/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/

package fr.cea.modane.sirius.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.ModelChangeTrigger;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.eclipse.xtext.EcoreUtil2;

import com.google.common.collect.Sets;

import fr.cea.modane.modane.Function;
import fr.cea.modane.modane.ModaneElement;
import fr.cea.modane.modane.ModanePackage;

/**
 * This class is strongly inspired by
 * https://github.com/eclipse/ecoretools/blob/master/org.eclipse.emf.ecoretools.design/src/org/eclipse/emf/ecoretools/design/service/LiveValidationTrigger.java
 *
 */
public class LiveValidationTrigger implements ModelChangeTrigger {

	public static final NotificationFilter IS_MODANE_CHANGE = new NotificationFilter.Custom() {

		public boolean matches(Notification notification) {
			return (!notification.isTouch() && notification.getFeature() instanceof EStructuralFeature
					&& ((EStructuralFeature) notification.getFeature()).getEContainingClass()
							.getEPackage() == ModanePackage.eINSTANCE);
		}
	};

	private TransactionalEditingDomain domain;

	/**
	 * We need to be triggered before the refresh mechanism takes place so that the
	 * diagnostic attachments are up-to date when computing colors.
	 */
	public static final int PRIORITY = 0;

	public LiveValidationTrigger(TransactionalEditingDomain domain) {
		this.domain = domain;
	}

	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) {
		final Set<EObject> changedModaneObjects = Sets.newLinkedHashSet();
		for (Notification notif : notifications) {
			Object obj = notif.getNotifier();
			if (obj instanceof EObject && ((EObject) obj).eClass() != null
					&& ((EObject) obj).eClass().getEPackage() == ModanePackage.eINSTANCE) {
				changedModaneObjects.add((EObject) obj);
			}
		}
		if (changedModaneObjects.size() > 0) {

			Command revalidateEObjects = new RecordingCommand(this.domain) {

				@Override
				protected void doExecute() {
					for (EObject eObj : changedModaneObjects) {
						revalidate(eObj);
						for (EObject parent : getParentsToValidate(eObj))
							revalidate(parent);
					}
				}

				protected void revalidate(EObject eObj) {
					try {
						Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObj);
						DiagnosticAttachment diag = DiagnosticAttachment.getAttachment(eObj);
						if (diag == null) {
							diag = DiagnosticAttachment.getOrCreate(eObj, diagnostic);
						}
						diag.setDiagnostic(diagnostic);
					} catch (Throwable e) {
						/*
						 * Anything which happens here might not be a concern.
						 */
					}
				}
			};
			return Options.newSome(revalidateEObjects);
		}
		return Options.newNone();
	}

	public int priority() {
		return PRIORITY;
	}

	private Collection<EObject> getParentsToValidate(EObject eObj)
	{
		ArrayList<EObject> parentsToValidate = new ArrayList<EObject>();
		parentsToValidate.add(EcoreUtil2.getContainerOfType(eObj, Function.class));
		parentsToValidate.add(EcoreUtil2.getContainerOfType(eObj, ModaneElement.class));
		return parentsToValidate;
	}

}

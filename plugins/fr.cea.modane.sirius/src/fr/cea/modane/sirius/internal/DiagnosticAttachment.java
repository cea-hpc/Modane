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

import java.util.Optional;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;

/**
 * This class has been copied and adapted (use Optional and Stream from java.util instead
 * of guava) from
 * https://github.com/eclipse/ecoretools/blob/master/org.eclipse.emf.ecoretools.design/src/org/eclipse/emf/ecoretools/design/service/DiagnosticAttachment.java
 *
 */
public class DiagnosticAttachment extends AdapterImpl {

	private Diagnostic diagnostic;

	public Diagnostic getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}

	public static DiagnosticAttachment getAttachment(EObject cur) {
		Optional<DiagnosticAttachment> found = cur.eAdapters().stream()
				.filter(DiagnosticAttachment.class::isInstance)
				.map(DiagnosticAttachment.class::cast)
				.findFirst();
		if (found.isPresent()) {
			return found.get();
		}
		return null;
	}

	public static DiagnosticAttachment getOrCreate(EObject cur, Diagnostic diag) {
		DiagnosticAttachment found = getAttachment(cur);
		if (found == null) {
			found = new DiagnosticAttachment();
			cur.eAdapters().add(found);
			found.setDiagnostic(diag);
		}
		return found;
	}

	public static Optional<Diagnostic> get(EObject cur) {
		DiagnosticAttachment found = getAttachment(cur);
		if (found != null) {
			return Optional.ofNullable(found.getDiagnostic());
		}
		return Optional.empty();
	}

}

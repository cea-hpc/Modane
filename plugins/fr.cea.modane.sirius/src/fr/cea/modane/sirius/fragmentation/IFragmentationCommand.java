/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.fragmentation;

import org.eclipse.emf.common.command.Command;

import fr.cea.modane.modane.ModaneModel;

public interface IFragmentationCommand extends Command 
{
	public ModaneModel getModel();
}

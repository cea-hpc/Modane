/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui.dialogs;

public class CreatePackageData {
	private String packageName;
	private boolean createModaneModel;
	
	public CreatePackageData(String packageName, boolean createModaneModel) {
		this.packageName = packageName;
		this.createModaneModel = createModaneModel;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public boolean isCreateModaneModel() {
		return createModaneModel;
	}
	
	public void setCreateModaneModel(boolean createModaneModel) {
		this.createModaneModel = createModaneModel;
	}
}

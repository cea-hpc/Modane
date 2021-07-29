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

import java.util.regex.Pattern;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.typed.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RenamePackageDialog extends TitleAreaDialog {
	private static final Pattern PACKAGE_VALID_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
	private Text txtName;
	
	private RenamePackageData data;
	private Button btnCheckButton;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public RenamePackageDialog(Shell parentShell, String oldPackageName) {
		super(parentShell);
		setShellStyle(SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
		initContents(oldPackageName);
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Rename Package");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Renames a package");
		setTitle("Rename Package");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		GridData gd_container = new GridData(GridData.FILL_BOTH);
		gd_container.heightHint = 66;
		container.setLayoutData(gd_container);
		container.setLayout(new GridLayout(2, false));
		
		Label lblPackageName = new Label(container, SWT.NONE);
		lblPackageName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPackageName.setText("Package name:");
		
		txtName = new Text(container, SWT.BORDER);
		txtName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				validateInput();
			}
		});
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblRenameSubPackages = new Label(container, SWT.NONE);
		lblRenameSubPackages.setText("Rename sub packages:");
		
		btnCheckButton = new Button(container, SWT.CHECK);
		
		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		initDataBindings();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(773, 288);
	}

	private void initContents(String oldPackageName) {
		data = new RenamePackageData(oldPackageName, true);
	}

	public RenamePackageData getData() {
		return data;
	}
	
	private void validateInput() {
		boolean isValidName = isValidPackageName(txtName.getText());
		boolean isEmptyName = (txtName.getText() == null) || (txtName.getText().isEmpty());
		
		boolean isDialogComplete = !isEmptyName && isValidName;
		getButton(IDialogConstants.OK_ID).setEnabled(isDialogComplete);
		
		if (isDialogComplete) {
			setErrorMessage(null);
		} else {
			if (isEmptyName) {
				setErrorMessage("The package name is required");
			} else if (!isValidName) {
				setErrorMessage("The package name should contain only alphanumeric characters");
			}
		}
	}

	private boolean isValidPackageName(String name) {
		return PACKAGE_VALID_NAME_PATTERN.matcher(name).matches();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtNameObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtName);
		IObservableValue packageNameDataObserveValue = PojoProperties.value("newPackageName").observe(data);
		bindingContext.bindValue(observeTextTxtNameObserveWidget, packageNameDataObserveValue, null, null);
		//
		IObservableValue observeSelectionBtnCheckButtonObserveWidget = WidgetProperties.buttonSelection().observe(btnCheckButton);
		IObservableValue createModaneModelDataObserveValue = PojoProperties.value("renameSubPackages").observe(data);
		bindingContext.bindValue(observeSelectionBtnCheckButtonObserveWidget, createModaneModelDataObserveValue, null, null);
		//
		return bindingContext;
	}
}

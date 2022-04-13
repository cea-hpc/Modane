/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.ui.dialogs;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GenerateTitleDialog extends TitleAreaDialog
{
	private static String AllPackages = "Tous";
	private GenerateTitleDialogOptions options;
	private List<String> packages;
	private Combo packagesCombo;
	private Text outputDirText;
	private Text packagePrefixText;
	private Button writeModaneFilesBtn;
	private Button writeCMakeFilesBtn;

	/**
	 * @wbp.parser.constructor
	 */
	public GenerateTitleDialog(Shell parentShell)
	{
		super(parentShell);
		setShellStyle(SWT.RESIZE);
		setHelpAvailable(false);
	}

	public GenerateTitleDialog(Shell parentShell, GenerateTitleDialogOptions options, List<String> packages)
	{
		this(parentShell);
		this.options = options;
		this.packages = packages;
		Collections.sort(this.packages);
	}

	@Override
	protected Control createDialogArea(Composite parent)
	{
		setTitleImage(null);
		setTitle("Options de génération");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		GridLayout gl_container = new GridLayout(1, true);
		gl_container.marginHeight = 10;
		gl_container.marginWidth = 10;
		gl_container.verticalSpacing = 3;
		gl_container.horizontalSpacing = 3;
		container.setLayout(gl_container);
		GridData gd_container = new GridData(GridData.FILL_BOTH);
		gd_container.heightHint = 318;
		container.setLayoutData(gd_container);

		Group packageToGenerateGrp = new Group(container, SWT.NONE);
		FillLayout fl_packageToGenerateGrp = new FillLayout(SWT.HORIZONTAL);
		fl_packageToGenerateGrp.marginWidth = 10;
		fl_packageToGenerateGrp.marginHeight = 10;
		packageToGenerateGrp.setLayout(fl_packageToGenerateGrp);
		GridData gd_packageToGenerateGrp = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_packageToGenerateGrp.widthHint = 449;
		gd_packageToGenerateGrp.heightHint = 50;
		packageToGenerateGrp.setLayoutData(gd_packageToGenerateGrp);
		packageToGenerateGrp.setText("Package à générer");

		packagesCombo = new Combo(packageToGenerateGrp, SWT.READ_ONLY);

		Group packagePrefixGrp = new Group(container, SWT.NONE);
		packagePrefixGrp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		packagePrefixGrp.setText("Pr\u00E9fixe de package (optionnel)");
		FillLayout fl_packagePrefixGrp = new FillLayout(SWT.HORIZONTAL);
		fl_packagePrefixGrp.marginWidth = 10;
		fl_packagePrefixGrp.marginHeight = 10;
		packagePrefixGrp.setLayout(fl_packagePrefixGrp);

		packagePrefixText = new Text(packagePrefixGrp, SWT.BORDER | SWT.WRAP | SWT.SEARCH);

		Group outputDirGrp = new Group(container, SWT.NONE);
		GridData gd_outputDirGrp = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_outputDirGrp.heightHint = 50;
		outputDirGrp.setLayoutData(gd_outputDirGrp);
		outputDirGrp.setText("R\u00E9pertoire de sortie (chemin absolu)");
		GridLayout gl_outputDirGrp = new GridLayout(2, false);
		gl_outputDirGrp.marginHeight = 10;
		gl_outputDirGrp.marginWidth = 10;
		outputDirGrp.setLayout(gl_outputDirGrp);

		outputDirText = new Text(outputDirGrp, SWT.BORDER | SWT.WRAP | SWT.SEARCH);
		outputDirText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button outputDirButton = new Button(outputDirGrp, SWT.NONE);
		outputDirButton.setText("...");
		outputDirButton.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent event)
			{
				DirectoryDialog dlg = new DirectoryDialog(getShell());
				dlg.setFilterPath(outputDirText.getText());
				dlg.setMessage("Sélection du répertoire de génération");
				String dir = dlg.open();
				if (dir != null) outputDirText.setText(dir);
			}
		});

		Group grpOptions = new Group(container, SWT.NONE);
		grpOptions.setLayout(new GridLayout(1, false));
		GridData gd_grpOptions = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_grpOptions.widthHint = 153;
		grpOptions.setLayoutData(gd_grpOptions);
		grpOptions.setText("Options");
		writeModaneFilesBtn = new Button(grpOptions, SWT.CHECK);
		writeModaneFilesBtn.setSize(221, 17);
		writeModaneFilesBtn.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
			}
		});
		writeModaneFilesBtn.setText("Ecriture des fichiers '.modane'");
		
		writeCMakeFilesBtn = new Button(grpOptions, SWT.CHECK);
		writeCMakeFilesBtn.setSize(221, 17);
		writeCMakeFilesBtn.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
			}
		});
		writeCMakeFilesBtn.setText("Ecriture des fichiers CMakeFiles");

		fillDialog();

		return area;
	}

	protected Point getInitialSize() { return new Point(538, 505); }

	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		createOkButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	protected Button createOkButton(Composite parent, int id, String label, boolean defaultButton)
	{
		((GridLayout) parent.getLayout()).numColumns++;
		Button okButton = new Button(parent, SWT.PUSH);
		okButton.setText(label);
		okButton.setFont(JFaceResources.getDialogFont());
		okButton.setData(id);
		okButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				if (checkGenDir())
				{
					updateOptions();
					okPressed();
				}
			}
		});
	
		if (defaultButton) 
		{
			Shell shell = parent.getShell();
			if (shell != null) shell.setDefaultButton(okButton);
		}
		setButtonLayoutData(okButton);
		return okButton;
	}

	/**
	 * Remplissage de la boite de dialogue avec les options sauvegardées
	 */
	private void fillDialog()
	{
		// Ajout des packages a la combo box  
		packagesCombo.add(AllPackages);
		for (String packageName : packages) packagesCombo.add(packageName);

		if (options != null)
		{
			// Recherche des options pour sélectionner le bon package
			int indexToSelect = packages.indexOf(options.getPackageToGenerate());
			indexToSelect++; // index de "tous"
			packagesCombo.select(indexToSelect);

			// Autres options
			if (options.hasOutputDir()) outputDirText.setText(options.getOutputDir());
			if (options.hasPackagePrefix()) packagePrefixText.setText(options.getPackagePrefix());
			writeModaneFilesBtn.setSelection(options.isWriteModaneFiles());
			writeCMakeFilesBtn.setSelection(options.isWriteCmakeFiles());
		}
	}

	/**
	 * Mise à jour des options avec les champs de la boite de dialogue
	 */
	private void updateOptions()
	{
		if (options != null)
		{
			options.setOutputDir(outputDirText.getText());
			options.setPackagePrefix(packagePrefixText.getText());
			options.setWriteModaneFiles(writeModaneFilesBtn.getSelection());
			options.setWriteCMakeFiles(writeCMakeFilesBtn.getSelection());

			String packageToGenerate = packagesCombo.getItem(packagesCombo.getSelectionIndex());
			if (packageToGenerate.equals(AllPackages)) packageToGenerate = "";
			options.setPackageToGenerate(packageToGenerate);
		}
	}

	/**
	 * Vérification de la validité du répertoire de sortie
	 * @return true si le répertoire de sortie existe
	 */
	private boolean checkGenDir()
	{
		String outputDir = outputDirText.getText();
		if (isNullOrEmpty(outputDir))
		{
			setErrorMessage("Répertoire de sortie non renseigné.");
			return false;
		}
		else
		{
			File file = new File(outputDir);
			if (!file.exists() || !file.isDirectory())
			{
				setErrorMessage("Répertoire de sortie non valide.");
				return false;
			}
		}
		
		return true;
	}

	private boolean isNullOrEmpty(String s) { return (s==null || s.isEmpty()); }
}

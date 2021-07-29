/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui.search;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPageSite;

import fr.cea.modane.cycles.DependencyInfo;
import fr.cea.modane.ui.ModaneUiUtils;

public class CyclesSearchResultPage extends DialogPage implements ISearchResultPage 
{
	private ModaneUiUtils uiUtils;
	private String ID;
	private IPageSite site;
	private CyclesSearchResult result;
	private Object uiState;
	private Composite composite;
	private TreeViewer searchResultTreeViewer;
	@SuppressWarnings("unused")
	private ISearchResultViewPart viewPart;
	
	public CyclesSearchResultPage() {}

	@Override
	public IPageSite getSite() { return site; }

	@Override
	public void init(IPageSite site) throws PartInitException { this.site = site; }

	@Override
	public void createControl(Composite parent) 
	{
		uiUtils = new ModaneUiUtils();
		
		composite = new Composite(parent, SWT.NONE);
		GridLayout gd_composite = new GridLayout(1,true);
		gd_composite.marginHeight = 0;
		gd_composite.marginWidth = 0;
		composite.setLayout(gd_composite);
		
		searchResultTreeViewer = new TreeViewer(composite, SWT.NONE);
		Tree searchResultTree = searchResultTreeViewer.getTree();
		searchResultTree.setLinesVisible(true);
		searchResultTree.setHeaderVisible(true);
		searchResultTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TreeViewerColumn sourceColumnViewer = new TreeViewerColumn(searchResultTreeViewer, SWT.NONE);
		TreeColumn sourceColumn = sourceColumnViewer.getColumn();
		sourceColumn.setWidth(450);
		sourceColumn.setText("Source de la r\u00E9f\u00E9rence");
		sourceColumnViewer.setLabelProvider(new CyclesSearchResultSourceLabelProvider());
		
		TreeViewerColumn targetColumnViewer = new TreeViewerColumn(searchResultTreeViewer, SWT.NONE);
		TreeColumn targetColumn = targetColumnViewer.getColumn();
		targetColumn.setWidth(300);
		targetColumn.setText("Cible de la r\u00E9f\u00E9rence");
		targetColumnViewer.setLabelProvider(new CyclesSearchResultTargetLabelProvider());

		searchResultTreeViewer.addDoubleClickListener(new DoubleClickListener());
		NewSearchUI.addQueryListener(new QueryListener());
	}

	@Override
	public Control getControl() { return composite; }

	@Override
	public void setActionBars(IActionBars actionBars) { } 

	@Override
	public void setFocus() { searchResultTreeViewer.getControl().setFocus(); }

	@Override
	public Object getUIState() { return uiState; }

	@Override
	public void setInput(ISearchResult search, Object uiState) 
	{
		if (search != null && search instanceof CyclesSearchResult) this.result = (CyclesSearchResult)search;
		this.uiState = uiState;
	}

	@Override
	public void setViewPart(ISearchResultViewPart part) { this.viewPart = part; }

	@Override
	public void restoreState(IMemento memento) { }
	
	@Override
	public void saveState(IMemento memento) { }

	@Override
	public void setID(String id) { this.ID = id; }
	
	@Override
	public String getID() {	return ID; }

	@Override
	public String getLabel() { return "Dépendances cycliques entre packages"; }

	private class QueryListener implements IQueryListener
	{
		@Override
		public void queryAdded(ISearchQuery query) { }

		@Override
		public void queryRemoved(ISearchQuery query) { }

		@Override
		public void queryStarting(ISearchQuery query) { }

		@Override
		public void queryFinished(ISearchQuery query) 
		{
			Display.getDefault().asyncExec(new Runnable() {
				public void run()
				{
					if (result != null && result.getCycles() != null)
					{
						searchResultTreeViewer.setContentProvider(new CyclesSearchResultContentProvider(result.getGraph()));
						searchResultTreeViewer.setInput(result.getCycles());
					}
				}
			});
		}
	}
	
	private class DoubleClickListener implements IDoubleClickListener
	{
		@Override
		public void doubleClick(DoubleClickEvent event) 
		{
			ISelection s = event.getSelection();
			if (s != null && s instanceof TreeSelection)
			{
				Object selection = ((TreeSelection)s).getFirstElement();
				if (selection != null && selection instanceof DependencyInfo)
					uiUtils.openXtextEditor(((DependencyInfo)selection).getSourceElement());
			}
		}
	}
}

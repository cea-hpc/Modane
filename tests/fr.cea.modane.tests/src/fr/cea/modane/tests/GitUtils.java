/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.tests;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.DiffCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffEntry.ChangeType;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.junit.Assert;

class GitUtils
{
	public Git git;

	public GitUtils(String repoPath)
	{
		try {
			git = Git.open(new File(repoPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Repository getRepository()
	{
		return git.getRepository();
	}

	private List<DiffEntry> getModifiedFiles(String path)
	{
		DiffCommand diffCommand = git.diff();
		if (!path.isEmpty())
			diffCommand .setPathFilter(PathFilter.create(path));
		List<DiffEntry> diffs = new ArrayList<DiffEntry>();
		try {
			diffs = diffCommand.call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<DiffEntry> modifies = new ArrayList<DiffEntry>();
		for (DiffEntry diff : diffs)
			if (diff.getChangeType() == ChangeType.MODIFY)
				modifies.add(diff);
		return modifies;
	}

	@SuppressWarnings("unused")
	private void printDiffFor(String relativeFilePath) 
	{
		ObjectId head = null;
		try {
			head = git.getRepository().resolve("HEAD");
		} catch (RevisionSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (head == null) return;

		ByteArrayOutputStream diffOutputStream = new ByteArrayOutputStream();
		DiffFormatter formatter = new DiffFormatter(diffOutputStream);
		formatter.setRepository(git.getRepository());
		formatter.setPathFilter(PathFilter.create(relativeFilePath.replaceAll("\\\\","/")));

		CanonicalTreeParser commitTreeIterator = null;
		try {
			commitTreeIterator = prepareTreeParser(git.getRepository(), head.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileTreeIterator workTreeIterator = new FileTreeIterator(git.getRepository());

		// Scan gets difference between the two iterators.
		try {
			formatter.format(commitTreeIterator, workTreeIterator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(diffOutputStream.toString());
		formatter.close();
	}

	private CanonicalTreeParser prepareTreeParser(Repository repository, String objectId) throws MissingObjectException, IncorrectObjectTypeException, IOException
	{
		// from the commit we can build the tree which allows us to construct the TreeParser
		try (RevWalk walk = new RevWalk(repository))
		{
			RevCommit commit = walk.parseCommit(ObjectId.fromString(objectId));
			RevTree tree = walk.parseTree(commit.getTree().getId());

			CanonicalTreeParser oldTreeParser = new CanonicalTreeParser();
			try (ObjectReader oldReader = repository.newObjectReader())
			{
				oldTreeParser.reset(oldReader, tree.getId());
			}

			walk.dispose();
			return oldTreeParser;
		}
	}

	public void testNoGitDiff(String subPath)
	{
		List<DiffEntry> diffs = getModifiedFiles(subPath);
		for (DiffEntry diff : diffs)
		{
			System.out.println(diff.getChangeType() + " " + diff.getNewPath());
			//printDiffFor(diff.newPath)
		}
		Assert.assertTrue(diffs.isEmpty());
	}
}

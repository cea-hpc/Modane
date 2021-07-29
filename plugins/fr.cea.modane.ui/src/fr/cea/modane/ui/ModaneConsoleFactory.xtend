/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.ui

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.swt.graphics.Color
import org.eclipse.swt.widgets.Display
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsoleFactory
import org.eclipse.ui.console.MessageConsole
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher

@Singleton
class ModaneConsoleFactory implements IConsoleFactory
{
	public static val ConsoleName = "Modane Console"
	static val BLUE = new Color(null, 70, 30, 180)
	static val BLACK = new Color(null, 0, 0, 0)
	static val ORANGE = new Color(null, 255, 140, 0)
	static val RED = new Color(null, 139, 0, 0)

	@Inject ModaneGeneratorMessageDispatcher dispatcher
	MessageConsole console

	override openConsole() 
	{
		val consoleMng = ConsolePlugin.^default.consoleManager
		console = consoleMng.consoles.filter(MessageConsole).findFirst[x | x.name == ConsoleName]
		if (console === null)
		{
			val id = ModaneUiUtils::getImageDescriptor("icons/modane.gif")
			val image = if (id.present) id.get else null
			console = new MessageConsole(ConsoleName, image)
			consoleMng.addConsoles(#[console])
			dispatcher.traceListeners += [type, msg | printConsole(type, msg)]
		}
	}

	def void clearAndActivateConsole()
	{
		if (console !== null)
		{
			console.clearConsole
			console.activate
		}
	}

	def void printConsole(MessageType type, String msg)
	{
		if (console !== null)
		{
			val display = Display.^default
			display.syncExec
			([
				val stream = console.newMessageStream
				stream.color = switch type
				{
					case MessageType.Exec: BLUE
					case MessageType.Warning: ORANGE
					case MessageType.Error: RED
					default: BLACK
				}
				stream.println(msg)
			])
		}
	}
}

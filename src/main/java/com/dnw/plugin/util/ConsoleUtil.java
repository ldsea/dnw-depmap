/**
 * !(#) ConsoleUtil.java
 * Copyright (c) 2013 DNW Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     DNW Technologies - initial API and implementation
 *
 * Create by manbaum since Jan 31, 2013.
 */
package com.dnw.plugin.util;

import java.text.MessageFormat;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

/**
 * Class/Interface ConsoleUtil.
 * 
 * @author manbaum
 * @since Jan 31, 2013
 */
public class ConsoleUtil {

	/**
	 * Method createConsole.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param consoleManager
	 * @param name
	 * @return
	 */
	public static MessageConsole createConsole(IConsoleManager consoleManager,
			String name) {
		MessageConsole console = new MessageConsole(name, null, true);
		consoleManager.addConsoles(new IConsole[] { console });
		return console;
	}

	/**
	 * Method findConsole.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param consoleManager
	 * @param name
	 * @return
	 */
	public static MessageConsole findConsole(IConsoleManager consoleManager,
			String name) {
		for (IConsole c : consoleManager.getConsoles()) {
			if (c.getName().equals(name))
				return (MessageConsole) c;
		}
		return null;
	}

	/**
	 * Method createConsole.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param name
	 * @return
	 */
	public static MessageConsole createConsole(String name) {
		return createConsole(ConsolePlugin.getDefault().getConsoleManager(),
				name);
	}

	/**
	 * Method findConsole.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param name
	 * @return
	 */
	public static MessageConsole findConsole(String name) {
		return findConsole(ConsolePlugin.getDefault().getConsoleManager(), name);
	}

	/**
	 * Method getConsole.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param name
	 * @return
	 */
	public static MessageConsole getConsole(String name) {
		IConsoleManager consoleManager = ConsolePlugin.getDefault()
				.getConsoleManager();
		MessageConsole c = findConsole(consoleManager, name);
		if (c == null) {
			c = createConsole(consoleManager, name);
		}
		consoleManager.showConsoleView(c);
		return c;
	}

	/**
	 * Method messageOfThrowable.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param e
	 * @return
	 */
	public static String messageOfThrowable(Throwable e) {
		StringBuffer sb = new StringBuffer();
		sb.append(e.getClass().getName());
		sb.append(": ");
		sb.append(e.getMessage());
		for (StackTraceElement s : e.getStackTrace()) {
			sb.append("\n    ");
			sb.append(s.getClassName());
			sb.append(".");
			sb.append(s.getMethodName());
			sb.append("() (line ");
			sb.append(s.getLineNumber());
			sb.append(")");
		}
		return sb.toString();
	}

	/**
	 * Method print.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param console
	 * @param message
	 */
	public static void print(MessageConsole console, String message) {
		if (console != null) {
			console.newMessageStream().print(message);
		}
	}

	/**
	 * Method println.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param console
	 * @param message
	 */
	public static void println(MessageConsole console, String message) {
		if (console != null) {
			console.newMessageStream().println(message);
		}
	}

	/**
	 * Method print.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param console
	 * @param e
	 */
	public static void print(MessageConsole console, Throwable e) {
		if (console != null) {
			console.newMessageStream().print(messageOfThrowable(e));
		}
	}

	/**
	 * Method println.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param console
	 * @param e
	 */
	public static void println(MessageConsole console, Throwable e) {
		if (console != null) {
			console.newMessageStream().println(messageOfThrowable(e));
		}
	}

	/**
	 * Method format.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param console
	 * @param pattern
	 * @param arguments
	 */
	public static void format(MessageConsole console, String pattern,
			Object... arguments) {
		if (console != null) {
			console.newMessageStream().print(
					MessageFormat.format(pattern, arguments));
		}
	}

	/**
	 * Method formatln.
	 * 
	 * @author manbaum
	 * @since Jan 31, 2013
	 * 
	 * @param console
	 * @param pattern
	 * @param arguments
	 */
	public static void formatln(MessageConsole console, String pattern,
			Object... arguments) {
		if (console != null) {
			console.newMessageStream().println(
					MessageFormat.format(pattern, arguments));
		}
	}
}

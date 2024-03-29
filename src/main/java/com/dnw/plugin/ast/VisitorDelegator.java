/**
 * !(#) VisitorDelegator.java
 * Copyright (c) 2014 DNW Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     DNW Technologies - initial API and implementation
 *
 * Create by manbaum since Sep 29, 2014.
 */
package com.dnw.plugin.ast;

import org.eclipse.jdt.core.dom.ASTNode;

/**
 * Class/Interface VisitorDelegator.
 * 
 * @author manbaum
 * @since Sep 29, 2014
 */
public interface VisitorDelegator {

	/**
	 * Method preVisit.
	 * 
	 * @author manbaum
	 * @since Sep 29, 2014
	 * 
	 * @param node
	 * @return
	 */
	boolean preVisit(ASTNode node);

	/**
	 * Method postVisit.
	 * 
	 * @author manbaum
	 * @since Sep 29, 2014
	 * 
	 * @param node
	 */
	void postVisit(ASTNode node);

	/**
	 * Method visit.
	 * 
	 * @author manbaum
	 * @since Sep 29, 2014
	 * 
	 * @param type
	 * @param node
	 * @return
	 */
	<T extends ASTNode> boolean visit(Class<T> type, T node);

	/**
	 * Method endVisit.
	 * 
	 * @author manbaum
	 * @since Sep 29, 2014
	 * 
	 * @param type
	 * @param node
	 */
	<T extends ASTNode> void endVisit(Class<T> type, T node);
}

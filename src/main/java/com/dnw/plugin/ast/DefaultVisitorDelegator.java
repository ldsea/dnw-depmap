/**
 * !(#) DefaultVisitorDelegator.java
 * Copyright (c) 2014 DNW Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     DNW Technologies - initial API and implementation
 *
 * Create by manbaum since Sep 30, 2014.
 */
package com.dnw.plugin.ast;

import org.eclipse.jdt.core.dom.ASTNode;

/**
 * Class/Interface DefaultVisitorDelegator.
 * 
 * @author manbaum
 * @since Sep 30, 2014
 */
public final class DefaultVisitorDelegator implements VisitorDelegator {

	private final NodeTypeSet stopSet;
	private final VisitorRegistry registry;

	/**
	 * Constructor of DefaultVisitorDelegator.
	 * 
	 * @author manbaum
	 * @since Sep 30, 2014
	 * 
	 * @param stopSet
	 * @param registry
	 */
	public DefaultVisitorDelegator(NodeTypeSet stopSet, VisitorRegistry registry) {
		this.stopSet = stopSet;
		this.registry = registry;
	}

	/**
	 * Overrider method preVisit.
	 * 
	 * @author manbaum
	 * @since Sep 30, 2014
	 * 
	 * @param node
	 * @return
	 * 
	 * @see com.dnw.plugin.ast.VisitorDelegator#preVisit(org.eclipse.jdt.core.dom.ASTNode)
	 */
	public boolean preVisit(ASTNode node) {
		return !stopSet.contains(node.getNodeType());
	}

	/**
	 * Overrider method postVisit.
	 * 
	 * @author manbaum
	 * @since Sep 30, 2014
	 * 
	 * @param node
	 * 
	 * @see com.dnw.plugin.ast.VisitorDelegator#postVisit(org.eclipse.jdt.core.dom.ASTNode)
	 */
	public void postVisit(ASTNode node) {
	}

	/**
	 * Overrider method visit.
	 * 
	 * @author manbaum
	 * @since Sep 30, 2014
	 * 
	 * @param type
	 * @param node
	 * @return
	 * 
	 * @see com.dnw.plugin.ast.VisitorDelegator#visit(java.lang.Class,
	 *      org.eclipse.jdt.core.dom.ASTNode)
	 */
	public <T extends ASTNode> boolean visit(Class<T> type, T node) {
		Visitor<T> visitor = registry.lookup(type);
		visitor.visit(node);
		return true;
	}

	/**
	 * Overrider method endVisit.
	 * 
	 * @author manbaum
	 * @since Sep 30, 2014
	 * 
	 * @param type
	 * @param node
	 * 
	 * @see com.dnw.plugin.ast.VisitorDelegator#endVisit(java.lang.Class,
	 *      org.eclipse.jdt.core.dom.ASTNode)
	 */
	public <T extends ASTNode> void endVisit(Class<T> type, T node) {
	}
}

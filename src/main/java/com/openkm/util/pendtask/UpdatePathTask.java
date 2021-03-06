/**
 * OpenKM, Open Document Management System (http://www.openkm.com)
 * Copyright (c) 2006-2015 Paco Avila & Josep Llort
 * 
 * No bytes were intentionally harmed during the development of this application.
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.openkm.util.pendtask;

import java.util.List;

import org.hibernate.Session;

import com.openkm.core.DatabaseException;
import com.openkm.dao.bean.NodeBase;

public class UpdatePathTask implements ProcessInDepthTask {

	@Override
	public void securityPruneNodeList(List<? extends NodeBase> nodeList) throws DatabaseException {
		// None
	}

	@Override
	public Object doTask(Session session, NodeBase parentNode, NodeBase node) throws DatabaseException {
		node.setPath(parentNode.getPath() + "/" + node.getName());
		session.update(node);
		
		return null;
	}
}

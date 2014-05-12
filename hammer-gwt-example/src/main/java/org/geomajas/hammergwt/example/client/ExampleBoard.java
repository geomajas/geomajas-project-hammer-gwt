/*
 * This is part of Geomajas, a GIS framework, http://www.geomajas.org/.
 *
 * Copyright 2008-2014 Geosparc nv, http://www.geosparc.com/, Belgium.
 *
 * The program is available in open source according to the Apache
 * License, Version 2.0. All contributions in this program are covered
 * by the Geomajas Contributors License Agreement. For full licensing
 * details, see LICENSE.txt in the project root.
 */
package org.geomajas.hammergwt.example.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;
import org.geomajas.hammergwt.client.impl.HammerWidget;


/**
 * @author Dosi Bingov
 */
public class ExampleBoard extends HammerWidget {
	private AbsolutePanel panel;

	public ExampleBoard() {
		panel = new AbsolutePanel();
		panel.setWidth("100%");
		panel.setHeight("150px");
		panel.getElement().getStyle().setBackgroundColor("pink");
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}

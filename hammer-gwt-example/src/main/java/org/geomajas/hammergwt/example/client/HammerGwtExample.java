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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import org.geomajas.hammergwt.client.HammerGWT;

/**
 * Hammer GWT example entry point.
 *
 * @author Dosi Bingov
 */
public class HammerGwtExample implements EntryPoint {
	private TabLayoutPanel tabPanel;

	@Override
	public void onModuleLoad() {
		HammerGWT.USE_JS_SOURCE = true;

		// Create a tab panel
		tabPanel = new TabLayoutPanel(2.5, Style.Unit.EM);
		tabPanel.setAnimationDuration(1000);
		tabPanel.getElement().getStyle().setMarginBottom(10.0, Style.Unit.PX);

		// Add event logger sample
		addTab(new EventLoggerSample());

		// Add a tab gwt panels
		addTab(new PanelsSample());

		tabPanel.selectTab(0);

		RootLayoutPanel.get().add(tabPanel);
	}

	public void addTab(TabSample sample) {
		tabPanel.add(sample, sample.getTitle());
	}

}

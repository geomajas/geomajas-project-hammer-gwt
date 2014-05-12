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
package org.geomajas.hammergwt.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.IsWidget;
import org.geomajas.hammergwt.client.handler.HammerDragHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchHandler;
import org.geomajas.hammergwt.client.handler.HammerTapHandler;


/**
 * Hammer GWT widget. If the widget is extended should be possible to add hammer handlers to it.
 *
 * @author Dosi Bingov
 *
 * @version 1.0
 */

public abstract class HammerWidget implements IsWidget {
	private JavaScriptObject hammertime;

	public HammerWidget() {
	}

	public void addPinchHandler(HammerPinchHandler handler) {
		HammerGWT.onPinch(getHammerInstance(), handler);
	}

	public void addTapHandler(HammerTapHandler handler) {
		HammerGWT.onTap(getHammerInstance(), handler);
	}

	public void addDragHandler(HammerDragHandler handler) {
		HammerGWT.onDrag(getHammerInstance(), handler);
	}

	private JavaScriptObject getHammerInstance() {
		if (hammertime == null) {
			com.google.gwt.user.client.Element el = asWidget().getElement();
			hammertime = HammerGWT.getInstance(el);
		}

		return hammertime;
	}


}

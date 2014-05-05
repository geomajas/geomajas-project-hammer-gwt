package org.geomajas.hammergwt.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.IsWidget;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.event.NativeHammerEvent;
import org.geomajas.hammergwt.client.handler.HammerDragEndHandler;
import org.geomajas.hammergwt.client.handler.HammerDragHandler;
import org.geomajas.hammergwt.client.handler.HammerDragStartHandler;
import org.geomajas.hammergwt.client.handler.HammerHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchInHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchOutHandler;
import org.geomajas.hammergwt.client.handler.HammerTapHandler;


/**
 * @author Dosi Bingov
 *
 * @version 1.0
 */
public class Hammerable {
	private JavaScriptObject hammertime;
	private IsWidget widget;

	public Hammerable(IsWidget widget) {
		this.widget = widget;
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

	public void addDragStartHandler(HammerDragStartHandler handler) {
		HammerGWT.onDragStart(getHammerInstance(), handler);
	}

	public void addDragEndHandler(HammerDragEndHandler handler) {
		HammerGWT.onDragEnd(getHammerInstance(), handler);
	}

	public void addPinchInHandler(HammerPinchInHandler handler) {
		HammerGWT.onPinchIn(getHammerInstance(), handler);
	}

	public void addPinchOutHandler(HammerPinchOutHandler handler) {
		HammerGWT.onPinchOut(getHammerInstance(), handler);
	}

	private JavaScriptObject getHammerInstance() {
		if (hammertime == null) {
			com.google.gwt.user.client.Element el = widget.asWidget().getElement();
			hammertime = HammerGWT.getInstance(el);
		}

		return hammertime;
	}

}

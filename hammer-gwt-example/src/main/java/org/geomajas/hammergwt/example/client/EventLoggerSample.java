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

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import org.geomajas.hammergwt.client.HammerGwt;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.event.NativeHammerEvent;
import org.geomajas.hammergwt.client.handler.HammerHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hammer Gwt event logger sample.
 *
 * @author Dosi Bingov
 */
public class EventLoggerSample implements TabSample {
	private Logger remoteLogger = Logger.getLogger("");
	private Widget layout;

	@UiField
	protected Label logArea;

	@UiField
	protected SimplePanel eventsPanel;

	/**
	 * UI binder for this sample.
	 *
	 * @author Dosi Bingov
	 */
	interface MyUiBinder extends UiBinder<Widget, EventLoggerSample> {
	}

	private static final MyUiBinder UI_BINDER = GWT.create(MyUiBinder.class);

	public EventLoggerSample() {
		layout = UI_BINDER.createAndBindUi(this);
		eventsPanel.getElement().setId("eventsPanel");
		layout.getElement().setId("eventsLoggerTab");
		// add hammer gwt events
		HammerGwt.on(HammerGwt.create(eventsPanel), new HammerHandler() {
					@Override
					public void onHammerEvent(NativeHammerEvent event) {
						log(event);
					}
				}, EventType.DOUBLETAP, EventType.PINCH, EventType.TAP, EventType.TRANSFORM, EventType.DRAG,
				EventType.HOLD, EventType.DRAGLEFT, EventType.DRAGRIGHT, EventType.DRAGDOWN, EventType.DRAGUP,
				EventType.DRAGEND, EventType.SWIPE, EventType.RELEASE, EventType.PINCHIN, EventType.PINCHOUT
		);

	}

	@Override
	public String getTitle() {
		return "Event logger";
	}

	@Override
	public Widget asWidget() {
		return layout;
	}

	private void log(NativeHammerEvent event) {
		String s = "Target tag name = " + event.getTarget().getNodeName() + ", Target id = " +
				event.getTarget().getId()  +
				", Touches = " + event.getTouches() + ", EventType = " + event.getType() +
				", PageX = " + event.getPageX() + ", PageY = " + event.getPageY() +
				", Direction = " + event.getDirection().getText() +
				", Interim direction = " + event.getInterimDirection().getText() +
				", RelativeX = " + event.getRelativeX() + ", RelativeY = " + event.getRelativeY() +
				", PointerType = " + event.getPointerType() +  ", Scale = " + event.getScale() +
				", VelocityX = " + event.getVelocityX() + ", VelocityY = " + event.getVelocityY() +
				", DeltaX = " + event.getDeltaX() + ", DeltaY = " + event.getDeltaY() +
				", Rotation = " + event.getRotation() + ",  Angle = " + event.getAngle();

		logArea.setText(s);
		remoteLogger.log(Level.SEVERE, s);
	}

}

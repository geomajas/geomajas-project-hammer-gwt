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
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.event.NativeHammerEvent;
import org.geomajas.hammergwt.client.handler.HammerDragHandler;
import org.geomajas.hammergwt.client.handler.HammerGWTCallback;
import org.geomajas.hammergwt.client.handler.HammerHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchHandler;
import org.geomajas.hammergwt.client.handler.HammerTapHandler;
import org.geomajas.hammergwt.client.impl.HammerTime;
import org.geomajas.hammergwt.client.impl.HammerGWT;
import org.geomajas.hammergwt.client.impl.HammerWidget;
import org.geomajas.hammergwt.client.impl.option.GestureOptions;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hammer GWT example entry point.
 *
 * @author Dosi Bingov
 */
public class HammerGWTExample implements EntryPoint {
	private Label logLabel = new Label();
	private Logger remoteLogger = Logger.getLogger("");

	@Override
	public void onModuleLoad() {
		logLabel.getElement().getStyle().setMarginTop(50, Style.Unit.PX);

		AbsolutePanel panel = new AbsolutePanel();

		SimplePanel panel2 = new SimplePanel();

		SimplePanel panel3 = new SimplePanel();
		//panel.getElement().getStyle().setTop(100, Style.Unit.PX);

		panel.setSize("100px", "200px");
		panel.getElement().setId("pinkPanel");
		panel.getElement().getStyle().setBackgroundColor("pink");
		panel.getElement().getStyle().setLeft(20, Style.Unit.PX);
		panel.getElement().getStyle().setTop(50, Style.Unit.PX);

		panel2.getElement().setId("orangePanel");
		panel2.getElement().getStyle().setBackgroundColor("orange");
		panel2.getElement().getStyle().setLeft(180, Style.Unit.PX);
		panel2.getElement().getStyle().setTop(50, Style.Unit.PX);
		panel2.setSize("100px", "200px");

		panel3.getElement().setId("notDraggable");
		panel3.getElement().getStyle().setBackgroundColor("black");
		panel3.getElement().getStyle().setLeft(180, Style.Unit.PX);
		panel3.getElement().getStyle().setTop(50, Style.Unit.PX);
		panel3.setSize("100px", "200px");

		//Hammer GWT widget example
		HammerGWTExampleWidget hammerGWTWidget = new HammerGWTExampleWidget();

		HammerableHandler hammerableHandler = new HammerableHandler();

		hammerGWTWidget.registerDragHandler(hammerableHandler);
		hammerGWTWidget.registerPinchHandler(hammerableHandler);


		hammerGWTWidget.registerTapHandler(new HammerTapHandler() {
			@Override
			public void onTap(NativeHammerEvent event) {
				log(event);
			}
		});

		hammerGWTWidget.unregisterEvent(EventType.TAP);


		//hammerGWTWidget.unregisterEvent(EventType.DRAG);

		//hammerGWTWidget.registerDragHandler(hammerableHandler);

		hammerGWTWidget.unregisterEvent(EventType.TAP);

		RootPanel.get().add(panel);
		RootPanel.get().add(panel2);
		RootPanel.get().add(panel3);
		RootPanel.get().add(hammerGWTWidget);
		RootPanel.get().add(logLabel);

		// add hammer gwt events
		HammerGWT.on(HammerGWT.createInstance(panel), new HammerHandler() {
			@Override
			public void onHammerEvent(NativeHammerEvent event) {
				log(event);
				event.preventDefault();
				event.preventNativeDefault();

				Element target = event.getTarget();

				switch (event.getType()) {
					case TAP:
						//return to start position
						target.getStyle().setLeft(20, Style.Unit.PX);
						break;
					case DRAG:
					default:
						//move 20px to the right
						int left = target.getAbsoluteLeft() + 20;
						target.getStyle().setLeft(left, Style.Unit.PX);
						break;

				}
			}
		}, EventType.TAP, EventType.DRAG);

		// add hammer gwt events
		HammerGWT.on(HammerGWT.createInstance(panel2), new HammerHandler() {
			@Override
			public void onHammerEvent(NativeHammerEvent event) {
				log(event);
			}
		}, EventType.DOUBLETAP, EventType.PINCH);

		HammerTime hammerTime3 = HammerGWT.createInstance(panel3.getElement());


		// Set hammer gwt options
		hammerTime3.setOption(GestureOptions.HOLD_TIMEOUT, 2);
		hammerTime3.setOption(GestureOptions.DRAG, false);

		// add hammer gwt events
		HammerGWTCallback sb3 = HammerGWT.on(HammerGWT.createInstance(panel3), new HammerHandler() {

			@Override
			public void onHammerEvent(NativeHammerEvent event) {
				log(event);
			}
		}, EventType.DOUBLETAP, EventType.PINCH, EventType.DRAG);


		//HammerGWT.off(hammerTime3, EventType.DRAG, sb3);


	}

	private void log(NativeHammerEvent event) {
		String s = "target tag name = " + event.getTarget().getNodeName() + ", scale = " + event.getScale() +
				", touches = " + event.getTouches() + ", EventType = " + event.getType() +
				", pageX = " + event.getPageX() + ", pageY = " + event.getPageY() +
				", direction = " + event.getDirection().getText() +
				", interim direction = " + event.getInterimDirection().getText() +
				", relativeX = " + event.getRelativeX() + ", relativeY = " + event.getRelativeY() +
				", PointerType = " + event.getPointerType() + ", Target id = " + event.getTarget().getId();
		remoteLogger.log(Level.SEVERE, s);
		logLabel.setText(s);
	}

	/**
	 * Hammer gwt events handler.
	 *
	 * @author Dosi Bingov
	 *
	 */
	class HammerableHandler implements HammerDragHandler, HammerPinchHandler {

		@Override
		public void onDrag(NativeHammerEvent event) {
			log(event);
		}

		@Override
		public void onPinch(NativeHammerEvent event) {
			log(event);
		}

	}

	/**
	 * Hammer gwt widget inner class.
	 *
	 * @author Dosi Bingov
	 */
	class HammerGWTExampleWidget extends HammerWidget {

		public HammerGWTExampleWidget() {
			super();
		}

		@Override
		public Widget createWidget() {
			SimplePanel panel = new SimplePanel();
			panel.setSize("100px", "200px");
			panel.getElement().setId("hammerWidget");
			panel.getElement().getStyle().setBackgroundColor("green");
			panel.getElement().getStyle().setRight(0, Style.Unit.PX);
			panel.getElement().getStyle().setTop(0, Style.Unit.PX);

			return panel;
		}
	}
}

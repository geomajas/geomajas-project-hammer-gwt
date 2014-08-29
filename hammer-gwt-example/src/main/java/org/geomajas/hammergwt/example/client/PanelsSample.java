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

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import org.geomajas.hammergwt.client.HammerGwt;
import org.geomajas.hammergwt.client.HammerTime;
import org.geomajas.hammergwt.client.HammerWidget;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.event.NativeHammerEvent;
import org.geomajas.hammergwt.client.handler.NativeHammmerHandler;
import org.geomajas.hammergwt.client.handler.HammerHandler;
import org.geomajas.hammergwt.client.handler.HammerSwipeHandler;
import org.geomajas.hammergwt.client.option.GestureOptions;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hammer Gwt panels sample.
 *
 * @author Dosi Bingov
 */
public class PanelsSample implements TabSample {
	private Logger remoteLogger = Logger.getLogger("");
	private FlowPanel layout;

	public PanelsSample() {
		layout = new FlowPanel();
		final AbsolutePanel pinkPanel = new AbsolutePanel();
		pinkPanel.setSize("100px", "200px");
		pinkPanel.getElement().setId("pinkPanel");
		pinkPanel.getElement().getStyle().setBackgroundColor("pink");
		pinkPanel.getElement().getStyle().setLeft(0, Style.Unit.PX);
		pinkPanel.getElement().getStyle().setTop(0, Style.Unit.PX);

		final Label pinkPanelLabel = new Label("Drag");
		pinkPanelLabel.getElement().getStyle().setPadding(5, Style.Unit.PX);
		pinkPanel.add(pinkPanelLabel);

		final AbsolutePanel orangePanel = new AbsolutePanel();
		AbsolutePanel blackPanel = new AbsolutePanel();
		//panel.getElement().getStyle().setTop(100, Style.Unit.PX);

		orangePanel.getElement().setId("orangePanel");
		orangePanel.getElement().getStyle().setPosition(Style.Position.ABSOLUTE);
		orangePanel.getElement().getStyle().setBackgroundColor("orange");
		orangePanel.getElement().getStyle().setLeft(105, Style.Unit.PX);
		orangePanel.getElement().getStyle().setTop(0, Style.Unit.PX);
		orangePanel.setSize("100px", "200px");
		orangePanel.add(new Label("Pinch"));

		blackPanel.getElement().setId("notDraggable");
		blackPanel.getElement().getStyle().setPosition(Style.Position.ABSOLUTE);
		blackPanel.getElement().getStyle().setBackgroundColor("black");
		blackPanel.getElement().getStyle().setLeft(210, Style.Unit.PX);
		blackPanel.getElement().getStyle().setTop(0, Style.Unit.PX);
		blackPanel.setSize("100px", "200px");

		final Label blackPanelLabel = new Label("Hold");
		blackPanelLabel.getElement().getStyle().setPadding(5, Style.Unit.PX);
		blackPanelLabel.getElement().getStyle().setColor("white");
		blackPanel.add(blackPanelLabel);

		//Hammer GWT widget example
		final HammerGWTExampleWidget hammerGWTWidget = new HammerGWTExampleWidget();


		layout.add(orangePanel);
		layout.add(blackPanel);
		layout.add(hammerGWTWidget);
		layout.add(pinkPanel);

		// add hammer gwt events
		HammerGwt.on(HammerGwt.create(pinkPanel), new HammerHandler() {
			@Override
			public void onHammerEvent(NativeHammerEvent event) {
				log(event);
				event.preventDefault();
				event.preventNativeDefault();

				switch (event.getType()) {
					case TAP:
						//return to start position
						pinkPanel.getElement().getStyle().setLeft(0, Style.Unit.PX);
						pinkPanel.getElement().getStyle().setTop(0, Style.Unit.PX);
						pinkPanelLabel.setText("Drag");

						break;
					case DRAG:
					default:
						pinkPanelLabel.setText("Tap to move to start position");
						int left = event.getPageX() - 50;
						int top = event.getPageY() - 100;
						pinkPanel.getElement().getStyle().setLeft(left, Style.Unit.PX);
						pinkPanel.getElement().getStyle().setTop(top, Style.Unit.PX);

						break;

				}
			}
		}, EventType.TAP, EventType.DRAG);

		// add hammer gwt events
		HammerGwt.on(HammerGwt.create(orangePanel), new HammerHandler() {
			@Override
			public void onHammerEvent(NativeHammerEvent event) {
				log(event);
				switch (event.getType()) {
					case DRAG:
						int left = event.getPageX() - 50;
						int top = event.getPageY() - 100;
						orangePanel.getElement().getStyle().setLeft(left, Style.Unit.PX);
						orangePanel.getElement().getStyle().setTop(top, Style.Unit.PX);

						break;
					case PINCH:
					default:
						double w = (event.getScale() * orangePanel.getElement().getClientWidth());

						double h = (event.getScale() * orangePanel.getElement().getClientHeight());

						orangePanel.setPixelSize((int) w, (int) h);

						break;

				}
			}
		}, EventType.DRAG, EventType.PINCH);

		HammerTime hammerTime3 = HammerGwt.create(blackPanel.getElement());

		// Set hammer gwt options
		hammerTime3.setOption(GestureOptions.HOLD_TIMEOUT, 2);
		hammerTime3.setOption(GestureOptions.DRAG, false);

		// add hammer gwt events
		NativeHammmerHandler sb3 = HammerGwt.on(HammerGwt.create(blackPanel), new HammerHandler() {

			@Override
			public void onHammerEvent(NativeHammerEvent event) {
				log(event);
				Timer timer = new Timer() {
					public void run() {
						// Timer expired
						blackPanelLabel.setText("Hold");
					}
				};

				switch (event.getType()) {

					case HOLD:
						blackPanelLabel.setText("Holding...");
						timer.cancel();

						break;
					case RELEASE:
						blackPanelLabel.setText("Released");

						// Execute the timer to expire 1 second in the future
						timer.schedule(1000);

						break;

				}


			}
		}, EventType.HOLD, EventType.RELEASE);


		//HammerGWT.off(hammerTime3, EventType.DRAG, sb3);

	}

	@Override
	public String getTitle() {
		return "Gwt panels";
	}

	@Override
	public Widget asWidget() {
		return layout;
	}


	/**
	 * Hammer gwt widget inner class.
	 *
	 * @author Dosi Bingov
	 */
	class HammerGWTExampleWidget extends HammerWidget {
		private AbsolutePanel panel;

		private HammerSwipeHandler swipeHandler = new HammerSwipeHandler() {
			@Override
			public void onSwipe(NativeHammerEvent event) {
				log(event);

				switch (event.getDirection()) {

					case UP:
					case DOWN:
						asWidget().getElement().getStyle().setTop(event.getRelativeY(), Style.Unit.PX);
						break;
					case LEFT:
					case RIGHT:
						asWidget().getElement().getStyle().setLeft(event.getRelativeX(), Style.Unit.PX);
						break;
				}
			}
		};

		public HammerGWTExampleWidget() {
			super();
			setOption(GestureOptions.SWIPE_VELOCITY, 1.5);
			registerSwipeHandler(swipeHandler);
		}

		@Override
		public Widget createWidget() {
			panel = new AbsolutePanel();
			panel.add(new Label("Swipe"));
			CheckBox checkBox = new CheckBox("unregister handler");
			checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {
					if (event.getValue()) {
						unregisterHandler(EventType.SWIPE);
					} else {
						registerSwipeHandler(swipeHandler);
					}
				}
			});

			panel.add(checkBox);
			panel.getElement().getStyle().setPosition(Style.Position.ABSOLUTE);
			panel.setSize("150px", "200px");
			panel.getElement().setId("hammerWidget");
			panel.getElement().getStyle().setBackgroundColor("green");
			panel.getElement().getStyle().setRight(0, Style.Unit.PX);
			panel.getElement().getStyle().setTop(0, Style.Unit.PX);

			return panel;
		}
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
	}

}

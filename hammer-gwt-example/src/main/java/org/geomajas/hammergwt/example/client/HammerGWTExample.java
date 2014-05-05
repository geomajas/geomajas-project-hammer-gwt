package org.geomajas.hammergwt.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.event.NativeHammerEvent;
import org.geomajas.hammergwt.client.handler.HammerDragHandler;
import org.geomajas.hammergwt.client.handler.HammerHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchHandler;
import org.geomajas.hammergwt.client.handler.HammerTapHandler;
import org.geomajas.hammergwt.client.impl.HammerTime;
import org.geomajas.hammergwt.client.impl.HammerGWT;
import org.geomajas.hammergwt.client.impl.option.GestureOption;
import org.geomajas.hammergwt.client.impl.option.GestureOptions;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hammer GWT example.
 *
 * @author Dosi Bingov
 */
public class HammerGWTExample implements EntryPoint {
	final Label logLabel = new Label();
	private Logger remoteLogger = Logger.getLogger("");

	@Override
	public void onModuleLoad() {
		logLabel.getElement().getStyle().setMarginTop(50, Style.Unit.PX);

		AbsolutePanel panel = new AbsolutePanel();

		SimplePanel panel2 = new SimplePanel();

		SimplePanel panel3= new SimplePanel();
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


		RootPanel.get().add(panel);
		RootPanel.get().add(panel2);
		RootPanel.get().add(panel3);
		RootPanel.get().add(logLabel);

		// Hammerable hammerable = new Hammerable(panel);


		HammerGWT.on(panel, new HammerHandler() {
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
						int left =target.getAbsoluteLeft() + 20;
						target.getStyle().setLeft(left, Style.Unit.PX);
						break;

				}
			}
		}, EventType.TAP, EventType.DRAG);


		HammerGWT.on(panel2, new HammerHandler() {
			@Override
			public void onHammerEvent(NativeHammerEvent event) {


				log(event);
			}
		}, EventType.DOUBLETAP, EventType.PINCH);


		HammerTime hammerTime = HammerGWT.on(panel3, new HammerHandler() {

			@Override
			public void onHammerEvent(NativeHammerEvent event) {
				log(event);
			}
		}, EventType.DOUBLETAP, EventType.PINCH, EventType.DRAG);


		// Set options example
		hammerTime.setOption(GestureOptions.DRAG, false);

		hammerTime.setOption(GestureOptions.HOLD_TIMEOUT, 2);

	}

	private void log(NativeHammerEvent event) {
		String s = "target tag name = "+event.getTarget().getNodeName() + ", scale = " + event.getScale() +
				", touches = " + event.getTouches() + ", EventType = " + event.getType() +
				", pageX = " + event.getPageX() + ", pageY = " + event.getPageY() +
				", relativeX = " + event.getRelativeX() + ", relativeY = " + event.getRelativeY() +
				", PointerType = " + event.getPointerType() + ", Target id = " + event.getTarget().getId();
		remoteLogger.log(Level.SEVERE, s);
		logLabel.setText(s);
	}

	class HammerableHandler implements HammerDragHandler, HammerPinchHandler,HammerTapHandler {

		@Override
		public void onDrag(NativeHammerEvent event) {
			log(event);
		}

		@Override
		public void onPinch(NativeHammerEvent event) {
			log(event);
		}

		@Override
		public void onTap(NativeHammerEvent event) {
			log(event);
		}
	}
}

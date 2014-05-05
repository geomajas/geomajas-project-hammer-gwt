package org.geomajas.hammergwt.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.IsWidget;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.handler.HammerDragEndHandler;
import org.geomajas.hammergwt.client.handler.HammerDragHandler;
import org.geomajas.hammergwt.client.handler.HammerDragStartHandler;
import org.geomajas.hammergwt.client.handler.HammerHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchInHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchOutHandler;
import org.geomajas.hammergwt.client.handler.HammerTapHandler;
import org.geomajas.hammergwt.client.impl.option.GestureOption;

/**
 * Hammer GWT implementation.
 *
 * @author Dosi Bingov
 *
 * @version 1.0
 */
public final class HammerGWT {

	protected HammerGWT() {
	}


	/**
	 * Sets hammer time options
	 * @param gestureOptions
	 */
	private static void setOptions(GestureOption[] gestureOptions, JavaScriptObject hammerGwt) {
		String gestureOptionsStr = "";

		for (GestureOption option: gestureOptions) {
			gestureOptionsStr = gestureOptionsStr + option + ", ";
		}

		gestureOptionsStr = gestureOptionsStr.substring(0, gestureOptionsStr.lastIndexOf(',')); //trim last comma

		setOptions(hammerGwt);
	}

	/**
	 * Detach event of a widget.
	 *
	 * @param widget
	 * @param eventType
	 */
	public static void off(IsWidget widget, EventType eventType) {
		off(widget.asWidget().getElement(), eventType.getText());
	}

	/**
	 * Add multiple hammer event.
	 *
	 *
	 * @param handler EventType handles all kinds of hammer event
	 * @param eventTypes type that hammer should handle
	 *
	 * @return Hammertime object
	 */
	public static HammerTime on(IsWidget widget, HammerHandler handler, EventType... eventTypes) {
		return on(widget, null, handler, eventTypes);
	}

	/**
	 * Add multiple hammer event.
	 *
	 * @param handler EventType handles all kinds of hammer event
	 * @param eventTypes type that hammer should handle
	 */
	public static HammerTime on(IsWidget widget, String eventNamespace, HammerHandler handler, EventType... eventTypes) {
		//JsArrayString arr = JavaScriptObject.createArray().cast();
		String eventTypesStr = "";

		for (EventType hammerEventType: eventTypes) {
			String namespace = "";

			if (null != eventNamespace && !eventNamespace.isEmpty()) {
				namespace = "." + eventNamespace;
			}

			eventTypesStr = eventTypesStr + hammerEventType.getText() + namespace + " ";
		}

		eventTypesStr = eventTypesStr.substring(0, eventTypesStr.lastIndexOf(" ")); //trim last space

		HammerTime obj = getInstance(widget.asWidget().getElement());

		on(obj, eventTypesStr, handler);

		return obj;
	}

	private static native void off(com.google.gwt.dom.client.Element el, String event) /*-{
        return $wnd.Hammer(el).off(event);
    }-*/;

	//TODO: make possible to set options as parameter
	private static native void setOptions(JavaScriptObject hammertime) /*-{
        hammertime.options.prevent_default = true;
        hammertime.options.no_mouseevents = true;
    }-*/;


	public static native HammerTime getInstance(com.google.gwt.dom.client.Element el) /*-{
        return $wnd.Hammer(el);
    }-*/;

	private static native void on(JavaScriptObject hammertime, String evenTypes, HammerHandler handler) /*-{

        hammertime.on(evenTypes,

            function(ev) {
                handler.@org.geomajas.hammergwt.client.handler.HammerHandler::onHammerEvent(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onPinch(JavaScriptObject hammer, HammerPinchHandler handler) /*-{
        hammer.on("pinch",

            function(ev) {
               handler.@org.geomajas.hammergwt.client.handler.HammerPinchHandler::onPinch(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onTap(JavaScriptObject hammer, HammerTapHandler handler) /*-{
        hammer.on("tap",

            function(ev) {
                handler.@org.geomajas.hammergwt.client.handler.HammerTapHandler::onTap(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;


	public static native void onDrag(JavaScriptObject hammer, HammerDragHandler handler) /*-{
        hammer.on("drag",

            function(ev) {
                handler.@org.geomajas.hammergwt.client.handler.HammerDragHandler::onDrag(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);

                //if (typeof console == 'object') {
					//TODO: make logging more generic
					console.log('Drag Event', ev);
                //}
            });
    }-*/;

	public static native void onPinchIn(JavaScriptObject hammer, HammerPinchInHandler handler) /*-{
        hammer.on("pinchin",

            function(ev) {
                handler.@org.geomajas.hammergwt.client.handler.HammerPinchInHandler::onPinchIn(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onPinchOut(JavaScriptObject hammer, HammerPinchOutHandler handler) /*-{
        hammer.on("pinchout",

            function(ev) {
                handler.@org.geomajas.hammergwt.client.handler.HammerPinchOutHandler::onPinchOut(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onDragStart(JavaScriptObject hammer, HammerDragStartHandler handler) /*-{
        hammer.on("dragstart",

            function(ev) {
                handler.@org.geomajas.hammergwt.client.handler.HammerDragStartHandler::onDragStart(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onDragEnd(JavaScriptObject hammer, HammerDragEndHandler handler) /*-{
        hammer.on("dragend",

            function(ev) {
                handler.@org.geomajas.hammergwt.client.handler.HammerDragEndHandler::onDragEnd(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

}

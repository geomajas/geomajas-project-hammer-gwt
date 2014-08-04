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
import org.geomajas.annotation.Api;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.handler.HammerDoubleTapHandler;
import org.geomajas.hammergwt.client.handler.HammerDragHandler;
import org.geomajas.hammergwt.client.handler.HammerGWTCallback;
import org.geomajas.hammergwt.client.handler.HammerGestureHandler;
import org.geomajas.hammergwt.client.handler.HammerHandler;
import org.geomajas.hammergwt.client.handler.HammerHoldHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchHandler;
import org.geomajas.hammergwt.client.handler.HammerReleaseHandler;
import org.geomajas.hammergwt.client.handler.HammerRotateHandler;
import org.geomajas.hammergwt.client.handler.HammerSwipeHandler;
import org.geomajas.hammergwt.client.handler.HammerTapHandler;
import org.geomajas.hammergwt.client.handler.HammerTouchHandler;
import org.geomajas.hammergwt.client.handler.HammerTransformHandler;

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
	 * Unregister hammer event.
	 *
	 * @param eventType {@link org.geomajas.hammergwt.client.event.EventType}
	 */
	public static void off(HammerTime hammerTime, EventType eventType, HammerGWTCallback callback) {
		off(hammerTime, callback, eventType.getText());
	}

	/**
	 * Add multiple hammer events.
	 *
	 * @param handler  {@link org.geomajas.hammergwt.client.handler.HammerHandler}
	 * @param eventTypes {@link org.geomajas.hammergwt.client.event.EventType}
	 *
	 * @return {@link org.geomajas.hammergwt.client.impl.HammerTime}
	 */
	public static HammerGWTCallback on(HammerTime hammerTime, HammerHandler handler, EventType... eventTypes) {
		HammerGWTCallback cb = on(hammerTime, createEvenTypesString(null, eventTypes), handler);

		return cb;
	}

	/**
	 * Add multiple hammer events.
	 *
	 * @param handler  {@link org.geomajas.hammergwt.client.handler.HammerHandler}
	 * @param eventTypes {@link org.geomajas.hammergwt.client.event.EventType}
	 *
	 * @return {@link org.geomajas.hammergwt.client.impl.HammerTime}
	 */
	public static HammerGWTCallback on(HammerTime hammerTime, String eventNamespace,
			HammerHandler handler, EventType... eventTypes) {
		//JsArrayString arr = JavaScriptObject.createArray().cast();

		HammerGWTCallback cb = on(hammerTime, createEvenTypesString(eventNamespace, eventTypes), handler);

		return cb;
	}

	/**
	 * Create instance of {@link org.geomajas.hammergwt.client.impl.HammerTime} for a given
	 *  {@link com.google.gwt.user.client.ui.IsWidget}.
	 * @param widget
	 * @return {@link org.geomajas.hammergwt.client.impl.HammerTime}
	 *
	 *  @since 1.0.0
	 */
	@Api
	public static HammerTime createInstance(IsWidget widget) {
		return createInstance(widget.asWidget().getElement());
	}

	private static String createEvenTypesString(String eventNamespace, EventType... eventTypes) {
		String eventTypesStr = "";

		for (EventType hammerEventType : eventTypes) {
			String namespace = "";

			if (null != eventNamespace && !eventNamespace.isEmpty()) {
				namespace = "." + eventNamespace;
			}

			eventTypesStr = eventTypesStr + hammerEventType.getText() + namespace + " ";
		}

		return eventTypesStr;
	}


	// CHECKSTYLE: OFF
	private static native void off(HammerTime hammerTime, HammerGWTCallback callback, String event) /*-{
		hammerTime.off(event, callback);
	}-*/;

	//TODO: make possible to set options as parameter on create instance
	private static native void setOptions(JavaScriptObject hammertime) /*-{
		hammertime.options.prevent_default = true;
		hammertime.options.no_mouseevents = true;
	}-*/;

	/**
	 * Create instance of {@link org.geomajas.hammergwt.client.impl.HammerTime} for a given
	 *  {@link  com.google.gwt.dom.client.Element}.
	 * @param el
	 * @return {@link org.geomajas.hammergwt.client.impl.HammerTime}
	 *
	 * @since 1.0.0
	 */
	@Api
	public static native HammerTime createInstance(com.google.gwt.dom.client.Element el) /*-{
		return $wnd.Hammer(el);

	}-*/;


	private static native HammerGWTCallback on(HammerTime hammertime, String evenTypes, HammerHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerHandler::onHammerEvent(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

		hammertime.on(evenTypes, callback);

		return callback;
	}-*/;


	public static native HammerGWTCallback onPinch(HammerTime hammertime, HammerPinchHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerPinchHandler::onPinch(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev)
        });

        hammertime.on("pinch", callback);

		return callback
	}-*/;

	public static native HammerGWTCallback onTap(HammerTime hammertime, HammerTapHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerTapHandler::onTap(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("tap", callback);

        return callback
	}-*/;

	public static native HammerGWTCallback onDrag(HammerTime hammertime, HammerDragHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerDragHandler::onDrag(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("drag", callback);

        return callback
	}-*/;

	public static native HammerGWTCallback onHold(HammerTime hammertime, HammerHoldHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerHoldHandler::onHold(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("hold", callback);

        return callback
    }-*/;

	public static native HammerGWTCallback onDoubleTap(HammerTime hammertime, HammerDoubleTapHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerDoubleTapHandler::onDoubleTap(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("doubletap", callback);

        return callback
    }-*/;

	public static native HammerGWTCallback onSwipe(HammerTime hammertime, HammerSwipeHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerSwipeHandler::onSwipe(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("swipe", callback);

        return callback
    }-*/;

	public static native HammerGWTCallback onTransform(HammerTime hammertime, HammerTransformHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerTransformHandler::onTransform(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("transform", callback);

        return callback
    }-*/;

	public static native HammerGWTCallback onRotate(HammerTime hammertime, HammerRotateHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerRotateHandler::onRotate(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("rotate", callback);

        return callback
    }-*/;

	public static native HammerGWTCallback onTouch(HammerTime hammertime, HammerTouchHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerTouchHandler::onTouch(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("touch", callback);

        return callback
    }-*/;

	public static native HammerGWTCallback onRelease(HammerTime hammertime, HammerReleaseHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerReleaseHandler::onRelease(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("release", callback);

        return callback
    }-*/;

	public static native HammerGWTCallback onGesture(HammerTime hammertime, HammerGestureHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerGestureHandler::onGesture(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("gesture", callback);

        return callback
    }-*/;

	// CHECKSTYLE:ON

}

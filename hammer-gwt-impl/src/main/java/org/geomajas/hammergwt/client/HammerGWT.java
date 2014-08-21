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
package org.geomajas.hammergwt.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.IsWidget;
import org.geomajas.annotation.Api;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.handler.HammerDoubleTapHandler;
import org.geomajas.hammergwt.client.handler.HammerDragHandler;
import org.geomajas.hammergwt.client.handler.NativeHammmerHandler;
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

	/**
	 * Protected constructor.
	 */
	protected HammerGWT() {
	}

	/**
	 *  Unregister hammer event.
	 *
	 * @param hammerTime {@link HammerTime} hammer gwt instance.
	 * @param eventType {@link org.geomajas.hammergwt.client.event.EventType}
	 * @param callback {@link org.geomajas.hammergwt.client.handler.NativeHammmerHandler} of the event that needs
	 *                                                                                   to be unregistered.
	 */
	public static void off(HammerTime hammerTime, EventType eventType, NativeHammmerHandler callback) {
		off(hammerTime, callback, eventType.getText());
	}

	/**
	 * Add multiple hammer events.
	 *
	 * @param handler  {@link org.geomajas.hammergwt.client.handler.HammerHandler}
	 * @param eventTypes {@link org.geomajas.hammergwt.client.event.EventType}
	 *
	 * @return {@link org.geomajas.hammergwt.client.handler.NativeHammmerHandler}
	 */
	/**
	 *
	 * @param hammerTime {@link HammerTime} hammer gwt instance.
	 * @param handler {@link HammerHandler} generic hammer handler that will handle all event types.
	 * @param eventTypes multiple event types.
	 *
	 * @return {@linkHammerGwtCallback}
	 */
	public static NativeHammmerHandler on(HammerTime hammerTime, HammerHandler handler, EventType... eventTypes) {
		NativeHammmerHandler cb = on(hammerTime, createEvenTypesString(null, eventTypes), handler);

		return cb;
	}

	/**
	 *
	 * @param hammerTime {@link HammerTime} hammer gwt instance.
	 * @param eventNamespace hammer gwt namespace.
	 * @param handler {@link HammerHandler} generic hammer handler that will handle all event types.
	 * @param eventTypes multiple event types.
	 * @return {@linkHammerGwtCallback}.
	 */
	public static NativeHammmerHandler on(HammerTime hammerTime, String eventNamespace,
			HammerHandler handler, EventType... eventTypes) {
		//JsArrayString arr = JavaScriptObject.createArray().cast();
		NativeHammmerHandler cb = on(hammerTime, createEvenTypesString(eventNamespace, eventTypes), handler);

		return cb;
	}

	private static void injectScript() {
		if (!isInjected()) {
			String jsUrl = HammerGwtClientBundle.INSTANCE.hammerJs().getText();

			if (USE_JS_SOURCE) {
				jsUrl = HammerGwtClientBundle.INSTANCE.hammerJsSrc().getText();
			}

			//inject hammer js javascript at top level window object
			ScriptInjector.fromString(jsUrl).setWindow(ScriptInjector.TOP_WINDOW).inject();
		}
	}

	/**
	 * Add hammer Gwt to a given Gwt widget.
	 * @param widget {@link com.google.gwt.user.client.ui.IsWidget}
	 * @return {@link HammerTime}
	 * @since 1.0.0
	 */
	@Api
	public static HammerTime create(IsWidget widget) {
		return create(widget.asWidget().getElement());
	}

	/**
	 * Add {@link HammerTime} to a given Html Dom element.
	 *
	 * @param element {@link  com.google.gwt.dom.client.Element}.
	 * @return {@link HammerTime}
	 *
	 * @since 1.0.0
	 */
	@Api
	public static HammerTime create(Element element) {
		injectScript(); //very important don' t forget to inject hammer js script
		return createHammerJsInstance(element);
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

	/**
	 * By default minimized version of hammer Js javascript is injected.
	 */
	public static boolean USE_JS_SOURCE = false;

	private static native boolean isInjected() /*-{
		if (!(typeof $wnd.Hammer === "undefined") && !(null===$wnd.Hammer)) {
            return true;
        }
        return false;
    }-*/;


	private static native void off(HammerTime hammerTime, NativeHammmerHandler callback, String event) /*-{
		hammerTime.off(event, callback);
	}-*/;

	//TODO: make possible to set options as parameter on create instance
	private static native void setOptions(JavaScriptObject hammertime) /*-{
		hammertime.options.prevent_default = true;
		hammertime.options.no_mouseevents = true;
	}-*/;

	/**
	 * Add {@link HammerTime} to a given Html Dom element.
	 *
	 * @param el {@link  com.google.gwt.dom.client.Element}.
	 * @return {@link HammerTime}
	 *
	 * @since 1.0.0
	 */
	private static native HammerTime createHammerJsInstance(com.google.gwt.dom.client.Element el) /*-{
		return $wnd.Hammer(el);

	}-*/;

	private static native NativeHammmerHandler on(HammerTime hammertime, String evenTypes, HammerHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerHandler::onHammerEvent(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

		hammertime.on(evenTypes, callback);

		return callback;
	}-*/;


	public static native NativeHammmerHandler onPinch(HammerTime hammertime, HammerPinchHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerPinchHandler::onPinch(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev)
        });

        hammertime.on("pinch", callback);

		return callback
	}-*/;

	public static native NativeHammmerHandler onTap(HammerTime hammertime, HammerTapHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerTapHandler::onTap(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("tap", callback);

        return callback
	}-*/;

	public static native NativeHammmerHandler onDrag(HammerTime hammertime, HammerDragHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerDragHandler::onDrag(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("drag", callback);

        return callback
	}-*/;

	public static native NativeHammmerHandler onHold(HammerTime hammertime, HammerHoldHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerHoldHandler::onHold(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("hold", callback);

        return callback
    }-*/;

	public static native NativeHammmerHandler onDoubleTap(HammerTime hammertime, HammerDoubleTapHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerDoubleTapHandler::onDoubleTap(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("doubletap", callback);

        return callback
    }-*/;

	public static native NativeHammmerHandler onSwipe(HammerTime hammertime, HammerSwipeHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerSwipeHandler::onSwipe(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("swipe", callback);

        return callback
    }-*/;

	public static native NativeHammmerHandler onTransform(HammerTime hammertime, HammerTransformHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerTransformHandler::onTransform(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("transform", callback);

        return callback
    }-*/;

	public static native NativeHammmerHandler onRotate(HammerTime hammertime, HammerRotateHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerRotateHandler::onRotate(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("rotate", callback);

        return callback
    }-*/;

	public static native NativeHammmerHandler onTouch(HammerTime hammertime, HammerTouchHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerTouchHandler::onTouch(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("touch", callback);

        return callback
    }-*/;

	public static native NativeHammmerHandler onRelease(HammerTime hammertime, HammerReleaseHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerReleaseHandler::onRelease(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("release", callback);

        return callback
    }-*/;

	public static native NativeHammmerHandler onGesture(HammerTime hammertime, HammerGestureHandler handler) /*-{
        var callback = $entry(function(ev) {
            handler.@org.geomajas.hammergwt.client.handler.HammerGestureHandler::onGesture(Lorg/geomajas/hammergwt/client/event/NativeHammerEvent;)(ev);
        });

        hammertime.on("gesture", callback);

        return callback
    }-*/;

	// CHECKSTYLE:ON

}

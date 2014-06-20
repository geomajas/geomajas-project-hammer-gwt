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

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.geomajas.annotation.Api;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.handler.HammerDoubleTapHandler;
import org.geomajas.hammergwt.client.handler.HammerDragHandler;
import org.geomajas.hammergwt.client.handler.HammerGWTCallback;
import org.geomajas.hammergwt.client.handler.HammerGestureHandler;
import org.geomajas.hammergwt.client.handler.HammerHoldHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchHandler;
import org.geomajas.hammergwt.client.handler.HammerReleaseHandler;
import org.geomajas.hammergwt.client.handler.HammerRotateHandler;
import org.geomajas.hammergwt.client.handler.HammerSwipeHandler;
import org.geomajas.hammergwt.client.handler.HammerTapHandler;
import org.geomajas.hammergwt.client.handler.HammerTouchHandler;
import org.geomajas.hammergwt.client.handler.HammerTransformHandler;
import org.geomajas.hammergwt.client.impl.option.GestureOption;

import java.util.HashMap;
import java.util.Map;


/**
 * Hammer GWT widget.
 *
 * @author Dosi Bingov
 *
 * @version 1.0
 */

public abstract class HammerWidget implements IsWidget {
	protected HammerTime hammertime;
	protected Widget widget;
	private Map<EventType, HammerGWTCallback> callbacksMap;

	/**
	 * Default constructor.
	 *
	 * @since 1.0.0
	 */
	@Api
	public HammerWidget() {
		widget =  createWidget();
		hammertime = HammerGWT.createInstance(widget.getElement());
		callbacksMap = new HashMap<EventType, HammerGWTCallback>();
	}

	/**
	 * Create the widget that will have hammer gwt behavior.
	 *
	 * @return {@link com.google.gwt.user.client.ui.Widget}
	 *
	 * @since 1.0.0
	 */
	@Api
	public abstract Widget createWidget();

	/**
	 * Change initial settings of this hammer widget.
	 *
	 * @param option {@link org.geomajas.hammergwt.client.impl.option.GestureOption}
	 * @param value T look at {@link org.geomajas.hammergwt.client.impl.option.GestureOptions}
	 *                 interface for all possible types
	 *
	 * @param <T>
	 *
	 * @since 1.0.0
	 */
	@Api
	public <T> void setOption(GestureOption<T> option, T value) {
		hammertime.setOption(option, value);
	}

	public void registerPinchHandler(HammerPinchHandler handler) {
		callbacksMap.put(EventType.PINCH, HammerGWT.onPinch(hammertime, handler));
	}

	public void registerTapHandler(HammerTapHandler handler) {
		callbacksMap.put(EventType.TAP, HammerGWT.onTap(hammertime, handler));
	}

	public void registerDragHandler(HammerDragHandler handler) {
		callbacksMap.put(EventType.DRAG, HammerGWT.onDrag(hammertime, handler));
	}

	public void registerHoldHandler(HammerHoldHandler handler) {
		callbacksMap.put(EventType.HOLD, HammerGWT.onHold(hammertime, handler));
	}

	public void registerDoubleTapHandler(HammerDoubleTapHandler handler) {
		callbacksMap.put(EventType.DOUBLETAP, HammerGWT.onDoubleTap(hammertime, handler));
	}

	public void registerSwipeHandler(HammerSwipeHandler handler) {
		callbacksMap.put(EventType.SWIPE, HammerGWT.onSwipe(hammertime, handler));
	}

	public void registerTransformHandler(HammerTransformHandler handler) {
		callbacksMap.put(EventType.TRANSFORM, HammerGWT.onTransform(hammertime, handler));
	}

	public void registerRotateHandler(HammerRotateHandler handler) {
		callbacksMap.put(EventType.ROTATE, HammerGWT.onRotate(hammertime, handler));
	}

	public void registerTouchHandler(HammerTouchHandler handler) {
		callbacksMap.put(EventType.TOUCH, HammerGWT.onTouch(hammertime, handler));
	}

	public void registerReleaseHandler(HammerReleaseHandler handler) {
		callbacksMap.put(EventType.RELEASE, HammerGWT.onRelease(hammertime, handler));
	}

	public void registerGestureHandler(HammerGestureHandler handler) {
		callbacksMap.put(EventType.GESTURE, HammerGWT.onGesture(hammertime, handler));
	}

	/**
	 * Unregister hammer event.
	 *
	 * @param eventType {@link org.geomajas.hammergwt.client.event.EventType}
	 */
	@Api
	public void unregisterEvent(EventType eventType) {

		if (!callbacksMap.containsKey(eventType)) {
			return;
		}

		HammerGWT.off(hammertime, eventType, (HammerGWTCallback) callbacksMap.remove(eventType));
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}

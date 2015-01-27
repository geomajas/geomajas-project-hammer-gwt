/*
 * This is part of Geomajas, a GIS framework, http://www.geomajas.org/.
 *
 * Copyright 2008-2015 Geosparc nv, http://www.geosparc.com/, Belgium.
 *
 * The program is available in open source according to the Apache
 * License, Version 2.0. All contributions in this program are covered
 * by the Geomajas Contributors License Agreement. For full licensing
 * details, see LICENSE.txt in the project root.
 */
package org.geomajas.hammergwt.client;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.geomajas.annotation.Api;
import org.geomajas.hammergwt.client.event.EventType;
import org.geomajas.hammergwt.client.handler.HammerDoubleTapHandler;
import org.geomajas.hammergwt.client.handler.HammerDragHandler;
import org.geomajas.hammergwt.client.handler.NativeHammmerHandler;
import org.geomajas.hammergwt.client.handler.HammerGestureHandler;
import org.geomajas.hammergwt.client.handler.HammerHoldHandler;
import org.geomajas.hammergwt.client.handler.HammerPinchHandler;
import org.geomajas.hammergwt.client.handler.HammerReleaseHandler;
import org.geomajas.hammergwt.client.handler.HammerRotateHandler;
import org.geomajas.hammergwt.client.handler.HammerSwipeHandler;
import org.geomajas.hammergwt.client.handler.HammerTapHandler;
import org.geomajas.hammergwt.client.handler.HammerTouchHandler;
import org.geomajas.hammergwt.client.handler.HammerTransformHandler;
import org.geomajas.hammergwt.client.option.GestureOption;

import java.util.HashMap;
import java.util.Map;


/**
 * Hammer GWT widget. Should be used to create widgets with hammer Gwt events.
 *
 * @author Dosi Bingov
 *
 * @version 1.0.0
 */

public abstract class HammerWidget implements IsWidget {
	protected HammerTime hammertime;
	protected Widget widget;
	private Map<EventType, NativeHammmerHandler> jsHandlersMap;

	/**
	 * Default constructor.
	 *
	 * @since 1.0.0
	 */
	@Api
	public HammerWidget() {
		widget =  createWidget();
		hammertime = HammerGwt.create(widget.getElement());
		jsHandlersMap = new HashMap<EventType, NativeHammmerHandler>();
	}

	/**
	 * Create Gwt widget that will have hammer gwt events.
	 *
	 * @return {@link com.google.gwt.user.client.ui.Widget}
	 *
	 * @since 1.0.0
	 */
	@Api
	public abstract Widget createWidget();

	/**
	 * Change initial settings of this widget.
	 *
	 * @param option {@link org.geomajas.hammergwt.client.option.GestureOption}
	 * @param value T look at {@link org.geomajas.hammergwt.client.option.GestureOptions}
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
		jsHandlersMap.put(EventType.PINCH, HammerGwt.onPinch(hammertime, handler));
	}

	public void registerTapHandler(HammerTapHandler handler) {
		jsHandlersMap.put(EventType.TAP, HammerGwt.onTap(hammertime, handler));
	}

	public void registerDragHandler(HammerDragHandler handler) {
		jsHandlersMap.put(EventType.DRAG, HammerGwt.onDrag(hammertime, handler));
	}

	public void registerHoldHandler(HammerHoldHandler handler) {
		jsHandlersMap.put(EventType.HOLD, HammerGwt.onHold(hammertime, handler));
	}

	public void registerDoubleTapHandler(HammerDoubleTapHandler handler) {
		jsHandlersMap.put(EventType.DOUBLETAP, HammerGwt.onDoubleTap(hammertime, handler));
	}

	public void registerSwipeHandler(HammerSwipeHandler handler) {
		jsHandlersMap.put(EventType.SWIPE, HammerGwt.onSwipe(hammertime, handler));
	}

	public void registerTransformHandler(HammerTransformHandler handler) {
		jsHandlersMap.put(EventType.TRANSFORM, HammerGwt.onTransform(hammertime, handler));
	}

	public void registerRotateHandler(HammerRotateHandler handler) {
		jsHandlersMap.put(EventType.ROTATE, HammerGwt.onRotate(hammertime, handler));
	}

	public void registerTouchHandler(HammerTouchHandler handler) {
		jsHandlersMap.put(EventType.TOUCH, HammerGwt.onTouch(hammertime, handler));
	}

	public void registerReleaseHandler(HammerReleaseHandler handler) {
		jsHandlersMap.put(EventType.RELEASE, HammerGwt.onRelease(hammertime, handler));
	}

	public void registerGestureHandler(HammerGestureHandler handler) {
		jsHandlersMap.put(EventType.GESTURE, HammerGwt.onGesture(hammertime, handler));
	}

	/**
	 * Unregister Hammer Gwt handler.
	 *
	 * @param eventType {@link org.geomajas.hammergwt.client.event.EventType}
	 *
	 * @since 1.0.0
	 */
	@Api
	public void unregisterHandler(EventType eventType) {

		if (!jsHandlersMap.containsKey(eventType)) {
			return;
		}

		HammerGwt.off(hammertime, eventType, (NativeHammmerHandler) jsHandlersMap.remove(eventType));
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}

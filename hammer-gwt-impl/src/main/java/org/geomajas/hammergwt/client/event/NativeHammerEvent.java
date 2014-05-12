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
package org.geomajas.hammergwt.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;

/**
 * Native javascript event of hammer js.
 *
 * @author Dosi Bingov
 */
public class NativeHammerEvent extends JavaScriptObject {
	/**
	 * It is required for the compiler.
	 */
	protected NativeHammerEvent() {
	}


	/**
	 * Stops Hammer from detecting any further gestures, in the current detection session.
	 * Might be usefull to call after you did a succesfull swipe.
	 */
	public final void stopDetect() {
		stopDetect(this);
	}

	/**
	 * Stops bubbling the gesture event to its parents. So you can create nested event.
	 */
	public final void stopPropagation() {
		stopPropagation(this);
	}

	/**
	 * Prevents the browser from doing it's native gesture implementation.
	 * It doesn't make any sense, only for the drag event, since most browsers support dragstart-drag-dragend.
	 * It is in Hammer, because document.createEvent adds these, and Hammer uses this for creating DOM event.
	 */
	public final void preventDefault() {
		preventDefault(this);
	}

	/**
	 * Stops the native (source ev.gesture.srcEvent) event  from bubbling.
	 * The source event could be touchstart, touchmove, mousemove etc.
	 */
	public final void stopNativePropagation() {
		stopNativePropagation(this);
	}

	/**
	 * Prevents the native (source ev.gesture.srcEvent) event  from doing it's native behavior.
	 * Ex. prevent the browser scroll when you drag or swipe.
	 */
	public final void preventNativeDefault() {
		preventNativeDefault(this);
	}

	public final EventType getType() {
		return EventType.fromString(getType(this));
	}

	public final double getScale() {
		return getScale(this);
	}

	public final int getTouches() {
		return getTouches(this);
	}

	public final String getTargetTagName() {
		return getTargetTagName(this);
	}

	public final Element getTarget() {
		return getTarget(this);
	}

	public final int getPageX() {
		return getPageX(this);
	}

	public final int getPageY() {
		return getPageY(this);
	}

	public final PointerType getPointerType() {
		return PointerType.fromString(getPointerType(this));
	}

	public final String getDirection() {
		return getDirection(this);
	}

	public final NativeEvent getNativeEvent() {
		return getNativeEvent(this);
	}


	public final int getRelativeX() {
		NativeEvent e = getNativeEvent();
		Element target = getTarget();

		return e.getClientX() - target.getAbsoluteLeft() + target.getScrollLeft() +
				target.getOwnerDocument().getScrollLeft();
	}


	public final int getRelativeY() {
		NativeEvent e = getNativeEvent();
		Element target = getTarget();

		return e.getClientY() - target.getAbsoluteTop() + target.getScrollTop() +
				target.getOwnerDocument().getScrollTop();
	}

	//CHECKSTYLE VISIBILITY MODIFIER: OFF

	private native void stopDetect(NativeHammerEvent evt) /*-{
		evt.gesture.stopDetect();
	}-*/;

	private native void stopPropagation(NativeHammerEvent evt) /*-{
		evt.stopPropagation();
	}-*/;

	private native void preventDefault(NativeHammerEvent evt) /*-{
		evt.preventDefault();
	}-*/;

	private native void stopNativePropagation(NativeHammerEvent evt) /*-{
		evt.gesture.stopPropagation();
	}-*/;

	private native void preventNativeDefault(NativeHammerEvent evt) /*-{
		evt.gesture.preventDefault();
	}-*/;

	private native Element getTarget(NativeHammerEvent evt) /*-{
		return evt.gesture.target;
	}-*/;


	private native NativeEvent getNativeEvent(NativeHammerEvent evt) /*-{
		return evt.gesture['srcEvent'];
	}-*/;


	private native String getPointerType(NativeHammerEvent evt) /*-{
		return evt.gesture['pointerType'];
	}-*/;

	private native String getType(NativeHammerEvent event) /*-{
		return event.type;
	}-*/;

	private native double getScale(NativeHammerEvent evt) /*-{
		return evt.gesture['scale'];
	}-*/;

	private native int getTouches(NativeHammerEvent evt) /*-{
		return evt.gesture.touches.length;
	}-*/;

	private native String getTargetTagName(NativeHammerEvent evt) /*-{
		return evt.gesture.target.tagName;
	}-*/;

	private native int getPageX(NativeHammerEvent evt) /*-{
		return evt.gesture['center'].pageX;
	}-*/;


	private native int getPageY(NativeHammerEvent evt) /*-{
		return evt.gesture['center'].pageY;
	}-*/;

	private native String getDirection(NativeHammerEvent evt) /*-{
		return evt.gesture['direction'];
	}-*/;

	//CHECKSTYLE VISIBILITY MODIFIER: ON
}

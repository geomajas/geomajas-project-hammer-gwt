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
 * Hammer GWT event javascript overlay type.
 *
 * @author Dosi Bingov
 *
 * @since 1.0.0
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
	 * The source event could be touchstart, touchmove, mousemove, click and etc.
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

	/**
	 * Get the type of this hammer event.
	 *
	 * @return {@link org.geomajas.hammergwt.client.event.EventType}
	 */
	public final EventType getType() {
		return EventType.fromString(getType(this));
	}

	/**
	 * Scaling of the touches, needs 2 touches.
	 * @return value of scale
	 */
	public final double getScale() {
		return getScale(this);
	}

	/**
	 * Get current touches.
	 *
	 * @return value of current touches
	 */
	public final int getTouches() {
		return getTouches(this);
	}

	/**
	 * Get the name of the target DOM element.
	 *
	 * @return name of DOM element
	 */
	public final String getTargetTagName() {
		return getTargetTagName(this);
	}

	/**
	 * Get target DOM element.
	 *
	 * @return {@link com.google.gwt.dom.client.Element}
	 */
	public final Element getTarget() {
		return getTarget(this);
	}

	/**
	 * Get pageX.
	 * @return page x position in pixels.
	 */
	public final int getPageX() {
		return getPageX(this);
	}

	/**
	 * Get page y.
	 * @return page y position in pixels.
	 */
	public final int getPageY() {
		return getPageY(this);
	}

	/**
	 * Total time of the touches in the screen.
	 *
	 * @return total time
	 */
	public final int getDeltaTime() {
		return getDeltaTime(this);
	}

	/**
	 * The velocity on the x.
	 * @return velocity value
	 */
	public final double getVelocityX() {
		return getVelocityX(this);
	}

	/**
	 *  The velocity on the y.
	 * @return velocity value
	 */
	public final double getVelocityY() {
		return getVelocityY(this);
	}

	/**
	 * The angle between gesture start and end point.
	 * @return the angle value.
	 */
	public final double getAngle() {
		return getVelocityY(this);
	}

	/**
	 * The rotation of two touches.
	 *
	 * @return the rotation value.
	 */
	public final double getRotation() {
		return getRotation(this);
	}

	/**
	 * Interim angle since the last movement.
	 * @return the angle value.
	 */
	public final double getInterimAngle() {
		return getVelocityY(this);
	}

	/**
	 * Interim direction since the last movement.
	 * @return {@link org.geomajas.hammergwt.client.event.Direction}
	 */
	public final Direction getInterimDirection() {
		return Direction.fromString(getInterimDirection(this));
	}

	/**
	 * The distance we moved from the start of the gesture.
	 *
	 * @return value for distance
	 */
	public final int getDistance() {
		return getDistance(this);
	}

	public final PointerType getPointerType() {
		return PointerType.fromString(getPointerType(this));
	}

	/**
	 * Get gesture direction.
	 *
	 * @return {@link org.geomajas.hammergwt.client.event.Direction}
	 */
	public final Direction getDirection() {
		return Direction.fromString(getDirection(this));
	}

	/**
	 * Get time that event occurred.
	 *
	 * @return timestamp
	 */
	public final int getTimeStamp() {
		return getTimeStamp(this);
	}

	/**
	 * Get native browser event.
	 *
	 * @return {@link com.google.gwt.dom.client.NativeEvent}
	 */
	public final NativeEvent getNativeEvent() {
		return getNativeEvent(this);
	}

	/**
	 * Get native event from the first touch. this is used internal of hammer js
	 * to calculate distances, deltaTime, scaling and etc.
	 * @return {@link com.google.gwt.dom.client.NativeEvent}
	 */
	public final NativeEvent getStartEvent() {
		return getStartEvent(this);
	}

	/**
	 * Get relative x position on the page.
	 * @return x position in pixels
	 */
	public final int getRelativeX() {
		NativeEvent e = getNativeEvent();
		Element target = getTarget();

		return e.getClientX() - target.getAbsoluteLeft() + target.getScrollLeft() +
				target.getOwnerDocument().getScrollLeft();
	}

	/**
	 * Get relative y position on the page.
	 * @return x position in pixels
	 */
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

	private native NativeEvent getStartEvent(NativeHammerEvent evt) /*-{
		return evt.gesture['startEvent'];
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

	private native int getDeltaTime(NativeHammerEvent evt) /*-{
		return evt.gesture['deltaTime'];
	}-*/;

	private native double getVelocityX(NativeHammerEvent evt) /*-{
		return evt.gesture['velocityX'];
	}-*/;

	private native double getVelocityY(NativeHammerEvent evt) /*-{
		return evt.gesture['velocityY'];
	}-*/;

	private native double getAngle(NativeHammerEvent evt) /*-{
		return evt.gesture['angle'];
	}-*/;

	private native double getInterimAngle(NativeHammerEvent evt) /*-{
		return evt.gesture['interimAngle'];
	}-*/;

	private native String getInterimDirection(NativeHammerEvent evt) /*-{
		return evt.gesture['interimDirection'];
	}-*/;

	private native int getDistance(NativeHammerEvent evt) /*-{
		return evt.gesture['distance'];
	}-*/;

	private native double getRotation(NativeHammerEvent evt) /*-{
		return evt.gesture['rotation'];
	}-*/;

	private native int getTimeStamp(NativeHammerEvent evt) /*-{
        return evt.gesture['timestamp'];
    }-*/;

	//CHECKSTYLE VISIBILITY MODIFIER: ON
}

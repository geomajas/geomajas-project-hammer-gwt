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

import org.geomajas.annotation.Api;

/**
 * Hammer gwt event type.
 *
 * @author Dosi Bingov
 *
 * @since 1.0.0
 */
@Api
public enum EventType {
	/**
	 * gesture event.
	 */
	GESTURE("gesture"),

	/**
	 * touch event.
	 */
	TOUCH("touch"),
	/**
	 * release event.
	 */
	RELEASE("release"),
	/**
	 * hold event.
	 */
	HOLD("hold"),
	/**
	 * tap event.
	 */
	TAP("tap"),
	/**
	 * double tap event.
	 */
	DOUBLETAP("doubletap"),

	/**
	 * drag start event.
	 */
	DRAGSTART("dragstart"),
	/**
	 * drag event.
	 */
	DRAG("drag"),
	/**
	 * dragend event.
	 */
	DRAGEND("dragend"),
	/**
	 * dragleft event.
	 */
	DRAGLEFT("dragleft"),
	/**
	 * dragright event.
	 */
	DRAGRIGHT("dragright"),
	/**
	 * dragup event.
	 */
	DRAGUP("dragup"),
	/**
	 * drag down event.
	 */
	DRAGDOWN("dragdown"),

	/**
	 * swipe event.
	 */
	SWIPE("swipe"),
	/**
	 * swipe left event.
	 */
	SWIPELEFT("swipeleft"),
	/**
	 * swipe right event.
	 */
	SWIPERIGHT("swiperight"),
	/**t
	 * swipe up event.
	 */
	SWIPEUP("swipeup"),
	/**
	 * swipe down event.
	 */
	SWIPEDOWN("swipedown"),

	/**
	 * transform start event.
	 */
	TRANSFORMSTART("transformstart"),
	/**
	 * transform event.
	 */
	TRANSFORM("transform"),
	/**
	 * transform end event.
	 */
	TRANSFORMEND("transformend"),
	/**
	 * rotate event.
	 */
	ROTATE("rotate"),
	/**
	 * pinch event.
	 */
	PINCH("pinch"),
	/**
	 * pinch in event.
	 */
	PINCHIN("pinchin"),
	/**
	 * pinch out event.
	 */
	PINCHOUT("pinchout");

	private String text;

	EventType(String text) {
		this.text = text;
	}

	/**
	 * Get event type name.
	 *
	 * @return event type
	 *
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Create EventType by a given event name.
	 *
	 * @param text event name
	 *
	 * @return
	 */
	public static EventType fromString(String text) {
		if (text != null) {
			for (EventType b : EventType.values()) {
				if (text.equalsIgnoreCase(b.text)) {
					return b;
				}
			}
		}
		return null;
	}
}


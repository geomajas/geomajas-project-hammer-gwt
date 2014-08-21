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
 * Hammer GWT  direction type.
 *
 * @author Dosi Bingov
 *
 * @since 1.0.0
 */
@Api
public enum Direction {
	/**
	 * direction up.
	 */
	UP("up"),
	/**
	 * direction down.
	 */
	DOWN("down"),
	/**
	 * direction left.
	 */
	LEFT("left"),
	/**
	 * direction right.
	 */
	RIGHT("right");

	private String text;


	Direction(String text) {
		this.text = text;
	}


	/**
	 * Get direction type.
	 *
	 * @return
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Create hammer GTW Direction by a given direction type.
	 *
	 * @param type direction type
	 * @return {@link org.geomajas.hammergwt.client.event.Direction} object or null if
	 */
	public static Direction fromString(String type) {
		if (type != null) {
			for (Direction b : Direction.values()) {
				if (type.equalsIgnoreCase(b.text)) {
					return b;
				}
			}
		}
		return null;
	}
}


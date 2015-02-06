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
package org.geomajas.hammergwt.client.event;


import org.geomajas.annotation.Api;

/**
 * Hammer gwt pointer type.
 *
 * @author Dosi Bingov
 *
 * @since 1.0.0
 */
@Api
public enum PointerType {
	/**
	 * pointer type mouse.
	 */
	MOUSE("mouse"),
	/**
	 * pointer type touch.
	 */
	TOUCH("touch"),
	/**
	 * pointer type pen.
	 */
	PEN("pen"), ;

	private String text;

	PointerType(String text) {
		this.text = text;
	}

	/**
	 * Get pointer type.
	 *
	 * @return pointer type
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Create {@link PointerType} from a given type literal.
	 * @param text pointer type
	 *
	 * @return {@link PointerType}
	 */
	public static PointerType fromString(String text) {
		if (text != null) {
			for (PointerType b : PointerType.values()) {
				if (text.equalsIgnoreCase(b.text)) {
					return b;
				}
			}
		}
		return null;
	}
}


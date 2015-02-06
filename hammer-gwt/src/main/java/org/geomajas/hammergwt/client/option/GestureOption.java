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
package org.geomajas.hammergwt.client.option;


import org.geomajas.annotation.Api;

/**
 * Enum-like class that uniquely represents a gesture option of hammer gwt.
 * Define a static instance of this class for every gesture option.
 * 
 * @author Dosi Bingov
 * 
 * @param <T> Gesture Option type
 *
 * @since 1.0.0
 */
@Api
public class GestureOption<T> {

	private final String name;

	/**
	 * Create a gesture option with a given name.
	 *
	 * @param name of the gesture option
	 *
	 */
	public GestureOption(String name) {
		this.name = name;
	}

	/**
	 * Get the name gesture option. Uniqueness is not necessary as this is guaranteed by the class.
	 * 
	 * @return name gesture option name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get value as {@link java.lang.String}.
	 * @return {@link java.lang.String}
	 */
	public String getValue() {
		return String.valueOf(this);
	}
}

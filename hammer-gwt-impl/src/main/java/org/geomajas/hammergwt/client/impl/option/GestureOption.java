/*
 * This is part of Geomajas, a GIS framework, http://www.geomajas.org/.
 *
 * Copyright 2008-2014 Geosparc nv, http://www.geosparc.com/, Belgium.
 *
 * The program is available in open source according to the GNU Affero
 * General Public License. All contributions in this program are covered
 * by the Geomajas Contributors License Agreement. For full licensing
 * details, see LICENSE.txt in the project root.
 */
package org.geomajas.hammergwt.client.impl.option;


/**
 * Enum-like class that uniquely represents a gesture option. Define a static instance of this class for every gesture
 * option.
 * 
 * @author Dosi Bingov
 * 
 * @param <T> Gesture Option type
 *
 * @since 1.0.0
 */
public class GestureOption<T> {

	private final String name;

	/**
	 * Construct a gesture option with the following name.
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
	 * @return name Get the name of this gesture option.
	 */
	public String getName() {
		return name;
	}

	public String getValue() {
		return String.valueOf(this);
	}

}

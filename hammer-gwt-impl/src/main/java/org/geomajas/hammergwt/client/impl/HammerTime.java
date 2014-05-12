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

import com.google.gwt.core.client.JavaScriptObject;
import org.geomajas.hammergwt.client.impl.option.GestureOption;

/**
 * Hammer js overlay javascript  object.
 *
 * @author Dosi Bingov
 */
public final class HammerTime extends JavaScriptObject {

	protected HammerTime() {
	}

	private static native void setOption(HammerTime hammerTime, boolean value, String name) /*-{
		hammerTime.options[name] = value;
	}-*/;


	private static native void setOption(HammerTime hammerTime, double value, String name) /*-{
		hammerTime.options[name] = value;
	}-*/;

	private static native void setOption(HammerTime hammerTime, int value, String name) /*-{
		hammerTime.options[name] = value;
	}-*/;

	private static native void setOption(HammerTime hammerTime, String value, String name) /*-{
		hammerTime.options[name] = value;
	}-*/;

	public <T> void setOption(GestureOption<T> option, T value) {
		if (value == null) {
			throw new IllegalArgumentException("Null value passed.");
		}

		if (value instanceof Boolean) {
			setOption(this, (Boolean) value, option.getName());

		} else if (value instanceof Integer) {
			setOption(this, (Integer) value, option.getName());

		} else if (value instanceof  Double) {
			setOption(this, (Double) value, option.getName());

		} else if (value instanceof String) {
			setOption(this, String.valueOf(value), option.getName());
		}
	}
}
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

	private static final native void setOption(HammerTime hammerTime, boolean value, String name) /*-{
        hammerTime.options[name] = value;

    }-*/;


	private static final native void setOption(HammerTime hammerTime, double value, String name) /*-{
        hammerTime.options[name] = value;
    }-*/;

	private static final native void setOption(HammerTime hammerTime, int value, String name) /*-{
        hammerTime.options[name] = value;
    }-*/;

	private static final native void setOption(HammerTime hammerTime, String value, String name) /*-{
        hammerTime.options[name] = value;

         //if (typeof console == 'object') {
            //TODO: make logging more generic
         //   console.log('Swipe option ', hammerTime.options[name]);
		//	console.log('Hammer time object', hammerTime);
        //}
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
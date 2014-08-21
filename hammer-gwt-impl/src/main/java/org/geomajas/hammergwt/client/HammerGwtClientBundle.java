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
package org.geomajas.hammergwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Hammer Gwt client bundle.
 *
 * @author Dosi Bingov
 */
public interface HammerGwtClientBundle extends ClientBundle {

	HammerGwtClientBundle INSTANCE = GWT.create(HammerGwtClientBundle.class);

	/**
	 * Get minimized version of Hammer js.
	 *
	 * @return Javascript {@link TextResource}.
	 */
	@Source("hammerjs/hammer.min.js")
	TextResource hammerJs();

	/**
	 * Get source of Hammer js.
	 *
	 * @return  Javascript {@link TextResource}.
	 */
	@Source("hammerjs/hammer.js")
	TextResource hammerJsSrc();
}

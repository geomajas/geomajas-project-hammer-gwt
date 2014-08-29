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
package org.geomajas.hammergwt.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Hammer Gwt client bundle.
 *
 * @author Dosi Bingov
 */
public class HammerGwtResourceDebugImpl implements HammerGwtResource {

	@Override
	public String getHammerJsScript() {
		HammerJsResource hammerJs = GWT.create(HammerJsResource.class);

		return hammerJs.hammerJs().getText();
	}

	/**
	 * Gwt client bundle.
	 *
	 * @author Dosi Bingov
	 */
	interface HammerJsResource extends ClientBundle {

		/**
		 * Get source version of Hammer JS.
		 *
		 * @return Javascript {@link com.google.gwt.resources.client.TextResource}.
		 */
		@Source("org/geomajas/hammergwt/public/js/hammer.js")
		TextResource hammerJs();

	}

}
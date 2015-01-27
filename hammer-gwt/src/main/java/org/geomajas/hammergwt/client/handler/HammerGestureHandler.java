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
package org.geomajas.hammergwt.client.handler;

import org.geomajas.hammergwt.client.event.NativeHammerEvent;


/**
 * @author Dosi Bingov
 *
 * @since 1.0.0
 */
public interface HammerGestureHandler {
	void onGesture(NativeHammerEvent event);
}


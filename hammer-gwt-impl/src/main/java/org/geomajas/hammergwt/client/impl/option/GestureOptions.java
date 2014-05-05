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

import java.util.InputMismatchException;
import java.util.Map;

/**
 * Gesture options interface.
 * 
 * @author Dosi Bingov
 *
 *
 * @since 1.0.0
 */
public interface GestureOptions {


	/**
	 * use to indicate if hammer gwt should handle drag event.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> DRAG = new GestureOption<Boolean>("drag");


	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> PREVENT_DEFAULT = new GestureOption<Boolean>("prevent_default");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> DRAG_BLOCK_HORIZONTAL = new GestureOption<Boolean>("drag_block_horizontal");


	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> DRAG_BLOCK_VERTICAL = new GestureOption<Boolean>("drag_block_vertical");


	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> DRAG_LOCK_TO_AXIS = new GestureOption<Boolean>("drag_lock_to_axis");


	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> DRAG_MAX_TOUCHES = new GestureOption<Integer>("drag_max_touches");


	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> DRAG_MIN_DISTANCE = new GestureOption<Integer>("drag_min_distance");


	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> HOLD = new GestureOption<Boolean>("hold");


	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> HOLD_THRESHOLD = new GestureOption<Integer>("hold_threshold");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> HOLD_TIMEOUT = new GestureOption<Integer>("hold_threshold");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> PREVENT_MOUSEEVENTS = new GestureOption<Boolean>("prevent_mouseevents");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> RELEASE = new GestureOption<Boolean>("release");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> SHOW_TOUCHES = new GestureOption<Boolean>("show_touches");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> SWIPE = new GestureOption<Boolean>("swipe");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> SWIPE_MAX_TOUCHES = new GestureOption<Integer>("swipe_max_touches");


	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Double> SWIPE_VELOCITY = new GestureOption<Double>("swipe_velocity");



	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> TAP = new GestureOption<Boolean>("tap");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> TAP_ALWAYS = new GestureOption<Boolean>("tap_always");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> TAP_MAX_DISTANCE = new GestureOption<Integer>("tap_max_distance");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> DOUBLETAP_DISTANCE = new GestureOption<Integer>("doubletap_distance");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> DOUBLETAP_INTERVAL = new GestureOption<Integer>("doubletap_interval");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> TOUCH = new GestureOption<Boolean>("touch");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> TRANSFORM = new GestureOption<Boolean>("transform");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> TRANSFORM_ALWAYS_BLOCK = new GestureOption<Boolean>("transform_always_block");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> TRANSFORM_MIN_ROTATION = new GestureOption<Integer>("transform_min_rotation");

	/**
	 * If true prevents native browser event beahaviour.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Double> TRANSFORM_MIN_SCALE = new GestureOption<Double>("transform_min_scale");
}
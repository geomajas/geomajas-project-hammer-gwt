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
package org.geomajas.hammergwt.client.impl.option;

import org.geomajas.annotation.Api;

/**
 * Gesture options to change default hammer gwt settings.
 * 
 * @author Dosi Bingov
 *
 *
 * @since 1.0.0
 */
@Api
public interface GestureOptions {


	/**
	 * use to indicate if hammer gwt should handle drag event <b>Default true</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> DRAG = new GestureOption<Boolean>("drag");


	/**
	 * If true prevents native browser event beahaviour <b>Default false</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> PREVENT_DEFAULT = new GestureOption<Boolean>("prevent_default");

	/**
	 *  Drag block horizontal option  <b>Default false</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> DRAG_BLOCK_HORIZONTAL = new GestureOption<Boolean>("drag_block_horizontal");


	/**
	 * Drag block vertical option  <b>Default false</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> DRAG_BLOCK_VERTICAL = new GestureOption<Boolean>("drag_block_vertical");


	/**
	 * Drag lock to axis option  <b>Default false</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> DRAG_LOCK_TO_AXIS = new GestureOption<Boolean>("drag_lock_to_axis");


	/**
	 * Maximum touches while dragging.<b>Default value 1</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> DRAG_MAX_TOUCHES = new GestureOption<Integer>("drag_max_touches");


	/**
	 * Minimum distance that will cause drag event to fire.<b>Default value 10</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> DRAG_MIN_DISTANCE = new GestureOption<Integer>("drag_min_distance");


	/**
	 * Hold option <b>Default value true</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> HOLD = new GestureOption<Boolean>("hold");


	/**
	 * Hold threshold <b>Default value 2</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> HOLD_THRESHOLD = new GestureOption<Integer>("hold_threshold");

	/**
	 * Hold timeout <b>Default value 500</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> HOLD_TIMEOUT = new GestureOption<Integer>("hold_timeout");

	/**
	 * Should mouse events be prevented <b>Default false</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> PREVENT_MOUSEEVENTS = new GestureOption<Boolean>("prevent_mouseevents");

	/**
	 * Release option <b>Default value true</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> RELEASE = new GestureOption<Boolean>("release");

	/**
	 * Show touches option <b>Default true</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> SHOW_TOUCHES = new GestureOption<Boolean>("show_touches");

	/**
	 * Swipe option <b>Default true</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> SWIPE = new GestureOption<Boolean>("swipe");

	/**
	 * Maximum touches while swiping <b>Default value 1</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> SWIPE_MAX_TOUCHES = new GestureOption<Integer>("swipe_max_touches");


	/**
	 * Velocity while swiping <b>Default value 0.7</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Double> SWIPE_VELOCITY = new GestureOption<Double>("swipe_velocity");


	/**
	 * Tap option <b>Default value true</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> TAP = new GestureOption<Boolean>("tap");

	/**
	 * Tap always option <b>Default value true</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> TAP_ALWAYS = new GestureOption<Boolean>("tap_always");

	/**
	 * Maximum distance while tapping <b>Default value 10</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> TAP_MAX_DISTANCE = new GestureOption<Integer>("tap_max_distance");

	/**
	 * Maximum distance while double tapping <b>Default value 20</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> DOUBLETAP_DISTANCE = new GestureOption<Integer>("doubletap_distance");

	/**
	 * Maximum interval for double tap event to fire <b>Default value 300</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> DOUBLETAP_INTERVAL = new GestureOption<Integer>("doubletap_interval");

	/**
	 * Enable / disable touch option <b>Default true</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> TOUCH = new GestureOption<Boolean>("touch");

	/**
	 * Enable / disable transform option <b>Default true</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Boolean> TRANSFORM = new GestureOption<Boolean>("transform");


	/**
	 * Min rotation for transform event to fire <b>Default value 1</b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Integer> TRANSFORM_MIN_ROTATION = new GestureOption<Integer>("transform_min_rotation");

	/**
	 *  Min scale for transform event to fire <b>Default value 0.01 </b>.
	 *
	 * @since 1.0.0
	 */
	GestureOption<Double> TRANSFORM_MIN_SCALE = new GestureOption<Double>("transform_min_scale");
}
package org.geomajas.hammergwt.client.event;

/**
 * @author Dosi Bingov
 */
public enum EventType {
	TOUCH("touch"),
	RELEASE("release"),
	HOLD("hold"),
	TAP("tap"),
	DOUBLETAP("doubletap"),


	DRAGSTART("dragstart"),
	DRAG("drag"),
	DRAGEND("dragend"),
	DRAGLEFT("dragleft"),
	DRAGRIGHT("dragright"),
	DRAGUP("dragup"),
	DRAGDOWN("dragdown"),

	SWIPE("swipe"),
	SWIPELEFT("swipeleft"),
	SWIPEUP("swipeup"),
	SWIPEDOWN("swipedown"),


	TRANSFORMSTART("transformstart"),
	TRANSFORM("transform"),
	TRANSFORMEND("transformend"),
	ROTATE("rotate"),

	PINCH("pinch"),
	PINCHIN("pinchin"),
	PINCHOUT("pinchout");

	private String text;

	EventType(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static EventType fromString(String text) {
		if (text != null) {
			for (EventType b : EventType.values()) {
				if (text.equalsIgnoreCase(b.text)) {
					return b;
				}
			}
		}
		return null;
	}
}


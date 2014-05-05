package org.geomajas.hammergwt.client.event;


/**
 * @author Dosi Bingov
 */
public enum PointerType {
	MOUSE("mouse"),
	TOUCH("touch"),
	PEN("pen");

	private String text;

	PointerType(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static PointerType fromString(String text) {
		if (text != null) {
			for (PointerType b : PointerType.values()) {
				if (text.equalsIgnoreCase(b.text)) {
					return b;
				}
			}
		}
		return null;
	}
}


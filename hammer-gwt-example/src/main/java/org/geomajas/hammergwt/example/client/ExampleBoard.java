package org.geomajas.hammergwt.example.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import org.geomajas.hammergwt.client.impl.HammerWidget;


/**
 * @author Dosi Bingov
 */
public class ExampleBoard extends HammerWidget {
	AbsolutePanel panel;

	public ExampleBoard() {
		panel = new AbsolutePanel();
		panel.setWidth("100%");
		panel.setHeight("150px");
		panel.getElement().getStyle().setBackgroundColor("pink");
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}

# Hammer GWT

GWT library that provides multi touch and gestures support through [Hammer js](http://eightmedia.github.io/hammer.js/)

#### Getting Started

Look into example project [entry point](https://github.com/geomajas/geomajas-project-hammer-GWT/blob/master/hammer-GWT-example/src/main/java/org/geomajas/hammergwt/example/client/HammerGWTExample.java)

##### Inherit Hammer GTW module

```xml
<module rename-to="myGWTapp">

    <inherits name="com.google.GWT.user.User" />

    <!-- Hammer GWT module  -->
    <inherits name="org.geomajas.hammergwt.HammerGWT_Min" />

    <source path="client" />
</module>

```

##### Register hammer events to existing GWT widget

```java

IsWidget mywidget;

HammerTime hammerTime = HammerGWT.createInstance(mywidget);

// add hammer generic hammer handler
// Note that only tap and drag event are handled here
HammerGWTCallback hammerCallback = HammerGWT.on(hammerTime, new HammerHandler() {
    @Override
    public void onHammerEvent(NativeHammerEvent event) {
        event.preventDefault();
        event.preventNativeDefault();

        Element target = event.getTarget();

        switch (event.getType()) {
            case TAP:
                //do something on tap
                break;
            case DRAG:
            default:
                //do something on drag
                break;

        }
    }
}, EventType.TAP, EventType.DRAG);


```

##### Unregister hammer events

```java
//remove drag event of previously created HammerTime instance
HammerGWT.off(hammerTime, EventType.DRAG, hammerCallback);

```

##### Change initial setting of hammer GWT

```java

HammerTime hammerTime = HammerGWT.createInstance(mywidget);

		// Set hammer GWT options
		hammerTime.setOption(GestureOptions.HOLD_TIMEOUT, 2);
		// disable drag event detection of hammer GWT
		hammerTime.setOption(GestureOptions.DRAG, false);

```

##### Create Hammer GWT widget

```java

// to create hammer GWT widget you should  extend HammerWidget class
class HammerGWTExampleWidget extends HammerWidget {

		public HammerGWTExampleWidget() {
			super();
		}

		@Override
		public Widget createWidget() {
		    //create GWT widget
			SimplePanel panel = new SimplePanel();
			panel.setSize("100px", "200px");
			panel.getElement().setId("hammerWidget");

			return panel;
		}
	}

// create instance of hammer GWT widget

HammerGWTExampleWidget myHammerWidget = new HammerGWTExampleWidget();

//register tap handler
myHammerWidget.registerTapHandler(new HammerTapHandler() {
			@Override
			public void onTap(NativeHammerEvent event) {
				//do something on tap
			}
		});

//unregister tap event
hammerGWTWidget.unregisterEvent(EventType.TAP);
```

##### Build hammer GWT project

Hammer GWT is maven modular project. It consists of 3 projects:

+ Implementation project - hammer GWT wrapper implementation.

+ Example project - example code how to use hammer GWT .

+ Documentation project - documentation of hammer GWT.

To build the project you just need maven, the rest is all set up for you.

After you cloned hammer GWT from github go to the paren project and type

```
mvn clean install;

```

##### Start the example project

Go to the root of example project and type

```
cd example
mvn clean install jetty:run

```

### See also Hammer js [documentation](https://github.com/EightMedia/hammer.js/wiki)



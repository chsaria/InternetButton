package org.c02.iot.cloud.examples;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.behaviour.CountAndShowLed;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;

public class CountAndShowLedDemo {

	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId, DemoConstants.accessToken);
	static InternetButtonApi button = new InternetButtonImpl(api);
	
	public static void main(String[] args) {
		CountAndShowLed casled = new CountAndShowLed(button);
		casled.run();
	}

}

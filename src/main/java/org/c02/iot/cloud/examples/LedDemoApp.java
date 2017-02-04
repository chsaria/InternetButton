package org.c02.iot.cloud.examples;

import java.awt.Color;

import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;

public class LedDemoApp {

	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);
	
	public static void main(String[] args) throws ParticleException {
		
		InternetButtonImpl internetButton = new InternetButtonImpl(api);
		
		// TODO Auto-generated method stub
		internetButton.setLed(4, new Color(255255255));
		internetButton.allLedsOff();
	}

}

package org.c02.iot.cloud.examples;

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
		
		internetButton.playSound(); // Spielt einen melodie ab
	}

}

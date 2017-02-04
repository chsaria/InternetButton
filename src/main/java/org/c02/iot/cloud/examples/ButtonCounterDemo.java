package org.c02.iot.cloud.examples;

import java.awt.Color;

import org.c02.iot.InternetButtonImpl;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;

public class ButtonCounterDemo {

	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);
	
	public static void main(String[] args) throws ParticleException {
		
		InternetButtonImpl internetButton = new InternetButtonImpl(api);
		
		// TODO Auto-generated method stub

		System.out.println("North:"+internetButton.getButtonCounter(ButtonDirection.North));
		System.out.println("South:"+internetButton.getButtonCounter(ButtonDirection.South));
		System.out.println("East:"+internetButton.getButtonCounter(ButtonDirection.East));		
		System.out.println("West:"+internetButton.getButtonCounter(ButtonDirection.West));		
		internetButton.resetButtonCounters();
		
	}

}

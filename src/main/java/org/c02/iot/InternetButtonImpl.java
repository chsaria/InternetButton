package org.c02.iot;

import java.awt.Color;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;

public class InternetButtonImpl implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonImpl(ParticleApiWrapper wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public InternetButtonImpl(String deviceid, String accesstoken) {
		// TODO Auto-generated constructor stub
	}

	public int getButtonCounter(ButtonDirection button) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLed(int postition, Color color) {
		// TODO Auto-generated method stub
	}

	public void allLedsOff() {
		// TODO Auto-generated method stub

	}

	public void playSound() {
		try {
			wrapper.callMethod("play",null);  // Spielt einen melodie ab
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	public void resetButtonCounters() {
		// TODO Auto-generated method stub
		
	}

}

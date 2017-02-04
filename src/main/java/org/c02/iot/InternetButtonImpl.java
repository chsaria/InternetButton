package org.c02.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;

public class InternetButtonImpl implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonImpl(ParticleApiWrapper wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonCounter(ButtonDirection button) {
		
		String buttonName = null;
		
		switch (button) {
		
		case North:
			buttonName = "countButton1";
			break;
		case East:
			buttonName = "countButton3";
			break;
		case South:
			buttonName = "countButton2";
			break;
		case West:	
			buttonName = "countButton4";
			break;
		};

		
		// TODO Auto-generated method stub
		try {
			return wrapper.readVariable(buttonName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return 0;

	}

	public void setLed(int postition, Color color) {
		// TODO Auto-generated method stub
		
		String input = "";
		String pos = "";
		
		if( postition < 10){
			
			pos = "0"+ postition;
		
		}else{
				pos = postition + "";
		}
			
		
		input = pos + color.getRGB();

		// nn = Position 01-12
		// rrr = rot
		// ggg = grün
		// bbb = blau
		//                    nnrrrgggbbb
		try {
			wrapper.callMethod("led",input);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void allLedsOff() {
		// TODO Auto-generated method stub

		try {
			wrapper.callMethod("ledsOff",null);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //Schaltet die LEDs aus		
		
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

		try {
			wrapper.callMethod("reset",null);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}

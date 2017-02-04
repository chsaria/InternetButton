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
			
		
	    Integer red= color.getRed();
	    Integer green = color.getGreen();
	    Integer blue = color.getBlue();
	    String strRed = red.toString();
	    String strGreen = green.toString();
	    String strBlue = blue.toString();
	    if(blue < 10)
	    	strBlue = "00" + strBlue;
	    else if(blue < 100)
	    	strBlue = "0" + strBlue;
	    if(red < 10)
	    	strRed = "00" + strRed;
	    else if(red < 100)
	    	strRed = "0" + strRed;
	    if(green < 10)
	    	strGreen = "00" + strGreen;
	    else if(green < 100)
	    	strGreen = "0" + strGreen;
	    	
		input = pos + strRed + strGreen + strBlue;//color.getRGB();

		// nn = Position 01-12
		// rrr = rot
		// ggg = grün
		// bbb = blau
		//                    nnrrrgggbbb
		
		System.out.println("Color: "+input);
		
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

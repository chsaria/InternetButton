package org.c02.iot.behaviour;

import java.awt.Color;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.ButtonDirection;

public class CountAndShowLed extends AbstractBehaviour {

	public CountAndShowLed(InternetButtonApi buttonInstance) {
		super(buttonInstance);
	}
	
	@Override
	public void run() {
		while (true)
			setLedToButtonClicks();
	}
	
	public void setLedToButtonClicks()
	{
		button.allLedsOff();
		int buttonCounter = button.getButtonCounter(ButtonDirection.North);
		System.out.println("Counter: "+buttonCounter%12);
		for (int i = 1; i <= buttonCounter%12; i++) {
			System.out.println("i: "+i);
			System.out.println(buttonCounter);
			button.setLed(i, Color.GREEN);
		}
	}

}

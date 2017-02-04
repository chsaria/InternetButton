package org.c02.iot.behaviour.test;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonImpl;
import org.c02.iot.behaviour.CountAndShowLed;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;
import org.junit.Test;
import org.mockito.Mockito;

public class InternetButtonImplTest {

	static ParticleApiWrapper api = Mockito.mock(ParticleApiWrapperImpl.class);
	
	//
	
	private InternetButtonImpl button = new  InternetButtonImpl(api);
	
	@Test
	public void testResetButtonCounters() throws ParticleException{
		
		button.resetButtonCounters();
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("reset",null);;
		
	}
	
	@Test
	public void testGetButtonCounter() throws IOException {
	
		button.getButtonCounter(ButtonDirection.North);
		button.getButtonCounter(ButtonDirection.East);
		button.getButtonCounter(ButtonDirection.South);
		button.getButtonCounter(ButtonDirection.West);
		Mockito.verify(api, Mockito.atLeastOnce()).readVariable("countButton1");
		Mockito.verify(api, Mockito.atLeastOnce()).readVariable("countButton2");
		Mockito.verify(api, Mockito.atLeastOnce()).readVariable("countButton3");
		Mockito.verify(api, Mockito.atLeastOnce()).readVariable("countButton4");
	}
	
	@Test
	public void testSetLed() throws ParticleException {
		
		button.setLed(1, Color.RED);
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("led", "01255000000");
	}

	@Test
	public void testAllLedsOff() throws ParticleException {
		button.allLedsOff();
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("ledsOff",null);
	}

	@Test
	public void testPlaySound() throws ParticleException {

		button.playSound();
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("play",null);
		
	}
	
	@Test
	public void testCountAndShowLed() throws IOException, ParticleException{
		Mockito.when(api.readVariable("countButton1")).thenReturn(5);
		CountAndShowLed countAndShow = new CountAndShowLed(button);
		countAndShow.setLedToButtonClicks();
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("ledsOff",null);
		Mockito.verify(api, Mockito.atLeastOnce()).readVariable("countButton1");
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("led", "01000255000");
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("led", "02000255000");
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("led", "03000255000");
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("led", "04000255000");
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("led", "05000255000");
	}
	
}

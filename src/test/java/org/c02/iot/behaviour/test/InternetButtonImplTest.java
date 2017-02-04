package org.c02.iot.behaviour.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.c02.iot.InternetButtonImpl;
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
	public void testGetButtonCounter() {
	
	}
	
	@Test
	public void testSetLed() throws ParticleException {
		
		button.setLed(1, Color.RED);
		Mockito.verify(api, Mockito.atLeastOnce()).callMethod("led", "1"+ Integer.toString(Color.RED.getRGB()));
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

}

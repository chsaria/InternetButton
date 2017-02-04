package org.c02.iot.behaviour.test;

import static org.junit.Assert.*;

import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;
import org.junit.Test;
import org.mockito.Mockito;

public class InternetButtonImplTest {

	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);	
	
	private InternetButtonImpl internetButton = Mockito.mock(InternetButtonImpl.class);
		
	
	@Test
	public void testSetLed() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testAllLedsOff() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlaySound() {
	
		internetButton.playSound();
		
	}

}

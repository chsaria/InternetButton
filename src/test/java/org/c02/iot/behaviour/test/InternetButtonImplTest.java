package org.c02.iot.behaviour.test;

import static org.junit.Assert.*;

import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class InternetButtonImplTest {

	static ParticleApiWrapper api = Mockito.mock(ParticleApiWrapperImpl.class);
	
	//
	
	private InternetButtonImpl internetButton = new  InternetButtonImpl(api);
		
	
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

		
	}

}

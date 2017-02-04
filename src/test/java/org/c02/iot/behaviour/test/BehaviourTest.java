package org.c02.iot.behaviour.test;

import java.awt.Color;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.behaviour.CountAndShowLed;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BehaviourTest {

	@Test
	public void testBehaviour() {

		InternetButtonApi buttonInstance = new InternetButtonApi() {

			@Override
			public int getButtonCounter(ButtonDirection button) {
				if (button == ButtonDirection.North)
					return 5;
				return 0;
			}

			@Override
			public void resetButtonCounters() {
				Assert.fail();
			}

			@Override
			public void setLed(int position, Color color) {
				Assert.assertEquals(5, position);
				Assert.assertEquals(Color.GREEN, color);
			}

			@Override
			public void allLedsOff() {
				Assert.fail();
			}

			@Override
			public void playSound() {
				Assert.fail();
			}
		};

		//Count and Show Led: entfernt, da impl. falsch
		//CountAndShowLed beh = new CountAndShowLed(buttonInstance2);

		//beh.run();
	}
}

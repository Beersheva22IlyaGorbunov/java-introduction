import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class IsraelIdentityTest {
	@Test
	void verifyTest() {
		assertTrue(IsraelIdentity.verify(123456782));
	}
	
	@Test
	void generateRandomIdTest() {
		for (int i = 0; i < 20; i++) {
			assertTrue(IsraelIdentity.verify(IsraelIdentity.generateRandomId()));
		}
	}
}

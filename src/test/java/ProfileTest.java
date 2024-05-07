

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.Start;


public class ProfileTest {

	Organizer o;

	void setUp() throws Exception {
		Profile x = o.createProfile("johndoe");
			
	}
	
	@Test
	void testProfile() {
		
		Profile x = o.createProfile("johndoe");
		System.out.println(x);
		//System.out.println(o.profileList.get(0).name);
		assertEquals(o.profileList.get(0).name, "johndoe", "username should match expected value");
		
	}
		
}
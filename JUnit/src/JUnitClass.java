import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JUnitClass {
	@Test
	
	public void SetUp(){
		String str = "klh";
		String str1 = "klh";
		String str2 = "edu";
		String str3 = null;
		String str4 = "edu";
		int val = 5;
		int val1 = 7;
		String[] expectedArray = {"one","two","three"};
		String[] resultArray = {"one","two","three"};
		
		//assertEquals: checks whether two primitives/objects/strings are same
		assertEquals(str,str1);
		//assertTrue: checks the condition is true or not
		assertTrue(val<val1);
		//assertFalse: checks the condition is false or not
		assertFalse(val>val1);
		//assertNull: checks whether the value is null or not
		assertNull(str3);
		//assertNotNull: checks whether the value is not null or not
		assertNotNull(str);
		//assertArrayEquals: compares if both the arrays are equal or not
		assertArrayEquals(expectedArray,resultArray);
		//assertSame: compares using reference and checks whether same or not
		assertSame(str2,str4);		
		//assertNotSame:
		assertNotSame(str1,str2);
	}
	

	

}

package com.testcase;

//package com.testcase;

import static org.junit.Assert.*;
import com.logic.*;
import com.logic.Calculation;

import org.junit.Test;

public class TestLogic {

	@Test
	public void testFindMax(){
		assertEquals(4,Calculation.findMax(new int[]{1,3,4,2}));
		//assertEquals(-2,Calculation.findMax(new int[]{-12,-3,-4,-2}));
	}
}

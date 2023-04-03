package com.practice;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
	public void test1() {
		System.out.println("-----TestScript_01");
		System.out.println("-----TestScript_02");
		assertEquals("tyss", "qsp");
		System.out.println("-----TestScript_03");
	}
	
	
	@Test
	public void test2() {
		int i=10;
		System.out.println("-----TestScript_04");
		System.out.println("-----TestScript_05");
		assertNull(i);
		System.out.println("-----TestScript_06");
	}

}

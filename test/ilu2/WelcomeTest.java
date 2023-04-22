package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void test_EX1() {
		assertEquals(Welcome.welcome("Bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("paul"), "Hello, Paul");
	}
	
	@Test
	void test_EX2() {
		assertEquals(Welcome.welcome(null), "Hello, my friend");
		assertEquals(Welcome.welcome(""), "Hello, my friend");
		assertEquals(Welcome.welcome("      "), "Hello, my friend");
	}
	
	@Test
	void test_EX3() {
		assertEquals(Welcome.welcome("JERRY"), "HELLO, JERRY !");
		assertEquals(Welcome.welcome("BOB"), "HELLO, BOB !");
	}
	
	@Test
	void test_EX4() {
		assertEquals(Welcome.welcome("Amy,Bob"), "Hello, Amy and Bob");
		assertEquals(Welcome.welcome("amy,Bob"), "Hello, Amy and Bob");
		assertEquals(Welcome.welcome("amy,bob"), "Hello, Amy and Bob");
	}
	
	@Test
	void test_EX5() {
		assertEquals(Welcome.welcome("Amy,bob,jerry"), "Hello, Amy, Bob and Jerry");
		assertEquals(Welcome.welcome("Jerry,amy,Bob,Paul,tom"), "Hello, Jerry, Amy, Bob, Paul and Tom");
	}
	
	@Test
	void test_EX6() {
		assertEquals(Welcome.welcome("Amy,BOB,jerry"), "Hello, Amy and Jerry. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("JERRY,amy,Bob,PAUL,tom"), "Hello, Amy, Bob and Tom. AND HELLO, JERRY AND PAUL !");
		assertEquals(Welcome.welcome("AMY,BOB"), "HELLO, AMY AND BOB !");
	}
	
	@Test
	void test_EX7() {
		assertEquals(Welcome.welcome("Amy,BOB,jerry"), "Hello, Amy and Jerry. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("JERRY,amy,Bob,PAUL,tom"), "Hello, Amy, Bob and Tom. AND HELLO, JERRY AND PAUL !");
		assertEquals(Welcome.welcome("tom,AMY,BOB"), "Hello, Tom. AND HELLO, AMY AND BOB !");
	}
	
	@Test
	void test_EX8() {
		assertEquals(Welcome.welcome("Amy     ,bob"), "Hello, Amy and Bob");
		assertEquals(Welcome.welcome("JERRY    ,   amy,Bob"), "Hello, Amy and Bob. AND HELLO, JERRY !");
		
	}
	
	@Test
	void test_EX9() {
		assertEquals(Welcome.welcome("Amy,bob,bob,bob"), "Hello, Amy and Bob (x3)");
		assertEquals(Welcome.welcome("JERRY,Amy,JERRY,bob,JERRY,bob"), "Hello, Amy and Bob (x2). AND HELLO, JERRY (X3) !");
		assertEquals(Welcome.welcome("JERRY    ,   amy,JERRY,Bob"), "Hello, Amy and Bob. AND HELLO, JERRY (X2) !");
		
	}
	
	

}

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
		assertEquals(Welcome.welcome("Amy,Bob"), "Hello, Amy, Bob");
		assertEquals(Welcome.welcome("amy,Bob"), "Hello, Amy, Bob");
		assertEquals(Welcome.welcome("amy,bob"), "Hello, Amy, Bob");
	}
	
	@Test
	void test_EX5() {
		assertEquals(Welcome.welcome("Amy,bob,jerry"), "Hello, Amy, Bob, Jerry");
		assertEquals(Welcome.welcome("Jerry,amy,Bob,Paul,tom"), "Hello, Jerry, Amy, Bob, Paul, Tom");
	}

}

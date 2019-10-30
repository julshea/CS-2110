import java.awt.Color;

import turtle.Turtle;
import turtle.World;

/**
 * Homework 6
 * 
 * Implement the following methods on recursion
 * as defined in the homework 6 document.
 * 
 * @author jts6mq
 *
 */
public class Recursion {
	
	public static String reverseString(String s) {
		//base case is when the string is empty, so check this first
		if(s.isEmpty()) {
			return s;
		}
		/**
		 *if s isn't empty, take a substring of all indices except for the first
		 *place the first character of s at the end of the substring
		 *repeat this until the original string s is empty
		 */
		else {
			return reverseString(s.substring(1))+s.charAt(0);
		}
	}
	
	public static long Ackermann(long m, long n) {
		//function written out using the first condition as a base case, and copying the given function from there
		if(m < 0 || n < 0) {
			return 0;
		}
		if(m == 0) {
			return n + 1;
		}
		else if(m > 0 && n == 0) {
			return Ackermann(m - 1, 1);
		}
		else {
			return Ackermann(m - 1, Ackermann(m, n-1));
		}
	}
	
	public static int handshakes(int n) {
		//base case
		if(n == 1) {
			return 0;
		}
		//another base case
		else if(n == 2) {
			return 1;
		}
		else {
			return handshakes(n-1) + n-1;
		}
	}
	
	public static void snowflake(Turtle t, int n, double size) {
		
		if(n == 0) {
			t.forward(size);
		}
		else
        {
            snowflake(t, n-1, size);
            t.left(60);
            snowflake(t, n-1, size);
            t.right(120);
            snowflake(t, n-1, size);
            t.left(60);
            snowflake(t, n-1, size);
        }
	}

	
	
	public static void main(String[] args) {
		//tests for the reverse string method
		System.out.println(reverseString("Hello, World!"));
		System.out.println(reverseString("javaisfun"));
		
		//tests for the ackermann method--figure out how to implement try/catch clause
		System.out.println(Ackermann(4, -1));
		System.out.println(Ackermann(2, 1));

		
		//tests for the handshakes method
		System.out.println(handshakes(20));
		System.out.println(handshakes(2110));
		
//		 Note: for snowflake, you must create the turtle and world:
		//test for the snowflake method
		World myWorld = new World(900,900,Color.WHITE);
		Turtle bob = new Turtle(myWorld);
		bob.setDelay(0);
		for (int i = 0; i < 3; i++) {
		    snowflake(bob, 3, 12.0);
		    bob.right(120);
		}

	}
	
}

	
















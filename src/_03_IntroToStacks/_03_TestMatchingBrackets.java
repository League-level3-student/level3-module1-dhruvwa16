package _03_IntroToStacks;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character> brackets = new Stack<Character>();
			int i;
			i = b.length();
			for (int j = 0; j < i; j++) {
				brackets.push(b.charAt(j));
			}
			int open = 0;
			int close = 0;
			for (Character c:brackets) {
				if(c == '{') {
					open++;
				}
				else {
					close++;
				}
			}

		if(open == close && brackets.get(0) == '{') {
			return true;
		}
		else {
		return false;
		}

}
	
	
	
}
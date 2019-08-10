package invaders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ParserTest {
	@Test
    void testNoInput() throws Exception {
		char[][] output = Parser.readInput(null);
        assertEquals(null, output);
    }
	
	@Test
    void testEmptyPath() throws Exception {
		char[][] output = Parser.readInput("");
		assertEquals(null, output);
    }
	
	@Test
    void testEmptyInput() throws Exception {
		char[][] output = Parser.readInput("EmptyInput.txt");
		assertEquals(null, output);
    }
	
	@Test
    void testInput() throws Exception {
		char[][] output = Parser.readInput("input1.txt");
		assertEquals(50, output.length);
		assertEquals(100, output[0].length);
    }
	
	@Test
    void testReadInvaders() throws Exception {
		List<char[][]> output = Parser.readInvaders();
		assertEquals(2, output.size());
    }
}

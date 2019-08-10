package invaders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DetectInvadersTest {
	@Test
    void testInputDefaultTreshold() throws Exception {
        int detectedInvaders = DetectInvaders.detect(Parser.readInput("input1.txt"), Parser.readInvaders());
        assertEquals(5, detectedInvaders);
	}
	
	@Test
    void testInputWith80Treshold() throws Exception {
		int detectedInvaders = DetectInvaders.detect(Parser.readInput("input1.txt"), Parser.readInvaders(), 80);
        assertEquals(6, detectedInvaders);
    }
	
	@Test
    void testInputWith0Treshold() throws Exception {
		int detectedInvaders = DetectInvaders.detect(Parser.readInput("input1.txt"), Parser.readInvaders(), 0);
		assertTrue(detectedInvaders > 1000);
    }
	
	@Test
    void testInputWith100Treshold() throws Exception {
		int detectedInvaders = DetectInvaders.detect(Parser.readInput("input1.txt"), Parser.readInvaders(), 100);
		assertEquals(0, detectedInvaders);
    }
	
	@Test
    void testExactInvader1() throws Exception {
		int detectedInvaders = DetectInvaders.detect(Parser.readInput("inputExactInvader1.txt"), Parser.readInvaders());
		assertEquals(1, detectedInvaders);
    }
	
	@Test
    void testExactInvader2() throws Exception {
		int detectedInvaders = DetectInvaders.detect(Parser.readInput("inputExactInvader2.txt"), Parser.readInvaders());
		assertEquals(1, detectedInvaders);
    }

}

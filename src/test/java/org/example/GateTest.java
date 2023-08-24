package org.example;

import org.junit.jupiter.api.Test;

import static org.example.ANDGate.and;
import static org.example.NANDGate.nand;
import static org.example.NORGate.nor;
import static org.example.ORGate.or;
import static org.example.XORGate.xor;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The GateTest class contains test methods for various logic gates and circuits.
 */
class GateTest {

    /**
     * Tests the NAND gate logic.
     * Asserts the expected outputs of the NAND gate for different input combinations.
     */
    @Test
    void testNANDGate() {
        assertTrue(nand(false, false));
        assertTrue(nand(false, true));
        assertTrue(nand(true, false));
        assertFalse(nand(true, true));
    }

    /**
     * Tests the AND gate logic.
     * Asserts the expected outputs of the AND gate for different input combinations.
     */
    @Test
    void testANDGate() {
        assertFalse(and(false, false));
        assertFalse(and(false, true));
        assertFalse(and(true, false));
        assertTrue(and(true, true));
    }

    /**
     * Tests the OR gate logic.
     * Asserts the expected outputs of the OR gate for different input combinations.
     */
    @Test
    void testORGate() {
        assertFalse(or(false, false));
        assertTrue(or(false, true));
        assertTrue(or(true, false));
        assertTrue(or(true, true));
    }

    /**
     * Tests the NOR gate logic.
     * Asserts the expected outputs of the NOR gate for different input combinations.
     */
    @Test
    void testNORGate() {
        assertTrue(nor(false, false));
        assertFalse(nor(false, true));
        assertFalse(nor(true, false));
        assertFalse(nor(true, true));
    }

    /**
     * Tests the XOR gate logic.
     * Asserts the expected outputs of the XOR gate for different input combinations.
     */
    @Test
    void testXORGate() {
        assertFalse(xor(false, false));
        assertTrue(xor(false, true));
        assertTrue(xor(true, false));
        assertFalse(xor(true, true));
    }

    /**
     * Tests the behavior of the GatedDLatch class.
     * The method sets input values and verifies the latch's output based on different scenarios.
     */
    @Test
    void testGatedDLatch() {
        GatedDLatch latch = new GatedDLatch();

        // Test when D and E are true, output Q should be true
        latch.setInD(true);
        latch.setInE(true);
        assertTrue(latch.getOutQ(), "Output Q should be true when D and E are true");

        // Test when E is false, output Q should remain true
        latch.setInE(false);
        assertTrue(latch.getOutQ(), "Output Q should remain true when E is false");

        // Test when D is false and E is true, output Q should become false
        latch.setInD(false);
        latch.setInE(true);
        assertFalse(latch.getOutQ(), "Output Q should become false when D is false and E is true");

        // Test when E is false, output Q should remain false
        latch.setInE(false);
        assertFalse(latch.getOutQ(), "Output Q should remain false when E is false");

        // Test when D is true, output Q should remain false
        latch.setInD(true);
        assertFalse(latch.getOutQ(), "Output Q should remain false when D is true");

        // Test when D and E are false, output Q should remain false
        latch.setInD(false);
        latch.setInE(false);
        assertFalse(latch.getOutQ(), "Output Q should remain false when D and E are false");

        // Test when D is false and E is true, output Q should remain false
        latch.setInD(false);
        latch.setInE(true);
        assertFalse(latch.getOutQ(), "Output Q should remain false when D is false and E is true");

        // Test when D and E are true, output Q should become true again
        latch.setInD(true);
        latch.setInE(true);
        assertTrue(latch.getOutQ(), "Output Q should become true when D and E are true");
    }

    /**
     * Tests the behavior of the MasterSlaveDFlipFlop class.
     * The method simulates clock pulses and verifies the flip-flop's output based on input values.
     */
    @Test
    void testMasterSlaveDFlipFlop() {
        MasterSlaveDFlipFlop masterSlaveDFlipFlop = new MasterSlaveDFlipFlop();

        // Latch data on the rising edge, output should be true
        masterSlaveDFlipFlop.setInD(true);
        masterSlaveDFlipFlop.setInCLK(true);
        assertTrue(masterSlaveDFlipFlop.getOutQ(), "Output should be true after latching data");

        // Latched data becomes the output on the falling edge
        masterSlaveDFlipFlop.setInCLK(false);
        masterSlaveDFlipFlop.setInD(false);
        assertTrue(masterSlaveDFlipFlop.getOutQ(), "Output should remain true after falling edge");

        // Latch data on the falling edge (CLK low), output should remain true
        masterSlaveDFlipFlop.setInD(false);
        masterSlaveDFlipFlop.setInCLK(false);
        assertTrue(masterSlaveDFlipFlop.getOutQ(), "Output should remain true when CLK is low");

        // No change when CLK = 1
        masterSlaveDFlipFlop.setInD(true);
        masterSlaveDFlipFlop.setInCLK(true);
        assertTrue(masterSlaveDFlipFlop.getOutQ(), "Output should remain true on rising CLK edge");

        // No change when CLK = 0
        masterSlaveDFlipFlop.setInD(true);
        masterSlaveDFlipFlop.setInCLK(false);
        assertTrue(masterSlaveDFlipFlop.getOutQ(), "Output should remain true on falling CLK edge");

        // Latch data on the rising edge, output should change to false
        masterSlaveDFlipFlop.setInD(false);
        masterSlaveDFlipFlop.setInCLK(true);
        assertFalse(masterSlaveDFlipFlop.getOutQ(), "Output should change to false after latching data");

        // Latched data becomes the output on the rising edge
        masterSlaveDFlipFlop.setInD(false);
        masterSlaveDFlipFlop.setInCLK(true);
        assertFalse(masterSlaveDFlipFlop.getOutQ(), "Output should remain false on rising CLK edge");

        // Latch data on the falling edge (CLK low), output should remain false
        masterSlaveDFlipFlop.setInCLK(false);
        masterSlaveDFlipFlop.setInD(true);
        assertFalse(masterSlaveDFlipFlop.getOutQ(), "Output should remain false after falling edge");
    }

    /**
     * Tests the behavior of the BinaryCounter class for one-bit counting.
     * The method simulates clock pulses and verifies the counter's output based on input values.
     */
    @Test
    void testOneBitCounter() {
        BinaryCounter counter = new BinaryCounter();

        counter.setInCLK(false);    // Set clock to low
        assertFalse(counter.getOutQ(), "Initial state must be false");

        counter.setInCLK(false);    // No change on falling edge
        assertFalse(counter.getOutQ(), "No change on falling edge");

        counter.setInCLK(true);     // Rising edge, count changes to true
        assertTrue(counter.getOutQ(), "Count should change to true on rising edge");

        counter.setInCLK(false);    // Falling edge, count remains true
        assertTrue(counter.getOutQ(), "Count should remain true after rising edge");

        counter.setInCLK(true);     // Rising edge, count changes to false
        assertFalse(counter.getOutQ(), "Count should change to false on rising edge");

        counter.setInCLK(false);    // Falling edge, count remains false
        assertFalse(counter.getOutQ(), "Count should remain false after rising edge");

        counter.setInCLK(true);     // Rising edge, count changes to true
        assertTrue(counter.getOutQ(), "Count should change to true on rising edge");

        counter.setInCLK(true);     // No change on rising edge
        assertTrue(counter.getOutQ(), "No change on rising edge");

        counter.setInCLK(false);    // Falling edge, count remains true
        assertTrue(counter.getOutQ(), "Count should remain true after rising edge");
    }

    /**
     * Tests the behavior of the FourBitBinaryCounter class.
     * The method simulates clock pulses and compares the counter output with expected values.
     */
    @Test
    public void testFourBitBinaryCounter() {
        FourBitBinaryCounter counter = new FourBitBinaryCounter();

        boolean inCLK = true;

        boolean[][] expectedCounts = {
                {false, false, false, false},
                {false, false, false, false},
                {true, false, false, false},
                {true, false, false, false},
                {false, true, false, false},
                {false, true, false, false},
                {true, true, false, false},
                {true, true, false, false},
                {false, false, true, false},
                {false, false, true, false},
                {true, false, true, false},
                {true, false, true, false},
                {false, true, true, false},
                {false, true, true, false},
                {true, true, true, false},
                {true, true, true, false},
                {false, false, false, true},
                {false, false, false, true},
                {true, false, false, true},
                {true, false, false, true},
        };

        for (int i = 0; i < expectedCounts.length; i++) {
            counter.setInCLK(inCLK); // Simulate clock pulse
            boolean[] actualCount = counter.getCount();
            assertArrayEquals(expectedCounts[i], actualCount, "Count mismatch at step " + i);
            inCLK = !inCLK;
        }
    }
}
package org.example;

import static org.example.NANDGate.nand;

/**
 * The ANDGate class provides a static method to simulate the behavior of an AND gate.
 * An AND gate returns the logical AND operation between two inputs.
 */
public class ANDGate {
    /**
     * Simulates an AND gate operation.
     *
     * @param inA The first input boolean value.
     * @param inB The second input boolean value.
     * @return The result of the AND gate operation.
     *         Returns true if both inA and inB are true, otherwise returns false.
     */
    public static boolean and(boolean inA, boolean inB) {
        boolean outQ = nand(inA, inB);
        return nand(outQ, outQ);
    }
}

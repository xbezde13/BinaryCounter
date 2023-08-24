package org.example;

import static org.example.NANDGate.nand;

/**
 * The ORGate class provides a static method to simulate the behavior of an OR gate.
 * An OR gate returns the logical OR operation between two inputs.
 */
public class ORGate {
    /**
     * Simulates an OR gate operation.
     *
     * @param inA The first input boolean value.
     * @param inB The second input boolean value.
     * @return The result of the OR gate operation.
     *         Returns true if either inA or inB is true, or both are true. Returns false if both inA and inB are false.
     */
    public static boolean or(boolean inA, boolean inB) {
        return nand(nand(inA, inA), nand(inB, inB));
    }
}

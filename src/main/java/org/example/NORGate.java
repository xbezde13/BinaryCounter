package org.example;

import static org.example.NANDGate.nand;

/**
 * The NORGate class provides a static method to simulate the behavior of a NOR gate.
 * A NOR gate returns the negation of the logical OR operation between two inputs.
 */
public class NORGate {
    /**
     * Simulates a NOR gate operation.
     *
     * @param inA The first input boolean value.
     * @param inB The second input boolean value.
     * @return The result of the NOR gate operation.
     *         Returns true if both inA and inB are false, otherwise returns false.
     */
    public static boolean nor(boolean inA, boolean inB) {
        boolean outQ = nand(nand(inA, inA), nand(inB, inB));
        return nand(outQ, outQ);
    }
}

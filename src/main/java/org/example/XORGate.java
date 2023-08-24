package org.example;

import static org.example.NANDGate.nand;

/**
 * The XORGate class provides a static method to simulate the behavior of an XOR gate.
 * An XOR gate returns the exclusive OR operation between two inputs.
 */
public class XORGate {
    /**
     * Simulates an XOR gate operation.
     *
     * @param inA The first input boolean value.
     * @param inB The second input boolean value.
     * @return The result of the XOR gate operation.
     *         Returns true if inputs are different (one is true, the other is false).
     *         Returns false if both inputs are the same (both true or both false).
     */
    public static boolean xor(boolean inA, boolean inB) {
        boolean nand1 = nand(inA, inB);
        boolean nand2 = nand(inA, nand1);
        boolean nand3 = nand(inB, nand1);
        return nand(nand2, nand3);
    }
}

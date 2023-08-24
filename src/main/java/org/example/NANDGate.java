package org.example;

/**
 * The NANDGate class provides a static method to simulate the behavior of a NAND gate.
 * A NAND gate returns the negation of the logical AND operation between two inputs.
 */
public class NANDGate {
    /**
     * Simulates a NAND gate operation.
     *
     * @param inA The first input boolean value.
     * @param inB The second input boolean value.
     * @return The result of the NAND gate operation.
     *         Returns true if either inA or inB is false, and false only if both inA and inB are true.
     */
    public static boolean nand(boolean inA, boolean inB) {
        return !(inA && inB);
    }
}

package org.example;

import static org.example.NANDGate.nand;

/**
 * The GatedDLatch class models a gated D latch using NAND gates.
 * A D latch is a digital circuit that stores one bit of data.
 */
public class GatedDLatch {

    private boolean outQ = false;   // The output Q of the latch.
    private boolean outQNot = true; // The complement of output Q.

    private boolean inD = false;    // The data input.
    private boolean inE = false;    // The enable input.

    /**
     * Calculates the output values of the D latch based on input values.
     */
    private void calc() {
        boolean nand1 = nand(inD, inE);
        boolean nand2 = nand(inE, nand1);
        outQNot = nand(nand2, outQ);
        outQ = nand(nand1, outQNot);
    }

    /**
     * Sets the data input and recalculates the latch outputs.
     *
     * @param inD The new data input value.
     */
    public void setInD(boolean inD) {
        this.inD = inD;
        calc();
    }

    /**
     * Sets the enable input and recalculates the latch outputs.
     *
     * @param inE The new enable input value.
     */
    public void setInE(boolean inE) {
        this.inE = inE;
        calc();
    }

    /**
     * Retrieves the value of the Q output.
     *
     * @return The value of the Q output.
     */
    public boolean getOutQ() {
        return outQ;
    }

    /**
     * Retrieves the value of the complement of the Q output (QNot).
     *
     * @return The value of the QNot output.
     */
    public boolean getOutQNot() {
        return outQNot;
    }
}
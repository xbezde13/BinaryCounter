package org.example;

/**
 * The FourBitBinaryCounter class models a four-bit binary counter using BinaryCounters.
 * The counter increments its value on each clock pulse.
 */
public class FourBitBinaryCounter {

    private final boolean[] count = new boolean[4];        // The four-bit count array.
    private final BinaryCounter[] binaryCounters = new BinaryCounter[4]; // Array of BinaryCounters.
    private boolean inCLK;                                  // The clock input.

    /**
     * Constructs a new instance of the FourBitBinaryCounter class.
     * Initializes the binary counters and the count array.
     */
    public FourBitBinaryCounter() {
        for (int i = 0; i < 4; i++) {
            binaryCounters[i] = new BinaryCounter();
            count[i] = false;
        }
    }

    /**
     * Calculates the output values of the four-bit binary counter based on input values.
     * The counter increments its value on each clock pulse.
     */
    private void calc() {
        for (int i = 0; i < 4; i++) {
            if (!count[i]) {
                binaryCounters[i].setInCLK(inCLK);
                count[i] = binaryCounters[i].getOutQ();
                break;
            }
            binaryCounters[i].setInCLK(inCLK);
            count[i] = binaryCounters[i].getOutQ();
            inCLK = binaryCounters[i].getOutQNot();
        }
    }

    /**
     * Sets the clock input and recalculates the counter outputs.
     *
     * @param inCLK The new clock input value.
     */
    public void setInCLK(boolean inCLK) {
        this.inCLK = inCLK;
        calc();
    }

    /**
     * Retrieves the array representing the current count.
     *
     * @return The array of booleans representing the current count.
     *         Each index corresponds to a bit, and the value at that index is true if the bit is 1.
     */
    public boolean[] getCount() {
        return count;
    }
}

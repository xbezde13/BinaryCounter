package org.example;


/**
 * The BinaryCounter class models a binary counter using a master-slave D flip-flop.
 * The counter increments its value on each clock pulse.
 */
public class BinaryCounter {

    private final MasterSlaveDFlipFlop masterSlaveDFlipFlop = new MasterSlaveDFlipFlop(); // The master-slave D flip-flop.
    private boolean outQ = false;     // The output Q of the counter.
    private boolean outQNot = true;   // The complement of output Q.

    private boolean inCLK = true;     // The clock input.

    /**
     * Calculates the output values of the binary counter based on input values.
     * The counter increments its value on each clock pulse.
     */
    private void calc() {
        masterSlaveDFlipFlop.setInCLK(inCLK);
        masterSlaveDFlipFlop.setInD(masterSlaveDFlipFlop.getOutQNot());

        outQ = masterSlaveDFlipFlop.getOutQ();
        outQNot = masterSlaveDFlipFlop.getOutQNot();
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

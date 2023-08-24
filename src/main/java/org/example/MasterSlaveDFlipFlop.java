package org.example;

/**
 * The MasterSlaveDFlipFlop class models a master-slave D flip-flop using gated D latches.
 * A D flip-flop is a digital circuit that stores one bit of data and has a clock input.
 * It prevents changes in the stored data from affecting the output until a clock pulse arrives.
 */
public class MasterSlaveDFlipFlop {

    private final GatedDLatch master = new GatedDLatch(); // The master latch.
    private final GatedDLatch slave = new GatedDLatch();  // The slave latch.

    private boolean outQ = false;     // The output Q of the flip-flop.
    private boolean outQNot = true;   // The complement of output Q.

    private boolean inD = false;      // The data input.
    private boolean inCLK = false;    // The clock input.

    /**
     * Calculates the output values of the D flip-flop based on input values.
     * The flip-flop's behavior depends on the clock input.
     */
    private void calc() {
        master.setInE(!inCLK);
        master.setInD(inD);

        slave.setInE(inCLK);
        slave.setInD(master.getOutQ());

        outQ = slave.getOutQ();
        outQNot = slave.getOutQNot();
    }

    /**
     * Sets the data input and recalculates the flip-flop outputs.
     *
     * @param inD The new data input value.
     */
    public void setInD(boolean inD) {
        this.inD = inD;
        calc();
    }

    /**
     * Sets the clock input and recalculates the flip-flop outputs.
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

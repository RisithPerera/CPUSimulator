package simulator;

import java.util.Objects;

public class Instruction {
    private int opCode;
    private int destination;
    private int sourceOne;
    private int sourceTwo;

    public Instruction(int opCode, int destination, int sourceOne, int sourceTwo) {
        this.opCode = opCode;
        this.destination = destination;
        this.sourceOne = sourceOne;
        this.sourceTwo = sourceTwo;
    }

    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getSourceOne() {
        return sourceOne;
    }

    public void setSourceOne(int sourceOne) {
        this.sourceOne = sourceOne;
    }

    public int getSourceTwo() {
        return sourceTwo;
    }

    public void setSourceTwo(int sourceTwo) {
        this.sourceTwo = sourceTwo;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "opCode=" + opCode +
                ", destination=" + destination +
                ", sourceOne=" + sourceOne +
                ", sourceTwo=" + sourceTwo +
                '}';
    }
}

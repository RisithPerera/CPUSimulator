package simulator;

import java.util.Objects;

public class Instruction {
    private short opCode;
    private short destination;
    private short sourceOne;
    private short sourceTwo;
    private short immValue;

    public Instruction(short opCode, short destination, short sourceOne, short sourceTwo, short immValue) {
        this.opCode = opCode;
        this.destination = destination;
        this.sourceOne = sourceOne;
        this.sourceTwo = sourceTwo;
        this.immValue = immValue;
    }

    public short getOpCode() {
        return opCode;
    }

    public short getDestination() {
        return destination;
    }

    public short getSourceOne() {
        return sourceOne;
    }

    public short getSourceTwo() {
        return sourceTwo;
    }

    public short getImmValue() {
        return immValue;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "opCode=" + opCode +
                ", destination=" + destination +
                ", sourceOne=" + sourceOne +
                ", sourceTwo=" + sourceTwo +
                ", immValue=" + immValue +
                '}';
    }
}

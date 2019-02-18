package simulator;

import java.io.IOException;

public class ControlUnit {

    private static ControlUnit controlUnit;
    private Instruction instruction;

    private ControlUnit(){}

    public static ControlUnit getInstance(){
        if(controlUnit == null){
            controlUnit = new ControlUnit();
        }
        return controlUnit;
    }

    public Instruction decodeInstruction(String code){
        //Clarify, whether their is 3 data (opCode, destination, sourceOne, sourceTwo)
        if(code == null || code.length() != 32){
            System.out.println("Runtime Error: Invalid Instruction" );
            return null;
        }

        //Decode Instructions
        short opCode = getDecimalValue(code.substring(0,8));
        short destination = getDecimalValue(code.substring(8,16));
        short sourceOne = getDecimalValue(code.substring(16,24));
        short sourceTwo = getDecimalValue(code.substring(29,32));
        short immValue = getDecimalValue(code.substring(24,32));

        //Create a Instruction object.
        return new Instruction(opCode, destination, sourceOne, sourceTwo, immValue);
    }

    private short getDecimalValue(String byteCode) {
        return Short.parseShort(byteCode,2);
    }
}

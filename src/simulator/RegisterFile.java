package simulator;

import java.util.HashMap;
import java.util.Map;

public class RegisterFile {

    private static final int REG_CAPACITY = 8;

    //This a primitive integer array which keeps register values
    //Indexes of this array are related to register addresses
    private static int[] registers;

    private static RegisterFile registerFile;

    private RegisterFile() {
        registers = new int[REG_CAPACITY];
    }

    public static RegisterFile getInstance(){
        if(registerFile == null){
            registerFile = new RegisterFile();
        }
        return registerFile;
    }

    public int getRegisterValue(short address){
        return registers[address];
    }


    public void setRegisterValue(short address, int value){
        registers[address] = value;
    }
}

package simulator;

public class ProgramCounter {

    private int readAddress;
    private boolean reset;

    private static ProgramCounter programCounter;

    private ProgramCounter() {}

    public static ProgramCounter getInstance(){
        if(programCounter == null){
            programCounter = new ProgramCounter();
        }
        return programCounter;
    }

    //Increase Read_Addr by one at each negative clock cycle
    public int getNextAddress(boolean reset){
        readAddress = (reset) ? 0 : readAddress + 1;
        return readAddress;
    }
}

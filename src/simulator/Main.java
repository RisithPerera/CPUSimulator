package simulator;

public class Main{
    private static final String FILE_PATH  = "src/simulator/Machine.machine";


    public static void main(String[] args){

        //First we have to load our program instructions into Instruction Memory
        InstructionRegister instructionRegister = InstructionRegister.getInstance();
        instructionRegister.loadInstructions(FILE_PATH);
        //instructionRegister.printInstructions();


        //Then we start the processor
        Processor processor = Processor.getInstance();
        processor.start();

    }
}

/*

 try {
                Thread.sleep(1000);
            }catch (InterruptedException e){}

 */
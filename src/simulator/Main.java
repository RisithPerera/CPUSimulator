package simulator;

public class Main{
    private static boolean CLOCK_STATE;
    private static final String FILE_PATH  = "src/simulator/Machine.machine";

    public static void main(String[] args){
        InstructionMemory instructionMemory = new InstructionMemory(FILE_PATH);

        /*
        while(true){
            CLOCK_STATE = !CLOCK_STATE;
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){}

            System.out.println(CLOCK_STATE);
        }
        */
    }
}

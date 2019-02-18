package simulator;

public class Processor {
    private static Processor processor;
    private ProgramCounter programCounter;
    private RegisterFile registerFile;
    private String instructionCode;
    private Instruction instruction;

    private static boolean CLOCK_STATE;

    private Processor() {
        CLOCK_STATE = false;
        programCounter = ProgramCounter.getInstance();
        registerFile = RegisterFile.getInstance();
    }

    public static Processor getInstance(){
        if(processor == null){
            processor = new Processor();
        }
        return processor;
    }

    public void start(){
        int nextAddress = 0;
        while(true){
            for(int i=0;i<2;i++){
                switch (i){
                    case 0:
                        nextAddress = programCounter.getNextAddress(false);
                        instructionCode = InstructionRegister.getInstance().fetchInstruction(nextAddress);
                        instruction = ControlUnit.getInstance().decodeInstruction(instructionCode);
                        System.out.println(CLOCK_STATE+":" + instruction);
                        break;
                    case 1:
                        if(instruction == null) return;
                        int valueOutOne = registerFile.getRegisterValue(instruction.getSourceOne());
                        int valueOutTwo = registerFile.getRegisterValue(instruction.getSourceTwo());
                        System.out.println(CLOCK_STATE+":" + valueOutOne);
                        break;
                }
                CLOCK_STATE = !CLOCK_STATE;
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}

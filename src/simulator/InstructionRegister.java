package simulator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InstructionRegister {

    private Map<Integer,String> instructionCodeMap;
    private static InstructionRegister instructionRegister;

    private InstructionRegister() {
        instructionCodeMap = new HashMap<Integer,String>();
    }

    public static InstructionRegister getInstance(){
        if(instructionRegister == null){
            instructionRegister = new InstructionRegister();
        }
        return instructionRegister;
    }

    public void loadInstructions(String fileName){
            //Check the file existence
            File file = new File(fileName);
            if (!file.exists()){
                System.out.println("File doesn't exist..");
                return;
            }

            String instructionCode;
            //Read the file
            try (FileReader fileReader = new FileReader(file)) {

                BufferedReader bufferedReader = new BufferedReader(fileReader);
                int instructionCount = 0;
                while ((instructionCode = bufferedReader.readLine()) != null) {
                        instructionCodeMap.put(instructionCount,instructionCode);
                        instructionCount++;
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println("Error : When reading the " + fileName);
            }
    }

    public String fetchInstruction(Integer instructionAddress){
        return instructionCodeMap.get(instructionAddress);
    }

    public void printInstructions() {
        for (Map.Entry<Integer,String> entry: instructionCodeMap.entrySet()) {
            String instruction = entry.getValue();
            System.out.println(instruction);
        }
    }
}

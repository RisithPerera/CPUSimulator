package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InstructionMemory {
    private List<Instruction> instructionList;

    public InstructionMemory(String fileName) {
        instructionList = new ArrayList<Instruction>();

        loadInstructions(fileName);

        printInstructions();
    }

    private void printInstructions() {
        for (Instruction instruction: instructionList) {
            System.out.println(instruction);
        }
    }

    private void loadInstructions(String fileName){
        try{
            //Check the file existence
            File file = new File(fileName);
            if (!file.exists()){
                System.out.println("File doesn't exist..");
                return;
            }

            String line;
            //Read the file
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    //Divide the string at the commas
                    String[] parts = line.split(" ");

                    //Clarify, whether their is 3 data (opCode, destination, sourceOne, sourceTwo)
                    if(parts.length == 4){
                        //Create a contact object.

                        int opCode = getDecimalValue(parts[0]);
                        int destination = getDecimalValue(parts[1]);
                        int sourceOne = getDecimalValue(parts[2]);
                        int sourceTwo = getDecimalValue(parts[3]);

                        Instruction instruction = new Instruction(opCode, destination,sourceOne, sourceTwo);
                        instructionList.add(instruction);
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Error : When reading the " + fileName);
        }
    }

    private int getDecimalValue(String byteCode) throws IOException {
        if(byteCode.length() != 8) {
            throw new IOException();
        }
        return Integer.parseInt(byteCode,2);
    }
}

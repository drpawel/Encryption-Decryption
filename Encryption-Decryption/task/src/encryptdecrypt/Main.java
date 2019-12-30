package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String result = "";
        String mode = "";
        int key = 0;
        String data = "";
        String inPath = "";
        String outPath = "";
        String alg = "";
        for(int i = 0; i < args.length; i = i+2){
            String parameter = args[i];
            if("-mode".equals(parameter)){
                mode = args[i + 1];
            }else if("-data".equals(parameter)){
                data = args[i +1];
            }else if("-key".equals(parameter)){
                key = Integer.parseInt(args[i+1]);
            }else if("-in".equals(parameter)) {
                inPath = args[i + 1];
            }else if("-out".equals(parameter)) {
                outPath = args[i + 1];
            }else if("-alg".equals(parameter)){
                alg = args[i+1];
            }
        }

        if(data.isEmpty() && !inPath.isEmpty()){
            try{
                data = new String (Files.readAllBytes(Paths.get(inPath)));
            }catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }


        if(mode.isEmpty()){
            System.out.println("Unknown operation");
        }else if(mode.equals("enc")){
            CodingMachine machine = new CodingMachine();
            machine.setAlgorithm(alg);
            result = machine.encryption(data,key);
        }else{
            CodingMachine machine = new CodingMachine();
            machine.setAlgorithm(alg);
            result = machine.decryption(data,key);
        }

        if(inPath.isEmpty()){
            System.out.println(result);
        }else{
            File outPut = new File(outPath);
            try(FileWriter writer = new FileWriter(outPut)){
                writer.write(result);
            }catch (IOException e){
                System.out.println("Error " + e.getMessage() );
            }
        }
    }
}

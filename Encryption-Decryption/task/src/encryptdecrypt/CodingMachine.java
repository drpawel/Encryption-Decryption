package encryptdecrypt;

public class CodingMachine {
    private AlgorithmStrategy algorithm;

    public void setAlgorithm(String alg){
        if(alg.equals("unicode")){
            this.algorithm = new UnicodeAlgorithm();
        }else{
            this.algorithm = new ShiftAlgorithm();
        }
    }

    public String encryption(String str, int key){
        return this.algorithm.encryption(str,key);
    }

    public String decryption(String str, int key){
        return this.algorithm.decryption(str, key);
    }
}

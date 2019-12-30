package encryptdecrypt;

public interface AlgorithmStrategy {
    String encryption(String str,int key);
    String decryption(String str,int key);
}

class ShiftAlgorithm implements AlgorithmStrategy{
    @Override
    public String encryption(String str,int key){
        String encrStr = "";
        key = key % 26;
        for(int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            if(currentChar>='A' && currentChar<='Z'){
                if((currentChar+key)>'Z'){
                    currentChar -= 26;
                }else if(currentChar+key<'A') {
                    currentChar += 26;
                }
                currentChar += key;

            }else if (currentChar>='a' && currentChar<='z'){
                if((currentChar+key)>'z'){
                    currentChar -= 26;
                }else if(currentChar+key<'a'){
                    currentChar += 26;
                }
                currentChar += key;
            }
            encrStr += currentChar;
        }
        return encrStr;
    }

    @Override
    public String decryption(String str, int key) {
        String decrStr = "";
        key = key % 26;
        for(int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            if(currentChar>='A' && currentChar<='Z'){
                if((currentChar-key)<'A'){
                    currentChar += 26;
                }else if(currentChar-key>'Z'){
                    currentChar -= 26;
                }
                currentChar -= key;
            }else if (currentChar>='a' && currentChar<='z'){
                if((currentChar-key)<'a'){
                    currentChar += 26;
                }else if(currentChar-key>'z'){
                    currentChar -= 26;
                }
                currentChar -= key;
            }
            decrStr += currentChar;
        }
        return decrStr;
    }
}

class UnicodeAlgorithm implements AlgorithmStrategy{
    @Override
    public String encryption(String str, int key){
        String encrStr = "";
        for(int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            currentChar += key;
            encrStr += currentChar;

        }
        return encrStr;
    }
    @Override
    public String decryption(String str, int key){
        String decrStr = "";
        for(int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            currentChar -= key;
            decrStr += currentChar;
        }
        return decrStr;
    }
}
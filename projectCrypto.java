import java.util.*;

public class projectCrypto {
    public static void main(String[] args){
        String text = collectString();
        int shift = collectShift();
        int groupSize = collectGroupSize();
        String normalizedText = normalizeText(text);
        String obifiedString = obify(normalizedText);
        String caesarifiedText = caesarify(obifiedString, shift);
        groupify(caesarifiedText, groupSize);
    }
    public static String collectString(){
        Scanner input = new Scanner(System.in);
        System.out.print("What do you want to encrypt? ");
        String text = input.nextLine();
        return text;
    }

    public static int collectShift(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many letters do you want to shift by? ");
        int shift = input.nextInt();
        return shift;
    }

    public static int collectGroupSize(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many characters do you want the result to be grouped by? ");
        int groupSize = input.nextInt();
        return groupSize;
    }

    public static String normalizeText(String text){
        text = text.replace(" ", "");
        text = text.replaceAll("\\p{Punct}","");
        String normalizedText = text.toUpperCase();
        return normalizedText;
    }

    public static String obify(String normalizedText){
        StringBuilder obifiedString = new StringBuilder(100);
        for (int i = 0; i < normalizedText.length(); i++){
            if (normalizedText.charAt(i) == 'A' || normalizedText.charAt(i) == 'E' || normalizedText.charAt(i) == 'I' || normalizedText.charAt(i) == 'O' || normalizedText.charAt(i) == 'U'){
                obifiedString.append("OB");
            }
            obifiedString.append(normalizedText.charAt(i));
        }
        return obifiedString.toString();
    }

    public static String caesarify(String obifiedString, int shift) {
        String alphabet = shiftAlphabet(0);
        String shiftedAlphabet = shiftAlphabet(shift);
        StringBuilder caesarifiedText = new StringBuilder(100);
        for (int i = 0; i < obifiedString.length(); i++) {
            char oldChar = obifiedString.charAt(i);
            int oldIndex = alphabet.indexOf(oldChar);
            char newChar = shiftedAlphabet.charAt(oldIndex);
            caesarifiedText.append(newChar);
        }
        return caesarifiedText.toString();
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static void groupify(String caesarifiedText, int groupSize){
        int modText = caesarifiedText.length()%groupSize;
        int modDiff = groupSize - modText;
        StringBuilder appendedCipher = new StringBuilder(caesarifiedText);
        if (modText > 0) {
            for (int j = 0; j < modDiff; j++) {
                appendedCipher.append('x');
            }
        }
        for (int i = 0; i < appendedCipher.length(); i = i + groupSize){
            System.out.print(appendedCipher.substring(i, (i + groupSize)) + " ");
        }
    }
}

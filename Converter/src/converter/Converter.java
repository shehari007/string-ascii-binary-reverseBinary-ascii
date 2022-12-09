package converter;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.text.ParseException;
import java.util.Arrays;

public class Converter {
    

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static String strToBinary(String inputString) {

        int[] ASCIIHolder = new int[inputString.length()];
        for (int index = 0; index < inputString.length(); index++) {
            ASCIIHolder[index] = (int) inputString.charAt(index);
        }

        StringBuffer binaryStringBuffer = new StringBuffer();

        for (int index = 0; index < inputString.length(); index++) {

            binaryStringBuffer.append(Integer.toBinaryString(ASCIIHolder[index]));
        }

        String binaryToBeReturned = binaryStringBuffer.toString();

        binaryToBeReturned.replace(" ", "");

        return binaryToBeReturned;
    }

    public static String binaryToString(String binaryString) {
        String returnString = "";
        int charCode;
        for (int i = 0; i < binaryString.length(); i += 7) {
            charCode = Integer.parseInt(binaryString.substring(i, i + 7), 2);
            String returnChar = new Character((char) charCode).toString();
            returnString += returnChar;
        }
        return returnString;
    }
 
    static String convert(byte[] data) {
    StringBuilder sb = new StringBuilder(data.length);
    for (int i = 0; i < data.length; ++ i) {
        if (data[i] < 0) throw new IllegalArgumentException();
        sb.append((char) data[i]);
    }
    return sb.toString();
}
    public static void main(String[] args) throws UnsupportedEncodingException {
        String metin;
        String metin_binary;
        String metin_tersBinary;
       
        Scanner scan = new Scanner(System.in);
        System.out.println("Metin: ");
        metin = scan.nextLine();
        byte[] bytes = metin.getBytes("US-ASCII");
        metin_binary = strToBinary(metin);
        metin_tersBinary = metin_binary.replaceAll("0","x").replaceAll("1","0").replaceAll("x","1");
        //metin_tersBinary = reverseString(metin_binary);
        byte[] bytes2 = metin_tersBinary.getBytes("US-ASCII");
        String ss = convert(bytes2);
        System.out.println("Girdiginiz_metinin : " + metin + "\nASCII: " + Arrays.toString(bytes) + "\nIKI Bitlik: " + metin_binary + "\nTers_IKI_Bitlik: "
                + metin_tersBinary + "\nBinary_TO_ASCII: " + Arrays.toString(bytes2)+"\nASCII_To_String: "+ss);
    }

}

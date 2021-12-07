import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SimpleNumGenerator primeGen= new SimpleNumGenerator();
        int[] primeNumbersPair = primeGen.getRandomPAndQ();
        Scanner in = new Scanner(System.in);
        System.out.println("Input your text in one line:");
        String input = in.nextLine();
        System.out.println();
        in.close();
        System.out.println(primeNumbersPair[0]+" "+primeNumbersPair[1]);
        RSAalg encryption = new RSAalg(input,primeNumbersPair[0],primeNumbersPair[1]);

        //encrypt and print encrypted message
        ArrayList<String> encryptedMessage = encryption.encrypt();
        System.out.println("Message after encryption:");
        for(String s : encryptedMessage){
            System.out.print(s+" ");
        }
        System.out.println();

        //decrypt and print the message
        String decryptedMessage = encryption.decrypt(encryptedMessage);
        System.out.println("Message after decryption:\n"+decryptedMessage);
    }


}
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SimpleNumGenerator primeGen= new SimpleNumGenerator();
        int[] primeNumbersPair = primeGen.getRandomPAndQ();
        Scanner in = new Scanner(System.in);
        System.out.println("Input your text in one line:\n");
        String input = in.nextLine();
        in.close();

        RSAalg encryption = new RSAalg(input,primeNumbersPair[0],primeNumbersPair[1]);

        //encrypt and print encrypted message
        ArrayList<String> encryptedMessage = encryption.encrypt();
        for(String s : encryptedMessage){
            System.out.print(s+" ");
        }

        //decrypt and print the message
        String decryptedMessage = encryption.decrypt(encryptedMessage);
        System.out.println(decryptedMessage);
    }


}


// for p=29 q=31
//
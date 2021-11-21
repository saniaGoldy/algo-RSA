import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input your text in one line:\n");
        String input = in.nextLine();
        long p;
        long q;
        do{
            System.out.println("Input simple numbers p and and q:");
            p=in.nextLong();
            q=in.nextLong();
        } while (!(SimpleNumGenerator.isSimple(p) && SimpleNumGenerator.isSimple(q)));
        RSAalg encryption = new RSAalg(input,p,q);
        in.close();

        //encrypt and print result
        ArrayList<String> encryptedMessage = encryption.encrypt();
        for(String s : encryptedMessage){
            System.out.print(s+" ");
        }

        String decryptedMessage = encryption.decrypt(encryptedMessage);
        System.out.println(decryptedMessage);
    }


}

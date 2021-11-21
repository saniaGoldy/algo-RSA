import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RSAalg {
    private long p;
    private long q;
    private long m;
    char[] input;
    private long d;
    int e;
    BigInteger n;


    public RSAalg(String input, long p, long q){
        this.input=input.toCharArray();
        this.p=p;
        this.q=q;
        n=BigInteger.valueOf(p*q);
        m=(p-1)*(q-1);
        e=calculateE(m);
        d=(2*m + 1)/e;
    }

    public int calculateE(long m){
        int e=3;
        for(int i=2; i<=e; i++){
            if((e%i==0) && (m%i==0)){
                e+=1;
                i=1;
            }
        }
        return e;
    }

    //Open key: e,n
    public ArrayList<String> encrypt(){
        BigInteger symbol;
        ArrayList<String> encrypted=new ArrayList<>();
        for(char c : input){
            symbol=BigInteger.valueOf((long)c);
            symbol=(symbol.pow(e)).mod(n);
            encrypted.add(String.valueOf(symbol));
        }
        return encrypted;
    }

    //Overload of encrypt method to work without creation of Class instance
    public ArrayList<String> encrypt(int e, BigInteger n){
        BigInteger symbol;
        ArrayList<String> encrypted=new ArrayList<>();
        for(char c : input){
            symbol=BigInteger.valueOf((long)c);
            symbol=(symbol.pow(e)).mod(n);
            encrypted.add(String.valueOf(symbol));
        }
        return encrypted;
    }

    //Private key: d,n
    public String decrypt(ArrayList<String> encryptedMessege){
        String message="";
        for(String character:encryptedMessege){
            BigInteger bi = BigInteger.valueOf(Long.parseLong(character));
            bi = (bi.pow((int) d)).mod(n);
            message = message + (char)(bi.longValue());
        }
        return message;
    }
    //Overload of decrypt method to work without creation of Class instance
    public static String decrypt(ArrayList<String> encryptedMessege, long d, BigInteger n){
        String message="";
        for(String character:encryptedMessege){
            BigInteger bi = BigInteger.valueOf(Long.parseLong(character));
            bi = (bi.pow((int) d)).mod(n);
            message = message + (char)(bi.longValue());
        }
        return message;
    }
}

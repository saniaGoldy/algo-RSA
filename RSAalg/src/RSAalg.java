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
        for (int i = 0; i <= 9; i++) {
            int x = (int) (1 + (i * m));

            // d is for private key
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
    }

    public int calculateE(long m){
        int e=2;
        for(;e<m;e++){
            if(gcd(e,m) == 1){
                break;
            }
        }
        return e;
    }

    static long gcd(long e, long m)
    {
        if (e == 0)
            return m;
        else
            return gcd(m % e, e);
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

import java.security.SecureRandom;
import java.util.ArrayList;
import java.security.SecureRandom;

public class SimpleNumGenerator {
    ArrayList <Integer> simpleNumArr=new ArrayList<>();

    public SimpleNumGenerator(){
        SecureRandom random = new SecureRandom();
        //Get random number in range 0 - 9998
        int randomKey = random.nextInt(9998);
        generatePrimeNumbers(10000);
        //Tests
        for(int i:simpleNumArr){
            System.out.print(i+" ");
        }
    }

    //Don`t need it btw
    public static boolean isSimple(long x){
        if(x<2)
            return false;
        for(long i = 2; i < x; i++){
            if((x % i) == 0) {
                return false;
            }
        }
        return true;
    }

    //Method to check is n is a next prime number using already calculated prime numbers
    public boolean isNextPrime(int n){
        for(int i:simpleNumArr){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    // Calculates n prime numbers and write them in simpleNumArr
    private void generatePrimeNumbers(int n){
        int cntr=0;
        int currN=3;
        while (cntr<=n){
            if(isNextPrime(currN)){
                simpleNumArr.add(currN);
                currN++;
                cntr++;
            }
            currN++;
        }
    }
}

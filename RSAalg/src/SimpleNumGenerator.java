import java.security.SecureRandom;
import java.util.ArrayList;

public class SimpleNumGenerator {
    ArrayList <Integer> simpleNumArr=new ArrayList<>();

    public SimpleNumGenerator(){
        generatePrimeNumbers(100);
        /*Tests
        for(int i:simpleNumArr){
            System.out.print(i+" ");
        }
        System.out.println();
        */
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
        int currN=2;
        while (cntr<=n){
            if(isNextPrime(currN)){
                simpleNumArr.add(currN);
                currN++;
                cntr++;
            }
            currN++;
        }
    }

    public int[] getRandomPAndQ(){
        SecureRandom random = new SecureRandom();
        //Get random number in range 0 - 9998
        //Because 9999 is last index in simpleNumArr
        int randomKey = random.nextInt(98);
        int[] pAndQ = {simpleNumArr.get(randomKey),simpleNumArr.get(randomKey+1)};
        /*Tests
        //int[] pAndQ = {simpleNumArr.get(simpleNumArr.size()-2),simpleNumArr.get(simpleNumArr.size()-1)};
        //System.out.println(pAndQ[0] + " " + pAndQ[1] + "\n");
        */
        return pAndQ;
    }
}

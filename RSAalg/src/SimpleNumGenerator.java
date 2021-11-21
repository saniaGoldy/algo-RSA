import java.security.SecureRandom;
import java.util.ArrayList;
import java.security.SecureRandom;

public class SimpleNumGenerator {
    ArrayList <Integer> simpleNumArr=new ArrayList<>();

    public SimpleNumGenerator(){
        SecureRandom random = new SecureRandom();
        //Get random number in range 5 - Integer.MAX_VALUE
        int randomKey = random.nextInt(Integer.MAX_VALUE-4);
        generatePrimeNumbers(randomKey);
        //Tests
        for(int i:simpleNumArr){
            System.out.print(i+" ");
        }
    }

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

    // Counts randomKey prime numbers and write them in simpleNumArr
    private void generatePrimeNumbers(int randomKey){
        int cntr=0;
        int currN=3;
        while (cntr<=randomKey){
            if(isSimple(currN)){
                simpleNumArr.add(currN);
                cntr++;
            }
        }
    }
}

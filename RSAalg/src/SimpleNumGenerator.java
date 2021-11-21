import java.util.ArrayList;

public class SimpleNumGenerator {
    ArrayList <Integer> simpleNumArr=new ArrayList<>();

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
    private void getTwoSimpleNumbers(int randomKey){
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

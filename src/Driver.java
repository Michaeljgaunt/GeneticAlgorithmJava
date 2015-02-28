
import java.util.Arrays;


public class Driver {
    
    public static void main(String args[]) {
        
        Chromosome c1 = new Chromosome(0, 31, 3);
        System.out.println("The function has " + c1.numVars +" variables in the range " + c1.lowerBound + " - " + c1.upperBound + ".");
        System.out.println("Chromosome is " + Arrays.toString(c1.chromosome));
        System.out.println("Values are " + Arrays.toString(c1.bitStringValues));
    }
}


import java.util.Arrays;
import java.util.Random;


public class Driver {
    
    public static void main(String args[]) {
        
        Chromosome c1 = new Chromosome(0, 31, 3);
        System.out.println("The function has " + c1.numVars +" variables in the range " + c1.lowerBound + " - " + c1.upperBound + ".");
        
        Random random = new Random();
        c1.generateBitString(random);
        c1.convertBitString();
        
        System.out.println("Chromosome is " + Arrays.toString(c1.chromosome));
        System.out.println("Values are " + Arrays.toString(c1.bitStringValues));
        
        ObjectiveFunction objfunc = new ObjectiveFunction();
        c1.evaluateFitness(objfunc);
        
        System.out.println("Fitness is " + (c1.fitness));
        
        c1.mutate(50, random);
        
        System.out.println("Mutating with rate 50% " + Arrays.toString(c1.chromosome));
    }
}

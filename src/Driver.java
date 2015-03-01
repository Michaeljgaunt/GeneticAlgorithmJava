
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Driver {
    
    static int chromNum = 4;
    static int varNum = 2;
    static int lowerBound = 0;
    static int upperBound = 31;
    static int numCuts = 2;
    
    public static void main(String args[]) {
        
        Random random = new Random();
        ObjectiveFunction objfunc = new ObjectiveFunction();

        ArrayList<Chromosome> chromArray = new ArrayList<Chromosome>(chromNum);
        for(int i = 0; i < chromNum; i++) {
            Chromosome c = new Chromosome(lowerBound, upperBound, varNum);
            c.generateBitString(random);
            c.convertBitString();
            c.evaluateFitness(objfunc);
            chromArray.add(c);
        }
        
        System.out.println("\nChromosome array: ");
        for(int i = 0; i < chromNum; i++) {     
            System.out.println(Arrays.toString(chromArray.get(i).chromosome));
        }
        
        System.out.println("\nVariable values: ");
        for(int i = 0; i < chromNum; i++) {     
            System.out.println(Arrays.toString(chromArray.get(i).bitStringValues));
        }
        
        System.out.println("\nFitness values: ");
        for(int i = 0; i < chromNum; i++) {     
            System.out.println(chromArray.get(i).fitness);
        }
                
        Evolve evolve = new Evolve(chromArray);
        evolve.getFitnessSum();
        evolve.evaluateProbabilities();
        System.out.println("\nFitness sum is: " + evolve.sum);
        System.out.println("\nProbabilities are : " + evolve.probArray);
        evolve.roulette_rank(random);
        System.out.println("\nParents based on roulette ranking: ");
        for(int i = 0; i < chromNum; i++) {       
            System.out.println(Arrays.toString(evolve.parentArray.get(i).chromosome));
        }
        System.out.println("\nChildren after crossover: ");
        evolve.crossover(random, 1, lowerBound, upperBound, varNum);
        for(int i = 0; i < chromNum; i++) {       
            System.out.println(Arrays.toString(evolve.chromArray.get(i).chromosome));
        }
    }
}

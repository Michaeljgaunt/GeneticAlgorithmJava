
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Driver {
    
    static int chromNum = 4;
    static int varNum = 2;
    static int lowerBound = 0;
    static int upperBound = 31;
    
    
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
        
        System.out.println("\nChromosomes after mutating with a rate of 10%: ");
        for(int i = 0; i < chromNum; i++) {          
            chromArray.get(i).mutate(10, random);
            System.out.println(Arrays.toString(chromArray.get(i).chromosome));
        }
        
        for (Chromosome chromosome : chromArray) {
            chromosome.convertBitString();
            chromosome.evaluateFitness(objfunc);
        }
        
        System.out.println("\nValues after mutating: ");
        for(int i = 0; i < chromNum; i++) {     
            System.out.println(Arrays.toString(chromArray.get(i).bitStringValues));
        }
        
        System.out.println("\nFitness values after mutating: ");
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
        
    }
}

package Debug;

import GA.ObjectiveFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class DebugDriver {
    
    static int numIts = 3;
    static int chromNum = 4;
    static int varNum = 2;
    static int lowerBound = 0;
    static int upperBound = 31;
    static int numCuts = 1;
    static int mutRate = 50;
    
    
    public static void debug() {
        
        Random random = new Random();
        ObjectiveFunction objfunc = new ObjectiveFunction();

        System.out.println("------------------------- DEBUG MODE -------------------------");
        System.out.println("Iterating " + numIts + " times.");
        System.out.println("Generating " + chromNum + " chromosomes with " + varNum + " variables in the range " + lowerBound + " - " + upperBound + ".");
        System.out.println("During crossover, " + numCuts + " cut(s) will be made.");
        System.out.println("A mutation rate of " + mutRate + "% will be applied.");
        System.out.println("--------------------------------------------------------------");
        
        System.out.println("\nGenerating chromosomes:");
        ArrayList<DebugChromosome> chromArray = new ArrayList<>(chromNum);
        for(int i = 0; i < chromNum; i++) {
            System.out.println("\nChromosome " + (i + 1) + ": ");
            DebugChromosome c = new DebugChromosome(lowerBound, upperBound, varNum);
            c.generateBitString(random);
            System.out.println(Arrays.toString(c.chromosome));
            c.convertBitString();
            System.out.println("Values: " + Arrays.toString(c.bitStringValues));
            c.evaluateFitness(objfunc);
            System.out.println("Fitness: " + c.fitness);
            chromArray.add(c);
        }
        System.out.println("\n--------------------------------------------------------------");
        
        for(int iteration = 0; iteration < numIts; iteration++) {
            
            System.out.println("\nIteration " + (iteration + 1) + ":");
            for(int i = 0; i < chromArray.size(); i++) {
                System.out.println(Arrays.toString(chromArray.get(i).chromosome));
            }    
                    
            DebugEvolve evolve = new DebugEvolve(chromArray);
            evolve.getFitnessSum();
            System.out.println("\nSigma fitness is " + evolve.sum);
            evolve.evaluateProbabilities();
            System.out.println("\nProbabilities are: " + evolve.probArray);
            System.out.println("\n--------------------------------------------------------------");
            System.out.println("\nRanking parents:");
            evolve.rouletteRank(random);
            System.out.println("\n--------------------------------------------------------------");

            System.out.println("\nPerforming crossover:");
            evolve.crossover(random, 1, lowerBound, upperBound, varNum);
            for(int i = 0; i < chromNum; i++) {       
                chromArray = evolve.chromArray;
            }
            System.out.println("\n--------------------------------------------------------------");
            
            if(mutRate == 0) {
                System.out.println("\nMutation rate is 0%, no mutation will be applied.");
            } else {
                System.out.println("\nApplying mutation rate of " + mutRate + "%...");
                for(int i = 0; i < chromNum; i++) {
                    System.out.println("Chromosome " + (i + 1) + ": ");
                    chromArray.get(i).mutate(mutRate, random);
                }
            }
            System.out.println("\n--------------------------------------------------------------");
            
            double bestFit = 0;
            
            System.out.println("\nEvaluating chromosomes...");
            for(int i = 0; i < chromNum; i++) {
                System.out.println("\nChromosome " + (i + 1) + ": ");
                chromArray.get(i).convertBitString();
                System.out.println("Values: " + Arrays.toString(chromArray.get(i).bitStringValues));
                chromArray.get(i).evaluateFitness(objfunc);
                System.out.println("Fitness: " + chromArray.get(i).fitness);
            }
            System.out.println("\n--------------------------------------------------------------");
            
            for (DebugChromosome chrom : chromArray) {
                if (chrom.fitness > bestFit) {
                    bestFit = chrom.fitness;
                }
            } 
            
            int bestIndex = 0;
            for (int i = 0; i < chromArray.size(); i++) {
                if(chromArray.get(i).fitness == bestFit){
                    bestIndex = i;
                }
            }
            
            DebugChromosome bestChrom = chromArray.get(bestIndex);
            System.out.println("\nOn iteration " + (iteration + 1) + ", the best values for the variables found are: " + Arrays.toString(chromArray.get(bestIndex).bitStringValues));
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            
        }
    }
}

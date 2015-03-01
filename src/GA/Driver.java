package GA;

import Debug.DebugDriver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Driver {
    
    public static int numIts = 3;
    public static int chromNum = 4;
    public static int varNum = 2;
    public static int lowerBound = 0;
    public  static int upperBound = 31;
    public static int numCuts = 1;
    public static int mutRate = 5;
    static boolean debugFlag = true;
    
    
    public static void main(String args[]) {
        
        if(debugFlag) {
            DebugDriver.debug();    
        } else {
            
            Random random = new Random();
            ObjectiveFunction objfunc = new ObjectiveFunction();

            System.out.println("\nRandomly generating " + chromNum + " chromosomes...");
            ArrayList<Chromosome> chromArray = new ArrayList<>(chromNum);
            System.out.println("Evaluating chromosomes...");
            for(int i = 0; i < chromNum; i++) {
                Chromosome c = new Chromosome(lowerBound, upperBound, varNum);
                c.generateBitString(random);
                c.convertBitString();
                c.evaluateFitness(objfunc);
                chromArray.add(c);
            }

            for(int iteration = 0; iteration < numIts; iteration++) {

                System.out.println("\nIteration " + (iteration + 1) + ".");

                Evolve evolve = new Evolve(chromArray);
                evolve.getFitnessSum();
                evolve.evaluateProbabilities();
                evolve.rouletteRank(random);
                System.out.println("\nRanking parents...");

                System.out.println("Performing crossover...");
                evolve.crossover(random, 1, lowerBound, upperBound, varNum);
                for(int i = 0; i < chromNum; i++) {       
                    chromArray = evolve.chromArray;
                }

                if(mutRate == 0) {
                    System.out.println("Mutation rate is 0%, no mutation will be applied.");
                } else {
                    System.out.println("Applying mutation rate of " + mutRate + "%...");
                    for(int i = 0; i < chromNum; i++) {
                        chromArray.get(i).mutate(mutRate, random);
                    }
                }

                double bestFit = 0;

                System.out.println("Evaluating chromosomes...");
                for(int i = 0; i < chromNum; i++) {
                    chromArray.get(i).convertBitString();
                    chromArray.get(i).evaluateFitness(objfunc);
                }

                for (Chromosome chrom : chromArray) {
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

                Chromosome bestChrom = chromArray.get(bestIndex);
                System.out.println("\nOn iteration " + (iteration + 1) + ", the best values for the variables found are: " + Arrays.toString(chromArray.get(bestIndex).bitStringValues));
            }
        }
    }
}

package Debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DebugEvolve {
    
    public ArrayList<DebugChromosome> chromArray;
    double sum = 0;
    ArrayList<Double> probArray;
    ArrayList<DebugChromosome> parentArray;
    int chromLen = 0;
    ArrayList<DebugChromosome> childArray;
    
    public DebugEvolve(ArrayList<DebugChromosome> chromosomeArray) {
        chromArray = chromosomeArray;
    }
    
    public void getFitnessSum() {
        for (DebugChromosome chromosome : chromArray) {
            sum += chromosome.fitness;
        }
    }   
    
    public void evaluateProbabilities() {
        int probArraySize = chromArray.size();
        probArray = new ArrayList<>(probArraySize);
        for(int i = 0; i < probArraySize; i++) {
            double x = chromArray.get(i).fitness;
            double probability = x / sum;
            probArray.add(probability);
        }
    }
    
    public void rouletteRank(Random random) {
        float randomNum = random.nextFloat();
        parentArray = new ArrayList<>(chromArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            System.out.println("\nChoosing chromosome " + (i + 1) + ": ");
            if(parentArray.isEmpty()) {
                double bestProb = 0;
                for(int j = 0; j < probArray.size(); j++) {
                    if(probArray.get(j) > bestProb)  {
                        bestProb = probArray.get(j);
                    }  
                }
                int bestIndex = probArray.indexOf(bestProb);
                System.out.println("Surviving parent: " + Arrays.toString(chromArray.get(bestIndex).chromosome));
                parentArray.add(chromArray.get(bestIndex));
            } else {
                double total = 0;
                System.out.println("Random number is " + randomNum);
                for(int k = 0; k < chromArray.size(); k++) {
                    total += probArray.get(k);
                    System.out.println("Total is " + total);
                    if(total >= randomNum) {
                        System.out.println("Total has exceeded random number, adding in chromosome with index " + k + ":");
                        System.out.println(Arrays.toString(chromArray.get(k).chromosome));
                        parentArray.add(chromArray.get(k));
                        total = 0;
                        randomNum = random.nextFloat();
                        break;
                    }
                }      
            }
        }
    }
    
    public void tournamentRank(Random random, int tourneySize) {
        parentArray = new ArrayList<>(chromArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            ArrayList<DebugChromosome> tournamentArray =  new ArrayList<>(tourneySize);
            System.out.println("\nChoosing chromosome " + (i + 1) + ": ");
            for(int j = 0; j < tourneySize; j++) {
                int randomNum = random.nextInt(chromArray.size());
                System.out.println("Random number is " + randomNum);
                System.out.println("Adding chromosome to tournament: " + Arrays.toString(chromArray.get(randomNum).chromosome));
                tournamentArray.add(chromArray.get(randomNum));
            }
            System.out.println("\nComplete tournament is: ");
            for(int j = 0; j < tourneySize; j++) {
                System.out.println(Arrays.toString(tournamentArray.get(j).chromosome));
            }
            double bestFit = 0;
            System.out.println("\nFitnesses of tournament participants: ");
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(tournamentArray.get(j).fitness > bestFit)  {
                    bestFit = tournamentArray.get(j).fitness;
                }  
                System.out.println(tournamentArray.get(j).fitness);
            }
            int bestIndex = 0;
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(tournamentArray.get(j).fitness == bestFit){
                    bestIndex = j;
                    System.out.println("\nTournament winner is chromosome at index " + bestIndex + ": ");
                }
            }
            System.out.println(Arrays.toString(tournamentArray.get(bestIndex).chromosome));
            parentArray.add(tournamentArray.get(bestIndex));
        }     
    }
    
    public void crossover(Random random, int numCuts, int lowerBound, int upperBound, int varNum) {
        chromLen = parentArray.get(0).chromosome.length;
        childArray = new ArrayList<>(parentArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            DebugChromosome c = new DebugChromosome(lowerBound, upperBound, varNum);
            c.generateBitString(random);
            childArray.add(c);
        }
        int numChromPairs = parentArray.size() / 2;
        for(int i = 1; i <= numChromPairs; i++) {
            int[] chromA = parentArray.get((2 * i) - 2).chromosome;
            int[] chromB = parentArray.get((2 * i) - 1).chromosome;
            System.out.println("\nParents to mate: ");
            System.out.println(Arrays.toString(chromA));
            System.out.println(Arrays.toString(chromB));
            int cutPoint;
            for(int j = 0; j < numCuts; j++) {
                cutPoint = random.nextInt(chromLen);
                System.out.println("\nCut point is " + cutPoint + ". (" + numCuts + " cuts total).");
                int[] parentASegmentA;
                int[] parentBSegmentA;
                int[] parentASegmentB;
                int[] parentBSegmentB;
                int[] childA;
                int[] childB;

                parentASegmentA = Arrays.copyOfRange(chromA, 0, cutPoint);
                parentASegmentB = Arrays.copyOfRange(chromA, cutPoint, chromA.length);
                parentBSegmentA = Arrays.copyOfRange(chromB, 0, cutPoint);
                parentBSegmentB = Arrays.copyOfRange(chromB, cutPoint, chromB.length);
                System.out.println("\nChild A will consist of: ");
                System.out.println("Parent 1, Fragment 1: " + Arrays.toString(parentASegmentA));
                System.out.println("Parent 2, Fragment 2: " + Arrays.toString(parentBSegmentB));
                System.out.println("\nChild B will consist of: ");
                System.out.println("Parent 2, Fragment 1: " + Arrays.toString(parentBSegmentA));
                System.out.println("Parent 1, Fragment 2: " + Arrays.toString(parentASegmentB));

                childA = recombine(parentASegmentA, parentBSegmentB);
                childB = recombine(parentBSegmentA, parentASegmentB);
                
                childArray.get((2 * i) - 2).chromosome = childA;
                childArray.get((2 * i) - 1).chromosome = childB;  
            }
        }
        System.out.println("\nChild chromosomes: ");
        for(int i = 0; i < childArray.size(); i++) {
            System.out.println(Arrays.toString(childArray.get(i).chromosome));
        }
        chromArray = childArray;
    }
    
    public static int[] recombine(int[] a, int[] b){
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
        
    
}


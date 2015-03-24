/*
 * The evolve class contains the methods that perform some chromosome evaluation
 * and ranking/crossover of chromosomes.
 */

package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Evolve {
    
    //Declaring class variables.
    public ArrayList<Chromosome> chromArray;
    public double sum = 0;
    public ArrayList<Double> probArray;
    public ArrayList<Chromosome> parentArray;
    public int chromLen = 0;
    public ArrayList<Chromosome> childArray;
    
    //Constructor, takes in a list of chromosomes.
    public Evolve(ArrayList<Chromosome> chromosomeArray) {
        chromArray = chromosomeArray;
    }
    
    //Method to sum the fitness values of the chromosomes in the list.
    public void getFitnessSum() {
        for (Chromosome chromosome : chromArray) {
            sum += chromosome.fitness;
        }
    } 
        
    //Method to calculate probabilities of chromosomes.
    public void evaluateProbabilities() {
        int probArraySize = chromArray.size();
        probArray = new ArrayList<>(probArraySize);
        for(int i = 0; i < probArraySize; i++) {
            double x = chromArray.get(i).fitness;
            double probability = x / sum;
            probArray.add(probability);
        }
    }
    
    //Method to rank chromosomes using the roulette method.
    public void rouletteRank(Random random) {
        float randomNum = random.nextFloat();
        parentArray = new ArrayList<>(chromArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            if(parentArray.isEmpty()) {
                double bestProb = 0;
                for(int j = 0; j < probArray.size(); j++) {
                    if(probArray.get(j) > bestProb)  {
                        bestProb = probArray.get(j);
                    }  
                }
                int bestIndex = probArray.indexOf(bestProb);
                parentArray.add(chromArray.get(bestIndex));
            } else {
                double total = 0;
                for(int k = 0; k < chromArray.size(); k++) {
                    total += probArray.get(k);
                    if(total >= randomNum) {
                        parentArray.add(chromArray.get(k));
                        total = 0;
                        randomNum = random.nextFloat();
                        break;
                    }
                }      
            }
        }
    }
    
    //Roulette ranking method with descripitve print statements for "full results mode"
    public void rouletteRankFR(Random random) {
        float randomNum = random.nextFloat();
        parentArray = new ArrayList<>(chromArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            System.out.println("\n  Choosing chromosome " + (i + 1) + ": ");
            if(parentArray.isEmpty()) {
                double bestProb = 0;
                for(int j = 0; j < probArray.size(); j++) {
                    if(probArray.get(j) > bestProb)  {
                        bestProb = probArray.get(j);
                    }  
                }
                int bestIndex = probArray.indexOf(bestProb);
                System.out.println("  Surviving parent: " + Arrays.toString(chromArray.get(bestIndex).chromosome));
                parentArray.add(chromArray.get(bestIndex));
            } else {
                double total = 0;
                System.out.println("  Random number is " + randomNum);
                for(int k = 0; k < chromArray.size(); k++) {
                    total += probArray.get(k);
                    System.out.println("  Total is " + total);
                    if(total >= randomNum) {
                        System.out.println("  Total has exceeded random number, adding in chromosome with index " + k + ":");
                        System.out.println("  " + Arrays.toString(chromArray.get(k).chromosome));
                        parentArray.add(chromArray.get(k));
                        total = 0;
                        randomNum = random.nextFloat();
                        break;
                    }
                }      
            }
        }
    }
    
    //Method to rank chromosomes using the tournament method (for maximising functions).
    public void tournamentRankMax(Random random, int tourneySize) {
        parentArray = new ArrayList<>(chromArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            ArrayList<Chromosome> tournamentArray =  new ArrayList<>(tourneySize);
            for(int j = 0; j < tourneySize; j++) {
                int randomNum = random.nextInt(chromArray.size());
                tournamentArray.add(chromArray.get(randomNum));
            }
            double bestFit = 0;
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(tournamentArray.get(j).fitness > bestFit)  {
                    bestFit = tournamentArray.get(j).fitness;
                }  
            }
            int bestIndex = 0;
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(tournamentArray.get(j).fitness == bestFit){
                    bestIndex = j;
                }
            }
            parentArray.add(tournamentArray.get(bestIndex));
        }     
    }
    
    //Tournament ranking method with descripitve print statements for "full results mode"
    public void tournamentRankMaxFR(Random random, int tourneySize) {
        parentArray = new ArrayList<>(chromArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            ArrayList<Chromosome> tournamentArray =  new ArrayList<>(tourneySize);
            System.out.println("\n  Choosing chromosome " + (i + 1) + ": ");
            for(int j = 0; j < tourneySize; j++) {
                int randomNum = random.nextInt(chromArray.size());
                System.out.println("  Random number is " + randomNum);
                System.out.println("  Adding chromosome to tournament: " + Arrays.toString(chromArray.get(randomNum).chromosome));
                tournamentArray.add(chromArray.get(randomNum));
            }
            System.out.println("\n  Complete tournament is: ");
            for(int j = 0; j < tourneySize; j++) {
                System.out.println("  " + Arrays.toString(tournamentArray.get(j).chromosome));
            }
            double bestFit = 0;
            System.out.println("\n  Fitnesses of tournament participants: ");
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(tournamentArray.get(j).fitness > bestFit)  {
                    bestFit = tournamentArray.get(j).fitness;
                }  
                System.out.println("  " + tournamentArray.get(j).fitness);
            }
            int bestIndex = 0;
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(tournamentArray.get(j).fitness == bestFit){
                    bestIndex = j;
                    System.out.println("\n  Tournament winner is chromosome at index " + bestIndex + ": ");
                }
            }
            System.out.println("  " + Arrays.toString(tournamentArray.get(bestIndex).chromosome));
            parentArray.add(tournamentArray.get(bestIndex));
        }     
    }
    
    //Method to rank chromosomes using the tournament method (for minimising functions).
    public void tournamentRankMin(Random random, int tourneySize) {
        parentArray = new ArrayList<>(chromArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            ArrayList<Chromosome> tournamentArray =  new ArrayList<>(tourneySize);
            for(int j = 0; j < tourneySize; j++) {
                int randomNum = random.nextInt(chromArray.size());
                tournamentArray.add(chromArray.get(randomNum));
            }
            double bestFit = 0;
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(j == 0) {
                    bestFit = tournamentArray.get(j).fitness;
                }
                if(tournamentArray.get(j).fitness < bestFit)  {
                    bestFit = tournamentArray.get(j).fitness;
                }  
            }
            int bestIndex = 0;
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(tournamentArray.get(j).fitness == bestFit){
                    bestIndex = j;
                }
            }
            parentArray.add(tournamentArray.get(bestIndex));
        }     
    }
    
    //Tournament ranking method with descripitve print statements for "full results mode"
    public void tournamentRankMinFR(Random random, int tourneySize) {
        parentArray = new ArrayList<>(chromArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            ArrayList<Chromosome> tournamentArray =  new ArrayList<>(tourneySize);
            System.out.println("\n  Choosing chromosome " + (i + 1) + ": ");
            for(int j = 0; j < tourneySize; j++) {
                int randomNum = random.nextInt(chromArray.size());
                System.out.println("  Random number is " + randomNum);
                System.out.println("  Adding chromosome to tournament: " + Arrays.toString(chromArray.get(randomNum).chromosome));
                tournamentArray.add(chromArray.get(randomNum));
            }
            System.out.println("\n  Complete tournament is: ");
            for(int j = 0; j < tourneySize; j++) {
                System.out.println("  " + Arrays.toString(tournamentArray.get(j).chromosome));
            }
            double bestFit = 0;
            System.out.println("\n  Fitnesses of tournament participants: ");
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(j == 0) {
                    bestFit = tournamentArray.get(j).fitness;
                }
                if(tournamentArray.get(j).fitness < bestFit)  {
                    bestFit = tournamentArray.get(j).fitness;
                }  
                System.out.println("  " + tournamentArray.get(j).fitness);
            }
            int bestIndex = 0;
            for(int j = 0; j < tournamentArray.size(); j++) {
                if(tournamentArray.get(j).fitness == bestFit){
                    bestIndex = j;
                    System.out.println("\n  Tournament winner is chromosome at index " + bestIndex + ": ");
                }
            }
            System.out.println("  " + Arrays.toString(tournamentArray.get(bestIndex).chromosome));
            parentArray.add(tournamentArray.get(bestIndex));
        }     
    }
    
    //Method for performing crossover of chromosomes.
    public void crossover(Random random, int numCuts, int lowerBound, int upperBound, int varNum) {
        chromLen = parentArray.get(0).chromosome.length;
        childArray = new ArrayList<>(parentArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            Chromosome c = new Chromosome(lowerBound, upperBound, varNum);
            c.generateBitStringInt(random);
            childArray.add(c);
        }
        int numChromPairs = parentArray.size() / 2;
        for(int i = 1; i <= numChromPairs; i++) {
            int[] chromA = parentArray.get((2 * i) - 2).chromosome;
            int[] chromB = parentArray.get((2 * i) - 1).chromosome;
            int cutPoint;
            for(int j = 0; j < numCuts; j++) {
                cutPoint = random.nextInt(chromLen);
                if (cutPoint == 0) {
                    cutPoint++;
                }
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

                childA = recombine(parentASegmentA, parentBSegmentB);
                childB = recombine(parentBSegmentA, parentASegmentB);
                
                childArray.get((2 * i) - 2).chromosome = childA;
                childArray.get((2 * i) - 1).chromosome = childB;        
            }
        }
        chromArray = childArray;
    }
    
    //Crossover method with descripitve print statements for "full results mode"
    public void crossoverFR(Random random, int numCuts, int lowerBound, int upperBound, int varNum) {
        chromLen = parentArray.get(0).chromosome.length;
        childArray = new ArrayList<>(parentArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            Chromosome c = new Chromosome(lowerBound, upperBound, varNum);
            c.generateBitStringInt(random);
            childArray.add(c);
        }
        int numChromPairs = parentArray.size() / 2;
        for(int i = 1; i <= numChromPairs; i++) {
            int[] chromA = parentArray.get((2 * i) - 2).chromosome;
            int[] chromB = parentArray.get((2 * i) - 1).chromosome;
            System.out.println("\n  Mother:  " + Arrays.toString(chromA));
            System.out.println("\n  Father: " + Arrays.toString(chromB));
            int cutPoint;
            for(int j = 0; j < numCuts; j++) {
                cutPoint = random.nextInt(chromLen);
                if (cutPoint == 0) {
                    cutPoint++;
                }
                System.out.println("\n  Cut point is " + cutPoint + ". (" + numCuts + " cut(s) total).");
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
                System.out.println("\n  Brother will consist of: ");
                System.out.println("  Mother, Fragment 1: " + Arrays.toString(parentASegmentA));
                System.out.println("  Father, Fragment 2: " + Arrays.toString(parentBSegmentB));
                System.out.println("\n  Sister will consist of: ");
                System.out.println("  Father, Fragment 1: " + Arrays.toString(parentBSegmentA));
                System.out.println("  Mother, Fragment 2: " + Arrays.toString(parentASegmentB));
                System.out.println("\n  ------------------------------------------------------------------");

                childA = recombine(parentASegmentA, parentBSegmentB);
                childB = recombine(parentBSegmentA, parentASegmentB);
                
                childArray.get((2 * i) - 2).chromosome = childA;
                childArray.get((2 * i) - 1).chromosome = childB;  
            }
        }
        System.out.println("\n  Child chromosomes: ");
        for(int i = 0; i < childArray.size(); i++) {
            System.out.println("  " + Arrays.toString(childArray.get(i).chromosome));
        }
        chromArray = childArray;
    }
    
    //Method to recombine chromosomal fragments into a complete chromosome.
    public static int[] recombine(int[] a, int[] b){
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
        
    
}

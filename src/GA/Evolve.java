package GA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Evolve {
    
    public ArrayList<Chromosome> chromArray;
    double sum = 0;
    ArrayList<Double> probArray;
    ArrayList<Chromosome> parentArray;
    int chromLen = 0;
    ArrayList<Chromosome> childArray;
    
    public Evolve(ArrayList<Chromosome> chromosomeArray) {
        chromArray = chromosomeArray;
    }
    
    public void getFitnessSum() {
        for (Chromosome chromosome : chromArray) {
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
    
    public void crossover(Random random, int numCuts, int lowerBound, int upperBound, int varNum) {
        chromLen = parentArray.get(0).chromosome.length;
        childArray = new ArrayList<>(parentArray.size());
        for(int i = 0; i < chromArray.size(); i++) {
            Chromosome c = new Chromosome(lowerBound, upperBound, varNum);
            c.generateBitString(random);
            childArray.add(c);
        }
        int numChromPairs = parentArray.size() / 2;
        for(int i = 1; i <= numChromPairs; i++) {
            int[] chromA = parentArray.get((2 * i) - 2).chromosome;
            int[] chromB = parentArray.get((2 * i) - 1).chromosome;
            int cutPoint;
            for(int j = 0; j < numCuts; j++) {
                cutPoint = random.nextInt(chromLen);
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
    
    public static int[] recombine(int[] a, int[] b){
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
        
    
}

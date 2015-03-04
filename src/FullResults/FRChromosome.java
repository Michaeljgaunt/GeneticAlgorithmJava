/*
 * A clone of the chromosome class. Provides a slightly different mutate method.
 */

package FullResults;

import GA.ObjectiveFunction;
import java.util.Random;

public class FRChromosome {
    
    private ObjectiveFunction obj;
    
    public int lowerBound,
                upperBound,
                probability,
                numVars,
                bitStringLength;
    
    public int[] chromosome;
    public double[] bitStringValues;        
    
    public double fitness;
    
    public FRChromosome(int lowerBound, int upperBound, int numVars) {
        
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.numVars = numVars;
    }
    
    public void generateBitString(Random random) {
        
       bitStringLength = (int)(Math.ceil(Math.log(upperBound) / Math.log(2)));
       int chromLen = bitStringLength * numVars;
       chromosome = new int[chromLen];
       
       for(int i = 0; i < chromLen; i++) {
           int randomNum = random.nextInt(10) + 1;
           if(randomNum <= 5) {
               chromosome[i] = 0;
           } else {
               chromosome[i] = 1;
           }  
       }
    }
       
    public void convertBitString() {
        
        bitStringValues = new double[numVars];
        int val = 0, power = 0;
        double squeezedVal = 0;
        
        for(int i = 0; i < numVars; i++) {
            for(int j = (bitStringLength * (i + 1)); j > (bitStringLength * i); j--) {
                val += (chromosome[j - 1] * Math.pow(2, power));
                power++;      
            }
            squeezedVal = (lowerBound + (((upperBound - lowerBound) / (Math.pow(2, (chromosome.length / numVars)) - 1)) * val));
            bitStringValues[i] = squeezedVal;
            power = 0;
            val = 0;
        }
    }
    
    public void evaluateFitness(ObjectiveFunction obj) {
        fitness = obj.ObjectiveFunction(bitStringValues);
    }
    
    //Slightly different mutate method that contains descriptive print statements for the 
    //"full results mode" option.
    public void mutate(int mutRate, Random random) {
        int mutCounter = 0;
        for(int i = 0; i < chromosome.length; i++) {
           int randomNum = random.nextInt(100) + 1;
           if(randomNum <= mutRate) {
               mutCounter++;
               System.out.println("  Bit number " + (i + 1) + " has mutated from " + chromosome[i] + " to " + (1 - chromosome[i]) + ".");
               chromosome[i] = 1 - chromosome[i];
           }
        }
        if(mutCounter == 0) {
            System.out.println("  No mutations occured.");
        }
    }
             
}

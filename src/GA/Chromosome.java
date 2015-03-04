/*
 * The chromosome class contains the bit-string and other chromosomal attributes.
 * Various methods are provided to calculate fitness and bit-string value. 
 * A mutation method is also provided.
 */

package GA;

import java.util.Random;

public class Chromosome {
    
    //Declaring class variables.
    private ObjectiveFunction obj;
    
    public int lowerBound,
                upperBound,
                probability,
                numVars,
                bitStringLength;
    
    public int[] chromosome;
    public double[] bitStringValues;        
    
    public double fitness;
    
    //Constructor, takes in the range of values and number of variables.
    public Chromosome(int lowerBound, int upperBound, int numVars) {
        
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.numVars = numVars;
    }
    
    //Method to randomly generate a bitstring.
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
       
    //Method to convert the bitstring to its decimal value.
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
    
    //Method to evaluate chromosomal fitness.
    public void evaluateFitness(ObjectiveFunction obj) {
        fitness = obj.ObjectiveFunction(bitStringValues);
    }
    
    //Method to mutate the chromosome by a given mutation rate.
    public void mutate(int mutRate, Random random) {
        
        for(int i = 0; i < chromosome.length; i++) {
           int randomNum = random.nextInt(100) + 1;
           if(randomNum <= mutRate) {
               chromosome[i] = 1 - chromosome[i];
           }
        }
    }
             
}


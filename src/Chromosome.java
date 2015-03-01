
import java.util.Random;

public class Chromosome {
    
    public ObjectiveFunction obj;
    
    public int lowerBound,
                upperBound,
                probability,
                numVars,
                bitStringLength;
    
    public int[] chromosome;
    public double[] bitStringValues;        
    
    public double fitness;
    
    public Chromosome(int lowerBound, int upperBound, int numVars) {
        
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
        double x = bitStringValues[0];
        double y = bitStringValues[1];
        double z = bitStringValues[2];
        double s = bitStringValues[3];
        fitness = obj.ObjectiveFunction(x, y, z, s);
    }
    
    public void mutate(int mutRate, Random random) {
        
        for(int i = 0; i < chromosome.length; i++) {
           int randomNum = random.nextInt(100) + 1;
           if(randomNum <= mutRate) {
               chromosome[i] = 1 - chromosome[i];
           }
        }
    }
             
}


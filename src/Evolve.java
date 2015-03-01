
import java.util.ArrayList;
import java.util.Random;

public class Evolve {
    
    ArrayList<Chromosome> chromArray;
    double sum = 0;
    ArrayList<Double> probArray;
    ArrayList<Chromosome> parentArray;
    
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
    
    public void roulette_rank(Random random) {
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
    
}

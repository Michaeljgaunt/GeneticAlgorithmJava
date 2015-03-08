/*
 * The Driver class contains the main method that launches the program.
 */

package Controllers;

import Model.Chromosome;
import Model.Evolve;
import Views.DiscreteTypes;
import Enums.Enums.*;
import Model.ObjectiveFunction;
import Views.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Driver {
    
    //Declaring class variables.
    public static int menuState;
    public static int numIts;
    public static int chromNum;
    public static int varNum;
    public static int lowerBound;
    public static int upperBound;
    public static int numCuts;
    public static int prMutRate;
    public static int seMutRate;
    public static int tourneySize;
    public static int fitnessThreshold;    
    static boolean frFlag;
    static boolean rouletteFlag;
    static boolean tournamentFlag;
    static boolean minFlag;
    static boolean maxFlag;
    static boolean dynamicMutFlag;
    
    public static MainMenu menu;
    
    public static void main(String args[]) {
        //Initialising the GUI.
        menu = new MainMenu();
        menu.setVisible(true);

    }
    
    public static void getMenuChoice() {
        menuState = menu.getMenuState();
        //If discrete values is selected:
        if(menuState == 0) {
            menu.setVisible(false);
            DiscreteTypes x = new DiscreteTypes();
            x.setVisible(true);          
        //If real values is selected:
        } else if(menuState == 1) {
            menu.setVisible(false);
            RealTypes x = new RealTypes();
            x.setVisible(true);
        }
    }
    
    public static void runBitStrings() {
        //Setting class variables as the values entered on the DiscreteTypes.
        numIts = DiscreteTypes.getNumIts();
        chromNum = DiscreteTypes.getChromNum();
        varNum = DiscreteTypes.getVarNum();
        lowerBound = DiscreteTypes.getLowerBound();
        upperBound = DiscreteTypes.getUpperBound();
        numCuts = DiscreteTypes.getNumCuts();
        prMutRate = DiscreteTypes.getPrMutRate();
        seMutRate = DiscreteTypes.getSeMutRate();
        fitnessThreshold = DiscreteTypes.getFitThreshold();
        tourneySize = DiscreteTypes.getTourneySize();
        frFlag = DiscreteTypes.isFullResultsSelected();
        dynamicMutFlag = DiscreteTypes.isDynamicMutationSelected();
                
        //Setting the mutation changed flag.
        boolean mutChanged = false;

        //Setting the ranking method chosen by the user.
        RankingMethod rank = DiscreteTypes.getRankButState();
        
        switch(rank) {
            case ROULETTE:
                rouletteFlag = true;
                tournamentFlag = false;
                break;
            case TOURNAMENT:
                rouletteFlag = false;
                tournamentFlag = true;
                break;
        }
        
        //Setting the optimisation method chosen by the user.
        Optimisation optimisation = DiscreteTypes.getOptimization();
        switch(optimisation) {
            case MINIMISE:
                maxFlag = false;
                minFlag = true;
                break;
            case MAXIMISE:
                maxFlag = true;
                minFlag = false;
                break;
        }
        
        //Executes if the user selects "minimise"
        if(minFlag) {
            //Executes if the user selects "Full results mode"
            if(frFlag) {

                Random random = new Random();
                ObjectiveFunction objfunc = new ObjectiveFunction();

                System.out.println("  Full results mode (minimising objective function).");            
                System.out.println("  Iterating " + numIts + " times.");
                System.out.println("  Generating " + chromNum + " chromosomes with " + varNum + " variables in the range " + lowerBound + " - " + upperBound + ".");
                System.out.println("  During crossover, " + numCuts + " cut(s) will be made.");
                System.out.println("  A mutation rate of " + prMutRate + "% will be applied.");
                if(dynamicMutFlag) {
                    System.out.println("  The mutation rate will be lowered to " + seMutRate + "% if a chromosome reaches the threshold fitness of " + fitnessThreshold + ".");
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                System.out.println("\n  Generating chromosomes:");
                ArrayList<Chromosome> chromArray = new ArrayList<>(chromNum);
                
                //Generating chromosomes and setting chromosomal attributes.
                for(int i = 0; i < chromNum; i++) {
                    System.out.println("\n  Chromosome " + (i + 1) + ": ");
                    Chromosome c = new Chromosome(lowerBound, upperBound, varNum);
                    c.generateBitString(random);
                    System.out.println("  " + Arrays.toString(c.chromosome));
                    c.convertBitString();
                    System.out.println("  Values: " + Arrays.toString(c.bitStringValues));
                    c.evaluateFitness(objfunc);
                    System.out.println("  Fitness: " + c.fitness);
                    chromArray.add(c);
                }
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for(int iteration = 0; iteration < numIts; iteration++) {
                    System.out.println("\n  Iteration " + (iteration + 1) + ":");
                    for (Chromosome chrom : chromArray) {
                        System.out.println("  " + Arrays.toString(chrom.chromosome));
                    }    

                    //Evaluating chromosomes and ranking.
                    Evolve evolve = new Evolve(chromArray);
                    evolve.getFitnessSum();
                    System.out.println("\n  Sigma fitness is " + evolve.sum);
                    System.out.println("\n  Probabilities are: " + evolve.probArray);
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    if(tournamentFlag) {
                        System.out.println("\n  Ranking parents (tournament method, size " + tourneySize + "):");
                        evolve.tournamentRankMinFR(random, tourneySize);
                    }
                    System.out.println("\n  Chosen parents: ");
                    for (Chromosome parentArray : evolve.parentArray) {
                        System.out.println(Arrays.toString(parentArray.chromosome));
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    //Crossover and mutation of chromosomes.
                    System.out.println("\nPerforming crossover:");
                    evolve.crossoverFR(random, numCuts, lowerBound, upperBound, varNum);
                    for(int i = 0; i < chromNum; i++) {       
                        chromArray = evolve.chromArray;
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    if(prMutRate == 0) {
                        System.out.println("\n  Mutation rate is 0%, no mutation will be applied.");
                    } else {
                        System.out.println("\n  Applying mutation rate of " + prMutRate + "%...");
                        for(int i = 0; i < chromNum; i++) {
                            System.out.println("\n  Chromosome " + (i + 1) + ": ");
                            chromArray.get(i).mutateFR(prMutRate, random);
                        }
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    //Evaluating chromosomes.
                    double bestFit = 0;

                    System.out.println("\n  Evaluating chromosomes...");
                    for(int i = 0; i < chromNum; i++) {
                        System.out.println("\n  Chromosome " + (i + 1) + ": ");
                        chromArray.get(i).convertBitString();
                        System.out.println("  Values: " + Arrays.toString(chromArray.get(i).bitStringValues));
                        chromArray.get(i).evaluateFitness(objfunc);
                        System.out.println("  Fitness: " + chromArray.get(i).fitness);
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    //Finding the chromosome with the best fitness.
                    for (int i = 0; i < chromArray.size(); i++) {
                        if(i == 0) {
                            bestFit = chromArray.get(i).fitness;
                        }
                        if (chromArray.get(i).fitness < bestFit) {
                            bestFit = chromArray.get(i).fitness;
                        }
                    } 

                    int bestIndex = 0;
                    for (int i = 0; i < chromArray.size(); i++) {
                        if(chromArray.get(i).fitness == bestFit){
                            bestIndex = i;
                            if((bestFit <= fitnessThreshold) && (dynamicMutFlag) && (mutChanged == false)) {
                                System.out.println("  A chromosome has exceeded the fitness threshold, lowering mutation rate to " + seMutRate + "%.");
                                prMutRate = seMutRate;
                                mutChanged = true;
                            }
                        }
                    }

                    System.out.println("\n  On iteration " + (iteration + 1) + ", the best values for the variables found are: " + Arrays.toString(chromArray.get(bestIndex).bitStringValues));
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            
            //If full results mode is not selected
            } else {
                System.out.println("  Concise results mode (minimising objective function).");
                Random random = new Random();
                ObjectiveFunction objfunc = new ObjectiveFunction();

                System.out.println("\n  Randomly generating " + chromNum + " chromosomes...");
                ArrayList<Chromosome> chromArray = new ArrayList<>(chromNum);
                System.out.println("  Evaluating chromosomes...");
                
                //Generating chromosomes and setting chromosomal attributes.
                for(int i = 0; i < chromNum; i++) {
                    Chromosome c = new Chromosome(lowerBound, upperBound, varNum);
                    c.generateBitString(random);
                    c.convertBitString();
                    c.evaluateFitness(objfunc);
                    chromArray.add(c);
                }

                for(int iteration = 0; iteration < numIts; iteration++) {

                    System.out.println("\n  Iteration " + (iteration + 1) + ":");

                    //Evaluating chromosomes and ranking.
                    Evolve evolve = new Evolve(chromArray);
                    evolve.getFitnessSum();
                    if(rouletteFlag) {
                        System.out.println("  Ranking parents (roulette method)...");
                        evolve.rouletteRank(random);
                    } else if(tournamentFlag) {
                        System.out.println("  Ranking parents (tournament method, size " + tourneySize + ")...");
                        evolve.tournamentRankMin(random, tourneySize);
                    }

                    //Crossover and mutation of chromosomes.
                    System.out.println("  Performing crossover...");
                    evolve.crossover(random, numCuts, lowerBound, upperBound, varNum);
                    for(int i = 0; i < chromNum; i++) {
                        chromArray = evolve.chromArray;
                    }

                    if(prMutRate == 0) {
                        System.out.println("  Mutation rate is 0%, no mutation will be applied.");
                    } else {
                        System.out.println("  Applying mutation rate of " + prMutRate + "%...");
                        for(int i = 0; i < chromNum; i++) {
                            chromArray.get(i).mutate(prMutRate, random);
                        }
                    }

                    //Evaluating chromosomes.
                    double bestFit = 0;

                    System.out.println("  Evaluating chromosomes...");
                    for(int i = 0; i < chromNum; i++) {
                        chromArray.get(i).convertBitString();
                        chromArray.get(i).evaluateFitness(objfunc);
                    }

                    //Finding chromosomes with best fitness.
                    for (int i = 0; i < chromArray.size(); i++) {
                        if(i == 0) {
                            bestFit = chromArray.get(i).fitness;
                        }
                        if (chromArray.get(i).fitness < bestFit) {
                            bestFit = chromArray.get(i).fitness;
                        }
                    }

                    int bestIndex = 0;
                    for (int i = 0; i < chromArray.size(); i++) {
                        if(chromArray.get(i).fitness == bestFit){
                            bestIndex = i;
                            if((bestFit <= fitnessThreshold) && (dynamicMutFlag) && (mutChanged == false)) {
                                System.out.println("  A chromosome has exceeded the fitness threshold, lowering mutation rate to " + seMutRate + "%.");
                                prMutRate = seMutRate;
                                mutChanged = true;
                            }
                        }
                    }

                    System.out.println("\n  Best values found on iteration " + (iteration + 1) + ": " + Arrays.toString(chromArray.get(bestIndex).bitStringValues));
                }
            }
            
        //Executes if the user selects "maximise"
        } if(maxFlag) {           
            //Executes if the user selects "Full results mode"
            if(frFlag) {

                Random random = new Random();
                ObjectiveFunction objfunc = new ObjectiveFunction();

                System.out.println("  Full results mode (maximising objective function).");            
                System.out.println("  Iterating " + numIts + " times.");
                System.out.println("  Generating " + chromNum + " chromosomes with " + varNum + " variables in the range " + lowerBound + " - " + upperBound + ".");
                System.out.println("  During crossover, " + numCuts + " cut(s) will be made.");
                System.out.println("  A mutation rate of " + prMutRate + "% will be applied.");
                if(dynamicMutFlag) {
                    System.out.println("  The mutation rate will be lowered to " + seMutRate + "% if a chromosome reaches the threshold fitness of " + fitnessThreshold + ".");
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                System.out.println("\n  Generating chromosomes:");
                ArrayList<Chromosome> chromArray = new ArrayList<>(chromNum);
                
                //Generating chromosomes and setting chromosomal attributes.
                for(int i = 0; i < chromNum; i++) {
                    System.out.println("\n  Chromosome " + (i + 1) + ": ");
                    Chromosome c = new Chromosome(lowerBound, upperBound, varNum);
                    c.generateBitString(random);
                    System.out.println("  " + Arrays.toString(c.chromosome));
                    c.convertBitString();
                    System.out.println("  Values: " + Arrays.toString(c.bitStringValues));
                    c.evaluateFitness(objfunc);
                    System.out.println("  Fitness: " + c.fitness);
                    chromArray.add(c);
                }
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for(int iteration = 0; iteration < numIts; iteration++) {

                    System.out.println("\n  Iteration " + (iteration + 1) + ":");
                    for(int i = 0; i < chromArray.size(); i++) {
                        System.out.println("  " + Arrays.toString(chromArray.get(i).chromosome));
                    }    

                    //Evaluating chromosomes and ranking.
                    Evolve evolve = new Evolve(chromArray);
                    evolve.getFitnessSum();
                    System.out.println("\n  Sigma fitness is " + evolve.sum);
                    evolve.evaluateProbabilities();
                    System.out.println("\n  Probabilities are: " + evolve.probArray);
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    if(rouletteFlag) {
                        System.out.println("\n  Ranking parents (roulette method):");
                        evolve.rouletteRankFR(random);
                    } else if(tournamentFlag) {
                        System.out.println("\n  Ranking parents (tournament method, size " + tourneySize + "):");
                        evolve.tournamentRankMaxFR(random, tourneySize);
                    }
                    System.out.println("\n  Chosen parents: ");
                    for(int i = 0; i < evolve.parentArray.size(); i++) {
                        System.out.println(Arrays.toString(evolve.parentArray.get(i).chromosome));
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    //Crossover and mutation of chromosomes.
                    System.out.println("\nPerforming crossover:");
                    evolve.crossoverFR(random, numCuts, lowerBound, upperBound, varNum);
                    for(int i = 0; i < chromNum; i++) {       
                        chromArray = evolve.chromArray;
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    if(prMutRate == 0) {
                        System.out.println("\n  Mutation rate is 0%, no mutation will be applied.");
                    } else {
                        System.out.println("\n  Applying mutation rate of " + prMutRate + "%...");
                        for(int i = 0; i < chromNum; i++) {
                            System.out.println("\n  Chromosome " + (i + 1) + ": ");
                            chromArray.get(i).mutateFR(prMutRate, random);
                        }
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    //Evaluating chromosomes.
                    double bestFit = 0;

                    System.out.println("\n  Evaluating chromosomes...");
                    for(int i = 0; i < chromNum; i++) {
                        System.out.println("\n  Chromosome " + (i + 1) + ": ");
                        chromArray.get(i).convertBitString();
                        System.out.println("  Values: " + Arrays.toString(chromArray.get(i).bitStringValues));
                        chromArray.get(i).evaluateFitness(objfunc);
                        System.out.println("  Fitness: " + chromArray.get(i).fitness);
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    //Finding chromosomes with best fitness.
                    for (int i = 0; i < chromArray.size(); i++) {
                        if (chromArray.get(i).fitness > bestFit) {
                            bestFit = chromArray.get(i).fitness;
                        }
                    } 

                    int bestIndex = 0;
                    for (int i = 0; i < chromArray.size(); i++) {
                        if(chromArray.get(i).fitness == bestFit){
                            bestIndex = i;
                            if((bestFit >= fitnessThreshold) && (dynamicMutFlag) && (mutChanged == false)) {
                                System.out.println("  A chromosome has exceeded the fitness threshold, lowering mutation rate to " + seMutRate + "%.");
                                prMutRate = seMutRate;
                                mutChanged = true;
                            }
                        }
                    }

                    System.out.println("\n  On iteration " + (iteration + 1) + ", the best values for the variables found are: " + Arrays.toString(chromArray.get(bestIndex).bitStringValues));
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }

            //If full results mode is not selected.
            } else {
                System.out.println("  Concise results mode (maximising objective function).");
                Random random = new Random();
                ObjectiveFunction objfunc = new ObjectiveFunction();

                System.out.println("\n  Randomly generating " + chromNum + " chromosomes...");
                ArrayList<Chromosome> chromArray = new ArrayList<>(chromNum);
                System.out.println("  Evaluating chromosomes...");
                
                //Generating chromosomes and setting chromosomal attributes
                for(int i = 0; i < chromNum; i++) {
                    Chromosome c = new Chromosome(lowerBound, upperBound, varNum);
                    c.generateBitString(random);
                    c.convertBitString();
                    c.evaluateFitness(objfunc);
                    chromArray.add(c);
                }

                for(int iteration = 0; iteration < numIts; iteration++) {

                    System.out.println("\n  Iteration " + (iteration + 1) + ":");

                    //Evaluating chromosomes and ranking.
                    Evolve evolve = new Evolve(chromArray);
                    evolve.getFitnessSum();
                    evolve.evaluateProbabilities();
                    if(rouletteFlag) {
                        System.out.println("  Ranking parents (roulette method)...");
                        evolve.rouletteRank(random);
                    } else if(tournamentFlag) {
                        System.out.println("  Ranking parents (tournament method, size " + tourneySize + ")...");
                        evolve.tournamentRankMax(random, tourneySize);
                    }

                    //Crossover and mutation of chromosomes.
                    System.out.println("  Performing crossover...");
                    evolve.crossover(random, numCuts, lowerBound, upperBound, varNum);
                    for(int i = 0; i < chromNum; i++) {
                        chromArray = evolve.chromArray;
                    }

                    if(prMutRate == 0) {
                        System.out.println("  Mutation rate is 0%, no mutation will be applied.");
                    } else {
                        System.out.println("  Applying mutation rate of " + prMutRate + "%...");
                        for(int i = 0; i < chromNum; i++) {
                            chromArray.get(i).mutate(prMutRate, random);
                        }
                    }

                    //Evaluating chromosomes.
                    double bestFit = 0;

                    System.out.println("  Evaluating chromosomes...");
                    for(int i = 0; i < chromNum; i++) {
                        chromArray.get(i).convertBitString();
                        chromArray.get(i).evaluateFitness(objfunc);
                    }

                    for (int i = 0; i < chromArray.size(); i++) {
                        if (chromArray.get(i).fitness > bestFit) {
                            bestFit = chromArray.get(i).fitness;
                        }
                    }

                    //Finding chromosome with best fitness.
                    int bestIndex = 0;
                    for (int i = 0; i < chromArray.size(); i++) {
                        if(chromArray.get(i).fitness == bestFit){
                            bestIndex = i;
                            if((bestFit >= fitnessThreshold) && (dynamicMutFlag) && (mutChanged == false)) {
                                System.out.println("  A chromosome has exceeded the fitness threshold, lowering mutation rate to " + seMutRate + "%.");
                                prMutRate = seMutRate;
                                mutChanged = true;
                            }
                        }
                    }

                    System.out.println("\n  Best values found on iteration " + (iteration + 1) + ": " + Arrays.toString(chromArray.get(bestIndex).bitStringValues));
                }
            }
        }
    }                                    
}

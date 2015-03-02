package GA;

import Debug.DebugChromosome;
import Debug.DebugEvolve;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;

public class GUI extends javax.swing.JFrame {

    public int numIts;
    public int chromNum;
    public int varNum;
    public int lowerBound;
    public int upperBound;
    public int numCuts;
    public int mutRate;
    public int tourneySize;
    
    static boolean debugFlag;
    static boolean rouletteFlag;
    static boolean tournamentFlag;
    
    public GUI() {
        initComponents();
        PrintStream printStream = new PrintStream(new CustomOutputStream(outputWindow));
        System.setOut(printStream);
        System.setErr(printStream);
        this.setIconImage(new ImageIcon(getClass().getResource("/res/dna_helix.png")).getImage());  
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rankButs = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        numChromsSp = new javax.swing.JSpinner();
        lowerBoundSp = new javax.swing.JSpinner();
        numCutsSp = new javax.swing.JSpinner();
        numVarsSp = new javax.swing.JSpinner();
        numItsSp = new javax.swing.JSpinner();
        upperBoundSp = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        rouletteRankBut = new javax.swing.JRadioButton();
        tournamentRankBut = new javax.swing.JRadioButton();
        frModeBut = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        tourneySizeSp = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        prMutRateBut = new javax.swing.JSlider();
        dynamicMutBut = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        fitnessThreshold = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        seMutRateBut = new javax.swing.JSlider();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputWindow = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        runButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Genetic Algorithm");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "  Variable Options  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Lower Bound");

        jLabel2.setText("Upper Bound");

        jLabel3.setText("Number of Chromosomes");

        jLabel4.setText("Number of Iterations");

        jLabel5.setText("Number of Cuts");

        jLabel7.setText("Number of Variables");

        numChromsSp.setValue(4);

        lowerBoundSp.setValue(2);

        numCutsSp.setValue(1);

        numVarsSp.setValue(2);

        numItsSp.setValue(5);

        upperBoundSp.setValue(31);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numChromsSp, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lowerBoundSp)
                    .addComponent(numCutsSp))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numVarsSp, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(numItsSp)
                    .addComponent(upperBoundSp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lowerBoundSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperBoundSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numChromsSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numItsSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCutsSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(numVarsSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "  Mode Options  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        rankButs.add(rouletteRankBut);
        rouletteRankBut.setText("Roulette Ranking");
        rouletteRankBut.setSelected(true);
        rouletteRankBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rouletteRankButActionPerformed(evt);
            }
        });

        rankButs.add(tournamentRankBut);
        tournamentRankBut.setText("Tournament Ranking");

        frModeBut.setText("Full Results Output");

        jLabel6.setText("Tournament Size");

        tourneySizeSp.setValue(3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frModeBut)
                    .addComponent(rouletteRankBut)
                    .addComponent(tournamentRankBut)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tourneySizeSp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rouletteRankBut, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tournamentRankBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tourneySizeSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(frModeBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "  Mutation Rate (%)  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        prMutRateBut.setMajorTickSpacing(5);
        prMutRateBut.setMinorTickSpacing(1);
        prMutRateBut.setPaintLabels(true);
        prMutRateBut.setPaintTicks(true);
        prMutRateBut.setSnapToTicks(true);
        prMutRateBut.setValue(5);

        dynamicMutBut.setText("Dynamically Lower to Secondary Rate if threshold is reached.");
        dynamicMutBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicMutButActionPerformed(evt);
            }
        });

        jLabel9.setText("Fitness Threshold");

        jLabel10.setText("Primary Rate");

        seMutRateBut.setMajorTickSpacing(5);
        seMutRateBut.setMinorTickSpacing(1);
        seMutRateBut.setPaintLabels(true);
        seMutRateBut.setPaintTicks(true);
        seMutRateBut.setSnapToTicks(true);
        seMutRateBut.setValue(5);

        jLabel11.setText("Seciondary Rate");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fitnessThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dynamicMutBut)
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seMutRateBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prMutRateBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prMutRateBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(seMutRateBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fitnessThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dynamicMutBut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        outputWindow.setColumns(20);
        outputWindow.setRows(5);
        outputWindow.setText("\nThis program uses a genetic algorithm to maximise an objective function."
            + "\nUse the above controls to fine tune how you want the algorithm to perform."
            + "\n"
            + "\nSet the lower bound and upper bound to define the range in which you want the generated variables to be within."
            + "\nThe higher your upper bound, the more chromosomes you should set to ensure a good variety of values."
            + "\nAs the range increases, the number of iterations should also be increased."
            + "\nAs the upper bound increases, the number of cuts should be reasonably raised."
            + "\n"
            + "\nRoulette ranking ranks the chromosomes based on weighted probabilites."
            + "\nTournament ranking ranks chromosomes based on the 'best' in a tournament setting."
            + "\nTo have no ranking in effect, select tournament ranking with a size of 1. This will"
            + "\npick chromosomes at random."
            + "\n"
            + "\nA high mutation rate means a greater range of values will be 'explored'."
            + "\nA low mutation rate means a smaller range of values will be 'explored',"
            + "\nbut the range of values that is explored will be more thoroughly 'exploited'"
            + "\n"
            + "\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        jScrollPane1.setViewportView(outputWindow);

        jLabel8.setText("Output: ");

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runButton)
                    .addComponent(clearButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed

        numIts = (Integer)numItsSp.getValue();
        chromNum = (Integer)numChromsSp.getValue();
        varNum = (Integer)numVarsSp.getValue();
        lowerBound = (Integer)lowerBoundSp.getValue();
        upperBound = (Integer)upperBoundSp.getValue();
        numCuts = (Integer)numCutsSp.getValue();
        mutRate = (Integer)prMutRateBut.getValue();
        boolean mutChanged = false;
        tourneySize = (Integer)tourneySizeSp.getValue();
        if(rouletteRankBut.isSelected()) {
            rouletteFlag = true;
            tournamentFlag = false;
        } else if(tournamentRankBut.isSelected()) {
            tournamentFlag = true;
            rouletteFlag = false;
        }
        if(frModeBut.isSelected()) {
            debugFlag = true;
        } else {
            debugFlag = false;
        }

        if(debugFlag) {
                   
            Random random = new Random();
            ObjectiveFunction objfunc = new ObjectiveFunction();

            System.out.println("Full results mode.");            
            System.out.println("Iterating " + numIts + " times.");
            System.out.println("Generating " + chromNum + " chromosomes with " + varNum + " variables in the range " + lowerBound + " - " + upperBound + ".");
            System.out.println("During crossover, " + numCuts + " cut(s) will be made.");
            System.out.println("A mutation rate of " + mutRate + "% will be applied.");
            if(dynamicMutBut.isSelected()) {
                System.out.println("The mutation rate will be lowered to " + seMutRateBut.getValue() + "% if a chromosome reaches the threshold fitness of " + fitnessThreshold.getValue() + ".");
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

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
            System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

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
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                if(rouletteFlag) {
                    System.out.println("\nRanking parents (roulette method):");
                    evolve.rouletteRank(random);
                } else if(tournamentFlag) {
                    System.out.println("\nRanking parents (tournament method, size " + tourneySize + "):");
                    evolve.tournamentRank(random, tourneySize);
                }
                System.out.println("\nChosen parents: ");
                for(int i = 0; i < evolve.parentArray.size(); i++) {
                    System.out.println(Arrays.toString(evolve.parentArray.get(i).chromosome));
                }
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                System.out.println("\nPerforming crossover:");
                evolve.crossover(random, numCuts, lowerBound, upperBound, varNum);
                for(int i = 0; i < chromNum; i++) {       
                    chromArray = evolve.chromArray;
                }
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                if(mutRate == 0) {
                    System.out.println("\nMutation rate is 0%, no mutation will be applied.");
                } else {
                    System.out.println("\nApplying mutation rate of " + mutRate + "%...");
                    for(int i = 0; i < chromNum; i++) {
                        System.out.println("\nChromosome " + (i + 1) + ": ");
                        chromArray.get(i).mutate(mutRate, random);
                    }
                }
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                double bestFit = 0;

                System.out.println("\nEvaluating chromosomes...");
                for(int i = 0; i < chromNum; i++) {
                    System.out.println("\nChromosome " + (i + 1) + ": ");
                    chromArray.get(i).convertBitString();
                    System.out.println("Values: " + Arrays.toString(chromArray.get(i).bitStringValues));
                    chromArray.get(i).evaluateFitness(objfunc);
                    System.out.println("Fitness: " + chromArray.get(i).fitness);
                }
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (DebugChromosome chrom : chromArray) {
                    if (chrom.fitness > bestFit) {
                        bestFit = chrom.fitness;
                    }
                } 

                int bestIndex = 0;
                for (int i = 0; i < chromArray.size(); i++) {
                    if(chromArray.get(i).fitness == bestFit){
                        bestIndex = i;
                        if((bestFit >= (Integer)fitnessThreshold.getValue()) && (dynamicMutBut.isSelected()) && (mutChanged == false)) {
                            System.out.println("A chromosome has exceeded the fitness threshold, lowering mutation rate to " + (Integer)seMutRateBut.getValue() + "%.");
                            mutRate = (Integer)seMutRateBut.getValue();
                            mutChanged = true;
                        }
                    }
                }

                DebugChromosome bestChrom = chromArray.get(bestIndex);
                System.out.println("\nOn iteration " + (iteration + 1) + ", the best values for the variables found are: " + Arrays.toString(chromArray.get(bestIndex).bitStringValues));
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            
        } else {
            System.out.println("Concise results mode.");
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

                System.out.println("\nIteration " + (iteration + 1) + ":");

                Evolve evolve = new Evolve(chromArray);
                evolve.getFitnessSum();
                evolve.evaluateProbabilities();
                if(rouletteFlag) {
                    System.out.println("Ranking parents (roulette method)...");
                    evolve.rouletteRank(random);
                } else if(tournamentFlag) {
                    System.out.println("Ranking parents (tournament method, size " + tourneySize + ")...");
                    evolve.tournamentRank(random, tourneySize);
                }

                System.out.println("Performing crossover...");
                evolve.crossover(random, numCuts, lowerBound, upperBound, varNum);
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
                        if((bestFit >= (Integer)fitnessThreshold.getValue()) && (dynamicMutBut.isSelected()) && (mutChanged == false)) {
                            System.out.println("A chromosome has exceeded the fitness threshold, lowering mutation rate to " + (Integer)seMutRateBut.getValue() + "%.");
                            mutRate = (Integer)seMutRateBut.getValue();
                            mutChanged = true;
                        }
                    }
                }

                Chromosome bestChrom = chromArray.get(bestIndex);
                System.out.println("\nBest values found on iteration " + (iteration + 1) + ": " + Arrays.toString(chromArray.get(bestIndex).bitStringValues));
            }
        }
    }//GEN-LAST:event_runButtonActionPerformed

    private void rouletteRankButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rouletteRankButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rouletteRankButActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        outputWindow.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void dynamicMutButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicMutButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dynamicMutButActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JCheckBox dynamicMutBut;
    private javax.swing.JSpinner fitnessThreshold;
    private javax.swing.JCheckBox frModeBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner lowerBoundSp;
    private javax.swing.JSpinner numChromsSp;
    private javax.swing.JSpinner numCutsSp;
    private javax.swing.JSpinner numItsSp;
    private javax.swing.JSpinner numVarsSp;
    private javax.swing.JTextArea outputWindow;
    private javax.swing.JSlider prMutRateBut;
    private javax.swing.ButtonGroup rankButs;
    private javax.swing.JRadioButton rouletteRankBut;
    private javax.swing.JButton runButton;
    private javax.swing.JSlider seMutRateBut;
    private javax.swing.JRadioButton tournamentRankBut;
    private javax.swing.JSpinner tourneySizeSp;
    private javax.swing.JSpinner upperBoundSp;
    // End of variables declaration//GEN-END:variables
}

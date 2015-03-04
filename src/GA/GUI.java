/*
 * The GUI class contains the bulk of the code that drives the GA and all of the
 * code that defines the interface.
 */

package GA;

import FullResults.FRChromosome;
import FullResults.FREvolve;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;

public class GUI extends javax.swing.JFrame {

    //Declaring class variables.
    public int numIts;
    public int chromNum;
    public int varNum;
    public int lowerBound;
    public int upperBound;
    public int numCuts;
    public int mutRate;
    public int tourneySize;
    
    static boolean frFlag;
    static boolean rouletteFlag;
    static boolean tournamentFlag;
    static boolean minFlag;
    static boolean maxFlag;
    
    //Constructor method. Initializes the interface, redefines the System output
    //to the interface and sets the program's icon.
    public GUI() {
        initComponents();
        PrintStream printStream = new PrintStream(new CustomOutputStream(outputWindow));
        System.setOut(printStream);
        System.setErr(printStream);
        this.setIconImage(new ImageIcon(getClass().getResource("/res/dna_helix.png")).getImage());  
    }

    //Method to build the interface.
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rankButs = new javax.swing.ButtonGroup();
        funcButs = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        variablePanel = new javax.swing.JPanel();
        lowerBoundLabel = new javax.swing.JLabel();
        upperBoundLabel = new javax.swing.JLabel();
        chromLabel = new javax.swing.JLabel();
        itLabel = new javax.swing.JLabel();
        cutsLabel = new javax.swing.JLabel();
        varLabel = new javax.swing.JLabel();
        numChromsSp = new javax.swing.JSpinner();
        lowerBoundSp = new javax.swing.JSpinner();
        numCutsSp = new javax.swing.JSpinner();
        numVarsSp = new javax.swing.JSpinner();
        numItsSp = new javax.swing.JSpinner();
        upperBoundSp = new javax.swing.JSpinner();
        mutPanel = new javax.swing.JPanel();
        prMutRateBut = new javax.swing.JSlider();
        dynamicMutBut = new javax.swing.JCheckBox();
        fitThreshLabel = new javax.swing.JLabel();
        fitnessThreshold = new javax.swing.JSpinner();
        prmrLabel = new javax.swing.JLabel();
        seMutRateBut = new javax.swing.JSlider();
        semrLabel = new javax.swing.JLabel();
        prmrLab = new javax.swing.JLabel();
        semrLab = new javax.swing.JLabel();
        outputPanel = new javax.swing.JScrollPane();
        outputWindow = new javax.swing.JTextArea();
        controlPanel = new javax.swing.JPanel();
        runButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        rankPanel = new javax.swing.JPanel();
        rouletteRankBut = new javax.swing.JRadioButton();
        tournamentRankBut = new javax.swing.JRadioButton();
        tourneySizeLabel = new javax.swing.JLabel();
        tourneySizeSp = new javax.swing.JSpinner();
        funcPanel = new javax.swing.JPanel();
        minimiseBut = new javax.swing.JRadioButton();
        maximiseBut = new javax.swing.JRadioButton();
        frModeBut = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Genetic Algorithm");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        variablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "  Variable Options  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lowerBoundLabel.setText("Lower Bound");

        upperBoundLabel.setText("Upper Bound");

        chromLabel.setText("Chromosomes");

        itLabel.setText("Iterations");

        cutsLabel.setText("Cuts");

        varLabel.setText("Variables");

        numChromsSp.setValue(4);

        lowerBoundSp.setValue(0);

        numCutsSp.setValue(1);

        numVarsSp.setValue(3);

        numItsSp.setValue(50);

        upperBoundSp.setValue(31);

        javax.swing.GroupLayout variablePanelLayout = new javax.swing.GroupLayout(variablePanel);
        variablePanel.setLayout(variablePanelLayout);
        variablePanelLayout.setHorizontalGroup(
            variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(variablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(variablePanelLayout.createSequentialGroup()
                        .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lowerBoundLabel)
                            .addComponent(chromLabel))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, variablePanelLayout.createSequentialGroup()
                        .addComponent(cutsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numChromsSp)
                    .addComponent(numCutsSp)
                    .addComponent(lowerBoundSp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itLabel)
                    .addComponent(varLabel)
                    .addComponent(upperBoundLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(upperBoundSp, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(numItsSp)
                    .addComponent(numVarsSp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        variablePanelLayout.setVerticalGroup(
            variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(variablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowerBoundLabel)
                    .addComponent(upperBoundLabel)
                    .addComponent(lowerBoundSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperBoundSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numChromsSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chromLabel)
                    .addComponent(itLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numItsSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCutsSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cutsLabel)
                    .addComponent(numVarsSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varLabel))
                .addContainerGap())
        );

        mutPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "  Mutation Rate (%)  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        prMutRateBut.setMajorTickSpacing(5);
        prMutRateBut.setMinorTickSpacing(1);
        prMutRateBut.setSnapToTicks(true);
        prMutRateBut.setValue(32);
        prMutRateBut.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                prMutRateButStateChanged(evt);
            }
        });

        dynamicMutBut.setText("Dynamically Lower to Secondary Rate");
        dynamicMutBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicMutButActionPerformed(evt);
            }
        });

        fitThreshLabel.setText("Fitness Threshold");

        fitnessThreshold.setMaximumSize(new java.awt.Dimension(999999999, 999999999));

        prmrLabel.setText("Primary Rate");

        seMutRateBut.setMajorTickSpacing(5);
        seMutRateBut.setMinorTickSpacing(1);
        seMutRateBut.setSnapToTicks(true);
        seMutRateBut.setValue(1);
        seMutRateBut.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                seMutRateButStateChanged(evt);
            }
        });

        semrLabel.setText("Secondary Rate");

        prmrLab.setText(prMutRateBut.getValue() + "%");

        semrLab.setText(seMutRateBut.getValue() + "%");

        javax.swing.GroupLayout mutPanelLayout = new javax.swing.GroupLayout(mutPanel);
        mutPanel.setLayout(mutPanelLayout);
        mutPanelLayout.setHorizontalGroup(
            mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mutPanelLayout.createSequentialGroup()
                        .addComponent(fitThreshLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fitnessThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dynamicMutBut)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mutPanelLayout.createSequentialGroup()
                        .addGroup(mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semrLabel)
                            .addComponent(prmrLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prMutRateBut, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                            .addComponent(seMutRateBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prmrLab)
                            .addComponent(semrLab))
                        .addGap(191, 191, 191))))
        );
        mutPanelLayout.setVerticalGroup(
            mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mutPanelLayout.createSequentialGroup()
                .addGroup(mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prmrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prMutRateBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prmrLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(semrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seMutRateBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(semrLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fitThreshLabel)
                    .addComponent(fitnessThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dynamicMutBut)))
        );

        outputWindow.setColumns(20);
        outputWindow.setRows(5);
        outputWindow.setText("\n  This program uses a genetic algorithm to maximise an objective function."
            + "\n  Use the above controls to fine tune how you want the algorithm to perform."
            + "\n"
            + "\n  Set the lower bound and upper bound to define the range in which you want the generated variables to be within."
            + "\n  The higher your upper bound, the more chromosomes you should set to ensure a good variety of values."
            + "\n  As the range increases, the number of iterations should also be increased."
            + "\n  As the upper bound increases, the number of cuts should be reasonably raised."
            + "\n"
            + "\n  Roulette ranking ranks the chromosomes based on weighted probabilites."
            + "\n  Tournament ranking ranks chromosomes based on the 'best' in a tournament setting."
            + "\n  To have no ranking in effect, select tournament ranking with a size of 1. This will"
            + "\n  pick chromosomes at random."
            + "\n"
            + "\n  A high mutation rate means a greater range of values will be 'explored'."
            + "\n  A low mutation rate means a smaller range of values will be 'explored',"
            + "\n  but the range of values that is explored will be more thoroughly 'exploited'"
            + "\n  Engage dynamic mode to lower (or raise) the mutation rate to the secondary"
            + "\n  value when a chromosome exceeds the threshold fitness value."
            + "\n"
            + "\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        outputPanel.setViewportView(outputWindow);

        controlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "  Controls  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

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

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(runButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(runButton)
                .addGap(18, 18, 18)
                .addComponent(clearButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rankPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "  Ranking Options  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        rankButs.add(rouletteRankBut);
        rouletteRankBut.setText("Roulette");
        rouletteRankBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rouletteRankButActionPerformed(evt);
            }
        });

        rankButs.add(tournamentRankBut);
        tournamentRankBut.setText("Tournament");
        tournamentRankBut.setSelected(true);
        tournamentRankBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tournamentRankButActionPerformed(evt);
            }
        });

        tourneySizeLabel.setText("Tournament Size");

        tourneySizeSp.setValue(3);

        javax.swing.GroupLayout rankPanelLayout = new javax.swing.GroupLayout(rankPanel);
        rankPanel.setLayout(rankPanelLayout);
        rankPanelLayout.setHorizontalGroup(
            rankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rankPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rankPanelLayout.createSequentialGroup()
                        .addComponent(tourneySizeSp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tourneySizeLabel))
                    .addComponent(tournamentRankBut)
                    .addComponent(rouletteRankBut))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        rankPanelLayout.setVerticalGroup(
            rankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rankPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rouletteRankBut, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tournamentRankBut)
                .addGap(18, 18, 18)
                .addGroup(rankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tourneySizeSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tourneySizeLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        funcPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "  Function Options  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        funcButs.add(minimiseBut);
        minimiseBut.setText("Minimise");
        minimiseBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimiseButActionPerformed(evt);
            }
        });

        funcButs.add(maximiseBut);
        maximiseBut.setText("Maximise");
        maximiseBut.setSelected(true);
        maximiseBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maximiseButActionPerformed(evt);
            }
        });

        frModeBut.setText("Full Results Output");

        javax.swing.GroupLayout funcPanelLayout = new javax.swing.GroupLayout(funcPanel);
        funcPanel.setLayout(funcPanelLayout);
        funcPanelLayout.setHorizontalGroup(
            funcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(funcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimiseBut)
                    .addComponent(maximiseBut)
                    .addComponent(frModeBut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        funcPanelLayout.setVerticalGroup(
            funcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(minimiseBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(maximiseBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(frModeBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(outputPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(variablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rankPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(funcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(variablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rankPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(funcPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(400, 400, 400))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Method that is performed once the run button is clicked. Bulk of the GA.
    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed

        //Setting class variables as the values entered on the GUI.
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
        
        if(maximiseBut.isSelected()) {
            maxFlag = true;
            minFlag = false;
        } else if(minimiseBut.isSelected()) {
            minFlag = true;
            maxFlag = false;
        }
        
        if(frModeBut.isSelected()) {
            frFlag = true;
        } else {
            frFlag = false;
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
                System.out.println("  A mutation rate of " + mutRate + "% will be applied.");
                if(dynamicMutBut.isSelected()) {
                    System.out.println("  The mutation rate will be lowered to " + seMutRateBut.getValue() + "% if a chromosome reaches the threshold fitness of " + fitnessThreshold.getValue() + ".");
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                System.out.println("\n  Generating chromosomes:");
                ArrayList<FRChromosome> chromArray = new ArrayList<>(chromNum);
                
                //Generating chromosomes and setting chromosomal attributes.
                for(int i = 0; i < chromNum; i++) {
                    System.out.println("\n  Chromosome " + (i + 1) + ": ");
                    FRChromosome c = new FRChromosome(lowerBound, upperBound, varNum);
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
                    for (FRChromosome chrom : chromArray) {
                        System.out.println("  " + Arrays.toString(chrom.chromosome));
                    }    

                    //Evaluating chromosomes and ranking.
                    FREvolve evolve = new FREvolve(chromArray);
                    evolve.getFitnessSum();
                    System.out.println("\n  Sigma fitness is " + evolve.sum);
                    System.out.println("\n  Probabilities are: " + evolve.probArray);
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    if(tournamentFlag) {
                        System.out.println("\n  Ranking parents (tournament method, size " + tourneySize + "):");
                        evolve.tournamentRankMin(random, tourneySize);
                    }
                    System.out.println("\n  Chosen parents: ");
                    for (FRChromosome parentArray : evolve.parentArray) {
                        System.out.println(Arrays.toString(parentArray.chromosome));
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    //Crossover and mutation of chromosomes.
                    System.out.println("\nPerforming crossover:");
                    evolve.crossover(random, numCuts, lowerBound, upperBound, varNum);
                    for(int i = 0; i < chromNum; i++) {       
                        chromArray = evolve.chromArray;
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    if(mutRate == 0) {
                        System.out.println("\n  Mutation rate is 0%, no mutation will be applied.");
                    } else {
                        System.out.println("\n  Applying mutation rate of " + mutRate + "%...");
                        for(int i = 0; i < chromNum; i++) {
                            System.out.println("\n  Chromosome " + (i + 1) + ": ");
                            chromArray.get(i).mutate(mutRate, random);
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
                            if((bestFit <= (Integer)fitnessThreshold.getValue()) && (dynamicMutBut.isSelected()) && (mutChanged == false)) {
                                System.out.println("  A chromosome has exceeded the fitness threshold, lowering mutation rate to " + (Integer)seMutRateBut.getValue() + "%.");
                                mutRate = (Integer)seMutRateBut.getValue();
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

                    if(mutRate == 0) {
                        System.out.println("  Mutation rate is 0%, no mutation will be applied.");
                    } else {
                        System.out.println("  Applying mutation rate of " + mutRate + "%...");
                        for(int i = 0; i < chromNum; i++) {
                            chromArray.get(i).mutate(mutRate, random);
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
                            if((bestFit <= (Integer)fitnessThreshold.getValue()) && (dynamicMutBut.isSelected()) && (mutChanged == false)) {
                                System.out.println("  A chromosome has exceeded the fitness threshold, lowering mutation rate to " + (Integer)seMutRateBut.getValue() + "%.");
                                mutRate = (Integer)seMutRateBut.getValue();
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
                System.out.println("  A mutation rate of " + mutRate + "% will be applied.");
                if(dynamicMutBut.isSelected()) {
                    System.out.println("  The mutation rate will be lowered to " + seMutRateBut.getValue() + "% if a chromosome reaches the threshold fitness of " + fitnessThreshold.getValue() + ".");
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                System.out.println("\n  Generating chromosomes:");
                ArrayList<FRChromosome> chromArray = new ArrayList<>(chromNum);
                
                //Generating chromosomes and setting chromosomal attributes.
                for(int i = 0; i < chromNum; i++) {
                    System.out.println("\n  Chromosome " + (i + 1) + ": ");
                    FRChromosome c = new FRChromosome(lowerBound, upperBound, varNum);
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
                    FREvolve evolve = new FREvolve(chromArray);
                    evolve.getFitnessSum();
                    System.out.println("\n  Sigma fitness is " + evolve.sum);
                    evolve.evaluateProbabilitiesMax();
                    System.out.println("\n  Probabilities are: " + evolve.probArray);
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    if(rouletteFlag) {
                        System.out.println("\n  Ranking parents (roulette method):");
                        evolve.rouletteRank(random);
                    } else if(tournamentFlag) {
                        System.out.println("\n  Ranking parents (tournament method, size " + tourneySize + "):");
                        evolve.tournamentRankMax(random, tourneySize);
                    }
                    System.out.println("\n  Chosen parents: ");
                    for(int i = 0; i < evolve.parentArray.size(); i++) {
                        System.out.println(Arrays.toString(evolve.parentArray.get(i).chromosome));
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    //Crossover and mutation of chromosomes.
                    System.out.println("\nPerforming crossover:");
                    evolve.crossover(random, numCuts, lowerBound, upperBound, varNum);
                    for(int i = 0; i < chromNum; i++) {       
                        chromArray = evolve.chromArray;
                    }
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    if(mutRate == 0) {
                        System.out.println("\n  Mutation rate is 0%, no mutation will be applied.");
                    } else {
                        System.out.println("\n  Applying mutation rate of " + mutRate + "%...");
                        for(int i = 0; i < chromNum; i++) {
                            System.out.println("\n  Chromosome " + (i + 1) + ": ");
                            chromArray.get(i).mutate(mutRate, random);
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
                            if((bestFit >= (Integer)fitnessThreshold.getValue()) && (dynamicMutBut.isSelected()) && (mutChanged == false)) {
                                System.out.println("  A chromosome has exceeded the fitness threshold, lowering mutation rate to " + (Integer)seMutRateBut.getValue() + "%.");
                                mutRate = (Integer)seMutRateBut.getValue();
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

                    if(mutRate == 0) {
                        System.out.println("  Mutation rate is 0%, no mutation will be applied.");
                    } else {
                        System.out.println("  Applying mutation rate of " + mutRate + "%...");
                        for(int i = 0; i < chromNum; i++) {
                            chromArray.get(i).mutate(mutRate, random);
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
                            if((bestFit >= (Integer)fitnessThreshold.getValue()) && (dynamicMutBut.isSelected()) && (mutChanged == false)) {
                                System.out.println("  A chromosome has exceeded the fitness threshold, lowering mutation rate to " + (Integer)seMutRateBut.getValue() + "%.");
                                mutRate = (Integer)seMutRateBut.getValue();
                                mutChanged = true;
                            }
                        }
                    }

                    System.out.println("\n  Best values found on iteration " + (iteration + 1) + ": " + Arrays.toString(chromArray.get(bestIndex).bitStringValues));
                }
            }
        }
    }//GEN-LAST:event_runButtonActionPerformed

    //Method that executes when roulette ranking is selected.
    private void rouletteRankButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rouletteRankButActionPerformed
        //Disables the tournament size selection.
        tourneySizeSp.setEnabled(false);
        tourneySizeLabel.setEnabled(false);
    }//GEN-LAST:event_rouletteRankButActionPerformed

    //Method that executes when the clear button is pressed.
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        //Clears the output window of all text.
        outputWindow.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    //Method that executes when the dynamic mutation rate checkbox is selected.
    private void dynamicMutButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicMutButActionPerformed
        
    }//GEN-LAST:event_dynamicMutButActionPerformed

    //Method that executes when the primary mutation rate slider is moved.
    private void prMutRateButStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_prMutRateButStateChanged
        //Updates the text on the slider label
        prmrLab.setText(prMutRateBut.getValue() + "%");
    }//GEN-LAST:event_prMutRateButStateChanged

    //Method that executes when the primary mutation rate slider is moved.
    private void seMutRateButStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_seMutRateButStateChanged
        //Updates the text on the slider label
        semrLab.setText(seMutRateBut.getValue() + "%");
    }//GEN-LAST:event_seMutRateButStateChanged

    //Method that executes when the minimise radio button is selected.
    private void minimiseButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimiseButActionPerformed
        //Disables the roulette ranking button and selects tournament ranking.
        rouletteRankBut.setEnabled(false);
        rankButs.clearSelection();
        tournamentRankBut.setSelected(true);
        tourneySizeSp.setEnabled(true);
        tourneySizeLabel.setEnabled(true);
    }//GEN-LAST:event_minimiseButActionPerformed

    //Method that executes when the maximise radio button is selected.
    private void maximiseButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maximiseButActionPerformed
        //Enables the roulette ranking button.
        rouletteRankBut.setEnabled(true);
    }//GEN-LAST:event_maximiseButActionPerformed

    //Method that executes when tournament ranking is selected.
    private void tournamentRankButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tournamentRankButActionPerformed
        //Enables the tournament size selection.
        tourneySizeSp.setEnabled(true);
        tourneySizeLabel.setEnabled(true);
    }//GEN-LAST:event_tournamentRankButActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chromLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JLabel cutsLabel;
    private javax.swing.JCheckBox dynamicMutBut;
    private javax.swing.JLabel fitThreshLabel;
    private javax.swing.JSpinner fitnessThreshold;
    private javax.swing.JCheckBox frModeBut;
    private javax.swing.ButtonGroup funcButs;
    private javax.swing.JPanel funcPanel;
    private javax.swing.JLabel itLabel;
    private javax.swing.JLabel lowerBoundLabel;
    private javax.swing.JSpinner lowerBoundSp;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton maximiseBut;
    private javax.swing.JRadioButton minimiseBut;
    private javax.swing.JPanel mutPanel;
    private javax.swing.JSpinner numChromsSp;
    private javax.swing.JSpinner numCutsSp;
    private javax.swing.JSpinner numItsSp;
    private javax.swing.JSpinner numVarsSp;
    private javax.swing.JScrollPane outputPanel;
    private javax.swing.JTextArea outputWindow;
    private javax.swing.JSlider prMutRateBut;
    private javax.swing.JLabel prmrLab;
    private javax.swing.JLabel prmrLabel;
    private javax.swing.ButtonGroup rankButs;
    private javax.swing.JPanel rankPanel;
    private javax.swing.JRadioButton rouletteRankBut;
    private javax.swing.JButton runButton;
    private javax.swing.JSlider seMutRateBut;
    private javax.swing.JLabel semrLab;
    private javax.swing.JLabel semrLabel;
    private javax.swing.JRadioButton tournamentRankBut;
    private javax.swing.JLabel tourneySizeLabel;
    private javax.swing.JSpinner tourneySizeSp;
    private javax.swing.JLabel upperBoundLabel;
    private javax.swing.JSpinner upperBoundSp;
    private javax.swing.JLabel varLabel;
    private javax.swing.JPanel variablePanel;
    // End of variables declaration//GEN-END:variables
}

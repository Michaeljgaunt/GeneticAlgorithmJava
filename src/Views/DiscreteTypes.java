/*
 * The DiscreteTypes class contains the bulk of the code that drives the GA and all of the
 * code that defines the interface.
 */

package Views;

import Controllers.Driver;
import Enums.Enums.*;
import java.io.PrintStream;
import javax.swing.ImageIcon;

public class DiscreteTypes extends javax.swing.JFrame {
    
    //Constructor method. Initializes the interface, redefines the System output
    //to the interface and sets the program's icon.
    public DiscreteTypes() {
        initComponents();
        PrintStream printStream = new PrintStream(new GUIOutput(outputWindow));
        System.setOut(printStream);
        System.setErr(printStream);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/dna_helix.png")).getImage());  
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
        setTitle("Genetic Algorithm - Discrete Types");
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    //Method to get the number of iterations entered on the DiscreteTypes.
    public static int getNumIts() {
        return (Integer)numItsSp.getValue();
    }
    
    //Method to get the number of chromosomes entered on the DiscreteTypes.
    public static int getChromNum() {
        return (Integer)numChromsSp.getValue();
    }
    
    //Method to get the number of variables entered on the DiscreteTypes.
    public static int getVarNum() {
        return (Integer)numVarsSp.getValue();
    }
    
    //Method to get the lower bound entered on the DiscreteTypes.
    public static int getLowerBound() {
        return (Integer)lowerBoundSp.getValue();
    }
    
    //Method to get the upper bound entered on the DiscreteTypes.
    public static int getUpperBound() {
        return (Integer)upperBoundSp.getValue();
    }
    
    //Method to get the number of cuts entered on the DiscreteTypes.
    public static int getNumCuts() {
        return (Integer)numCutsSp.getValue();
    }
    
    //Method to get the mutation rate entered on the DiscreteTypes.
    public static int getPrMutRate() {
        return (Integer)prMutRateBut.getValue();
    }
    
    public static int getSeMutRate() {
        return (Integer)seMutRateBut.getValue();
    }
    
    public static int getFitThreshold() {
        return (Integer)fitnessThreshold.getValue();
    }
    
    //Method to get the tournament size entered on the DiscreteTypes.
    public static int getTourneySize() {
        return (Integer)tourneySizeSp.getValue();
    }
    
    //Method to get the ranking method entered on the DiscreteTypes.
    public static RankingMethod getRankButState() {
        RankingMethod rank = null;
        if(rouletteRankBut.isSelected()) {
            rank = RankingMethod.ROULETTE;
        } else if(tournamentRankBut.isSelected()) {
            rank = RankingMethod.TOURNAMENT;
        }
        return rank;
    }
    
    //Method to get the optimisation method entered on the DiscreteTypes.
    public static Optimisation getOptimization() {
        Optimisation optimisation = null;
        if(maximiseBut.isSelected()) {
            optimisation = Optimisation.MAXIMISE;
        } else if(minimiseBut.isSelected()) {
            optimisation = Optimisation.MINIMISE;
        }
        return optimisation;
    }
    
    //Method to get the full results button's state.
    public static boolean isFullResultsSelected() {
        return frModeBut.isSelected();
    }
  
    //Method to get the dynamic mutation button's state.
    public static boolean isDynamicMutationSelected() {
        return dynamicMutBut.isSelected();
    }
    
    //Method that is performed once the run button is clicked. Bulk of the GA.
    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        Driver.runBitStrings();
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
    private static javax.swing.JCheckBox dynamicMutBut;
    private javax.swing.JLabel fitThreshLabel;
    private static javax.swing.JSpinner fitnessThreshold;
    private static javax.swing.JCheckBox frModeBut;
    private javax.swing.ButtonGroup funcButs;
    private javax.swing.JPanel funcPanel;
    private javax.swing.JLabel itLabel;
    private javax.swing.JLabel lowerBoundLabel;
    private static javax.swing.JSpinner lowerBoundSp;
    private javax.swing.JPanel mainPanel;
    private static javax.swing.JRadioButton maximiseBut;
    private static javax.swing.JRadioButton minimiseBut;
    private javax.swing.JPanel mutPanel;
    private static javax.swing.JSpinner numChromsSp;
    private static javax.swing.JSpinner numCutsSp;
    private static javax.swing.JSpinner numItsSp;
    private static javax.swing.JSpinner numVarsSp;
    private javax.swing.JScrollPane outputPanel;
    private javax.swing.JTextArea outputWindow;
    private static javax.swing.JSlider prMutRateBut;
    private javax.swing.JLabel prmrLab;
    private javax.swing.JLabel prmrLabel;
    private javax.swing.ButtonGroup rankButs;
    private javax.swing.JPanel rankPanel;
    private static javax.swing.JRadioButton rouletteRankBut;
    private javax.swing.JButton runButton;
    private static javax.swing.JSlider seMutRateBut;
    private javax.swing.JLabel semrLab;
    private javax.swing.JLabel semrLabel;
    private static javax.swing.JRadioButton tournamentRankBut;
    private javax.swing.JLabel tourneySizeLabel;
    private static javax.swing.JSpinner tourneySizeSp;
    private javax.swing.JLabel upperBoundLabel;
    private static javax.swing.JSpinner upperBoundSp;
    private javax.swing.JLabel varLabel;
    private javax.swing.JPanel variablePanel;
    // End of variables declaration//GEN-END:variables
}

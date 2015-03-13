/*
 * The DiscreteTypes class contains the bulk of the code that drives the GA and all of the
 * code that defines the interface.
 */

package Views;

import Controllers.Driver;
import static Controllers.Driver.menu;
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
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/dna.png")).getImage());  
    }

    //Method to build the interface.
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mutButs = new javax.swing.ButtonGroup();
        rankButs = new javax.swing.ButtonGroup();
        funcButs = new javax.swing.ButtonGroup();
        tourneySizeDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        tourneyLabel = new javax.swing.JLabel();
        tourneySizeSp = new javax.swing.JSpinner();
        tourneySizeOkBut = new javax.swing.JButton();
        mutationDialog = new javax.swing.JDialog();
        seMutRateBut = new javax.swing.JSlider();
        semrLabel1 = new javax.swing.JLabel();
        semrLab = new javax.swing.JLabel();
        mutationOkBut = new javax.swing.JButton();
        fitnessThreshold = new javax.swing.JSpinner();
        fitThreshLabel = new javax.swing.JLabel();
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
        prmrLab = new javax.swing.JLabel();
        outputPanel = new javax.swing.JScrollPane();
        outputWindow = new javax.swing.JTextArea();
        controlPanel = new javax.swing.JPanel();
        runButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        mainMenuBut = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitBut = new javax.swing.JMenuItem();
        funcMenu = new javax.swing.JMenu();
        minimiseBut = new javax.swing.JRadioButtonMenuItem();
        maximiseBut = new javax.swing.JRadioButtonMenuItem();
        rankingMenu = new javax.swing.JMenu();
        rouletteRankingBut = new javax.swing.JRadioButtonMenuItem();
        tournamentRankingBut = new javax.swing.JRadioButtonMenuItem();
        mutationMenu = new javax.swing.JMenu();
        staticMutBut = new javax.swing.JRadioButtonMenuItem();
        dynamicMutBut = new javax.swing.JRadioButtonMenuItem();
        resultsMenu = new javax.swing.JMenu();
        chromPrinBut = new javax.swing.JCheckBoxMenuItem();
        popPrinBut = new javax.swing.JCheckBoxMenuItem();
        crossPrinBut = new javax.swing.JCheckBoxMenuItem();
        rankPrinBut = new javax.swing.JCheckBoxMenuItem();
        mutPrinBut = new javax.swing.JCheckBoxMenuItem();

        tourneySizeDialog.setIconImage(null);
        tourneySizeDialog.setMinimumSize(new java.awt.Dimension(350, 90));
        setLocationRelativeTo(this);

        tourneyLabel.setText("Select size of tournament:");

        tourneySizeSp.setValue(3);

        tourneySizeOkBut.setText("OK");
        tourneySizeOkBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tourneySizeOkButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tourneyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tourneySizeSp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tourneySizeOkBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tourneyLabel)
                    .addComponent(tourneySizeSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tourneySizeOkBut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tourneySizeDialogLayout = new javax.swing.GroupLayout(tourneySizeDialog.getContentPane());
        tourneySizeDialog.getContentPane().setLayout(tourneySizeDialogLayout);
        tourneySizeDialogLayout.setHorizontalGroup(
            tourneySizeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        tourneySizeDialogLayout.setVerticalGroup(
            tourneySizeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        mutationDialog.setMinimumSize(new java.awt.Dimension(600, 125));

        seMutRateBut.setMajorTickSpacing(5);
        seMutRateBut.setMinorTickSpacing(1);
        seMutRateBut.setSnapToTicks(true);
        seMutRateBut.setValue(1);
        seMutRateBut.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                seMutRateButStateChanged(evt);
            }
        });

        semrLabel1.setText("Secondary Mutation Rate");

        semrLab.setText(seMutRateBut.getValue() + "%");

        mutationOkBut.setText("OK");
        mutationOkBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutationOkButActionPerformed(evt);
            }
        });

        fitnessThreshold.setMaximumSize(new java.awt.Dimension(999999999, 999999999));

        fitThreshLabel.setText("Fitness Threshold");

        javax.swing.GroupLayout mutationDialogLayout = new javax.swing.GroupLayout(mutationDialog.getContentPane());
        mutationDialog.getContentPane().setLayout(mutationDialogLayout);
        mutationDialogLayout.setHorizontalGroup(
            mutationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mutationDialogLayout.createSequentialGroup()
                .addGroup(mutationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mutationDialogLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(semrLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seMutRateBut, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(semrLab))
                    .addGroup(mutationDialogLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(fitThreshLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fitnessThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mutationOkBut)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        mutationDialogLayout.setVerticalGroup(
            mutationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mutationDialogLayout.createSequentialGroup()
                .addGroup(mutationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mutationDialogLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(semrLab, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mutationDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mutationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(seMutRateBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(semrLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mutationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fitThreshLabel)
                    .addComponent(fitnessThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mutationOkBut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        lowerBoundSp.setValue(-66);

        numCutsSp.setValue(1);

        numVarsSp.setValue(2);

        numItsSp.setValue(50);

        upperBoundSp.setValue(66);

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

        prmrLab.setText(prMutRateBut.getValue() + "%");

        javax.swing.GroupLayout mutPanelLayout = new javax.swing.GroupLayout(mutPanel);
        mutPanel.setLayout(mutPanelLayout);
        mutPanelLayout.setHorizontalGroup(
            mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prMutRateBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prmrLab, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mutPanelLayout.setVerticalGroup(
            mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mutPanelLayout.createSequentialGroup()
                .addGroup(mutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prMutRateBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prmrLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        outputWindow.setColumns(20);
        outputWindow.setRows(5);
        outputWindow.setText("\n  This program uses a genetic algorithm to maximise an objective function."
            + "\n  Use the above controls to fine tune how you want the algorithm to perform."
            + "\n"
            + "\n  Set the lower bound and upper bound to define the range in which you want the generated variables "
            + "\n  to be within. The higher your upper bound, the more chromosomes you should set to ensure a good "
            + "\n  variety of values. As the range increases, the number of iterations should also be increased."
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
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(runButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(runButton)
                .addGap(18, 18, 18)
                .addComponent(clearButton)
                .addGap(23, 23, 23))
        );

        fileMenu.setText("Menu");

        mainMenuBut.setText("Main Menu");
        mainMenuBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButActionPerformed(evt);
            }
        });
        fileMenu.add(mainMenuBut);
        fileMenu.add(jSeparator1);

        exitBut.setText("Quit");
        exitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButActionPerformed(evt);
            }
        });
        fileMenu.add(exitBut);

        jMenuBar1.add(fileMenu);

        funcMenu.setText("Function");

        funcButs.add(minimiseBut);
        minimiseBut.setSelected(false);
        minimiseBut.setText("Minimise");
        minimiseBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimiseButActionPerformed(evt);
            }
        });
        funcMenu.add(minimiseBut);

        funcButs.add(maximiseBut);
        maximiseBut.setText("Maximise");
        maximiseBut.setSelected(true);
        maximiseBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maximiseButActionPerformed(evt);
            }
        });
        funcMenu.add(maximiseBut);

        jMenuBar1.add(funcMenu);

        rankingMenu.setText("Ranking");

        rankButs.add(rouletteRankingBut);
        rouletteRankingBut.setSelected(true);
        rouletteRankingBut.setText("Roulette");
        rankingMenu.add(rouletteRankingBut);

        rankButs.add(tournamentRankingBut);
        tournamentRankingBut.setSelected(false);
        tournamentRankingBut.setText("Tournament");
        tournamentRankingBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tournamentRankingButActionPerformed(evt);
            }
        });
        rankingMenu.add(tournamentRankingBut);

        jMenuBar1.add(rankingMenu);

        mutationMenu.setText("Mutation");

        mutButs.add(staticMutBut);
        staticMutBut.setSelected(true);
        staticMutBut.setText("Static");
        staticMutBut.setSelected(true);
        mutationMenu.add(staticMutBut);

        mutButs.add(dynamicMutBut);
        dynamicMutBut.setText("Dynamic");
        dynamicMutBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicMutButActionPerformed(evt);
            }
        });
        mutationMenu.add(dynamicMutBut);

        jMenuBar1.add(mutationMenu);

        resultsMenu.setText("Results");

        chromPrinBut.setText("Show Chromosome Statistics");
        resultsMenu.add(chromPrinBut);

        popPrinBut.setText("Print Population Statistics");
        resultsMenu.add(popPrinBut);

        crossPrinBut.setText("Show Crossover Process");
        resultsMenu.add(crossPrinBut);

        rankPrinBut.setText("Show Ranking Process");
        resultsMenu.add(rankPrinBut);

        mutPrinBut.setText("Show Mutation Statistics");
        resultsMenu.add(mutPrinBut);

        jMenuBar1.add(resultsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(variablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(outputPanel)
                    .addComponent(mutPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(variablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(400, 400, 400))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(mutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if(rouletteRankingBut.isSelected()) {
            rank = RankingMethod.ROULETTE;
        } else if(tournamentRankingBut.isSelected()) {
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
      
    //Method to get the dynamic mutation button's state.
    public static boolean isDynamicMutationSelected() {
        return dynamicMutBut.isSelected();
    }
    
    //Method to get the chromosome information print button's state.
    public static boolean isChromPrinButSelected() {
        return chromPrinBut.isSelected();
    }
    
    //Method to get the evaluation information print button's state.
    public static boolean isEvalPrinButSelected() {
        return popPrinBut.isSelected();
    }
    
    //Method to get the evolution information print button's state.
    public static boolean isEvolPrinButSelected() {
        return crossPrinBut.isSelected();
    }
    
    //Method to get the ranking information print button's state.
    public static boolean isRankPrinButSelected() {
        return rankPrinBut.isSelected();
    }
    
    //Method to get the mutation information print button's state.
    public static boolean isMutPrinButSelected() {
        return mutPrinBut.isSelected();
    }
    
    
    //Method that is performed once the run button is clicked. Bulk of the GA.
    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        Driver.runBitStrings();
    }//GEN-LAST:event_runButtonActionPerformed
        
    //Method that executes when the clear button is pressed.
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        //Clears the output window of all text.
        outputWindow.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    //Method that executes when the primary mutation rate slider is moved.
    private void prMutRateButStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_prMutRateButStateChanged
        //Updates the text on the slider label
        prmrLab.setText(prMutRateBut.getValue() + "%");
    }//GEN-LAST:event_prMutRateButStateChanged

    //Method that executes when the quit button on the menu is clicked.
    private void exitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButActionPerformed

    private void mainMenuButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButActionPerformed
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_mainMenuButActionPerformed

    private void tournamentRankingButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tournamentRankingButActionPerformed
        tourneySizeDialog.setLocationRelativeTo(null);
        tourneySizeDialog.setIconImage(new ImageIcon(getClass().getResource("/Resources/dna_helix.png")).getImage()); 
        tourneySizeDialog.setVisible(true); 
    }//GEN-LAST:event_tournamentRankingButActionPerformed

    //Method that executes when the minimise radio button is selected.
    private void minimiseButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimiseButActionPerformed
        //Disables the roulette ranking button and selects tournament ranking.
        rouletteRankingBut.setEnabled(false);
        if(!tournamentRankingBut.isSelected()) {
            tourneySizeDialog.setLocationRelativeTo(null);
            tourneySizeDialog.setIconImage(new ImageIcon(getClass().getResource("/Resources/dna_helix.png")).getImage()); 
            tourneySizeDialog.setVisible(true); 
        }
        rankButs.clearSelection();
        tournamentRankingBut.setSelected(true);
        tourneySizeSp.setEnabled(true);
    }//GEN-LAST:event_minimiseButActionPerformed

     //Method that executes when the maximise radio button is selected.
    private void maximiseButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maximiseButActionPerformed
        //Enables the roulette ranking button.
        rouletteRankingBut.setEnabled(true);
    }//GEN-LAST:event_maximiseButActionPerformed

    //Method that executes when the OK button is clicked on the tournament dialog.
    private void tourneySizeOkButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tourneySizeOkButActionPerformed
        tourneySizeDialog.setVisible(false);
    }//GEN-LAST:event_tourneySizeOkButActionPerformed
    
    //Method that executes when the primary mutation rate slider is moved.
    private void seMutRateButStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_seMutRateButStateChanged
        //Updates the text on the slider label
        semrLab.setText(seMutRateBut.getValue() + "%");
    }//GEN-LAST:event_seMutRateButStateChanged

    //Method that executes when the OK button is clicked on the mutation dialog.
    private void mutationOkButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutationOkButActionPerformed
        mutationDialog.setVisible(false);
    }//GEN-LAST:event_mutationOkButActionPerformed

    private void dynamicMutButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicMutButActionPerformed
        mutationDialog.setLocationRelativeTo(null);
        mutationDialog.setIconImage(new ImageIcon(getClass().getResource("/Resources/dna_helix.png")).getImage()); 
        mutationDialog.setVisible(true);
    }//GEN-LAST:event_dynamicMutButActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chromLabel;
    private static javax.swing.JCheckBoxMenuItem chromPrinBut;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel controlPanel;
    private static javax.swing.JCheckBoxMenuItem crossPrinBut;
    private javax.swing.JLabel cutsLabel;
    private static javax.swing.JRadioButtonMenuItem dynamicMutBut;
    private javax.swing.JMenuItem exitBut;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel fitThreshLabel;
    private static javax.swing.JSpinner fitnessThreshold;
    private javax.swing.ButtonGroup funcButs;
    private javax.swing.JMenu funcMenu;
    private javax.swing.JLabel itLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lowerBoundLabel;
    private static javax.swing.JSpinner lowerBoundSp;
    private javax.swing.JMenuItem mainMenuBut;
    private javax.swing.JPanel mainPanel;
    private static javax.swing.JRadioButtonMenuItem maximiseBut;
    private static javax.swing.JRadioButtonMenuItem minimiseBut;
    private javax.swing.ButtonGroup mutButs;
    private javax.swing.JPanel mutPanel;
    private static javax.swing.JCheckBoxMenuItem mutPrinBut;
    private javax.swing.JDialog mutationDialog;
    private javax.swing.JMenu mutationMenu;
    private javax.swing.JButton mutationOkBut;
    private static javax.swing.JSpinner numChromsSp;
    private static javax.swing.JSpinner numCutsSp;
    private static javax.swing.JSpinner numItsSp;
    private static javax.swing.JSpinner numVarsSp;
    private javax.swing.JScrollPane outputPanel;
    private javax.swing.JTextArea outputWindow;
    private static javax.swing.JCheckBoxMenuItem popPrinBut;
    private static javax.swing.JSlider prMutRateBut;
    private javax.swing.JLabel prmrLab;
    private javax.swing.ButtonGroup rankButs;
    private static javax.swing.JCheckBoxMenuItem rankPrinBut;
    private javax.swing.JMenu rankingMenu;
    private javax.swing.JMenu resultsMenu;
    private static javax.swing.JRadioButtonMenuItem rouletteRankingBut;
    private javax.swing.JButton runButton;
    private static javax.swing.JSlider seMutRateBut;
    private javax.swing.JLabel semrLab;
    private javax.swing.JLabel semrLabel1;
    private static javax.swing.JRadioButtonMenuItem staticMutBut;
    private static javax.swing.JRadioButtonMenuItem tournamentRankingBut;
    private javax.swing.JLabel tourneyLabel;
    private javax.swing.JDialog tourneySizeDialog;
    private javax.swing.JButton tourneySizeOkBut;
    private static javax.swing.JSpinner tourneySizeSp;
    private javax.swing.JLabel upperBoundLabel;
    private static javax.swing.JSpinner upperBoundSp;
    private javax.swing.JLabel varLabel;
    private javax.swing.JPanel variablePanel;
    // End of variables declaration//GEN-END:variables
}

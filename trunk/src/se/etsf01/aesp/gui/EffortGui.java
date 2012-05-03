package se.etsf01.aesp.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import se.etsf01.aesp.ExportProject;
import se.etsf01.aesp.algo.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henrik
 */
public class EffortGui extends javax.swing.JFrame {

    private ProjectList projectlist;
    String path;

    /**
     * Creates new form EffortGui
     */
    public EffortGui() {
        initComponents();
        setPosition();
        readFromConfig();
        setVisible(true);

    }
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        RELY = new javax.swing.JComboBox();
        DATA = new javax.swing.JComboBox();
        CPLX = new javax.swing.JComboBox();
        TIME = new javax.swing.JComboBox();
        STOR = new javax.swing.JComboBox();
        ACAP = new javax.swing.JComboBox();
        VEXP = new javax.swing.JComboBox();
        LEXP = new javax.swing.JComboBox();
        MODP = new javax.swing.JComboBox();
        TOOL = new javax.swing.JComboBox();
        SCED = new javax.swing.JComboBox();
        AEXP = new javax.swing.JComboBox();
        PCAP = new javax.swing.JComboBox();
        VIRT = new javax.swing.JComboBox();
        TURN = new javax.swing.JComboBox();
        SimThreshold = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        LOC = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        mnuBar = new javax.swing.JMenuBar();
        mnuDatabase = new javax.swing.JMenu();
        mnuOpenDatabase = new javax.swing.JMenuItem();
        mnuProject = new javax.swing.JMenu();
        mnuExportProject = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AESP Tool v1");
        setResizable(false);

        RELY.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Nominal", "High", "Very_High" }));
        RELY.setSelectedIndex(1);

        DATA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Nominal", "High", "Very_High" }));
        DATA.setSelectedIndex(1);

        CPLX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Nominal", "High", "Very_High", "Extra_High" }));
        CPLX.setSelectedIndex(1);

        TIME.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nominal", "High", "Very_High", "Extra_High" }));
        TIME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEActionPerformed(evt);
            }
        });

        STOR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nominal", "High", "Very_High", "Extra_High" }));

        ACAP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nominal", "High", "Very_High" }));

        VEXP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Nominal", "High" }));
        VEXP.setSelectedIndex(1);
        VEXP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VEXPActionPerformed(evt);
            }
        });

        LEXP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very_Low", "Low", "Nominal", "High" }));
        LEXP.setSelectedIndex(2);

        MODP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Nominal", "High", "Very_High" }));
        MODP.setSelectedIndex(1);

        TOOL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very_Low", "Low", "Nominal", "High", "Very_High" }));
        TOOL.setSelectedIndex(2);
        TOOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOOLActionPerformed(evt);
            }
        });

        SCED.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Nominal", "High" }));
        SCED.setSelectedIndex(1);

        AEXP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nominal", "High", "Very_High" }));

        PCAP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nominal", "High", "Very_High" }));
        PCAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCAPActionPerformed(evt);
            }
        });

        VIRT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Nominal", "High", " " }));
        VIRT.setSelectedIndex(1);
        VIRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIRTActionPerformed(evt);
            }
        });

        TURN.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Nominal", "High" }));
        TURN.setSelectedIndex(1);

        jLabel1.setText("RELY");

        jLabel2.setText("DATA");

        jLabel3.setText("CPLX");

        jLabel4.setText("TIME");

        jLabel5.setText("SCED");

        jLabel6.setText("STOR");

        jLabel7.setText("VIRT");

        jLabel8.setText("TURN");

        jLabel9.setText("ACAP");

        jLabel10.setText("AEXP");

        jLabel11.setText("PCAP");

        jLabel12.setText("VEXP");

        jLabel13.setText("LEXP");

        jLabel14.setText("MODP");

        jLabel15.setText("TOOL");

        jLabel16.setText("SimililariyThreshold");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, SimThreshold, org.jdesktop.beansbinding.ELProperty.create("${value}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        LOC.setText("100.0");
        LOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOCActionPerformed(evt);
            }
        });

        jLabel17.setText("SIZE (kLOC)");

        mnuDatabase.setText("Database");

        mnuOpenDatabase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnuOpenDatabase.setLabel("Open Database...");
        mnuOpenDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpenDatabaseActionPerformed(evt);
            }
        });
        mnuDatabase.add(mnuOpenDatabase);

        mnuBar.add(mnuDatabase);

        mnuProject.setText("Project");

        mnuExportProject.setText("Export Project...");
        mnuExportProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExportProjectPerformed(evt);
            }
        });
        mnuProject.add(mnuExportProject);

        mnuBar.add(mnuProject);

        setJMenuBar(mnuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(694, Short.MAX_VALUE)
                .add(jButton1)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(61, 61, 61)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel12)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(jLabel16)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(SimThreshold, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(VEXP, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, VIRT, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, RELY, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(26, 26, 26)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(TURN, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                .add(jLabel13)
                                                .add(jLabel2)
                                                .add(DATA, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(LEXP, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .add(jLabel8)))
                                    .add(jLabel1)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel7)
                                        .add(235, 235, 235)))
                                .add(22, 22, 22)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel9)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(ACAP, 0, 108, Short.MAX_VALUE)
                                        .add(jLabel3)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, CPLX, 0, 0, Short.MAX_VALUE)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, MODP, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(jLabel14)))))
                        .add(31, 31, 31)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel10)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(AEXP, 0, 0, Short.MAX_VALUE)
                                .add(TOOL, 0, 108, Short.MAX_VALUE)
                                .add(TIME, 0, 108, Short.MAX_VALUE)
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel15)
                                        .add(jLabel4))
                                    .add(0, 57, Short.MAX_VALUE))))))
                .add(36, 36, 36)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel11)
                        .addContainerGap())
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(6, 6, 6)
                                    .add(jLabel17))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jLabel6)
                                    .add(jLabel5)
                                    .add(STOR, 0, 0, Short.MAX_VALUE)
                                    .add(SCED, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(LOC)))
                            .add(35, 35, 35))
                        .add(layout.createSequentialGroup()
                            .add(PCAP, 0, 118, Short.MAX_VALUE)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(101, 101, 101)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel2)
                        .add(jLabel3)
                        .add(jLabel4)
                        .add(jLabel6)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(RELY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(DATA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(CPLX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(TIME, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(STOR, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(54, 54, 54)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(jLabel8)
                    .add(jLabel9)
                    .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel11))
                .add(5, 5, 5)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(VIRT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(TURN, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ACAP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(AEXP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(PCAP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(66, 66, 66)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(jLabel13)
                    .add(jLabel14)
                    .add(jLabel15)
                    .add(jLabel5))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(VEXP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(LEXP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(MODP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(TOOL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(SCED, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jLabel17)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(LOC, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton1)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(SimThreshold, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel16))
                        .add(38, 38, Short.MAX_VALUE))))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VEXPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VEXPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VEXPActionPerformed

    private void TOOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TOOLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TOOLActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private Project createProject() {
        //To get attributes use the follwing line as a template.
        Project proj = new Project();
        Field[] fields = this.getClass().getDeclaredFields();

        HashMap<String, Attribute> attributes = new HashMap<String, Attribute>();
        for (Attribute attr : Attribute.values()) {
            attributes.put(attr.name(), attr);
        }

        for (Field field : fields) {
            if (attributes.containsKey(field.getName())) {
                try {
                    JComboBox current = (JComboBox) field.get(this);
                    proj.attributes().put(attributes.get(field.getName()), Rating.fromString((String) current.getSelectedItem()));
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }

        try {
            float linesOfCode = Float.parseFloat(LOC.getText());
            proj.setLinesOfCode(Math.round(linesOfCode * 1000.0f));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Lines of Code value, check that field!", "AESP Tool", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return proj;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Project proj = createProject();
        
        System.out.println(proj);

        //If you want to run with the database from the config file
        if (projectlist == null) {
            Parser parser = new Parser(path);
            projectlist = parser.parseFile();
        }

        EstimationFactory factory = new EstimationFactory(projectlist);
        Estimator estim = factory.createEstimator();

        ArrayList<EstimationResult> results = new ArrayList<EstimationResult>();


        try {
            writeToConfig();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "IOException trying to write to configfile", "AESP Tool", JOptionPane.ERROR_MESSAGE);
        }
        //TODO: Might not be the fastest way to do it, but it is simple.
        EstimationResult result = estim.estimate(SimThreshold.getValue() / 100.0, proj);
        ReportWindow rp = new ReportWindow(proj, result);
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TIMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEActionPerformed

    private void PCAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PCAPActionPerformed

    private void VIRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIRTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VIRTActionPerformed

    private void mnuOpenDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpenDatabaseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Project Database Format files (*.txt)", "txt");
        chooser.setFileFilter(filter);

        chooser.setApproveButtonText("Open");
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            Parser parser = new Parser(path);
            projectlist = parser.parseFile();
            JOptionPane.showMessageDialog(this, "Found " + String.valueOf(projectlist.size()) + " projects.", "Loading complete.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_mnuOpenDatabaseActionPerformed

    private void readFromConfig() {
        File config = new File("/h/d8/t/dt08ml7/NetBeansProjects/trunk/dist/config.ini");
        if (!config.exists()) {
            System.out.println("cant find config file");

        } else {
            try {
                Scanner scanner = new Scanner(new FileReader(config));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("path: ")) {
                        path = line.substring(6);

                    } else {
                        System.out.println("no path found on this line");
                    }
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Did not find config file", "AESP Tool", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    private void writeToConfig() throws IOException {
        File config = new File("config.ini");
        if (!config.exists()) {
            System.out.println("config doesnt exist, creating new one");
        } else {
            config.delete();
        }
        //Creates new config file everytime to make sure the information is correct and up to date.
        if (config.createNewFile()) {
            System.out.println("Created new config file");
        }

        FileWriter fstream = new FileWriter(config);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write("path: " + path);
        out.close();
    }
    private void LOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LOCActionPerformed

    private void mnuExportProjectPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExportProjectPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Project files (*.prj)", "prj");
        chooser.setFileFilter(filter);

        chooser.setApproveButtonText("Export");
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            ExportProject ep = new ExportProject(path, createProject());
            ep.export();
            JOptionPane.showMessageDialog(this, "Exported project to " + path + ".", "Export complete.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_mnuExportProjectPerformed

      private void setPosition() {
        // Get the size of the screen
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
 
    // Determine the new location of the window
    int w = getSize().width;
    int h = getSize().height;
   // int x = (dim.width-w)/2;
   // int y = (dim.height-h)/2;

    // Move the window
    setLocation((dim.width-w)/2, (dim.height-h)/2);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EffortGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EffortGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EffortGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EffortGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EffortGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ACAP;
    private javax.swing.JComboBox AEXP;
    private javax.swing.JComboBox CPLX;
    private javax.swing.JComboBox DATA;
    private javax.swing.JComboBox LEXP;
    private javax.swing.JTextField LOC;
    private javax.swing.JComboBox MODP;
    private javax.swing.JComboBox PCAP;
    private javax.swing.JComboBox RELY;
    private javax.swing.JComboBox SCED;
    private javax.swing.JComboBox STOR;
    private javax.swing.JSlider SimThreshold;
    private javax.swing.JComboBox TIME;
    private javax.swing.JComboBox TOOL;
    private javax.swing.JComboBox TURN;
    private javax.swing.JComboBox VEXP;
    private javax.swing.JComboBox VIRT;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenu mnuDatabase;
    private javax.swing.JMenuItem mnuExportProject;
    private javax.swing.JMenuItem mnuOpenDatabase;
    private javax.swing.JMenu mnuProject;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}

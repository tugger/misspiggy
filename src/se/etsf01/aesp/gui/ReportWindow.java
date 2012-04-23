/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import se.etsf01.aesp.algo.Effort;
import se.etsf01.aesp.algo.EstimationResult;

/**
 *
 * @author tugger
 */
public class ReportWindow extends javax.swing.JFrame {
    private EstimationResult result;
    /**
     * Creates new form ReportWindow
     */
    public ReportWindow(EstimationResult result) {
        this.result = result;
        initComponents();
        postInit();
    }
    
    private void postInit() {
        setLocation(300,300);
        sources.setText("Estimated from " + Integer.toString(result.getAdaptiationSource().size()) + " sources");
         float effort;
                if (result.getEstimatedEffort().toPersonYear() < 1) {
                    if (result.getEstimatedEffort().toPersonMonths() < 1) {
                        effort = result.getEstimatedEffort().toPersonHours();
                    } else {
                        effort = result.getEstimatedEffort().toPersonMonths();
                    }
                } else { 
                    effort = result.getEstimatedEffort().toPersonYear();
                }
                DecimalFormat df = new DecimalFormat("#.##");
        effortLabel.setText(df.format(effort));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sources = new javax.swing.JLabel();
        effortLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        effortLabel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sources, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(effortLabel)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(effortLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(sources)
                .addGap(34, 34, 34))
        );

        effortLabel.getAccessibleContext().setAccessibleName("effort");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel effortLabel;
    private javax.swing.JLabel sources;
    // End of variables declaration//GEN-END:variables
}

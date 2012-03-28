package se.etsf01.aesp.gui;

import java.awt.Dimension;
import javax.swing.JFrame;

import se.etsf01.aesp.algo.EstimationResult;


/**
 * The Report Window
 */
public class ReportWindow extends JFrame {
	
	public ReportWindow() {
		super("Report Window");
		setPreferredSize(new Dimension(300, 300));
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(400, 400, 300, 300);
		setVisible(true);
	}
	
	/**
	 * Shows the result in a nice manner.
	 * @param The EstimationResult produced by the AESP algorithm
	 */
	public void showResult(EstimationResult result) {
		
	}
}

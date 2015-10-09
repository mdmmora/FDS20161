package cadPessoas;

import java.awt.event.*;
import javax.swing.*;

public class mainWindows extends javax.swing.JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenuItem mExibir;
	private JMenuItem mInserir;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mainWindows inst = new mainWindows();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public mainWindows() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				menuBar = new JMenuBar();
				setJMenuBar(menuBar);
				{
					mInserir = new JMenuItem();
					menuBar.add(mInserir);
					mInserir.setText("Inserir");
					mInserir.addActionListener(this);
				}
				{
					mExibir = new JMenu();
					menuBar.add(mExibir);
					mExibir.setText("Exibir");
					mExibir.addActionListener(this);
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}

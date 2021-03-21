import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.JTextArea;

public class MainWindow {

	private JFrame frmHome;
	private JTextField txtAlgorithmForFinding;
	private JTextField txtGtcsbMinimumCost;
	private JTable table;
	private JTextField txtCloudServiceProvider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.getContentPane().setBackground(Color.DARK_GRAY);
		frmHome.getContentPane().setLayout(null);
		
		txtAlgorithmForFinding = new JTextField();
		txtAlgorithmForFinding.setEditable(false);
		txtAlgorithmForFinding.setBorder(null);
		txtAlgorithmForFinding.setFont(new Font("Cambria", Font.BOLD, 25));
		txtAlgorithmForFinding.setForeground(Color.WHITE);
		txtAlgorithmForFinding.setBackground(Color.DARK_GRAY);
		txtAlgorithmForFinding.setText("Algorithm for Finding the Minimum Cost of Storing and Regenerating Datasets in Multiple Clouds");
		txtAlgorithmForFinding.setBounds(93, 40, 1114, 35);
		frmHome.getContentPane().add(txtAlgorithmForFinding);
		txtAlgorithmForFinding.setColumns(10);
		
		txtGtcsbMinimumCost = new JTextField();
		txtGtcsbMinimumCost.setEditable(false);
		txtGtcsbMinimumCost.setText("GT-CSB Minimum Cost Algorithm");
		txtGtcsbMinimumCost.setForeground(Color.WHITE);
		txtGtcsbMinimumCost.setFont(new Font("Cambria", Font.BOLD, 25));
		txtGtcsbMinimumCost.setColumns(10);
		txtGtcsbMinimumCost.setBorder(null);
		txtGtcsbMinimumCost.setBackground(Color.DARK_GRAY);
		txtGtcsbMinimumCost.setBounds(461, 90, 378, 35);
		frmHome.getContentPane().add(txtGtcsbMinimumCost);
		
		table = new JTable();
		table.setBounds(93, 400, 1114, 210);
		frmHome.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Get Data From Cloud");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 17));
		btnNewButton.setBounds(265, 226, 350, 35);
		frmHome.getContentPane().add(btnNewButton);
		
		JButton btnRunGtcsbMin = new JButton("Run GT-CSB Min Cost Algorithm");
		btnRunGtcsbMin.setForeground(Color.WHITE);
		btnRunGtcsbMin.setBackground(new Color(65, 105, 225));
		btnRunGtcsbMin.setBorder(null);
		btnRunGtcsbMin.setFont(new Font("Cambria", Font.BOLD, 17));
		btnRunGtcsbMin.setBounds(265, 272, 350, 35);
		frmHome.getContentPane().add(btnRunGtcsbMin);
		
		JButton btnNormalVsGtcsb = new JButton("Normal VS GT-CSB Cost Comparison Chart");
		btnNormalVsGtcsb.setBackground(new Color(65, 105, 225));
		btnNormalVsGtcsb.setForeground(Color.WHITE);
		btnNormalVsGtcsb.setBorder(null);
		btnNormalVsGtcsb.setFont(new Font("Cambria", Font.BOLD, 17));
		btnNormalVsGtcsb.setBounds(265, 318, 350, 35);
		frmHome.getContentPane().add(btnNormalVsGtcsb);
		
		txtCloudServiceProvider = new JTextField();
		txtCloudServiceProvider.setEditable(false);
		txtCloudServiceProvider.setBorder(null);
		txtCloudServiceProvider.setFont(new Font("Cambria", Font.BOLD, 17));
		txtCloudServiceProvider.setForeground(Color.WHITE);
		txtCloudServiceProvider.setBackground(Color.DARK_GRAY);
		txtCloudServiceProvider.setText("Cloud Service Provider");
		txtCloudServiceProvider.setBounds(300, 180, 185, 35);
		frmHome.getContentPane().add(txtCloudServiceProvider);
		txtCloudServiceProvider.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Cambria", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cloud 1", "Cloud 2"}));
		comboBox.setBounds(495, 180, 84, 30);
		frmHome.getContentPane().add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Cambria", Font.BOLD, 15));
		textArea.setEditable(false);
		textArea.setBounds(685, 180, 339, 173);
		frmHome.getContentPane().add(textArea);
		frmHome.setResizable(false);
		frmHome.setTitle("Home");
		frmHome.setBounds(100, 100, 1300, 700);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.setLocationRelativeTo(null);
	}
}

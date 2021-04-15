import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class MainWindow {

	private JFrame frmHome;
	private JTextField txtAlgorithmForFinding;

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
		txtAlgorithmForFinding.setBounds(93, 80, 1114, 35);
		frmHome.getContentPane().add(txtAlgorithmForFinding);
		txtAlgorithmForFinding.setColumns(10);
		
		JButton btnNewButton = new JButton("Cloud 1");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				frmHome.dispose();
				Cloud1 c1 = new Cloud1();
				c1.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 32));
		btnNewButton.setBounds(220, 190, 350, 100);
		frmHome.getContentPane().add(btnNewButton);
		
		JButton btnRunGtcsbMin = new JButton("Cloud 2");
		btnRunGtcsbMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				frmHome.dispose();
				Cloud2 c2 = new Cloud2();
				c2.setVisible(true);
			}
		});
		btnRunGtcsbMin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRunGtcsbMin.setForeground(Color.WHITE);
		btnRunGtcsbMin.setBackground(new Color(65, 105, 225));
		btnRunGtcsbMin.setBorder(null);
		btnRunGtcsbMin.setFont(new Font("Cambria", Font.BOLD, 32));
		btnRunGtcsbMin.setBounds(220, 330, 350, 100);
		frmHome.getContentPane().add(btnRunGtcsbMin);
		
		JButton btnNormalVsGtcsb = new JButton("GT-CSB  Algorithm");
		btnNormalVsGtcsb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				frmHome.dispose();
				GTCSB gt = new GTCSB();
				gt.setVisible(true);
			}
		});
		btnNormalVsGtcsb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNormalVsGtcsb.setBackground(new Color(65, 105, 225));
		btnNormalVsGtcsb.setForeground(Color.WHITE);
		btnNormalVsGtcsb.setBorder(null);
		btnNormalVsGtcsb.setFont(new Font("Cambria", Font.BOLD, 32));
		btnNormalVsGtcsb.setBounds(220, 470, 350, 100);
		frmHome.getContentPane().add(btnNormalVsGtcsb);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/reducecost.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(640, 185, 496, 413);
		frmHome.getContentPane().add(lblNewLabel);
		frmHome.setResizable(false);
		frmHome.setTitle("Home");
		frmHome.setBounds(100, 100, 1300, 700);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.setLocationRelativeTo(null);
	}
}

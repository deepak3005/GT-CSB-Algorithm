import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class GTCSB extends JFrame {

	private JPanel contentPane;
	private JTextField txtGtcsbMinimumCost;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GTCSB frame = new GTCSB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GTCSB() {
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("GT-CSB ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2 , size.height/2 - getHeight()/2 - 20);
		
		txtGtcsbMinimumCost = new JTextField();
		txtGtcsbMinimumCost.setText("GT-CSB  Minimum  Cost  Algorithm");
		txtGtcsbMinimumCost.setForeground(Color.WHITE);
		txtGtcsbMinimumCost.setFont(new Font("Cambria", Font.BOLD, 30));
		txtGtcsbMinimumCost.setEditable(false);
		txtGtcsbMinimumCost.setColumns(10);
		txtGtcsbMinimumCost.setBorder(null);
		txtGtcsbMinimumCost.setBackground(Color.DARK_GRAY);
		txtGtcsbMinimumCost.setBounds(455, 65, 480, 40);
		contentPane.add(txtGtcsbMinimumCost);
		
		textField_2 = new JTextField();
		textField_2.setText("Cloud Service Provider");
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Cambria", Font.BOLD, 17));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(Color.DARK_GRAY);
		textField_2.setBounds(300, 150, 185, 35);
		contentPane.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cloud 1", "Cloud 2"}));
		comboBox.setFont(new Font("Cambria", Font.BOLD, 15));
		comboBox.setBounds(511, 150, 84, 30);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Get Data From Cloud");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 17));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(265, 200, 350, 35);
		contentPane.add(btnNewButton);
		
		JButton btnRunGtcsbMin = new JButton("Run GT-CSB Min Cost Algorithm");
		btnRunGtcsbMin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRunGtcsbMin.setForeground(Color.WHITE);
		btnRunGtcsbMin.setFont(new Font("Cambria", Font.BOLD, 17));
		btnRunGtcsbMin.setBorder(null);
		btnRunGtcsbMin.setBackground(new Color(65, 105, 225));
		btnRunGtcsbMin.setBounds(265, 252, 350, 35);
		contentPane.add(btnRunGtcsbMin);
		
		JButton btnNormalVsGtcsb = new JButton("Normal VS GT-CSB Cost Comparison Chart");
		btnNormalVsGtcsb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNormalVsGtcsb.setForeground(Color.WHITE);
		btnNormalVsGtcsb.setFont(new Font("Cambria", Font.BOLD, 17));
		btnNormalVsGtcsb.setBorder(null);
		btnNormalVsGtcsb.setBackground(new Color(65, 105, 225));
		btnNormalVsGtcsb.setBounds(265, 305, 350, 35);
		contentPane.add(btnNormalVsGtcsb);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Cambria", Font.BOLD, 15));
		textArea.setEditable(false);
		textArea.setBounds(685, 150, 339, 190);
		contentPane.add(textArea);
		
		table = new JTable();
		table.setBounds(93, 385, 1114, 210);
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Back");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				SwitchWindows sw3 = new SwitchWindows();
				sw3.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/back-arrow.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(15, 15, 50, 48);
		contentPane.add(lblNewLabel_1);
	}
}

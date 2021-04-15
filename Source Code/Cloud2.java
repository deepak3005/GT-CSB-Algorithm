import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cloud2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCloudServer;
	private JTable table;
	private JTextField txtStorageCostkb;
	private JTextField txtComputationCostkb;
	private JTextField txtBandwidthCostkbps;
	private JTextField StorageCostInput;
	private JTextField ComputationCostInput;
	private JTextField BandwidthCostInput;
	private JButton btnBrowseFiles;
	private JButton btnCalculateCost_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cloud2 frame = new Cloud2();
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
	public Cloud2() {
		setTitle("Cloud 2");
		setResizable(false);
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
		
		txtCloudServer = new JTextField();
		txtCloudServer.setText("Cloud-2  Server");
		txtCloudServer.setForeground(Color.WHITE);
		txtCloudServer.setFont(new Font("Cambria", Font.BOLD, 30));
		txtCloudServer.setEditable(false);
		txtCloudServer.setColumns(10);
		txtCloudServer.setBorder(null);
		txtCloudServer.setBackground(Color.DARK_GRAY);
		txtCloudServer.setBounds(540, 70, 220, 35);
		contentPane.add(txtCloudServer);
		
		table = new JTable();
		table.setBounds(93, 380, 1114, 210);
		contentPane.add(table);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Cambria", Font.BOLD, 15));
		textArea.setEditable(false);
		textArea.setBounds(680, 160, 339, 115);
		contentPane.add(textArea);
		
		JButton btnCalculateCost = new JButton("Calculate  Cost");
		btnCalculateCost.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculateCost.setForeground(Color.WHITE);
		btnCalculateCost.setFont(new Font("Cambria", Font.BOLD, 18));
		btnCalculateCost.setBorder(null);
		btnCalculateCost.setBackground(new Color(65, 105, 225));
		btnCalculateCost.setBounds(400, 310, 200, 35);
		contentPane.add(btnCalculateCost);
		
		txtStorageCostkb = new JTextField();
		txtStorageCostkb.setText("Storage  Cost/KB");
		txtStorageCostkb.setForeground(Color.WHITE);
		txtStorageCostkb.setFont(new Font("Cambria", Font.BOLD, 18));
		txtStorageCostkb.setEditable(false);
		txtStorageCostkb.setColumns(10);
		txtStorageCostkb.setBorder(null);
		txtStorageCostkb.setBackground(Color.DARK_GRAY);
		txtStorageCostkb.setBounds(260, 165, 200, 25);
		contentPane.add(txtStorageCostkb);
		
		txtComputationCostkb = new JTextField();
		txtComputationCostkb.setText("Computation  Cost/KB");
		txtComputationCostkb.setForeground(Color.WHITE);
		txtComputationCostkb.setFont(new Font("Cambria", Font.BOLD, 18));
		txtComputationCostkb.setEditable(false);
		txtComputationCostkb.setColumns(10);
		txtComputationCostkb.setBorder(null);
		txtComputationCostkb.setBackground(Color.DARK_GRAY);
		txtComputationCostkb.setBounds(260, 208, 200, 25);
		contentPane.add(txtComputationCostkb);
		
		txtBandwidthCostkbps = new JTextField();
		txtBandwidthCostkbps.setText("Bandwidth  Cost/KBPS");
		txtBandwidthCostkbps.setForeground(Color.WHITE);
		txtBandwidthCostkbps.setFont(new Font("Cambria", Font.BOLD, 18));
		txtBandwidthCostkbps.setEditable(false);
		txtBandwidthCostkbps.setColumns(10);
		txtBandwidthCostkbps.setBorder(null);
		txtBandwidthCostkbps.setBackground(Color.DARK_GRAY);
		txtBandwidthCostkbps.setBounds(260, 250, 200, 25);
		contentPane.add(txtBandwidthCostkbps);
		
		StorageCostInput = new JTextField();
		StorageCostInput.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) 
				{
					e.consume();
				}
			}
		});
		StorageCostInput.setFont(new Font("Cambria", Font.BOLD, 15));
		StorageCostInput.setHorizontalAlignment(SwingConstants.CENTER);
		StorageCostInput.setBounds(480, 160, 80, 28);
		contentPane.add(StorageCostInput);
		StorageCostInput.setColumns(10);
		
		ComputationCostInput = new JTextField();
		ComputationCostInput.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) 
				{
					e.consume();
				}
			}
		});
		ComputationCostInput.setHorizontalAlignment(SwingConstants.CENTER);
		ComputationCostInput.setFont(new Font("Cambria", Font.BOLD, 15));
		ComputationCostInput.setColumns(10);
		ComputationCostInput.setBounds(480, 205, 80, 28);
		contentPane.add(ComputationCostInput);
		
		BandwidthCostInput = new JTextField();
		BandwidthCostInput.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) 
				{
					e.consume();
				}
			}
		});
		BandwidthCostInput.setHorizontalAlignment(SwingConstants.CENTER);
		BandwidthCostInput.setFont(new Font("Cambria", Font.BOLD, 15));
		BandwidthCostInput.setColumns(10);
		BandwidthCostInput.setBounds(480, 247, 80, 28);
		contentPane.add(BandwidthCostInput);
		
		JButton btnCalculateCost_1 = new JButton("Access  File");
		btnCalculateCost_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculateCost_1.setForeground(Color.WHITE);
		btnCalculateCost_1.setFont(new Font("Cambria", Font.BOLD, 18));
		btnCalculateCost_1.setBorder(null);
		btnCalculateCost_1.setBackground(new Color(65, 105, 225));
		btnCalculateCost_1.setBounds(705, 310, 200, 35);
		contentPane.add(btnCalculateCost_1);
		
		btnBrowseFiles = new JButton("Browse  Files");
		btnBrowseFiles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBrowseFiles.setForeground(Color.WHITE);
		btnBrowseFiles.setFont(new Font("Cambria", Font.BOLD, 18));
		btnBrowseFiles.setBorder(null);
		btnBrowseFiles.setBackground(new Color(65, 105, 225));
		btnBrowseFiles.setBounds(93, 310, 200, 35);
		contentPane.add(btnBrowseFiles);
		
		btnCalculateCost_2 = new JButton("Reload  Table");
		btnCalculateCost_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculateCost_2.setForeground(Color.WHITE);
		btnCalculateCost_2.setFont(new Font("Cambria", Font.BOLD, 18));
		btnCalculateCost_2.setBorder(null);
		btnCalculateCost_2.setBackground(new Color(65, 105, 225));
		btnCalculateCost_2.setBounds(1007, 310, 200, 35);
		contentPane.add(btnCalculateCost_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Back");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				SwitchWindows sw2 = new SwitchWindows();
				sw2.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/back-arrow.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(15, 15, 50, 48);
		contentPane.add(lblNewLabel_1);
	}
}

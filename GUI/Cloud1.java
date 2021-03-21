import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Cloud1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtCloudServer;
	private JTable table;
	private JTextField txtStorageCostkb;
	private JTextField txtComputationCostkb;
	private JTextField txtBandwidthCostkbps;
	private JTextField StorageCostInput;
	private JTextField ComputationCostInput;
	private JTextField BandwidthCostInput;
	private JButton btnCompressStorage;
	private JButton btnCompressExtensionChart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cloud1 frame = new Cloud1();
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
	public Cloud1() {
		setResizable(false);
		setTitle("Cloud 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("Algorithm for Finding the Minimum Cost of Storing and Regenerating Datasets in Multiple Clouds");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Cambria", Font.BOLD, 25));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(93, 40, 1114, 35);
		contentPane.add(textField);
		
		txtCloudServer = new JTextField();
		txtCloudServer.setText("Cloud-1  Server");
		txtCloudServer.setForeground(Color.WHITE);
		txtCloudServer.setFont(new Font("Cambria", Font.BOLD, 25));
		txtCloudServer.setEditable(false);
		txtCloudServer.setColumns(10);
		txtCloudServer.setBorder(null);
		txtCloudServer.setBackground(Color.DARK_GRAY);
		txtCloudServer.setBounds(559, 90, 182, 35);
		contentPane.add(txtCloudServer);
		
		table = new JTable();
		table.setBounds(93, 400, 1114, 210);
		contentPane.add(table);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Cambria", Font.BOLD, 15));
		textArea.setEditable(false);
		textArea.setBounds(680, 180, 339, 115);
		contentPane.add(textArea);
		
		JButton btnCalculateCost = new JButton("Calculate  Cost");
		btnCalculateCost.setForeground(Color.WHITE);
		btnCalculateCost.setFont(new Font("Cambria", Font.BOLD, 18));
		btnCalculateCost.setBorder(null);
		btnCalculateCost.setBackground(new Color(65, 105, 225));
		btnCalculateCost.setBounds(260, 325, 200, 35);
		contentPane.add(btnCalculateCost);
		
		txtStorageCostkb = new JTextField();
		txtStorageCostkb.setText("Storage  Cost/KB");
		txtStorageCostkb.setForeground(Color.WHITE);
		txtStorageCostkb.setFont(new Font("Cambria", Font.BOLD, 18));
		txtStorageCostkb.setEditable(false);
		txtStorageCostkb.setColumns(10);
		txtStorageCostkb.setBorder(null);
		txtStorageCostkb.setBackground(Color.DARK_GRAY);
		txtStorageCostkb.setBounds(260, 185, 200, 25);
		contentPane.add(txtStorageCostkb);
		
		txtComputationCostkb = new JTextField();
		txtComputationCostkb.setText("Computation  Cost/KB");
		txtComputationCostkb.setForeground(Color.WHITE);
		txtComputationCostkb.setFont(new Font("Cambria", Font.BOLD, 18));
		txtComputationCostkb.setEditable(false);
		txtComputationCostkb.setColumns(10);
		txtComputationCostkb.setBorder(null);
		txtComputationCostkb.setBackground(Color.DARK_GRAY);
		txtComputationCostkb.setBounds(260, 228, 200, 25);
		contentPane.add(txtComputationCostkb);
		
		txtBandwidthCostkbps = new JTextField();
		txtBandwidthCostkbps.setText("Bandwidth  Cost/KBPS");
		txtBandwidthCostkbps.setForeground(Color.WHITE);
		txtBandwidthCostkbps.setFont(new Font("Cambria", Font.BOLD, 18));
		txtBandwidthCostkbps.setEditable(false);
		txtBandwidthCostkbps.setColumns(10);
		txtBandwidthCostkbps.setBorder(null);
		txtBandwidthCostkbps.setBackground(Color.DARK_GRAY);
		txtBandwidthCostkbps.setBounds(260, 270, 200, 25);
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
		StorageCostInput.setBounds(480, 180, 80, 28);
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
		ComputationCostInput.setBounds(480, 225, 80, 28);
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
		BandwidthCostInput.setBounds(480, 267, 80, 28);
		contentPane.add(BandwidthCostInput);
		
		btnCompressStorage = new JButton("Compress  Storage");
		btnCompressStorage.setForeground(Color.WHITE);
		btnCompressStorage.setFont(new Font("Cambria", Font.BOLD, 18));
		btnCompressStorage.setBorder(null);
		btnCompressStorage.setBackground(new Color(65, 105, 225));
		btnCompressStorage.setBounds(515, 325, 200, 35);
		contentPane.add(btnCompressStorage);
		
		btnCompressExtensionChart = new JButton("Compress  Extension  Chart");
		btnCompressExtensionChart.setForeground(Color.WHITE);
		btnCompressExtensionChart.setFont(new Font("Cambria", Font.BOLD, 18));
		btnCompressExtensionChart.setBorder(null);
		btnCompressExtensionChart.setBackground(new Color(65, 105, 225));
		btnCompressExtensionChart.setBounds(763, 325, 256, 35);
		contentPane.add(btnCompressExtensionChart);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2 , size.height/2 - getHeight()/2 - 20);
		
		
		
		
	}

}

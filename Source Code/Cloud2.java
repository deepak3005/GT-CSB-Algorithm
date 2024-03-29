import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import net.proteanit.sql.DbUtils;

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
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	private JScrollPane scrollPane;
	
	File[] files;
	
	static String SelectedRowNumber,SelectedRowName,SelectedRowSize,SelectedRowStorage,SelectedRowComputation,SelectedRowBandwidth;
	static int SelectedRowAccess;
	private JButton btnCalculateCost_1_1;
	private JButton btnCalculateCost_1_1_1;
	
	public void displayTable()
	{
		
		try 
        {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
               
            String query2 = "SELECT File_Number,File_Name,File_Size,Access_Frequency,Storage_Cost,Computation_Cost,Bandwidth_Cost FROM cloud2";

            Statement sta = connection.createStatement();
            ResultSet rs2 = sta.executeQuery(query2);
            
            table.setModel(DbUtils.resultSetToTableModel(rs2));
            
            String query3 = "SELECT Input_SC FROM cloud2";
            Statement sta3 = connection.createStatement();
            ResultSet rs3 = sta.executeQuery(query3);
            rs3.next();
            StorageCostInput.setText((rs3.getString(1)));
            
            String query4 = "SELECT Input_CC FROM cloud2";
            Statement sta4 = connection.createStatement();
            ResultSet rs4 = sta.executeQuery(query4);
            rs4.next();
            ComputationCostInput.setText((rs4.getString(1)));
            
            String query5 = "SELECT Input_BC FROM cloud2";
            Statement sta5 = connection.createStatement();
            ResultSet rs5 = sta.executeQuery(query5);
            rs5.next();
            BandwidthCostInput.setText((rs5.getString(1)));
            
            connection.close();
        }
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
		
		
		TableColumn col1 = table.getColumnModel().getColumn(0);
	    col1.setPreferredWidth(100);
	    TableColumn col2 = table.getColumnModel().getColumn(1);
	    col2.setPreferredWidth(190);
	    TableColumn col3 = table.getColumnModel().getColumn(2);
	    col3.setPreferredWidth(100);
	    TableColumn col4 = table.getColumnModel().getColumn(3);
	    col4.setPreferredWidth(150);
	    TableColumn col5 = table.getColumnModel().getColumn(4);
	    col5.setPreferredWidth(100);
	    TableColumn col6 = table.getColumnModel().getColumn(5);
	    col6.setPreferredWidth(135);
	    TableColumn col7 = table.getColumnModel().getColumn(6);
	    col7.setPreferredWidth(145);
	    
	    JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setBackground(Color.black);
	    tableHeader.setForeground(Color.white);
	    Font headerFont = new Font("Cambria", Font.BOLD, 16);
	    tableHeader.setFont(headerFont);
	    tableHeader.setPreferredSize(new Dimension(50,40));
	}

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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 380, 1114, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		table.setGridColor(Color.black);
		table.setRowHeight(40);
		
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
	    r.setHorizontalAlignment(JLabel.CENTER);
	    table.setDefaultRenderer(Object.class,r);
		
		Font headerFont1 = new Font("Cambria", Font.BOLD, 16);
	    table.setFont(headerFont1);
		table.setBounds(93, 380, 1114, 210);
		
		table.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int SelectedRowIndex = table.getSelectedRow();
				SelectedRowNumber = model.getValueAt(SelectedRowIndex, 0).toString();
				SelectedRowName = model.getValueAt(SelectedRowIndex, 1).toString();
				SelectedRowSize = model.getValueAt(SelectedRowIndex, 2).toString();
				SelectedRowAccess = (Integer) model.getValueAt(SelectedRowIndex, 3);
				SelectedRowStorage = model.getValueAt(SelectedRowIndex, 4).toString();
				SelectedRowComputation = model.getValueAt(SelectedRowIndex, 5).toString();
				SelectedRowBandwidth = model.getValueAt(SelectedRowIndex, 6).toString();
			}
		});
		
		JButton btnCalculateCost = new JButton("Calculate  Cost");
		btnCalculateCost.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				float StorageCostEntered = Float.parseFloat(StorageCostInput.getText());
				float ComputationCostEntered = Float.parseFloat(ComputationCostInput.getText());
				float BandwidthCostEntered = Float.parseFloat(BandwidthCostInput.getText());
				
				try 
                {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
                    
                    String query1 = "SELECT * from cloud2";
                    Statement sta1 = connection.createStatement();
                    ResultSet rs = sta1.executeQuery(query1); 
                    
                    int count = 0;
                    
                    while(rs.next())
                    {
                    	count++;
                        float GetFileSize = rs.getFloat("File_Size");
                        
                        float CalculateStorage = GetFileSize*StorageCostEntered;
                        float CalculateComputation = GetFileSize*ComputationCostEntered;
                        float CalculateBandwidth = GetFileSize*BandwidthCostEntered;
                        
                        String query2 = "UPDATE cloud2 SET Storage_Cost='"+CalculateStorage+"' WHERE File_Number='"+count+"'";
                        Statement sta2 = connection.createStatement();
                        sta2.executeUpdate(query2);
                        
                        String query3 = "UPDATE cloud2 SET Computation_Cost='"+CalculateComputation+"' WHERE File_Number='"+count+"'";
                        Statement sta3 = connection.createStatement();
                        sta3.executeUpdate(query3);
                        
                        String query4 = "UPDATE cloud2 SET Bandwidth_Cost='"+CalculateBandwidth+"' WHERE File_Number='"+count+"'";
                        Statement sta4 = connection.createStatement();
                        sta4.executeUpdate(query4);
                        
                        float CCandBC = CalculateComputation + CalculateBandwidth;
                        
                        String query5 = "UPDATE cloud2 SET CC_and_BC='"+CCandBC+"' WHERE File_Number='"+count+"'";
                        Statement sta5 = connection.createStatement();
                        sta4.executeUpdate(query5);
                        
                        String query6 = "UPDATE cloud2 SET Input_SC='"+StorageCostEntered+"' WHERE File_Number='"+count+"'";
                        Statement sta6 = connection.createStatement();
                        sta4.executeUpdate(query6);
                        
                        String query7 = "UPDATE cloud2 SET Input_CC='"+ComputationCostEntered+"' WHERE File_Number='"+count+"'";
                        Statement sta7 = connection.createStatement();
                        sta4.executeUpdate(query7);
                        
                        String query8 = "UPDATE cloud2 SET Input_BC='"+BandwidthCostEntered+"' WHERE File_Number='"+count+"'";
                        Statement sta8 = connection.createStatement();
                        sta4.executeUpdate(query8);
                        
                    }
                    
                    connection.close();
                }
                catch (Exception exception) 
                {
                	exception.printStackTrace();
                }
				displayTable();
			}
		});
		btnCalculateCost.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculateCost.setForeground(Color.WHITE);
		btnCalculateCost.setFont(new Font("Cambria", Font.BOLD, 18));
		btnCalculateCost.setBorder(null);
		btnCalculateCost.setBackground(new Color(65, 105, 225));
		btnCalculateCost.setBounds(400, 305, 200, 35);
		contentPane.add(btnCalculateCost);
		
		txtStorageCostkb = new JTextField();
		txtStorageCostkb.setText("Storage  Cost/KB (INR)");
		txtStorageCostkb.setForeground(Color.WHITE);
		txtStorageCostkb.setFont(new Font("Cambria", Font.BOLD, 18));
		txtStorageCostkb.setEditable(false);
		txtStorageCostkb.setColumns(10);
		txtStorageCostkb.setBorder(null);
		txtStorageCostkb.setBackground(Color.DARK_GRAY);
		txtStorageCostkb.setBounds(480, 157, 200, 25);
		contentPane.add(txtStorageCostkb);
		
		txtComputationCostkb = new JTextField();
		txtComputationCostkb.setText("Computation  Cost/KB (INR)");
		txtComputationCostkb.setForeground(Color.WHITE);
		txtComputationCostkb.setFont(new Font("Cambria", Font.BOLD, 18));
		txtComputationCostkb.setEditable(false);
		txtComputationCostkb.setColumns(10);
		txtComputationCostkb.setBorder(null);
		txtComputationCostkb.setBackground(Color.DARK_GRAY);
		txtComputationCostkb.setBounds(480, 200, 240, 25);
		contentPane.add(txtComputationCostkb);
		
		txtBandwidthCostkbps = new JTextField();
		txtBandwidthCostkbps.setText("Bandwidth  Cost/KBPS (INR)");
		txtBandwidthCostkbps.setForeground(Color.WHITE);
		txtBandwidthCostkbps.setFont(new Font("Cambria", Font.BOLD, 18));
		txtBandwidthCostkbps.setEditable(false);
		txtBandwidthCostkbps.setColumns(10);
		txtBandwidthCostkbps.setBorder(null);
		txtBandwidthCostkbps.setBackground(Color.DARK_GRAY);
		txtBandwidthCostkbps.setBounds(480, 242, 240, 25);
		contentPane.add(txtBandwidthCostkbps);
		
		StorageCostInput = new JTextField();
		StorageCostInput.setText("0");
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
		StorageCostInput.setBounds(730, 155, 80, 28);
		contentPane.add(StorageCostInput);
		StorageCostInput.setColumns(10);
		
		ComputationCostInput = new JTextField();
		ComputationCostInput.setText("0");
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
		ComputationCostInput.setBounds(730, 200, 80, 28);
		contentPane.add(ComputationCostInput);
		
		BandwidthCostInput = new JTextField();
		BandwidthCostInput.setText("0");
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
		BandwidthCostInput.setBounds(730, 242, 80, 28);
		contentPane.add(BandwidthCostInput);
		
		JButton btnCalculateCost_1 = new JButton("Access  File");
		btnCalculateCost_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnCalculateCost_1.setForeground(Color.WHITE);
		btnCalculateCost_1.setFont(new Font("Cambria", Font.BOLD, 18));
		btnCalculateCost_1.setBorder(null);
		btnCalculateCost_1.setBackground(new Color(65, 105, 225));
		btnCalculateCost_1.setBounds(705, 305, 150, 35);
		contentPane.add(btnCalculateCost_1);
		
		btnBrowseFiles = new JButton("Browse  Files");
		btnBrowseFiles.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int af = 1;
				int sc = 0;
				int cc = 0;
				int bc = 0;
				int ccANDbc = 0;
				int isc = 0;
				int icc = 0;
				int ibc = 0;
				
				//JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				File f = new File("D:\\College Material\\Projects\\Minor-2 Project");
				JFileChooser j = new JFileChooser(f,FileSystemView.getFileSystemView());
                j.setDialogTitle("Browse");
                j.setMultiSelectionEnabled(true);
                int r = j.showOpenDialog(null); 
                if (r == JFileChooser.APPROVE_OPTION) 
                { 
                    files = j.getSelectedFiles();
                	String fileNames = "";
                    for(File file: files)
                    {
                    	int i = 1;
                    	//fileNames += file.getName();
                        try 
                        {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
                            
                            String query1 = "SELECT * from cloud2";
                            Statement sta1 = connection.createStatement();
                            ResultSet rs = sta1.executeQuery(query1);
                            while(rs.next())
                            {
                                i++;
                            }
                                
                            String query2 = "INSERT INTO cloud2 values('" + i + "','" + file.getName() + "','" + file.length() + "','" + af + "','" + sc + "','" + cc + "','" + bc + "','" + ccANDbc + "','" + isc + "','" + icc + "','" + ibc + "')";
                            Statement sta2 = connection.createStatement();
                            sta2.executeUpdate(query2);
                            
                            connection.close();
                        }
                        catch (Exception exception) 
                        {
                        	exception.printStackTrace();
                        }
                    }
                }
                displayTable();
			
			}
		});
		btnBrowseFiles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBrowseFiles.setForeground(Color.WHITE);
		btnBrowseFiles.setFont(new Font("Cambria", Font.BOLD, 18));
		btnBrowseFiles.setBorder(null);
		btnBrowseFiles.setBackground(new Color(65, 105, 225));
		btnBrowseFiles.setBounds(93, 305, 200, 35);
		contentPane.add(btnBrowseFiles);
		
		btnCalculateCost_2 = new JButton("Reset  Cost");
		btnCalculateCost_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try 
                {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
                    
                    String query1 = "SELECT * from cloud2";
                    Statement sta1 = connection.createStatement();
                    ResultSet rs = sta1.executeQuery(query1); 
                    
                    int count = 0;
                    
                    while(rs.next())
                    {
                    	count++;
                        
                        int CalculateStorage = 0;
                        int CalculateComputation = 0;
                        int CalculateBandwidth = 0;
                        
                        String query2 = "UPDATE cloud2 SET Storage_Cost='"+CalculateStorage+"' WHERE File_Number='"+count+"'";
                        Statement sta2 = connection.createStatement();
                        sta2.executeUpdate(query2);
                        
                        String query3 = "UPDATE cloud2 SET Computation_Cost='"+CalculateComputation+"' WHERE File_Number='"+count+"'";
                        Statement sta3 = connection.createStatement();
                        sta3.executeUpdate(query3);
                        
                        String query4 = "UPDATE cloud2 SET Bandwidth_Cost='"+CalculateBandwidth+"' WHERE File_Number='"+count+"'";
                        Statement sta4 = connection.createStatement();
                        sta4.executeUpdate(query4);
                    }
                    
                    connection.close();
                }
                catch (Exception exception) 
                {
                	exception.printStackTrace();
                }
				displayTable();
			}
		});
		btnCalculateCost_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculateCost_2.setForeground(Color.WHITE);
		btnCalculateCost_2.setFont(new Font("Cambria", Font.BOLD, 18));
		btnCalculateCost_2.setBorder(null);
		btnCalculateCost_2.setBackground(new Color(65, 105, 225));
		btnCalculateCost_2.setBounds(1040, 305, 167, 35);
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
		
		btnCalculateCost_1_1 = new JButton("+");
		btnCalculateCost_1_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(SelectedRowName==null)
				{
					JOptionPane.showMessageDialog(null, new JLabel("Please select a file to access !", JLabel.CENTER), "No file selected", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					SelectedRowAccess = SelectedRowAccess+1;
					
					try 
	            	{
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
	                    
	                    String query = "UPDATE cloud2 SET Access_Frequency='"+SelectedRowAccess+"' WHERE File_Name='"+SelectedRowName+"'";
                        Statement sta = connection.createStatement();
                        sta.executeUpdate(query);
	                    connection.close();
	                    
	                }
	                catch (Exception exception) 
	            	{
	                    exception.printStackTrace();
	                }
					
					displayTable();
				}
			}
		});
		btnCalculateCost_1_1.setForeground(Color.WHITE);
		btnCalculateCost_1_1.setFont(new Font("Cambria", Font.BOLD, 30));
		btnCalculateCost_1_1.setBorder(null);
		btnCalculateCost_1_1.setBackground(new Color(65, 105, 225));
		btnCalculateCost_1_1.setBounds(860, 305, 35, 35);
		contentPane.add(btnCalculateCost_1_1);
		
		btnCalculateCost_1_1_1 = new JButton("-");
		btnCalculateCost_1_1_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(SelectedRowName==null)
				{
					JOptionPane.showMessageDialog(null, new JLabel("Please select a file to access !", JLabel.CENTER), "No file selected", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(SelectedRowAccess>1)
					{
						SelectedRowAccess = SelectedRowAccess-1;
						
						try 
		            	{
		                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
		                    
		                    String query = "UPDATE cloud2 SET Access_Frequency='"+SelectedRowAccess+"' WHERE File_Name='"+SelectedRowName+"'";
	                        Statement sta = connection.createStatement();
	                        sta.executeUpdate(query);
		                    connection.close();
		                    
		                }
		                catch (Exception exception) 
		            	{
		                    exception.printStackTrace();
		                }
						
						displayTable();
					}
				}
			}
		});
		btnCalculateCost_1_1_1.setForeground(Color.WHITE);
		btnCalculateCost_1_1_1.setFont(new Font("Cambria", Font.BOLD, 32));
		btnCalculateCost_1_1_1.setBorder(null);
		btnCalculateCost_1_1_1.setBackground(new Color(65, 105, 225));
		btnCalculateCost_1_1_1.setBounds(900, 305, 35, 35);
		contentPane.add(btnCalculateCost_1_1_1);
		
		
		displayTable();
	}
}

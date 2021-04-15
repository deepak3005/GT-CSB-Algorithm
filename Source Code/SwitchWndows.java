import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class SwitchWindows extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwitchWindows frame = new SwitchWindows();
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
	public SwitchWindows() {
		setTitle("Switch Windows");
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
		
		JButton btnNewButton = new JButton("Cloud 1");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				Cloud1 c1 = new Cloud1();
				c1.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 32));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(475, 120, 350, 120);
		contentPane.add(btnNewButton);
		
		JButton btnRunGtcsbMin = new JButton("Cloud 2");
		btnRunGtcsbMin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRunGtcsbMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				Cloud2 c2 = new Cloud2();
				c2.setVisible(true);
			}
		});
		btnRunGtcsbMin.setForeground(Color.WHITE);
		btnRunGtcsbMin.setFont(new Font("Cambria", Font.BOLD, 32));
		btnRunGtcsbMin.setBorder(null);
		btnRunGtcsbMin.setBackground(new Color(65, 105, 225));
		btnRunGtcsbMin.setBounds(475, 290, 350, 120);
		contentPane.add(btnRunGtcsbMin);
		
		JButton btnNormalVsGtcsb = new JButton("GT-CSB  Algorithm");
		btnNormalVsGtcsb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNormalVsGtcsb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				GTCSB gt2 = new GTCSB();
				gt2.setVisible(true);
			}
		});
		btnNormalVsGtcsb.setForeground(Color.WHITE);
		btnNormalVsGtcsb.setFont(new Font("Cambria", Font.BOLD, 32));
		btnNormalVsGtcsb.setBorder(null);
		btnNormalVsGtcsb.setBackground(new Color(65, 105, 225));
		btnNormalVsGtcsb.setBounds(475, 460, 350, 120);
		contentPane.add(btnNormalVsGtcsb);
	}

}

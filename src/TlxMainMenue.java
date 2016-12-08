import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TlxMainMenue extends JFrame {

	private JPanel contentPane;
	private JTextField exportName;
	private JButton btnSave;
	private JButton btnExport;
	private JButton btnAnalysis;
	private JButton btnReset;
	

	public TlxMainMenue(int windowWith, int windowHeight) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		setBounds((int)(width-800)/2, 30, windowWith, windowHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("NASA-TLX");
		heading.setBounds(200, 50, 400, 50);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setForeground(Color.decode("#EEEEEE"));
		heading.setFont(new Font("Sans-Serif", Font.BOLD, 60));
		contentPane.add(heading);
		JLabel subheading = new JLabel("Testsuite");
		subheading.setBounds(200, 120, 400, 30);
		subheading.setHorizontalAlignment(SwingConstants.CENTER);
		subheading.setForeground(Color.decode("#EEEEEE"));
		subheading.setFont(new Font("Sans-Serif", Font.BOLD, 30));
		contentPane.add(subheading);
		JLabel footer = new JLabel("Human-Computer-Interaction - TU Dresden - winter term 16/17");
		footer.setBounds(100, 630, 600, 20);
		footer.setHorizontalAlignment(SwingConstants.CENTER);
		footer.setForeground(Color.decode("#AAAAAA"));
		footer.setFont(new Font("Sans-Serif", Font.PLAIN, 12));
		contentPane.add(footer);
		JLabel subfooter = new JLabel("created by Julian Catoni & Jonas Fischer");
		subfooter.setBounds(100, 650, 600, 20);
		subfooter.setHorizontalAlignment(SwingConstants.CENTER);
		subfooter.setForeground(Color.decode("#AAAAAA"));
		subfooter.setFont(new Font("Sans-Serif", Font.PLAIN, 12));
		contentPane.add(subfooter);
		
		JButton btnStartTlx = CustomButtonFactory.createNewButton("Start test", 275, 200, 250, 50);
		btnStartTlx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewController.getInstance().showFirstTest(TlxMainMenue.this);
			}
		});
		contentPane.add(btnStartTlx);
		
		
	
		btnAnalysis = CustomButtonFactory.createNewButton("Analysis", 275, 260, 250, 50);
		btnAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewController.getInstance().showAnalysis(TlxMainMenue.this);
			}
		});
		contentPane.add(btnAnalysis);
		
		
		btnReset = CustomButtonFactory.createNewButton("Reset", 275, 320, 250, 50);
		btnReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewController.getInstance().values.clear();
				ViewController.getInstance().weights.clear();
				enableButtons(false);
			}
		});
		contentPane.add(btnReset);
		
		
		btnExport = CustomButtonFactory.createNewButton("Export", 275, 380, 250, 50);
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSave.setVisible(!btnSave.isVisible());
				exportName.setVisible(!exportName.isVisible());
				exportName.setText("tlx-"+Calendar.getInstance().getTimeInMillis());
			}
		});		
		contentPane.add(btnExport);
		
		
		exportName = new JTextField();
		exportName.setVisible(false);
		exportName.setBounds(275, 440, 190, 25);
		exportName.setBackground(Color.DARK_GRAY);
		exportName.setForeground(Color.decode("#EEEEEE"));
		exportName.setCaretColor(Color.decode("#EEEEEE"));
		contentPane.add(exportName);
		
		btnSave = CustomButtonFactory.createNewButton("Save", 475, 440, 50, 26);
		btnSave.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String path = TlxMainMenue.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
					path = path.substring(0, path.lastIndexOf("/") + 1);
					Writer writer = new BufferedWriter(new OutputStreamWriter(
									new FileOutputStream(path + exportName.getText()+".json"), "utf-8"));
					writer.write(ViewController.getInstance().createJson());
					writer.close();
					exportName.setVisible(false);
					btnSave.setVisible(false);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		contentPane.add(btnSave);
		
		
		
		

		
		JButton btnClose = CustomButtonFactory.createNewButton("Close", 275, 480, 250, 50);

		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlxMainMenue.this.processWindowEvent(
		                new WindowEvent(
		                      TlxMainMenue.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		contentPane.add(btnClose);
	}
	
	public void enableButtons(boolean enable){
		btnAnalysis.setEnabled(enable);
		btnExport.setEnabled(enable);
		btnReset.setEnabled(enable);
	}
	
}

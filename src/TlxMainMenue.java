import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TlxMainMenue extends JFrame {

	private JPanel contentPane;
	private JTextField exportName;
	private JButton btnSave;
	private JButton btnExport;
	private JButton btnAnalysis;
	

	public TlxMainMenue(int windowWith, int windowHeight) {
		
		setBounds(100, 100, windowWith, windowHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartTlx = CustomButtonFactory.createNewButton("Start TLX", 275, 200, 250, 50);
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
		
		
		btnExport = CustomButtonFactory.createNewButton("Export", 275, 330, 250, 50);
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSave.setVisible(!btnSave.isVisible());
				exportName.setVisible(!exportName.isVisible());
			}
		});		
		contentPane.add(btnExport);
		
		
		exportName = new JTextField();
		exportName.setVisible(false);
		exportName.setBounds(275, 390, 190, 25);
		exportName.setBackground(Color.DARK_GRAY);
		exportName.setForeground(Color.decode("#EEEEEE"));
		exportName.setCaretColor(Color.decode("#EEEEEE"));
		exportName.setText("tlx-"+Calendar.getInstance().getTimeInMillis());
		contentPane.add(exportName);
		
		btnSave = CustomButtonFactory.createNewButton("Save", 475, 390, 50, 26);
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try (Writer writer = new BufferedWriter(new OutputStreamWriter(
			              new FileOutputStream(exportName.getText()+".json"), "utf-8"))) {
					writer.write(ViewController.getInstance().createJson());
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			}
		});
		contentPane.add(btnSave);
		
		
		
		JButton btnClose = CustomButtonFactory.createNewButton("Close", 300, 460, 200, 50);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlxMainMenue.this.processWindowEvent(
		                new WindowEvent(
		                      TlxMainMenue.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		contentPane.add(btnClose);
	}
	
	public void enableExportAndAnalysis(boolean enable){
		btnAnalysis.setEnabled(enable);
		btnExport.setEnabled(enable);
	}
	
}

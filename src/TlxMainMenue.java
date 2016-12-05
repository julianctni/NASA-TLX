import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TlxMainMenue extends JFrame {

	private JPanel contentPane;	

	public TlxMainMenue(int windowWith, int windowHeight) {
		
		setBounds(100, 100, windowWith, windowHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartTlx = new JButton("New TLX");
		btnStartTlx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewController.getInstance().showFirstTest(TlxMainMenue.this);
			}
		});
		btnStartTlx.setBounds(300, 200, 200, 50);
		contentPane.add(btnStartTlx);		
		
		JButton btnAnalyse = new JButton("Analysis");
		btnAnalyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ViewController controller = ViewController.getInstance();
				ViewController.getInstance().showAnalysis(TlxMainMenue.this);
			}
		});
		btnAnalyse.setBounds(300, 260, 200, 50);
		contentPane.add(btnAnalyse);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewController.getInstance().values.clear();
				ViewController.getInstance().weights.clear();
			}
		});
		btnReset.setBounds(300, 355, 200, 50);
		contentPane.add(btnReset);
		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlxMainMenue.this.processWindowEvent(
		                new WindowEvent(
		                      TlxMainMenue.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnClose.setBounds(300, 415, 200, 50);
		contentPane.add(btnClose);
	}

}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
				ViewController.getInstance().showTest(TlxMainMenue.this);
			}
		});
		btnStartTlx.setBounds(300, 200, 200, 50);
		contentPane.add(btnStartTlx);
		
		
		
		JButton btnAnalyse = new JButton("Analyse");
		btnAnalyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewController.getInstance().showAnalysis(TlxMainMenue.this);
			}
		});
		btnAnalyse.setBounds(300, 260, 200, 50);
		contentPane.add(btnAnalyse);
		
		
		JButton btnClose = new JButton("Beenden");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlxMainMenue.this.processWindowEvent(
		                new WindowEvent(
		                      TlxMainMenue.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnClose.setBounds(300, 355, 200, 50);
		contentPane.add(btnClose);
	}

}

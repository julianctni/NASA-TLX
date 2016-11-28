import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.JLabel;


public class TlxTestView extends JFrame {

	private int mWindowWidth;

	public TlxTestView(int windowWidth, int windowHeight) {
		mWindowWidth = windowWidth;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, windowWidth, windowHeight);
		JPanel main = new JPanel();
		main.setLayout(null);
		int yPos = 20;
		main.add(addNewSlider("How mentally demanding was the task?",yPos));
		main.add(addNewSlider("How physically demanding was the task?",yPos+=120));
		main.add(addNewSlider("How hurried or rushed was the pace of the task?",yPos+=120));
		main.add(addNewSlider("How successful were you in accomplishing what you were asked to do?",yPos+=120));
		main.add(addNewSlider("How hard did you have to work to accomplish your level of performance?",yPos+=120));
		main.add(addNewSlider("How insecure, discouraged, irritated, stressed, and annoyed were you?",yPos+=120));
		JButton btnSaveTLX = new JButton("Absenden");
		btnSaveTLX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewController.getInstance().showMainMenue(TlxTestView.this);
			}
		});
		btnSaveTLX.setBounds(500, yPos+=120, 200, 50);
		main.add(btnSaveTLX);
		main.setPreferredSize(new Dimension( mWindowWidth,yPos+70));
		JScrollPane scrollFrame = new JScrollPane(main, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		main.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(windowWidth,windowHeight));
		scrollFrame.getVerticalScrollBar().setUnitIncrement(5);
		this.add(scrollFrame);
		
	}
	
	public JPanel addNewSlider(String labelText, int yPosition){
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(10, yPosition, mWindowWidth-100, 100);
		contentPane.setBorder(BorderFactory.createTitledBorder(labelText));
		
		JSlider sliderMD = new JSlider();
	    sliderMD.setMinorTickSpacing(2);
	    sliderMD.setMajorTickSpacing(10);
	    sliderMD.setPaintLabels(true);
	    sliderMD.setPaintTicks(true);
	    sliderMD.setBounds(10, 25, 550, 50);
	    sliderMD.setLabelTable(sliderMD.createStandardLabels(10));
	    
	 
	    
	    JLabel valueMD = new JLabel(""+sliderMD.getValue());
	    valueMD.setBounds(630, 25, 30, 30);
	    
	    valueMD.setFont(new Font("Sans-Serif", Font.PLAIN, 22));
		
		sliderMD.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent changeEvent) {
	    		valueMD.setText(sliderMD.getValue()+"");
	    	}
	    });
		
		contentPane.add(sliderMD);
		contentPane.add(valueMD);
		
		return contentPane;
	}
}

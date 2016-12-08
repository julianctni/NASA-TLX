import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TlxTestView extends JFrame {

	private int mWindowWidth;
	private int sliderCount = 0;
	private JSlider[] sliders = new JSlider[6];

	public TlxTestView(int windowWidth, int windowHeight) {
		mWindowWidth = windowWidth;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel main = new JPanel();
		main.setBorder(null);
		main.setBackground(Color.DARK_GRAY);
		main.setLayout(null);
		int yPos = 20;
		main.add(addNewSlider("How mentally demanding was the task?",yPos));
		main.add(addNewSlider("How physically demanding was the task?",yPos+=100));
		main.add(addNewSlider("How hurried or rushed was the pace of the task?",yPos+=100));
		main.add(addNewSlider("How successful were you in accomplishing what you were asked to do?",yPos+=100));
		main.add(addNewSlider("How hard did you have to work to accomplish your level of performance?",yPos+=100));
		main.add(addNewSlider("How insecure, discouraged, irritated, stressed, and annoyed were you?",yPos+=100));
		JButton btnSaveTLX = CustomButtonFactory.createNewButton("Finish test", 500, yPos+=90, 250, 50);
		btnSaveTLX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				int[] tempArray = new int[6];
				for(JSlider Sld : sliders){
					tempArray[i] = Sld.getValue();
					Sld.setValue(50);
					i++;
				}
				ViewController.getInstance().resetFirstTestFrame();
				ViewController.getInstance().values.add(tempArray);

				ViewController.getInstance().showMainMenue(TlxTestView.this);
				JOptionPane.showMessageDialog(null, "Thanks for participating!");
			}
		});
		
		JButton btnBack = CustomButtonFactory.createNewButton("Back", 50, yPos, 250, 50);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewController.getInstance().showFirstTest(TlxTestView.this);
			}
		});
		
		main.add(btnSaveTLX);
		main.add(btnBack);
		main.setPreferredSize(new Dimension( mWindowWidth,yPos+70));
		JScrollPane scrollFrame = new JScrollPane(main, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		main.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(windowWidth,windowHeight));
		scrollFrame.setBorder(null);
		scrollFrame.getVerticalScrollBar().setUnitIncrement(5);
		this.add(scrollFrame);
		
	}
	
	int count = 1;
	
	public JPanel addNewSlider(String labelText, int yPosition){
		JPanel contentPane = new JPanel();
		
		contentPane.setLayout(null);
		contentPane.setBounds(50, yPosition, mWindowWidth-100, 80);
		TitledBorder border = BorderFactory.createTitledBorder(labelText);
		border.setTitleFont(new Font("Sans-Serif", Font.BOLD, 13));
		border.setTitleColor(Color.decode("#EEEEEE"));
		border.setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")));
		contentPane.setBorder(border);
		
		JSlider sliderMD = new JSlider();
		
		sliderMD.setForeground(Color.decode("#EEEEEE"));
	    sliderMD.setMinorTickSpacing(5);
	    sliderMD.setMajorTickSpacing(10);
	    sliderMD.setPaintLabels(true);
	    sliderMD.setPaintTicks(true);
	    sliderMD.setBounds(10, 25, 550, 50);
	    sliderMD.setLabelTable(sliderMD.createStandardLabels(10));
	    sliderMD.setSnapToTicks(true);
	    
		contentPane.setBackground(Color.DARK_GRAY);
		sliderMD.setBackground(Color.DARK_GRAY);
	    
		count++;
	    
	    addSliderToArray(sliderMD);
	    
	    JLabel valueMD = new JLabel(""+sliderMD.getValue());
	    valueMD.setBounds(630, 25, 50, 30);
	    
	    valueMD.setFont(new Font("Sans-Serif", Font.BOLD, 22));
	    valueMD.setForeground(Color.decode("#EEEEEE"));
	    
		sliderMD.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent changeEvent) {
	    		int value = sliderMD.getValue();
	    		int newValue = value - value%5;
	    		valueMD.setText(newValue+"");
	    	}
	    });
		
		contentPane.add(sliderMD);
		contentPane.add(valueMD);
		
		return contentPane;
	}
	
	public void addSliderToArray(JSlider slider){
		sliders[sliderCount] = slider;
		sliderCount++;
		if(sliderCount == 6)
			sliderCount = 0;
	}
}

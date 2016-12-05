import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.util.logging.*;


public class TlxFirstTestView extends JFrame {

	private int mWindowWidth;
	private int radBtnCount = 0;
	private JRadioButton[] radBtns = new JRadioButton[30];

	public TlxFirstTestView(int windowWidth, int windowHeight) {
		mWindowWidth = windowWidth;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, windowWidth, windowHeight);
		JPanel main = new JPanel();
		main.setLayout(null);
		int yPos = 20;
		
		JLabel tasklabel = new JLabel("Select the member which provided the most significant source of workload variation of each pair!");
		tasklabel.setBounds(50, yPos, windowWidth-100, 50);
		main.add(tasklabel);
		
		String MDString = "Mental Demand";
		String PDString = "Physical Demand";
		String TDString = "Temporal Demand";
		String OPString = "Performance";
		String EFString = "Effort";
		String FRString = "Frustration";
		
		JRadioButton radMD1 = new JRadioButton(MDString);
		radMD1.setBounds(150, yPos+=50, 200, 20);
		radMD1.setSelected(true);
		addRadBtnToArrys(radMD1);
	    JRadioButton radPD1 = new JRadioButton(PDString);
	    radPD1.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radPD1);
	    ButtonGroup groupMDPD = new ButtonGroup();
	    groupMDPD.add(radMD1);
	    groupMDPD.add(radPD1);	    
	    JRadioButton radMD2 = new JRadioButton(MDString);
		radMD2.setBounds(150, yPos+=30, 200, 20);
		addRadBtnToArrys(radMD2);
		radMD2.setSelected(true);
		JRadioButton radTD1 = new JRadioButton(TDString);
	    radTD1.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radTD1);
	    ButtonGroup groupMDTD = new ButtonGroup();
	    groupMDTD.add(radMD2);
	    groupMDTD.add(radTD1);	    
	    JRadioButton radMD3 = new JRadioButton(MDString);
	    radMD3.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radMD3);
	    radMD3.setSelected(true);
	    JRadioButton radOP1 = new JRadioButton(OPString);
	    radOP1.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radOP1);
	    ButtonGroup groupMDOP = new ButtonGroup();
	    groupMDOP.add(radMD3);
	    groupMDOP.add(radOP1);	    
	    JRadioButton radMD4 = new JRadioButton(MDString);
	    radMD4.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radMD4);
	    radMD4.setSelected(true);
	    JRadioButton radFR1 = new JRadioButton(FRString);
	    radFR1.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radFR1);
	    ButtonGroup groupMDFR = new ButtonGroup();
	    groupMDFR.add(radMD4);
	    groupMDFR.add(radFR1);	    
	    JRadioButton radMD5 = new JRadioButton(MDString);
	    radMD5.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radMD5);
	    radMD5.setSelected(true);
	    JRadioButton radEF1 = new JRadioButton(EFString);
	    radEF1.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radEF1);
	    ButtonGroup groupMDEF = new ButtonGroup();
	    groupMDEF.add(radMD5);
	    groupMDEF.add(radEF1);	    
	    JRadioButton radPD2 = new JRadioButton(PDString);
	    radPD2.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radPD2);
	    radPD2.setSelected(true);
	    JRadioButton radTD2 = new JRadioButton(TDString);
	    radTD2.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radTD2);
	    ButtonGroup groupPDTD = new ButtonGroup();
	    groupPDTD.add(radPD2);
	    groupPDTD.add(radTD2);
	    JRadioButton radPD3 = new JRadioButton(PDString);
	    radPD3.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radPD3);
	    radPD3.setSelected(true);
	    JRadioButton radOP2 = new JRadioButton(OPString);
	    radOP2.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radOP2);
	    ButtonGroup groupPDOP = new ButtonGroup();
	    groupPDOP.add(radPD3);
	    groupPDOP.add(radOP2);
	    JRadioButton radPD4 = new JRadioButton(PDString);
	    radPD4.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radPD4);
	    radPD4.setSelected(true);
	    JRadioButton radFR2 = new JRadioButton(FRString);
	    radFR2.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radFR2);
	    ButtonGroup groupPDFR = new ButtonGroup();
	    groupPDFR.add(radPD4);
	    groupPDFR.add(radFR2);
	    JRadioButton radPD5 = new JRadioButton(PDString);
	    radPD5.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radPD5);
	    radPD5.setSelected(true);
	    JRadioButton radEF2 = new JRadioButton(EFString);
	    radEF2.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radEF2);
	    ButtonGroup groupPDEF = new ButtonGroup();
	    groupPDEF.add(radPD5);
	    groupPDEF.add(radEF2);
	    JRadioButton radTD3 = new JRadioButton(TDString);
	    radTD3.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radTD3);
	    radTD3.setSelected(true);
	    JRadioButton radOP3 = new JRadioButton(OPString);
	    radOP3.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radOP3);
	    ButtonGroup groupTDOP = new ButtonGroup();
	    groupTDOP.add(radTD3);
	    groupTDOP.add(radOP3);	    
	    JRadioButton radTD4 = new JRadioButton(TDString);
	    radTD4.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radTD4);
	    radTD4.setSelected(true);
	    JRadioButton radFR3 = new JRadioButton(FRString);
	    radFR3.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radFR3);
	    ButtonGroup groupTDFR = new ButtonGroup();
	    groupTDFR.add(radTD4);
	    groupTDFR.add(radFR3);
	    JRadioButton radTD5 = new JRadioButton(TDString);
	    radTD5.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radTD5);
	    radTD5.setSelected(true);
	    JRadioButton radEF3 = new JRadioButton(EFString);
	    radEF3.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radEF3);
	    ButtonGroup groupTDEF = new ButtonGroup();
	    groupTDEF.add(radTD5);
	    groupTDEF.add(radEF3);
	    JRadioButton radOP4 = new JRadioButton(OPString);
	    radOP4.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radOP4);
	    radOP4.setSelected(true);
	    JRadioButton radFR4 = new JRadioButton(FRString);
	    radFR4.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radFR4);
	    ButtonGroup groupOPFR = new ButtonGroup();
	    groupOPFR.add(radOP4);
	    groupOPFR.add(radFR4);
	    JRadioButton radOP5 = new JRadioButton(OPString);
	    radOP5.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radOP5);
	    radOP5.setSelected(true);
	    JRadioButton radEF4 = new JRadioButton(EFString);
	    radEF4.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radEF4);
	    ButtonGroup groupOPEF = new ButtonGroup();
	    groupOPEF.add(radOP5);
	    groupOPEF.add(radEF4);
	    JRadioButton radFR5 = new JRadioButton(FRString);
	    radFR5.setBounds(150, yPos+=30, 200, 20);
	    addRadBtnToArrys(radFR5);
	    radFR5.setSelected(true);
	    JRadioButton radEF5 = new JRadioButton(EFString);
	    radEF5.setBounds(450, yPos, 200, 20);
	    addRadBtnToArrys(radEF5);
	    ButtonGroup groupFREF = new ButtonGroup();
	    groupFREF.add(radFR5);
	    groupFREF.add(radEF5);
	    
	    main.add(radMD1);
	    main.add(radPD1);
	    main.add(radMD2);
	    main.add(radTD1);
	    main.add(radMD3);
	    main.add(radOP1);
	    main.add(radMD4);
	    main.add(radFR1);
	    main.add(radMD5);    
	    main.add(radEF1);
	    main.add(radPD2);
	    main.add(radTD2);
	    main.add(radPD3);
	    main.add(radOP2);
	    main.add(radPD4);
	    main.add(radFR2);
	    main.add(radPD5);
	    main.add(radEF2);
	    main.add(radTD3);
	    main.add(radOP3);
	    main.add(radTD4);
	    main.add(radFR3);
	    main.add(radTD5);
	    main.add(radEF3);
	    main.add(radOP4);
	    main.add(radFR4);
	    main.add(radOP5);
	    main.add(radEF4);
	    main.add(radFR5);
	    main.add(radEF5);

	    JButton btnSaveTLX = new JButton("Absenden");
		btnSaveTLX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] weightCounts = {0,0,0,0,0,0};
				for(JRadioButton Btn : radBtns){
					if(Btn.isSelected()){
						String name = Btn.getText();
						switch (name) {
							case "Mental Demand":
								weightCounts[0]++;
								break;
							case "Physical Demand":
								weightCounts[1]++;
								break;
							case "Temporal Demand":
								weightCounts[2]++;
								break;
							case "Performance":
								weightCounts[3]++;
								break;
							case "Frustration":
								weightCounts[4]++;
								break;
							case "Effort":
								weightCounts[5]++;
								break;
						}
					}
				}
				ViewController.getInstance().weights.add(weightCounts);
				ViewController.getInstance().showTest(TlxFirstTestView.this);				
			}
		});
		btnSaveTLX.setBounds(500, yPos+=50, 200, 50);
		main.add(btnSaveTLX);
	    	
		main.setPreferredSize(new Dimension( mWindowWidth,yPos+70));
		JScrollPane scrollFrame = new JScrollPane(main, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		main.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(windowWidth,windowHeight));
		scrollFrame.getVerticalScrollBar().setUnitIncrement(5);
		this.add(scrollFrame);		
	}
	
	public void addRadBtnToArrys(JRadioButton radBtn){
		radBtns[radBtnCount] = radBtn;
		radBtnCount++;
		if(radBtnCount == 30)
			radBtnCount = 0;
	}
}

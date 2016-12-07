import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;


public class TlxFirstTestView extends JFrame {

	private int mWindowWidth;
	private int radBtnCount = 0;
	private JRadioButton[] radBtns = new JRadioButton[30];
	private static Color COLOR_DARK_WHITE = Color.decode("#EEEEEE");

	public TlxFirstTestView(int windowWidth, int windowHeight) {
		mWindowWidth = windowWidth;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel main = new JPanel();
		main.setBorder(null);
		main.setBackground(Color.DARK_GRAY);
		main.setLayout(null);
		int yPos = 5;
		
		JLabel tasklabel = new JLabel("Select the member which provided the most significant source of workload variation of each pair!");
		tasklabel.setForeground(COLOR_DARK_WHITE);
		tasklabel.setBounds(10, yPos, windowWidth, 50);
		tasklabel.setFont(new Font("Sans-Serif", Font.BOLD, 13));
		tasklabel.setHorizontalAlignment(SwingConstants.CENTER);
		main.add(tasklabel);
		
		String MDString = "Mental Demand";
		String PDString = "Physical Demand";
		String TDString = "Temporal Demand";
		String OPString = "Performance";
		String EFString = "Effort";
		String FRString = "Frustration";
		
		JRadioButton radMD1 = new JRadioButton(MDString);
		radMD1.setBounds(150, yPos+=50, 250, 35);
		radMD1.setSelected(true);
		addRadBtnToArray(radMD1);
	    JRadioButton radPD1 = new JRadioButton(PDString);
	    radPD1.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radPD1);
	    ButtonGroup groupMDPD = new ButtonGroup();
	    groupMDPD.add(radMD1);
	    groupMDPD.add(radPD1);
	    
	    JRadioButton radMD2 = new JRadioButton(MDString);
		radMD2.setBounds(150, yPos+=35, 250, 35);
		radMD2.setSelected(true);
		addRadBtnToArray(radMD2);
		JRadioButton radTD1 = new JRadioButton(TDString);
	    radTD1.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radTD1);
	    ButtonGroup groupMDTD = new ButtonGroup();
	    groupMDTD.add(radMD2);
	    groupMDTD.add(radTD1);
	    
	    JRadioButton radMD3 = new JRadioButton(MDString);
	    radMD3.setBounds(150, yPos+=35, 250, 35);
	    radMD3.setSelected(true);
	    addRadBtnToArray(radMD3);
	    JRadioButton radOP1 = new JRadioButton(OPString);
	    radOP1.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radOP1);
	    ButtonGroup groupMDOP = new ButtonGroup();
	    groupMDOP.add(radMD3);
	    groupMDOP.add(radOP1);
	    
	    JRadioButton radMD4 = new JRadioButton(MDString);
	    radMD4.setBounds(150, yPos+=35, 250, 35);
	    radMD4.setSelected(true);
	    addRadBtnToArray(radMD4);
	    JRadioButton radFR1 = new JRadioButton(FRString);
	    radFR1.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radFR1);
	    ButtonGroup groupMDFR = new ButtonGroup();
	    groupMDFR.add(radMD4);
	    groupMDFR.add(radFR1);	 
	    
	    JRadioButton radMD5 = new JRadioButton(MDString);
	    radMD5.setBounds(150, yPos+=35, 250, 35);
	    radMD5.setSelected(true);
	    addRadBtnToArray(radMD5);
	    JRadioButton radEF1 = new JRadioButton(EFString);
	    radEF1.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radEF1);
	    ButtonGroup groupMDEF = new ButtonGroup();
	    groupMDEF.add(radMD5);
	    groupMDEF.add(radEF1);
	    
	    JRadioButton radPD2 = new JRadioButton(PDString);
	    radPD2.setBounds(150, yPos+=35, 250, 35);
	    radPD2.setSelected(true);
	    addRadBtnToArray(radPD2);
	    JRadioButton radTD2 = new JRadioButton(TDString);
	    radTD2.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radTD2);
	    ButtonGroup groupPDTD = new ButtonGroup();
	    groupPDTD.add(radPD2);
	    groupPDTD.add(radTD2);
	    
	    JRadioButton radPD3 = new JRadioButton(PDString);
	    radPD3.setBounds(150, yPos+=35, 250, 35);
	    
	    radPD3.setSelected(true);
	    addRadBtnToArray(radPD3);
	    JRadioButton radOP2 = new JRadioButton(OPString);
	    radOP2.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radOP2);
	    ButtonGroup groupPDOP = new ButtonGroup();
	    groupPDOP.add(radPD3);
	    groupPDOP.add(radOP2);
	    
	    JRadioButton radPD4 = new JRadioButton(PDString);
	    radPD4.setBounds(150, yPos+=35, 250, 35);
	    radPD4.setSelected(true);
	    addRadBtnToArray(radPD4);
	    JRadioButton radFR2 = new JRadioButton(FRString);
	    radFR2.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radFR2);
	    ButtonGroup groupPDFR = new ButtonGroup();
	    groupPDFR.add(radPD4);
	    groupPDFR.add(radFR2);
	    
	    JRadioButton radPD5 = new JRadioButton(PDString);
	    radPD5.setBounds(150, yPos+=35, 250, 35);
	    radPD5.setSelected(true);
	    addRadBtnToArray(radPD5);
	    JRadioButton radEF2 = new JRadioButton(EFString);
	    radEF2.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radEF2);
	    ButtonGroup groupPDEF = new ButtonGroup();
	    groupPDEF.add(radPD5);
	    groupPDEF.add(radEF2);
	    
	    JRadioButton radTD3 = new JRadioButton(TDString);
	    radTD3.setBounds(150, yPos+=35, 250, 35);
	    radTD3.setSelected(true);
	    addRadBtnToArray(radTD3);
	    JRadioButton radOP3 = new JRadioButton(OPString);
	    radOP3.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radOP3);
	    ButtonGroup groupTDOP = new ButtonGroup();
	    groupTDOP.add(radTD3);
	    groupTDOP.add(radOP3);
	    
	    JRadioButton radTD4 = new JRadioButton(TDString);
	    radTD4.setBounds(150, yPos+=35, 250, 35);
	    radTD4.setSelected(true);
	    addRadBtnToArray(radTD4);
	    JRadioButton radFR3 = new JRadioButton(FRString);
	    radFR3.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radFR3);
	    ButtonGroup groupTDFR = new ButtonGroup();
	    groupTDFR.add(radTD4);
	    groupTDFR.add(radFR3);
	    
	    JRadioButton radTD5 = new JRadioButton(TDString);
	    radTD5.setBounds(150, yPos+=35, 250, 35);
	    radTD5.setSelected(true);
	    addRadBtnToArray(radTD5);
	    JRadioButton radEF3 = new JRadioButton(EFString);
	    radEF3.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radEF3);
	    ButtonGroup groupTDEF = new ButtonGroup();
	    groupTDEF.add(radTD5);
	    groupTDEF.add(radEF3);
	    
	    JRadioButton radOP4 = new JRadioButton(OPString);
	    radOP4.setBounds(150, yPos+=35, 250, 35);
	    radOP4.setSelected(true);
	    addRadBtnToArray(radOP4);
	    JRadioButton radFR4 = new JRadioButton(FRString);
	    radFR4.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radFR4);
	    ButtonGroup groupOPFR = new ButtonGroup();
	    groupOPFR.add(radOP4);
	    groupOPFR.add(radFR4);
	    
	    JRadioButton radOP5 = new JRadioButton(OPString);
	    radOP5.setBounds(150, yPos+=35, 250, 35);
	    radOP5.setSelected(true);
	    addRadBtnToArray(radOP5);
	    JRadioButton radEF4 = new JRadioButton(EFString);
	    radEF4.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radEF4);
	    ButtonGroup groupOPEF = new ButtonGroup();
	    groupOPEF.add(radOP5);
	    groupOPEF.add(radEF4);
	    
	    JRadioButton radFR5 = new JRadioButton(FRString);
	    radFR5.setBounds(150, yPos+=35, 250, 35);
	    radFR5.setSelected(true);
	    addRadBtnToArray(radFR5);
	    JRadioButton radEF5 = new JRadioButton(EFString);
	    radEF5.setBounds(400, yPos, 250, 35);
	    addRadBtnToArray(radEF5);
	    ButtonGroup groupFREF = new ButtonGroup();
	    groupFREF.add(radFR5);
	    groupFREF.add(radEF5);
	    
	    int tempCount = 1;
	    for (JRadioButton btn : radBtns) {
	    	btn.setFont(new Font("Sans-Serif", Font.BOLD, 15));
	    	btn.setFocusable(false);
	    	//if (tempCount%2 == 0)
	    	//	btn.setHorizontalAlignment(SwingConstants.RIGHT);
	    	if (tempCount < 3){
	    		btn.setBackground(Color.decode("#555555"));
	    	} else {
	    		btn.setBackground(Color.DARK_GRAY);
	    	}
	    	btn.setForeground(COLOR_DARK_WHITE);

		    tempCount++;
		    if (tempCount > 4)
		    	tempCount = 1;
	    }
	    
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

	    JButton btnSaveTLX = CustomButtonFactory.createNewButton("Continue", 400, yPos+=50, 250, 50);
		btnSaveTLX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] weightCounts = {0,0,0,0,0,0};
				for(JRadioButton btn : radBtns){
					String name = btn.getText();
					if(btn.isSelected()){
						if (name.equals("Mental Demand"))
								weightCounts[0]++;
						else if (name.equals("Physical Demand"))
								weightCounts[1]++;
						else if (name.equals("Temporal Demand"))
								weightCounts[2]++;
						else if (name.equals("Performance"))
								weightCounts[3]++;
						else if (name.equals("Frustration"))
								weightCounts[4]++;
						else if (name.equals("Effort"))
								weightCounts[5]++;
						
					}
				}
				int count = 0;
				for(JRadioButton btn : radBtns){
					if (count%2 == 0)
						btn.setSelected(true);
					else
						btn.setSelected(false);
					count++;
				}
				ViewController.getInstance().weights.add(weightCounts);
				ViewController.getInstance().showTest(TlxFirstTestView.this);				
			}
		});
		
		
		main.add(btnSaveTLX);
	    	
		main.setPreferredSize(new Dimension( mWindowWidth,yPos+70));
		JScrollPane scrollFrame = new JScrollPane(main, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		main.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(windowWidth,windowHeight));
		scrollFrame.getVerticalScrollBar().setUnitIncrement(5);
		scrollFrame.setBorder(null);
		this.add(scrollFrame);		
	}
	
	public void addRadBtnToArray(JRadioButton radBtn){
		radBtns[radBtnCount] = radBtn;
		radBtnCount++;
		if(radBtnCount == 30)
			radBtnCount = 0;
	}
}

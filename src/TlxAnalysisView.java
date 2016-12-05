import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class TlxAnalysisView extends JFrame {

	private JPanel contentPane;
	private int mWindowWidth;

	/**
	 * Create the frame.
	 */
	public TlxAnalysisView(int windowWidth, int windowHeight) {
		mWindowWidth = windowWidth;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, windowWidth, windowHeight);
		JPanel main = new JPanel();
		main.setLayout(null);
		int yPos = -180;
		//weights = ViewController.getInstance().getWeights();
		//values = ViewController.getInstance().getValues();
		for(int i = 0; i < ViewController.getInstance().values.size(); i++){
			main.add(addNewAnalysis(i, "Proband "+(i+1), yPos+=230));		
		}
		
		
		main.setPreferredSize(new Dimension( mWindowWidth,yPos+70));
		JScrollPane scrollFrame = new JScrollPane(main, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		main.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(windowWidth,windowHeight));
		scrollFrame.getVerticalScrollBar().setUnitIncrement(5);
		this.add(scrollFrame);
		
		
		
		/*JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(5, 5, 200, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
	}
	
	public JPanel addNewAnalysis(int analysisCount, String labelText, int yPosition){
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(10, yPosition, mWindowWidth-100, 210);
		contentPane.setBorder(BorderFactory.createTitledBorder(labelText));
		int innerY = -15;
		String[] categories = {"Mental Demand", "Physical Demand", "Temporal Demand", "Performance", "Frustration", "Effort"};
		for(int i = 0; i < 6; i++){
			JLabel label = new JLabel(categories[i]);
			label.setBounds(30, innerY+=30, 200, 30);
			contentPane.add(label);
			
			int val = ViewController.getInstance().values.get(analysisCount)[i];
			JLabel value = new JLabel("Value " + String.valueOf(val));
			value.setBounds(200, innerY, 100, 30);
			contentPane.add(value);
			
			int wei = ViewController.getInstance().weights.get(analysisCount)[i];
			JLabel weight = new JLabel("Weight: x" + String.valueOf(wei));
			weight.setBounds(300, innerY, 100, 30);
			contentPane.add(weight);
			
			int prod = val + wei;
			JLabel product = new JLabel("Product: " + String.valueOf(prod));
			product.setBounds(400, innerY, 100, 30);
			contentPane.add(product);
		}
		return contentPane;
	}

}

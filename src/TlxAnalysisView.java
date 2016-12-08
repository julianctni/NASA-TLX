import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
		JPanel main = new JPanel();
		main.setBorder(null);
		main.setBackground(Color.DARK_GRAY);
		main.setLayout(null);

		int yPos = 20;
		for(int i = 0; i < ViewController.getInstance().values.size(); i++){
			main.add(addNewAnalysis(i, "Proband "+(i+1), yPos));	
			yPos+=310;
		}
		

		
		main.setPreferredSize(new Dimension( mWindowWidth,yPos+70));
		JScrollPane scrollFrame = new JScrollPane(main, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		main.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(windowWidth,windowHeight));
		scrollFrame.getVerticalScrollBar().setUnitIncrement(5);
		this.add(scrollFrame);
		
		
		JButton btnBackButton = CustomButtonFactory.createNewButton("Back", 10, yPos, 200, 50);
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewController.getInstance().showMainMenue(TlxAnalysisView.this);
			}
		});
		main.add(btnBackButton);
	}
	
	public JPanel addNewAnalysis(int analysisCount, String labelText, int yPosition){
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBounds(10, yPosition, mWindowWidth-100, 300);
		TitledBorder border = BorderFactory.createTitledBorder(labelText);
		border.setTitleFont(new Font("Sans-Serif", Font.PLAIN, 14));
		border.setTitleColor(Color.decode("#EEEEEE"));
		border.setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")));
		contentPane.setBorder(border);

		int innerY = -15;
		int prodSum = 0;
		int weightsSum = 0;
		String[] categories = {"Mental Demand", "Physical Demand", "Temporal Demand", "Performance", "Frustration", "Effort"};
		for(int i = 0; i < 6; i++){
			JLabel label = new JLabel(categories[i]);
			label.setForeground(Color.decode("#EEEEEE"));
			label.setBounds(30, innerY+=30, 200, 30);
			contentPane.add(label);
			
			int val = ViewController.getInstance().values.get(analysisCount)[i];

			JLabel value = new JLabel("Value: " + String.valueOf(val));
			value.setForeground(Color.decode("#EEEEEE"));

			value.setBounds(200, innerY, 100, 30);
			contentPane.add(value);
			
			int wei = ViewController.getInstance().weights.get(analysisCount)[i];
			JLabel weight = new JLabel("Weight: x" + String.valueOf(wei));
			weight.setForeground(Color.decode("#EEEEEE"));
			weight.setBounds(300, innerY, 100, 30);
			contentPane.add(weight);
			weightsSum += wei;
			
			int prod = val * wei;
			JLabel product = new JLabel("Product: " + String.valueOf(prod));
			product.setForeground(Color.decode("#EEEEEE"));
			product.setBounds(400, innerY, 100, 30);
			contentPane.add(product);
			prodSum += prod;
		}
		
		JLabel sum = new JLabel("Sum: " + prodSum);
		sum.setForeground(Color.decode("#EEEEEE"));
		sum.setBounds(400, innerY+=30, 200, 30);
		contentPane.add(sum);
		
		JLabel weiSum = new JLabel("Weights: "+ weightsSum);
		weiSum.setForeground(Color.decode("#EEEEEE"));
		weiSum.setBounds(400, innerY+=30, 200, 30);
		contentPane.add(weiSum);
		
		JLabel avg = new JLabel("AVG: " + (Math.round((float)prodSum/(float)weightsSum)));
		avg.setForeground(Color.decode("#EEEEEE"));
		avg.setBounds(400, innerY+=30, 200, 30);
		contentPane.add(avg);
		
		return contentPane;
	}

}

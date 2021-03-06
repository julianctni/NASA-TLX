import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class CustomButtonFactory {
	
	
	public static JButton createNewButton(String text, int x, int y, int width, int height){
		JButton button = new JButton(text);
		button.setOpaque(true);
		button.setBackground(Color.DARK_GRAY);
		button.setForeground(Color.decode("#EEEEEE"));
		button.setFont(new Font("Sans-Serif", Font.BOLD, 22));
		button.setFocusable(false);
		button.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		button.setBounds(x, y, width, height);
		return button;
	}

}

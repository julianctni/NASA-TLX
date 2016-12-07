import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.UIManager;

public class TlxMainView {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TlxMainView window = new TlxMainView();
					ViewController controller = ViewController.getInstance();
					UIManager.put("Button.select",Color.BLACK);
					UIManager.put("Slider.thumb", Color.BLACK);
					controller.showMainMenue(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

import java.awt.EventQueue;

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
					controller.showMainMenue(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

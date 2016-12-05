import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class ViewController {

	private JFrame mainMenueFrame;
	private JFrame analysisFrame;
	private JFrame testFrame;
	private JFrame firstTestFrame;
	int windowWidth = 800;
	int windowHeight = 650;
	
	public List<int[]> weights = new ArrayList<int[]>();
	public List<int[]> values = new ArrayList<int[]>();
	
	private static ViewController controller;	
	
	private ViewController(){
		mainMenueFrame = new TlxMainMenue(windowWidth, windowHeight);
		//analysisFrame = new TlxAnalysisView(windowWidth, windowHeight);
		testFrame = new TlxTestView(windowWidth, windowHeight);
		firstTestFrame = new TlxFirstTestView(windowWidth, windowHeight);
	}
	
	public static ViewController getInstance (){
		if (ViewController.controller == null) {
			ViewController.controller = new ViewController();
		}
		return ViewController.controller;
	}
	
	public void showMainMenue (JFrame hideFrame){
		if (hideFrame != null)
			hideFrame.setVisible(false);
		mainMenueFrame.setVisible(true);
	}
	
	public void showAnalysis (JFrame hideFrame){
		if (hideFrame != null)
			hideFrame.setVisible(false);
		analysisFrame = new TlxAnalysisView(windowWidth, windowHeight);
		analysisFrame.setVisible(true);
	}
	
	public void showFirstTest(JFrame hideFrame){
		if (hideFrame != null)
			hideFrame.setVisible(false);
		firstTestFrame.setVisible(true);
	}
	
	public void showTest (JFrame hideFrame){
		if (hideFrame != null)
			hideFrame.setVisible(false);		
		testFrame.setVisible(true);
	}	
}

package loginTemplate;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class Login {

	static Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static Dimension screenSize = toolkit.getScreenSize();
	private JFrame frame;
	private BackgroundPanel bp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					UIManager.setLookAndFeel(new FlatLightLaf());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(0, 0, screenSize.width, screenSize.height);
		background();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void background() {
		bp = new BackgroundPanel("res/background.png");
		frame.getContentPane().add(bp);
	}

}

package loginTemplate;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image backgroundImage;
	private RoundedPanel rp;
	private RoundedField username;
	// private RoundedField password;
	private RoundedPasswordField roundedPasswordField;
	private int radius = 55;

	/**
	 * Create the panel.
	 */
	public BackgroundPanel(String imagePath) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				requestFocus();
			}
		});
		setSize(Login.screenSize.width, Login.screenSize.height);
		setLayout(null);
		this.backgroundImage = new ImageIcon(imagePath).getImage();
		rp = new RoundedPanel(30);
		rp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				requestFocus();
			}
		});
		rp.setSize((getWidth() / 2) + 100, (getHeight() / 2) + 100);
		rp.setLocation((getHeight() / 2) - 100, ABORT + 100);
		add(rp);
		setup();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, Login.screenSize.width, Login.screenSize.height, this);
	}

	private void setup() {
		JLabel lblNewLabel = new JLabel("Member Login");
		lblNewLabel.setBounds(706, 135, 263, 58);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));

		JLabel usernameIcon = new JLabel(new ImageIcon("res/username.png"));
		usernameIcon.setBounds(590, 225, 50, 50);

		RoundedButton roundedButton = new RoundedButton("Login", radius);
		roundedButton.setBounds(644, 368, 335, 50);
		roundedButton.setFocusable(false);
		roundedButton.setFocusTraversalKeysEnabled(false);
		roundedButton.setFocusPainted(false);
		roundedButton.setForeground(new Color(255, 255, 255));
		roundedButton.setBackground(Color.decode("#57b846"));
		roundedButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		roundedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				roundedButton.setBackground(Color.decode("#333333"));
				roundedButton.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				roundedButton.setBackground(Color.decode("#57b846"));
				roundedButton.repaint();
			}

		});

		/*
		 * password = new RoundedField(radius);
		 * password.setBounds(644, 283, 335, 50);
		 * password.addFocusListener(new FocusAdapter() {
		 * 
		 * @Override
		 * public void focusGained(FocusEvent e) {
		 * if (password.getText().equals("Password")) {
		 * password.setText("");
		 * password.setForeground(Color.GRAY);
		 * }
		 * }
		 * 
		 * @Override
		 * public void focusLost(FocusEvent e) {
		 * if (password.getText().isEmpty()) {
		 * password.setText("Password");
		 * password.setForeground(Color.LIGHT_GRAY);
		 * }
		 * }
		 * });
		 * password.setForeground(Color.LIGHT_GRAY);
		 * password.setText("Password");
		 * password.setFont(new Font("Tahoma", Font.PLAIN, 22));
		 */
		username = new RoundedField(radius);
		username.setBounds(644, 224, 335, 50);
		username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (username.getText().equals("Username")) {
					username.setText("");
					username.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (username.getText().isEmpty()) {
					username.setText("Username");
					username.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		username.setForeground(Color.LIGHT_GRAY);
		username.setText("Username");
		username.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JLabel passwordIcon = new JLabel(new ImageIcon("res/password2.png"));
		passwordIcon.setBounds(580, 280, 65, 65);

		rp.setLayout(null);
		rp.add(usernameIcon);
		rp.add(username);
		// rp.add(password);
		rp.add(passwordIcon);
		rp.add(roundedButton);
		rp.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Forgot");
		lblNewLabel_1.setBounds(687, 430, 58, 18);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rp.add(lblNewLabel_1);

		JButton forgotB = new JButton("Username / Password?");
		forgotB.setBounds(724, 429, 229, 20);
		forgotB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				forgotB.setForeground(Color.decode("#57b846"));
				forgotB.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				forgotB.setForeground(Color.decode("#333333"));
				forgotB.repaint();
			}
		});
		forgotB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		forgotB.setHorizontalAlignment(SwingConstants.LEFT);
		forgotB.setForeground(Color.decode("#333333"));
		forgotB.setBorderPainted(false);
		forgotB.setContentAreaFilled(false);
		forgotB.setFocusPainted(false);
		forgotB.setFocusable(false);
		rp.add(forgotB);

		JButton btnCreateYourAccont = new JButton("Create your Account →");
		btnCreateYourAccont.setBounds(687, 578, 229, 25);
		btnCreateYourAccont.setForeground(Color.decode("#333333"));
		btnCreateYourAccont.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCreateYourAccont.setForeground(Color.decode("#57b846"));
				btnCreateYourAccont.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCreateYourAccont.setForeground(Color.decode("#333333"));
				btnCreateYourAccont.repaint();
			}
		});
		btnCreateYourAccont.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreateYourAccont.setForeground(new Color(51, 51, 51));
		btnCreateYourAccont.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreateYourAccont.setFocusable(false);
		btnCreateYourAccont.setFocusPainted(false);
		btnCreateYourAccont.setContentAreaFilled(false);
		btnCreateYourAccont.setBorderPainted(false);
		rp.add(btnCreateYourAccont);

		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("res/img.png"));
		lblNewLabel_2.setBounds(105, 159, 316, 289);
		rp.add(lblNewLabel_2);

		roundedPasswordField = new RoundedPasswordField(radius);
		roundedPasswordField.setBounds(644, 283, 335, 50);
		roundedPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals("Password")) {
					roundedPasswordField.setText("");
					roundedPasswordField.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (getText().isEmpty()) {
					roundedPasswordField.setText("Password");
					roundedPasswordField.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		roundedPasswordField.setForeground(Color.LIGHT_GRAY);
		roundedPasswordField.setText("Password");
		roundedPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rp.add(roundedPasswordField);

		new Thread(() -> {
			try {
				Thread.sleep(90);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				username.setFocusable(true);
				roundedPasswordField.setFocusable(true);
			}

		}).start();

	}

	private String getText() {
		Document doc = roundedPasswordField.getDocument();
		String txt;
		try {
			txt = doc.getText(0, doc.getLength());
		} catch (BadLocationException e) {
			txt = null;
		}
		return txt;
	}

}

package loginTemplate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class RoundedPasswordField extends JPasswordField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radius;

	public RoundedPasswordField(int radius) {
		super();
		this.radius = radius;
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		setFocusable(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Dimension arcs = new Dimension(radius, radius);
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setColor(getBackground());
		graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
		graphics.setColor(getForeground());
		graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
		super.paintComponent(g);
	}

	@Override
	public void setBackground(Color bg) {
		super.setBackground(bg);
	}

}

package 教师考勤管理系统界面;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FindcodePanel extends JPanel {
	private BufferedImage image;
	public Dimension size;
	public boolean maximize;
	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	/**
	 * Create the panel.
	 */
	public FindcodePanel(Dimension size) {
		// TODO Auto-generated constructor stub
		InputStream is=this.getClass().getResourceAsStream("/images/regi_fcode.jpg");
				try {
		            image= ImageIO.read(is);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				this.size = size;
	}
	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,size.width,size.height,null);
	}
}

package 教师考勤管理系统界面;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RegisterPanel extends JPanel {
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
	public RegisterPanel() {
		// TODO Auto-generated constructor stub
	}
	
	public RegisterPanel(Dimension size) {
		// TODO Auto-generated constructor stub
		try {
			InputStream is = this.getClass().getResourceAsStream("/images/selfinfo.jpg");
            image= ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
		this.size = size;
	}

	public void paintComponent(Graphics g) {
//		System.out.print(size.width+" ");
//		System.out.println(size.height);
		g.drawImage(image,0,0,size.width,size.height,null);
	}
}

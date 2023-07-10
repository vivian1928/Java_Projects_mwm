package ��ʦ���ڹ���ϵͳ����;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LoginPanel extends JPanel {
	private BufferedImage image;
	public Dimension size;
	public boolean maximize;
	private ImageIcon icon_1;
	public java.net.URL imgURL = Login.class.getResource("/images/login.jpg");
	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	/**
	 * Create the panel.
	 */
	public LoginPanel(Dimension size) {
		// TODO Auto-generated constructor stub
		InputStream is=this.getClass().getResourceAsStream("/images/login.jpg"); 
		try {
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

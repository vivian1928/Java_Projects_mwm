package ��ʦ���ڹ���ϵͳ����;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.peer.LightweightPeer;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class CheckCode extends JPanel {
	private static Random random = new Random();
	private int width = 175;//��֤����
	private int height =34;//��֤��߶�
	private int font_size = 20;//��֤����ɫ
	private int x = 0;//��֤�����ڴ���X����
	private int y = 0;//��֤�����ڴ���Y����
	private int jam = 5;//����Ԫ�� ����ʹ�� 4~7 ֮�������
	private String code = "";//������֤��
	public static boolean click = true;
	public static String coderecord = "";
	public static int width_1[] = {0,0,0,0,0}, height_1[] = {0,0,0,0,0}, width_2[] = {0,0,0,0,0}, height_2[] = {0,0,0,0,0};
	public static Color colorrecord[] = new Color[4];
	public static Color colorrecord_1[] = new Color[5];
 
	public CheckCode(int x, int y){//��ʼ��������Ϣ
		this.x = x;
		this.y = y;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click = true;
				repaint();
			}
		});
	}
// 
////	Container��update�������룺
//	public void update(Graphics g) {
//		if(isShowing()) {
//			g.clearRect(x, y, width, height);
//			paint(g);
//		}
//	}
		
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getRandomColor(){//��������ɫ
		int R = random.nextInt(255),G = random.nextInt(255),B = random.nextInt(255);
		return new Color(R,G,B);
	}
 
	public String getRandomString(){//�����֤��
		int num = random.nextInt(9);
		code = num+"";
		coderecord += code;
		return code;
	}
 
	public void checkCode(Graphics g){// �滭��֤��
		if(click) {
			drawCode(g);
			drawJam(g);
		}else {
			drawCode_1(g);
			drawJam_1(g);
		}
	}
	
	public void drawCode(Graphics g){//�滭��֤������
		coderecord = "";
		Color gc = g.getColor();
		for(int i=0;i<4;i++){
			g.setColor(colorrecord[i] = getRandomColor());
			g.setFont(new Font("΢���ź�",Font.BOLD,font_size));
			g.drawString(getRandomString(), x+30+(i*30), y+font_size);
		}
		g.setColor(gc);
	}
 
	public void drawJam(Graphics g){//�滭����Ԫ��
		Color gc = g.getColor();
		for(int i=0;i<jam;i++){
			width_1[i] = random.nextInt(width);
			height_1[i] = random.nextInt(height);
			width_2[i] = random.nextInt(width);
			height_2[i] = random.nextInt(height);
			g.setColor(colorrecord_1[i] = getRandomColor());
			g.drawLine(x+width_1[i], y+height_1[i], x+width_2[i], y+height_2[i]);
		}
		g.setColor(gc);
	}
	
	public void drawCode_1(Graphics g){//�滭ǰһ����֤������
		Color gc = g.getColor();
		char tmp;
		String asis = null;
		for(int i=0;i<4;i++){
			tmp = coderecord.charAt(i);
			asis = tmp + "";
			g.setColor(colorrecord[i]);
			g.setFont(new Font("΢���ź�",Font.BOLD,font_size));
			g.drawString(asis, x+30+(i*30), y+font_size);
		}
		g.setColor(gc);
	}
	
	public void drawJam_1(Graphics g){//�滭֮ǰ�ĸ���Ԫ��
		Color gc = g.getColor();
		for(int i=0;i<jam;i++){
			g.setColor(colorrecord_1[i]);
			g.drawLine(x+width_1[i], y+height_1[i], x+width_2[i], y+height_2[i]);
		}
		g.setColor(gc);
	}
 
	public void paint(Graphics g) {
		if(click) {
			g.clearRect(x, y, width, height);
//			System.out.println(x);
//			System.out.println(y);
			Color c = g.getColor();
			checkCode(g);
			g.setColor(c);
			click = false;
		}else {
			Color c = g.getColor();
			checkCode(g);
//			System.out.println(c);
			g.setColor(c);
		}
	}
}

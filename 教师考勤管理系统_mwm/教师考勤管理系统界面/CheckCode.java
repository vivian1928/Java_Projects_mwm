package 教师考勤管理系统界面;

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
	private int width = 175;//验证码宽度
	private int height =34;//验证码高度
	private int font_size = 20;//验证码颜色
	private int x = 0;//验证码所在窗体X坐标
	private int y = 0;//验证码所在窗体Y坐标
	private int jam = 5;//干扰元素 建议使用 4~7 之间的数字
	private String code = "";//保存验证码
	public static boolean click = true;
	public static String coderecord = "";
	public static int width_1[] = {0,0,0,0,0}, height_1[] = {0,0,0,0,0}, width_2[] = {0,0,0,0,0}, height_2[] = {0,0,0,0,0};
	public static Color colorrecord[] = new Color[4];
	public static Color colorrecord_1[] = new Color[5];
 
	public CheckCode(int x, int y){//初始化窗体信息
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
////	Container的update方法代码：
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

	public Color getRandomColor(){//获得随机颜色
		int R = random.nextInt(255),G = random.nextInt(255),B = random.nextInt(255);
		return new Color(R,G,B);
	}
 
	public String getRandomString(){//获得验证码
		int num = random.nextInt(9);
		code = num+"";
		coderecord += code;
		return code;
	}
 
	public void checkCode(Graphics g){// 绘画验证码
		if(click) {
			drawCode(g);
			drawJam(g);
		}else {
			drawCode_1(g);
			drawJam_1(g);
		}
	}
	
	public void drawCode(Graphics g){//绘画验证码内容
		coderecord = "";
		Color gc = g.getColor();
		for(int i=0;i<4;i++){
			g.setColor(colorrecord[i] = getRandomColor());
			g.setFont(new Font("微软雅黑",Font.BOLD,font_size));
			g.drawString(getRandomString(), x+30+(i*30), y+font_size);
		}
		g.setColor(gc);
	}
 
	public void drawJam(Graphics g){//绘画干扰元素
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
	
	public void drawCode_1(Graphics g){//绘画前一个验证码内容
		Color gc = g.getColor();
		char tmp;
		String asis = null;
		for(int i=0;i<4;i++){
			tmp = coderecord.charAt(i);
			asis = tmp + "";
			g.setColor(colorrecord[i]);
			g.setFont(new Font("微软雅黑",Font.BOLD,font_size));
			g.drawString(asis, x+30+(i*30), y+font_size);
		}
		g.setColor(gc);
	}
	
	public void drawJam_1(Graphics g){//绘画之前的干扰元素
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

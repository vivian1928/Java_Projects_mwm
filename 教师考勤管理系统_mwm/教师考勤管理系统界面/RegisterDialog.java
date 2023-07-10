package 教师考勤管理系统界面;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RegisterDialog extends JDialog {
	private ImageIcon icon_1;
	private final JPanel contentPanel = new JPanel();
	public java.net.URL imgURL = Login.class.getResource("/images/register.png");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			String str = "注册成功!";
//			String str1 = "您的编号为19016";
//			RegisterDialog dialog = new RegisterDialog(str, str1);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public RegisterDialog(String consequence, String number) {
		setTitle("注册结果");
		icon_1= new ImageIcon(imgURL);
		setBounds(300, 200, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(15);
			contentPanel.add(panel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setHgap(24);
			contentPanel.add(panel, BorderLayout.WEST);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			{
				JLabel label = new JLabel("");
				label.setText(number);
				label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
				panel.add(label);
			}
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(icon_1);
			label.setText(consequence);
			label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			contentPanel.add(label, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT);
			fl_buttonPane.setVgap(13);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u5B9A");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
				Dimension size = new Dimension(80, 40);
				okButton.setPreferredSize(size);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}

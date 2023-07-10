package 系统后台操作;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

import 教师考勤管理系统界面.TeacherJF;

public class Teacher {
	public String no;
	public String name;
	public String sex;
	public String picture;
	public String birth_year_month;
	public String register_time;
	public String politic;
	public String hometown;
	public String education;
	public String position;
	public String telephone;
	public String mailbox;
	public String qqorwechat;
	public String profession;
	public String address;
	public String code;
	public String identity;
	public String college;
	public String college_profession;
	

	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth_year_month() {
		return birth_year_month;
	}
	public void setBirth_year_month(String birth_year_month) {
		this.birth_year_month = birth_year_month;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getPolitic() {
		return politic;
	}
	public void setPolitic(String politic) {
		this.politic = politic;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getQqorwechat() {
		return qqorwechat;
	}
	public void setQqorwechat(String qqorwechat) {
		this.qqorwechat = qqorwechat;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCollege_profession() {
		return college_profession;
	}
	public void setCollege_profession(String college_profession) {
		this.college_profession = college_profession;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Teacher(String no, String name, String sex, String birth_year_month, String register_time, String hometown,
			String politic, String identity, String picture, String education, String college, String profession,
			String position, String qqorwechat, String telephone, String mailbox, String code,
			String college_profession,String address) {
		super();
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.birth_year_month = birth_year_month;
		this.register_time = register_time;
		this.hometown = hometown;
		this.politic = politic;
		this.identity = identity;
		this.picture = picture;
		this.education = education;
		this.college = college;
		this.profession = profession;
		this.position = position;
		this.qqorwechat = qqorwechat;
		this.telephone = telephone;
		this.mailbox = mailbox;
		this.code = code;
		this.college_profession = college_profession;
		this.address=address;
	}
	public Teacher() {
		super();
		// TODO 自动生成的构造函数存根
	}
	@Override
	public String toString() {
		return "Teacher [no=" + no + ", name=" + name + ", sex=" + sex + ", birth_year_month=" + birth_year_month
				+ ", register_time=" + register_time + ", hometown=" + hometown + ", politic=" + politic + ", identity="
				+ identity + ", picture=" + picture + ", education=" + education + ", college=" + college
				+ ", profession=" + profession + ", position=" + position + ", qqorwechat=" + qqorwechat
				+ ", telephone=" + telephone + ", mailbox=" + mailbox + ", code=" + code + ", college_profession="
				+ college_profession + ", address=" + address +"]";
	}
	public void paint() {
		TeacherJF teacherJF=new TeacherJF();
		teacherJF.setVisible(true);
	}	
}

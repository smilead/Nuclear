package com.chinasoft.bbs.entity;

/**
 * 用户类
 * @author Administrator
 *
 */
public class User {
	//属性
	private int uid;//编号
	private String username;//用户名
	private String password;//密码
	private String userpic;//头像
	private String pixname;//昵称
	private String sex;//性别
	private int age;//年龄
	private String tel;//电话
	private String email;//邮箱
	private int exp;//经验
	private int status;//状态
	private String level;//级别
	private String safeques;//安全问题
	private String safeanswer;//安全回答
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserpic() {
		return userpic;
	}
	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}
	public String getPixname() {
		return pixname;
	}
	public void setPixname(String pixname) {
		this.pixname = pixname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSafeques() {
		return safeques;
	}
	public void setSafeques(String safeques) {
		this.safeques = safeques;
	}
	public String getSafeanswer() {
		return safeanswer;
	}
	public void setSafeanswer(String safeanswer) {
		this.safeanswer = safeanswer;
	}
	
	
	
	
}

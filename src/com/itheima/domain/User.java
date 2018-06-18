package com.itheima.domain;

public class User {
private int id;
private String userName;
private String userPassword;
private int age;
private String hobby;
public User(int id, String userName, String userPassword, int age,String hobby) {
	super();
	this.id = id;
	this.userName = userName;
	this.userPassword = userPassword;
	this.age = age;
	this.hobby=hobby;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + id;
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	result = prime * result
			+ ((userPassword == null) ? 0 : userPassword.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (age != other.age)
		return false;
	if (id != other.id)
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	if (userPassword == null) {
		if (other.userPassword != null)
			return false;
	} else if (!userPassword.equals(other.userPassword))
		return false;
	return true;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
//	this.age = age;
}
@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", userPassword="
			+ userPassword + ", age=" + age + ", hobby=" + hobby + "]";
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
}

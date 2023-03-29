package DTO;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class UserInfoPage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String username;
	long mobile;
	String email;
	String password;
	Date date;
	String gender;
	String address;
	String country;
	String skills[];
	int age;

}

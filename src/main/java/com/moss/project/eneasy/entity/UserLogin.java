package com.moss.project.eneasy.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(schema = "RECOMMEND", name = "USER_LOGIN")
@Entity
@Setter
@Getter
@Where(clause = "recordStatus = 'A'")
public class UserLogin extends BaseEntity {

	public UserLogin() {
	}

	@OneToOne
	private User user;

	@Column(name="LAST_LOGIN_DATE")
	@DateTimeFormat
	private Date lastLoginDate;

}


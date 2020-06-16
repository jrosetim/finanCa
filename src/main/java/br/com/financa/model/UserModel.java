package br.com.financa.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private Long iduser;

	private String nickname;

	private String password;

	private String status;

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}


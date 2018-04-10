package pl.coderslab.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import pl.coderslab.validator.PasswordMatches;

@PasswordMatches
public class PersonalTrainerDTO {

	@NotNull
    @NotEmpty
    private String name;
	@NotNull
	@NotEmpty
	private String password;
	@NotEmpty
	private String matchingPassword;
	@NotEmpty
	private String surname;
	@NotNull
	private Integer phoneNumber;
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@NotNull
	@NotEmpty
	private String email;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

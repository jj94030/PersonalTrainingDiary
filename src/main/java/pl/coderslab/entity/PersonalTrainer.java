package pl.coderslab.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.aerogear.security.otp.api.Base32;
import org.mindrot.jbcrypt.BCrypt;

@Entity
public class PersonalTrainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String surname;
	@NotNull
	private Integer phoneNumber;
	private String description;
	@Email
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String password;

	@ElementCollection // Also relation to new entity Role can be used
	private Collection<String> roles;

	@OneToMany(mappedBy = "personalTrainer", fetch = FetchType.EAGER)
	private List<Client> clients = new ArrayList<>();

	private boolean enabled;
	private String secret;

	public PersonalTrainer() {
		super();
		this.secret = Base32.random();
		this.enabled = true;
	}

	public PersonalTrainer(String name, String surname, int phoneNumber, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		setPassword(password);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	 public void setEmail(String email) {
	 this.email = email;
	 }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public boolean isPasswordCorrect(String password) {
		return BCrypt.checkpw(password, this.password);
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
	
	
	
	public Collection<String> getRoles() {
		return roles;
	}

	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
        return enabled;
    }

	public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }


	// spring security
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PersonalTrainer trainer = (PersonalTrainer) obj;
		if (!email.equals(trainer.email)) {
			return false;
		}
		return true;
	}

//	 @Override
//	    public String toString() {
//	        final StringBuilder builder = new StringBuilder();
//	        builder.append("User [id=").append(id).append(", email=").append(email).append(", password=").append(password).append(", enabled=").append(enabled)
//	               .append(", secret=").append(secret).append(", roles=").append(roles).append("]");
//	        return builder.toString();
//	    }

}

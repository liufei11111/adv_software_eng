package models.data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * User entity bean.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
abstract public class User extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@Constraints.Required
	private Integer id;

	@Constraints.Required
	private String firstName;

	@Constraints.Required
	private String lastName;

	@Constraints.Required
	private String email;

	@Constraints.Required
	private String password;

	@Constraints.Required
	private Integer isEnabled;

	public static Model.Finder<String, User> find = new Model.Finder<String, User>(
			String.class, User.class);

	/**
	 * Retrieve a User from email.
	 */
	public static User findByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}

	/**
	 * Authenticate a User.
	 */
	public static User authenticate(String email, String password) {
		return find.where().eq("email", email).eq("password", password)
				.findUnique();
	}

	@Override
	public String toString() {
		return "User(" + email + ")";
	}

	/**
	 * Return id.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set id.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Return email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Return password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Return is enabled.
	 */
	public Integer getIsEnabled() {
		return isEnabled;
	}

	/**
	 * Set is enabled.
	 */
	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}


	public boolean isAdmin(){
		return (this instanceof Admin);
	}

	public boolean isPlayer(){
		return (this instanceof Player);
	}
}

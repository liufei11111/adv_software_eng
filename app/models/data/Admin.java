package models.data;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import play.db.ebean.Model;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("admin")
public class Admin extends User {
	private static final long serialVersionUID = 1L;
	
	public static Model.Finder<String, Admin> find = new Model.Finder<String, Admin>(
			String.class, Admin.class);

	/**
	 * Retrieve all users.
	 */
	public static List<Admin> findAll() {
		return find.all();
	}
}

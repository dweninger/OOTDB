import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NPC {
/*
 * [Name], [Gender], [Race], [Category], [Occupation], [Description]
 */

	private String name;
	private String gender;
	private String race;
	private String category;
	private String occupation;
	private String description;
	
	public NPC(String name, String gender, String race, String category, String occupation, String description) {
		super();
		this.name = name;
		this.gender = gender;
		this.race = race;
		this.category = category;
		this.occupation = occupation;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "NPC [name=" + name + ", gender=" + gender + ", race=" + race + ", category=" + category
				+ ", occupation=" + occupation + ", description=" + description + "]";
	}
	
}

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Enemy {
	private String name;
	private String threatLevel;
	private String type;
	private String description;
	
	public Enemy(String name, String threatLevel, String type, String description) {
		super();
		this.name = name;
		this.type = type;
		this.description = threatLevel;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThreatLevel() {
		return threatLevel;
	}

	public void setThreatLevel(String threatLevel) {
		this.threatLevel = threatLevel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Enemy [name=" + name + ", threatLevel=" + threatLevel + ", type=" + type + ", description="
				+ description + "]";
	}
	
}

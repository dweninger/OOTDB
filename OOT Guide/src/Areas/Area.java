import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Area {

	private String name;
	private String type;
	private String description;
	
	public Area(String name, String type, String description) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
	}

	public Area(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Area [name=" + name + ", type=" + type + ", description=" + description
				+ "]";
	}
	
}

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Song {
/*
 * [Name], [Description], [Sequence], [AreaId], [NPCId]
 */
	
	private String name;
	private String sequence;
	private String description;
	
	public Song(String name, String sequence, String description) {
		super();
		this.name = name;
		this.sequence = sequence;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Song [name=" + name + ", sequence=" + sequence + ", description=" + description + "]";
	}
	
}

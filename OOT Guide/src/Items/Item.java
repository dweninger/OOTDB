

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Item {

	private String name;
	private String type;
	private String uses;
	private String source;
	private String cost;
	private String description;
	
	public Item(String name, String type, String description) {
		super();
		this.name = name;
		this.type = type;
		this.name = uses;
		this.type = cost;
		this.description = source;
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

	public String getUses() {
		return uses;
	}

	public void setUses(String uses) {
		this.uses = uses;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", type=" + type + ", uses=" + uses + ", source=" + source + ", cost=" + cost
				+ ", description=" + description + "]";
	}
	
}

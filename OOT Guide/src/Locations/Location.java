
public class Location {
	private String name;
	private int locationId;
	
	public Location(String name, int locationId) {
		super();
		this.locationId = locationId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + "]";
	}
	
}

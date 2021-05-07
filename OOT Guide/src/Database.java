import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	/*
	 * Load SQL Driver (JDBC)
	 * 	> Add to build path
	 * 
	 * Set up the database
	 * 
	 * Connect to Database
	 * 
	 * Make modifications to database
	 * 	> Insert, update, delete data
	 * 
	 * Query the Database
	 * 
	 * Disconnect from database
	 */
	
	private String url = "jdbc:sqlite:/home/daniel/Documents/UWL.Spring.2021/DB/sqlitestudio-3.2.1/SQLiteStudio/OcarinaOfTimeDB"; 
	
	private Connection connection;
	
	// singleton pattern
	private static final Database INSTANCE = new Database();
	
	private Database() { }
	
	public static Database getInstance() {
		return INSTANCE;
	}
	
	public void connect() throws SQLException {
		connection = DriverManager.getConnection(url);
	}
	
	public void disconnect() throws SQLException {
		connection.close();
	}
	
	public ResultSet runQuery(String query) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		return results;
	}
	
	public void runVoidQuery(String query) throws SQLException {
		String sql = query;
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
	
	//======================== AREA ========================//
	
	public Object[][] areaLookup(String nameSearch) throws SQLException {
		Object o[][] = new Object[38][3];
		int i = 0;
		String query = "SELECT Name, Type, Description" + 
				"    FROM Area" + 
				"    WHERE Name LIKE \"%"+ nameSearch + "%\"";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		while(results.next()) {
			String name = results.getString("Name");
			String type = results.getString("Type");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = type;
			o[i][2] = desc;
			i++;
		}
		return o;
	}
	
	public Object[][] getAllAreas() throws SQLException{
		Object o[][] = new Object[38][3];
		String query = "SELECT Name, Type, Description FROM Area";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name = results.getString("Name");
			String type = results.getString("Type");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = type;
			o[i][2] = desc;
			i++;
		}
		return o;
	}
	
	public void insertArea(Area a) throws SQLException {
		String sql = "INSERT INTO Area[Name, Type, Description] VALUES(?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, a.getName());
		stmt.setString(2, a.getType());
		stmt.setString(3, a.getDescription());
		stmt.executeUpdate();
	}
	
	//======================== ITEM ========================//
	
	public Object[][] getAllItems() throws SQLException{
		Object o[][] = new Object[98][3];
		String query = "SELECT Name, Uses, Description FROM Item";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name = results.getString("Name");
			String uses = results.getString("Uses");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = uses;
			o[i][2] = desc;
			i++;
		}
		return o;
	}
	
	public Object[][] itemLookup(String nameSearch) throws SQLException {
		Object o[][] = new Object[98][3];
		int i = 0;
		String query = "SELECT Name, Uses, Description" + 
				"    FROM Item" + 
				"    WHERE Name LIKE \"%"+ nameSearch + "%\"";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		while(results.next()) {
			String name = results.getString("Name");
			String uses = results.getString("Uses");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = uses;
			o[i][2] = desc;
			i++;
		}
		return o;
	}
	
	public void insertItem(Item i) throws SQLException {
		String sql = "INSERT INTO Area[Name, Type, Uses, Cost, Source, Description] VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, i.getName());
		stmt.setString(2, i.getType());
		stmt.setString(3, i.getUses());
		stmt.setString(4, i.getCost());
		stmt.setString(5, i.getSource());
		stmt.setString(6, i.getDescription());
		stmt.executeUpdate();
	}
	
	//======================== ENEMY ========================//
	
	public Object[][] getAllEnemies() throws SQLException{
		Object o[][] = new Object[96][4];
		String query = "SELECT Name, ThreatLevel, Type, Description FROM Enemy";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name = results.getString("Name");
			String threatLevel = results.getString("ThreatLevel");
			String type = results.getString("Type");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = threatLevel;
			o[i][2] = type;
			o[i][3] = desc;
			i++;
		}
		return o;
	}
	
	public Object[][] enemyLookup(String nameSearch) throws SQLException {
		Object o[][] = new Object[96][4];
		int i = 0;
		String query = "SELECT Name, ThreatLevel, Type, Description" + 
				"    FROM Enemy" + 
				"    WHERE Name LIKE \"%"+ nameSearch + "%\"";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		while(results.next()) {
			String name = results.getString("Name");
			String threatLevel = results.getString("ThreatLevel");
			String type = results.getString("Type");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = threatLevel;
			o[i][2] = type;
			o[i][3] = desc;
			i++;
		}
		return o;
	}
	
	//======================== NPC ========================//
	
	public Object[][] getAllNPCs() throws SQLException{
		/*
		 * [Name], [Gender], [Race], [Category], [Occupation], [Description]
		 */
		Object o[][] = new Object[86][6];
		String query = "SELECT Name, Gender, Race, Category, Occupation, Description FROM NPC";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name = results.getString("Name");
			String gender = results.getString("Gender");
			String race = results.getString("Race");
			String category = results.getString("Category");
			String occupation = results.getString("Occupation");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = gender;
			o[i][2] = race;
			o[i][3] = category;
			o[i][4] = occupation;
			o[i][5] = desc;
			i++;
		}
		return o;
	}
	
	public Object[][] npcLookup(String nameSearch) throws SQLException {
		Object o[][] = new Object[86][6];
		int i = 0;
		String query = "SELECT Name, Gender, Race, Category, Occupation, Description" + 
				"    FROM NPC" + 
				"    WHERE Name LIKE \"%"+ nameSearch + "%\"";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		while(results.next()) {
			String name = results.getString("Name");
			String gender = results.getString("Gender");
			String race = results.getString("Race");
			String category = results.getString("Category");
			String occupation = results.getString("Occupation");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = gender;
			o[i][2] = race;
			o[i][3] = category;
			o[i][4] = occupation;
			o[i][5] = desc;
			i++;
		}
		return o;
	}
	
	//======================== SONG ========================//
	
	public Object[][] getAllSongs() throws SQLException{
		Object o[][] = new Object[13][3];
		String query = "SELECT Name, Sequence, Description FROM Song";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name = results.getString("Name");
			String sequence = results.getString("Sequence");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = sequence;
			o[i][2] = desc;
			i++;
		}
		return o;
	}
	
	public Object[][] songLookup(String nameSearch) throws SQLException {
		Object o[][] = new Object[13][3];
		int i = 0;
		String query = "SELECT Name, Sequence, Description" + 
				"    FROM Song" + 
				"    WHERE Name LIKE \"%"+ nameSearch + "%\"";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		while(results.next()) {
			String name = results.getString("Name");
			String sequence = results.getString("Sequence");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = sequence;
			o[i][2] = desc;
			i++;
		}
		return o;
	}
	
	//======================== LOCATION ========================//
	
	public Object[][] getAllLocations() throws SQLException{
		Object o[][] = new Object[5][2];
		String query = "SELECT LocationId, Name FROM Location";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String locationId = results.getString("LocationId");
			String name = results.getString("Name");
			
			o[i][0] = locationId;
			o[i][1] = name;
			i++;
		}
		return o;
	}
	
	public Object[][] locationLookup(String nameSearch) throws SQLException {
		Object o[][] = new Object[5][2];
		int i = 0;
		String query = "SELECT LocationId, Name" + 
				"    FROM Location" + 
				"    WHERE Name LIKE \"%"+ nameSearch + "%\"";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		while(results.next()) {
			String locationId = results.getString("LocationId");
			String name = results.getString("Name");
			
			o[i][0] = locationId;
			o[i][1] = name;
			i++;
		}
		return o;
	}
	
	public Object[][] getNPCsPerLocation() throws SQLException{
		Object o[][] = new Object[100][2];
		String query = "SELECT DISTINCT Location.Name AS Loc, NPC.Name AS N\n" + 
				"FROM Location JOIN Area JOIN NPCArea JOIN NPC\n" + 
				"ON Location.LocationId = Area.LocationId AND Area.AreaId = NPCArea.AreaId AND NPCArea.NPCId = NPC.NPCId\n" + 
				"WHERE Location.Name LIKE '%%'\n" + 
				"ORDER BY Location.LocationId ";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String location = results.getString("Loc");
			String npc = results.getString("N");
			
			o[i][0] = location;
			o[i][1] = npc;
			i++;
		}
		return o;
	}
	
	public Object[][] searchNPCsPerLocation(String nameSearch) throws SQLException {
		Object o[][] = new Object[10][2];
		int i = 0;
		String query = "SELECT Location.Name AS Loc, NPC.Name AS N\n" + 
				"FROM Location JOIN Area JOIN NPCArea JOIN NPC\n" + 
				"ON Location.LocationId = Area.LocationId AND Area.AreaId = NPCArea.AreaId AND NPCArea.NPCId = NPC.NPCId\n" + 
				"WHERE NPC.Name LIKE '%" + nameSearch + "%'\n" + 
				"ORDER BY Location.LocationId ";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		while(results.next()) {
			String location = results.getString("Loc");
			String npc = results.getString("N");
			
			o[i][0] = location;
			o[i][1] = npc;
			i++;
		}
		return o;
	}
	
	//======================== AREA ENEMIES ========================//
	
	public Object[][] getEnemiesPerArea() throws SQLException{
		Object o[][] = new Object[28][2];
		String query = "SELECT Area.Name, count(Enemy.EnemyId) AS EnemyCount\n" + 
				"FROM Area JOIN EnemyArea JOIN Enemy\n" + 
				"ON Area.AreaId = EnemyArea.AreaId AND EnemyArea.EnemyId = Enemy.EnemyId\n" + 
				"GROUP BY Area.AreaId\n" + 
				"ORDER BY EnemyCount DESC";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String area = results.getString("Name");
			String enemies = results.getString("EnemyCount");
			
			o[i][0] = area;
			o[i][1] = enemies;
			i++;
		}
		return o;
	}
	
	public Object[][] searchEnemiesPerArea(String areaSearch) throws SQLException{
		Object o[][] = new Object[28][2];
		String query = "SELECT Area.Name, count(Enemy.EnemyId) AS EnemyCount\n" + 
				"FROM Area JOIN EnemyArea JOIN Enemy\n" + 
				"ON Area.AreaId = EnemyArea.AreaId AND EnemyArea.EnemyId = Enemy.EnemyId\n" + 
				"GROUP BY Area.AreaId\n" + 
				"HAVING Area.Name LIKE '%" + areaSearch + "%'\n" + 
				"ORDER BY EnemyCount DESC";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		int i = 0;
		while(results.next()) {
			String area = results.getString("Name");
			String enemies = results.getString("EnemyCount");
			
			o[i][0] = area;
			o[i][1] = enemies;
			i++;
		}
		return o;
	}
	
	//======================== AREA THREAT LEVEL ========================//
	
	public Object[][] getThreatPerArea() throws SQLException{
		Object o[][] = new Object[27][2];
		String query = "SELECT EnemyThreat.AreaName, avg(EnemyThreat.ThreatLevel) avgThreat\n" + 
				"FROM (SELECT Area.AreaId AS AreaId, Area.Name AS AreaName, Enemy.ThreatLevel AS ThreatLevel\n" + 
				"FROM Enemy JOIN EnemyArea JOIN Area\n" + 
				"ON Enemy.EnemyId = EnemyArea.EnemyId AND EnemyArea.AreaId = Area.AreaId\n" + 
				"WHERE Enemy.ThreatLevel > 0) AS EnemyThreat\n" + 
				"GROUP BY EnemyThreat.AreaName\n" + 
				"ORDER BY avgThreat DESC";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String area = results.getString("AreaName");
			String threat = results.getString("avgThreat");
			
			o[i][0] = area;
			o[i][1] = threat;
			i++;
		}
		return o;
	}
	
	public Object[][] searchThreatPerArea(String areaName) throws SQLException{
		Object o[][] = new Object[27][2];
		String query = "SELECT EnemyThreat.AreaName, avg(EnemyThreat.ThreatLevel) avgThreat\n" + 
				"FROM (SELECT Area.AreaId AS AreaId, Area.Name AS AreaName, Enemy.ThreatLevel AS ThreatLevel\n" + 
				"FROM Enemy JOIN EnemyArea JOIN Area\n" + 
				"ON Enemy.EnemyId = EnemyArea.EnemyId AND EnemyArea.AreaId = Area.AreaId\n" + 
				"WHERE Enemy.ThreatLevel > 1) AS EnemyThreat\n" + 
				"GROUP BY EnemyThreat.AreaName\n" + 
				"HAVING AreaName LIKE '%"+ areaName + "%'\n" + 
				"ORDER BY avgThreat DESC";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String area = results.getString("AreaName");
			String threat = results.getString("avgThreat");
			
			o[i][0] = area;
			o[i][1] = threat;
			i++;
		}
		return o;
	}

	//======================== MY ========================//
	
	public Object[][] getAllMyGear() throws SQLException{
		Object o[][] = new Object[50][4];
		String query = "SELECT Item.Name, Amount, Notes, Item.Description\n" + 
				"FROM MyGear JOIN Item\n" + 
				"ON MyGear.ItemId = Item.ItemId\n" + 
				"WHERE Item.Name LIKE '%%'\n" + 
				"LIMIT 50";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name = results.getString("Name");
			String amount = results.getString("Amount");
			String notes = results.getString("Notes");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = amount;
			o[i][2] = notes;
			o[i][3] = desc;
			i++;
		}
		return o;
	}
	
	public Object[][] myGearLookup(String nameSearch) throws SQLException {
		Object o[][] = new Object[50][4];
		String query = "SELECT Item.Name, Amount, Notes, Item.Description\n" + 
				"FROM MyGear JOIN Item\n" + 
				"ON MyGear.ItemId = Item.ItemId\n" + 
				"WHERE Item.Name LIKE '%" + nameSearch + "%'\n" + 
				"LIMIT 50";
		
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name = results.getString("Name");
			String amount = results.getString("Amount");
			String notes = results.getString("Notes");
			String desc = results.getString("Description");
			
			o[i][0] = name;
			o[i][1] = amount;
			o[i][2] = notes;
			o[i][3] = desc;
			i++;
		}
		return o;
	}
	
	public Object[][] insertMyGear(String name, String notes) throws SQLException {
		String sql = "INSERT INTO [MyGear] ([ItemId], [Notes], [Amount]) VALUES ((SELECT ItemId FROM Item WHERE Name = '" + name + "'), '" + notes + "', 1);";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.executeUpdate();
		
		Object o[][] = new Object[50][4];
		String query = "SELECT Item.Name, Amount, Notes, Item.Description\n" + 
				"FROM MyGear JOIN Item\n" + 
				"ON MyGear.ItemId = Item.ItemId\n" + 
				"WHERE Item.Name LIKE '%%'\n" + 
				"LIMIT 50";
		
		PreparedStatement stmt2 = connection.prepareStatement(query);
		ResultSet results = stmt2.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name2 = results.getString("Name");
			String amount = results.getString("Amount");
			String notes2 = results.getString("Notes");
			String desc = results.getString("Description");
			
			o[i][0] = name2;
			o[i][1] = amount;
			o[i][2] = notes2;
			o[i][3] = desc;
			i++;
		}
		return o;
	}
	
	public Object[][] updateMyGear(String name, String amount, String notes) throws SQLException {
		String sql = null;
		if(amount.isEmpty()) {
			sql = "UPDATE MyGear  \n" + 
					"SET Notes = '" + notes + "' \n" + 
					"WHERE (SELECT ItemId FROM Item WHERE Name = '" + name + "') = MyGear.ItemId";
		} else if(notes.isEmpty()) {
			sql = "UPDATE MyGear  \n" + 
					"SET Amount = '" + amount + "' \n" + 
					"WHERE (SELECT ItemId FROM Item WHERE Name = '" + name + "') = MyGear.ItemId";
		} else {
			sql = "UPDATE MyGear  \n" + 
					"SET Amount = '" + amount + "', Notes = '" + notes + "' \n" + 
					"WHERE (SELECT ItemId FROM Item WHERE Name = '" + name + "') = MyGear.ItemId";
		}
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.executeUpdate();
		
		Object o[][] = new Object[50][4];
		String query = "SELECT Item.Name, Amount, Notes, Item.Description\n" + 
				"FROM MyGear JOIN Item\n" + 
				"ON MyGear.ItemId = Item.ItemId\n" + 
				"WHERE Item.Name LIKE '%%'\n" + 
				"LIMIT 50";
		
		PreparedStatement stmt2 = connection.prepareStatement(query);
		ResultSet results = stmt2.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name2 = results.getString("Name");
			String amount2 = results.getString("Amount");
			String notes2 = results.getString("Notes");
			String desc = results.getString("Description");
			
			o[i][0] = name2;
			o[i][1] = amount2;
			o[i][2] = notes2;
			o[i][3] = desc;
			i++;
		}
		return o;
	}
	
	public Object[][] deleteMyGear(String name) throws SQLException {
		String sql = "DELETE FROM MyGear  WHERE (SELECT ItemId FROM Item WHERE Name = '" + name + "') = MyGear.ItemId";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.executeUpdate();
		
		Object o[][] = new Object[50][4];
		String query = "SELECT Item.Name, Amount, Notes, Item.Description\n" + 
				"FROM MyGear JOIN Item\n" + 
				"ON MyGear.ItemId = Item.ItemId\n" + 
				"WHERE Item.Name LIKE '%%'\n" + 
				"LIMIT 50";
		
		PreparedStatement stmt2 = connection.prepareStatement(query);
		ResultSet results = stmt2.executeQuery();
		
		int i = 0;
		while(results.next()) {
			String name2 = results.getString("Name");
			String amount = results.getString("Amount");
			String notes2 = results.getString("Notes");
			String desc = results.getString("Description");
			
			o[i][0] = name2;
			o[i][1] = amount;
			o[i][2] = notes2;
			o[i][3] = desc;
			i++;
		}
		return o;
	}
	
	//INSERT INTO [MyGear] ([ItemId], [Notes]) VALUES ((SELECT ItemId FROM Item WHERE Name = 'Deku Stick'), 'Notes Test');
	
}






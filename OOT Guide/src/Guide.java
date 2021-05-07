import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Guide {

	public static void main(String[] args) throws SQLException {
		
		Database db = Database.getInstance();
		
		try {
			db.connect();
		} catch (SQLException e) {
			System.out.println("Database connection failed...");
			e.printStackTrace();
		}
		
		System.out.println("Connected!\n");
		buildGui();
//		try {
//			ArrayList<Area> areas = new ArrayList<>();
//			
////			Area a = new Area("THIS", "THAT", "THE OTHER");
////			db.insertArea(a);
//			//ResultSet results = db.runQuery("SELECT Name, Type, Description FROM Area");
//			//Area a = db.areaLookup("Temple of Time");
//			//System.out.println(a);
//			
//		} catch (SQLException e1) {
//			System.out.println("Something went wrong!");
//			e1.printStackTrace();
//		}
		
		try {
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Database closure failed...");
			e.printStackTrace();
		}
		
		System.out.println("\nDisconnected!\n");

	}
	
	private static void buildGui() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame;
				try {
					frame = new Mainframe("Ocarina of Time Database");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    frame.setSize(1300, 1100);
				    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				    frame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			}
		}); 
	}

}



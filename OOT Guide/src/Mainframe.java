import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Mainframe extends JFrame {
	
	private LocationPanels locationPanel;
	private AreaPanel areaPanel;
	private ItemPanels itemPanel;
	private EnemyInfoPanel enemyPanel;
	private SongInfoPanel songPanel;
	private NPCInfoPanel npcPanel;
	private MyPanel myPanel;
	
	public Mainframe(String title) throws SQLException {
		super(title);
		
		// Set layout manager
		setLayout(new BorderLayout());
		
		// Create Swing component
		JTextArea textArea = new JTextArea();
		JButton button = new JButton("Click me!");
		
		//TABS//
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon mapIcon = createImageIcon("/images/map.png",
                "a pretty but meaningless splat");
		ImageIcon compassIcon = createImageIcon("/images/compass.png",
                "a pretty but meaningless splat");
		ImageIcon swordIcon = createImageIcon("/images/sword.png",
                "a pretty but meaningless splat");
		ImageIcon npcIcon = createImageIcon("/images/npc.png",
                "a pretty but meaningless splat");
		ImageIcon ocarinaIcon = createImageIcon("/images/ocarina.png",
                "a pretty but meaningless splat");
		ImageIcon enemyIcon = createImageIcon("/images/octoroc.png",
                "a pretty but meaningless splat");
		ImageIcon myIcon = createImageIcon("/images/bottle.png",
                "a pretty but meaningless splat");
		
		//AREA PANEL//
		locationPanel = new LocationPanels();
		areaPanel = new AreaPanel();
		itemPanel = new ItemPanels();
		npcPanel = new NPCInfoPanel();
		songPanel = new SongInfoPanel();
		enemyPanel = new EnemyInfoPanel();
		myPanel = new MyPanel();
		
		tabbedPane.addTab("Locations", mapIcon, locationPanel, "Locations");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.addTab("Areas", compassIcon, areaPanel, "Areas");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabbedPane.addTab("Items", swordIcon, itemPanel, "Items");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		tabbedPane.addTab("NPCs", npcIcon, npcPanel, "NPCs");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		tabbedPane.addTab("Songs", ocarinaIcon, songPanel, "Songs");
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
		tabbedPane.addTab("Enemies", enemyIcon, enemyPanel, "Enemies");
		tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);
		tabbedPane.addTab("My", myIcon, myPanel, "My");
		tabbedPane.setMnemonicAt(6, KeyEvent.VK_7);
		
		// Add Swing component to content pane
		Container c = getContentPane();
		//c.add(textArea, BorderLayout.CENTER);
		//c.add(button, BorderLayout.SOUTH);
		//c.add(areaPanel, BorderLayout.WEST);
		c.add(tabbedPane, BorderLayout.CENTER);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("Hello\n");
			}
			
		});
		
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
}

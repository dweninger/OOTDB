import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class ItemPanels extends JPanel {
	private ItemInfoPanel itemPanel;
	private ItemAreaInfoPanel itemAreaPanel;
	
	public ItemPanels() throws SQLException {
		// Set layout manager
		setLayout(new GridBagLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("images/middle.gif",
                "a pretty but meaningless splat");
		
		itemPanel = new ItemInfoPanel();
		itemAreaPanel = new ItemAreaInfoPanel();
		
		tabbedPane.addTab("Item List", icon, itemPanel, "Does something");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.addTab("Item Areas", icon, itemAreaPanel, "Does something");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.gridheight = 2;
		gc.fill = GridBagConstraints.BOTH;
		add(tabbedPane, gc);
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

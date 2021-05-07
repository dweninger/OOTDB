import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AreaEnemiesPanel extends JPanel {
	Database db = Database.getInstance();
	JTextField searchBox = new JTextField(30);
	JButton searchButton = new JButton("Search!");
	String[] columnNames = {"Area", "Enemies"};
	JTable table;
	
	public AreaEnemiesPanel() throws SQLException {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		try {
			db.connect();
		} catch (SQLException e) {
			System.out.println("Database connection failed...");
			e.printStackTrace();
		}
	
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Enemies In Area"));
		table = new JTable(db.getEnemiesPerArea(), columnNames);
		TableModel model = new DefaultTableModel(db.getEnemiesPerArea(), columnNames);
		
		table.setPreferredScrollableViewportSize(new Dimension(450,63));
	    table.setFillsViewportHeight(true);
	
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	
	    
	    searchButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = searchBox.getText();
		        if (text.length() == 0) {
		          //sorter.setRowFilter(null);
		        	table.setModel(model);
		        } else {
		          //sorter.setRowFilter(RowFilter.regexFilter(text));
		        	try {
						TableModel searchModel = new DefaultTableModel(db.searchEnemiesPerArea(text), columnNames);
						table.setModel(searchModel);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
			
		});
		
		// FIRST COLUMN //
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(searchBox, gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		
		add(searchButton, gc);
		
		// Second Column //
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 15;
		gc.gridheight = 7;
		gc.fill = GridBagConstraints.BOTH;
		
		add(scrollPane, gc);
	}
	
	public void actionPerformed(ActionEvent e) {
	    if ("disable".equals(e.getActionCommand())) {
	        searchButton.setEnabled(true);
	        
	    } else {
	        searchButton.setEnabled(false);
	    }
	}
}

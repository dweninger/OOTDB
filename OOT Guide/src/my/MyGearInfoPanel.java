import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MyGearInfoPanel extends JPanel {
	Database db = Database.getInstance();
	JTextField searchBox = new JTextField(30);
	JButton searchButton = new JButton("Search!");
	JLabel addLabel = new JLabel("Add Item:");
	JTextField addBox = new JTextField(30);
	JLabel addNotesLabel = new JLabel("Add Notes:");
	JTextField addNotesBox = new JTextField(50);
	JButton addButton = new JButton("Add!");
	JLabel updateLabel = new JLabel("Update Item:");
	JTextField updateBox = new JTextField(30);
	JLabel updateAmountLabel = new JLabel("Update Amount:");
	JTextField updateAmountBox = new JTextField(30);
	JLabel updateNotesLabel = new JLabel("Update Notes:");
	JTextField updateNotesBox = new JTextField(50);
	JButton updateButton = new JButton("Update!");
	JLabel deleteLabel = new JLabel("Delete Item:");
	JTextField deleteBox = new JTextField(30);
	JButton deleteButton = new JButton("Delete!");
	String[] columnNames = {"Item", "Amount", "Description", "Notes"};
	JTable table;
	public MyGearInfoPanel() throws SQLException {
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
		
		setBorder(BorderFactory.createTitledBorder("My Gear"));
		
		table = new JTable(db.getAllMyGear(), columnNames);
		TableModel model = new DefaultTableModel(db.getAllMyGear(), columnNames);
		
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
						TableModel searchModel = new DefaultTableModel(db.myGearLookup(text), columnNames);
						table.setModel(searchModel);
						searchBox.setText("");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
			
		});
        
        addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String itemText = addBox.getText();
				String notesText = addNotesBox.getText();
		        if (itemText.length() == 0) {
		          //sorter.setRowFilter(null);
		        	table.setModel(model);
		        } else {
		          //sorter.setRowFilter(RowFilter.regexFilter(text));
		        	try {
						TableModel addModel = new DefaultTableModel(db.insertMyGear(itemText, notesText), columnNames);
						table.setModel(addModel);
						addBox.setText("");
						addNotesBox.setText("");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
			
		});
        
        updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String itemText = updateBox.getText();
				String amountText = updateAmountBox.getText();
				String notesText = updateNotesBox.getText();
		        if (itemText.length() == 0) {
		          //sorter.setRowFilter(null);
		        	table.setModel(model);
		        } else {
		          //sorter.setRowFilter(RowFilter.regexFilter(text));
		        	try {
						TableModel updateModel = new DefaultTableModel(db.updateMyGear(itemText, amountText, notesText), columnNames);
						table.setModel(updateModel);
						updateBox.setText("");
						updateAmountBox.setText("");
						updateNotesBox.setText("");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
			
		});
        
        deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String itemText = deleteBox.getText();
		        if (itemText.length() == 0) {
		          //sorter.setRowFilter(null);
		        	table.setModel(model);
		        } else {
		          //sorter.setRowFilter(RowFilter.regexFilter(text));
		        	try {
						TableModel deleteModel = new DefaultTableModel(db.deleteMyGear(itemText), columnNames);
						table.setModel(deleteModel);
						deleteBox.setText("");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
			
		});
		
		// First Column //
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(searchBox, gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.NONE;
		add(searchButton, gc);
		
		
		// Second Column //
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		add(addLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(addBox, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		add(addNotesLabel, gc);
		
		gc.gridx = 3;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(addNotesBox, gc);
		
		gc.gridx = 4;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.NONE;
		add(addButton, gc);
		
		// Third Column //
		gc.gridx = 0;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.NONE;
		add(updateLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(updateBox, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.NONE;
		add(updateAmountLabel, gc);
		
		gc.gridx = 3;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(updateAmountBox, gc);
		
		gc.gridx = 4;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.NONE;
		add(updateNotesLabel, gc);
		
		gc.gridx = 5;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(updateNotesBox, gc);
		
		gc.gridx = 7;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.NONE;
		add(updateButton, gc);
		
		// Fourth Column //
		gc.gridx = 0;
		gc.gridy = 3;
		gc.fill = GridBagConstraints.NONE;
		add(deleteLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(deleteBox, gc);
		
		gc.gridx = 2;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.NONE;
		add(deleteButton, gc);
		
		// Fifth Column //
		gc.gridx = 0;
		gc.gridy = 4;
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

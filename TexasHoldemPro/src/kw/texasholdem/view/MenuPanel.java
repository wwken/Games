package kw.texasholdem.view;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class controls all user actions from ButtonPanel.
 *
 * @author Ken Wu @ New York
 */

public class MenuPanel extends MenuBar {
	private static final long serialVersionUID = 1L;
	MenuItem m_newItem = new MenuItem("New");
	MenuItem m_saveItem = new MenuItem("Save");
    MenuItem m_checkItem = new MenuItem("Check");
    MenuItem m_undoItem = new MenuItem("Undo");
    MenuItem m_exitItem = new MenuItem("Exit");
    MenuItem m_helpitem = new MenuItem("About");
	private TexasHoldemMainPanel m_parent;
    
    /*
    RadioButtonMenuItem m_rbLevelItem_1;
    JRadioButtonMenuItem m_rbLevelItem_2;
    JRadioButtonMenuItem m_rbLevelItem_3;
    JRadioButtonMenuItem m_rbLevelItem_4;
    JRadioButtonMenuItem m_rbLevelItem_5;
    JRadioButtonMenuItem m_rbLevelItem_6;
    */
    
	public MenuPanel(TexasHoldemMainPanel chineseChess) {
		m_parent = chineseChess;
		init();
	}
	
	void init() {
		
        
        Menu gamemenu = new Menu("File");
        
        gamemenu.add(m_newItem);
        
        gamemenu.add(m_saveItem);
        //gamemenu.add(new JSeparator());
        gamemenu.add(m_exitItem);
        this.add(gamemenu);
        
        /*
        Menu actionmenu = new Menu("Action");
        actionmenu.add(m_checkItem);
        actionmenu.add(m_undoItem);
        this.add(actionmenu);
        */
        
        Menu helpmenu = new Menu("Help");
        //helpmenu.add(new JSeparator());
        helpmenu.add(m_helpitem);
        this.add(helpmenu);
        
        MenuActionListenerImpl mal = new MenuActionListenerImpl();
        m_exitItem.addActionListener(mal);
        m_newItem.addActionListener(mal);
        m_saveItem.addActionListener(mal);
        m_helpitem.addActionListener(mal);
        
	}
	
	public void setSaveButtonEnableOrDisable(boolean t) {
		this.m_saveItem.setEnabled(t);
	}
	
	class MenuActionListenerImpl implements ActionListener {

		

		private AboutDialog m_aboutDialog;

		/**
		 * 
		 */
		public MenuActionListenerImpl() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent evt) {
		    Object cmp = evt.getSource();
		    // System.out.println("Source " + cmp);
		    if (cmp == m_exitItem)
		      System.exit(0);
		    else if (cmp == m_newItem) {
		    	//m_parent.reInit();
		    } else if (cmp == m_saveItem) {
		    	m_parent.issueSaveRequest();
		    } else if (cmp == m_helpitem) {
		    	
		    	if(m_aboutDialog == null) {
		    		m_aboutDialog = new AboutDialog(m_parent);
		    	}
		    	m_aboutDialog.show();
		    }
		}

	}
    
	
}

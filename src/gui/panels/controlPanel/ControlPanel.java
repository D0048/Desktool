package gui.panels.controlPanel;


import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ControlPanel extends JPanel{
	private static final long serialVersionUID = -2823491917549154922L;
	
	//public JPanel jPanel_ctl = new JPanel();
	public JPanel jPanel_ctl = this;
    public JLabel jlabel_ctlTitle = new JLabel("My computers:                                                                                              ");
    public Box vctlBox1 = Box.createVerticalBox(),
    		hctlBox1 = Box.createHorizontalBox(),
    		hctlBox2 = Box.createHorizontalBox();
    //public Vector<PC>vecPCs = new Vector<PC>();
    public Vector<String> vecFunctions = new Vector<String>();
    public String []functions = {
    	"Info","ScreenShoot","Functions","files"
    };
    public JPanel jPanel_content = new JPanel();
}

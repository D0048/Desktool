package gui;

import gui.panels.controlPanel.ControlPanel;
import gui.panels.logPanel.LogPanel;

import java.awt.GridLayout;
import javax.swing.JFrame;  
import javax.swing.WindowConstants;
  
public class Gui extends JFrame{
	private static final long serialVersionUID = 1L;
    static JFrame jFrame_mainWindow = new JFrame();
    static GridLayout mainLayout = new GridLayout(3,2);//layout类型
	static LogPanel logPanel = new LogPanel();
	static ControlPanel controlPanel = new ControlPanel();


	public static void startGui(String[] args) {
    	StatusFlag.setIsPending();
		//frame 初始化
        jFrame_mainWindow.setVisible(true);  
        jFrame_mainWindow.setSize(1000,800);  
        jFrame_mainWindow.setTitle("Server控制台");
        jFrame_mainWindow.setLayout(mainLayout);
        jFrame_mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame_mainWindow.setLocationRelativeTo(null);
        //jFrame_mainWindow.add(jPanel_log);
        
        jFrame_mainWindow.add(logPanel);
        jFrame_mainWindow.add(controlPanel);
        
        log("Gui载入成功！");
        StatusFlag.setOk(true);
        //StatusFlag.setPending(false);
        /*
        try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        //displayException(new Exception("test"));
    }
	public static void log(String msg){
		logPanel.log(msg);
	}
	
	public static void displayException(Exception e){
		StatusFlag.setIsError();
		String errInfo = "Error message: " + e.getMessage();
		for(StackTraceElement ste : e.getStackTrace()){
			errInfo = errInfo + "\n" + ste.toString();
		}
		log("[error]"+errInfo);
		//StatusFlag.setError(false);
	}

	/*舍不得扔的垃圾代码区
	static void createControlPanel(){
		//列表初始化
		//标题位
		jlabel_ctlTitle.setFont((new Font("宋体",Font.BOLD, 16)));
		jlabel_ctlTitle.setSize(20, 20);
		hctlBox1.add(jlabel_ctlTitle);
		hctlBox1.add(Box.createGlue());
		vctlBox1.add(hctlBox1);
		jPanel_ctl.add(vctlBox1);

		//列表位
		vecPCs.add(new PC("                "));
		//vecFunctions.add("                ");
		for(String f : functions){
			vecFunctions.add(f);
		}
		//int i=99; while(i-- > 0){vecFunctions.add("edf");}
		jScrollpane_pclist.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		jScrollpane_pclist.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		jScrollpane_pclist.setWheelScrollingEnabled(true);
		jScrollpane_funclist.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		jScrollpane_funclist.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		jScrollpane_funclist.setWheelScrollingEnabled(true);
		
		jlistPCs.setBorder(BorderFactory.createTitledBorder("Computers"));
		jlistPCs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hctlBox2.add(jScrollpane_pclist);
		
		jlistFunctions.setBorder(BorderFactory.createTitledBorder("Operations"));
		jlistFunctions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hctlBox2.add(jScrollpane_funclist);
		
		//hctlBox2.add(Box.createGlue());
		hctlBox2.add(jPanel_content);
		vctlBox1.add(hctlBox2);
		//内容位
		//jPanel_content.add(new JLabel("Nothing to show here"));
		jPanel_content.add(new IdlePanel());
		
		jFrame_mainWindow.add(jPanel_ctl);
	}
	
	public static String addPC(PC pc, Class<?> envoker)throws Exception{
		if(vecPCs.contains(pc)){
			Exception e = new Exception("PC already exist!");
			displayException(e);
			throw e;
		}
		try{
			StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
			String className = stackTrace[stackTrace.length-1].toString();
			className = envoker.getName();
			vecPCs.add(pc);
			log("\"" + className + "\"is trying to add these to PC list:\"" + pc + "\"");
			log("Successfully added!");
			return "Success!";
		}
		catch(Exception e){
			throw e;
		}
	}

	public static String removePC(PC pc, Class<?> envoker)throws Exception{
		if(!vecPCs.contains(pc)){
			Exception e = new Exception("PC do not exist!");
			displayException(e);
			throw e;
		}
		try{
			StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
			String className = stackTrace[stackTrace.length-1].toString();
			className = envoker.getName();
			vecPCs.remove(pc);
			log("\"" + className + "\"is trying to remove these from PC list:\"" + pc + "\"");
			log("Successfully removed!");
			return "Success!";
		}
		catch(Exception e){
			throw e;
		}
	}*/
	/*
	static void createLogPanel(){
        //日志框初始化
        //标题位
        jlabel_logTitle.setFont((new Font("宋体",Font.BOLD, 16)));
        jlabel_logTitle.setSize(20, 20);
        hlogBox2.add(jlabel_logTitle);
        hlogBox2.add(Box.createGlue());
        vlogBox1.add(hlogBox2);
        //输出位
        jTextArea_logArea.setEditable(false);
        jTextArea_logArea.setLineWrap(true);
        jTextArea_logArea.setWrapStyleWord(true);
        jScrollpane_logScroll=new JScrollPane(jTextArea_logArea);
        jScrollpane_logScroll.setHorizontalScrollBarPolicy( 
        		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        jScrollpane_logScroll.setVerticalScrollBarPolicy( 
        		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		jScrollpane_logScroll.setWheelScrollingEnabled(true);
		vlogBox1.add(jScrollpane_logScroll);
		//输入位
		hlogBox3.add(jtextField_enterBox);
		hlogBox3.add(button_send);
		vlogBox1.add(hlogBox3);
		jPanel_log.add(vlogBox1);//最后把整个panel加到窗口
	}
	public static void log(String msg){
		//jtextarea.setText(jlabel.getText().replace("</html>", "")+msg+"<br></html>");
		jTextArea_logArea.setText(jTextArea_logArea.getText()+"["+df_date.format(new Date())+"] "+msg+"\n");
		jTextArea_logArea.setCaretPosition(jTextArea_logArea.getText().length());
		System.out.print("["+df_date.format(new Date())+"] "+msg+"\n");
	}*/
	/*
    //control panel用
    static JPanel jPanel_ctl = new JPanel();
    static JLabel jlabel_ctlTitle = new JLabel("My computers:                                                                                              ");
    static Box vctlBox1 = Box.createVerticalBox(),
    		hctlBox1 = Box.createHorizontalBox(),
    		hctlBox2 = Box.createHorizontalBox();
    static Vector<PC>vecPCs = new Vector<PC>();
    static Vector<String> vecFunctions = new Vector<String>();
    static String []functions = {
    	"Info","ScreenShoot","Functions","files"
    };
    static JList jlistPCs = new JList(vecPCs),
    		jlistFunctions = new JList(vecFunctions);
    static JScrollPane jScrollpane_pclist = new JScrollPane(jlistPCs), jScrollpane_funclist = new JScrollPane(jlistFunctions);
    static JPanel jPanel_content = new JPanel();*/
	
    //static Label label=new Label();
	/*
	//log panel 用
    static JLabel jlabel_logTitle=new JLabel("LogOutput：                                                                                                  "); 
    static JTextField jtextField_enterBox = new JTextField(20);
    static JTextArea jTextArea_logArea=new JTextArea("Server日志开始记录:\n",10,30);
    static SimpleDateFormat df_date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    static JScrollPane jScrollpane_logScroll;
    static Box vlogBox1 = Box.createVerticalBox();
    static Box hlogBox2 = Box.createHorizontalBox();
    static Box hlogBox3 = Box.createHorizontalBox();
    static JPanel jPanel_log = new JPanel();
    static JButton button_send = new JButton("发送");
    */
} 
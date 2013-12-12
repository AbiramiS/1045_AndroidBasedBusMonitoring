
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Administrator
 */
public class Main extends javax.swing.JFrame implements Runnable,MouseListener, MouseMotionListener,ActionListener{
    private JPanel rotmap;
    public JPanel root,root2,root3;
  static  Main ob;
    private ImageIcon rootIco;
    private ImageIcon icon;
    
    
    static public boolean b1=false,b2=false,b3=false;
  static final int X[]={51,51,51,51,52,53,54,55,55,56,54,54,55,56,56,57,57,58,58,59,60,61,63,63,64,65,66,66,67,68,68,69,67,68,69,70,70,71,72,73,73,74,76,77,78,79,80,80,81,82,82,83,84,84,85,86,87,88,88,89,90,90,90,91,92,92,92,93,94,95,95,96,98,99,101,102,102,102,103,103,103,104,104,105,106,107,108,108,109,107,108,108,108,109,110,110,111,112,115,116,116,117,118,119,119,120,120,121,122,124,125,126,126,126,127,127,128,128,128,129,129,130,130,131,131,132,133,134,135,135,135,136,137,138,138,139,139,140,140,141,141,141,142,142,143,144,145,146,146,146,147,148,149,149,150,152,153,153,154,155,155,156,156,156,157,157,158,158,160,162,163,165,166,167,167,168,169,170,170,171,171,172,172,173,173,174,174,175,176,177,177,178,178,179,180,181,181,182,184,185,185,186,187,187,188,188,189,189,190,191,191,191,192,192,192,192,192,193,193,193,194,194,194,195,195,194,193,194,194,194,195,195,196,196,196,197,197,197,198,199,199,200,201,202,202,203,204,205,205,205,206,206,206,207,208,209,209,211,212,213,214,214,215,216,217,217,218,218,218,219,220,221,221,222,223,224,224,225,227,229,230,232,233,233,235,236,238,239,239,240,240,240,240,240,241,242,242,242,243,244,245,245,246,247,248,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,285,286,287,288,289,290,291,292,294,295,296,297,298,299,299,300,302,303,304,305,306,307,308,309,311,312,312,313,314,315,316,316,317,318,319,320,321,323,324,325,326,327,328,329,330,332,333,335,336,337,338,339,340,341,342,342,343,344,346,347,347,348,349,349,350,351,353,353,354,355,355,356,357,357,358,359,360,360,361,362,362,363,364,365,366,366,367,368,369,370,371,372,373,374,375,375,376,378,379,381,382,382,383,384,385,386,387,387,388,389,390,391,392,394,395,397,398,398,399,400,401,403,404,405,406,407,408,409,411,412,414,416,417,419,420,421,421,422,423,424,425,426,427,428,429,430,431,432,432,433,435,436,436,436,437,438,439,439,440,441,442,446,447,447,448,448,449,449,449,450,450,451,453,454,455,455,456,456,459,459,460,461,461,462,462,462,463,463,464,466,467,468,469,469,470,472,472,473,473,473,474,474,475,475,476,476,477,477,477,478,478,479,479,479,479,479,480,480,480,480,481,481,482,482,482,482,482,482,482,482,483,483,483,484,484,485,485,486,486,487,488,488,489,489,489,489,489,490,490,490,490,491,491,492,493,493,493,493,493,493,494,495,496,496,497,497,497,498,498,499,500,501,501,502,502,502,502,503,503,503,503,504,504,504,504,504,505,505,505,505,505,506,506,506,507,507,507,508,508,508,509,509,509,509,510,510,511,511,511,511,512,512,512,512,512,513,513,513,514,514,514,515,515,515,516,517,518,520,521,522,522,523,524,524,525,526,527,529,530,531,531,532,532,533,535,535,536,537,537,537,538,540,541,542,543,544,546,549,550,550,551,552,554,555,555,555,556,557,557,558,559,560,561,562,563,565,566,567,568,570,571,571,572,573,574,574,574,575,576,577,578,579,581,583,585,586,587,589,590,591,592,593,594,595,597,598,598,599,600,601,601,601,602,603,604,605,606,607,608,609,610,611,612,612,612,613,622,623,624,626,628,629,629,630,631,631,632,634,635,636,637,638,639,640,641,643,644,645,646,648,649,650,650,651,652,653,654,655,656,657,658,659,660,662,663,663,664,665,666,667,668,669,669,669,670,670,671,671,672,674,675,677,678,679,679,680,682,682,684,685,685,686,687,688,688,688,689,687,687,688,688,689,690,691,691,692,693,694,695,696,696,697,697,697,697,697,698,698,698,698,699,699,699,699,700,700,700,701,702,703,704,704,705,705,706,706,706,707,709,710,711,711,712,713,714,715,715,716,717,718,718,719,719,720,721,722,722,723,724,724,724,725,727,728,728,729,730,731,731,732,733,734,734,735,737,737,738,738,740,741,742,742,742};
   static final int Y[]={530,530,530,528,528,527,527,526,525,525,525,524,523,523,522,521,520,520,519,518,516,515,515,514,513,513,513,512,512,511,510,510,510,509,508,508,507,506,506,505,504,504,503,502,502,502,501,500,500,500,499,498,498,497,497,496,495,495,494,493,493,492,491,491,491,490,489,489,489,488,487,487,486,486,485,485,484,483,483,482,481,480,479,479,479,479,479,478,477,475,475,474,473,473,472,471,471,471,469,468,467,467,467,466,465,465,464,464,463,462,461,460,459,458,458,457,456,455,454,454,453,453,451,451,450,449,449,449,449,448,447,447,447,447,446,445,444,443,442,442,441,440,440,439,438,438,437,437,436,435,435,435,434,433,433,432,432,431,431,430,429,429,428,427,426,425,424,423,423,422,421,420,419,419,418,417,416,415,414,414,413,412,411,411,410,410,409,409,408,408,407,406,405,405,404,404,403,402,401,401,400,400,399,398,398,397,397,396,396,396,395,394,394,393,392,391,390,390,389,388,388,387,386,386,385,384,384,384,383,382,382,381,381,380,379,379,378,377,377,377,376,375,375,375,374,373,372,372,371,370,370,369,368,368,368,367,366,366,365,364,364,363,362,362,362,361,361,360,359,358,358,358,357,356,356,355,354,354,353,352,352,351,350,349,349,348,347,347,346,346,345,344,343,342,342,342,341,340,340,340,339,338,338,338,338,337,337,337,337,337,337,337,337,337,337,337,337,337,337,337,337,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,336,337,337,337,337,337,337,337,337,336,336,335,335,336,336,336,336,336,337,337,337,337,337,337,337,337,337,337,337,337,337,338,338,338,338,338,338,339,339,339,339,339,340,340,341,342,342,343,343,343,344,344,344,344,345,345,345,346,346,346,347,347,347,347,348,348,348,349,349,349,349,349,350,350,351,351,351,351,351,351,351,351,352,352,352,352,352,352,353,353,353,353,353,353,354,354,354,354,354,354,354,354,354,353,352,352,352,352,352,352,352,352,352,352,352,351,351,350,350,350,349,349,348,347,347,347,347,347,347,346,346,346,346,346,345,344,344,343,343,342,341,341,341,341,340,339,339,339,338,337,336,336,335,335,334,333,333,332,331,330,329,329,328,327,326,325,324,323,323,322,322,321,320,320,319,318,318,317,316,316,315,314,313,312,312,311,310,309,308,307,306,306,305,305,304,303,303,302,302,301,300,299,298,298,297,296,295,295,294,293,292,291,290,289,288,287,286,286,285,284,284,283,283,282,282,281,280,280,279,279,278,277,276,275,275,274,273,272,272,271,270,270,269,268,267,266,265,264,263,262,261,261,260,259,259,258,257,256,254,253,252,251,250,249,249,248,247,246,246,245,244,243,242,242,241,240,239,238,237,236,235,235,234,233,232,231,230,229,228,227,226,225,224,224,223,222,221,221,220,219,218,217,217,216,215,215,214,213,213,212,211,210,209,208,207,206,206,205,204,204,203,202,200,199,198,197,197,196,196,195,195,194,193,193,193,192,191,191,190,189,189,188,188,187,185,184,183,183,183,182,182,181,180,180,179,178,178,177,176,176,176,176,176,176,176,176,175,175,174,173,173,173,172,171,171,171,171,170,170,169,168,167,167,167,167,167,167,167,167,167,167,167,167,166,165,165,165,164,163,163,163,163,163,163,163,163,163,163,163,163,162,161,161,160,160,160,159,158,158,156,156,156,155,155,154,154,154,154,154,154,154,154,153,153,153,153,153,153,152,151,151,150,150,150,150,150,150,149,149,149,148,148,147,146,146,146,145,144,144,143,142,142,141,141,140,139,138,138,137,136,136,135,135,134,133,133,132,131,131,130,130,129,128,128,126,125,125,124,123,123,123,122,121,121,120,119,119,118,116,115,114,113,112,111,110,109,108,108,107,106,105,105,104,103,102,101,101,100,99,99,98,98,97,96,95,93,92,91,90,90,89,88,87,86,86,85,85,84,83,82,81,80,79,78,78,78,77,76,76,75,74,73,73,72,72,71,70,69,69,68,67,67,66,66,65,64,64,64,63,62};
     private JLabel iconbus,iconbus2,iconbus3;
    private JLabel lblRoot;
  static  Thread t;
    private JLabel status;
   static public  JButton btn,btn1,btn2;
  static  public JLabel timelab,timelab2,timelab3;
  static  public Date date;
    static public JLabel locate,locate2,locate3;
    static public  JLabel loccros,loccros2,loccros3;
    static public  JTextField ipaddress;
    public static JTextField portno;
    static public JButton fixbtn;
    private JLabel entlbl;
    Main(){
    super("LSB "); 
    this.setLayout(null);

    icon=new ImageIcon("../EconomicalLSB/src/image/busico.gif");
    rootIco=new ImageIcon("../EconomicalLSB/src/image/root.jpg");
    fixbtn=new JButton("Fix IP");
    root=new JPanel();
    root2=new JPanel();
    root3=new JPanel();
 rotmap =new JPanel();
 timelab=new JLabel("B1 Time");
 locate=new JLabel("B2 Location");
 loccros=new JLabel("B3 Status");

 locate2=new JLabel("B2 Location");
 loccros2=new JLabel("B2 Status");

 locate3=new JLabel("B3 Location");
 loccros3=new JLabel("B3 Status");
 ipaddress=new JTextField("127.0.0.1");
 portno =new JTextField("8080");
 btn = new JButton("Start Bus1");
  btn1 = new JButton("Start Bus2");
   btn2 = new JButton("Start Bus3");
 entlbl=new JLabel("Enter Server IP and port:");
 status=new JLabel("Start up");
iconbus=new JLabel(icon);
iconbus2=new JLabel(icon);
iconbus3=new JLabel(icon);
lblRoot=new JLabel(rootIco);
timelab.setBounds(770, 40, 120, 40);
locate.setBounds(770, 80, 120,40);
loccros.setBounds(770, 120, 120,40);

locate2.setBounds(770, 200, 120,40);
loccros2.setBounds(770, 240, 120,40);

locate3.setBounds(770, 320, 120,40);
loccros3.setBounds(770, 360, 120,40);
btn.setBounds(770, 450, 100, 40) ;
btn1.setBounds(770, 480, 100, 40) ;
btn2.setBounds(770, 510, 100, 40) ;
locate.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
timelab.setBorder(javax.swing.BorderFactory.createTitledBorder("B1"));
loccros.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
locate2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

loccros2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
locate3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

loccros3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
 status.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
lblRoot.setBorder(new LineBorder(Color.orange, 3));
 root.add(iconbus);
 root2.add(iconbus2);
 root3.add(iconbus3);
 status.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
 status.setBounds(20,560,200,30);  
 rotmap.add(lblRoot);
rotmap.setBounds(30, 20, 732, 534);
rotmap.addMouseMotionListener(this);
btn.addActionListener(this);
btn1.addActionListener(this);
btn2.addActionListener(this);
root.setBounds(43, 495, 8, 8);
root2.setBounds(43, 495, 8, 8);
root3.setBounds(43, 495, 8, 8);
ipaddress.setBounds(400,560,100,30);
portno.setBounds(500,560,100,30);
entlbl.setBounds(250,560,150,30);
fixbtn.setBounds(600, 560, 100, 30);
fixbtn.addActionListener(this);
 btn.setEnabled(false);
 btn1.setEnabled(false);
 btn2.setEnabled(false);
add(root);
add(root2);
add(root3);
 add(rotmap);
add(status);
add(timelab);
add(locate);
add(loccros);

add(locate2);
add(loccros2);

add(locate3);
add(loccros3);
add(btn);
add(btn1);
add(btn2);
add(ipaddress);
add(portno);
add(entlbl);
add(fixbtn);
addMouseMotionListener(this);
addMouseListener(this);
       
    }
    
  static void setLocation(int i) {
          try {
             
            
        
            URL yahoo = new URL("http://"+Main.ipaddress.getText()+":"+Main.portno.getText()+"/LBS/BUS1?currLoc="+Main.X[i]+"&speed=1");
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
               //System.out.println(inputLine);
            }
            in.close();

          }
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
       }
          try {
             
            
        
            URL yahoo = new URL("http://"+Main.ipaddress.getText()+":"+Main.portno.getText()+"/LBS/BUS2?currLoc="+Main.X[i]+"&speed=1");
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
               //System.out.println(inputLine);
            }
            in.close();

          }
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
       }
          try {
             
            
        
            URL yahoo = new URL("http://"+Main.ipaddress.getText()+":"+Main.portno.getText()+"/LBS/BUS3?currLoc="+Main.X[i]+"&speed=1");
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
               //System.out.println(inputLine);
            }
            in.close();

          }
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
       }
    }   
    
    
    
    

public static void main(String[] args) {
    t=Thread.currentThread();
 ob=new Main();
ob.setVisible(true);
ob.setSize(900,650);
Main.setLocation(0);
ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 while(true){
          t=new Thread();
          try{
          t.sleep(50);
        
          }catch(InterruptedException ur){
          
          }
        }

    }

    public void run() {
        
     
       
    }

    public void mouseClicked(MouseEvent e) {
  
  
    }

    public void mousePressed(MouseEvent e) {
        
     
    }

    public void mouseReleased(MouseEvent e) {
       root.setBounds(43, 495, 8, 8);
    }

    public void mouseEntered(MouseEvent e) {
       status.setText(e.getX()+""+e.getY());
         
    }

    public void mouseExited(MouseEvent e) {
      
    }

    public void mouseDragged(MouseEvent e) {
     root.setBounds(e.getX(), e.getY(), 50, 45);
    }

    public void mouseMoved(MouseEvent e) {
      status.setText(" X="+e.getX()+"Y="+e.getY());
          

}

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Start Bus1"){
        NewBus obj=new NewBus();
        b1=true;
       btn.setEnabled(false);
        }
         if(e.getActionCommand()=="Start Bus2"){
        b2=true;
        NewBus2 obj=new NewBus2();
       btn1.setEnabled(false);
        }
         if(e.getActionCommand()=="Start Bus3"){
       b3=true;
       NewBus3 obj=new NewBus3();
       btn2.setEnabled(false);
        }
        if(e.getActionCommand()=="Fix IP"){
        
        ipaddress.setEditable(false);
        portno.setEnabled(false);
          btn.setEnabled(true);
          btn1.setEnabled(true);
          btn2.setEnabled(true);
          fixbtn.setEnabled(false);
        }
      
     
    }

 

   
}



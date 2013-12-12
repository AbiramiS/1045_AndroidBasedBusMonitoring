
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class NewBus2 extends Thread{
    public static Thread t;
    String stat=null;
    String loce=null;
    String StartTimeB2;
    String RreachedTimeB2;
    int send;
    Date StartT;
    Date EndT;
    public ImageIcon icon1;
    public JLabel iconbus1;
    public JPanel root1;
    public int speed1;
    
    NewBus2(){
        Main.date=new Date();
        StartT=Main.date;
        @SuppressWarnings("deprecation")
        int starttime=(Main.date.getHours()*60*60)+Main.date.getMinutes()*60+Main.date.getSeconds();
        StartTimeB2=starttime+"";
        icon1=new ImageIcon("../EconomicalLSB/src/image/busico.gif");  
        iconbus1=new JLabel(icon1);
        root1=new JPanel();
        root1.add(iconbus1);
        root1.setBounds(43, 495, 8, 8);
        t = new Thread(this, "LSB");
        System.out.println("Start Time: " + StartTimeB2);
        System.out.println("Length of array"+Main.X.length);
        t.start(); // Start the thread
}
// This is the entry point for the second thread.
    @Override
public void run() {
try {
    for(int i=0;i<Main.X.length;i++){
      Main.date=new Date();
      setLocation(i);
                @SuppressWarnings("deprecation")
      String hr=""+Main.date.getHours();
                @SuppressWarnings("deprecation")
      String min=""+ Main.date.getMinutes();
                @SuppressWarnings("deprecation")
      String sec=""+Main.date.getSeconds();
     
      String loc=  getBusLocation(Main.X[i]);
      String status=getBusStatus(Main.X[i]);
      Main.locate2.setText(loc);
      Main.loccros2.setText(status);
      Thread.sleep(200);
}
} catch (InterruptedException e) {
System.out.println("Child interrupted.");
}

}

    void setLocation(int i) {
          try {
              send++;
            Main.ob.root2.setBounds(Main.X[i], Main.Y[i] - 30, 8, 8);
          if(send==20){
            URL yahoo = new URL("http://"+Main.ipaddress.getText()+":"+Main.portno.getText()+"/LBS/BUS2?currLoc="+Main.X[i]+"&speed=1");
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
               //System.out.println(inputLine);
            }
            in.close();
          send=0;
          }
        } catch (IOException ex) {
            Logger.getLogger(NewBus.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   

    private String getBusLocation(int i) {
       
        
       if(i==52){
        
       loce="stop1";
       }
      if(i==116){
        
       loce="stop2";
       }
        if(i==170){
          System.out.println("stop2");
       loce="stop3";
       }
         if(i==230){
        
       loce="stop4";
       }
        if(i==371){
       
       loce="stop5";
       }
     if(i==470){
        
       loce="stop6";
       }
        if(i==503){
          System.out.println("stop4");
       loce="stop7";
       }
         if(i==551){
        
       loce="stop 8";
       }
         if(i==666){
        
       loce="stop 9";
       }
        if(i==742){
         
       loce="stop 10";
       } 
       return loce;
    }

    private String getBusStatus(int i) {
        if(i==81){
        stat="near stop 2";
        }
        if(i==143){
        stat="near stop 3";
        }
         if(i==196){
        stat="near stop 4 ";
                
        }
        if(i==300){
        stat="near stop 5";
        }
        if(i==436){
        stat="near stop 6";
        }
        if(i==488){
        stat="near stop 7";
        }
        if(i==513){
        stat="near stop 8";
        }
        
        if(i==604){
        stat="near stop 9";
        }
         if(i==700){
        stat="near stop 10";
        }
         if(i==724){
        stat="Reached stop 10";
        
     Main.fixbtn.setEnabled(true);
     
        Main.date=new Date();
        EndT=Main.date;
        System.out.println("Start time"+StartT);
        System.out.println("End time"+EndT);
        
        }
        return stat;
    }

 
}
    



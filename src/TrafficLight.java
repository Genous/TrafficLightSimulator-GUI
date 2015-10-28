import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLight extends JFrame
{

    int counter=0;
    JButton button;
    JLabel Light, lightTimeLeft;
    Timer timer;
    
    final int redDuration = 20;
    final int yellowDuration = 5;
    final int greenDuration = 15;
    
    ImageIcon Red = new ImageIcon("Red.png");
    ImageIcon Yellow = new ImageIcon("Yellow.png");
    ImageIcon Green = new ImageIcon("Green.png");
    
    public TrafficLight()
    {
        
        setLayout(null);
        
        //Create Start Button
        button = new JButton("Start");
        add(button);
        button.setBounds(20,140,100,35);
        
        //Create Counter Label
        lightTimeLeft = new JLabel("Waiting to start...", SwingConstants.CENTER);
        add(lightTimeLeft);
        lightTimeLeft.setBounds(125,70,100,35);
        
        //Create Light Label
        Light = new JLabel(Red);
        add(Light);
        Light.setBounds(270,17,60,160);
        
        //Create Button Action Listener
        event e = new event();
        button.addActionListener(e);
    }
    
    public class event implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //Code excuted when button is pressed
            counter = 0;
            button.setEnabled(false);
            button.setText("Running...");

            TimeClass tc = new TimeClass();
            timer = new Timer(1000,tc);
            timer.start();    
            
        }
    }
    
    public class TimeClass implements ActionListener
    {
        public void actionPerformed(ActionEvent tc)
        {            
            //Code excuted after every timer tick(every 1 second)
            counter++;
            
            if(counter<(redDuration))
            {

                Light.setIcon(Red);
                lightTimeLeft.setText("Time Left: " + String.valueOf(redDuration-counter));
            }
            
            if(counter >=(redDuration) && counter < (redDuration + yellowDuration))
            {
                Light.setIcon(Yellow);
                lightTimeLeft.setText("Time Left: " + String.valueOf((redDuration + yellowDuration)-counter));
            }
            
            if(counter>=(redDuration + yellowDuration) && counter<(redDuration + yellowDuration + greenDuration))
            {
                Light.setIcon(Green);
                lightTimeLeft.setText("Time Left: " + String.valueOf((redDuration + yellowDuration + greenDuration)-counter));
            }
            if(counter>=(redDuration + yellowDuration + greenDuration))
            {
            	Light.setIcon(Red);
            	counter = 0;
            }
            
            


        }
    }
    
    
    public static void main(String[] args)
    {
        //Create the program
        TrafficLight gui = new TrafficLight();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(350,225);
        gui.setTitle("Taffic Light");
        gui.setResizable(false);
        gui.setLocation(500,200);
        gui.setVisible(true);
    }
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgfinal.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static java.awt.image.ImageObserver.ERROR;


/**
 *
 * @author shins5563
 */

// make sure you rename this class if you are doing a copy/paste
public class circle extends JComponent{

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    
    int rotate = 1;
    
    
    int xx = 250;
    int yy;
    boolean semiCircle = false;
    boolean quarter = false;
    
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
//        g2d.rotate(Math.toRadians(rotate), 350, 350);
//        g.drawRect(300, 300, 30, 30);
//        g2d.rotate(Math.toRadians(-rotate), 350, 350);
        
        
        g.drawString("xx and yy" + xx + "  " + yy, 50, 50);
        g.drawOval(xx, yy, 30, 30);
        
        // GAME DRAWING ENDS HERE
    }
    
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void run()
    {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            rotate +=4;

//            if(!semiCircle)
//            {
//                if(!quarter)
//                {
//                    xx +=1;
//                    yy = (int) Math.round(Math.sqrt(2500 - (xx-300)*(xx-300)) + 300);
//                    if(yy == 350)
//                    {
//                        quarter = true;
//                    }
//                }
//                if(quarter)
//                {
//                    xx +=1;
//                    yy = (int) Math.round(Math.sqrt(2500 - (xx-300)*(xx-300)) + 300);
//                }
//                
//                
//                if(xx == 200)
//                {
//                    semiCircle = true;
//                }
//            }
//            if(!semiCircle)
//            {
//                xx -=1;
//                yy = (int) Math.round(Math.sqrt(2500 - (xx-300)*(xx-300)) + 300);
//                
//                
//            }
            
            
            if(!semiCircle)
            {
                xx+=5;
                yy = (int)Math.sqrt(2500 - (xx-300)*(xx-300)) + 300;
                if(xx == 350)
                {
                    semiCircle = true;
                }
            }
            if(semiCircle)
            {
                xx -=5;
                yy = -(int)Math.sqrt(2500 - (xx-300)*(xx-300)) + 300;
                if(xx == 250)
                {
                    semiCircle = false;
                }
            }
            
            
            
            int circle2X = 250;
            int circle2Y;
                
             //cricle2
            //rotating
            if(!semiCircle)
            {
                circle2X += 4;
                circle2Y = (int)Math.sqrt(2500 - (circle2X-300)*(circle2X-300)) + 300;
                if(circle2X == 350)
                {
                    semiCircle = true;
                }
            }
            if(semiCircle)
            {
                circle2X -= 4;
                circle2Y = -(int)Math.sqrt(2500 - (circle2X-300)*(circle2X-300)) + 300;
                if(circle2X == 250)
                {
                    semiCircle = false;
                }
            }
             
            
            
            
            // GAME LOGIC ENDS HERE 
            
            // update the drawing (calls paintComponent)
            repaint();
            
            
            
            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if(deltaTime > desiredTime)
            {
                //took too much time, don't wait
            }else
            {
                try
                {
                    Thread.sleep(desiredTime - deltaTime);
                }catch(Exception e){};
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");
       
        // creates an instance of my game
        circle game = new circle();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        // adds the game to the window
        frame.add(game);
         
        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // starts my game loop
        game.run();
    }
}
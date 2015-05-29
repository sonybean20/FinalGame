package pkgfinal.project;

/*

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import static java.awt.image.ImageObserver.ERROR;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author shins5563
 */

// make sure you rename this class if you are doing a copy/paste
public class FinalProject extends JComponent implements KeyListener{

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    boolean moving = false;
    boolean spacebar = false;
    boolean gCircle1 = true;
    boolean gCircle2 = true;
    boolean gCircle3 = true;
    boolean gCircle4 = true;
    boolean gCircle5 = true;
    
    //stage
    int stage = 0;
    
    //life 
    int life = 3;
    
    //angle for rotation
    double theta1 = 0;
    double theta2 = Math.PI;
    double theta3 = 0;
    double theta4 = Math.PI;
    double theta5 = 0;
    
    //character
    int playerX = 400;
    int playerY = 550;
    int playerRadius = 13;
    int playerCenterX = playerX + 13;
    int playerCenterY = playerY + 13;
    
    //Black Circles
    int circle1X = 400;
    int circle1Y = 100;
    int circle1Radius = 13;
    int circle1CenterX = circle1X + 13;
    int circle1CenterY = circle1Y + 13;

    int circle2X = 400;
    int circle2Y = 200;
    int circle2Radius = 13;
    int circle2CenterX = circle2X + 13;
    int circle2CenterY = circle2Y + 13;
    
    int circle3X = 400;
    int circle3Y = 300;
    int circle3Radius = 13;
    int circle3CenterX = circle3X + 13;
    int circle3CenterY = circle3Y + 13;
    
    int circle4X = 400;
    int circle4Y = 400;
    int circle4Radius = 13;
    int circle4CenterX = circle4X + 13;
    int circle4CenterY = circle4Y + 13;
    
    int circle5X = 400;
    int circle5Y = 500;
    int circle5Radius = 13;
    int circle5CenterX = circle5X + 13;
    int circle5CenterY = circle5Y + 13;
    
    
    //Green circles
    int gCircle1X = 700;
    int gCircle1Y = 100;
    int gCircle1Radius = 13;
    int gCircle1CenterX = gCircle1X + 13;
    int gCircle1CenterY = gCircle1Y + 13;

    int gCircle2X = 550;
    int gCircle2Y = 200;
    int gCircle2Radius = 13;
    int gCircle2CenterX = gCircle2X + 13;
    int gCircle2CenterY = gCircle2Y + 13;
    
    int gCircle3X = 400;
    int gCircle3Y = 300;
    int gCircle3Radius = 13;
    int gCircle3CenterX = gCircle3X + 13;
    int gCircle3CenterY = gCircle3Y + 13;

    int gCircle4X = 250;
    int gCircle4Y = 400;
    int gCircle4Radius = 13;
    int gCircle4CenterX = gCircle4X + 13;
    int gCircle4CenterY = gCircle4Y + 13;
    
    int gCircle5X = 100;
    int gCircle5Y = 500;
    int gCircle5Radius = 13;
    int gCircle5CenterX = gCircle5X + 13;
    int gCircle5CenterY = gCircle5Y + 13;
    
    //backgroundG variable
    int xx = 70;
    boolean background = true;
    
    
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        
        
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
                  
        //background color change
        for(int i = 0; i < 101; i ++)
        {
            Color background = new Color(55+2*i, xx+i, 106+i);
            g.setColor(background);
            g.fillRect(0, HEIGHT-6*i, WIDTH, 6);
        }
        
        if(stage ==0)  //instructions page
        {
            //fill background
            g.setColor(Color.white);
            g.fillRect(0, 0, 800, 600);
            
            g.setColor(Color.black);
            g.drawString("Instructions", 380, 100);
            g.drawString("The goal of this game is to get all the green circles that are on the screen.", 200, 130);
            g.drawString("Use arrow keys to move your player." , 200, 150);
            g.drawString("Use space bar to gain a life by hitting a green circle.", 200, 170);
            g.drawString("You lose a life if you hit a black circle.", 200, 190);
            g.drawString("Press space bar to move onto the next stage.", 200, 250);
            
            //if spacebar is pressed
            if(spacebar)
            {
                //move onto stage 1
                stage = 1;
            }
            
            
        }else //during game
        {
            ////paint circles
            
            //character
            Color me = new Color(237, 125, 69);
            g.setColor(me);
            g.fillOval(playerX, playerY, 26, 26);

            //black circle1
            g.setColor(Color.BLACK);
            g.fillOval(circle1X, circle1Y, 26, 26);

            //black circle2
            g.setColor(Color.BLACK);
            g.fillOval(circle2X, circle2Y, 26, 26);

            //black circle3
            g.setColor(Color.BLACK);
            g.fillOval(circle3X, circle3Y, 26, 26);

            //black circle3
            g.setColor(Color.BLACK);
            g.fillOval(circle3X, circle3Y, 26, 26);

            //black circle4
            g.setColor(Color.BLACK);
            g.fillOval(circle4X, circle4Y, 26, 26);

            //black circle5
            g.setColor(Color.BLACK);
            g.fillOval(circle5X, circle5Y, 26, 26);

            //green circle1
            Color gCircle = new Color(103, 202, 121);
            if(gCircle1)
            {
                g.setColor(gCircle);
                g.fillOval(gCircle1X, gCircle1Y, 26, 26);
            }else
            {
                gCircle1X = -13;
                gCircle1Y = -13;
            }

            //green circle2
            if(gCircle2)
            {
                g.setColor(gCircle);
                g.fillOval(gCircle2X, gCircle2Y, 26, 26);
            }else
            {
                gCircle2X = -13;
                gCircle2Y = -13;
            }

            //green circle3
            if(gCircle3)
            {
                g.setColor(gCircle);
                g.fillOval(gCircle3X, gCircle3Y, 26, 26);
            }else
            {
                gCircle3X = -13;
                gCircle3Y = -13;
            }

            //green circle4
            if(gCircle4)
            {
                g.setColor(gCircle);
                g.fillOval(gCircle4X, gCircle4Y, 26, 26);
            }else
            {
                gCircle4X = -13;
                gCircle4Y = -13;
            }

            //green circle5
            if(gCircle5)
            {
                g.setColor(gCircle);
                g.fillOval(gCircle5X, gCircle5Y, 26, 26);
            }else
            {
                gCircle5X = -13;
                gCircle5Y = -13;
            }
                        
            
            //Show lives left
            g.setColor(Color.black);
            g.drawString("Stage " + stage, 70, 40);
            g.drawString("Life " + life, 70, 60);
        }
        
         
        
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
           
            //if there are no lives left
           if(life == 0)
            {
                //go back to the instruction page
                stage = 0;
                
                //reset life
                life = 3;
                
                //reset booleans
                gCircle1 = true;
                gCircle2 = true;
                gCircle3 = true;
                gCircle4 = true;
                gCircle5 = true;
                
                //reset player position
                playerX = 400;
                playerY = 550;
                
                //reset black circles' positions
                circle1X = 400;
                circle1Y = 100;
                circle2X = 400;
                circle2Y = 200;
                circle3X = 400;
                circle3Y = 300;
                circle4X = 400;
                circle4Y = 400;
                circle5X = 400;
                circle5Y = 500;
                
                //reset green circles' positions
                gCircle1X = 700;
                gCircle1Y = 100;
                gCircle2X = 550;
                gCircle2Y = 200;
                gCircle3X = 400;
                gCircle3Y = 300;
                gCircle4X = 250;
                gCircle4Y = 400;
                gCircle5X = 100;
                gCircle5Y = 500; 
                
            }
           
            //if all green circles are gone
            if(!gCircle1 && !gCircle2 && !gCircle3 && !gCircle4 && !gCircle5)
            {
                //reset life
                life = 3;
                
                //reset booleans
                gCircle1 = true;
                gCircle2 = true;
                gCircle3 = true;
                gCircle4 = true;
                gCircle5 = true;
                
                //reset player position
                playerX = 400;
                playerY = 550;
                
                //move on to next stage
                stage += 1;
            }
            
            //moving player
            if(right)
            {
                playerX += 5;
            }
            if(left)
            {
                playerX -= 5;
            }
            if(down)
            {
                playerY += 5;
            }
            if(up)
            {
                playerY -= 5;
            }
            
            //make player stay on the screen
            if(playerX < 0) // moving off the left hand side
            {
                playerX = 0;
            }
            if(playerX + playerRadius*2 > WIDTH) // off the right hand side
            {
                playerX = WIDTH - playerRadius*2;
            } 
            if(playerY < 0) // moving off the left hand side
            {
                playerY = 0;
            }
            if(playerY + playerRadius*2 > HEIGHT) // off the right hand side
            {
                playerY = HEIGHT - playerRadius*2;
            }
            
            //background colour change
            if(background)
            {
                xx = xx + 1;
                if(xx == 155)
                {
                    background = false;
                }
            }
            if (!background)
            {
                xx = xx - 1;
                if(xx == 70)
                {
                    background = true;
                }
            }
            
            //different stages
            if(stage == 1) //stage 1
            {
                 
                //black circle1 2 3 4 5
                //moving horizontally
                if(moving)
                {
                    circle1X -= 10;
                    circle2X += 10;
                    circle3X -= 10;
                    circle4X += 10;
                    circle5X -= 10;

                    if(circle1X == 0)
                    {
                        moving = false;
                    }
                }else{
                    //change direction

                    circle1X += 10;
                    circle2X -= 10;
                    circle3X += 10;
                    circle4X -= 10;
                    circle5X += 10;

                    if(circle1X == 790)
                    {
                        moving = true;
                    }
                }
            }else if(stage == 2)
            {
                
                //black circles - circle motion
                
                //black circle 1
                theta1 += 0.07;
                circle1X = (int) (100+Math.cos(theta1)*80) - 13;
                circle1Y = (int) (100+Math.sin(theta1)*80) - 13;
                
                //black circle 2
                theta2 += 0.08;
                circle2X = (int) (700+Math.cos(theta2)*60) - 13;
                circle2Y = (int) (100+Math.sin(theta2)*60) - 13;
                
                //black circle 3
                theta3 += 0.09;
                circle3X = (int) (400+Math.cos(theta3)*100) - 13;
                circle3Y = (int) (300+Math.sin(theta3)*100) - 13;
                
                //black circle 4
                theta4 += 0.08;
                circle4X = (int) (100+Math.cos(theta4)*70) - 13;
                circle4Y = (int) (500+Math.sin(theta4)*70) - 13;
                
                //black circle 5
                theta5 += 0.04;
                circle5X = (int) (700+Math.cos(theta5)*60) - 13;
                circle5Y = (int) (500+Math.sin(theta5)*60) - 13;
                
                
                //green circles - in the center of black circles
                
                //green circle1
                gCircle1X = 100 - 13;
                gCircle1Y = 100 - 13;
                
                //green circle2
                gCircle2X = 700 - 13;
                gCircle2Y = 100 - 13;
                
                //green circle3
                gCircle3X = 400 - 13;
                gCircle3Y = 300 - 13;
                
                //green circle4
                gCircle4X = 100 - 13;
                gCircle4Y = 500 - 13;
                
                //green circle5
                gCircle5X = 700 - 13;
                gCircle5Y = 500 - 13;
                
            }else if(stage == 3)  //stage 3
            {
                
                
                
                
            }
                
            
            //update center coordinates
            playerCenterX = playerX + 13;
            playerCenterY = playerY + 13;
            
            circle1CenterX = circle1X + 13;
            circle1CenterY = circle1Y + 13;
            
            circle2CenterX = circle2X + 13;
            circle2CenterY = circle2Y + 13;
            
            circle3CenterX = circle3X + 13;
            circle3CenterY = circle3Y + 13;
            
            circle4CenterX = circle4X + 13;
            circle4CenterY = circle4Y + 13;
            
            circle5CenterX = circle5X + 13;
            circle5CenterY = circle5Y + 13;
            
            gCircle1CenterX = gCircle1X + 13;
            gCircle1CenterY = gCircle1Y + 13;
            
            gCircle2CenterX = gCircle2X + 13;
            gCircle2CenterY = gCircle2Y + 13;
            
            gCircle3CenterX = gCircle3X + 13;
            gCircle3CenterY = gCircle3Y + 13;
            
            gCircle4CenterX = gCircle4X + 13;
            gCircle4CenterY = gCircle4Y + 13;
            
            gCircle5CenterX = gCircle5X + 13;
            gCircle5CenterY = gCircle5Y + 13;
            
            
            //collisions
            //black circle collision
            if(distance(playerCenterX, playerCenterY, circle1CenterX, circle1CenterY) < 26 ||
                    distance(playerCenterX, playerCenterY, circle2CenterX, circle2CenterY) < 26 ||
                    distance(playerCenterX, playerCenterY, circle3CenterX, circle3CenterY) < 26 ||
                    distance(playerCenterX, playerCenterY, circle4CenterX, circle4CenterY) < 26 ||
                    distance(playerCenterX, playerCenterY, circle5CenterX, circle5CenterY) < 26 )
            {
                //reset player position
                playerX = 400;
                playerY = 550;
                life -=1;
            }
            
            //green circle1 collision
            if(gCircle1 && distance(playerCenterX, playerCenterY, gCircle1CenterX, gCircle1CenterY) < 26 && spacebar)
            {
                gCircle1 = false; //make it disappear
                life +=1;
            }
            
            //green circle2 collision
            if(gCircle2 && distance(playerCenterX, playerCenterY, gCircle2CenterX, gCircle2CenterY) < 26 && spacebar)
            {
                gCircle2 = false; //make it disapear
                life +=1;
            }
            
            //green circle3 collision
            if(gCircle3 && distance(playerCenterX, playerCenterY, gCircle3CenterX, gCircle3CenterY) < 26 && spacebar)
            {
                gCircle3 = false; //make it disappear
                life +=1;
            }
            
            //green circle4 collision
            if(gCircle4 && distance(playerCenterX, playerCenterY, gCircle4CenterX, gCircle4CenterY) < 26 && spacebar)
            {
                gCircle4 = false; //make it disappear
                life +=1;
            }
            
            //green circle5 collision
            if(gCircle5 && distance(playerCenterX, playerCenterY, gCircle5CenterX, gCircle5CenterY) < 26 && spacebar)
            {
                gCircle5 = false; //make it disappear
                life +=1;
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
        FinalProject game = new FinalProject();
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
        frame.addKeyListener(game);
        // starts my game loop
        game.run();
    }
    @Override
     public void keyTyped(KeyEvent e) {
        
    }
    @Override
     public void keyPressed(KeyEvent e) {
         int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_RIGHT)
        {
            right = true;
        }else if(keyCode == KeyEvent.VK_LEFT)
        {
            left = true;
        }else if(keyCode == KeyEvent.VK_UP)
        {
            up = true;
        }else if(keyCode == KeyEvent.VK_DOWN)
        {
            down = true;
        }else if(keyCode == KeyEvent.VK_SPACE)
        {
            spacebar = true;
        }
        
     }
    @Override
     public void keyReleased(KeyEvent e) {
         int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_RIGHT)
        {
            right = false;
        }else if(keyCode == KeyEvent.VK_LEFT)
        {
            left = false;
        }else if(keyCode == KeyEvent.VK_UP)
        {
            up = false;
        }else if(keyCode == KeyEvent.VK_DOWN)
        {
            down = false;
        }else if(keyCode == KeyEvent.VK_SPACE)
        {
            spacebar = false;
        }
     }
    
    //find the distance between centers of two circles
    public double distance(int x1, int y1, int x2, int y2)
    {
        double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        return distance;
    }
    
}
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class game1panel extends JPanel implements KeyListener,ActionListener{

    public game1panel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
    }


    String direction;
    int snakeLength;
    int[] snakeX_axis = new int[600];
    int[] snakeY_axis = new int[500];
    int foodX_axis;
    int foodY_axis;
    Random random = new Random();
    boolean startgame= false;
    boolean endgame= false;
    int score;
    Timer timer = new Timer(94, this);
    public void init() {
        snakeLength=3;
        snakeX_axis[0]=100;snakeY_axis[0]=100;
        snakeX_axis[1]=75;snakeY_axis[1]=100;
        snakeX_axis[2]=50;snakeY_axis[2]=100;
        direction="R";
        timer.start();
        foodX_axis = 25 + 25*random.nextInt(34);
        foodY_axis = 75 + 25*random.nextInt(24);
        score=0;
    }







    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.blue);
        g.setColor(Color.pink);
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString("SNAKE GAME", 25, 50);
        g.fillRect(25, 75, 850, 600);
        game1Data.food.paintIcon(this,g,foodX_axis,foodY_axis);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.BOLD,18));
        g.drawString("Snake Length"+snakeLength, 600, 35);
        g.drawString("Score"+score, 600, 50);


        if(direction.equals("R")){
            game1Data.right.paintIcon(this,g,snakeX_axis[0],snakeY_axis[0]);
        }else if(direction.equals("L")){
            game1Data.left.paintIcon(this,g,snakeX_axis[0],snakeY_axis[0]);
        }else if(direction.equals("U")){
            game1Data.up.paintIcon(this,g,snakeX_axis[0],snakeY_axis[0]);
        }else if(direction.equals("D")){
            game1Data.down.paintIcon(this,g,snakeX_axis[0],snakeY_axis[0]);
        }

        for(int i=1 ; i< snakeLength;i++){
            game1Data.body.paintIcon(this,g,snakeX_axis[i],snakeY_axis[i]);
        }

        



        if(startgame==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,40));
            g.drawString("Press the space to start the game", 150, 400);
        }
        if(endgame){
            g.setColor(Color.red);
            g.setFont(new Font("Arial",Font.BOLD,40));
            g.drawString("GAME OVER,Press the space to restart", 100, 400);
        }


    }
    @Override
    public void keyPressed(KeyEvent e) {

        if(snakeX_axis[0] == foodX_axis && snakeY_axis[0] == foodY_axis){
            snakeLength++;
            score++;
            foodX_axis = 25 + 25*random.nextInt(34);
            foodY_axis = 75 + 25*random.nextInt(24);

        }
        int keyCode = e.getKeyCode();
        if(keyCode ==KeyEvent.VK_SPACE){
            if(endgame){
                endgame=false;
                init();
            }else{
                startgame =! startgame;
            }
            repaint();
        }
        if (keyCode == KeyEvent.VK_LEFT&& !(direction=="R")) {
            direction = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT&& !(direction=="L")) {
            direction = "R";
        } else if (keyCode == KeyEvent.VK_UP&& !(direction=="D")) {
            direction = "U";
        } else if (keyCode == KeyEvent.VK_DOWN&& !(direction=="U")) {
            direction = "D";
        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(startgame && endgame==false){
            for(int i=snakeLength-1;i>0;i--){
                snakeX_axis[i]= snakeX_axis[i-1];
                snakeY_axis[i]= snakeY_axis[i-1];

            }
            
            if (direction.equals("R")) {
                snakeX_axis[0] = snakeX_axis[0] + 25;
                if (snakeX_axis[0] > 850) snakeX_axis[0] = 25;
            } else if (direction.equals("L")) {
                snakeX_axis[0] = snakeX_axis[0] - 25;
                if (snakeX_axis[0] < 25) snakeX_axis[0] = 850;
            } else if (direction.equals("U")) {
                snakeY_axis[0] = snakeY_axis[0] - 25;
                if (snakeY_axis[0] < 75) snakeY_axis[0] = 650;
            } else if (direction.equals("D")) {
                snakeY_axis[0] = snakeY_axis[0] + 25;
                if (snakeY_axis[0] > 650) snakeY_axis[0] = 75;
            }

            for(int i=1;i<snakeLength;i++){
                if(snakeX_axis[0]==snakeX_axis[i]&&snakeY_axis[0]==snakeY_axis[i]){
                    endgame=true;
                }

            }



            repaint();
        }
        timer.start();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    



}
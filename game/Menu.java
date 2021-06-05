import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu implements ActionListener{
    JFrame frame=new JFrame();
    JButton button=new JButton("Snake Game");
    Menu(){

        button.setBounds(100,160,200,40);
        button.setFocusCycleRoot(false);
        button.addActionListener(this);

        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
            game1 game1=new game1();
        }
        



    }

}
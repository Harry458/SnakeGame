import javax.swing.*;
public class game1{
    JFrame frame= new JFrame();

    game1(){
        frame.setBounds(10,10,900,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(new game1panel());
        frame.setVisible(true);

    }
}
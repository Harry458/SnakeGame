import java.net.*;

import javax.swing.ImageIcon;

public class game1Data {
    public static URL headerURL = game1Data.class.getResource("header.png");
    public static ImageIcon header = new ImageIcon(headerURL);

    public static URL upURL = game1Data.class.getResource("up.png");
    public static ImageIcon up = new ImageIcon(upURL);

    public static URL downURL = game1Data.class.getResource("down.png");
    public static ImageIcon down = new ImageIcon(downURL);

    public static URL leftURL = game1Data.class.getResource("left.png");
    public static ImageIcon left = new ImageIcon(leftURL);

    public static URL rightURL = game1Data.class.getResource("right.png");
    public static ImageIcon right = new ImageIcon(rightURL);

    public static URL bodyURL = game1Data.class.getResource("body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);

    public static URL foodURL = game1Data.class.getResource("food.png");
    public static ImageIcon food = new ImageIcon(foodURL);
}

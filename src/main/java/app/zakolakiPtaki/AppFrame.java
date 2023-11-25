package app.zakolakiPtaki;

import javax.swing.*;

public class AppFrame extends JFrame {

    AppFrame(String name){

        setTitle(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300, 900);
        setResizable(false);
        setIconImage(new ImageIcon("src/main/resources/Graphics/appIcon.png").getImage());


    }



}

package app.zakolakiPtaki;

import javax.swing.*;
import java.awt.*;

public class AppWindows {

    public JPanel mainPanel(CardLayout cardLayout, JPanel cardPanel){

        JPanel panel = new JPanel();

        panel.setLayout(null);

        JLabel bgImage = new JLabel(new ImageIcon("src/main/resources/Graphics/bg.png"));
        bgImage.setSize(1300, 900);

        JLabel menuImage = new JLabel(new ImageIcon("src/main/resources/Graphics/menuImg.png"));
        menuImage.setBounds(200, 100, 860, 340);

        JButton startButton = new JButton("Start");
        startButton.setBounds(550, 480, 200, 50);
        startButton.setFocusable(false);
        startButton.setBackground(new Color(43, 118, 10));

        JButton creditsButton = new JButton("Credits");
        creditsButton.setBounds(550, 550, 200, 50);
        creditsButton.setFocusable(false);
        creditsButton.setBackground(new Color(43, 118, 10));

        JButton sourceButton = new JButton("Source");
        sourceButton.setBounds(550, 620, 200, 50);
        sourceButton.setFocusable(false);
        sourceButton.setBackground(new Color(43, 118, 10));

        startButton.addActionListener(e -> cardLayout.show(cardPanel, "Tree Simulation"));

        creditsButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Team Zakolaki Ptaki\nMaciej Sepeta | code, data & graphics\nMaciej Lewandowski | code & data\nRobert Juchimiuk | data\nSzymon Olszewski | graphics\nFryderyk Niedźwiedzki | algorithms"));

        sourceButton.addActionListener(e -> JOptionPane.showMessageDialog(null, """
                Source:
                https://8billiontrees.com/carbon-offsets-credits/carbon-ecological-footprint-calculators/how-much-carbon-does-a-tree-capture/
                https://www3.epa.gov/carbon-footprint-calculator/
                https://onetreeplanted.org/blogs/stories/how-much-co2-does-tree-absorb
                https://www.forestryengland.uk/sites/default/files/documents/Teacher%20resources_CalculatingCarbon.pdf
                https://justenergy.com/blog/how-to-calculate-your-carbon-footprint/
                https://ecotree.green/en/how-much-co2-does-a-tree-absorb
                https://climate.selectra.com/en/news/co2-tree
                https://aplikacja.mapadrzew.com/
                https://pl.wikipedia.org/wiki/Sulejówek
                https://warszawa.stat.gov.pl/vademecum/vademecum_mazowieckie/portrety_gmin/minski/1412151_sulejowek.pdf"""));

        {
            panel.add(startButton);
            panel.add(creditsButton);
            panel.add(sourceButton);
            panel.add(menuImage);
            panel.add(bgImage);
        }

            return panel;

    }

    public JPanel treeSimulationPanel(CardLayout cardLayout, JPanel cardPanel){

        JPanel panel = new JPanel();

        panel.setLayout(null);

        // KOMPONENTY

        JButton backHome = new JButton(new ImageIcon("src/main/resources/Graphics/homeButton.png"));
            backHome.setBounds(10,10, 70, 70);
            backHome.setOpaque(false);
            backHome.setContentAreaFilled(false);
            backHome.setBorderPainted(false);

            backHome.addActionListener(e -> cardLayout.show(cardPanel, "Main"));

        JLabel bgImage = new JLabel(new ImageIcon("src/main/resources/Graphics/bg.png"));
            bgImage.setSize(1300, 900);

        final JLabel[] treeImg = {new JLabel(new ImageIcon("src/main/resources/Graphics/Tree/tree1.png"))};
            treeImg[0].setBounds(180, 100, 200, 300);

        JLabel yourTreeLabel = new JLabel("Your tree:");
            yourTreeLabel.setBounds(230,50,200,40);
            yourTreeLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel cityTreeInfoLabel = new JLabel("Trees in the city absorbs yearly:");
            cityTreeInfoLabel.setBounds(730,50,400,40);
            cityTreeInfoLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel cityTreeNumLabel = new JLabel(footprintmiasto() + " kg CO2");
            cityTreeNumLabel.setBounds(740,90,400,40);
            cityTreeNumLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel treeCountLabel = new JLabel("Number of trees in Sulejówek:");
            treeCountLabel.setBounds(730,140,400,40);
            treeCountLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel treeCountNumLabel = new JLabel("29,853 trees");
            treeCountNumLabel.setBounds(743,180,400,40);
            treeCountNumLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel treeMapLabel = new JLabel("Sulejówek trees map:");
            treeMapLabel.setBounds(730,230,400,40);
            treeMapLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel treeMap = new JLabel(new ImageIcon("src/main/resources/Graphics/treeMap.png"));
            treeMap.setBounds(740,270,300,300);
            treeMap.setFont(new Font("Arial", Font.PLAIN, 24));

        JSlider heightSlider = new JSlider();
            heightSlider.setBounds(150,210,20,100);
            heightSlider.setMinimum(2);
            heightSlider.setMaximum(70);
            heightSlider.setOrientation(SwingConstants.VERTICAL);
            heightSlider.setMajorTickSpacing(1);
            heightSlider.setSnapToTicks(true);
            heightSlider.setPreferredSize(new Dimension(300,50));
            heightSlider.setOpaque(true);
            heightSlider.setBackground(Color.white);

        JLabel heightSliderLabel2 = new JLabel("Height:");
            heightSliderLabel2.setBounds(80,210,100,100);

        JLabel heightSliderLabel = new JLabel(heightSlider.getValue()/2 + " m");
            heightSliderLabel.setBounds(85,230,100,100);

        JSlider diameterSlider = new JSlider();
            diameterSlider.setBounds(230,430,100,20);
            diameterSlider.setMinimum(1);
            diameterSlider.setMaximum(300);
            diameterSlider.setMajorTickSpacing(1);
            diameterSlider.setSnapToTicks(true);
            diameterSlider.setOpaque(true);
            diameterSlider.setBackground(Color.white);

        JLabel diameterSliderLabel2 = new JLabel("Diameter:");
            diameterSliderLabel2.setBounds(250,480,100,40);

        JLabel diameterSliderLabel = new JLabel(diameterSlider.getValue() + " cm");
            diameterSliderLabel.setBounds(255,500,100,40);

        JLabel outputLabel1 = new JLabel();
            outputLabel1.setBounds(100,550,600,200);
            outputLabel1.setFont(new Font("Arial", Font.BOLD, 24));
            outputLabel1.setText("CO2 annual absorption of this tree:");

        JLabel outputLabelCO2 = new JLabel("0 kg CO2");
            outputLabelCO2.setBounds(100,590,600,200);
            outputLabelCO2.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel outputLabelEquals = new JLabel(new ImageIcon("src/main/resources/Graphics/equalsGreen.png"));
            outputLabelEquals.setBounds(590,635,150,80);

        JLabel outputLabelCigarettes = new JLabel("Cigarettes                = 0");
            outputLabelCigarettes.setBounds(900,500,600,200);
            outputLabelCigarettes.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel outputLabelPlanes = new JLabel("Plane (km) / person = = 0");
            outputLabelPlanes.setBounds(900,550,600,200);
            outputLabelPlanes.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel outputLabelCarsPetrol = new JLabel("Petrol car (km)         = 0");
            outputLabelCarsPetrol.setBounds(900,600,600,200);
            outputLabelCarsPetrol.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel outputLabelCarsDiesel = new JLabel("Diesel car (km)         = 0");
            outputLabelCarsDiesel.setBounds(900,650,600,200);
            outputLabelCarsDiesel.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel outputLabelBreath = new JLabel("Breaths                    = 0");
            outputLabelBreath.setBounds(900,700,600,200);
            outputLabelBreath.setFont(new Font("Arial", Font.PLAIN, 24));

        heightSlider.addChangeListener(e -> {

            if (heightSlider.getValue() == heightSlider.getMinimum()){

                heightSliderLabel.setText("<= " + (double)heightSlider.getValue()/2 + " m");

            } else if (heightSlider.getValue() == heightSlider.getMaximum()){

                heightSliderLabel.setText(">= " + (double)heightSlider.getValue()/2 + " m");

            } else {

                heightSliderLabel.setText((double)heightSlider.getValue()/2 + " m");

            }

            if (heightSlider.getValue()/2 < 5) {

                treeImg(treeImg[0], 4);

            } else if (heightSlider.getValue()/2 < 15) {

                treeImg(treeImg[0], 3);

            } else if (heightSlider.getValue()/2 < 25) {

                treeImg(treeImg[0], 2);

            } else {

                treeImg(treeImg[0], 1);

            }

            double emission = algorithm(diameterSlider.getValue(), heightSlider.getValue());

            outputLabelCO2.setText(emission + " kg CO2");
            outputLabelCigarettes.setText(  "Cigarettes                = " + porownanie(emission)[0]);
            outputLabelPlanes.setText(      "Plane (km) / person = " + porownanie(emission)[1]);
            outputLabelCarsPetrol.setText(  "Petrol car (km)         = " + porownanie(emission)[2]);
            outputLabelCarsDiesel.setText(  "Diesel car (km)         = " + porownanie(emission)[3]);
            outputLabelBreath.setText(      "Breaths                    = " + porownanie(emission)[4]);

        });

        diameterSlider.addChangeListener(e -> {

            if (diameterSlider.getValue() == diameterSlider.getMinimum()){

                diameterSliderLabel.setText("<= " + diameterSlider.getValue() + " cm");

            } else if (diameterSlider.getValue() == diameterSlider.getMaximum()){

                diameterSliderLabel.setText(">= " + diameterSlider.getValue() + " cm");

            } else {

                diameterSliderLabel.setText(diameterSlider.getValue() + " cm");

            }

            double emission = algorithm(diameterSlider.getValue(), heightSlider.getValue());

            outputLabelCO2.setText(emission + " kg CO2");
            outputLabelCigarettes.setText(  "Cigarettes                = " + porownanie(emission)[0]);
            outputLabelPlanes.setText(      "Plane (km) / person = " + porownanie(emission)[1]);
            outputLabelCarsPetrol.setText(  "Petrol car (km)         = " + porownanie(emission)[2]);
            outputLabelCarsDiesel.setText(  "Diesel car (km)         = " + porownanie(emission)[3]);
            outputLabelBreath.setText(      "Breaths                    = " + porownanie(emission)[4]);

        });

        // DODAWANIE KOMPONENTÓW
        {
            panel.add(backHome);
            panel.add(yourTreeLabel);
            panel.add(cityTreeInfoLabel);
            panel.add(cityTreeNumLabel);
            panel.add(treeCountLabel);
            panel.add(treeCountNumLabel);
            panel.add(treeMapLabel);
            panel.add(treeMap);
            panel.add(bgImage);
            panel.add(treeImg[0]);
            panel.add(heightSlider);
            panel.add(heightSliderLabel);
            panel.add(heightSliderLabel2);
            panel.add(diameterSlider);
            panel.add(diameterSliderLabel);
            panel.add(diameterSliderLabel2);
            panel.add(outputLabel1);
            panel.add(outputLabelCO2);
            panel.add(outputLabelEquals);
            panel.add(outputLabelCigarettes);
            panel.add(outputLabelPlanes);
            panel.add(outputLabelCarsPetrol);
            panel.add(outputLabelCarsDiesel);
            panel.add(outputLabelBreath);
            panel.add(bgImage);
        }

        return panel;
    }

    static double algorithm(double diameter, double height){

        height /= 2;

        double density = 620; // stała
        double foot = (5*0.475*3.67*density*diameter*height)/1600000;  //do sekcji z wyjsciem bo to ile pochlania rocznie

        return (double) Math.round(foot * 100) /100;

    }

    static void treeImg(JLabel tree, int treeSize){

        switch (treeSize){

            case 1:
                tree.setIcon(new ImageIcon("src/main/resources/Graphics/Tree/tree1.png"));
                break;
            case 2:
                tree.setIcon(new ImageIcon("src/main/resources/Graphics/Tree/tree2.png"));
                break;
            case 3:
                tree.setIcon(new ImageIcon("src/main/resources/Graphics/Tree/tree3.png"));
                break;
            case 4:
                tree.setIcon(new ImageIcon("src/main/resources/Graphics/Tree/tree4.png"));
                break;
        }

    }

    static long footprintmiasto(){
        int density = 620; // stała
        double volume = 6707858.0; // dana objetosc na wszyskie
        double avgHigh = 12.71;
        return Math.round((volume*density/2)*0.475*3.67/(avgHigh*1.7))/1000; //polowa masy drzewa to sucha masa, 47,5% to węgiel
        //z masy molowej wychodzi że jak pomnożysz przez 3.67 to przez cale zycie ile zaabsorbuje
        //mniej wiecej wysokosc razy 1.7 to wiek drzewa
    }

    public static int[] porownanie(double emission){
        int[] arr = new int[5];
        arr[0] = (int) Math.round(emission/0.0036);        //papieros
        arr[1] = (int) Math.round(emission/0.133);       //samolot
        arr[2] = (int) Math.round(emission/0.192);      //benzin
        arr[3] = (int) Math.round(emission/0.122);      //dizelek
        arr[4] = (int) Math.round(emission/(0.00013/15));    //oddech na osobe
        return arr;
    }

}

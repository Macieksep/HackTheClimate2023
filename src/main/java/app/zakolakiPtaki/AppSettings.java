package app.zakolakiPtaki;

import javax.swing.*;
import java.awt.*;

public class AppSettings {
    private AppFrame appWindow;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public AppSettings() {

        appWindow = new AppFrame("Hack The Climate Sulejówek | Team Zakolaki Ptaki");

        AppWindows appWindows = new AppWindows();

        // Create the card panel with CardLayout
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create Panel 1
        JPanel mainPanel = appWindows.mainPanel(cardLayout, cardPanel);

        // Create Panel 2
        JPanel treeSimulationPanel = appWindows.treeSimulationPanel(cardLayout, cardPanel);

        cardPanel.add(mainPanel, "Main");
        cardPanel.add(treeSimulationPanel, "Tree Simulation");

        // Add the card panel to the frame
        appWindow.add(cardPanel);

        // mainPanel jako startowy
        cardLayout.show(cardPanel, "Main");

        appWindow.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppSettings::new);
    }

}
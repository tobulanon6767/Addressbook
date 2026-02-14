/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addressbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Main extends JFrame {

    private BackgroundPanel backgroundPanel;
    private JButton enterButton;

    private int baseButtonY;
    private double animationAngle = 0;

    public Main() {
        setTitle("Graviton Address Book");
        setSize(900, 550);
        setMinimumSize(new Dimension(700, 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        initComponents();
        addResizeListener();
        startButtonAnimation();
    }

    private void initComponents() {

        enterButton = new JButton("ENTER");
        enterButton.setFocusPainted(false);
        enterButton.setBackground(Color.BLACK);
        enterButton.setForeground(Color.WHITE);
        enterButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));


        enterButton.addActionListener(e -> {
            menuOne menu = new menuOne();
            menu.setVisible(true);
            dispose(); 
        });

        backgroundPanel.add(enterButton);
        backgroundPanel.setComponentZOrder(enterButton, 0);

        updateLayout();
    }

    private void addResizeListener() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateLayout();
            }
        });
    }

    private void updateLayout() {
        int w = backgroundPanel.getWidth();
        int h = backgroundPanel.getHeight();

        enterButton.setFont(new Font("SansSerif", Font.BOLD, w / 55));

        int buttonWidth = w / 5;
        int buttonHeight = h / 12;

        int x = (w - buttonWidth) / 2;
        baseButtonY = (int) (h * 0.62);

        enterButton.setBounds(x, baseButtonY, buttonWidth, buttonHeight);
    }

    private void startButtonAnimation() {
        Timer timer = new Timer(16, e -> {
            animationAngle += 0.08;
            int offsetY = (int) (Math.sin(animationAngle) * 6);

            enterButton.setLocation(
                enterButton.getX(),
                baseButtonY + offsetY
            );
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    class BackgroundPanel extends JPanel {

        private Image backgroundImage;

        public BackgroundPanel() {
            try {
                URL imgURL = getClass().getResource("/addressbook/background.jpg");
                backgroundImage = new ImageIcon(imgURL).getImage();
            } catch (Exception e) {
                System.out.println("Background image not found.");
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(
                    backgroundImage,
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    this
                );
            }
        }
    }
}


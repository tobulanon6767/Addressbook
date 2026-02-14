/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addressbook;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;

public class menuOne extends JFrame {

    private final BackgroundPanel bg;
    private Font horizonFont;

    public menuOne() {

        setTitle("Get2Know Gravi – Menu One");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);

        loadHorizonFont();

        bg = new BackgroundPanel();
        bg.setLayout(null);
        setContentPane(bg);

        initUI();
    }

    private void loadHorizonFont() {
        try {
            InputStream is = getClass().getResourceAsStream("/addressbook/Horizon.otf");
            if (is == null) throw new Exception("Font not found");

            Font base = Font.createFont(Font.TRUETYPE_FONT, is);
            horizonFont = base;

            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(base);

        } catch (Exception e) {
            horizonFont = new Font("SansSerif", Font.BOLD, 22);
        }
    }

    private void initUI() {

        JLabel classList = new JLabel("> CLASSLIST");
        classList.setFont(horizonFont.deriveFont(34f));
        classList.setForeground(Color.WHITE);
        classList.setBounds(55, 165, 500, 50);
        bg.add(classList);

        int startY = 200;
        int spacing = 59;      
        int x = 70;
        int width = 700;
        int height = 105;

        int currentY = startY;

        String[] names = {
                "ANDREI JEMS A. TRAPERO",
                "THERENCE KYLE O. BULANON",
                "ACE JACOB A. BICOY",
                "MATT CHERUB OMLANG",
                "ZAIJAN SEAN A. BICOY"
        };

        for (int i = 0; i < names.length; i++) {

            JButton btn = createNameButton(names[i]);
            btn.setBounds(x, currentY, width, height);

            int index = i; 

            btn.addActionListener(e -> {
                dispose(); 

                switch (index) {
                    case 0 -> new profileOne().setVisible(true);
                    case 1 -> new profileTwo().setVisible(true);
                    case 2 -> new profileThree().setVisible(true);
                    case 3 -> new profileFour().setVisible(true);
                    case 4 -> new profileFive().setVisible(true);
                }
            });

            bg.add(btn);
            currentY += spacing;  
        }
    }

    private JButton createNameButton(String text) {
        JButton btn = new JButton(text);

        btn.setFont(horizonFont.deriveFont(28f));
        btn.setForeground(Color.WHITE);

        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);

        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return btn;
    }

    class BackgroundPanel extends JPanel {

        private Image img;

        public BackgroundPanel() {
            try {
                URL url = getClass().getResource("/addressbook/menubg.jpg");
                if (url != null)
                    img = new ImageIcon(url).getImage();
            } catch (Exception e) {
                System.out.println("Background failed.");
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null)
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}


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

                String info = "";

    switch (index) {
        case 0 -> info =
                "Name: ANDREI JEMS A. TRAPERO\n" +
                "Course: BSIT\n" +
                "Year: 2nd Year\n" +
                "Email: andrei@email.com\n" +
                "Phone: 09123456789";

        case 1 -> info =
                "Name: THERENCE KYLE O. BULANON\n" +
                "Course: BSIT\n" +
                "Year: 2nd Year\n" +
                "Email: therence@email.com\n" +
                "Phone: 09111111111";

        case 2 -> info =
                "Name: ACE JACOB A. BICOY\n" +
                "Course: BSIT\n" +
                "Year: 2nd Year\n" +
                "Email: ace@email.com\n" +
                "Phone: 09222222222";

        case 3 -> info =
                "Name: MATT CHERUB OMLANG\n" +
                "Course: BSIT\n" +
                "Year: 2nd Year\n" +
                "Email: matt@email.com\n" +
                "Phone: 09333333333";

        case 4 -> info =
                "Name: ZAIJAN SEAN A. BICOY\n" +
                "Course: BSIT\n" +
                "Year: 2nd Year\n" +
                "Email: zaijan@email.com\n" +
                "Phone: 09444444444";
    }

    new StudentInfoPage(names[index], info).setVisible(true);
                
            });

            bg.add(btn);
            currentY += spacing;  
        }
        JButton creatorsButton = new JButton("CREATORS");
        creatorsButton.setFont(horizonFont.deriveFont(18f));
        creatorsButton.setForeground(Color.WHITE);
        creatorsButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        creatorsButton.setContentAreaFilled(false);
        creatorsButton.setFocusPainted(false);
        creatorsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        creatorsButton.setBounds(800, 50, 150, 40);

        creatorsButton.addActionListener(e -> {
            dispose();
            new Creator1().setVisible(true);
        });

        bg.add(creatorsButton);
    
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

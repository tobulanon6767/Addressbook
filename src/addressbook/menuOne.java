package addressbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class menuOne extends JFrame {

    private final BackgroundPanel bg;
    private Font horizonFont;

    private JButton prevBtn, nextBtn;
    private JLabel pageLabel;

    private ArrayList<JButton> nameButtons = new ArrayList<>();

    private String[] names = {
            "ANDREI JEMS A. TRAPERO",
            "THERENCE KYLE O. BULANON",
            "ACE JACOB A. BICOY",
            "MATT CHERUB OMLANG",
            "ZAIJAN SEAN A. BICOY",
            "STUDENT 6",
            "STUDENT 7",
            "STUDENT 8",
            "STUDENT 9",
            "STUDENT 10",
            "STUDENT 11",
            "STUDENT 12",
            "STUDENT 13",
            "STUDENT 14",
            "STUDENT 15",
            "STUDENT 16",
            "STUDENT 17",
            "STUDENT 18",
            "STUDENT 19",
            "STUDENT 20",
            "STUDENT 21",
            "STUDENT 22",
            "STUDENT 23",
            "STUDENT 24",
            "STUDENT 25",
            "STUDENT 26",
            "STUDENT 27",
            "STUDENT 28",
            "STUDENT 29",
            "STUDENT 30"
            
    };

    private int currentPage = 1;
    private final int studentsPerPage = 5;

    public menuOne() {

        setTitle("Get2Know Gravi – Menu One");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            Font base = Font.createFont(Font.TRUETYPE_FONT, is);
            horizonFont = base;
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(base);
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

        int startY = 220;
        int spacing = 60;
        int x = 70;
        int width = 700;
        int height = 40;

        // Create reusable buttons
        for (int i = 0; i < studentsPerPage; i++) {
            JButton btn = createNameButton("");
            btn.setBounds(x, startY + (i * spacing), width, height);
            nameButtons.add(btn);
            bg.add(btn);
        }

        // PAGE CONTROLS
        prevBtn = new JButton("<");
        nextBtn = new JButton(">");
        pageLabel = new JLabel("1", SwingConstants.CENTER);

        prevBtn.setBounds(430, 500, 50, 30);
        pageLabel.setBounds(490, 500, 40, 30);
        pageLabel.setForeground(Color.WHITE);
pageLabel.setFont(horizonFont.deriveFont(20f));
pageLabel.setOpaque(true);
pageLabel.setBackground(new Color(0,0,0,120));

        nextBtn.setBounds(540, 500, 50, 30);

        bg.add(prevBtn);
        bg.add(pageLabel);
        bg.add(nextBtn);

        prevBtn.addActionListener(e -> changePage(-1));
        nextBtn.addActionListener(e -> changePage(1));

        loadPage();
    }

    private void changePage(int direction) {

        int maxPage = (int) Math.ceil((double) names.length / studentsPerPage);

        currentPage += direction;

        if (currentPage < 1) currentPage = 1;
        if (currentPage > maxPage) currentPage = maxPage;

        pageLabel.setText(String.valueOf(currentPage));

        loadPage();
    }

    private void loadPage() {

        int startIndex = (currentPage - 1) * studentsPerPage;

        for (int i = 0; i < nameButtons.size(); i++) {

            int studentIndex = startIndex + i;
            JButton btn = nameButtons.get(i);

            if (studentIndex < names.length) {

                btn.setText(names[studentIndex]);
                btn.setVisible(true);

                for (ActionListener al : btn.getActionListeners()) {
                    btn.removeActionListener(al);
                }

                int indexCopy = studentIndex;

                btn.addActionListener(e -> {

                    String info =
                            "Name: " + names[indexCopy] + "\n" +
                            "Course: BSIT\n" +
                            "Year: 2nd Year\n" +
                            "Email: student@email.com\n" +
                            "Phone: 09123456789";

                    new StudentInfoPage(names[indexCopy], info).setVisible(true);
                    dispose();
                });

            } else {
                btn.setVisible(false);
            }
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

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null)
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

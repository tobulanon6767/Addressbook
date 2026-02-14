package addressbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentInfoPage extends JFrame {

    private BackgroundPanel bg;
    private JTextField searchField;
    private JLabel infoLabel;
    private JLabel nameLabel;
    private JTextArea infoArea;
    private JLabel photoFrame;

    public StudentInfoPage(String studentName, String infoText) {

        setTitle("Student Information");
        setSize(900, 550);
        setMinimumSize(new Dimension(700, 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        bg = new BackgroundPanel();
        bg.setLayout(null);
        setContentPane(bg);

        initUI(studentName, infoText);
        addResizeListener();
    }

    private void initUI(String studentName, String infoText) {

        // > INFORMATION label
        infoLabel = new JLabel("> INFORMATION");
        infoLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        infoLabel.setForeground(Color.WHITE);
        bg.add(infoLabel);

        // Search box (top-right)
        searchField = new JTextField();
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);
        searchField.setBackground(new Color(0,0,0,0));
        searchField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        bg.add(searchField);

        // Student Name
        nameLabel = new JLabel(studentName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        nameLabel.setForeground(Color.WHITE);
        bg.add(nameLabel);

        // Information text
        infoArea = new JTextArea(infoText);
        infoArea.setForeground(Color.WHITE);
        infoArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        infoArea.setOpaque(false);
        infoArea.setEditable(false);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        bg.add(infoArea);

        // Photo frame placeholder
        photoFrame = new JLabel();
        photoFrame.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        bg.add(photoFrame);

        updateLayout();
    }

    // Layout scaling to match background proportions
    private void updateLayout() {

        int w = getWidth();
        int h = getHeight();

        // INFORMATION label
        infoLabel.setBounds(
                (int)(w * 0.08),
                (int)(h * 0.17),
                300,
                30
        );

        // Search field
        searchField.setBounds(
                (int)(w * 0.70),
                (int)(h * 0.17),
                (int)(w * 0.18),
                25
        );

        // Student name
        nameLabel.setBounds(
                (int)(w * 0.12),
                (int)(h * 0.30),
                (int)(w * 0.50),
                40
        );

        // Info text block
        infoArea.setBounds(
                (int)(w * 0.12),
                (int)(h * 0.38),
                (int)(w * 0.45),
                (int)(h * 0.30)
        );

        // Photo frame
        photoFrame.setBounds(
                (int)(w * 0.62),
                (int)(h * 0.35),
                (int)(w * 0.22),
                (int)(h * 0.28)
        );
    }

    private void addResizeListener() {
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                updateLayout();
            }
        });
    }

    // Background panel
    class BackgroundPanel extends JPanel {

        private Image img;

        public BackgroundPanel() {
            img = new ImageIcon(
                    getClass().getResource("/addressbook/menubg.jpg")
            ).getImage();
        }

        protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

    // Cover middle white lines
    g.setColor(Color.BLACK);
    g.fillRect(
        (int)(getWidth() * 0.04),
        (int)(getHeight() * 0.45),
        (int)(getWidth() * 0.9),
        (int)(getHeight() * 0.42)
    );
}

    }
}

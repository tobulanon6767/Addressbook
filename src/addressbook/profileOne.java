/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addressbook;

import javax.swing.*;
import java.awt.*;

public class profileOne extends JFrame {

    public profileOne() {
        setTitle("Profile One");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Profile One - Placeholder", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        add(label);
    }
}

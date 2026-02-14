/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addressbook;

import javax.swing.*;
import java.awt.*;

public class profileTwo extends JFrame {

    public profileTwo() {
        setTitle("Profile Two");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Profile Two - Placeholder", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        add(label);

        setVisible(true);
    }
}

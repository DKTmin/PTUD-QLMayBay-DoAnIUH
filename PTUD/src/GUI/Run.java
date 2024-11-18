/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ADMIN
 */
public class Run {

    public static void main(String[] args) {
        GUI_HOME_QuanLy a = new GUI_HOME_QuanLy();
        a.setVisible(true);
        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
        a.setUndecorated(true);
        a.setVisible(true);
    }
}

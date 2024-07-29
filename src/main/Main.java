package main;

import ui.AuthenticationScreen;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.*;
import ui.ShopScreen;

public final class Main extends JFrame implements UICallBack{

    private final JPanel form;
    
    private final Device device = new Device();

    public Main() {
        form = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        form.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(form, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1014, 637));
        setLocationRelativeTo(null);
                
        if (!device.isSignedIn(Device.getDeviceName())) {
            init(new AuthenticationScreen(this));
        } else {
            init(new ShopScreen());
        }
    }
    
    public void init(JPanel panel){
        form.removeAll();
        form.add(panel);
        form.revalidate();
        form.repaint();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());

            SwingUtilities.invokeLater(()-> new Main().setVisible(true));

        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("UnsupportedLookAndFeelException -> " + e.getMessage());
        }
    }

    @Override
    public void callBack() {
        init(new ShopScreen());
    }

}

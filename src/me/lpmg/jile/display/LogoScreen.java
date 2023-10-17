package me.lpmg.jile.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import me.lpmg.jile.gfx.ImageLoader;
import me.lpmg.jile.utils.AudioHandler;

/**
 *
 * @author lpmg
 */
public class LogoScreen extends javax.swing.JFrame {

	private javax.swing.JLabel imageIcon;
	
    public LogoScreen() {
    	setTitle("LOADING");
    	setIconImage(ImageLoader.loadImage("/logo/own-logo.png"));
        initComponents();
        makeTransparent();
        //playSound();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        closeFrame();
    }
                    
    private void initComponents() {

    	imageIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //TODO
        //JAVA 12
        //ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("logo/lpmggamestudios.gif"));
        
        //JAVA 8
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("logo/own-logo.png"));
        
        imageIcon.setIcon(image);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageIcon)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageIcon)
        );

        pack();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    } 
    
    private void playSound() {
    	//AudioHandler audioHandler= new AudioHandler(null);
    	//audioHandler.playSound("/audio/KRLogo.wav", false);
    }
    
    private void makeTransparent(){
        dispose();
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));       
        setVisible(true);
    }
    
    private void closeFrame() {
    	dispose();
    }
}

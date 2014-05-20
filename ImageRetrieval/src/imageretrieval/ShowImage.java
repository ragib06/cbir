/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageretrieval;

/**
 *
 * @author nautilus
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class ShowImage extends Panel {

    BufferedImage image;
    String imageName;
    String imageText;
    int width,height;

    public ShowImage(String imageDir, String imageFile, String text, int maxHW) {
        try {
            this.imageName = imageFile;
            this.imageText = text;
            File input = new File(imageDir+imageFile);
            image = ImageIO.read(input);
            int h = image.getHeight();
            int w = image.getWidth();
            if(h>w){
                width = maxHW*w/h;
                height = maxHW;
            }else{
                height = maxHW*h/w;
                width = maxHW;
            }
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
    }

    @Override
    public void paint(Graphics g) {
//        //g.drawImage(image, 0, 0, null);
        
        g.drawString(this.imageName, 0, 10);
        g.drawImage(this.image, 0, 15, width, height, this);
        g.drawString(this.imageText, 0, height+30);
        
    }
}

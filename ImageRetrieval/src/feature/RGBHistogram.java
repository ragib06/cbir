/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package feature;

/**
 *
 * @author nautilus
 */
public class RGBHistogram {
    private int red;
    private int green;
    private int blue;

    public RGBHistogram() {
    }

    public RGBHistogram(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }
}

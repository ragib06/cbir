/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chart;

/**
 *
 * @author nautilus
 */
public class XYData {
    private double xCord;
    private double yCord;

    public XYData(double xCord, double yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public XYData() {
        this.xCord = 0;
        this.yCord = 0;
    }

    public double getxCord() {
        return xCord;
    }

    public void setxCord(double xCord) {
        this.xCord = xCord;
    }

    public double getyCord() {
        return yCord;
    }

    public void setyCord(double yCord) {
        this.yCord = yCord;
    }
    
}

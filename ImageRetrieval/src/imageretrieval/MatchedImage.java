/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imageretrieval;

/**
 *
 * @author nautilus
 */
public class MatchedImage {
    private String image;
    private double distance;

    public MatchedImage() {
    }

    public MatchedImage(String image, double distance) {
        this.image = image;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

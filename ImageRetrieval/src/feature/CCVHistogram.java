/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package feature;

/**
 *
 * @author nautilus
 */
public class CCVHistogram {
    private double alpha;
    private double beta;

    public CCVHistogram(double alpha, double beta) {
        this.alpha = alpha;
        this.beta = beta;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }
    
}

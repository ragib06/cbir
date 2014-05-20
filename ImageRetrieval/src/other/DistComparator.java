/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package other;
import java.util.Comparator;
import imageretrieval.MatchedImage;
/**
 *
 * @author nautilus
 */
public class DistComparator implements Comparator{

    public int compare(Object me1, Object me2){

        double dist1 = ((MatchedImage)me1).getDistance();
        double dist2 = ((MatchedImage)me2).getDistance();

        if(dist1 > dist2)
            return 1;
        else if(dist1 < dist2)
            return -1;
        else
            return 0;
    }
}

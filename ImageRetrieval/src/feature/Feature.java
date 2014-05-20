/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package feature;

import java.util.Vector;

/**
 *
 * @author nautilus
 */
public interface Feature {
    //loads the specified database in 'dataDir' path with pregenerated data files
    public void loadDatabase(String dataDir);
    //returns 'Vector<MatchedImage>' matching the source 'image'
    public Vector searchImage(String image);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package feature;
/**
 *
 * @author nautilus
 */
public class FeatureFactory {
    public Feature getFeature(String criteria){
        if(criteria.compareTo("Histogram")==0){
            return new Histogram();
        }else if(criteria.compareTo("Color Structure Descriptor")==0){
            return new ColorStructureDescriptor();
        }else if(criteria.compareTo("Color Coherence Vector")==0){
            return new ColorCoherenceVector();
        }
        return null;
    }
}

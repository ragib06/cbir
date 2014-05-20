/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chart;

import java.util.Vector;

/**
 *
 * @author nemo
 */
public class XYDataSet {
    String title;
    Vector<XYData> data;

    public XYDataSet() {
    }
    
    public Vector<XYData> getData() {
        return data;
    }

    public void setData(Vector<XYData> data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package feature;

import imageretrieval.MatchedImage;
import java.io.FileNotFoundException;
import java.util.Vector;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Collections;
import java.util.StringTokenizer;

import other.DistComparator;

/**
 *
 * @author nautilus
 */
public class ColorCoherenceVector implements feature.Feature{
    private final String CCVDATASOURCE = "ccv.csv";

    private int numberOfBins;
    private int numberOfImages;
    private Vector bins;
    private Vector database;
    private Vector images;

    public ColorCoherenceVector() {
        this.bins = new Vector();
        this.database = new Vector();
        this.images = new Vector();
    }
    
    public void loadDatabase(String dataDir) {
        File data = new File(dataDir+this.CCVDATASOURCE);
        Scanner scn;
        try {
            scn = new Scanner(new FileInputStream(data));
            this.numberOfImages = scn.nextInt();
            this.numberOfBins = scn.nextInt();
            scn.nextLine();                                 //gobble the left newline from buffer
            System.out.println("images: "+this.numberOfImages+"  bins: " + this.numberOfBins);

            int i,j;
            for(i=0;i<this.numberOfImages;i++){
                StringTokenizer st = new StringTokenizer(scn.nextLine(),",\t ");
                this.images.add(st.nextToken());

                Vector imagedata = new Vector();
                for(j=0;j<this.numberOfBins;j++){
                    imagedata.add(new CCVHistogram(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())));
                }
                this.database.add(imagedata);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Vector searchImage(String image) {
        int queryImage = this.images.indexOf(image);
        Vector<CCVHistogram> ccvQ = ((Vector<CCVHistogram>)this.database.get(queryImage));
        Vector<MatchedImage> imdists = new Vector<MatchedImage>();
        int i,j;
        for(i=0;i<this.images.size();i++){
            double sum=0;
            for(j=0;j<this.numberOfBins;j++){
                CCVHistogram ccv = ((Vector<CCVHistogram>)this.database.get(i)).get(j);
                sum += Math.abs(ccv.getAlpha()-ccvQ.get(j).getAlpha());
                sum += Math.abs(ccv.getBeta()-ccvQ.get(j).getBeta());
            }
            sum = Double.parseDouble(String.format("%.5g%n", sum));
            imdists.add(new MatchedImage(images.get(i).toString(),sum));
            //System.out.println("imdists: "+ imdists.get(imdists.size()-1).getImage());
        }
        DistComparator dc = new DistComparator();
        Collections.sort(imdists, dc);

        return imdists;
    }

}

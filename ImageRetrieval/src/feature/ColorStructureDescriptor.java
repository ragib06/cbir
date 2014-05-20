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
public class ColorStructureDescriptor implements feature.Feature{

    private final String CSDDATASOURCE = "csd.csv";

    private int numberOfBins;
    private int numberOfImages;
    private Vector bins;
    private Vector database;
    private Vector images;

    public ColorStructureDescriptor() {
        this.bins = new Vector();
        this.database = new Vector();
        this.images = new Vector();
    }

    public void loadDatabase(String dataDir) {
        File data = new File(dataDir+this.CSDDATASOURCE);
        Scanner scn;
        try {
            scn = new Scanner(new FileInputStream(data));
            this.numberOfImages = scn.nextInt();
            this.numberOfBins = scn.nextInt();
            scn.nextLine();                                 //gobble the left newline from buffer
            System.out.println("images: "+this.numberOfImages+"  bins: " + this.numberOfBins);

            int i,j;
            for(i=0;i<this.numberOfImages;i++){
                StringTokenizer st = new StringTokenizer(scn.nextLine(),",");
                this.images.add(st.nextToken());

                Vector imagedata = new Vector();
                for(j=0;j<this.numberOfBins;j++){
                    //imagedata.add(new RGBHistogram(scn.nextInt(),scn.nextInt(),scn.nextInt()));
                    imagedata.add(Double.parseDouble(st.nextToken()));
                }
                this.database.add(imagedata);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Vector searchImage(String image) {
        int queryImage = this.images.indexOf(image);
        Vector<Double> rgbQ = (Vector<Double>)this.database.get(queryImage);
        Vector<MatchedImage> imdists = new Vector<MatchedImage>();
        int i,j;
        for(i=0;i<this.images.size();i++){
            double sum=0;
            for(j=0;j<this.numberOfBins;j++){
//                RGBHistogram rgb = ((Vector<RGBHistogram>)this.database.get(i)).get(j);
//                sum += Math.abs(rgb.getRed()-rgbQ.get(j).getRed());
//                sum += Math.abs(rgb.getGreen()-rgbQ.get(j).getGreen());
//                sum += Math.abs(rgb.getBlue()-rgbQ.get(j).getBlue());
                double hist = ((Vector<Double>)this.database.get(i)).get(j);
                sum += Math.abs(rgbQ.get(j) - hist);
            }
            //System.out.println("CSD: sum-> "+sum);
            sum = Double.parseDouble(String.format("%.5g%n", sum));
            imdists.add(new MatchedImage(images.get(i).toString(),sum));
            //System.out.println("imdists: "+ imdists.get(imdists.size()-1).getImage());
        }
        DistComparator dc = new DistComparator();
        Collections.sort(imdists, dc);

        return imdists;
    }
}

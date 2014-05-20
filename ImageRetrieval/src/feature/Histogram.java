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
public class Histogram implements feature.Feature{
    
    //private final String HISTDATASOURCE = "histogram.txt";
    private final String HISTDATASOURCE = "histogram.csv";
    private int NUMBEROFPIXELS = 128*192;

    private int numberOfBins;
    private int numberOfImages;
    private Vector bins;
    private Vector database;
    private Vector images;

    public Histogram() {
        this.bins = new Vector();
        this.database = new Vector();
        this.images = new Vector();
    }

    public void loadDatabase(String dataDir){
        System.out.println("loading feature database: "+dataDir+this.HISTDATASOURCE);
        File data = new File(dataDir+this.HISTDATASOURCE);
        
        Scanner scn;
        try {
            scn = new Scanner(new FileInputStream(data));
            
            this.numberOfImages = scn.nextInt();
            this.numberOfBins = scn.nextInt();
            scn.nextLine();                                 //gobble the left newline from buffer
            System.out.println("images: "+this.numberOfImages+"  bins: " + this.numberOfBins);

            long start = System.currentTimeMillis();
            System.out.println("loop start: "+start);
            int i,j;
            for(i=0;i<this.numberOfImages;i++){
                StringTokenizer st = new StringTokenizer(scn.nextLine(),",");

                this.images.add(st.nextToken());

                Vector<Double> imagedata = new Vector<Double>();
                for(j=0;j<this.numberOfBins;j++){
                    //imagedata.add(new RGBHistogram(scn.nextInt(),scn.nextInt(),scn.nextInt()));
                    imagedata.add(Double.parseDouble(st.nextToken()));
                }
                this.database.add(imagedata);
            }
            long end = System.currentTimeMillis();
            System.out.println("loop end: "+end);

            System.out.println("time: "+(end-start)/1000.0);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public Vector searchImage(String image){
        
        int queryImage = this.images.indexOf(image);
        //Vector<RGBHistogram> rgbQ = ((Vector<RGBHistogram>)this.database.get(queryImage));
        Vector<Double> rgbQ = (Vector<Double>)this.database.get(queryImage);
        Vector<MatchedImage> imdists = new Vector<MatchedImage>();
        int i,j;
        for(i=0;i<this.images.size();i++){
            double sum=0.0;
            for(j=0;j<this.numberOfBins;j++){
                //RGBHistogram rgb = ((Vector<RGBHistogram>)this.database.get(i)).get(j);
                //sum += Math.abs(rgb.getRed()-rgbQ.get(j).getRed());
                //sum += Math.abs(rgb.getGreen()-rgbQ.get(j).getGreen());
                //sum += Math.abs(rgb.getBlue()-rgbQ.get(j).getBlue());

                double hist = ((Vector<Double>)this.database.get(i)).get(j);
                sum += Math.abs(rgbQ.get(j) - hist);
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


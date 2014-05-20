/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chart;

import java.util.Vector;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author nautilus
 */

public class CreateChart extends JFrame {

	private static final long serialVersionUID = 1L;

	public CreateChart(Vector<XYDataSet> dataSet, String applicationTitle, String chartTitle, String xLabel, String yLabel) {
        super(applicationTitle);
        // This will create the dataset
        XYSeriesCollection dataset = createDataset(dataSet);
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle, xLabel, yLabel);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
        // add it to our application
        setContentPane(chartPanel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * Creates dataset
     */
    private  XYSeriesCollection createDataset(Vector<XYDataSet> dataSet) {
        
        //series.add(10, 1);
        XYSeriesCollection dataCollection = new XYSeriesCollection();
        for(int i=0;i<dataSet.size();i++){
            XYDataSet currentDataSet = dataSet.get(i);
            XYSeries series = new XYSeries(currentDataSet.getTitle());
            Vector<XYData> currentData = currentDataSet.getData();

            for(int j=0;j<currentData.size();j++){
                series.add(currentData.get(j).getxCord(),currentData.get(j).getyCord());
            }
            dataCollection.addSeries(series);
        }
        
        return dataCollection;
    }

    /**
     * Creates a chart
     */
    private JFreeChart createChart(XYSeriesCollection dataset, String title, String xLabel, String yLabel) {

        JFreeChart chart = ChartFactory.createXYLineChart(title, // Title
                xLabel, // x-axis Label
                yLabel, // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
            );

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setForegroundAlpha(0.9f);
        plot.setBackgroundAlpha(0.2f);
        return chart;
    }
}


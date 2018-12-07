/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussian;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author mokro
 */
public class DrawPanel {
    public static JFreeChart myChart;
    private static JFreeChart createChart(XYDataset dataset)
    {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "", "", 
                "", dataset, PlotOrientation.VERTICAL,
                true, false, false);
        chart.setBackgroundPaint(Color.lightGray);
        
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);
        
        return chart;
    }
    private static XYDataset createDataset() 
    {
        XYSeries g = new XYSeries("Krzywa Gaussa");
        double x,y;
        double step=0.01;
        double range=7/step;
//        if(Data.variance>=1){
//            range*=Data.variance;
//        }
        range*=Math.sqrt(Data.variance);
        for(int i=0; i<=range; i++){
            x=-range/2*step+Data.expectedValue+i*step;
            y=1/Math.sqrt(2*Math.PI*Data.variance)*Math.exp(-Math.pow(x-Data.expectedValue, 2)/(2*Data.variance));
            g.add(x,y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(g);
        return dataset;
    }
    
    public static JPanel createWoPanel() {
        myChart = createChart(createDataset());
        return new ChartPanel(myChart);
    }
}

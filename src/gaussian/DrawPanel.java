/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussian;

import java.awt.Color;
import java.awt.Shape;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author mokro
 */
public class DrawPanel {
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
        
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        Shape sh = renderer.getSeriesShape(1);
        renderer.setSeriesShape(2, sh);
        renderer.setSeriesShapesVisible(2, true);
        renderer.setSeriesLinesVisible(2, false);
        return chart;
    }
    private static XYDataset createDataset() 
    {
        XYSeries g = new XYSeries("Krzywa Gaussa");
        //g.add(x,y);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(g);
        return dataset;
    }
    
    public static JPanel createWoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
}

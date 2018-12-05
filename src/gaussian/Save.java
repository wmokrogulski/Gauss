/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussian;

import java.io.File;
import java.io.IOException;
import static org.jfree.chart.ChartUtilities.saveChartAsJPEG;
/**
 *
 * @author Arek
 */
public class Save {
    public static void saveChart() throws IOException{
        File file=new File("chart.jpeg");
        saveChartAsJPEG(file, DrawPanel.myChart, 450, 200);
    }
}

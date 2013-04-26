package jasper;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;

import java.util.*;
 
public class JasperTest {
 
    public static void main(String[] args) {
        String fileName = "acc_user.jasper";
        String outFileName = "acc_user.pdf";
        HashMap hm = new HashMap();
        try {
            // Fill the report using an empty data source
            JasperPrint print = JasperFillManager.fillReport(fileName, hm, new JREmptyDataSource());
 
            // Create a PDF exporter
            JRExporter exporter = new JRPdfExporter();
            //JRExporter exporter2=new JExcelApiExporter();
            
 
            // Configure the exporter (set output file name and print object)
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
 
            // Export the PDF file
            exporter.exportReport();
 
        } catch (JRException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
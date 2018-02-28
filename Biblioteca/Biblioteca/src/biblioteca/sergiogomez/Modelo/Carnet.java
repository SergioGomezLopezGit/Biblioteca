/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.Modelo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sergio
 */
public class Carnet {
    public Carnet(Integer id) throws ClassNotFoundException{
        try {
            Map hashmap=new  HashMap();
            hashmap.put("id_usuario", id);
                                                 
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
            URL url= getClass().getResource("../informes/carnet.jasper");
            
            JasperReport reporte=(JasperReport) JRLoader.loadObject(url);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, hashmap, conexion);
            
            JRPdfExporter exporter = new JRPdfExporter();     
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint)); 
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new java.io.File("carnetPDF.pdf")));
            exporter.exportReport();
            
            JasperViewer jasperViewer=new JasperViewer(jasperPrint);
            jasperViewer.setVisible(true);
        } catch (SQLException ignore) {
            ignore.printStackTrace();
        } catch (JRException ex) {
            Logger.getLogger(Carnet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

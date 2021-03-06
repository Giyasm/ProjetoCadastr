/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gerarrelatorio;

import java.io.InputStream;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import client.Cliente;

/**
 * Classe criada para
 * @since 27/06/2018 as 22:39:31
 */
public class Report {
    public void report(List<Cliente> lista) throws JRException{
    
    InputStream fonte = Report.class.getResourceAsStream("/reporte/Report.jrxml");
    
    JasperReport report = JasperCompileManager.compileReport(fonte);
    JasperPrint print = JasperFillManager.fillReport(report,null, new JRBeanCollectionDataSource(lista));
    JasperViewer.viewReport(print,false);        
            };

}

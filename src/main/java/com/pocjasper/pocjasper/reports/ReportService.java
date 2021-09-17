package com.pocjasper.pocjasper.reports;

import com.pocjasper.pocjasper.entities.User;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Component
public class ReportService {


    public void export(String format, List<User> users) throws JRException, FileNotFoundException {

        String path = "/home/dfaria/Desktop";

        File file = ResourceUtils.getFile("./exemplo-relatorio.jrxml");

        JasperReport jasperReport
                = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(users);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, datasource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/users.pdf");

    }
}

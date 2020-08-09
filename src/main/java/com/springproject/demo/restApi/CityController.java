package com.springproject.demo.restApi;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.springproject.demo.Business.ICityService;
import com.springproject.demo.Entities.AdresReportService;
import com.springproject.demo.Entities.City;
import com.springproject.demo.auth.TokenManager;
import com.springproject.demo.restApi.dto.LoginRequest;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cities")
public class CityController  {
private final ICityService cityService;
private final AdresReportService adresReportService;
private  final AuthenticationManager authenticationManager;
private final TokenManager tokenManager;
    @Autowired
    public CityController(ICityService cityService, AdresReportService adresReportService, AuthenticationManager authenticationManager, TokenManager tokenManager) {
        this.cityService = cityService;
        this.adresReportService = adresReportService;
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest)
    {
        try {
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

return  ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUsername()));
        }
        catch (Exception e){
            throw  e;
        }

    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Litesoft";
        List<City> employees = cityService.getAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:adres.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Fahir ÖZBAY");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\adres.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\adres.pdf");
        }

        return "report generated in path : " + path;
    }
    @GetMapping("/getReport")
    public String getr() throws FileNotFoundException, JRException {
        return exportReport("pdf");
    }
    @GetMapping("/mesaj")
    public String getmsaj(){

        try {
            Document document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("MerhabaDunya.pdf"));
            document.open();
            document.add(new Paragraph("Merhaba dünya"));
            document.addAuthor("Fahir ÖZBAY");
            document.addCreator("Fahir ÖZBAY");
            document.addCreationDate();
            document.addTitle("Başlık");
            document.addSubject("İçerik");
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            for (int i = 1; i < 11; i++) {
                PdfPCell cell = new PdfPCell(new Paragraph(i + " Fahir ÖZBAY"));
                cell.setBorderColor(BaseColor.BLACK);
                cell.setPadding(10f);
                table.addCell(cell);
            }

            document.add(table);
            Chapter chapter = new Chapter("1. Bölüm", 1);
            chapter.add(new Paragraph("1. Bölüm içeriği"));
            document.add(chapter);
            Chapter chapter1 = new Chapter("2. Bölüm", 2);
            chapter1.add(new Paragraph("2. Bölüm içeriği"));
            document.add(chapter1);
            document.close();
            pdfWriter.close();
        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return "Mesaj";
    }
    @GetMapping()
    public List<City> get(){
    return cityService.getAll();
    }
    @PostMapping("/add")
    public City add(@RequestBody City city){return  cityService.add(city);}
    @PostMapping("/update")
    public void update(@RequestBody City city){
        cityService.update(city);
    }
    @PostMapping("/delete")
    public void delete(@RequestBody City city){
        cityService.delete(city);
    }
    @GetMapping("/{id}")
    public  City getById(@PathVariable int id){
        return cityService.getById(id);
    }
    @GetMapping("/findAll/{columnName}/{value}")
    public  Iterable<City> findAll(@PathVariable String columnName,@PathVariable String value){return  cityService.findAll(columnName, value,"");}
    @GetMapping("/findAllOrderByColumnName/{columnName}/{value}/{orderColumn}")
    public  Iterable<City> findAllOrderByColumnName(@PathVariable String columnName,@PathVariable String value,@PathVariable String orderColumn){return  cityService.findAll(columnName, value,orderColumn);

    }
}

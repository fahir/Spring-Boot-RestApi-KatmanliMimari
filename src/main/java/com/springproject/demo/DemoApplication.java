package com.springproject.demo;

import com.springproject.demo.Entities.AdresReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;

@SpringBootApplication
public class DemoApplication {
	private final AdresReportService adresReportService;
@Autowired
	public DemoApplication(AdresReportService adresReportService) {
		this.adresReportService = adresReportService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}





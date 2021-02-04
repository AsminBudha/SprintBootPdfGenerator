package com.treeleaf.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.jboss.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.treeleaf.payload.response.LocationDetailsResponse;
import com.treeleaf.payload.response.VehicleDetailsResponse;

public class PDFGenerator {
	
	public static ByteArrayInputStream generatePDF(VehicleDetailsResponse vehicleDetails) {
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			
			PdfWriter.getInstance(document, out);
			document.open();
			
			Paragraph p = new Paragraph("Vechile Number: " + vehicleDetails.getVehicleNumber() + "\n");
			p.add("\n");
			p.add("Location Details:\n");
			document.add(p);
			int x = 1;
			for(LocationDetailsResponse locationDetails : vehicleDetails.getLocationDetails()) {
				Paragraph pp = new Paragraph();
				pp.add("  " + x +")  " +  locationDetails.getLocationName() + ": \n");
				pp.add("        Camara id \n");
				pp.add("            {\n");
				pp.add("                ");
				for(int i = 0;i<locationDetails.getCamaraDetails().size();i++) {
					pp.add(locationDetails.getCamaraDetails().get(i));
					if(i != locationDetails.getCamaraDetails().size()-1)pp.add(",");
				}
				pp.add("\n            } \n");
				document.add(pp);
				x++;
			}
			document.close();
			
		}catch (DocumentException ex) {
			Logger.getLogger(PDFGenerator.class.getName());
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
}

package com.treeleaf.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.treeleaf.payload.response.MessageResponse;
import com.treeleaf.payload.response.VehicleDetailsResponse;
import com.treeleaf.services.IAdminService;
import com.treeleaf.services.PDFGenerator;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	IAdminService adminService;
	
	@GetMapping("/vehicle-details/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public VehicleDetailsResponse getDetails(@PathVariable Long id){
		return adminService.getDetails(id);
	}
	
	@RequestMapping(value="/vehicle-details/{id}/pdf",method = RequestMethod.GET,produces = MediaType.APPLICATION_PDF_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getPDF(@PathVariable Long id){
		VehicleDetailsResponse vehicleDetails = adminService.getDetails(id);
		System.out.println(vehicleDetails);
		if(vehicleDetails.getStatus().equals("NOT_FOUND")) {
			return ResponseEntity.badRequest().body(new MessageResponse("Vehicle not found"));
		}
		System.out.println("first Hello world");
		ByteArrayInputStream bais = PDFGenerator.generatePDF(adminService.getDetails(id));
		System.out.println("hello world");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Vehicle-Details", "inline; filename=vehicleDetails.pdf");
		return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bais));
	}
}

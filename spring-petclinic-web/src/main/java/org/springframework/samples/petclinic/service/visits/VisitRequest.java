package org.springframework.samples.petclinic.service.visits;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class VisitRequest {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate visitDate;

	private String description;

}

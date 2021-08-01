package org.springframework.samples.petclinic.service.customers;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PetRequest {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	private String name;

	private Integer typeId;

}

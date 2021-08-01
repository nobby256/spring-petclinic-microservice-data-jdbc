package org.springframework.samples.petclinic.owner;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class VisitForm {

	private boolean isCreate;

	@NotEmpty
	private String visitDate;

	@NotEmpty
	private String description;

}

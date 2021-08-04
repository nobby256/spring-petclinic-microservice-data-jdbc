/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.visit.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Simple JavaBean domain object representing a visit.
 *
 * @author Ken Krebs
 * @author Dave Syer
 * @author Maciej Walkowiak
 */
@Data
@EqualsAndHashCode
@ToString
public class Visit implements Serializable {

	@Id
	private Integer id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate visitDate;

	@NotEmpty
	private String description;

	private Integer petId;

}

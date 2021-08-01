package org.springframework.samples.petclinic.service.customers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import feign.Param;

public interface PetServiceApi {

	@GetMapping(path = "/petTypes")
	List<PetType> getPetTypes();

	@PostMapping(path = "/owners/{ownerId}/pets")
	@ResponseStatus(HttpStatus.CREATED)
	Pet createPet(@RequestBody PetRequest petRequest, @PathVariable("ownerId") int ownerId);

	@PutMapping(path = "/owners/{ownerId}/pets/{petId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void updatePet(@RequestBody PetRequest petRequest, @PathVariable("ownerId") int ownerId, @PathVariable("petId") int petId);

	@GetMapping(path = "owners/*/pets/{petId}")
	Pet findPetByPetId(@PathVariable("petId") int petId);

	@GetMapping(path = "owners/{ownerId}/pets", params = { "petName" })
	List<Pet> findPetByOwnerIdAndPetName(@Param("ownerId") int ownerId, @Param("petName") String petName);

	@GetMapping(path = "owners/{ownerId}/pets")
	List<Pet> findPetByOwnerId(@Param("ownerId") int ownerId);

}

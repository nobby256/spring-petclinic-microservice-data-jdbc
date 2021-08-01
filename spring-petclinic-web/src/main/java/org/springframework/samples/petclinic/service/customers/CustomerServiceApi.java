package org.springframework.samples.petclinic.service.customers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import feign.Param;

public interface CustomerServiceApi {

	//OwnerServiceApi
	@PostMapping(path = "/owners")
	@ResponseStatus(HttpStatus.CREATED)
	Owner createOwner(@Valid @RequestBody OwnerRequest ownerRequest);

	@GetMapping(path = "/owners/{ownerId}")
	Owner findOwnerByOwnerId(@PathVariable("ownerId") int ownerId);

	@GetMapping(path = "/owners", params = { "lastName" })
	List<Owner> findOwnerByLastName(@RequestParam(name = "lastName", required = false) String lastName);

	@PutMapping(path = "/owners/{ownerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void updateOwner(@Valid @RequestBody OwnerRequest ownerRequest, @PathVariable("ownerId") int ownerId);

	//PetServiceApi
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

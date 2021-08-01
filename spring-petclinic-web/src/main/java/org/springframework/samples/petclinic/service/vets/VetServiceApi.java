package org.springframework.samples.petclinic.service.vets;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public interface VetServiceApi {

	@GetMapping("/vets")
    List<VetDetail> findAllVets();

}

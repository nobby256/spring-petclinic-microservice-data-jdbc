package org.springframework.samples.petclinic.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.samples.petclinic.service.vets.VetServiceApi;

@FeignClient("vets-service")
public interface VetsService extends VetServiceApi {

}

package org.springframework.samples.petclinic.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.samples.petclinic.service.customers.OwnerServiceApi;
import org.springframework.samples.petclinic.service.customers.PetServiceApi;

@FeignClient("customers-service")
public interface CustomersService extends OwnerServiceApi, PetServiceApi {

}

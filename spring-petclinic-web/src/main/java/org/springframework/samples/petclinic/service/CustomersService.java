package org.springframework.samples.petclinic.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.samples.petclinic.service.customers.CustomerServiceApi;

@FeignClient("customers-service")
public interface CustomersService extends CustomerServiceApi {

}

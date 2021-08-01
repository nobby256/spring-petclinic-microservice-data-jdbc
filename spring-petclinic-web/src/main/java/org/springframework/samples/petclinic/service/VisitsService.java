package org.springframework.samples.petclinic.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.samples.petclinic.service.visits.VisitServiceApi;

@FeignClient("visits-service")
public interface VisitsService extends VisitServiceApi {

}

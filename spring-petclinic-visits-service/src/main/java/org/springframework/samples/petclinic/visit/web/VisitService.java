package org.springframework.samples.petclinic.visit.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.samples.petclinic.visit.api.VisitServiceApi;
import org.springframework.samples.petclinic.visit.model.Visit;
import org.springframework.samples.petclinic.visit.model.VisitRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class VisitService implements VisitServiceApi {

	protected VisitRepository visitRepository;

	public VisitService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit createVisits(@Valid VisitRequest visitRequest, int ownerId, int petId) {
		Visit visit = new Visit();
		visit.setVisitDate(visitRequest.getVisitDate());
		visit.setDescription(visitRequest.getDescription());
		visit.setPetId(petId);
		visitRepository.save(visit);
		return visit;
	}

	@Override
	public List<Visit> findVisitByPetId(int ownerId, int petId) {
		return visitRepository.findByPetId(petId);
	}

	@Override
	public Map<Integer, List<Visit>> findVisitByPetIds(List<Integer> petIds) {
		Map<Integer, List<Visit>> map = new HashMap<>();
		visitRepository.findByPetIdIn(petIds).forEach(visit -> {
			int petId = visit.getPetId();
			map.putIfAbsent(petId, new ArrayList<>());
			map.get(petId).add(visit);
		});
		return map;
	}

	@Override
	public List<Visit> visitsMultiGet(List<Integer> petIds) {
		return visitRepository.findByPetIdIn(petIds);
	}

}

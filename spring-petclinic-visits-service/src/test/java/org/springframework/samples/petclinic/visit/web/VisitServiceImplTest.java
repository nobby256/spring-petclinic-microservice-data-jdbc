package org.springframework.samples.petclinic.visit.web;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.samples.petclinic.visit.model.Visit;

@DataJdbcTest
public class VisitServiceImplTest {

	@Autowired
	VisitRepository visitRepository;

	VisitServiceImpl target;

	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@BeforeEach
	void setup() {
		target = new VisitServiceImpl(visitRepository);
	}

	protected Visit[] expectedVisits(Integer... petIds) {
		List<Integer> visitIdList = Arrays.asList(petIds);
		List<Visit> visits = new ArrayList<>();

		Visit visit;
		visit = new Visit();
		visit.setId(1);
		visit.setPetId(7);
		visit.setVisitDate(LocalDate.parse("2013-01-01", formatter));
		visit.setDescription("rabies shot");
		visits.add(visit);

		visit = new Visit();
		visit.setId(2);
		visit.setPetId(6);
		visit.setVisitDate(LocalDate.parse("2013-01-02", formatter));
		visit.setDescription("rabies shot");
		visits.add(visit);

		visit = new Visit();
		visit.setId(3);
		visit.setPetId(8);
		visit.setVisitDate(LocalDate.parse("2013-01-03", formatter));
		visit.setDescription("neutered");
		visits.add(visit);

		visit = new Visit();
		visit.setId(4);
		visit.setPetId(7);
		visit.setVisitDate(LocalDate.parse("2013-01-04", formatter));
		visit.setDescription("spayed");
		visits.add(visit);

		return visits.stream().filter(v -> visitIdList.contains(v.getPetId())).collect(Collectors.toList())
				.toArray(new Visit[0]);
	}

	@Test
	void findByPetIdTest() {
		List<Visit> actual = target.findVisitByPetId(7);

		assertThat(actual).contains(expectedVisits(7));
	}

	@Test
	void findVisitByPetIdsTest() {
		List<Integer> args = List.of(Integer.valueOf(7), Integer.valueOf(8));
		Map<Integer, List<Visit>> actual = target.findVisitByPetIds(args);

		assertThat(actual.get(7)).contains(expectedVisits(7));
		assertThat(actual.get(8)).contains(expectedVisits(8));
	}

	@Test
	void visitsMultiGetTest() {
		List<Integer> args = List.of(Integer.valueOf(7), Integer.valueOf(8));
		List<Visit> actual = target.visitsMultiGet(args);

		assertThat(actual).contains(expectedVisits(7, 8));
	}

}

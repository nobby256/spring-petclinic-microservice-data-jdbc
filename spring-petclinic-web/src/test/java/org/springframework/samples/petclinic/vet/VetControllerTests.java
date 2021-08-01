package org.springframework.samples.petclinic.vet;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.service.vets.Specialty;
import org.springframework.samples.petclinic.service.vets.VetDetail;
import org.springframework.samples.petclinic.service.vets.VetServiceApi;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class for the {@link VetController}
 */
@WebMvcTest(VetController.class)
public class VetControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VetServiceApi vets;

	@BeforeEach
	public void setup() {
		VetDetail james = new VetDetail();
		james.setFirstName("James");
		james.setLastName("Carter");
		james.setId(1);

		VetDetail helen = new VetDetail();
		helen.setFirstName("Helen");
		helen.setLastName("Leary");
		helen.setId(2);

		Specialty radiology = new Specialty();
		radiology.setId(1);
		radiology.setName("radiology");
		helen.getSpecialties().add(radiology);

		given(this.vets.findAllVets()).willReturn(Lists.newArrayList(james, helen));
	}

	@Test
	public void testShowVetList() throws Exception {
		mockMvc.perform(get("/vets"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("vets"))
				.andExpect(view().name("vets/vetList"));
	}

}

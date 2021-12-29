package com.openclassrooms.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @WebMvcTest(controllers = EmployeeController.class) déclenche le mécanisme permettant de tester les controllers. On indique également le ou les controllers concernés.
 *
 * L’attribut mockMvc est un autre élément important. Il permet d’appeler la méthode “perform” qui déclenche la requête.
 *
 * L’attribut employeeService est annoté @MockBean. Il est obligatoire, car la méthode du controller exécutée par l’appel de “/employees” utilise cette classe.
 *
 * Rappelons que les tests unitaires ont pour vocation à tester uniquement le contenu d’une méthode, alors que les tests d’intégration impliquent de tester plus largement une fonctionnalité.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEmployees() throws  Exception{
        //mockMvc.perform(get("/employees")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Laurent")));
        mockMvc.perform(get("/employees")).andExpect(status().isOk());
    }
}

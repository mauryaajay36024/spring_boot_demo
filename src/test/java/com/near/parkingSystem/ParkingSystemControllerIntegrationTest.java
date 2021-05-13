package com.near.parkingSystem;

import com.near.parkingsystem.Main;
import com.near.parkingsystem.entity.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingSystemControllerIntegrationTest {
  @Autowired
  private TestRestTemplate restTemplate;

  @LocalServerPort
  private int port;

  private String getRootUrl() {
    return "http://localhost:" + port;
  }

  @Test
  public void testGetAllVehicles() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/vehicles",
        HttpMethod.GET, entity, String.class);
    assertNotNull(response.getBody());
  }

  @Test
  public void testGetVehicleById() {
    Vehicle vehicle = restTemplate.getForObject(getRootUrl() + "/vehicles/DL23AV4497", Vehicle.class);
    System.out.println(vehicle.getColour());
    assertNotNull(vehicle);
  }

  @Test
  public void testAddVehicle() {
    Vehicle vehicle = new Vehicle();
    vehicle.setRegNo("DL23AV4497");
    vehicle.setColour("RED");
    ResponseEntity<Vehicle> postResponse = restTemplate.postForEntity(getRootUrl() + "/vehicles", vehicle, Vehicle.class);
    assertNotNull(postResponse);
  }

  @Test
  public void testUpdateVehicle() {
    String id = "DL23AV4497";
    Vehicle vehicle = restTemplate.getForObject(getRootUrl() + "/vehicles/" + id, Vehicle.class);
    vehicle.setRegNo("PB76TG6754");
    vehicle.setColour("BLACK");
    restTemplate.put(getRootUrl() + "/vehicles/" + id, vehicle);
    Vehicle updatedEmployee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Vehicle.class);
    assertNotNull(updatedEmployee);
  }

  @Test
  public void testDeleteVehicles() {
    String id = "PB76TG6754";
    Vehicle vehicle = restTemplate.getForObject(getRootUrl() + "/vehicles/" + id, Vehicle.class);
    assertNotNull(vehicle);
    restTemplate.delete(getRootUrl() + "/vehicles/" + id);
    try {
      vehicle = restTemplate.getForObject(getRootUrl() + "/vehicles/" + id, Vehicle.class);
    } catch (final HttpClientErrorException e) {
      assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
    }
  }
}

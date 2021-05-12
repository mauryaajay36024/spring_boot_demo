package com.near.springBoot;

import com.near.springBoot.core.Vehicle;
import com.near.springBoot.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



public class ParkingSystemTest {
  
  @Test
  public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
      {

    // Given
    String name = RandomStringUtils.randomAlphabetic( 8 );
    HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );

    // When
    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

    // Then
    assertThat(
        httpResponse.getStatusLine().getStatusCode(),
        equalTo(HttpStatus.SC_NOT_FOUND));
  }

}

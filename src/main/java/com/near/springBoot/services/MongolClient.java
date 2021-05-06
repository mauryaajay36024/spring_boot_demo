package com.near.springBoot.services;
import com.near.springBoot.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MongolClient implements DbService {

  @Autowired
  private MongoRepository mongoRepository;

  @Override
  public List<Vehicle> printInfo() {
    return mongoRepository.findAll();
  }

  @Override
  public Vehicle addInfo(Vehicle vehicle) {
    mongoRepository.save(vehicle);
    return vehicle;
  }

  @Override
  public Vehicle updateInfo(String regNo,Vehicle vehicle){
    Optional<Vehicle> v1 =  mongoRepository.findById(regNo);
    return null;
  }

  @Override
  public void deleteInfo(String regNo) {

  }


}

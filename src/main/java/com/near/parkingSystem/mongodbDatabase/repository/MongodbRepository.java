package com.near.parkingSystem.mongodbDatabase.repository;
import com.near.parkingSystem.mongodbDatabase.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongodbRepository extends MongoRepository<Vehicle,Long> {

}
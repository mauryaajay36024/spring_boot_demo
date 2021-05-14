package com.near.parkingSystem.redisDatabase.repository;

import com.near.parkingSystem.redisDatabase.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<Vehicle,Long> {

}

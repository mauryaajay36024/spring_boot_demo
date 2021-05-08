package com.near.springBoot.repository;
import com.near.springBoot.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<Vehicle,Long> {

}

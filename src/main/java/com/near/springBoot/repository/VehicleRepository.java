package com.near.springBoot.repository;
import com.near.springBoot.core.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {

}

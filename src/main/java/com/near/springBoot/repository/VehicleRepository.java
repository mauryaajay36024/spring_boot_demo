package com.near.springBoot.repository;
import com.near.springBoot.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


@Repository
public interface VehicleRepository extends ElasticsearchRepository<Vehicle,String>{

}

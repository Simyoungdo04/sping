package com.kh.rasp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.rasp.model.entity.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
	
}

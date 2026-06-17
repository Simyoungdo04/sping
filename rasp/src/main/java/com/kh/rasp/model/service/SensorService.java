package com.kh.rasp.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.rasp.model.dao.SensorRepository;
import com.kh.rasp.model.dto.SensorDto;
import com.kh.rasp.model.entity.Sensor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SensorService {
	
	private final SensorRepository sensorRepository;

	public void save(SensorDto dto) {
		Sensor s = new Sensor();
		s.setCurrent(dto.getCurrent());
		s.setPower(dto.getPower());
		s.setVoltage(dto.getVoltage());
		sensorRepository.save(s);
	}

	public List<Sensor> findAll() {
		return sensorRepository.findAll();
	}

	
	
}

package com.tts.Weather.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.Weather.model.Zipcode;

@Repository
public interface ZipcodeRepository extends CrudRepository<Zipcode, Long> {

		public List<Zipcode> findAllByOrderByCreatedAtDesc();
		public List<Zipcode> findAll();
}

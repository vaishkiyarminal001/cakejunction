package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Data;
import com.app.repository.DataRepository;

@Service
public class DataService {
	
	@Autowired
	private DataRepository dataRepository;
	
	// Crud operation for post
	public Data addData(Data data) {
	    return dataRepository.save(data);
	}
	
	// get data
	
	public List<Data> getAllData() {
	    return dataRepository.findAll();
	}

	public Data getDataById(Long id) {
	    Data data = dataRepository.findById(id).get();
	    return data;
	}

	
	// update data
	
	public Data updateData(Long id, Data newData) {
	    Optional<Data> existingDataOptional = dataRepository.findById(id);
	    if (existingDataOptional.isPresent()) {
	        Data existingData = existingDataOptional.get();
	        existingData.setName(newData.getName());
	        existingData.setDescription(newData.getDescription());
	        return dataRepository.save(existingData);
	    } else {
	        return null; // Handle error: Data not found
	    }
	}

	
	// delete data
	
	public void deleteData(Long id) {
	    dataRepository.deleteById(id);
	}

}

package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.DataDto;
import com.app.entity.Data;
import com.app.exception.SomethingWentWrong;
import com.app.repository.DataRepository;

@Service
public class DataServiceImpl implements DataService{
    
    @Autowired
    private DataRepository dataRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    // Crud operation for post
    
//    Post 
    @Override
    public Data addData(DataDto data)throws SomethingWentWrong {
        Data d = mapper.map(data, Data.class);
        return dataRepository.save(d);
    }
    
    // get data
    @Override
    public List<Data> getAllData() throws SomethingWentWrong {
        return dataRepository.findAll();
    }

    @Override
    public Data getDataById(Long id) throws SomethingWentWrong {
        return dataRepository.findById(id).orElseThrow(() -> new SomethingWentWrong("Data not found"));
    }

    
    // update data 
    @Override
    public Data updateData(Long id, Data newData) throws SomethingWentWrong {
        Optional<Data> existingDataOptional = dataRepository.findById(id);
        if (existingDataOptional.isPresent()) {
            Data existingData = existingDataOptional.get();
            existingData.setName(newData.getName());
            existingData.setDescription(newData.getDescription());
            return dataRepository.save(existingData);
        } else {
            throw new SomethingWentWrong("Data not found");
        }
    }

    
    // delete data 
    @Override
    public Data deleteData(Long id) throws SomethingWentWrong {
        Optional<Data> dataOptional = dataRepository.findById(id);
        if (dataOptional.isPresent()) {
            dataRepository.deleteById(id);
        } else {
            throw new SomethingWentWrong("Data not found");
        }
		return null;
    }
}

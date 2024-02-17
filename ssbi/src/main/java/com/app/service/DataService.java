package com.app.service;

import java.util.List;

import com.app.DTO.DataDto;
import com.app.entity.Data;
import com.app.exception.SomethingWentWrong;

public interface DataService {
	
	Data addData(DataDto data) throws SomethingWentWrong;
	List<Data> getAllData() throws SomethingWentWrong;
	Data getDataById(Long id) throws SomethingWentWrong;
	Data updateData(Long id, Data newData) throws SomethingWentWrong;
	Data deleteData(Long id) throws SomethingWentWrong;

}

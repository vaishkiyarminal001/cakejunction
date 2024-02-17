package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Data;
import com.app.service.DataService;

@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "*")
public class DataController {

	 @Autowired
	    private DataService dataService;

	    @PostMapping("/registerData")
	    public ResponseEntity<Data> addData(@RequestBody Data data) {
	        Data newData = dataService.addData(data);
	        return ResponseEntity.status(HttpStatus.CREATED).body(newData);
	    }

	    @GetMapping("/getAllData")
	    public ResponseEntity<List<Data>> getAllData() {
	        List<Data> allData = dataService.getAllData();
	        return ResponseEntity.ok(allData);
	    }

	    @GetMapping("/getDataById/{id}")
	    public ResponseEntity<Data> getDataById(@PathVariable Long id) {
	        Data data = dataService.getDataById(id);
	        if (data != null) {
	            return ResponseEntity.ok(data);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/updateData/{id}")
	    public ResponseEntity<Data> updateData(@PathVariable Long id, @RequestBody Data newData) {
	        Data updatedData = dataService.updateData(id, newData);
	        if (updatedData != null) {
	            return ResponseEntity.ok(updatedData);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/deleteData/{id}")
	    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
	        dataService.deleteData(id);
	        return ResponseEntity.noContent().build();
	    }
}

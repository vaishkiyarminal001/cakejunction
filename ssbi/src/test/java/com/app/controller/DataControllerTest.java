package com.app.controller;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.DTO.DataDto;
import com.app.entity.Data;
import com.app.service.DataServiceImpl;

class DataControllerTest {

    @Mock
    private DataServiceImpl dataService;

    @InjectMocks
    private DataController dataController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddData() {
        DataDto dataDto = new DataDto();
        Data data = new Data();
        when(dataService.addData(dataDto)).thenReturn(data);

        ResponseEntity<Data> response = dataController.addData(dataDto);

        verify(dataService, times(1)).addData(dataDto);
        assert response.getStatusCode() == HttpStatus.CREATED;
        assert response.getBody() == data;
    }

    @Test
    void testGetAllData() {
        List<Data> dataList = new ArrayList<>();
        when(dataService.getAllData()).thenReturn(dataList);

        ResponseEntity<List<Data>> response = dataController.getAllData();

        verify(dataService, times(1)).getAllData();
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == dataList;
    }

    @Test
    void testGetDataById() {
        Long id = 1L;
        Data data = new Data();
        when(dataService.getDataById(id)).thenReturn(data);

        ResponseEntity<Data> response = dataController.getDataById(id);

        verify(dataService, times(1)).getDataById(id);
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == data;
    }

    @Test
    void testUpdateData() {
        Long id = 1L;
        Data newData = new Data();
        Data updatedData = new Data();
        when(dataService.updateData(id, newData)).thenReturn(updatedData);

        ResponseEntity<Data> response = dataController.updateData(id, newData);

        verify(dataService, times(1)).updateData(id, newData);
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == updatedData;
    }

    @Test
    void testDeleteData() {
        Long id = 1L;
        Data data = new Data();
        when(dataService.deleteData(id)).thenReturn(data);

        ResponseEntity<?> response = dataController.deleteData(id);

        verify(dataService, times(1)).deleteData(id);
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == data;
    }
}

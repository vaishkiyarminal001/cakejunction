//package com.app.configure;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import com.app.entity.Data;
//import com.app.service.DataService;
//
//@Controller
//public class WebSocketController {
//
//    @Autowired
//    private DataService dataService;
//    
//    @MessageMapping("/get_data")
//    @SendTo("/topic/data_update")
//    public List<Data> getDataUpdates(){
//        return dataService.getAllData();
//    }
//}

package ru.mephi.kaf46.teleleukemia.port.adapter.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mephi.kaf46.teleleukemia.application.KafedraSaveRequest;
import ru.mephi.kaf46.teleleukemia.application.KafedraService;
import ru.mephi.kaf46.teleleukemia.application.recognitionwindow.classic.NeuralNetworkService;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@RestController
public class DummyServer {

    public DummyServer(NeuralNetworkService neuralNetworkService) {

    }

    @PostMapping(value = "api/run-recognition")
    public ResponseEntity<String> createApplication(@RequestParam String path) {
        System.out.println(path);
        return ResponseEntity.ok("OK");
    }

//    @GetMapping("/api/kafedras/{id}")
//    ResponseEntity<Object> getKafedra(@PathVariable @NotNull @DecimalMin(value = "1") Integer id) {
//        return ResponseEntity.ok()
//                .body(this.kafedraService.getKafedra(id));
//
//    }
}

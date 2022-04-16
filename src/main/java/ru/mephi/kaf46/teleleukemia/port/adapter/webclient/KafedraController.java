package ru.mephi.kaf46.teleleukemia.port.adapter.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mephi.kaf46.teleleukemia.application.KafedraSaveRequest;
import ru.mephi.kaf46.teleleukemia.application.KafedraService;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * @author Yury Zorin
 */
@RestController
public class KafedraController {

    @Autowired
    private final KafedraService kafedraService;

    public KafedraController(KafedraService kafedraService) {
        this.kafedraService = kafedraService;
    }

    @PostMapping(value = "/api/kafedra", consumes = "application/json")
    ResponseEntity<Object> createApplication(@RequestBody @Valid KafedraSaveRequest request) {
        this.kafedraService.saveKafedra(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/kafedras/{id}")
    ResponseEntity<Object> getKafedra(@PathVariable @NotNull @DecimalMin(value = "1") Integer id) {
        return ResponseEntity.ok()
                .body(this.kafedraService.getKafedra(id));

    }
}

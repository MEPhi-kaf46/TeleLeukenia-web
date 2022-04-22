package ru.mephi.kaf46.teleleukemia.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.kaf46.teleleukemia.domain.model.kafedra.Kafedra;
import ru.mephi.kaf46.teleleukemia.domain.model.kafedra.KafedraRepository;

import java.util.List;

/**
 * @author Yury Zorin
 */
@Service
@RequiredArgsConstructor
@Transactional
public class KafedraService {

    @Autowired
    private KafedraRepository repository;

    public void saveKafedra(KafedraSaveRequest request) {
        this.repository.save(request.toDomain());
    }

    public Kafedra getKafedra(Integer number) {
        return this.repository.findByNumber(number)
                .orElseThrow(() -> new RuntimeException("Кафедра с номером " + number + " не найдена."));
    }

    public List<Kafedra> getAllKafedras(Integer year) {
        return this.repository.findByYearOfEstablishment(year);
    }

    public List<Kafedra> getAllKafedras() {
        return this.repository.findAll();
    }
}

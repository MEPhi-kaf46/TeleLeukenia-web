package ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NeuralNetworkRecognizedCellRepository extends JpaRepository<NeuralNetworkRecognizedCell, Long> {

        Optional<NeuralNetworkRecognizedCell> findByNumberInBunch(int numberInBunch);

        List<NeuralNetworkRecognizedCell> findByClassCode(String classCode);
}

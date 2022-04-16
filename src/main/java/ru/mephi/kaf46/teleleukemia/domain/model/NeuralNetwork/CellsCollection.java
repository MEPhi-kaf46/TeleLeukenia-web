package ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class CellsCollection {
    private List<NeuralNetworkRecognizedCell> CurrentCellsCollection;
    private Map<String , Integer> CellsClasses;

    public CellsCollection(List<NeuralNetworkRecognizedCell> ReceivedCellsCollection,
                           Map<String , Integer> ReceivedCellsClasses)
    {
        this.CellsClasses.putAll(ReceivedCellsClasses);
        this.CurrentCellsCollection.addAll(ReceivedCellsCollection);
    }
}

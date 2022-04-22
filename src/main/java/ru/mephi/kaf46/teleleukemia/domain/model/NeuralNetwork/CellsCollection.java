package ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.sun.istack.NotNull;
import lombok.Value;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Value
@JsonAutoDetect(fieldVisibility = ANY)
public class CellsCollection {
    @NotNull
    private List<NeuralNetworkRecognizedCell> CurrentCellsCollection;
    @NotNull
    private List<ClassOfCells> CellsClasses;

    public List<ClassOfCells> getInfoAboutClass()
    {
        return CellsClasses;
    }

    public List<NeuralNetworkRecognizedCell> getInfoAboutCells()
    {
        return CurrentCellsCollection;
    }
}

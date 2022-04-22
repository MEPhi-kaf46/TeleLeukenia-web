package ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jdk.jfr.Name;
import lombok.Value;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Value
@JsonAutoDetect(fieldVisibility = ANY)
public class ClassOfCells {
    @NotNull
    private String className;
    @NotNull
    private int classSize;

    public int getClassSize() {
        return classSize;
    }

    public String getClassName() {
        return className;
    }
}

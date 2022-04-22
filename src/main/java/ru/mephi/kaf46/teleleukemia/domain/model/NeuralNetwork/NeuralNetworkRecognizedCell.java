package ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;


@JsonAutoDetect(fieldVisibility = ANY)
public class NeuralNetworkRecognizedCell {


    private int numberInBunch;


    private String imagePath;


    private String classCode;


    int recognitionStatus;

    public NeuralNetworkRecognizedCell(String PathToImage, int number, String ClassCode, int Status)
    {
        this.classCode = ClassCode;
        this.imagePath = PathToImage;
        this.numberInBunch = number;
        this.recognitionStatus = Status;
    }

    public NeuralNetworkRecognizedCell()
    {
        //empty
    }

    public int recognitionStatus()
    {
        return this.recognitionStatus;
    }

    public int numberInBunch() {return this.numberInBunch;}

    public String classCode() {return  this.classCode;}

    public String imagePath() {return this.imagePath;}
}
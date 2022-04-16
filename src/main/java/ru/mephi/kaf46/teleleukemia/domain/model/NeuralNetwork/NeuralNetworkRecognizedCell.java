package ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Entity
@Table(name = "NeuralNetworkCell")
@JsonAutoDetect(fieldVisibility = ANY)
public class NeuralNetworkRecognizedCell {

    @Id
    @Column(nullable = false, updatable = false)
    private int numberInBunch;

    @Column(nullable = false, updatable = true)
    private String imagePath;

    @Column(nullable = false, updatable = true)
    private String classCode;

    @Column(nullable = false, updatable = true)
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
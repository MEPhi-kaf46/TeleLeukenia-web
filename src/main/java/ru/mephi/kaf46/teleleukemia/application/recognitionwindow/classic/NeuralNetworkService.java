package ru.mephi.kaf46.teleleukemia.application.recognitionwindow.classic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork.CellsCollection;

import java.awt.image.BufferedImage;

/**
 * @author Yury Zorin
 */
@Service
@RequiredArgsConstructor
@Transactional
public class NeuralNetworkService {

    @Autowired
    private NeuralNetworkRestClient client;

    public void PostImagePathByRest(String PathToImage)
    {
        this.client.PostImagePath(PathToImage);
    }

    public int getRecognitionStatusByRest()
    {
        return this.client.getRecognitionStatus().recognitionStatus();
    }

    public CellsCollection getRecognitionInfoByRest()
    {
        return this.client.getRecognitionInfo();
    }

    public BufferedImage getImageByRest(String Path)
    {
        return this.client.getImage(Path);
    }
//your code
}

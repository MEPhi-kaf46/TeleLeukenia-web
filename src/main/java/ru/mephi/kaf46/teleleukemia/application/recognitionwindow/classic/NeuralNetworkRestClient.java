package ru.mephi.kaf46.teleleukemia.application.recognitionwindow.classic;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork.CellsCollection;
import ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork.NeuralNetworkRecognizedCell;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.Map;

/**
 * @author Yury Zorin
 */
@Service
@Transactional
public class NeuralNetworkRestClient {

    private RestTemplate restTemplate;

    public String addressOfService;

    public NeuralNetworkRestClient()
    {
        this.restTemplate = new RestTemplateBuilder()
            .rootUri("http://10.52.10.147:8080")
            .build();
    }

    public void PostImagePath(String PathToImage)
    {
        Map<String , ?> parameters = Map.of("Vasay", PathToImage);
        try {
            ResponseEntity<String> response = this.restTemplate.postForEntity("http://10.52.10.142:8080/api/run-recognition?path={Vasay}",
                    null,
                    String.class,
                    parameters
            );
            if(!response.getStatusCode().is2xxSuccessful()){
                throw new RuntimeException("Соединение не удалось "+response);
            }
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Соединение не удалось "+ex.getMessage());
        }

    }

    public NeuralNetworkRecognizedCell getRecognitionStatus()
    {
        ResponseEntity<NeuralNetworkRecognizedCell> response = this.restTemplate.getForEntity("http://10.52.10.142:8080/api/recognition-status",
                NeuralNetworkRecognizedCell.class);

        if(!response.getStatusCode().is2xxSuccessful()){
            throw new RuntimeException("Соединение не удалось "+response);
        }

        NeuralNetworkRecognizedCell test = response.getBody();
        return response.getBody();
    }

    public CellsCollection getRecognitionInfo()
    {
        ResponseEntity<CellsCollection> response = this.restTemplate.getForEntity("http://10.52.10.142:8080/api/recognition-info",
                CellsCollection.class);

        if(!response.getStatusCode().is2xxSuccessful()){
            throw new RuntimeException("Соединение не удалось "+response);
        }
        CellsCollection test = response.getBody();
        return response.getBody();
    }

    public BufferedImage getImage(String Path)
    {
        Map<String , ?> parameters = Map.of("path", Path);
        ResponseEntity<BufferedImage> response = this.restTemplate.getForEntity("http://10.52.10.142:8080/api/image?path={path}",
                BufferedImage.class,
                parameters);

        if(!response.getStatusCode().is2xxSuccessful()){
            throw new RuntimeException("Соединение не удалось "+response);
        }

        return response.getBody();
    }
}

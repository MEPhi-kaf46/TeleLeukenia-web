package ru.mephi.kaf46.teleleukemia.application.recognitionwindow.neuralnetwork;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yury Zorin
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ClassicRecognitionRestClient {

    private RestTemplate restTemplate;
    //your code


}

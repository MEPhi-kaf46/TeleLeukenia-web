package ru.mephi.kaf46.teleleukemia.application.recognitionwindow.classic;

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
public class NeuralNetworkRestClient {

    private RestTemplate restTemplate;
    //your code
}

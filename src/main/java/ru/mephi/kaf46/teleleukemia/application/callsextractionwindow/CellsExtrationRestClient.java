package ru.mephi.kaf46.teleleukemia.application.callsextractionwindow;

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
public class CellsExtrationRestClient {

    private RestTemplate restTemplate;
    //your code
}

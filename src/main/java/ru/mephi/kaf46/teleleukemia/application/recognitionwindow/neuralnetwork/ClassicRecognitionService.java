package ru.mephi.kaf46.teleleukemia.application.recognitionwindow.neuralnetwork;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yury Zorin
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ClassicRecognitionService {

    @Autowired
    private ClassicRecognitionRestClient client;

//your code
}

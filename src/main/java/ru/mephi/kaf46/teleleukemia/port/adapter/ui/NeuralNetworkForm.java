package ru.mephi.kaf46.teleleukemia.port.adapter.ui;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import ru.mephi.kaf46.teleleukemia.application.KafedraSaveRequest;
import ru.mephi.kaf46.teleleukemia.application.KafedraService;
import ru.mephi.kaf46.teleleukemia.application.recognitionwindow.classic.NeuralNetworkService;

/**
 * @author Yury Zorin <yuri.zorin@bostongene.com>
 */
public class NeuralNetworkForm extends FormLayout {
    private final NeuralNetworkService neuralNetworkService;
    TextField ImagePath = new TextField("Путь к изображению");
    Button StartNeuralNetwork = new Button("Распознать", e -> Notification.show("Распознаем"));

    public NeuralNetworkForm(NeuralNetworkService neuralNetworkService) {

        this.neuralNetworkService = neuralNetworkService;

        addClassName("contact-form");

        StartNeuralNetwork.addClickListener(event -> {
            this.neuralNetworkService.PostImagePathByRest(ImagePath.getValue());
        });

        add(ImagePath,
            StartNeuralNetwork);
    }
}
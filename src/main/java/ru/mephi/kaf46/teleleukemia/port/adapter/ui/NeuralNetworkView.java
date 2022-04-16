package ru.mephi.kaf46.teleleukemia.port.adapter.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import ru.mephi.kaf46.teleleukemia.application.recognitionwindow.classic.NeuralNetworkService;
import ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork.CellsCollection;
import ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork.NeuralNetworkRecognizedCell;
import ru.mephi.kaf46.teleleukemia.domain.model.kafedra.Kafedra;


public class NeuralNetworkView extends VerticalLayout{

    private final NeuralNetworkService neuralNetworkService;

    Grid<NeuralNetworkRecognizedCell> grid = new Grid<>(NeuralNetworkRecognizedCell.class);
    Grid<CellsCollection> gridCellsCollection = new Grid<>(CellsCollection.class);
    NeuralNetworkForm form;

    public NeuralNetworkView(NeuralNetworkService service) {
        this.neuralNetworkService = service;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(getContent());
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureForm() {
        form = new NeuralNetworkForm(neuralNetworkService);
        form.setWidth("25em");
    }

    private void configureGrid() {
        grid.addClassNames("RecognizedCells-grid");
        grid.setSizeFull();

        grid.addColumn(NeuralNetworkRecognizedCell::imagePath).setHeader("Путь");
        grid.addColumn(NeuralNetworkRecognizedCell::classCode).setHeader("Тип");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

}

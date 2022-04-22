package ru.mephi.kaf46.teleleukemia.port.adapter.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.StreamResource;
import ru.mephi.kaf46.teleleukemia.application.recognitionwindow.classic.NeuralNetworkService;
import ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork.CellsCollection;
import ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork.ClassOfCells;
import ru.mephi.kaf46.teleleukemia.domain.model.NeuralNetwork.NeuralNetworkRecognizedCell;


import javax.imageio.ImageIO;
import javax.xml.transform.stream.StreamSource;
import java.awt.image.BufferedImage;
import java.io.*;


public class NeuralNetworkView extends VerticalLayout{

    private final NeuralNetworkService neuralNetworkService;

    Grid<NeuralNetworkRecognizedCell> grid = new Grid<>(NeuralNetworkRecognizedCell.class);
    Grid<ClassOfCells> gridCellsCollection = new Grid<>();
    Image cellImage = new Image();
    NeuralNetworkForm form;

    public NeuralNetworkView(NeuralNetworkService service) {
        this.neuralNetworkService = service;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureGridCellsCollection();
        configureForm();

        Button cellsButton = new Button("Показать все");

        cellsButton.addClickListener(event -> showAll());

        add(cellsButton, getContent());
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, gridCellsCollection, form);
        content.setFlexGrow(1, grid);
        content.setFlexGrow(1, gridCellsCollection);
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
        grid.addItemClickListener(e ->{
            if (e.getColumn()==grid.getColumnByKey("Путь")) {
//                cellImage.setSrc(createStreamResource(e.getItem().imagePath()));
                    //тут вывод картинки
            }
        });
    }

//    private StreamResource createStreamResource() {
//    return new StreamResource(new StreamSource() {
//        @Override
//        public InputStream getStream() {
//            String text = "Date: " + DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM).format(new Date());
//
//            BufferedImage bi = new BufferedImage(370, 30,
//                    BufferedImage.TYPE_3BYTE_BGR);
//            bi.getGraphics().drawChars(text.toCharArray(), 0,
//                    text.length(), 10, 20);
//
//            try {
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                ImageIO.write(bi, "png", bos);
//                return new ByteArrayInputStream(bos.toByteArray());
//            } catch (IOException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//    }, "dateImage.png");
//}


    private void configureGridCellsCollection() {
        gridCellsCollection.addClassNames("CellsCollection-grid");
        gridCellsCollection.setSizeFull();

        gridCellsCollection.addColumn(ClassOfCells::getClassName).setHeader("Тип");
        gridCellsCollection.addColumn(ClassOfCells::getClassSize).setHeader("Количество");
        gridCellsCollection.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void showAll() {
        if (neuralNetworkService.getRecognitionStatusByRest()==1) {
            Notification.show("Таблицы успешно обновлены!");
            grid.setItems(neuralNetworkService.getRecognitionInfoByRest().getInfoAboutCells());
            gridCellsCollection.setItems(neuralNetworkService.getRecognitionInfoByRest().getInfoAboutClass());
        }
        else
            Notification.show("Информация неготова...");
    }

}

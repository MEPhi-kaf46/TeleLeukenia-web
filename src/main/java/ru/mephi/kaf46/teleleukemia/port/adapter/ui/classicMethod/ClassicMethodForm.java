package ru.mephi.kaf46.teleleukemia.port.adapter.ui.classicMethod;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import ru.mephi.kaf46.teleleukemia.application.ClassicMethodRequest;
import ru.mephi.kaf46.teleleukemia.application.ClassicMethodService;

/**
 * @author Yury Zorin <yuri.zorin@bostongene.com>
 */
public class ClassicMethodForm extends FormLayout {
    private final ClassicMethodService classicMethodService;
    TextField fileName = new TextField("Имя файла с параметрами");
    TextField cellsClass = new TextField("Задать класс клеток");
    TextField objectNumber = new TextField("Число объектов");
    TextField minAreaInPixels = new TextField("Минимальная площадь объекта в пикселях");
    TextField maxUnstickySize = new TextField("Максимальный размер неслипшехся");
    Button save = new Button("Распознать", e -> Notification.show("Распознаем..."));
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    public ClassicMethodForm(ClassicMethodService classicMethodService) {

        this.classicMethodService = classicMethodService;

        addClassName("contact-form");

        save.addClickListener(event -> {
        	// TODO implement request
        	ClassicMethodRequest request = new ClassicMethodRequest(
            );
            // this.kafedraService.saveKafedra(request);
        });

        add(fileName,
        		cellsClass,
        		objectNumber,
        		minAreaInPixels,
        		maxUnstickySize,
                createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close);
    }
}
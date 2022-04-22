package ru.mephi.kaf46.teleleukemia.port.adapter.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mephi.kaf46.teleleukemia.application.KafedraService;
import ru.mephi.kaf46.teleleukemia.port.adapter.ui.classicMethod.ClassicMethodView;
import ru.mephi.kaf46.teleleukemia.application.ClassicMethodService;

import java.util.Map;

/**
 * @author Yury Zorin <yuri.zorin@bostongene.com>
 */
@Route("")
public class MainViewAppLayout extends AppLayout {

    private final KafedraService kafedraService;
    private final ClassicMethodService classicMethodService;

    public MainViewAppLayout(
    		@Autowired KafedraService kafedraService,
    		@Autowired ClassicMethodService classicMethodService
    	) {
    	this.classicMethodService = classicMethodService;
        this.kafedraService = kafedraService;
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("TeleLeukemia web");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tabs tabs = getTabs();

        addToDrawer(tabs);
        addToNavbar(toggle, title);
    }

    private Tabs getTabs() {
        String chairLabel = "Добавление Кафедры (только для демо на парах)";
        String classicMethodViewLabel = "Страница распознавания классическим методом";
        Tab kaf = new Tab(chairLabel);
        Tab main = new Tab("Основная страница");
        Tab cellsExtraction = new Tab("Страница формирования выборки");
        Tab classicMethod = new Tab(classicMethodViewLabel);
        Tab neuralNetwork = new Tab("Страница распознавания нейросетью");

        MainView chairForm = new MainView(this.kafedraService);
        ClassicMethodView classiMethodView = new ClassicMethodView(this.classicMethodService);

        // заполняем формами по лейблу вкладки
        Map<String, Component> contentById = Map.of(
        		chairLabel, chairForm,
        		classicMethodViewLabel, classiMethodView
        	);
        //можно добавить так contentById.put(yourLabel, yourForm);

        Tabs tabs = new Tabs(kaf, main, cellsExtraction, classicMethod, neuralNetwork);
        setContent(chairForm); // установка дефолтной страницы - тут надо МainPage проставить тому у кого заглавная страница!
        tabs.addSelectedChangeListener(event ->
                setContent(contentById.get(event.getSelectedTab().getLabel()))
        );
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.setHeight("240px");
        tabs.setWidth("240px");
        return tabs;
    }
}

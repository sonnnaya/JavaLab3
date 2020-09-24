package com.company.mvc;

import com.company.enums.ShapeSortTypes;

public class ShapesController {

    private final ShapesModel shapesModel;
    private final ShapesView shapesView;

    public ShapesController(ShapesModel shapesModel, ShapesView shapesView) {
        this.shapesModel = shapesModel;
        this.shapesView = shapesView;
    }

    public void shapes() {
        shapesView.printInstances(shapesView.SHAPES_DATA, shapesModel.getShapes());
    }

    public void calcAreasSum() {
        shapesView.printMessageAndResult(shapesView.SHAPES_SUM_ARES, shapesModel.calcAreasSum());
    }
    
    public void calcAreasSum(Class clazz) {
        String[] classNames = clazz.toString().split("\\.");
        String message = classNames[classNames.length - 1] + shapesView.CERTAIN_SHAPE_SUM_ARES;
        shapesView.printMessageAndResult(message, shapesModel.calcAreasSum(clazz));
    }

    public void sort(ShapeSortTypes type) throws NullPointerException {
        String message = shapesView.SHAPES_SORTED_BY + type.toString().toLowerCase() + ": ";
        switch (type) {
            case AREA -> shapesModel.sortByArea();
            case COLOR -> shapesModel.sortByColor();
            default -> throw new NullPointerException();
        }
        shapesView.printInstances(message, shapesModel.getShapes());
    }
}


package com.company;

import com.company.exceptions.IncorrectShapeException;
import com.company.shapes.Circle;
import com.company.shapes.Rectangle;
import com.company.enums.ShapeSortTypes;
import com.company.shapes.Triangle;
import com.company.mvc.ShapesController;
import com.company.mvc.ShapesModel;
import com.company.mvc.ShapesView;

public class Main {

    public static void main(String[] args) throws IncorrectShapeException {
        ShapesModel shapesModel = new ShapesModel(new Circle("red", 2.4),
                                                  new Rectangle("blue", 15, 2),
                                                  new Triangle("yellow", 3, 4,5),
                                                  new Circle("green", 4.89),
                                                  new Rectangle("brown", 3.5, 2.35),
                                                  new Triangle("white", 7, 2,6.4),
                                                  new Circle("orange", 8.9),
                                                  new Rectangle("pink", 1, 5.3),
                                                  new Triangle("grey", 3.02, 7.02,5.36),
                                                  new Circle("black", 8.5),
                                                  new Rectangle("blue", 6, 7),
                                                  new Triangle("yellow", 15, 10,6));

        ShapesView shapesView = new ShapesView();
        ShapesController shapesController = new ShapesController(shapesModel, shapesView);

        shapesController.shapes();
        shapesController.calcAreasSum();
        shapesController.calcAreasSum(Rectangle.class);
        shapesController.calcAreasSum(Triangle.class);
        shapesController.calcAreasSum(Circle.class);

        shapesController.sort(ShapeSortTypes.AREA);
        shapesController.sort(ShapeSortTypes.COLOR);
    }
}

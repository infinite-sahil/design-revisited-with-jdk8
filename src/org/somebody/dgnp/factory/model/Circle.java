package org.somebody.dgnp.factory.model;

import static org.somebody.dgnp.factory.model.ColorType.*;

public class Circle {

    private ColorType colorType;


    public Circle() {
        this(RED);
    }

    public Circle(ColorType colorType) {
        this.colorType = colorType;
    }


    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "colorType=" + colorType +
                '}';
    }
}

package dev.webfx.lib.circlepacking;

/**
 * @author Bruno Salmon
 */
interface CirclePacking {

    void setContainerSize(double width, double height);

    void setCirclesCount(int count);

    boolean hasChanged();

    double getCirclesRadius();

    double getCircleCenterX(int index);

    double getCircleCenterY(int index);

}

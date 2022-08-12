package dev.webfx.lib.circlepacking;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Bruno Salmon
 */
final class ResponsiveCirclePacking implements CirclePacking {

    private final CirclePacking[] circlePackings = {
            new GridCirclePacking(),
            new HoneyCombCirclePacking()
    };
    private CirclePacking maxRadiusCirclePacker;

    @Override
    public void setContainerSize(double width, double height) {
        Arrays.stream(circlePackings).forEach(cp -> cp.setContainerSize(width, height));
    }

    @Override
    public void setCirclesCount(int count) {
        Arrays.stream(circlePackings).forEach(cp -> cp.setCirclesCount(count));
    }

    @Override
    public boolean hasChanged() {
        return Arrays.stream(circlePackings).anyMatch(CirclePacking::hasChanged);
    }

    @Override
    public double getCirclesRadius() {
        maxRadiusCirclePacker = Arrays.stream(circlePackings).max(Comparator.comparingInt(cp -> (int) cp.getCirclesRadius())).orElse(null);
        return maxRadiusCirclePacker == null ? 0 : maxRadiusCirclePacker.getCirclesRadius();
    }

    @Override
    public double getCircleCenterX(int index) {
        return maxRadiusCirclePacker.getCircleCenterX(index);
    }

    @Override
    public double getCircleCenterY(int index) {
        return maxRadiusCirclePacker.getCircleCenterY(index);
    }
}

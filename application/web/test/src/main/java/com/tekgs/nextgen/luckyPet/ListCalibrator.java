package com.tekgs.nextgen.luckyPet;

import com.softwareonpurpose.calibrator4test.Calibrator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class ListCalibrator<C, I> extends Calibrator {
    // At runtime, childCalibrator requires creation method named 'getInstance()'
    private final Class<C> childCalibrator;

    // At runtime, childCalibratable requires method named 'equivalent()'
    private final Class<I> childCalibratable;

    public ListCalibrator(String description, Object expected, Object actual, Class<C> childCalibrator, Class<I> childCalibratable) {
        super(description, expected, actual);
        this.childCalibrator = childCalibrator;
        this.childCalibratable = childCalibratable;
    }

    private Method setGetInstance() {
        Method getInstance = null;
        for (Method method : this.childCalibrator.getMethods()) {
            if (method.getName().equals("getInstance")) {
                getInstance = method;
            }
        }
        return getInstance;
    }

    private void executeAddChildCalibrator(Object calibratableExpected, Object calibratableActual) {
        Method getInstance = setGetInstance();
        try {
            addChildCalibrator((Calibrator) getInstance.invoke(this.childCalibrator, calibratableExpected, calibratableActual));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Method setEquivalent() {
        Method equivalent = null;
        for (Method method : this.childCalibratable.getMethods()) {
            if (method.getName().equals("equivalent")) {
                equivalent = method;
            }
        }
        return equivalent;
    }

    public Boolean executeEquivalent(Object calibratableActual, Object comparator) {
        Method equivalent = setEquivalent();
        Boolean isEquivalent;
        try {
            isEquivalent = (Boolean) equivalent.invoke(calibratableActual, comparator);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return isEquivalent;
    }

    public void addCalibrationsExpected(List<I> listExpected, List<I> listActual) {
        for (I calibratableExpected : listExpected) {
            I calibratableActual = searchCalibratableActual(listActual, calibratableExpected);
            if (calibratableActual != null) {
                listActual.remove(calibratableActual);
            }
            this.executeAddChildCalibrator(calibratableExpected, calibratableActual);
        }
    }

    private I searchCalibratableActual(List<I> listActual, I calibratableExpected) {
        I calibratableFound = null;

        for (I calibratableActual : listActual) {
            if (this.executeEquivalent(calibratableActual, calibratableExpected)) {
                calibratableFound = calibratableActual;
                break;
            }
        }
        return calibratableFound;
    }

    public void addCalibrationsUnexpected(List<I> listActual) {
        for (I calibratableActual : listActual) {
            executeAddChildCalibrator(null, calibratableActual);
        }
    }
}

package com.luckypet.user.service.cart;

import com.luckypet.behavior.ToStringBehavior;
import com.luckypet.user.data.cart.CartCalibrator;
import com.softwareonpurpose.calibrator4test.Calibrator;

public class CartResponseCalibrator extends Calibrator {

    private static final String DESCRIPTION = "'Cart' response";
    private final CartResponseExpected expected;
    private final CartResponse actual;

    protected CartResponseCalibrator(CartResponseExpected expected, CartResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;


        if (expected.getCart() != null && actual.getCart() != null) {
            System.out.println(ToStringBehavior.getInstance(expected.getCart()).execute());
            System.out.println(ToStringBehavior.getInstance(actual.getCart()).execute());


            this.addChildCalibrator(CartCalibrator.getInstance(expected.getCart(), actual.getCart()));
        }
    }

    public static CartResponseCalibrator getInstance(CartResponseExpected expected, CartResponse actual) {
        return new CartResponseCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Is successful response", expected.isSuccessful(), actual.isSuccessful());
    }
}

package com.tekgs.nextgen.luckyPet.view.error;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ErrorViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Error' view";
    private final ErrorView actual;
    private final ErrorViewExpected expected;

    protected ErrorViewCalibrator(ErrorViewExpected expected, ErrorView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static ErrorViewCalibrator getInstance(ErrorViewExpected expected, ErrorView actual) {
        return new ErrorViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Message", expected.getMessage(), actual.getMessage());
    }
}

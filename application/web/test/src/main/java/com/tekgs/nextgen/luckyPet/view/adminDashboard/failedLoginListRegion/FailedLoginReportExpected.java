package com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion;

import com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion.FailedLoginRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion.FailedLoginRegionExpected;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FailedLoginReportExpected implements FailedLoginReportCalibratable {
    @SuppressWarnings("FieldCanBeLocal")
    private static final String FAILURE_FILES_PATH = "../source/public/logs/%s.log";
    @SuppressWarnings("FieldCanBeLocal")
    private final SortedMap<String, Integer> aggregatedDates = new TreeMap<>();

    private FailedLoginReportExpected(String expectedFilename) {
        expectedFilename = expectedFilename == null ? "loginfailure" : expectedFilename;
            File failureFile = new File(String.format(FAILURE_FILES_PATH, expectedFilename));
            try (BufferedReader failureFileReader = new BufferedReader(new FileReader(failureFile))) {
                String failureLine = failureFileReader.readLine();
                while (failureLine != null) {
                    String date = failureLine.split(" ")[0];
                    int failureCount = aggregatedDates.containsKey(date) ? aggregatedDates.get(date) + 1 : 1;
                    aggregatedDates.put(date, failureCount);
                    failureLine = failureFileReader.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    public static FailedLoginReportExpected getInstance() {
        return new FailedLoginReportExpected(null);
    }

    public static FailedLoginReportExpected getInstance(String loginFailureLogFile) {
        return new FailedLoginReportExpected(loginFailureLogFile);
    }

    @Override
    public List<FailedLoginRegionCalibratable> getFailureDates() {
        List<FailedLoginRegionCalibratable> failures = new ArrayList<>();
        for (String key : aggregatedDates.keySet()) {
            failures.add(FailedLoginRegionExpected.getInstance(key, aggregatedDates.get(key)));
        }
        // Reverse list to match actual to add child calibrators more efficiently
        Collections.reverse(failures);
        return failures;
    }
}

package com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion;

import com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion.LoginFailureRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion.LoginFailureRegionExpected;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LoginFailureListRegionExpected implements LoginFailureListRegionCalibratable {
    @SuppressWarnings("FieldCanBeLocal")
    private static final String FAILURE_FILES_PATH = "../source/public/logs/%s.log";
    @SuppressWarnings("FieldCanBeLocal")
    private final SortedMap<String, Integer> aggregatedDates = new TreeMap<>();
    
    private LoginFailureListRegionExpected(String expectedFilename) {
        expectedFilename = expectedFilename == null ? "loginfailure" : expectedFilename;
        File failureFile = new File(String.format(FAILURE_FILES_PATH, expectedFilename));
        try (BufferedReader failureFileReader = new BufferedReader(new FileReader(failureFile))) {
            String failureLine = failureFileReader.readLine();
            while (failureLine != null) {
                String date = failureLine.split(" ")[0];
                int failureCount = this.aggregatedDates.containsKey(date) ? this.aggregatedDates.get(date) + 1 : 1;
                this.aggregatedDates.put(date, failureCount);
                failureLine = failureFileReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public static LoginFailureListRegionExpected getInstance() {
        return new LoginFailureListRegionExpected(null);
    }
    
    public static LoginFailureListRegionExpected getInstance(String loginFailureLogFile) {
        return new LoginFailureListRegionExpected(loginFailureLogFile);
    }
    
    @Override
    public List<LoginFailureRegionCalibratable> getLoginFailureRegions() {
        List<LoginFailureRegionCalibratable> failures = new ArrayList<>();
        for (String key : this.aggregatedDates.keySet()) {
            failures.add(LoginFailureRegionExpected.getInstance(key, this.aggregatedDates.get(key)));
        }
        // Reverse list to match actual to add child calibrators more efficiently
        Collections.reverse(failures);
        return failures;
    }
}

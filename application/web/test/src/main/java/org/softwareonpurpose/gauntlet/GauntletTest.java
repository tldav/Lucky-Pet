package org.softwareonpurpose.gauntlet;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiDriver;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.tekgs.nextgen.luckyPet.behavior.ToStringBehavior;
import org.apache.commons.io.FileUtils;
import org.softwareonpurpose.coverage4test.CoverageReport;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Test
public abstract class GauntletTest {
    private static final CoverageReport reportManager = CoverageReport.getInstance();
    private final UiDriver driver = ChromeUiDriver.getInstance();
    private String feature;
    private String testName;
    private List<String> requirements = new ArrayList<>();

    @BeforeClass(alwaysRun = true)
    protected void initialize() {
        feature = this.getClass().getSimpleName().replace("Tests", "");
        WebUiHost.setUiDriver(driver);
    }

    @BeforeMethod(alwaysRun = true)
    protected void initializeTest(Method method) {
        testName = method.getName();
        System.out.println(String.format("Executing %s...", testName));
    }

    @AfterMethod(alwaysRun = true)
    protected void terminateTest(ITestResult result) {
        Object[] scenarios = result.getParameters();
        scenarios = scenarios.length == 0 ? null : scenarios;
        String feature = result.getTestClass().getRealClass().getSimpleName().replace("Tests", "");
        if (!requirements.isEmpty()) {
            for (String requirement : requirements) {
                reportManager.addRequirementTestEntry(testName, feature, scenarios, requirement);
            }
        } else {
            reportManager.addTestEntry(testName, feature, scenarios);
        }
        WebUiHost.quitInstance();
    }

    @AfterClass(alwaysRun = true)
    protected synchronized void reportClass() {
        String coverageFolder = "build/reports/coverage";
        File systemReport = new File(String.format("%s/system/%s.system.rpt", coverageFolder, feature));
        File requirementsReport = new File(String.format("%s/requirements/%s.requirements.rpt", coverageFolder, feature));
        try {
            FileUtils.writeStringToFile(systemReport, reportManager.getSystemCoverage(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(requirementsReport, reportManager.getRequirementsCoverage(), StandardCharsets.UTF_8);
            boolean newFile = systemReport.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void when() {
        System.out.printf("WHEN:%n");
    }

    protected void given(Object testData) {
        String testDataDescription = testData == null ? "<NULL>" : ToStringBehavior.getInstance(testData).execute();
        System.out.printf("GIVEN: %s%n", testData==null ? "" : testData.getClass().getSimpleName());
        System.out.println(testDataDescription);
    }

    protected void then(Calibrator calibrator) {
        Assert.assertEquals(calibrator.calibrate(), Calibrator.SUCCESS);
    }

    protected void addRequirements(String... requirements) {
        this.requirements.addAll(Arrays.asList(requirements));
    }

    public enum Endpoint {
        ;
        public static final String CHARGES = "charges";
    }

    public enum Service {
        ;
        public static final String STRIPE = "stripe";
    }

    public enum View {
        ;
        public static final String PURCHASE_CONFIRMATION = "purchase-confirmation";
        public static final String CHECKOUT = "checkout";
        public static final String SHOPPING_CART = "shopping-cart";
        public static final String PAYMENT_SUBMISSION = "payment-submission";
        public static final String ERROR = "error-404";
        public static final String LOGIN_FAILURE = "login-failure";
        public static final String PRODUCTS = "products";
        public static final String INVENTORY_DASHBOARD = "inventory-dashboard";
        public static final String FINANCIAL_DASHBOARD = "financial-dashboard";
        public static final String PETS = "pets";
    }

    public enum Application {
        ;
        public static final String LUCKY_PET_WEB = "lucky-pet-web";
    }

    public static class TestSuite {
        public static final String SMOKE = "smoke";
        public static final String RELEASE = "release";
        public static final String ACCEPTANCE = "acceptance";
        public static final String DEBUG = "debug";
    }
}

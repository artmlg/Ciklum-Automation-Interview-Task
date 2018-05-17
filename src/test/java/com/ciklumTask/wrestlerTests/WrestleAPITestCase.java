package com.ciklumTask.wrestlerTests;

import com.api.WrestlerController;
import com.api.models.CreateWrestlerModel;
import com.api.models.ReadWrestlerModel;
import com.ciklumTask.core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestleAPITestCase extends BaseTest {
    private CreateWrestlerModel testWrestler;

    @BeforeMethod
    public void beforeMethod() {
        String dateOfBirth = "25-05-1994";
        testWrestler = new CreateWrestlerModel(
                faker.name().firstName(),
                String.valueOf(faker.number().numberBetween(1, 20)),
                String.valueOf(faker.number().numberBetween(1, 20)),
                String.valueOf(faker.number().numberBetween(2013, 2017)),
                faker.name().lastName(),
                faker.name().lastName(),
                String.valueOf(faker.number().numberBetween(1, 3)),
                dateOfBirth,
                String.valueOf(faker.number().numberBetween(1, 3)),
                String.valueOf(faker.number().numberBetween(1, 3)),
                String.valueOf(faker.number().numberBetween(2, 3)),
                String.valueOf(faker.number().numberBetween(2, 3)));
    }

    @Test(description = "CREATE")
    public void testCreateNewWrestlerViaAPI() {
        CreateWrestlerModel wrestlerResponse = new WrestlerController(testWrestler).createNewWrestler();
        softAssert.assertTrue(wrestlerResponse.getResult(), "Wrestler is not created! > Result: False");
        softAssert.assertNotNull(wrestlerResponse.getIdWrestler(), "Wrestler ID is Null");
        softAssert.assertAll();
    }

    @Test(description = "READ")
    public void testReadWrestlerViaAPI() {
        WrestlerController wrestlerController = new WrestlerController(testWrestler);
        String getCreatedWrestlerID = wrestlerController.createNewWrestler().getIdWrestler();
        ReadWrestlerModel readWrestlerModel = wrestlerController.readWrestler(getCreatedWrestlerID);
        softAssert.assertEquals(testWrestler.getFname(), readWrestlerModel.getFname());
    }
}

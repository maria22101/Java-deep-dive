package HW_3_java_game.version_2_refactored;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {
    private static Model model;

    @BeforeClass
    public static void runTest() {
        model = new Model();
    }

    @Test
    public void setSecretValue() {
    }

    @Test
    public void testUpdateInputsHistory() {
        //inputsHistory array initial updates
        model.updateInputsHistory(1);
        model.updateInputsHistory(2);
        model.updateInputsHistory(3);
        int[] expectedInputsHistory = {1, 2, 3, 0};
        int expectedInputsElements = 3;
        int[] resultedInputsHistory = model.getInputsHistory();
        int resultedInputsElements = model.getElementsInInputsHistory();

        Assert.assertArrayEquals(expectedInputsHistory, resultedInputsHistory);
        Assert.assertEquals(expectedInputsElements, resultedInputsElements);

        //inputsHistory array resizing with next updates
        model.updateInputsHistory(4);
        model.updateInputsHistory(5);
        int[] expectedResizedInputsHistory = {1, 2, 3, 4, 5};
        int expectedInputsElementsAfterResize = 5;
        int[] resultedResizedInputsHistory = model.getInputsHistory();
        int resultingInputsElementsAfterResize = model.getElementsInInputsHistory();

        Assert.assertArrayEquals(expectedResizedInputsHistory, resultedResizedInputsHistory);
        Assert.assertEquals(expectedInputsElementsAfterResize, resultingInputsElementsAfterResize);
    }

    @Test
    public void testGetInputsHistoryInString() {
        model.updateInputsHistory(10);
        model.updateInputsHistory(20);
        model.updateInputsHistory(30);
        String expectedResult = "{10 20 30}";
        String result = model.getInputsHistoryInString();

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void checkInputIfEqualSecretValue() {
    }

    @Test
    public void checkInputIfMoreThanSecretValue() {
    }

    @Test
    public void checkInputIfLessThanSecretValue() {
    }
}
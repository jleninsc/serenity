import net.thucydides.core.annotations.Step;

public class SampleSteps {
    private int result;

    @Step
    public void performSomeAction(int number1, int number2) {
        result = number1 + number2;
    }

    @Step
    public void verifyResult(int expectedSum) {
        if (result != expectedSum) {
            throw new AssertionError(
                    "El resultado de la suma no es el esperado. Esperado: " + expectedSum + ", Actual: " + result);
        }
    }
}
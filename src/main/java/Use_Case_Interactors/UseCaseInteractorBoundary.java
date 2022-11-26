package Use_Case_Interactors;

/**
 * UseCaseInteractorBoundary manages all inputs and outputs between the controller layer and the use case layer
 * to allow for data transfer without violating the dependency rule.
 */
public interface UseCaseInteractorBoundary {
    /**
     * Controller layer sends data use case layer through boundaryInput()
     */
    public static void boundaryInput() {

    }

    /**
     * Use case layer sends data to Controller layer through boundaryOutput()
     */
    public static void boundaryOutput() {

    };
}


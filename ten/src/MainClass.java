import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public void main(String carId, String color, String engine, String size, Integer damageCode) {
        if (color.equals("red") || color.equals("black")) {

            List<String> partsToBeReplaced = step1(carId, color, engine, size, damageCode);

            if (partsToBeReplaced == null) {
                String errorMessage = "Car " + carId + " can't be repaired.";
                System.out.println("Fatal: No parts to be replaced");
                throw new RuntimeException(errorMessage);
            }

            step2(carId, color, engine, size, partsToBeReplaced);
        } else {
            System.out.println("Error: We repair only red and black bobby cars.");
        }
    }

    // First, we identify the required spare parts
    public List<String> step1(String carId, String color, String engine, String size, Integer damageCode) {
        List<String> partsToBeReplaced = new ArrayList();

        if (damageCode == 324) {
            // Worn tyres
            partsToBeReplaced.add("tyre");
        } else if (damageCode == null) {
            System.out.println("Error: Nothing to repair.");
            throw new RuntimeException("Error: Nothing to repair.");
        } else if (damageCode == 731) {
            // Horn not working anymore
            partsToBeReplaced.add("horn");
        } // so on ...

        boolean isProductRecall = color.equals("red") && engine.equals("feet") && size.equals("M");
        if (isProductRecall) {
            // There is a product recall for this type of car. Metal axle has to be replaced
            partsToBeReplaced.add("metal axle");
        }

        return partsToBeReplaced;
    }

    // Next, we repair the car
    public void step2(String carId, String color, String engine, String size, List<String> partsToBeReplaced) {
        List<String> partsToBeBilled = new ArrayList<>();

        for (int i = 0; i < partsToBeReplaced.size(); i++) {
            System.out.println("Repairing " + partsToBeReplaced.get(i));
            partsToBeBilled.add(partsToBeReplaced.get(i));

            boolean isProductRecall = color.equals("red") && engine.equals("feet") && size.equals("M");
            if (isProductRecall) {
                // Parts that are replaced in the context of a product recall, are free of charge
                partsToBeBilled.remove(partsToBeReplaced.get(i));
            }
        }

    }
}

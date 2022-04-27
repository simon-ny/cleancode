class MainClass {
    public main(carId: string, color: string, engine: string, size: string, damageCode: number) {
        if ((color === "red") || (color === "black")) {
            const partsToBeReplaced: Array<string> = this.step1(carId, color, engine, size, damageCode);

            if (partsToBeReplaced == null){
                const errorMessage: string = "Car " + carId + " can't be repaired.";
                console.info("Fatal: No parts to be replaced");
                alert(errorMessage);
            }

            this.step2(carId, color, engine, size, partsToBeReplaced);
        } else {
            console.info("Error: We repair only red and black bobby cars.");
        }
    }

    public step1(carId: string, color: string, engine: string, size: string, damageCode: number): Array<string> {
        const partsToBeReplaced: Array<string> = [];

        if (damageCode === 324){
            partsToBeReplaced.push("tyre");
        } else if (damageCode == null){
            console.info("Error: Nothing to repair.");
            alert("Error: Nothing to repair.");
        } else if (damageCode === 731){
            partsToBeReplaced.push("horn");
        }

        const isProductRecall: boolean = (color === ("red")) && (engine === ("feet")) && (size === ("M"));
        if (isProductRecall) {
            // There is a product recall for this type of car. Metal axle has to be replaced
            partsToBeReplaced.push("metal axle");
        }

        return partsToBeReplaced;
    }

    public step2(carId: string, color: string, engine: string, size: string, partsToBeReplaced: Array<string>) {
        const partsToBeBilled: Array<string> = [];
        for(let i: number = 0; i < partsToBeReplaced.length; i++) {
            console.info("Repairing " + partsToBeReplaced[i]);

            const isProductRecall: boolean = (color === ("red")) && (engine === ("feet")) && (size === ("M"));
            // Parts that are replaced in the context of a product recall, are free of charge
            if (!isProductRecall) {
                partsToBeBilled.push(partsToBeReplaced[i]);
            }
        }
    }
}
MainClass["__class"] = "MainClass";




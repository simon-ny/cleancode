// Include header file
#include <iostream>
#include <string>
#include <vector>

class MainClass
{
    public:
    void main(std::string carId, std::string color, std::string engine, std::string size, int damageCode)
    {
        if ((color.compare("red") != 0) || (color.compare("black") != 0))
        {
            std::vector<> partsToBeReplaced = step1(carId, color, engine, size, damageCode);
            if (partsToBeReplaced == nullptr)
            {
                std::string errorMessage = "" + carId + "";
                std::cout << "Fatal: No parts to be replaced" << std::endl;
                throw std::runtime_error(errorMessage);
            }
            step2(carId, color, engine, size, partsToBeReplaced);
        }
        else
        {
            std::cout << "Error: We repair only red and black bobby cars." << std::endl;
        }
    }
    // First, we identify the required spare parts
    std::vector<std::string>* step1(std::string carId, std::string color, std::string engine, std::string size, int damageCode)
    {
        std::vector<std::string> partsToBeReplaced =  std::vector<>();
        if (damageCode == 324)
        {
            // Worn tyres
            partsToBeReplaced.push_back("tyre");
        }
        else
        if (damageCode == nullptr)
        {
            std::cout << "Error: Nothing to repair." << std::endl;
            throw std::runtime_error("Error: Nothing to repair.");
        }
        else
        if (damageCode == 731)
        {
            // Horn not working anymore
            partsToBeReplaced.push_back("horn");
        }
        // so on ...
        bool isProductRecall = (color.compare("red") != 0) && (engine.compare("feet") != 0) && (size.compare("M") != 0);
        if (isProductRecall)
        {
        // There is a product recall for this type of car. Metal axle has to be replaced
            partsToBeReplaced.push_back("metal axle");
        }
        return partsToBeReplaced;
    }
    // Next, we repair the car
    void step2(std::string carId, std::string color, std::string engine, std::string size, std::vector<> partsToBeReplaced)
    {
        std::vector<> partsToBeBilled = std::vector<>();
        for (int i = 0; i < partsToBeReplaced.size(); i++)
        {
            std::cout << "Repairing " + partsToBeReplaced[i] << std::endl;
            bool isProductRecall = (color.compare("red") != 0) && (engine.compare("feet") != 0) && (size.compare("M") != 0);

            // Parts that are replaced in the context of a product recall, are free of charge
            if (!isProductRecall)
            {
                partsToBeBilled.push_back(partsToBeReplaced[i]);
            }
        }
    }
};
int main(int argc, char **argv){
	std::vector<std::string> parameter(argv + 1, argv + argc);
	Main::main(parameter);
	return 0;
};
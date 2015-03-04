/*
 * The Objective Function class contains the function that the genetic algorithm will try
 * to maximise/minimise.
 */

package GA;

public class ObjectiveFunction {

    //A method containing the objective function. Returns the result.
    public double ObjectiveFunction(double[] variables) {
        return ((10 * variables[0]) * (9 * variables[1]) * (Math.pow(variables[2], 3)));
    }
    
}

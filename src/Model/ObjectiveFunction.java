/*
 * The Objective Function class contains the function that the genetic algorithm will try
 * to maximise/minimise.
 */

package Model;

public class ObjectiveFunction {

    //A method containing the objective function. Returns the result. The default
    //objective function is De Jong's 5th function which should have bounds of 
    // -66 - +66.
    public double ObjectiveFunction(double[] variables) {
        double answer = 0.002;
        for(int i = 1; i <= 25; i++) {
            double interim = 0;
            for(int j = 1; j <= 2; j++) {
                interim =  Math.pow((variables[0] - variables[1]), 6);
            }
            answer += (1 / (i + interim));
        }
        return answer;
    }
    
}

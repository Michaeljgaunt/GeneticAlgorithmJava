package GA;

public class ObjectiveFunction {
     
    public double ObjectiveFunction(double[] variables) {
        return ((10 * variables[0]) * Math.sin(variables[1]) + (4 * variables[1]));
    }
    
}

package GA;

public class ObjectiveFunction {
     
    public double ObjectiveFunction(double[] variables) {
        return ((10 * variables[0]) * (9 * variables[1]) * (Math.pow(variables[2], 3)));
    }
    
}

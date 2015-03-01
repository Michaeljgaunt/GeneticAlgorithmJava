
public class ObjectiveFunction {
     
    public double ObjectiveFunction(double x, double y, double z) {
        return (10 * x) * Math.sin(y) * Math.pow(z, x) + (4 * y);
    }
    
}

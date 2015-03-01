
public class ObjectiveFunction {
     
    public double ObjectiveFunction(double x, double y, double z, double s) {
        return ((10 * x) * Math.sin(y) + (4 * y)) / (Math.cos(s) + Math.pow(z, s));
    }
    
}

public class Mars extends SolarObject {
    double velocity = 1.2;

    public Mars(double distance, double angle, double diameter, String color){
        super(distance,angle,diameter,color);
        
    }

    public void move(){
        s.drawSolarObject(distance, angle, diameter, col);
        angle=angle+velocity;
    }
}

public class Saturn extends SolarObject {
    
    double velocity = 0.375;
    
    public Saturn(double distance, double angle, double diameter, String color){
        super(distance,angle,diameter,color);
        
    }

    public void move(){
        //for(int i = 0; i>=0; i++){
            s.drawSolarObject(distance, angle, diameter, col);
            angle=angle+velocity;
        //}
    }
    
}

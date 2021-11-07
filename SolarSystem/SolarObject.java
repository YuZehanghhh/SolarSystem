
public class SolarObject implements SolarSystemController{
	double velocity;
	public SolarSystem s;
    double distance;
	double angle;
	double diameter;
	String col;
	String name;
	String Pname;

	public SolarObject(double distance,double angle,double diameter,String color){
		this.distance = distance;
		this.angle = angle;
		this.diameter = diameter;
		this.col = color;
		
	}

	public void move(){
		for(int i=0; i>=0; i++){
			s.drawSolarObject(distance, angle+i, diameter, col);
		}
	}

	public void finishedDrawing(){
		s.finishedDrawing();
	}

	public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour){
		this.name = name;
		this.distance = orbitalDistance;
		this.angle = initialAngle;
		this.diameter = size;
		this.velocity = speed;
		this.col = colour;	
	}

	public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour, String parentName){
		this.name = name;
		this.distance = orbitalDistance;
		this.angle = initialAngle;
		this.diameter = size;
		this.velocity = speed;
		this.col = colour;	
		this.Pname = parentName;
	}

	public void remove(String name){
		this.name = name;
	}


	

}

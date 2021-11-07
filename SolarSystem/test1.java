public class test1 {
    
    public static void main(String[] args) {
        test1 t = new test1();
        t.run();
    }
    public void run(){
        SolarSystem s = new SolarSystem(800, 800);

        SolarObject sun = new Sun(0,0,80,"YELLOW"); 
        sun.s = s;
        SolarObject earth = new Earth(100,20,30,"BLUE");
        earth.s=s;
        SolarObject mars = new Mars(150,50,20,"RED");
        mars.s=s;
        SolarObject saturn = new Saturn(250,200,50,"ORANGE");
        saturn.s=s;

        //sun.setVelocity(0);
        //e.setVelocity(1);
        //mars.setVelocity(2);

        //int x = 0;
        //x for the volecity

        /*for(x=0; x>=0; x=x+1){
            sun.ss.drawSolarObject(0, 0, 80, "YELLOW");
            earth.ss.drawSolarObject(100, x, 30, "BLUE");
            mars.ss.drawSolarObjectAbout(200, 20, 20, "RED",0,0);
            s.finishedDrawing();
            }*/
        for(int i=0; i>=0; i++){
           sun.move();
           earth.move();
           mars.move();
           saturn.move();
           s.finishedDrawing();
        }
    }
}
       
      



import java.util.ArrayList;


public class BuilderMain {
    public BuilderMain(){}
    public ArrayList<Ball> implementBuild(int cantidad,int velocidad,String color,int orientacion){
        ArrayList<Ball> arr = new ArrayList();
        for(int i=0;i<cantidad;i++){
            Ball b = new Ball.BallBuilder().setColor(color).setVelocidad(velocidad).setOrientacion(orientacion).build();
            arr.add(b);
        }
        return arr;
    } 
}

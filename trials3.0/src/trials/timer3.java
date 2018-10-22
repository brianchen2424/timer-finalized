package trials;
import java.util.Timer;
import java.util.TimerTask;

public class timer3 {
	Timer timer = new Timer();
	   double timePassed = 0.00;
	   static double z = 0.00;
	   //starts at 0.00
	   TimerTask task = new TimerTask() {
		   public void run() {
			  timePassed++;
			  z = timePassed;
			  //increments at 0.001 of a second
			  //System.out.println("Time Passed: " + timePassed);
			/*if(timePassed == 18.0) {
				System.exit(0);
			}*/
		
			
		   }
	   };
	   public void start() {
	   timer.scheduleAtFixedRate(task,1000,1);
	   // increments at 0.001 thousandths of a second, 1000 is 1 second
	   }
	   public double getTime() {
		     //return this.timePassed;
		   return z;
		  }
	   //supposed to allow Mainclass to getTime but is not used
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		//timer run = new timer ();
		//run.start();
	//}
	//not used
}
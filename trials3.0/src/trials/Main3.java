package trials;
import java.util.*;

import trials.timer3;
//imports timer file

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//for processing the entering of key 's'

import javax.swing.JFrame;
import javax.swing.JTextField;
// for text field to enter 's'


public class Main3 {
	static double x;
	// variable for 
	static timer3 run = new timer3 ();
	//creates timer

  public static void main(String[] argv) throws Exception {
	
	 
    JTextField component = new JTextField();
    component.addKeyListener(new MyKeyListener());
   JFrame f = new JFrame();
   f.add(component);
    f.setSize(300, 300);
    f.setVisible(true);
  //makes a textfield where you can type in s; 
    //create textbox to recieve data input; l, r,k, e
    System.out.println("START");
	run.start();
	//run.getTime();
	//runs timer
	
  }
  public static double getTime() {
	     //return this.timePassed;
	   return run.getTime();
	  }
}
class MyKeyListener extends KeyAdapter {
	public ArrayList<Double> timestampLaser = new ArrayList<>();
	//records laser firing times
	public ArrayList<Double> timestampUserInput = new ArrayList<>();
	// records user input clicking times
	public ArrayList<Integer> record = new ArrayList<Integer>();
	// records if the alternative laser is being fired one designed not to trigger a response
	public ArrayList<String> reactiontime = new ArrayList<String>();
	// array to store reaction times for specifically hits and false alarms and all other cases are represented by errors
	public ArrayList<String> result = new ArrayList<String>();
	//displays hit, false alarm, miss, correct rejection
	
	boolean l = false;
	// laser firing is not firing
	boolean r = false;
	// reaction is not triggered
	boolean k = false;
	// alternative laser is not firing
	   public void keyPressed(KeyEvent evt) {
	 if (evt.getKeyChar() == 'l' && l == false && k == false) {
	    double y = Main3.getTime();
	    timestampLaser.add(y);
	    l = true;
	    record.add(0);
	    // l scenario where laser is fired
	    // if laser is fired and the previous input was neither a laser or alternative laser firing
	    //get the time and record the time in timestampLaser array list and set laser firing to be true
	    // record 0 in the record array to indicate later that this was not the alternative laser firing
	    }
	     else if (evt.getKeyChar() == 'l' && l == true && k == false) {
	    	 l = true;
	  	  double q = Main3.getTime();
	  	    timestampLaser.add(q);
			 timestampUserInput.add(0.00);
			 record.add(0);
			 // ll scenario two back to back laser firings with no userinput after first firing
			 //if laser is fired and the previous command was also laser firing that means an response was not
			 //given after the first laser thus add a 0.00 to arraylist timestampuserinput to indicate user did not
			 //respond and add the new laser firing time to timestamplaser arraylist
			// record 0 in the record array to indicate later that this was not the alternative laser firing
		 }
	     else if (evt.getKeyChar() == 'l' && k == true && l == false) {
	    	double f = Main3.getTime();
	  	    timestampLaser.add(f);
			 timestampUserInput.add(0.00);
			 record.add(0);
			 l = true;
	    	 k = false;
	    	 //kl scenario, alternative laser fires with no userresponse followed by laser
	    	 //if alternate laser is fired and user does no respond thus keeping K true and then the normal laser
	    	 //is fired and then that means patient correctly did not respond to the fake laser
	    	 //thus record the time of the laser fire (record 0 for record because it's not alternate laser firing"
	    	 //set userinput for the previous firing of K , the alternative laser as 0.indicating no user response
	    	 // reset k alternative laser to not firing
	    	 // set l = true because l is firing
		 }
	 else if (evt.getKeyChar() == 'k' && k == false && l == false) {
		 double q = Main3.getTime();
		 timestampLaser.add(q);
		 l = false;
		 k = true;
		 record.add(1);
		 // just k firing
		 //if alternative laser is firing and no other laser has previously fired
		 //obtain time of fire and add it to timestamplaser
		 //set laser firing to false and alternative laser firing to true
		 // put 1 in record to indicate alternative laser firing
	 }
	 else if (evt.getKeyChar() == 'k' && l == true && k == false) {
		 timestampUserInput.add(0.00);
		 double q = Main3.getTime();
		 timestampLaser.add(q);
		 l = false;
		 k = true;
		 record.add(1);
		 //for lk scenario, laser is fired, followed by alternative laser with no user response in between
		 //if alternative laser is firing and previously laser had fired, that means the subject
		 //missed that laser firing so put userinput as 0.00 for that firing
		 // but add the time the alternative laser firing to timestamplaser to calulate reaction time later
		 // set k = true to indicate alternate laser firing and normal laser to not firing
		//add 1 to indicate alternative lase firing
	 }
	 else if (evt.getKeyChar() == 'k' && k == true && l == false) {
		 timestampUserInput.add(0.00);
		 double q = Main3.getTime();
		 timestampLaser.add(q);
		 l = false;
		 k = true;
		 record.add(1);
		 // for kk scenario, where consecutive alternative laser are fired consecutively
		 // since user didn't response set userinput for 0, get time for alternative laser firing
		 //set k firing to true
		 //add 1 to indicate alternative lase firing
	 }
	 else if (evt.getKeyChar() == 'r' && l == true && k == false) {
	    	 l = false;
	   double z = Main3.getTime();
	    timestampUserInput.add(z);
	    // lr scenario
	   //if normal laser is fired thus l== true  and a userinput or r is detected, recorded userinput
	    //time response in arraylist
	    
	     }
	 	    else if (evt.getKeyChar() == 'r' && l == false && k == true) {
	 	    	double a = Main3.getTime();
	 	    	timestampUserInput.add(a);
	 	    	k= false;
	 	       // kr scenario
	 		   //if alternative laser is fired thus  k == true  and a userinput or r is detected, recorded userinput
	 		    //reset K= false, "turnt" off alternative laser
	 		    
	 	    }
	 	
	     else if (evt.getKeyChar() == 'e') {
	    	 for(int x = 1; x>0; x++) {
	    	 if(timestampLaser.size()> timestampUserInput.size()) {
	 	    	timestampUserInput.add(0.00);	
	 	    //if timestamplaser array size is bigger than input size, that means at the end you either ended with a 
	 	    	// laser firing or alternative laser firing thus no userinput was recorded thus add a 0.00 until the array is filled
	 	    	
	 	    }
	    	 else if(timestampLaser.size() < timestampUserInput.size()) {
		 	    	timestampLaser.add(0.00);	
		 	    	record.add(0);
		 	    	//if timestampuserinput array size is bigger than timestamplaser size, that means at the end you either ended with a 
		 	    	// bunch or r, or just put in for in case it happens but in theory it shouldn't
		 	    	// because standalone r not initiated by a kind of laser(l,k) is ignored.
		 	    	// but fill the array list to match the arraylist size and add 0 to record to indicate these
		 	    	//laser firing are not alternative laser firing,
		 	    }
	    	 }
	    	System.out.println("Times in Miliseconds for Laser: "+timestampLaser);
	    	//prints out array list for laser firing
	    	System.out.println("Times in Miliseconds for UserInput: "+timestampUserInput);
	    	//prints out array list for user input
	    	for(int x = 0; x< timestampLaser.size(); x++)
	    	{
	    		//goes for entire length of timestamplaser since now both arrays should be the same
	    		if(timestampUserInput.get(x)== 0 || timestampLaser.get(x)== 0) {
	    			reactiontime.add("error");
	    			// adds error time to reactiontime when either timestampuserinput or its corresponding
	    			//timestamplaser display a zero which occurs for miss, or correct rejections
	    			//essentially whenever the subject doesn't respond
	    		}
	    		else{
	    			
	    			double y = timestampUserInput.get(x) - timestampLaser.get(x);
	    			String numberAsString = Double.toString(y);
	    			reactiontime.add(numberAsString);
	    			// find the difference between laser firing and userinput to get reaction time
	    			//once rection time is obtained convert it to a string and put it in reaction time arraylist
	    			//for hits and false alarms
	    			//essnetially when there is some type of laser firing(k,l) and the user responds to it
	    		
	    		}
	    	}
	    	
	    	System.out.println("Reaction Time:"+reactiontime);
	    	//displays difference between laser and userinput
	    	
	    	 
	    	
	    	for(int x = 0; x< timestampLaser.size(); x++)
	    	{
	    		//produces the results
	    	if(timestampUserInput.get(x) == 0.00 && timestampLaser.get(x)>0.00 && record.get(x) == 0) {
    			result.add("miss");
    			// misses if user doesn't respond, and a laser is fired, and that laser being a normal laser
    		}
	    	else if(timestampUserInput.get(x) == 0.00 && timestampLaser.get(x) > 0.00 && record.get(x) == 1) {
    			result.add("correct rejection");
    			//correct rejection, if no user input, a laser is fired, that being the alternative laser
    		}
	    	else if(timestampUserInput.get(x) > 0.00 && timestampUserInput.get(x) > 0.00 && record.get(x) == 1 ) {
    			result.add("false alarm");
    			//false alarm, if a laser is fired, that laser being the alternative laser, and the user responds
    		}
	    	else {
    			result.add("hit");
    			//else basically is user responds to a laser that is fired and that laser is the normal laser
    		}
	    	}
	    	
	    	System.out.println("Result"+result);
	    	//prints results
	    	//hit:lt:pt
	    	//miss:lt:pn
	    	//false alarm: ln:pt
	    	//correct rejection: ln:pn
	    	System.exit(0);
	    	//press e to end program and get results
	     }
	     }
	   // ignores if subject sends response with no laser input
	   // r = user input
	   // l = laser
	   // e = end
	   }


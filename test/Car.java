import javax.swing.*;
import java.awt.*;


//public class Car with properties
public class Car {
	 String make;
	 int year;
	 String color;
	 public int speed;
	public double distance;
	public int carnum;
	JButton mybutton = new JButton();
     DrawPanel p;
     
  
	public void draw() {
		mybutton.setText(carnum + "-" + (int) distance + "(" + speed + ")");
		 ImageIcon iIcon = new ImageIcon("src/images/race" + carnum + ".jpg");
		  Image img;
		  Image temp = iIcon.getImage();
		  img = temp.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
		  iIcon = new ImageIcon(img);
		  mybutton.setIcon(iIcon);
		  mybutton.setHorizontalTextPosition(SwingConstants.LEFT);
		  mybutton.setHorizontalAlignment(SwingConstants.RIGHT);
		mybutton.setSize(200+ (int) distance*5,50); 
		mybutton.setLocation(0,carnum * 60);
		if (distance >99.9) { mybutton.setBackground(Color.green);}
	}
	public void setDistance(double indistance) {
		distance = indistance;
	}
	public double getDistance() {
		return distance;
	}
	
	// setter function for Accelerate
public void setAccelerate(int year){
	//if before 2010, speed+=15
	if (year<2010){
		speed+=15;
	}
	//if after 2010, speed+=30
	else if (year>=2010){
		speed+=30;
	}
	}

//getter function for Accelerate
public  int getAccelerate(){
	return speed;
}

//setter Brake function
public  void setBrake(int year){
	//if before 2010, speed-=5
	if (year<2010){
		speed-=5;
	}
	//if after 2010, speed-=10
	else if (year>=2010){
		speed-=10;
	}
	//if speed goes negative, set to zero
	if (speed<0){
		speed=0;
	}
}

//getter function for Brake
public  int getBrake(){
	return speed;
}

//setter function for Stop
public  void setStop(int year){
	// set speed to 0
	speed=0;
}


//getter Stop function
public  int getStop(){
	return speed;
}

//setter Color function
public  void setColor(String input){
	color=input;
}

//getter Color function
public  String getColor(){
	return color;
}

//setter Year function
public  void setYear(int i){
	year=i;
}


//getter Year function
public int getYear(){
	return year;
}

//setter Make function
public  void setMake(String setmake){
	make=setmake;
}

// getter Make function
public  String getMake(){
	return make;
}

//Constructor
public Car(int carnum, DrawPanel inp){
	p=inp;
	mybutton = new JButton();
	mybutton.setLocation(100,carnum*20);
	mybutton.setSize(100,15);
	p.add(mybutton);
	speed=0;
}


}

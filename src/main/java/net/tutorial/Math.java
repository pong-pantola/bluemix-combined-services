package net.tutorial;

public class Math{

  //will be used in the multiply method to simulate that
  //the multiply method is taking too long to execute
  private void delay(){
    try{
      Thread.sleep(3000);//3000 msec. or 3 sec. delay
    } catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  public int add(int a, int b){
    return a+b;
  }
  
  public int sub(int a, int b){
    return a-b;
  }  

  public int multiply(int a, int b){
    return a*b;
  }
}
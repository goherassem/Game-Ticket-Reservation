/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameticket_package;

import java.util.Scanner;

public class GameTicket {

    /**
     * main method that contain single array of games that are national and international
     * contain array of seats to different games
     * call all functionalities of fan account
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        game g[] = new game[6];
        seats s[] = new seats[6];
        s[0] = new seats(10,10,10);
        s[1] = new seats(5,10,15);
        s[2] = new seats(15,10,5);
        s[3] = new seats(20,30,40);
        s[4] = new seats(15,15,10);
        s[5] = new seats(5,6,12);
        
        g[0]=  new national_game("Football","Ahly","Zamalek","Cairo",1,8,2021,s[0],101);
        g[1]=  new national_game("Basketball","Wady degla","Heliopolis","Alexandria",1,10,2021,s[1],102);
        g[2] = new national_game("Tennis","Ismailia ","Petrojet","Assiout",11,6,2020,s[2],103);
        g[3] = new international_game("Football","Egypt","Argentina","Egypt",1,9,2020,s[3],104);
        g[4] = new international_game("Vollyball","Brazil","italy","italy",15,6,2021,s[4],105);
        g[5] = new international_game("Handball","german","Russia","cairo",12,6,2021,s[5],106);
        
       fan_account fan[] = new fan_account[5];
       for (int i = 0 ; i<fan.length;i++){
           fan[i] = new fan_account(i+1);
           while(true){
               System.out.println("it is the fan number: "+ (i+1));
               System.out.println("if you want to check seats availability or reserve a ticket press 1 , canel reservation press 2 , make a bet for the game result 3 , upgrade seat category 4 , 5 to exit  ");
               int choose = input.nextInt();
               if(choose == 1){
                   fan[i].ticket_reservation(g);
                   fan[i].display();
               }
               else if(choose == 2){
                   fan[i].cancelreservation();
                   fan[i].display();
               }
                else if(choose == 3){
                    fan[i].make_bet();
                    fan[i].display();
                }
               else if(choose == 4){
                   fan[i].upgrade_seat();
                   fan[i].display();
               }
               else if(choose == 5)
                   break;
               else
                   System.out.println("you should press a number from above");
                   
               
           }
           System.out.println("if you want to exit from all program press(y) , get another fan press(n)");
           char h = input.next().charAt(0);
           if(h=='y' || h== 'Y')
               break;
       }
        
        
        
        
        
       
        
        
        
        
        
    }
    
    
}
/** An abstract class that extend from it two types of games national and international
 *  it represent a parent class of inheritance tree
 *  assign common data members of two sub classes 
 *  it has different access modifiers
 */
abstract class game {
    
    int generated_code;
    protected String stadium_name;
    private int day;
    private int month;
    private int year;
    private String first_team;
    private String second_team;
    private String game_type;
    
    game(String stadium_name ,int day, int month ,int year,String first_team , String second_team,String game_type,int generated_code ) {
    
    this.generated_code = generated_code;
    this.first_team = first_team;
    this.second_team= second_team;
    this.game_type= game_type;
    this.stadium_name = stadium_name;
    this.day = day;
    this.month=month;
    this.year = year;
    
    
    }
    /**
     * check the available seats in 1st , 2nd ,3rd category
     * and reserve the seat you want 
     * @return 1 if the seat is reserved and -1 if not reserved
     */
    abstract int check_seatsavail();
    /**
     * if anyone cancel his seat it will increase available seats
     * @param catgnum the number of category to increase its seats
     */
    abstract void increaseseats(int catgnum);
    /** 
     * @return code of this game
     */
    public int getGenerated_code() {
        return generated_code;
    }
    /**
     * @return stadium name or location of this game
     */
    public String getStadium_name() {
        return stadium_name;
    }
  /**
   * @return day of the game
   */
    public int getDay() {
        return day;
    }
    /**
     * 
     * @return month of the game 
     */
    public int getMonth() {
        return month;
    }
    /**
     * 
     * @return year of the game
     */
    public int getYear() {
        return year;
    }
    /**
     * 
     * @return name of the first team
     */
    public String getFirst_team() {
        return first_team;
    }
    /**
     * 
     * @return name of the second team
     */
    public String getSecond_team() {
        return second_team;
    }
    /**
     * 
     * @return type of the game 
     */
    public String getGame_type() {
        return game_type;
    }



}
/**
 * sub class of inheritance tree that extends from class game
 * and it is type of games that are national
 * it has different access modifiers
 */
 class national_game extends game{
    

    
    private int av_seats_firstcategory;
    private int av_seats_secondcategory;
    private int av_seats_thirdcategory;
    seats s;
    /**
     * gives to parent constructor the data members wanted
     * assign available seats of each game
     */
    national_game(String game_type,String first_team , String second_team ,String stadium ,int day,int month,int year,seats L ,int generated_code){
        super(stadium,day,month,year,first_team,second_team,game_type,generated_code);
        
        s = L;
        av_seats_firstcategory = L.no_fc;
        av_seats_secondcategory = L.no_sc;
        av_seats_thirdcategory = L.no_tc;
        
    
    }
    /**
     * overriding method run time polymorphism
     * check the available seats in 1st , 2nd ,3rd category in national game
     * and reserve the seat you want 
     * @return 1 if the seat is reserved and -1 if not reserved
     */
   public int check_seatsavail(){
        Scanner input = new Scanner(System.in);
       
        System.out.printf("there is %d seats are available in first category, %d in second category , %d in third category\n",av_seats_firstcategory,av_seats_secondcategory ,av_seats_thirdcategory);
            System.out.println("if you want to reserve seats in first category press 1 , second category 2 , third category 3");
            int x= input.nextInt();
        
        if (x==1){
            if(av_seats_firstcategory>0){
                s.seat(1);
                av_seats_firstcategory--;
            }
                else{
                    System.out.println("there is no available seats");
                    return -1;
                }
                
            }
            
        
        else if(x==2){
            
        if(av_seats_secondcategory>0){ 
               
                s.seat(2);
                av_seats_secondcategory--;
        }
                else{
                    System.out.println("there is no available seats");
                    return -1;
                }
                
            }
       
        
        
        
        
        else if(x==3){
            
        if(av_seats_thirdcategory>0){
                s.seat(3);
                av_seats_thirdcategory--;
        }
                else{
                    System.out.println("there is no available seats");
                    return -1;
                }
                
        
        }
        
        else
            return -1;
                    
        return 1;
   }
   /**
     * overriding method run time polymorphism
     * if anyone cancel his seat it will increase available seats
     * @param catgnum the number of category to increase its seats
     */
   
   public void increaseseats(int catgnum){
       if(catgnum==1){
           av_seats_firstcategory++;
           s.cancelf();
       }
       else if(catgnum==2){
           av_seats_secondcategory++;
           s.cancels();
       }
       else {
           av_seats_thirdcategory++;
           s.cancelt();
       }
   }
        
    
    
     



}
/**
 * sub class of inheritance tree that extends from class game
 * and it is type of games that are international
 * it has different access modifiers
 */
 class international_game extends game{

    
    private int av_seats_firstcategoryi;
    private int av_seats_secondcategoryi;
    private int av_seats_thirdcategoryi;
    seats se;
    /**
     * gives to parent constructor the data members wanted
     * assign available seats of each game
     */
    international_game(String game_type,String first_team , String second_team ,String stadium ,int day,int month,int year,seats L,int generated_code ){
        super(stadium,day,month,year,first_team,second_team,game_type,generated_code);
        
        se = L;
        av_seats_firstcategoryi=L.no_fc;
        av_seats_secondcategoryi = L.no_sc;
        av_seats_thirdcategoryi = L.no_tc;
        
        
    
    }
    /**
     * overriding method run time polymorphism
     * check the available seats in 1st , 2nd ,3rd category in international game
     * and reserve the seat you want 
     * @return 1 if the seat is reserved and -1 if not reserved
     */
   public int check_seatsavail(){
    
    
     Scanner input = new Scanner(System.in);
        System.out.printf("there is %d seats are available in first category, %d in second category , %d in third category \n",av_seats_firstcategoryi,av_seats_secondcategoryi ,av_seats_thirdcategoryi);
            System.out.println("if you want to reserve seats in first category press 1 , second category 2 , third category 3");
            int x= input.nextInt();
        if (x==1){
            if(av_seats_firstcategoryi>0){
               se.seat(1);
                av_seats_firstcategoryi--;
            }
                else{
                    System.out.println("there is no available seats");
                    return -1;
                }
                
            }
            
        else if(x==2){
            
        if(av_seats_secondcategoryi>0){
                
                se.seat(2);
                av_seats_secondcategoryi--;
                }
                else{
                    System.out.println("there is no available seats");
                    return -1;
                }
                
            }
        
        
        else if(x==3){
            
        if(av_seats_thirdcategoryi>0){
                
                se.seat(3);
                av_seats_thirdcategoryi--;
        }
                else{
                    System.out.println("there is no available seats");
                    return -1;
                }
                
            }
       
        else 
            return -1;
                    
        
    return 1;
    
    
    }
   /**
     * overriding method run time polymorphism
     * if anyone cancel his seat it will increase available seats
     * @param catgnum the number of category to increase its seats
     */
     public void increaseseats(int catgnum){
       if(catgnum==1){
           av_seats_firstcategoryi++;
           se.cancelf();
       }
       else if(catgnum==2){
           av_seats_secondcategoryi++;
           se.cancels();
       }
       else {
           av_seats_thirdcategoryi++;
           se.cancelt();
       }
   }
    
   


}

/**
 * interface class used to reserve the seats according category
 * and give to each seat its number and price
 * it is SOLID object-oriented design principle
 * Interface segregation principle (ISP)
 * it has final data members 
 */
interface sourceofseats{
   final int first_seats_price = 200;
   final int second_seats_price = 150 ;
   final int third_seasts_price = 100 ;
   
   
}
/**
 * interface class used to reserve and get back the number of seat that canceled of first category
 * it is SOLID object-oriented design principle
 * Interface segregation principle (ISP)
 */
interface firstcategory extends sourceofseats{
    void reserve_f();
    public void cancelf();
}
/**
 * interface class used to reserve and get back the number of seat that canceled of second category
 * it is SOLID object-oriented design principle
 * Interface segregation principle (ISP)
 */
interface secondcategory extends sourceofseats{
    void reserve_s();
    public void cancels();
}
/**
 * interface class used to reserve and get back the number of seat that canceled of third category
 * it is SOLID object-oriented design principle
 * Interface segregation principle (ISP)
 */
interface thirdcategory extends sourceofseats{
    void reserve_t();
   public void cancelt();
}

/**
 * class that implement interfaces classes 
 * and get back the number of seat that canceled
 *  it has static data members and different access modifiers
 */
 class seats implements firstcategory, secondcategory, thirdcategory {

   
   int number_of_1st;
   int number_of_2nd;
   int number_of_3rd;
   int no_fc;
   int no_sc;
   int no_tc;
   public static int finalprice;
   public static int number_of_seat;
   public static int category;
   /**
    * overloading constructor compile time polymorphism that assign data members
    * and there is calculated data members
    * @param no_fc it represent number of seats of first category
    * @param no_sc it represent number of seats of second category
    * @param no_tc  it represent number of seats of third category
    * 
    */
   seats(int no_fc,int no_sc,int no_tc){
        this.no_fc = no_fc;
        this.no_sc = no_sc;
        this.no_tc =no_tc; 
        number_of_1st = 0;
        number_of_2nd =no_fc;
        number_of_3rd = no_fc+no_sc;
        

}
   /**
    * overloading constructor compile time polymorphism that assign data members
    */
   seats(int no_fc,int no_sc){
       this.no_fc = no_fc;
       this.no_sc = no_sc;
       number_of_1st = 0;
       number_of_2nd =no_fc;
   }
   /**
    * reserve the seat according category
    * @param number number of category
    * 
    */
  public void seat(int number){
        if(number==1)
            reserve_f();
        else if(number==2)
            reserve_s();
        else
            reserve_t();
            
    }
  /**
   * overriding method
   * reserve a seat in first category
   * gives to it number and price
   */
    public void reserve_f(){
        
         number_of_1st++;
  
         finalprice = first_seats_price;
         number_of_seat=number_of_1st;
         category = 1;
        
    }
   /**
   * overriding method
   * reserve a seat in second category
   * gives to it number and price
   */
    public void reserve_s(){
       
          number_of_2nd++;
          
         finalprice = second_seats_price;
         number_of_seat=number_of_2nd;
         category = 2;
    }
    /**
   * overriding method
   * reserve a seat in third category
   * gives to it number and price
   */
    public void reserve_t(){
       
          number_of_3rd++;
        
         finalprice = third_seasts_price;
         number_of_seat=number_of_3rd;
         category=3;
    }
    /**
     * get back the number of seat of first category
     */
    public void cancelf(){
        number_of_1st--;
    }
    /**
     * get back the number of seat of second category
     */
    public void cancels(){
        number_of_2nd--;
    }
    /**
     * get back the number of seat of third category
     */
    public void cancelt(){
        number_of_3rd--;
    }
    

    
    

}
    /**
     * Exception handling
     * my own defined exception class that inherit from class Exception
     * use when user gives invalid input
     */

 class ioException extends Exception{
        public ioException(String massege){
            super(massege);
        }
    }

/**
 * class of fan account that can do following functionalities
 * check the seats availability, reserve a ticket, cancel reservation, make a bet, upgrade seat category ,display the ticket
 * it has builder design pattern , java defined exception and my own defined exception
 * different access modifiers , calculated data members , static and final methods
 */

 class fan_account{
    Scanner input = new Scanner(System.in);
    protected int fanid ;
    protected int seat_number;
    protected int seats_price;
    protected int seat_category;
    protected int game_code;
    String firstteam;
    String secondteam;
    String stadiumname;
    int day;
    int month;
    int year;
    fan_account []fanaccount =new fan_account[10];
    
    game g;
    static int todayday;
    static int todaymonth;
    static int todayyear;
    int result;
    int count=-1;
    /**
     * data member used to check number of bet
     * as only one bet is accepted for each game
     */
    int m = 1;
   
   /**
    * assign id of the sports fans
    * @param fen id of the sport fan
    * make result of bet random
    */
    fan_account(int fen){
        fanid = fen;
        result = fen;
    }
   /**
    * builder design pattern class that are static 
    * and assign the data members of the fan account
    */
    public static class fanBuilder{
   
    int seat_number;
    int seats_price;
    int seat_category;
    int game_code; 
    String firstteam;
    String secondteam;
    String stadiumname;
    int day;
    int month;
    int year;
   
    /**
     * constructor that assign the name of the first team and second team 
     */
    public fanBuilder(String firstteam,String secondteam){
        this.firstteam = firstteam;
        this.secondteam=secondteam;
    }
    /**
     * assign stadium name
     */
    public fanBuilder stadiumname(String stadiumname){
        this.stadiumname= stadiumname;
        return this;
    }
    /**
     * assign code of the game
     */
    public fanBuilder game_code(int game_code){
        this.game_code= game_code;
        return this;
    }
    /**
     * assign seat number of sport fan
     */
    public fanBuilder seat_number(int seat_number){
        this.seat_number= seat_number;
        return this;
    }
    /**
     * assign seat price of sport fan
     */
    public fanBuilder seats_price(int seats_price){
        this.seats_price= seats_price;
        return this;
    }
    /**
     * assign seat category of sport fan
     */
     public fanBuilder seat_category(int seat_category){
        this.seat_category= seat_category;
        return this;
    }
     /**
     * assign date of the ticket
     */
     public fanBuilder date(int day,int month,int year){
        this.day= day;
        this.month =month;
        this.year = year;
        return this;
    }
     /**
      * method that build the fan account data members by creating object of it and assign all data members by data
      * @return the object that contain all data
      */
     public fan_account build(){
         fan_account fan = new fan_account(1);
         fan.firstteam = this.firstteam;
         fan.secondteam= this.secondteam;
         fan.stadiumname = this.stadiumname;
         fan.game_code = this.game_code;
         fan.seat_category = this.seat_category;
         fan.seats_price = this.seats_price;
         fan.seat_number = this.seat_number;
         fan.day = this.day;
         fan.month = this.month;
         fan.year= this.year;
         return fan;
         
                 }
    
    
        }
    

    
    
    
    /**
     * method that responsible for check the available seats and reserve a ticket
     * for national and international games
     * assign fan sport account with game he wanted
     * @param arr takes the array of games to reserve the game you wanted
     */
    void ticket_reservation(game[]arr){
        count++;
        System.out.println("what a type of game you intersted in press N if national and I if international");
        char c = input.next().charAt(0);
        if(c=='N'|| c=='n'){
            for(int i = 0 ; i<arr.length;i++){
                if(arr[i] instanceof national_game){
                    g =(national_game) arr[i];
                    System.out.println("this game is "+ g.getGame_type());
                    System.out.println("this game is between "+ g.getFirst_team()+ " and "+ g.getSecond_team());
                    System.out.println("this date of the game: "+ g.getDay()+ "/"+ g.getMonth()+"/"+g.getYear());
                    System.out.println("this location of the game: "+ g.getStadium_name());
                    System.out.println("if you want to reserve the ticket you should check seats availability if you want press y if you want another game press N");
                    char a = input.next().charAt(0);
                    if(a=='y' || a=='Y'){
                       int b= g.check_seatsavail();
                       if(b!=-1){
                           System.out.println("ticket is reserved successfully");
                            fanaccount[count]= new fan_account.fanBuilder(g.getFirst_team(),g.getSecond_team())
                                   .game_code(g.getGenerated_code())
                                   .seat_category(seats.category)
                                   .seat_number(seats.number_of_seat)
                                   .seats_price(seats.finalprice)
                                   .stadiumname(g.getStadium_name())
                                   .date(g.getDay(),g.getMonth(),g.getYear()).build();
                            
                             break;
                           
                                
                                
                           
                       }
                       else{
                            System.out.println("ticket is not reserved ");
                            System.out.println("if you want to reserve it again press y,if you want another game press n ");
                            char a2 = input.next().charAt(0);
                             if(a2=='y' || a2=='Y')
                                 i--;
                            
                       }
                    }
                    else{
                        continue;
                    }
                        
                }
            }
        }
        
        else if(c=='I' || c=='i'){
            for(int i = 0 ; i<arr.length;i++){
                if(arr[i] instanceof international_game){
                    g =(international_game) arr[i];
                    System.out.println("this game is "+ g.getGame_type());
                    System.out.println("this game is between "+ g.getFirst_team()+ " and "+ g.getSecond_team());
                    System.out.println("this date of the game: "+ g.getDay()+ "/"+ g.getMonth()+"/"+g.getYear());
                    System.out.println("this location of the game: "+ g.getStadium_name());
                    System.out.println("if you want to reserve the ticket you should check seats availability if you want press y if you want another game press N");
                    char a = input.next().charAt(0);
                    if(a=='y' || a=='Y'){
                        int b= g.check_seatsavail();
                    if(b!=-1){
                           System.out.println("ticket is reserved successfully");
                            fanaccount[count] = new fan_account.fanBuilder(g.getFirst_team(),g.getSecond_team())
                                   .game_code(g.getGenerated_code())
                                   .seat_category(seats.category)
                                   .seat_number(seats.number_of_seat)
                                   .seats_price(seats.finalprice)
                                   .stadiumname(g.getStadium_name())
                                   .date(g.getDay(),g.getMonth(),g.getYear()).build();
                            
                           break;
                    }
                       else{
                            System.out.println("ticket is not reserved ");
                            System.out.println("if you want to reserve it again press y,if you want another game press n ");
                            char a2 = input.next().charAt(0);
                             if(a2=='y' || a=='Y')
                                 i--;
                            
                       }
                    }
                    else{
                        continue;
                    }
                    
                }
            
            
            
            }
            
            
            
        }
        
       
        
        
        
    }
    /**
     * final and static method that has a date 
     * it is use for canceling the reservation 
     * as Cancel a reservation accepted only before the game date by at least 3 days
     */
    final static void todaydate(){
         todayday =9;
         todaymonth=6;
         todayyear =2020;
    }
    /**
     * display all the data of reserved games (display the tickets)
     * it has java defined exception
     * @throws NullPointerException an exception if fan account points to null
     */
    void display(){
        for(int i =0;i<=count;i++){
        try{
        System.out.println( "fan id: "+fanid+" game code: "+ fanaccount[i].game_code +" seat category: "+ fanaccount[i].seat_category+" seat price: "+ fanaccount[i].seats_price+" seat number: "+fanaccount[i].seat_number
                +"\nfirst team: "+ fanaccount[i].firstteam+" second team: "+fanaccount[i].secondteam+" location: "+fanaccount[i].stadiumname+" date: "+fanaccount[i].day+"/"+fanaccount[i].month+"/"+fanaccount[i].year + "\n"); 
        }
        
        catch(Exception e){
                System.out.println("there is no ticket to display");
                }
        }
      
        
    }
    /**
     * method that cancel the reservation
     * Cancel a reservation accepted only before the game date by at least 3 days
     * @throws NullPointerException java defined exception when there is no tickets reserved (fan account points to null)
     */
    void cancelreservation(){
        todaydate();
    System.out.println("are you sure you want to cancel reservation (y/n)");
    char ch = input.next().charAt(0);
    if(ch=='y' || ch=='Y'){
       
        try{
            if((todaymonth < fanaccount[count].month && todayyear==fanaccount[count].year) || todayyear < fanaccount[count].year ){
            g.increaseseats(fanaccount[count].seat_category);
            fanaccount[count] = null;
            System.out.println("done");
            count--;
            
            }
            else if(todayday<=fanaccount[count].day-3 && todayyear==fanaccount[count].year && todaymonth<= fanaccount[count].month){
                g.increaseseats(fanaccount[count].seat_category);
                fanaccount[count] = null;
                System.out.println("done");
                count--;
            }
            else
                System.out.println("you can't cancel the reservation as it accepted only before the game date by at least 3 days");
            
        }
       
        catch(Exception e){
            System.out.println("you should reseve a ticket first");
        }
        }
        
        
    }
    
    /**
     * method that upgrade seat category and build the new seat number, seat price and seat category
     * if fan account upgrade seat category to its old same category it will give him the same seat number
     * @throws NullPointerException java defined exception when there is no tickets reserved (fan account points to null)
     */
  
    public void upgrade_seat(){
        try{
        System.out.println("are you sure you want to upgrade seat (y/n)");
    char ch = input.next().charAt(0);
    if(ch=='y' || ch=='Y'){
        if(fanaccount[count]!= null){
        g.check_seatsavail();
        g.increaseseats(fanaccount[count].seat_category);
        if(fanaccount[count].seat_category== seats.category)
            seats.number_of_seat--;
        fanaccount[count] = new fan_account.fanBuilder(g.getFirst_team(),g.getSecond_team())
                                   .game_code(g.getGenerated_code())
                                   .seat_category(seats.category)
                                   .seat_number(seats.number_of_seat)
                                   .seats_price(seats.finalprice)
                                   .stadiumname(g.getStadium_name())
                                   .date(g.getDay(),g.getMonth(),g.getYear()).build();
    
    
    }
        else{
            System.out.println("you should reserve a ticket frst");
        }
    }
        }
        catch(Exception e){
            System.out.println("there are no ticket reserved");
        }
    }
    /**
     * method that make sports fan make a bet and if he win the bet his seat price will decrease by 50
     * if he lose his seat price still constant
     * it has calculated data members based on value of result
     * each fan account can make only one bet for each game (international , national)
     * IOException if user gives invalid input any input considered invalid except f and s considered valid
     * @throws NullPointerException java defined exception when there is no tickets reserved (fan account points to null)
     */
    public void make_bet() {
       
        try{
        if(fanaccount[count]!=null){
        if(m==count+1){
            m++;
        char bet;
        char end;
        
        System.out.println("are you want to make a bet (y/n)");
        char ch = input.next().charAt(0);
    if(ch=='y' || ch=='Y'){
        
        System.out.println("if you win the bet your seat price will decrease 50 pounds");
        System.out.println("if you think that first team will win press (f) , second team press(s)");
        bet = input.next().charAt(0);
        
        if(result%2==0){
            end = 'f';
            
        }
        else {
            end='s';
             
        }
        try{
           if(bet != 'f' && bet !='s')
            throw new ioException("the bet should be first team(f) or second team(s)");
        if(bet==end){
             if(end=='f')
                System.out.println("first team is win");
            else
                 System.out.println("second team is win");
             
            System.out.println("you are win the bet and you can check the seat price");
           
             fanaccount[count] = new fan_account.fanBuilder(g.getFirst_team(),g.getSecond_team())
                                   .game_code(g.getGenerated_code())
                                   .seat_category(seats.category)
                                   .seat_number(seats.number_of_seat)
                                   .seats_price(seats.finalprice-50)
                                   .stadiumname(g.getStadium_name())
                                   .date(g.getDay(),g.getMonth(),g.getYear()).build();
             
            
            
            
                    }
        else 
        {
             System.out.println("sorry you lose the bet");
              
        
    }
        
        
        }
        catch(ioException i){
          System.out.println(i.getMessage());
        }
    
    
    }
    
   
        } 
        else {
            System.out.println("you cant't make bet two times");
        }
        
    }
    
    else{
    System.out.println("there are no ticket reserved");
}
    
        }
        catch(Exception e){
            System.out.println("there are no ticket reserved");
        }
        
       
}
    
}



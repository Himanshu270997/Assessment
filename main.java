import java.util.*;

public class main {

	 public static void shuffle(String card[], int n) 
	    { 
	          
	        Random rand = new Random(); 
	          
	        for (int i = 0; i < n; i++) 
	        { 
	            // Random for remaining positions. 
	            int r = i + rand.nextInt(52 - i); 
	              
	             //swapping the elements 
	             String temp = card[r]; 
	             card[r] = card[i]; 
	             card[i] = temp; 
	               
	        } 
	    }
	 
	 //print all card
	    public static void print(String card[]){
	    	 for (int i = 0; i < card.length; i ++)
	    		 if(card[i]!=null)
	           System.out.print(card[i]+" "); 
	    	 System.out.println();
	    }
	    
	    public static void getbackdeck(Player[] p,String a[]) {
	    	int k=0;
	        System.out.println();
	    	for(int i=0;i<a.length;i++) {
	    		if(a[i]==null) {
	    			a[i]=p[k].getCard();
	    			k++;
	    		}
	    	}
	    }
	    
	    public static void start() {
	        System.out.println();
	    	Scanner t=new Scanner(System.in);
	    	System.out.println("Click any key and Press enter to start the game");
	    	String temp=t.next();
	    	
	    }
	    
	    public static void printCard(Player[] p,int n) {
	        System.out.println();
	    	   for(int i=0;i<n;i++) {
		        	System.out.print(p[i].getName());
		        	System.out.print(" Is Holding ");
			        System.out.println(p[i].getCard());
		        }
	    }
	    
	    public static int winner(Player[] p,int n) {
	    	int index=0;
	    	char c1=p[0].getCard().charAt(0);
	    	String s=p[0].getCard().substring(1);
	    	if(s=="J")
	    		s="11";
	    	if(s=="Q")
	    		s="12";
	    	if(s=="K")
	    		s="13";
	    	int value=Integer.parseInt(s);
	    	for(int i=1;i<n;i++) {
	    		char c2=p[i].getCard().charAt(0);
		    	String ss=p[i].getCard().substring(1);
		    	if(ss=="J")
		    		ss="11";
		    	if(ss=="Q")
		    		ss="12";
		    	if(ss=="K")
		    		ss="13";
		    	int value2=Integer.parseInt(ss);
		    	if(value2>value) {
		    		c1=c2;
		    		value=value2;
		    		index=i;
		    	}
		    	if(value2==value) {
		    		System.out.print(c2);
		    		System.out.print(c1);
		    		if(c2=='S') {
		    			c1=c2;
		    			index=i;
		    		}
		    		else if(c1=='S') {
		    			;
		    		}
		    		else if(c2=='H') {
		    			c1=c2;
		    			index=i;
		    		}
		    		else if(c1=='H') {
		    			;
		    		}
		    		else if(c2=='C') {
		    			c1=c2;
		    			index=i;
		    		
		    		}
		    		else if(c1=='C') {
		    			;
		    		}
		    		else if(c2=='D') {
		    			c1=c2;
		    			index=i;
		    		}
		    		else if(c1=='D') {
		    			;
		    		}
		    		
		    	}
		    	
	    	}
	    	return index;
	    }
	       
	    // Driver code 
	    public static void main(String[] args)  
	    { 
	        // Array from 0 to 51 
	    	start();//To start the game
	        String a[] = {"S1","S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK","H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","Hk","D1","D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK","C1","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ","CK"}; 
	        // String of deck of cards
	        shuffle(a, 52); // shuffle the deck
	        print(a);//print all the card
	        
	        Scanner sc = new Scanner(System.in); 
	        System.out.println("Enter No of Players");//No of players
	        int n=sc.nextInt();
	        
	        Player[] p=new Player[n];// Player object 
	        
	        for(int i=0;i<n;i++) {
	        	System.out.println("Enter Name of Player");
		    	String name = sc.next();
		    	p[i]=new Player(name,a[i]);
		    	a[i]=null;
	        }
	        printCard(p,n);//Print card player is holding
	        System.out.println();
	        System.out.println(p[winner(p,n)].getName()+" IS winner");//Find the winner of card
	        
	        
	        getbackdeck(p,a);//get back deck of card
	    	
	        //System.out.print(no_of_player);
	       
	        // Printing all shuffled elements of cards 
	       // for (int i = 0; i < 52; i ++) 
	         //  System.out.print(a[i]+" "); 
	          
	    } 

}


 class Player {
	//Player Class which have name and card player is holding
	private String Name;
	private String card;
	
	public Player(String Name,String card) {
	this.Name=Name;
	this.card=card;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
	
}


package Example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {

	String name;
	String number;
 

	PhoneBook(String name,String phone){
		this.name=name;
		this.number=phone;
	}

	public String getName(){
		return name;
	}

	public String getPhone(){
		return number;
	}

	public String setName(String name){
	return 	this.name=name;
	}

	public String setPhone(String phone){
	return 	this.number=phone;
	}

	
	static HashMap<String,String> table=new HashMap<>();
	static int num=0;
	static HashMap<String,Integer> calls=new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		table=readList();
		Scanner sc=new Scanner(System.in);
		int choice;
		char next='n';
		char close='c';
		 while(next=='n'){
			showMenu();
			System.out.println("Choose Number 1-6");
			choice=sc.nextInt();
			switch(choice){
			case 1:addPhone(); break;
			case 2:deletePhone();break;
			case 3:searchContact();break;
			case 4: ViewContact();break;
			case 5:outgoingCalls();break;
			case 6:ougoingCallsPrinting();break;
			}
		
			    
			      InputStreamReader isr=new InputStreamReader(System.in);
			      System.out.println();
			      System.out.println("Input n to continue or e for end ?");
			      
			      next=(char)isr.read();
			      
			     if(next=='e'){
			    	 break;
			     }
		 }
		
		}
	
	

	public static void ViewContact(){
		Map<String,String> treeMap=new TreeMap<String,String>(table);	
		printMap(treeMap);
		
			 
	}
	public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Name : " + entry.getKey()
				+ " -> Number : " + entry.getValue());
        }
    }


	public static void addPhone() throws IOException{
			
				
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Name: ");
			String name=br.readLine();
			System.out.println("Phone: ");
			String phone=br.readLine();
			if((phone.matches("\\+3598[7-9][2-9]\\d{6}"))||(phone.matches("08[7-9][2-9]\\d{6}"))||(phone.matches("00359[7-9][2-9]\\d{7}"))){  

			    table.put(name,phone); 
			   	System.out.println("Contact is added");
	   
			}
			else{
				System.out.println("Not valid phone");
			}
			}		
			
	
	
	public static void deletePhone() throws IOException{
		
		     
		     
		         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		         System.out.println("Name:");
		         String key=br.readLine();
		         if(table.containsKey(key)){
		        	 table.remove(key); 
		        	 calls.remove(key);
		        	 System.out.println(key+" is deleted");
		        	 
		     }
		        
		     else{ 	 
		         
		         System.out.println(key+" is not in the Phonebook");	       
		     		}
		         
	}
	
	public static void outgoingCalls() throws IOException{
		
		try{
		 Map<String,String> myMap=new TreeMap<String,String>(table);
		
		 
		if( num==0){
			
			for(Map.Entry<String, String> e:myMap.entrySet()){ 
			
			calls.put(e.getKey(), 0);
			 Map.Entry<String, String> next = ((TreeMap<String, String>) myMap).higherEntry(e.getKey());
			 num++;
			}
		}
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 	
			 System.out.println("Search by name:");
				String key=br.readLine();
				String cu=table.get(key);
				if(calls.get(key)==null){
					 System.out.println(key+" is not in the Phonebook");
				 }
				int m=calls.get(key);
			 
			 if(m>=0){
				 m++;
				 calls.put(key,m);
			 }
			 System.out.println(key+" is calling ...");
		}
		catch(Exception e){
			
				 System.out.println("Please try again!");
			 
		}
		
	
	}
	public static void ougoingCallsPrinting(){
		 Map<String,Integer> myMap=new TreeMap<String,Integer>(calls);
		 
		for(Map.Entry<String, Integer> e:myMap.entrySet()){ 
		
			System.out.println(e.getKey()+" is caling "+e.getValue()+" times");
			
		}
	}
	
	public static void searchContact() throws IOException{
		if(table!=null){
			
				
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Search by name:");
				String key=br.readLine();
				String cu=table.get(key);
				if(cu!=null){
					System.out.println("Name: "+key+" -> "+"Number: "+cu);
	      
	     }
				else{
					
					System.out.println(key+" is not in the PhoneBook!");
					}
	     
				
		
		
		}
			 
		
		
	
		
	    }
	   
	 
	
	   public static HashMap<String,String>  readList(){
		 
		   
		    try{
		    	String line;
		        BufferedReader in;

		        in = new BufferedReader(new FileReader("C:\\Users\\darko.ivanovski\\workspace\\ExampleTest\\bin\\Example\\infophonebook.txt"));
		        String pom2=in.readLine();
		        while(pom2!=null){
	        	   
		        String[] pom= pom2.split(",");
	if((pom[1].matches("\\+3598[7-9][2-9]\\d{6}"))||(pom[1].matches("08[7-9][2-9]\\d{6}"))||(pom[1].matches("00359[7-9][2-9]\\d{7}"))){  
 
	          table.put(pom[0],pom[1]);
	          pom2=in.readLine();
	            }
	else{
		 pom2=in.readLine();
	}
	            }
	    }catch(Exception e){
	    	System.out.println("File is not read");
	    }
		   return table;
	   }
	
		

	
	
public static void showMenu(){
	System.out.println("1. Add contact to phonebook");
	System.out.println("2. Delete contact");
	System.out.println("3. Find contact ");
	System.out.println("4. Print contacts");
	System.out.println("5. Do u want to call someone?");
	System.out.println("6. Printing calling members from phonebook");
}
}

import java.util.Scanner;

class bank_Account{
	String name;
	String username;
	String password;
	String account_no;
	int transaction=0;
	float bal=100000f;  
	String transHis=""; 
	Scanner s=new Scanner(System.in);
	
	public void registration() {
		
		System.out.println("Enter your name:");
		name=s.nextLine();
		System.out.println("Enter your Username:");
		username=s.nextLine();
		System.out.println("Enter your Password:");
		password=s.nextLine();
		System.out.println("Enter your account number:");
		account_no=s.nextLine();
		System.out.println("***********REGISTRATION COMPLETED************");
		
	}
	public boolean login() {
		
		boolean login=false;
		while(!login) {
			System.out.println("Enter Username:");
			String USERNAME =s.nextLine();
			if(USERNAME.equals(username)) {
				while(!login) {
					System.out.println("Enter Password");
					String PASSWORD = s.nextLine();
					if(PASSWORD.equals(password)) {
						System.out.println("login successful!");
						login=true;
					}
					else {
						System.out.println("Incorrect Password");
					}
				}
			}
			else 
				System.out.println("Username not found");
			}
		return login;
	}
	public void withdraw() {
		System.out.println("********Enter amount to withdraw*********");
		float AMOUNT =s.nextFloat();
		try {
			if(bal >= AMOUNT) {
				transaction ++;
				bal -=AMOUNT;
				System.out.println("Successfully Withdrawn money");
				String str= AMOUNT + "Rs Withdrawn\n";
				transHis =transHis.concat(str);
			}
			else {
				System.out.println("Insufficient Balance kindly note!!!");
			}
		}catch(Exception e) {
			
		}
	}
	public void deposit() {
		System.out.println("*******Enter amount to Deposit********");
		float AMOUNT1 =s.nextFloat();
		try {
			if( AMOUNT1<=100000f) {
				transaction ++;
				bal +=AMOUNT1;
				System.out.println("Successful Deposit");
				String str= AMOUNT1 + "Rs Deposited\n";
				transHis =transHis.concat(str);
			}
			else {
				System.out.println("Sorry limit is 100000.00");
			}
		}catch(Exception e) {
			
		}
	}
	public void transfer() {
		System.out.println("Enter the receipent's name");
	    String rece=s.nextLine();
	    System.out.println("Enter the amount to transfer");
	    float AMOUNT2 =s.nextFloat();
	    
	    try {
	    	if(bal >= AMOUNT2) {
	    		if(AMOUNT2 <=50000f) {
	    			transaction ++;
	    			bal -=AMOUNT2;
	    			System.out.println("Successfully done transaction to " + rece);
	    			String str= AMOUNT2 + "Rs transfred to "+ rece + "\n";
					transHis =transHis.concat(str);
	    		}
	    		else
	    		{
	    			System.out.println("Sorry limit is 500000.00");
	    		}
	    	}
	    	else {
				System.out.println("Insufficient balance in your Account");
			}
	    	
	    }catch (Exception e) {
	    	
	    }
	}
	public void check_Balance() {
		System.out.println("\n" +bal + "Rs");
	}
	public void trans_History() {
		if(transaction==0) {
			System.out.println("Empty");
			
		}else
			System.out.println(transHis);
	}
	
}

public class ATM {
	
	public static int takeIntrgerInput(int limit) {
		int input_value=0;
		boolean flag = false;
		
		while (!flag) {
			try {
				Scanner s1=new Scanner(System.in);
				input_value=s1.nextInt();
				flag=true;
				if(flag && input_value>limit || input_value<1) {
					System.out.println("Choose the number between 1 to" + limit);
					flag= false;
					
				}
				
			}catch(Exception e) {
				System.out.println("Enter only Integer value");
				flag= false;
			}
		};
		return input_value;
	}

	public static void main(String[] args) {
		
     System.out.println("\n**** WELCOME TO ATM ****\n");
     System.out.println("1.Register \n2.Exit");
     System.out.println("Enter your Option:");
     int ch=takeIntrgerInput(2);
     
     if (ch==1) {
    	 bank_Account b= new bank_Account();
    	 b.registration();
    	 while(true) {
    		 System.out.println("\n1.Login \n2.Exit");
    		 System.out.println("Enter your Option:");
    		 int c=takeIntrgerInput(2);
    		 if(c==1) {
    			 if(b.login()) {
    				 System.out.println("\n\n **** Welcome To" + b.name +"*****\n");
    				 boolean isFinished =false;
    				 while(!isFinished) {
    				System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check balance \n5.History" );
    			    System.out.println("Enter your Option:");
    			    int c1=takeIntrgerInput(6);
    			    switch(c1) {
    			    case 1:
    			    	b.withdraw();
    			    	break;
    			    case 2:
    			    	b.deposit();
    			    	break;
    			    case 3:
    			    	b.transfer();
    			    	break;
    			    case 4:
    			    	b.check_Balance();
    			    	break;
    			    case 5:
    			    	b.trans_History();
    			    	break;
    			    case 6:
    			    	isFinished=true;
    			    	break;
    			    }
    				 }
    			 }
    		 }
    		 else {
    			 System.exit(0);
    		 }
    	 }
     }
     else {
		 System.exit(0);
	 }
	}

}


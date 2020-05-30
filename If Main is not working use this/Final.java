import java.util.*;
import java.io.*;
class Question {
	public String ques,ans,diff;
	int anscorrect;
	float avg;
	Question(String ques,String ans){
		this.ques=ques;
		this.ans=ans;
		diff="Easy";
	}
	public void update(int a){
		this.anscorrect=a;
	}
	public void difficulty(int total){
		avg=(float)anscorrect/total;
		if(avg>=0.75)
			diff="Easy";
		else if(avg>=0.40)
			diff="Medium";
		else
			diff="Hard";
	}

}

class evaluation {
	public int readFile(Question[] q,int total){
	File file =  new File("data.txt"); 
	try{
	 Scanner sc = new Scanner(file);
	 int i=0,k;
	String a="4";
	for(i=0;i<10;i++){
		k=sc.nextInt();
		q[i].update(k);
	}
	total=sc.nextInt();

	}
	catch(IOException e){
		System.out.println("exception occoured" + e); 
	}
	return total;
	}
	public void writeFile(Question[] q,int total){
	    try {
	        FileWriter writer = new FileWriter("data.txt");

	        for (int i = 0; i < 10; i++) {
	           writer.write(q[i].anscorrect +"\n");
	        }
	        writer.write(total+"\n");

	        writer.close();

	    }
	    catch (IOException e) {
	        e.printStackTrace();
	      }

	}
}

class test {
	public static void takeTest(Question [] questions,String[] ans){
	    int score = 0;
	    Scanner input = new Scanner(System.in);
	    try{
	        FileWriter writer = new FileWriter("Output.txt");

	    for(int i = 0; i < questions.length; i++) {
	    	writer.write(i+1+")"+questions[i].ques);
	    	writer.write("Difficulty: "+questions[i].diff+"\n");
	        System.out.print(i+1+")"+questions[i].ques);
	        System.out.println("Difficulty: "+questions[i].diff);
	        String answer = ans[i];
	        answer=answer.toLowerCase();
	        System.out.println("Your Ans: "+answer+"\n");
	        if(answer.equals(questions[i].ans)) {
	            score++;
	            questions[i].anscorrect++;
	            questions[i].update(questions[i].anscorrect);
	        }
	    	writer.write("Your Ans: "+answer+"\n\n");
		    
	    }
	    System.out.println("You Scored: " + score + "/" + questions.length);
	    input.close();
	    writer.close();
	}
	
	catch (IOException e) {
        e.printStackTrace();
      }
	}
	

}
public class Final{	
	
	public static void main(String arg[]){
		
		int total=0;

		String q1="Java programs are\n(a)Faster than others\n(b)Platform independent\n(c)Not reusable\n(d)Not scalable\n";
		
		String q2 = "In a while loop, if the boolean expression is true, what will the loop do?\n(a)Break\n(b)Program will exit\n(c)Repeat\n(d)Continue through program\n";
		
	    String q3 = "What does i++; do?\n(a)Adds 1 to i\n(b)Adds 2 to i\n(c)Gets the sum\n(d)Multiplies the numbers\n";
	   
	    String q4 = "Command to execute compiled java program is\n(a)java\n(b)javac\n(c)run\n(d)javaw\n";
		
	    String q5 = "What is a loop that never stops?\n(a)For Loop\n(b)Infinite Loop\n(c)Do-While Loop\n(d)Full Loop\n";

	    String q6 = "What is an array?\n(a)Numbers of items ArrayList can store without increasing its size\n(b)Number used as an index to pinpoint a specfic element within an array\n(c)Object that can store a group of values, all of the same type\n(d)Method of locating a specific item in a larger collection of data\n";

		
		String q7 = "Inner classes are\n(a)anonymous classes\n(b)nested classes\n(c)subclasses\n(d) derived classes\n";

		String q8="The command javac is used to\n(a)debug a java program\n(b)compile a java program\n(c)interpret a java program\n(d)execute a java program\n";
		
		String q9 = "You use this statement to throw an exception manually\n(a)Throw\n(b)call stack\n(c)try block\n(d)thrown\n";

		String q10 = "Which of the following is not the Java primitive type\n(a)Byte\n(b)Float\n(c)Character\n(d)Long double\n";

	    Question [] questions = {
	            new Question(q1, "b"),
	            new Question(q2, "c"),
	            new Question(q3, "a"),
	            new Question(q4, "b"),
	            new Question(q5, "b"),
	            new Question(q6, "c"),
	            new Question(q7, "b"),
	            new Question(q8, "b"),
	            new Question(q9, "a"),
	            new Question(q10, "d")
	    };
	    total=new evaluation().readFile(questions,total);
	    for(int i=0;i<10;i++){
	    	questions[i].difficulty(total);
	    }
	    String a[]=new String[100];
	    File file =  new File("Input.txt"); 
		try{
			Scanner sc = new Scanner(file);
			int i=0,k;
			for(i=0;i<10;i++){
				a[i]=sc.next();
			}
		}
		catch(IOException e){
			System.out.println("exception occoured" + e); 
		}

	   new test().takeTest(questions,a);
	    new evaluation().writeFile(questions,total+1);
	       
	      

	}
}

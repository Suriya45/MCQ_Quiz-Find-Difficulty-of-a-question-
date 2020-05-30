package examly;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class test {
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
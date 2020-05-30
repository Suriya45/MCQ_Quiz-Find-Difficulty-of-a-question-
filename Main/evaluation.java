package examly;
import java.io.*;
import java.util.*;
public class evaluation {
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

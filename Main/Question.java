package examly;
public class Question {
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

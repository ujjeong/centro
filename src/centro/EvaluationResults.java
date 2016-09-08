package centro;

import java.util.List;


/*
 * evaluationResults Class
 * 
 * Variables:
 * 	- results (List<resultDetails>)
 * 	- evaluationTimeInMillis (long)
 * 
 */
public class EvaluationResults {
	private List<ResultDetails> results;
	private long evaluationTimeInMillis;
	
	EvaluationResults(){
		
	}
	EvaluationResults(List<ResultDetails> results, long evaluationTimeInMillis){
		this.results = results;
		this.evaluationTimeInMillis = evaluationTimeInMillis;
	}
	
	public final List<ResultDetails> getResults(){
		return this.results;
	}
	public final long getEvaluationTimeInMillis(){
		return this.evaluationTimeInMillis;
	}
	
	public final void setResults(List<ResultDetails> results){
		this.results = results;
	}
	public final void setEvaluationTimeInMillis(long evaluationTimeInMillis){
		this.evaluationTimeInMillis = evaluationTimeInMillis;
	}
}

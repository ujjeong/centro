/*
 * OutputGenerator Class
 * 
 * Member functions:
 * 	- evaluateObjects
 * 	- createOutputJSONFile
 * 
 */

package centro;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;

public class OutputGenerator {
	public List<EvaluationResults> outputObject;
	
	OutputGenerator(){
		
	}

	public final void evaluateObjects(List<BidRequests> requestObjects, List<Campaigns> campaignObjects) {
		
		List<ResultDetails> details = new ArrayList<ResultDetails>();
		
		
		System.out.println("Evaluating...");
		
		// Start evaluation time
		long startEvaluationTime = System.currentTimeMillis();
		
		// Matching Algorithm
		/*
		 * 1. Checks if requestObject->pageUrl is substring of campaignObject->targetedDomain, then
		 * 2. Checks if requestObject->country is same as campaignObject->targetedCountry, then
		 * 3. Checks if requestObject->dimension falls into one of campaignObject->adDimensions array element
		 * 
		 */
		for(int i=0; i<requestObjects.size(); i++){
			for(int j=0; j<campaignObjects.size(); j++){
				
				if(requestObjects.get(i).getPageUrl().toLowerCase().contains(campaignObjects.get(j).getTargetedDomain().toLowerCase())
						&& requestObjects.get(i).getCountry().equals(campaignObjects.get(j).getTargetedCountry())
						&& Arrays.asList(campaignObjects.get(j).getAdDimensions()).contains(requestObjects.get(i).getDimensions())){
					
					ResultDetails rd = new ResultDetails(requestObjects.get(i).getRequestId(), campaignObjects.get(j).getCampaignId());
					details.add(rd);
				}
			}
		}
		
		// End evaluation time and calculate total time
		long endEvalutionTime   = System.currentTimeMillis();
		long totalTime = endEvalutionTime - startEvaluationTime;
		
		System.out.println("Evaluation Complete!");
		
		EvaluationResults er = new EvaluationResults(details, totalTime);
		outputObject = new ArrayList<EvaluationResults>();
		outputObject.add(er);
	}
	
	public final void createOutputJSONFile(String fileDir){
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("\nCreating JSON file at " + fileDir + "...");
		
		// Try writing object into JSON file
		try {
			mapper.writeValue(new File(fileDir), outputObject);
			System.out.println("File Created!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public final List<EvaluationResults> getOutputObject(){
		return this.outputObject;
	}
}

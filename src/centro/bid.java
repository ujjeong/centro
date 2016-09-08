/*
 * Eugene Jeong
 * 
 * Centro Platform Development Assignment
 * 
 * Classes:
 * 	- JSONParser
 * 	- OutputGenerator
 * 
 * 	- BidRequests
 * 	- Campaigns
 * 	- EvaluationResults
 * 	- ResultDetails
 * 
 */

package centro;

public class bid {
	public static void main(String[] args){
		
		// Pre-defined Variables. Only these variables need to be changed for other use.
		final String requestFileName = "json/bid_requests.json";
		final String campaignFileName = "json/campaigns.json";
		final String outputFileName = "json/resultOutput.json";
		
		JSONParser<BidRequests> requestObject = new JSONParser<BidRequests>(requestFileName);
		JSONParser<Campaigns> campaignObject = new JSONParser<Campaigns>(campaignFileName);
		
		Class<BidRequests> br = BidRequests.class;
		Class<Campaigns> c = Campaigns.class;
		
		
		// Set Java Object from JSON file
		requestObject.setObjects(br);
		campaignObject.setObjects(c);
		
		// Declare OutputGenerator Object to execute evaluation
		OutputGenerator output = new OutputGenerator();
		output.evaluateObjects(requestObject.getObjects(), campaignObject.getObjects());
		output.createOutputJSONFile(outputFileName);
	}
}
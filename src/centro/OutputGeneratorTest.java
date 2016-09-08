package centro;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class OutputGeneratorTest {
	
	String reqeustFilename = "json/bid_requests.json";
	String campaignFilename = "json/campaigns.json";
	JSONParser<BidRequests> jsonRequests = new JSONParser<BidRequests>(reqeustFilename);
	JSONParser<Campaigns> jsonCampaigns = new JSONParser<Campaigns>(campaignFilename);
	OutputGenerator output = new OutputGenerator();

	@Test
	public void testOutputGenerator() {
		
		assertNull(output.getOutputObject()); // Should be null since before evaluation
	}

	@Test
	public void testEvaluateObjects() {
		jsonRequests.setObjects(BidRequests.class);
		jsonCampaigns.setObjects(Campaigns.class);
		
		output.evaluateObjects(jsonRequests.getObjects(), jsonCampaigns.getObjects());
		assertNotNull(output.getOutputObject()); // Should not be null since after evaluation
	}

	@Test
	public void testGetOutputObject() {
		jsonRequests.setObjects(BidRequests.class);
		jsonCampaigns.setObjects(Campaigns.class);
		output.evaluateObjects(jsonRequests.getObjects(), jsonCampaigns.getObjects());
		
		List<EvaluationResults> results = output.getOutputObject();
		
		assertEquals(results.get(0).getResults().size(), 125);
		assertEquals(results.get(0).getResults().get(0).getBidRequestId(), 1173828);
		assertEquals(results.get(0).getResults().get(0).getCampaignId(), 4);
		assertNotNull(results.get(0).getEvaluationTimeInMillis());
	}

}

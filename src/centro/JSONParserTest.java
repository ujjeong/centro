package centro;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class JSONParserTest {
	
	String reqeustFilename = "json/bid_requests.json";
	String campaignFilename = "json/campaigns.json";
	JSONParser<BidRequests> jsonRequests = new JSONParser<BidRequests>(reqeustFilename);
	JSONParser<Campaigns> jsonCampaigns = new JSONParser<Campaigns>(campaignFilename);
	
	@Test
	public void testJSONParser() {
		assertNull(jsonRequests.getObjects()); // Should be null since there was no request object to be set
		assertNull(jsonCampaigns.getObjects()); // Should be null since there was no campaign object to be set
	}
	
	@Test
	public void testSetObjects() {
		jsonRequests.setObjects(BidRequests.class);
		jsonCampaigns.setObjects(Campaigns.class);
		
		assertNotNull(jsonRequests.getObjects()); // Should not be null since request object was set
		assertNotNull(jsonCampaigns.getObjects()); // Should not be null since campaign object was set
	}

	@Test
	public void testGetObjects() {
		jsonRequests.setObjects(BidRequests.class);
		jsonCampaigns.setObjects(Campaigns.class);
		
		List<BidRequests> jsonRequestObject = jsonRequests.getObjects();
		List<Campaigns> jsonCampaignObject = jsonCampaigns.getObjects();
		
		assertEquals(jsonRequestObject.get(0).getRequestId(), 1173828);
		assertEquals(jsonRequestObject.get(0).getPageUrl(), "http://engadget.com/2014/07/22/digital-tattoo-phone-unlock/");
		assertEquals(jsonRequestObject.get(0).getCountry(), "CA");
		assertEquals(jsonRequestObject.get(0).getDimensions(), "728x90");
		
		assertEquals(jsonCampaignObject.get(0).getCampaignId(), 1);
		assertEquals(jsonCampaignObject.get(0).getTargetedCountry(), "CA");
		assertEquals(jsonCampaignObject.get(0).getTargetedDomain(), "apple.com");
		assertEquals(jsonCampaignObject.get(0).getAdDimensions()[0], "300x250");
	}
}

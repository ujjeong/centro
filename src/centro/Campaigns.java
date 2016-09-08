package centro;


/*
 * campaigns Class
 * 
 * Variables:
 * 	- campaignId (int)
 * 	- targetedCountry (String)
 * 	- targetedDomain (String)
 *  - adDimensions (String[])
 * 
 */
public class Campaigns {
	private int campaignId;
	private String targetedCountry;
	private String targetedDomain;
	private String[] adDimensions;
	
	Campaigns(){
		
	}
	
	Campaigns(int campaignId, String targetedCountry, String targetedDomain, String[] adDimensions){
		this.campaignId = campaignId;
		this.targetedCountry = targetedCountry;
		this.targetedDomain = targetedDomain;
		this.adDimensions = adDimensions;
	}
	
	public final int getCampaignId(){
		return campaignId;
	}
	public final String getTargetedCountry(){
		return targetedCountry;
	}
	public final String getTargetedDomain(){
		return targetedDomain;
	}
	public final String[] getAdDimensions(){
		return adDimensions;
	}
	
	public final void setCampaignId(int campaignId){
		this.campaignId = campaignId;
	}
	public final void setTargetedCountry(String targetedCountry){
		this.targetedCountry = targetedCountry;
	}
	public final void setTargetedDomain(String targetedDomain){
		this.targetedDomain = targetedDomain;
	}
	public final void setAdDimensions(String[] adDimensions){
		this.adDimensions = adDimensions;
	}
}

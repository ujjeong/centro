package centro;

/*
 * resultsDetails Class
 * 
 * Variables:
 * 	- bidRequestId (int)
 * 	- campaignId (int)
 * 
 */
public class ResultDetails {
	private int bidRequestId;
	private int campaignId;
	
	ResultDetails(){
		
	}
	
	ResultDetails(int bidRequestId, int campaignId){
		this.bidRequestId = bidRequestId;
		this.campaignId = campaignId;
	}
	
	public final int getBidRequestId(){
		return bidRequestId;
	}
	public final int getCampaignId(){
		return campaignId;
	}
	
	public final void setBidRequestId(int bidRequestId){
		this.bidRequestId = bidRequestId;
	}
	public final void setCampaignId(int campaignId){
		this.campaignId = campaignId;
	}
}

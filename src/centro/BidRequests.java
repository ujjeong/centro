package centro;

/*
 * bidRequests Class
 * 
 * Variables:
 * 	- requiestId (int)
 * 	- pageUrl (String)
 * 	- country (String)
 * 	- dimensions (String)
 * 
 */
public class BidRequests {
	private int requestId;
 	private String pageUrl;
 	private String country;
 	private String dimensions;

 	public BidRequests(){
 		
 	}
 	
 	public BidRequests(int requestId, String pageUrl, String country, String dimensions){
 		this.requestId = requestId;
 		this.pageUrl = pageUrl;
 		this.country = country;
 		this.dimensions = dimensions;
 	}
 	
 	public final int getRequestId(){
 		return requestId;
 	}
 	public final String getPageUrl(){
 		return pageUrl;
 	}
 	public final String getCountry(){
 		return country;
 	}
 	public final String getDimensions(){
 		return dimensions;
 	}
 	
 	public final void setRequestId(int requestId){
 		this.requestId = requestId;
 	}
 	public final void setPagerlL(String pageUrl){
 		this.pageUrl = pageUrl;
 	}
 	public final void setCountry(String country){
 		this.country = country;
 	}
 	public final void setDimensions(String dimensions){
 		this.dimensions = dimensions;
 	}
}

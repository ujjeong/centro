/*
 * Universal JSON Parser 
 * 
 * Variables:
 * 	- Filename (String)
 * 	- obj (List<T>)
 * 
 *  1 Able to parse specific JSON file into different Class Object
 *  2 Uses Jackson JSON to parse .json file into specific class object
 *  3 Re-usability, Extensibility, Maintenance
 *  
 */

package centro;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

public class JSONParser<T> {
	private String FileName;
	private List<T> obj;
	
	JSONParser(String f){
		this.FileName = f;
	}

	public final List<T> getObjects() {
		return obj;
	}

	@SuppressWarnings("deprecation")
	public final void setObjects( Class<T> elementType) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		final File f = new File(FileName);
		
		// Try parsing campaign json file
		try {
		  this.obj = mapper.readValue(f, TypeFactory.collectionType(List.class, elementType));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

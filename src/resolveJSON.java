import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class resolveJSON {
	private String prevJSON;
	public bingJSON[] results;
	public int length;
	public resolveJSON(String prevJSON)
	{
		this.prevJSON=prevJSON;
		try {
			JSONObject obj1 = new JSONObject(this.prevJSON);
			String tmp = obj1.getString("d");
			String resArray = new JSONObject(tmp).getString("results");
			JSONArray jArray = new JSONArray(resArray);
			results=new bingJSON[jArray.length()];
			for(int i=0;i<jArray.length();i++)
			{
				JSONObject obj = jArray.getJSONObject(i);
				bingJSON result = new bingJSON(obj.getString("Title"), obj.getString("Description"), obj.getString("DisplayUrl"));
				results[i]=result;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buildDocument()
	{
		
	}
	
	

}

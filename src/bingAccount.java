import java.util.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;


public class bingAccount {
	private String url;
	private String accountKey;
	private double precision;
	public bingAccount(String accountKey, double precision)
	{
		this.url="https://api.datamarket.azure.com/Bing/Search/Web?Query=";
		this.accountKey=accountKey;
		this.precision = precision;
	}
	public String getKey()
	{
		return this.accountKey;
	}
	public double getPrecision()
	{
		return this.precision;
	}
	public String getContent(String query, int top)
	{
		byte[] accountKeyBytes = Base64.encodeBase64((accountKey + ":" + accountKey).getBytes());
		String accountKeyEnc = new String(accountKeyBytes);
		String searchText = query.replaceAll(" ", "%20");
		String bingUrl = this.url+"%27"+searchText+"%27&$top="+Integer.toString(top)+"&$format=json";
		URL searchUrl;
		String content="null string";
		try {
			searchUrl = new URL(bingUrl);
			URLConnection urlConnection = searchUrl.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
			InputStream inputStream = (InputStream) urlConnection.getContent();		
			byte[] contentRaw = new byte[urlConnection.getContentLength()];
			inputStream.read(contentRaw);
			content = new String(contentRaw);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;	
	}
	
}

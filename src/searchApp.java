import java.util.Scanner;


public class searchApp {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the query keywords, end with enter");
		String query = in.nextLine();
		System.out.println("Please input the precision between 0 and 1, end with enter");
		double targetPrecision = Double.parseDouble(in.nextLine());
		bingAccount account = new bingAccount("hRqThhNipztA2KKY9gLz0cFNsn1o3wYvchUxZizksio=", targetPrecision);
		System.out.println("Parameters: ");
		System.out.println("Client Key: "+account.getKey());
		System.out.println("Precision: "+Double.toString(account.getPrecision()));
		System.out.println("Total no of results: "+Integer.toString(10));
		System.out.println("================================");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double currentPrecision = 0;
		while(currentPrecision<targetPrecision)
		{
			String content = account.getContent(query, 10);
			resolveJSON app = new resolveJSON(content);
			for(int i=0;i<app.results.length;i++)
			{
				System.out.println("Result "+Integer.toString(i+1));
				System.out.println("[");
				System.out.println("URL: "+app.results[i].displayUrl);
				System.out.println("Title: "+app.results[i].title);
				System.out.println("Summary: "+app.results[i].discription);
				System.out.println("]");
				System.out.println();
				System.out.println("Is it relevant (Y/N)?");
				String tmp = in.nextLine();
				boolean relevant = (tmp.equals("Y"))?true:false;
				
			}
		}
		
	}
}

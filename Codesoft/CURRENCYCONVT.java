package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;
public class CURRENCYCONVT {
	
	final static String APIKEY = "YOUR_API_KEY";
	final static String APIURL="https://open.er-api.com/v6/latest/";

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		
		Scanner sc=new Scanner(System.in);
		System.out.println("********************CURRENCY CONVERTER**********************");
		System.out.println("Enter the Base currency: ");
		String base_curr=sc.next().toUpperCase();
		
		System.out.println("Enter the target currency: ");
		String target_curr=sc.next().toUpperCase();
		
		System.out.println("Enter the amount to be convert: ");
		double amt=sc.nextDouble();
		
		double amt_convt= convertCurr(base_curr, target_curr, amt);
		if (amt_convt != -1) {
            System.out.println(amt + " " + base_curr + " = " + amt_convt + " " + target_curr);
        } else {
            System.out.println("Please enter the valid input");
        }
		
	}
	
	static double convertCurr(String base_curr, String target_curr, double amt)
	{
		try {
			String urlstr = APIURL+base_curr+ "?apikey=" +APIKEY;
			URL url1=new URL(urlstr);
			HttpURLConnection con=(HttpURLConnection)url1.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder res=new StringBuilder();
			String stmt;
			
			while((stmt=br.readLine()) != null) {
				res.append(stmt);
			}
			
			JSONObject json=new JSONObject(res.toString());
			JSONObject imp=json.getJSONObject("rates");
			
			double exchg=imp.getDouble(target_curr);
			
			return amt*exchg;
		}
		catch(Exception e) {
			return -1;
		}
	}
}
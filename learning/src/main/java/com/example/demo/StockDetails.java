package com.example.demo;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StockDetails {
	private String lable;
	private int days;
	
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	public void date(int days) {
		
	}
	
	public List<stock> HistStock() throws IOException {
		
		Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -days);
        Date ndays = cal.getTime();
		
		//API request
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-historical-data?frequency=1d&filter=history&period1="+ndays.getTime()/1000+"&period2="+today.getTime()/1000+"&symbol="+lable)
				.get()
				.addHeader("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
				.addHeader("x-rapidapi-key", "4d1e573c15msh0e14453648cfb18p12542bjsnd198b7a0ae94")
				.build();

		
        Response response = client.newCall(request).execute();
        
        //converted to json object
        JSONObject json = new JSONObject(response.peekBody(20000).string());
        JSONArray jsonArr = json.getJSONArray("prices");
        List<stock> dataList = new ArrayList<stock>();
        
        for (int i = 0; i < jsonArr.length(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            stock data = new stock();
            data.setDate(jsonObj.getDouble("date"));
            data.setOpen(jsonObj.getLong("open"));
            data.setClose(jsonObj.getLong("close"));
            data.setHigh(jsonObj.getLong("high"));
            data.setLow(jsonObj.getLong("low"));
            dataList.add(data);
        }
        
        
        return dataList;
        
	}
}

class stock{
	double date;
	long high;
	long low;
	long open;
	long close;
	public double getDate() {
		return date;
	}
	public void setDate(double date) {
		this.date = date;
	}
	public long getHigh() {
		return high;
	}
	public void setHigh(long high) {
		this.high = high;
	}
	public long getLow() {
		return low;
	}
	public void setLow(long low) {
		this.low = low;
	}
	public long getOpen() {
		return open;
	}
	public void setOpen(long open) {
		this.open = open;
	}
	public long getClose() {
		return close;
	}
	public void setClose(long close) {
		this.close = close;
	}
	
	
}



/*
 * import java.util.*; public class Outer extends Inner { public static void
 * main(String [] args) { int odd = 1;
 * 
 * if(odd) {
 * 
 * }
 * 
 * } } protected class Inner { void cnt() { for (int x = 0;x<7;x++,x++ ) {
 * System.out.print(" " + x); } } }
 */

/*
 * class MyThread extends Thread { MyThread() { System.out.print(" Thread"); }
 * public void run() { System.out.print(" 2"); } public void run(String s) {
 * System.out.println(" 3"); } } public class Test { public static void main
 * (String [] args) { Thread t = new MyThread() { public void run() {
 * System.out.println(" 1"); } }; t.start(); } }
 */



/*
 * class MyThread extends Thread { MyThread() {} MyThread(Runnable r) {super(r);
 * } public void run() { System.out.print("Inside Thread "); } } class
 * RunnableDemo implements Runnable { public void run() {
 * System.out.print(" Inside Runnable"); } } public class ThreadDemo { public
 * static void main(String[] args) { new MyThread().start(); new MyThread(new
 * RunnableDemo()).start(); } }
 */

/*
 * public class Exceptional { public static void main (String[] args) {
 * method(); } public static int method() { try { System.out.println("try"); int
 * x =33/0; System.out.println(11); return 11; } catch(Exception e) {
 * System.out.println("catch"); System.out.println(17); return 17; } finally {
 * System.out.println("finally"); System.out.println(88); return 88; } } }
 */

/*
 * public class Source { public static void Order(String s) {
 * System.out.println("String"); } public static void Order(Object o) {
 * System.out.println("Object"); } public static void main (String [] args) {
 * Order(null); } }
 */

/*
 * class MTClass extends Thread { public void run() { try { System.out.println
 * ("Thread " + Thread.currentThread().getId() + " is running"); } catch
 * (Exception e) { System.out.println ("Exception is caught"); } } }
 * 
 * 
 * public class Main { public static void main(String[] args) { for (int i=0;
 * i<=3; i++) { MTClass object = new MTClass(); object.start(); } } }
 * 
 * 
 * 
 */

/*
 * class Parent { final public int calc(int a, int b) { return 1; } } class
 * Child extends Parent { public int calc(int a, int b) { return false; } }
 * public class Writeout { public static void main(String args[]) { Child c =
 * new Child(); System.out.print("c is:" + c.calc(0,1)); } }
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



public class Writeout {

    /*
     * Complete the 'drawingEdge' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int drawingEdge(int n) {
        
        long noOfEdges = n*(n-1)/2;
        
        int noOfGraphs =  fastExpo(2, noOfEdges);
        
        return noOfGraphs;

    }
    
    public static int fastExpo(long x, long y) {
        int MOD = (int) 1e9 + 7;
        
        long res = 1;
        
        while( y > 0 ){
            if((y&1) != 0 ){
                res = (res*x) % MOD;
            }
            
            x = (x*x) % MOD;
            y /= 2;
        }
        
        return (int)res;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=spider&page=1");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);;
    	
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getInputStream()));
			  String inputLine; 
			  StringBuffer response = new StringBuffer();
			  
			  while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
			  in.close();
			  
			  System.out.println(response.toString());
			 
		} else {
			System.out.println("GET request not worked");
		}
	}
    
    

}

class Movies{
	private String page;
	private String per_page;
	private String total;
	private String total_pages;
	private List<MovieData> data;
	@Override
	public String toString() {
		return "Movies [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages=" + total_pages
				+ ", data=" + data + "]";
	}
	
	
}

class MovieData{
	private String Title;
	private String Year;
	private String imdbID;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	@Override
	public String toString() {
		return "MovieData [Title=" + Title + ", Year=" + Year + ", imdbID=" + imdbID + "]";
	}

}


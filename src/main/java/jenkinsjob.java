
public class jenkinsjob {

	public static String concatWithString()    {  
		String t = "Java";  
		for (int i=0; i<10000; i++){  
			t = t + "Tpoint";  
		}  
		return t;  
	}  
	public static String concatWithStringBuffer(){  
		StringBuffer sb = new StringBuffer("Java");  
		for (int i=0; i<100000; i++){  
			sb.append("Tpoint");  
		}  
		return sb.toString();  
	}  
	
	public static String concatWithStringBuilder(){  
		StringBuilder sb2 = new StringBuilder("Java");  
		for (int i=0; i<100000; i++){  
			sb2.append("Tpoint");  
		}  
		return sb2.toString();  
	}  

	public static void main(String[] args){  
		long startTime = System.currentTimeMillis();  
		concatWithString();  
		System.out.println("R Time taken by Concating with String: "+(System.currentTimeMillis()-startTime)+"ms");  
		startTime = System.currentTimeMillis();  
		concatWithStringBuffer();  
		System.out.println("Time taken by Concating with  StringBuffer: "+(System.currentTimeMillis()-startTime)+"ms");
		
		startTime = System.currentTimeMillis();
		concatWithStringBuilder();  
		System.out.println("Time taken by Concating with  StringBuilder: "+(System.currentTimeMillis()-startTime)+"ms");  
	
	}  


}

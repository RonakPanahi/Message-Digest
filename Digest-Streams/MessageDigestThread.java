import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class MessageDigestThread  implements Runnable {
	
		
	private String mddata ;
	
	   MessageDigestThread(String data)
	   {
		  setMddata(data);
		  
	   }
	
	   public void run()
		{
		
		   try
		   {
		 
			File file = new File(mddata);
			FileInputStream fis = new FileInputStream(file);
	
		    MessageDigest md = MessageDigest.getInstance("SHA");
		    DigestInputStream dis = new DigestInputStream(fis,md);
		    byte[] Bytes = new byte[128];
		    
		    
		    int read = 0; 
		    //reading bytes from the digest input stream 
		    while ((read = dis.read(Bytes)) != -1) 
			   		    
			      md.update(Bytes, 0, read); //Updating digest
			
		
		    byte[] mdbytes = md.digest();
		 		
		    StringBuffer sb = new StringBuffer();
		    
		    //Converting the bytes to string 
		    for (int i = 0; i < mdbytes.length; i++) 
		    	
		    	sb.append(Integer.toString(mdbytes[i]));
		    
		    System.out.println(mddata);
		    System.out.println("Digest: " + sb.toString());
		    
		    
		   dis.close();
		   fis.close();
		   }
		   catch(Exception e)
		   {
			   System.err.println(e);
		   }
}

	public String getMddata() {
		return mddata;
	}

	public void setMddata(String mddata) {
		this.mddata = mddata;
	}
}	


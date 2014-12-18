import org.jibble.pircbot.*;

public class MyBot extends PircBot {
	
	private String botname;
	private boolean mute;
    
    public MyBot() {
    	botname = "CopyCats";
    	mute = false;
        this.setName(botname);
    }
  
    
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
    	
		String messagelower;
		messagelower = message.toLowerCase();
	    
    	if (messagelower.contains(botname)) {
		       mute = false;
		}
    	
    	if (!mute) {
    		
		    if (!botname.equals(sender)) {
		        sendMessage(channel, message + " Nyah!");
		    }
		    
		    if (messagelower.contains("mira")) {
		        sendMessage(channel, "All hail fuhrer! \\o\\");
		    }
		    
		    if (messagelower.contains("fish")) {
		        sendMessage(channel, "Bloop bloop fish! <><");
		    }
		    
		    if (messagelower.contains("kiri")) {
		        sendMessage(channel, "Oh Kiri? She's awesome!");
		    }
		    
		    if (messagelower.contains("shut up")) {
		       mute = true;
		    }
    	}
    }
    
    
}
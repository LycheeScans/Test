import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.UtilSSLSocketFactory;
import org.pircbotx.cap.TLSCapHandler;
public class MainMeido {

	public static void main(String[] args) {

		Configuration config = new Configuration.Builder()
		.setName("Iri") //Nick of the bot. CHANGE IN YOUR CODE
		.setLogin("MaidCorp") //Login part of hostmask, eg name:login@host
		.setAutoNickChange(true) //Automatically change nick when the current one is in use
		.setCapEnabled(true) //Enable CAP features
		.addCapHandler(new TLSCapHandler(new UtilSSLSocketFactory().trustAllCertificates(), true))
		.setServerHostname("irc.rizon.net") //The server were connecting to
		.addAutoJoinChannel("#lycheescans") //Join #pircbotx channel on connect
		.buildConfiguration(); //Create an immutable configuration from this builder

		//bot.connect throws various exceptions for failures
		try {
			PircBotX bot = new PircBotX(config);
			//Connect to the freenode IRC network
			bot.startBot();
		} //In your code you should catch and handle each exception seperately,
		//but here we just lump them all togeather for simpliciy
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
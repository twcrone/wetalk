@Grab(group='com.twilio.sdk', module='twilio-java-sdk', version='3.4.6')
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

// Find your Account Sid and Token at twilio.com/user/account
ACCOUNT_SID = args[0]
AUTH_TOKEN = args[1]

TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

// Build a filter for the MessageList
List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("Body", "Hey you?!"));
params.add(new BasicNameValuePair("To", "+18593611777"));
params.add(new BasicNameValuePair("From", "+18593095765"));

MessageFactory messageFactory = client.getAccount().getMessageFactory();
Message message = messageFactory.create(params);
System.out.println(message.getSid());

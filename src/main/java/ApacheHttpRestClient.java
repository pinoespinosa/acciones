import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ApacheHttpRestClient {

	public static void main(String[] args) throws InterruptedException {

		while (true)
		{
			checkValue("","/Instruments/NIY");
	//		checkValue("Maiz:", "/Instruments/ZC");
			Thread.sleep(1000);
		}
		
	}

	public static void checkValue(String elem, String accion) {
		
		
		
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpHost target = new HttpHost("www.plus500.es", 80, "http");

			HttpGet getRequest = new HttpGet(accion);

			HttpResponse httpResponse = httpclient.execute(target, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			
			
			if (entity != null) {
				System.out.print(elem);
				Utils.extractValor(EntityUtils.toString(entity));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
}

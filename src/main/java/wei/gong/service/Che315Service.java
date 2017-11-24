package wei.gong.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wei.liu
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2017-11-17
 * Time: 11:36
 */
public class Che315Service {

    private static final int OK = 200;

    public static void main(String[] args) throws IOException {
        System.out.println("test");
        String baseUrl = "http://www.315che.com";
        //String baseUrl = "http://www.baidu.com";
        first(baseUrl);
    }

    public static void first (String baseUrl) throws IOException {
        URL url = new URL(baseUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(2000);
        httpURLConnection.setReadTimeout(2000);

        int code = httpURLConnection.getResponseCode();
        if ( code == OK ) {
            InputStream responseInputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseInputStream, "UTF-8"));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        }


    }
}

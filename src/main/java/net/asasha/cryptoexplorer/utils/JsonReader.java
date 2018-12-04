package net.asasha.cryptoexplorer.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
/**
 *
 */
public class JsonReader {

    public static final String USER_AGENT = "Mozilla/5.0";

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        URLConnection conn = new URL(url).openConnection();
        conn.setRequestProperty("User-Agent", USER_AGENT);
        InputStream is = conn.getInputStream();

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}

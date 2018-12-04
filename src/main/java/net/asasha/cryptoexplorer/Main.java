package net.asasha.cryptoexplorer;

import net.asasha.cryptoexplorer.utils.JsonReader;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        JSONObject coins = JsonReader.readJsonFromUrl("http://whattomine.com/coins.json").getJSONObject("coins");
        Iterator<String> keys = coins.keys();

        List<JSONObject> list = new ArrayList<>();

        int i = 0;
        while(keys.hasNext()) {
            String key = keys.next();
            JSONObject nextCoin = coins.getJSONObject(key);
            list.add(nextCoin);
            String tag = nextCoin.getString("tag");
            System.out.printf("%d\t%s (%s)%n", ++i, key, tag);
        }
    }
}

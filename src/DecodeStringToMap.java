package src;

import java.util.HashMap;
import java.util.Map;

public class DecodeStringToMap {

    public static Map<String, String> decode(String s) {

        Map<String,String> map = new HashMap<String, String>();

        if(s.equals("")) return map;
        if(s == null) return null;

        String[] pairs = s.split("&");

        for(String pair: pairs) {

            if(pair.contains("=")) {
                String[] temp = pair.split("=");

                if(pair.startsWith("="))
                    map.put("", temp[1]);
                else if(pair.endsWith("="))
                    map.put(temp[0], "");
                else {
                    if(temp.length != 2) break;
                    map.put(temp[0], temp[1]);
                }
            }
            else {
                throw new IllegalArgumentException();
            }

        }
        return map;
    }
}

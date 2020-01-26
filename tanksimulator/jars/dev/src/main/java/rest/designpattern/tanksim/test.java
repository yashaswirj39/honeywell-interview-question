package rest.designpattern.tanksim;

import org.json.JSONObject;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("t1", "acd");
        map.put("t2", "dse");
        System.out.println(new JSONObject(map));
    }
}

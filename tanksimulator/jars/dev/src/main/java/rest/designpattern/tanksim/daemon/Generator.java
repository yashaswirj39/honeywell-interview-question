package rest.designpattern.tanksim.daemon;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import rest.designpattern.tanksim.randomGenerator.GenerateRandom;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.TreeMap;

@Path("/level")
public class Generator {
    private static final Logger logger = Logger.getLogger(Generator.class);
    public static TreeMap<String, String> cache = new TreeMap<>();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/generator")
    public String updateCache () {
        if (!cache.isEmpty()) {
            for (Map.Entry<String, String> entry: cache.entrySet()) {
                String key = entry.getKey();
                cache.put(key, String.valueOf(GenerateRandom.generateRandom()));
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                cache.put("tank - " + i, String.valueOf(GenerateRandom.generateRandom()));
            }
        }
        return convertMapToJson(cache).toString();
    }

    private static JSONObject convertMapToJson(TreeMap<String, String> map) {
        logger.debug("JSON response: " + new JSONObject(map));
        return new JSONObject(map);
    }
}

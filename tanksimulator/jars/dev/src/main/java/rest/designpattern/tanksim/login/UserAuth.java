package rest.designpattern.tanksim.login;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.log4j.Logger;
import org.json.JSONObject;

@Path("/auth")
public class UserAuth {

    private static final Logger logger = Logger.getLogger(UserAuth.class);

    static Config cfg;

    static {
        cfg = ConfigFactory.load("user-cred.conf");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/loginauth")
    public String login(Login login) {
        try {
            System.out.println("inside login auth of tank simulator.");
            logger.debug("inside login auth of tank simulator.");
            if (authenticateUser(login))
                return new JSONObject().put("status", "success").toString();
            else
                return new JSONObject().put("status", "failed").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject().toString();
    }

    private boolean authenticateUser(Login login) {
        if (login.getUserName().equalsIgnoreCase(cfg.getString("cred.userName"))
                && login.getPassword().equalsIgnoreCase(cfg.getString("cred.password")))
            return true;
        else return false;
    }
}

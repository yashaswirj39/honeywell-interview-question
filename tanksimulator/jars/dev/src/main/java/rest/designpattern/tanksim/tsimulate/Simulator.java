package rest.designpattern.tanksim.tsimulate;

import rest.designpattern.tanksim.daemon.Generator;
import rest.designpattern.tanksim.randomGenerator.GenerateRandom;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Simulator {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/simulate")
    public Response getTankName(Tank tank) {
        if (addTankDetails(tank.getTankName(), getRandom())) {
            return Response.ok(Response.Status.ACCEPTED).entity("Success").build();
        } else {
            return Response.ok(Response.Status.fromStatusCode(500)).build();
        }
    }

    private static long getRandom() {
        return GenerateRandom.generateRandom();
    }

    public boolean addTankDetails(String tankName, long random) {
        boolean flag = false;
        try {
            Generator.cache.put(tankName, String.valueOf(random));
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
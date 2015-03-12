package org.doublecloud.rest.demo;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/hi")
public class HelloWorldService
{
  @GET
  @Path("/{name}")
  public Response getMessage(@PathParam("name") String name)
  {
    String outMsg = "Hello " + name + "!";
    return Response.status(200).entity(outMsg).build();
  }
}


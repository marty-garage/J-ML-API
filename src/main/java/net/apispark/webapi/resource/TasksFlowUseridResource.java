package net.apispark.webapi.resource;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import java.util.UUID;
import org.restlet.resource.Delete;
import org.restlet.resource.Options;
import org.restlet.representation.Representation;
public interface TasksFlowUseridResource {

    @Get
    net.apispark.webapi.representation.AnonymousRepresentation5 represent() throws Exception;

    @Post
    void add() throws Exception;

    @Delete
    void remove() throws Exception;

}


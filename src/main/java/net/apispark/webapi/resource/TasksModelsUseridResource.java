package net.apispark.webapi.resource;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

import net.apispark.webapi.representation.Usemodel;

import java.util.List;
import java.util.UUID;
import org.restlet.resource.Delete;
import org.restlet.resource.Options;
import org.restlet.representation.Representation;
public interface TasksModelsUseridResource {

    @Get
    net.apispark.webapi.representation.Createmodel represent() throws Exception;

    @Post
    List<Usemodel> add(net.apispark.webapi.representation.Createmodel bean) throws Exception;

    @Delete
    net.apispark.webapi.representation.AnonymousRepresentation2 remove() throws Exception;

}


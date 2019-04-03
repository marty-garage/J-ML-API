package net.apispark.webapi.resource;

import org.restlet.resource.Post;
import java.util.UUID;
import org.restlet.resource.Put;
import org.restlet.resource.Options;
import org.restlet.representation.Representation;
public interface TasksModelsTrainUseridResource {

    @Post
    net.apispark.webapi.representation.AnonymousRepresentation6 add(net.apispark.webapi.representation.Trainmodel bean) throws Exception;

    @Put
    net.apispark.webapi.representation.AnonymousRepresentation7 store(net.apispark.webapi.representation.Trainmodel bean) throws Exception;

}


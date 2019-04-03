package net.apispark.webapi.resource;

import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.representation.Representation;
public interface TasksModelsResource {

    @Get
    net.apispark.webapi.representation.Createmodel represent() throws Exception;

}


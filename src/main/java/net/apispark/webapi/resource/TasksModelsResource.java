package net.apispark.webapi.resource;

import org.restlet.resource.Get;
import org.restlet.resource.Options;

import net.apispark.webapi.representation.Createmodel;
import net.apispark.webapi.representation.Usemodel;

import java.util.List;

import org.restlet.representation.Representation;
public interface TasksModelsResource {

    @Get
    List<Usemodel> represent() throws Exception;

}


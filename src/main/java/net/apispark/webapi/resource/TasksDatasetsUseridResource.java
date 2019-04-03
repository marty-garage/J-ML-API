package net.apispark.webapi.resource;

import org.restlet.resource.Post;
import java.util.UUID;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.representation.Representation;
public interface TasksDatasetsUseridResource {

    @Post
    net.apispark.webapi.representation.AnonymousRepresentation3 add(net.apispark.webapi.representation.UploadDataset bean) throws Exception;

    @Delete
    void remove() throws Exception;

    @Get
    net.apispark.webapi.representation.UploadDataset represent() throws Exception;

}


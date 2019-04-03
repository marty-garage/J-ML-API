package boot;

import express.Express;

public class WebApiHost {

    public static void main(String[] args) throws Exception {
    	Express app = new Express();
        //app.bind(new Bindings()); // See class below
    	app.get("/", (req, res) -> {
    		   res.send("Hello World");
    		}).listen(9001);
       // app.listen(9001);

        // Attach application to http://localhost:9001/v1
		/*
		 * Component c = new Component(); c.getServers().add(Protocol.HTTP, 9001);
		 * c.getDefaultHost().attach("/v1", new WebApiApplication()); c.start();
		 */
    }
}
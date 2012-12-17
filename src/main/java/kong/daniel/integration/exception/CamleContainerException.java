package kong.daniel.integration.exception;

public class CamleContainerException extends RuntimeException {

	private static final long serialVersionUID = -1619711085288771990L;

	public CamleContainerException(String msg) {
        super(msg);
    }

    public CamleContainerException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public CamleContainerException(Throwable cause) {
    	super(cause);
    }	
    
}

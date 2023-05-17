public class NoIPPartException extends RuntimeException {
	
	private int ip;

	NoIPPartException(Integer ip) {
		super(ip.toString());
		this.ip = ip;
	}
}
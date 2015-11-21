package project;

public class MemberPermissionException extends Exception{
	
	public MemberPermissionException(){}
	
	public MemberPermissionException(String message){
		super(message);
	}
	
	public MemberPermissionException(Throwable cause){
		super(cause);
	}
	public MemberPermissionException(String message, Throwable cause){
		super(message, cause);
	}
}
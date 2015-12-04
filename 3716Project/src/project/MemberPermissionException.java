package project;

public class MemberPermissionException extends Exception{
	/* MemberPermissionException is an exception thrown when a student
	 * tries to implement a function but does not have the permission to
	 * do so based upon their role, or lack thereof, in a society.
	 * This exception follows the Society heirarchy.
	 * @author Sam
	 */
	
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

/**
 * This interface declares and initializes three variables with a final value(fine, maxBooks and dueDays)
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public interface Policies {
	
	/**Used in calculation of fine using a specific formulae**/
	public static final int fine=1;
	
	/**Used to check that only a certain amount of books are entered**/
	public static final int maxBooks=5;

	/**Used in fine in case due date is exceeded for any book**/
	public static final int dueDays=14;
}

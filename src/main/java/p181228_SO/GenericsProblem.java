package p181228_SO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * https://stackoverflow.com/questions/53962916/possible-eclipse-bug/53963586#53963616
 * @author Aleksandr_Radchenko
 * @since 2018-12-28
 *
 */
public class GenericsProblem
{
	public static <FR extends FilterResult, T, A extends ACComparator<? super WrappedFilterResult<? super T, ? super FR>>> List<? super WrappedFilterResult<? super T, FR>> filter(
			String check, 
			Collection<T> elements, 
			Function<? super T, String> converter, 
			Filter<? extends FR> filter, 
			A comparator)
	{
		List<? super WrappedFilterResult<? super T, FR>> result = new ArrayList<>();
	    // eclipse says 'filter' doesn't accept these arguments
	    return filter1(check, elements, result, converter, filter, comparator);

	    // doing a self call will result in the same error?
	    // return filter(check, elements, converter, filter, comparator);

	    // calling without returning doesn't solve it either?
	    // filter(check, elements, converter, filter, comparator);
	    // return null;
	}

	// no complaints here
	public static <FR extends FilterResult, T, C extends Collection<? super WrappedFilterResult<? super T, FR>>> C filter1(
			String check, 
			Collection<T> elements, 
			C result, 
			Function<? super T, String> converter, 
			Filter<? extends FR> filter, 
			ACComparator<? super WrappedFilterResult<? super T, ? super FR>> comparator)
	{
	    // content
		return null;
	}
	
	public static class FilterResult {}
	public interface Filter<FR extends FilterResult> {}
	public static class WrappedFilterResult<T, FR extends FilterResult> extends FilterResult {}
	public interface ACComparator<FR extends FilterResult> {}
}

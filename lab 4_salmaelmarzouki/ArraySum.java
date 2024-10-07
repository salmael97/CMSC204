/**
 * Class for calculating the sum of elements in an array.
 * @author Salma El Marzouki
 *
 */
public class ArraySum {
	/**
     * Calculates the total of the integers in an array starting from a given index.
     * @param array - an array of integers
     * @param index - the starting index for the summation
     * @return the sum of elements from the specified index onward
     */
	public int sumOfArray(Integer[] a,int index) 
	{
		int sum;
		if(index == 0) 
		{
			sum = a[index];
		} else 
		{
			sum = a[index] + sumOfArray(a, index - 1);
		}
		return sum;
	}
}
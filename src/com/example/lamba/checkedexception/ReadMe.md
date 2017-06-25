<b>Java 8 Unchecked Exception in Handling Lambda Express: </b><br/>
Standard Java Lambda expression doesn't have facility to propagate the exception to caller. 
The reason is standard functional interface which facilitates the lamda expression don't handle unchecked exception. 

For example look at below code where I am trying to parse a set of inputs into List of Integers.
```
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaCheckedException {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("10", "20", "30", "40", "tyu");
		List<Integer> parsedInput = input.stream()
				.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		System.out.println(parsedInput.toString());
	}
}
```
If you try to run the above example on console you will get NumberFormatException but this will never propagate to main method.

Even if you try to put the lambda expression under try-catch block compiler will not allow stating that catch block is unreachable.

So as a work around as shown below you can put try-catch under the lambda expression itself, but it goes against the clarity of functional design thinking.
```
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaCheckedException {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("10", "20", "30", "40", "tyu");
		List<Integer> parsedInput = input.stream().map(x -> {
			Integer m = null;
			try {
				m = Integer.parseInt(x);
			} catch (NumberFormatException pe) {
				pe.printStackTrace();
			}
			return m;
		}).collect(Collectors.toList());
		System.out.println(parsedInput.toString());
	}
}
```
So solution is to create custom functional interface which can throw checked exception and use that in lambda expression.
Please go through the code section for solution.


 


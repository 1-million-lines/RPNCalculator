import java.util.LinkedList;

public class RPN {

	public static void evalRPN(final String expr) {

		String cleanExpr = cleanExpr(expr);
		LinkedList<Double> stack = new LinkedList<>();

		System.out.println("Input\tOperation\tStack after");
		for (String token : cleanExpr.split("\\s")) {

			System.out.print(token + "\t");
			Double tokenNum = null;

			try {

				tokenNum = Double.parseDouble(token);
			} catch (NumberFormatException e) {}

			if (tokenNum != null) {

				System.out.print("Push\t\t");
				stack.push(Double.parseDouble(token + ""));
			} else if (token.equals("*")) {

				System.out.print("Operate\t\t");
				double firstNumber = stack.pop();
				double secondNumber = stack.pop();
				stack.push(firstNumber * secondNumber);
			} else if (token.equals("/")) {

				System.out.print("Operate\t\t");
				double firstNumber = stack.pop();
				double secondNumber = stack.pop();
				stack.push(firstNumber / secondNumber);
			} else if (token.equals("-")) {

				System.out.print("Operate\t\t");
				double firstNumber = stack.pop();
				double secondNumber = stack.pop();
				stack.push(secondNumber - firstNumber);
			} else if (token.equals("+")) {

				System.out.print("Operate\t\t");
				double firstNumber = stack.pop();
				double secondNumber = stack.pop();
				stack.push(firstNumber + secondNumber);
			} else if (token.equals("^")) {

				System.out.print("Operate\t\t");
				double firstNumber = stack.pop();
				double secondNumber = stack.pop();
				stack.push(Math.pow(firstNumber, secondNumber));
			} else {

				System.out.println("Error");
				return;
			}

			System.out.println(stack);
		}
		System.out.println("Final answer: " + stack.pop());
	}

	private static String cleanExpr(final String expr) {
		return expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
	}

	public static void main(final String[] args) {
		evalRPN("3 4 2 * 1 5 - 2 3 ^ ^ / +");
	}
}

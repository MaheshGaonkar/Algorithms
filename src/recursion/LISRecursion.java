package recursion;

public class LISRecursion {
	public static int getLis(final int[] num, int index) {
		if (null == num || num.length == 0) return 0;
		if (num.length == 1) return 1;
		int currentMax = 0;
		for (int i = index; i < num.length; i++) {
			int result = getLis(num, i + 1);
			if (num[i - 1] < num[i]) {
				currentMax = Math.max(currentMax, result);
			}
		}
		return currentMax + 1;
	}
	
	public static void main(String[] args) {
		int[] num = {90};
		System.out.print(getLis(num, 1));
	}
}

public class YahtzeeSortDice
{
	private int first;
	private int second;
	private int third;
	private int fourth;
	private int fifth;

	/* constructor: initializes the private data by sorting the order of the dice */
	public YahtzeeSortDice(int a, int b, int c, int d, int e)
	{
		while(a<=b && b<=c && c<=d && d<=e) {
			int temp;
			if (a > b) {
				temp = a;
				a = b;
				b = temp;
			}
			if (b > c) {
				temp = c;
				c = b;
				b = temp;
			}
			if (c > d) {
				temp = d;
				d = c;
				c = temp;
			}
			if (d > e) {
				temp = e;
				e = d;
				d = temp;
			}
		}
		first = a;
		second = b;
		third = c;
		fourth = d;
		fifth = e;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public int getThird() {
		return third;
	}

	public int getFourth() {
		return fourth;
	}

	public int getFifth() {
		return fifth;
	}
}
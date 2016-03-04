import java.util.Scanner;

/*
 * Strategy: test all permutations of width and height. 
 */

public class Billboards {
	public static void main(String [] args) {
		Pair [] pairs1 = {(new Pair(1, 4)), (new Pair(2, 2)), (new Pair(4, 1))};
		System.out.println(bruteForce(pairs1));
	}

	// 
	private static Pair bruteForce(Pair [] pairs) { // billboards
		Pair ret = new Pair(30000, 30000);
		int area = 0;
		// permute pairs
		for (int width = 0; width < pairs.length; width++) {
			for (int height = 0; height < pairs.length; height++) {
				Pair currPoster = new Pair(pairs[width].w, pairs[height].h);
				int currentArea = pairs[width].w * pairs[height].h;
				int numBillboardFits = 0;

				for (int i = 0; i < pairs.length; i++) {
					if (fits(currPoster, pairs[i])) {
						numBillboardFits++;
					}
				}

				int totalArea = numBillboardFits * currentArea;
				
				if (totalArea > area) {
					area = totalArea;
					ret = currPoster;
				}
				if (totalArea == area && (currPoster.w < ret.w || (currPoster.w == ret.w && currPoster.h < ret.h)) ) {
					ret = currPoster;
				}
			}
		}

		return ret;
	}

	private static boolean fits(Pair pair, Pair other) {
		return (pair.w <= other.w && pair.h <= other.h);
	}
}

class Pair {
	int w;
	int h;

	public Pair(int i, int j) {
		w = i;
		h = j;
	}

	@Override
	public String toString() {
		return "(" + w + ", " + h + ")";
	}
}
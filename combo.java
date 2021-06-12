package combo;

	/*
	ID: zhenyu.2
	LANG: JAVA
	TASK: combo
	*/

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;

	public class combo {

	    public static void main(String args[]) throws IOException {
	        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
	        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

	        int len = Integer.valueOf(f.readLine());
	        String[] A = f.readLine().trim().split(" ");
	        String[] B = f.readLine().trim().split(" ");
	        f.close();
	        int[] a = {Integer.valueOf(A[0]), Integer.valueOf(A[1]), Integer.valueOf(A[2])};
	        int[] b = {Integer.valueOf(B[0]), Integer.valueOf(B[1]), Integer.valueOf(B[2])};

	        int count = 0, maxA, maxB, minA, minB;
	        for (int i = 1; i <= len; i++) {
	            boolean c = false, d= false;
	            d = false;
	            maxA = max(i, a[0]);
	            minA = min(i, a[0]);
	            maxB = max(i, b[0]);
	            minB = min(i, b[0]);
	            if (isCan(maxA, minA, len))
	                c = true;
	            if (isCan(maxB, minB, len))
	                d = true;
	            if (c || d)
	                for (int j = 1; j <= len; j++) {
	                    boolean e = false;
	                    boolean f1= false;
	                    maxA = max(j, a[1]);
	                    minA = min(j, a[1]);
	                    maxB = max(j, b[1]);
	                    minB = min(j, b[1]);
	                    if (c && isCan(maxA, minA, len))
	                        e = true;
	                    if (d && isCan(maxB, minB, len))
	                        f1 = true;
	                    if (e || f1)
	                        for (int k = 1; k <= len; k++) {
	                            maxA = max(k, a[2]);
	                            minA = min(k, a[2]);
	                            maxB = max(k, b[2]);
	                            minB = min(k, b[2]);
	                            if (c && e && isCan(maxA, minA, len) || d && f1 && isCan(maxB, minB, len)) {
	                                count++;
	                            }
	                        }
	                }

	        }
	        out.println(count);
	        out.close();
	    }

	    private static int max(int a, int b) {
	        return a > b ? a : b;
	    }

	    private static int min(int a, int b) {
	        return a > b ? b : a;
	    }

	    private static boolean isCan(int a, int b, int len) {
	        if (a - 2 <= b || (a + 2 - len >= b))
	            return true;
	        return false;
	    }
	}



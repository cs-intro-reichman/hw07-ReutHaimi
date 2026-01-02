/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {
        if (args.length > 0) {
            snowFlake(Integer.parseInt(args[0]));
        }
    }

    /** Draws a Koch curve of depth n from (x1,y1) to (x5,y5). */
    public static void curve(int n, double x1, double y1, double x5, double y5) {
        if (n == 0) {
            StdDraw.line(x1, y1, x5, y5);
            return;
        }
        double x3 = ((double)0.5 * ((double)(x1 + 2.0 * (x5 - x1) / 3.0) - (double)(x1 + (x5 - x1) / 3.0))) - ((double)(Math.sqrt(3) / 2.0) * ((double)(y1 + 2.0 * (y5 - y1) / 3.0) - (double)(y1 + (y5 - y1) / 3.0))) + (double)(x1 + (x5 - x1) / 3.0);
        double y3 = ((double)(Math.sqrt(3) / 2.0) * ((double)(x1 + 2.0 * (x5 - x1) / 3.0) - (double)(x1 + (x5 - x1) / 3.0))) + ((double)0.5 * ((double)(y1 + 2.0 * (y5 - y1) / 3.0) - (double)(y1 + (y5 - y1) / 3.0))) + (double)(y1 + (y5 - y1) / 3.0);
        curve(n - 1, x1, y1, (double)(x1 + (x5 - x1) / 3.0), (double)(y1 + (y5 - y1) / 3.0));
        curve(n - 1, (double)(x1 + (x5 - x1) / 3.0), (double)(y1 + (y5 - y1) / 3.0), x3, y3);
        curve(n - 1, x3, y3, (double)(x1 + 2.0 * (x5 - x1) / 3.0), (double)(y1 + 2.0 * (y5 - y1) / 3.0));
        curve(n - 1, (double)(x1 + 2.0 * (x5 - x1) / 3.0), (double)(y1 + 2.0 * (y5 - y1) / 3.0), x5, y5);
    }

    public static void snowFlake(int n) {
        StdDraw.clear();
        double x1 = 0.2, y1 = 0.25;
        double x2 = 0.5, y2 = 0.25 + (Math.sqrt(3)/2.0) * 0.6;
        double x3 = 0.8, y3 = 0.25;
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}
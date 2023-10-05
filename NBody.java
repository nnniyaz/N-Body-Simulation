public class NBody {
    public static void main(String[] args) {
        // Parse command-line arguments.
        double stoopingTime = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        double GRAVITATIONAL_CONSTANT = 6.67 * Math.pow(10, -11);

        // Read universe from standard input.
        int n = StdIn.readInt();
        double radius = StdIn.readDouble();
        double[] px = new double[n];
        double[] py = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        double[] mass = new double[n];
        String[] image = new String[n];

        for (int i = 0; i < n; i++) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
        }

        // Initialize standard drawing.
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        // Simulate the universe.
        double ax = 0;
        double ay = 0;
        for (double t = 0.0; t < stoopingTime; t += dt) {
            // Calculate net forces.
            double[] fx = new double[n];
            double[] fy = new double[n];
            for (int i = 0; i < n; i++) {
                double f = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        double r = Math
                                .sqrt(Math.pow(px[j] - px[i], 2) + Math.pow(py[j] - py[i], 2));
                        f = (GRAVITATIONAL_CONSTANT * mass[i] * mass[j]) / Math.pow(r, 2);
                        fx[i] += f * ((px[j] - px[i]) / r);
                        fy[i] += f * ((py[j] - py[i]) / r);
                    }
                }
            }

            // Update velocities and positions.
            for (int i = 0; i < n; i++) {
                ax = fx[i] / mass[i];
                ay = fy[i] / mass[i];

                vx[i] = vx[i] + (ax * dt);
                vy[i] = vy[i] + (ay * dt);

                px[i] = px[i] + (vx[i] * dt);
                py[i] = py[i] + (vy[i] * dt);
            }

            // Draw universe to standard drawing.
            StdDraw.picture(0, 0, "starfield.jpg");
            for (int i = 0; i < n; i++) {
                StdDraw.picture(px[i], py[i], image[i]);
            }
            StdDraw.show();
            StdDraw.pause(20);
        }
        // Print universe to standard output.
        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < n; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          px[i], py[i], vx[i], vy[i], mass[i], image[i]);
        }
    }
}

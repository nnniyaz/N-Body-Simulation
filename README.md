# N-Body Simulation

P.S.: N-Body Simulation is a programming project from Princeton University.

**Reading in the universe.** The input format is a text file that contains the information for a particular universe (in SI units). The first value is an integer *N* which represents the number of particles. The second value is a real number *R* which represents the *radius* of the universe, used to determine the scaling of the drawing window. Finally, there are *N* rows, and each row contains 6 values. The first two values are the *x*- and *y*-coordinates of the initial position; the next pair of values are the *x*- and *y*-components of the initial velocity; the fifth value is the mass; the last value is a String that is the name of an image file used to display the particle. As an example, planets.txt contains data for our own solar system (up to Mars):

- **Pairwise force.** *Newton's law of universal gravitation* asserts that the strength of the gravitational force between two particles is given by the product of their masses divided by the square of the distance between them, scaled by the gravitational constant *G* (6.67 × 10-11 N m2 / kg2). The pull of one particle towards another acts on the line between them. Since we are using Cartesian coordinates to represent the position of a particle, it is convenient to break up the force into its *x*- and *y*-components (*Fx, Fy*) as illustrated below.

![nbody.png](https://www.cs.princeton.edu/courses/archive/spr15/cos126/assignments/nbody-files/nbody.png)

- **Net force.** The *principle of superposition* says that the net force acting on a particle in the *x* or *y* direction is the sum of the pairwise forces acting on the particle in that direction.
- **Acceleration.** *Newton's second law of motion* postulates that the accelerations in the *x* and *y* directions are given by: *ax = Fx / m, ay = Fy / m*.

### Compiling and executing your program
```
% javac-introcs NBody.java
```

### Here are our results for a few sample inputs:
```
%java-introcs NBody 0.0 25000.0 < planets.txt           // zero steps
5
2.50e+11
 1.4960e+11  0.0000e+00  0.0000e+00  2.9800e+04  5.9740e+24    earth.gif
 2.2790e+11  0.0000e+00  0.0000e+00  2.4100e+04  6.4190e+23     mars.gif
 5.7900e+10  0.0000e+00  0.0000e+00  4.7900e+04  3.3020e+23  mercury.gif
 0.0000e+00  0.0000e+00  0.0000e+00  0.0000e+00  1.9890e+30      sun.gif
 1.0820e+11  0.0000e+00  0.0000e+00  3.5000e+04  4.8690e+24    venus.gif
```

```
%java-introcs NBody 25000.0 25000.0 < planets.txt       // one step
5
2.50e+11
 1.4960e+11  7.4500e+08 -1.4820e+02  2.9800e+04  5.9740e+24    earth.gif
 2.2790e+11  6.0250e+08 -6.3860e+01  2.4100e+04  6.4190e+23     mars.gif
 5.7875e+10  1.1975e+09 -9.8933e+02  4.7900e+04  3.3020e+23  mercury.gif
 3.3087e+01  0.0000e+00  1.3235e-03  0.0000e+00  1.9890e+30      sun.gif
 1.0819e+11  8.7500e+08 -2.8329e+02  3.5000e+04  4.8690e+24    venus.gif
```

```
%java-introcs NBody 50000.0 25000.0 < planets.txt       // two steps
5
2.50e+11
 1.4959e+11  1.4900e+09 -2.9640e+02  2.9799e+04  5.9740e+24    earth.gif
 2.2790e+11  1.2050e+09 -1.2772e+02  2.4100e+04  6.4190e+23     mars.gif
 5.7826e+10  2.3945e+09 -1.9789e+03  4.7880e+04  3.3020e+23  mercury.gif
 9.9262e+01  2.8198e-01  2.6470e-03  1.1279e-05  1.9890e+30      sun.gif
 1.0818e+11  1.7499e+09 -5.6660e+02  3.4998e+04  4.8690e+24    venus.gif
```

```
%java-introcs NBody 60000.0 25000.0 < planets.txt       // three steps
5
2.50e+11
 1.4958e+11  2.2349e+09 -4.4460e+02  2.9798e+04  5.9740e+24    earth.gif
 2.2789e+11  1.8075e+09 -1.9158e+02  2.4099e+04  6.4190e+23     mars.gif
 5.7752e+10  3.5905e+09 -2.9682e+03  4.7839e+04  3.3020e+23  mercury.gif
 1.9852e+02  1.1280e+00  3.9705e-03  3.3841e-05  1.9890e+30      sun.gif
 1.0816e+11  2.6248e+09 -8.4989e+02  3.4993e+04  4.8690e+24    venus.gif
```

```
%java-introcs NBody 31557600.0 25000.0 < planets.txt    // one year
5
2.50e+11
 1.4959e+11 -1.6531e+09  3.2949e+02  2.9798e+04  5.9740e+24    earth.gif
-2.2153e+11 -4.9263e+10  5.1805e+03 -2.3640e+04  6.4190e+23     mars.gif
 3.4771e+10  4.5752e+10 -3.8269e+04  2.9415e+04  3.3020e+23  mercury.gif
 5.9426e+05  6.2357e+06 -5.8569e-02  1.6285e-01  1.9890e+30      sun.gif
-7.3731e+10 -7.9391e+10  2.5433e+04 -2.3973e+04  4.8690e+24    venus.gif

```

```
// this test should take only a few seconds. 4.294E9 is bigger than the largest int
%java-introcs NBody 4.294E9 2.147E9 < 3body.txt
3
1.25e+11
2.1470e+12 -7.8082e-03  5.0000e+02 -3.6368e-12  5.9740e+24    earth.gif
1.2882e+14 -1.5100e+17  3.0000e+04 -3.5165e+07  1.9890e+30      sun.gif
-1.2882e+14  1.5100e+17 -3.0000e+04  3.5165e+07  1.9890e+30      sun.gif
```

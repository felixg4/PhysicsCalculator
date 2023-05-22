class Physics {
    public static double findInitVel(double v1, double t, double a) {
        // vf = vi + at --> vi = vf - at
        return v1 - a * t;
    }

    public static double findFinalVel(double vi, double a, double t) {
        //vf = vi+at
        return vi + a*t;
    }

    public static double findTime(double v0, double v1, double a) {
        // vf = vi + at --> t = (vf - vi)/a
        return (v1 - v0)/a;
    }
    public static double findDistance(double vi, double a, double t) {
        // x = vi + (1/2)at^2
        return vi + (1/2) *  (a * t * t);
    }
    public static double findAcceleration(double v0, double v1, double t) {
        // vf = vi + at --> a = (vf - vi)/t
        return (v1 - v0)/t;
    }
}
public class Main {

    //Constants we need in this program
    final static double K = 9 * Math.pow(10, 9);//Constants we need in this program
    final static double NANO = Math.pow(10,-9);

    public static void main(String[] args) {

        double Q = 1*NANO;//Our charge
        System.out.println("1. question a: V0 = "+rodPotentialCalculator(Q,1,1));
        System.out.println("1. question b: V1 = "+ElectricPotentialCalculator(Q,1,0,1));
        System.out.println("1. question c: V2 = "+ElectricPotentialCalculator(Q,1,1,2));
        System.out.println("1. question d: V4 = "+ElectricPotentialCalculator(Q,1,1,4));
        System.out.println("1. question f: V6 = "+ElectricPotentialCalculator(Q,1,1,6));
        System.out.println("1. question e: V8 = "+ElectricPotentialCalculator(Q,1,1,8));
        System.out.println("1. question g: VN = "+ElectricPotentialCalculator(Q,1,1, Integer.MAX_VALUE));

    }

    //For first question
    public static double rodPotentialCalculator(double Q, double x, double L){
        return (K*Q/(2L))*Math.log((Math.sqrt(Math.pow(L,2) + Math.pow(x,2))+L)/
                (Math.sqrt(Math.pow(L,2) + Math.pow(x,2))-L));
    }

    public static double ElectricPotentialCalculator(double Q, double x, double length, int particleCount) {


        double  minimumL = length/(particleCount-1);
        double L = minimumL;

        Q = Q / particleCount;
        //if we have one particle we do not need to make all the calculation
        if (particleCount == 1){
            return calculateChargeElectricPotential(Q, x, length);
        }


        double totalV = 0;
        //works as riemann sum so the more particle we have the better approximation we get
        for (int i = 0; i < particleCount/2; i++) {
                totalV +=  2*calculateChargeElectricPotential(Q,x,L);
                L += 2*minimumL;

        }
        return totalV;
    }

    //Electric Potential formula for a charge
    private static double calculateChargeElectricPotential(double Q, double x, double L) {
        return  (K * Q) / calculateHypotenuse(x, L);
    }

    //a function for calculating Hypotenuse
    private static double calculateHypotenuse(double x, double L) {
        return Math.pow(Math.pow(x, 2) + Math.pow(L, 2), 0.5);
    }

}
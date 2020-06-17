package uk.ramp.seir.ode;

import uk.ramp.seir.population.CompartmentRecord;

public class OdeEquations {

    private OdeEquations() {
        // hidden constructor
    }

    public static double dSdT(OdeProperties props, CompartmentRecord pop) {
        return -props.beta() * pop.s() / pop.n() * (pop.a() + pop.p() + pop.sym() + pop.sev());
    }

    public static double dEdT(OdeProperties props, CompartmentRecord pop) {
        return props.beta() * pop.s() / pop.n() * (pop.a() + pop.p() + pop.sym() + pop.sev()) - props.sigma1() * pop.e() - props.sigma2() * pop.e();
    }

    public static double dIdT(OdeProperties props, CompartmentRecord pop) {
        return props.sigma1() * pop.e() - props.gamma1() * pop.a();
    }

    public static double dpDt(OdeProperties props, CompartmentRecord pop) {
        return props.sigma2() * pop.e() - props.alpha() * pop.p();
    }

    public static double dSymDt(OdeProperties props, CompartmentRecord pop) {
        return props.alpha() * pop.p() - props.gamma2() * pop.sym() - props.sigma3() * pop.sym();
    }

    public static double dSymSevDt(OdeProperties props, CompartmentRecord pop) {
        return props.sigma3() * pop.sym() - props.gamma3() * pop.sev() - props.mu() * pop.sev();
    }

    public static double dDDt(OdeProperties props, CompartmentRecord pop) {
        return props.mu() * pop.sev();
    }

    public static double dRdt(OdeProperties props, CompartmentRecord pop) {
        return props.gamma1() * pop.a() + props.gamma2() * pop.sym() + props.gamma3() * pop.sev();
    }

}
package webapp.test.beans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.io.Serializable;

@ApplicationScoped
@Named
public class Calculation implements Serializable {

    @DecimalMin("-4.00")
    @DecimalMax("4.00")
    private double x;

    @DecimalMin("-3.00")
    @DecimalMax("3.00")
    private double y;

    @DecimalMin("1.00")
    @DecimalMax("3.00")
    private double r;

    private boolean result;



    @Inject
    private Engine engine;

    public Calculation(){
        System.out.println("Calculation started");
    }
    public Calculation(double x, double y, double r, boolean result/*, long attemptTime, double executionTime*/) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;

    }


    public void checkArea() {
        System.out.println("checkArea");
        boolean result = ((x <= 0) && (x >= -r/2) && (y >= 0) && (y <= r))
                || ((y <= 0) && (x >= 0) && (y >= ( x- r ) / 2))
                || ((x <= 0) && (y <= 0) && (x * x + y * y <= r * r));
        engine.addCalculation(new Calculation(x, y, r, result));
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public double getX() {

        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}

package webapp.test.models;

import jakarta.persistence.*;

@Entity
@Table(name = "calculations")
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "x")
    private double x;

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    @Column (name = "y")
    private double y;

    @Column (name = "r")
    private double r;
    @Column (name = "result")
    private boolean result;

    public Calculation() {
    }

    public Calculation(double x, double y, double r, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }

    public int getId() {
        return id;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
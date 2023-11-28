package webapp.test.beans;



import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import webapp.test.dao.CalculationDao;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@ApplicationScoped
@Named
public class Engine implements Serializable {
    private static final long serialVersionUID = 123L;
    private CalculationDao dao;
    private ArrayList<Calculation> calculations;
    @PostConstruct
    public void init(){

    }
    public Engine() {
        this.dao = new CalculationDao();
        this.calculations = new ArrayList<Calculation>();
        getResultsFromDB();

    }

    public void getResultsFromDB(){
        ArrayList<webapp.test.models.Calculation> results = this.dao.findAll();
        for (webapp.test.models.Calculation row: results) {
            this.calculations.add(
                    new Calculation(row.getX(),row.getY(),row.getR(),row.isResult())
            );
        }
    }

    public void saveCalculationToDB(Calculation calculation){
        webapp.test.models.Calculation calc
                = new webapp.test.models.Calculation(
                calculation.getX(), calculation.getY(), calculation.getR(), calculation.isResult());
        dao.update(calc);
    }

    public void clear(){
        calculations.clear();
        this.dao.deleteAll();
    }

    public void addCalculation(Calculation calculation){
        System.out.println("addCalculation: r="+calculation.getR()+" x="+calculation.getX()+" y="+calculation.getY());
        calculations.add(calculation);
        saveCalculationToDB(calculation);
    }

    public ArrayList<Calculation> getCalculations() {
        return calculations;
    }

    public void setCalculations(ArrayList<Calculation> calculations) {
        this.calculations = calculations;
    }

    public CalculationDao getDao() {
        return dao;
    }

    public void setDao(CalculationDao dao) {
        this.dao = dao;
    }
}

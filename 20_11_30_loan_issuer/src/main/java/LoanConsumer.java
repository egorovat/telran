public class LoanConsumer {

    private String name;
    private int age;
    private int annualIncome;


    public LoanConsumer(String name, int age, int annualIncome) {
        this.name = name;
        this.age = age;
        this.annualIncome = annualIncome;
    }


    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getAnnualIncome(){
        return this.annualIncome;
    }

    public void setAge(int age){

        this.age = age;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setAnnualIncome(int annualIncome){

        this.annualIncome = annualIncome;
    }
}


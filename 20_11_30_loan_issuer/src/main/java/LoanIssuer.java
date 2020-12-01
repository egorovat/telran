

public class LoanIssuer {

    private String name;
    private boolean isLazy;
    private boolean isKind;


    public LoanIssuer(String name, boolean isLazy, boolean isKind) {
        this.name = name;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }

    public boolean isKind() {
        return isKind;
    }

    public void setKind(boolean kind) {
        isKind = kind;
    }

    /**
     *
     * Loan is not issued to any consumer under 18 years
     * Loan is not issued to any consumer with income under 20 000
     * Loan is not issued to any consumer older than 50 years by issuer with isKind=false and isLazy=false
     * Loan is not issued to any consumer older than 70 years by any issuer with isKind=true and isLazy=false
     * @param consumer bank customer, who's requested the loan
     * @return decision of issuing the loan to consumer made by loan issuer
     */
    public boolean toIssue(LoanConsumer consumer){

        if(consumer.getAge() >= 18 && consumer.getAnnualIncome() >= 20000)
        {
            if(isLazy) return true;

            if(consumer.getAge() < 50) return true;

            if(isKind && consumer.getAge() < 70) return true;
        }

        return false;
    }
}

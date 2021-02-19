package data;

public class TransaktionMySql implements Comparable<TransaktionMySql> {
    int transaktionsId;
    int beløb;
    int kundeId;

    public TransaktionMySql(int transaktionsId, int beløb, int kundeId) {
        this.transaktionsId = transaktionsId;
        this.beløb = beløb;
        this.kundeId = kundeId;
    }

    public int getTransaktionsId() {
        return transaktionsId;
    }

    public void setTransaktionsId(int transaktionsId) {
        this.transaktionsId = transaktionsId;
    }

    public int getBeløb() {
        return beløb;
    }

    public void setBeløb(int beløb) {
        this.beløb = beløb;
    }

    public int getKundeId() {
        return kundeId;
    }

    public void setKundeId(int kundeId) {
        this.kundeId = kundeId;
    }

    @Override
    public String toString() {
        return  "transaktionsId = " + transaktionsId +
                ", beløb =" + beløb +
                ", kundeId=" + kundeId;
    }

    @Override
    public int compareTo(TransaktionMySql o) {
        return o.getBeløb() - this.beløb;
    }
}

package be.Projects.model;

public class Profit {

    private ProjDetails prjid;
    private int cost;
    private int profit;

    public ProjDetails getPrjid() {
        return prjid;
    }

    public void setPrjid(ProjDetails prjid) {
        this.prjid = prjid;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Profit{" +
                "prjid=" + prjid +
                ", cost=" + cost +
                ", profit=" + profit +
                '}';
    }
}

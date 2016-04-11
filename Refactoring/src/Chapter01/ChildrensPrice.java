package Chapter01;

public class ChildrensPrice extends Price {
	
	public int getPriceCode() {
        return Movie.CHILDREN;
    }
	
	double getCharge(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }
}

package Chapter01;

public class NewReleasePrice extends Price {
	public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
	 public double getCharge(int daysRented) {
	        return daysRented * 3;
	    }
	 int getFrequentRenterPoints(int daysRented) {
	        if (daysRented > 1)
	            return 2;
	        return 1;
	    }
}

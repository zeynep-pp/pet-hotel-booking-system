import java.util.Comparator;

public class HotelRatingComparator implements Comparator<Hotel> {
	
	@Override
	public int compare(Hotel o1, Hotel o2) {
		
		if(o1.getHotel_rating() == o2.getHotel_rating()) return 0;
		else if(o1.getHotel_rating() > o2.getHotel_rating()) return -1;
		else return 1;
	}

}

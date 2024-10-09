package api.payload;

public class Geo {
	private static double lat;
    private static double lng;

    // Getters and Setters

    public static double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public static double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}

package ovh.spajstech.azure.model;

public class Place {
    public Double lat;
    public Double lon;
    public String name;
    public String image;
    public String description;

    public Place(Double lat, Double lon, String name, String image, String description) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

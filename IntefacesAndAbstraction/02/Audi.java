public class Audi extends CarImpl implements Rentable{
     private Integer getMinRentDay;
     private Double getPricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer getMinRentDay, Double getPricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.getMinRentDay = getMinRentDay;
        this.getPricePerDay = getPricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.getMinRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.getPricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nMinimum rental period of %d days. Price per day %.6f", this.getMinRentDay, this.getPricePerDay);
    }
}

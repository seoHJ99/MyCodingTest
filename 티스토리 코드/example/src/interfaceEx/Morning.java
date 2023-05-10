package interfaceEx;

public class Morning extends Car {

    private String maker = "KIA";
    private int maxDistanceKm = 774;
    private String kmPerOil = "Good";
    private String sort = "소형";

    @Override
    public void transport(String thing) {
        super.transport(thing);
        System.out.println(aa);
        System.out.println("최대 4인까지 탑승 가능합니다.");
    }
//
//    public interfaceEx.Morning(String maker, int maxDistanceKm, String kmPerOil, String sort) {
//        this.maker = maker;
//        this.maxDistanceKm = maxDistanceKm;
//        this.kmPerOil = kmPerOil;
//        this.sort = sort;
//    }

    public static void main(String[] args) {
        Morning morning = new Morning();
        morning.transport("bb");
    }
}

package interfaceEx;

public class Car implements interfaceEx.CarInter {

    public String aa = "aaaaaaa";
    @Override
    public void transport(String thing) {
        System.out.println("바퀴 갯수: " + wheel);
        System.out.println("동력원: " + powerSource);
        System.out.println( thing + " 을 운송합니다." );
    }

}
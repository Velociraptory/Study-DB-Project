package functional;

public class Lamp implements ElectricityConsumer{
    public void lampOn(){
        System.out.println("lamp on");
    }

    @Override
    public void electricityOn(Object sender) {
        lampOn();
    }
}

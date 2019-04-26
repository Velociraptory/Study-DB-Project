package functional;

public class Radio implements ElectricityConsumer{
    public void play(){
        System.out.println("radio plays");
    }

    @Override
    public void electricityOn(Object sender) {
        play();
    }
}

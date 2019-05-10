package decorate;

public class App {
    public static void main(String[] args) {
        //要装饰的实体类
        Phone phone = new Iphone();

        //装饰为MusicPhone
        phone = new MusicPhone(phone);

        phone = new GiveCurrentTimePhone(phone);

        phone.call();
    }
}

package proxy.StaticProxy;

public class UserService implements BaseService {
    @Override
    public void save() {
        System.out.println("UserService.save()");
    }
}

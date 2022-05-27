package demo2;


public class Test2 {

    public static void main(String[] args) {
        ChainPipline2 validateInterceptor = new validateInterceptor();
        ChainPipline2 loginInterceptor = new loginInterceptor();
        ChainPipline2 authInterceptor = new authInterceptor();
        validateInterceptor.setNextChain(loginInterceptor);
        loginInterceptor.setNextChain(authInterceptor);

        User user = new User("test","123");
        validateInterceptor.doProcess(user);
    }
}

package demo3;


import demo2.User;

public class Test3 {

    public static void main(String[] args) {
        User user = new User("test","123");
        ChainPipline3 chain = new ChainPipline3.Builder()
                .addInterceptor(new validateInterceptor())
                .addInterceptor(new loginInterceptor())
                .addInterceptor(new authInterceptor())
                .build();
        chain.doProcess(user);
    }
}

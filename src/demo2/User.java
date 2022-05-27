package demo2;


public class User {

    private String name;
    private String pwd;
    private String role;

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

class UserService {

    /**
     * 模拟登录
     *
     * @param name 用户名
     * @param pwd 密码
     */
    public void login(String name, String pwd) {
        if (name == null || pwd == null) {
            throw new RuntimeException("账号或密码为空，校验失败");
        }

        User user = checkUser(name, pwd);

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        if (!"admin".equals(user.getRole())) {
            throw new RuntimeException("权限不足，非法操作");
        }
        System.out.println("允许操作");
    }

    /**
     * 模拟查询数据库
     *
     * @param name 用户名
     * @param pwd 密码
     * @return User
     */
    private User checkUser(String name, String pwd) {
        if ("test".equals(name) && "123".equals(pwd)) {
            User user = new User(name, pwd);
            user.setRole("admin");
            return user;
        }
        return null;
    }
}

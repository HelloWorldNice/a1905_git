package cn.bdqn.helloworld;

public class HelloWorld {

    private String username;
	
	// 于博修改的文件
	public String void(){
		return null;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void info(){
        System.out.println("人的姓名是:" + this.username);
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setUsername("HelloWorld");
        helloWorld.info();
    }
	
	// 杨鹏修改了文件
	public void xxxxx(){
		int x = 12 / 0;
		Systemout.println("于博再次更新代码");
		Systemout.println("于博再次更新代码3333333333");
		Systemout.println("于博再次更新代码2222222222222222222222222222");
		return;
	}

}

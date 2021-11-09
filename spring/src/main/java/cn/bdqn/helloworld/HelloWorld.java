package cn.bdqn.helloworld;

public class HelloWorld {

    private String username;

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
		return;
		
	}

}

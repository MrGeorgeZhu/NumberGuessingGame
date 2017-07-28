import java.util.Scanner;
//aaa
public class NumberGuessingGame {
	static int key;
	static String name;
	public static void main(String[] args) {
		greeting();
		checkAnswer();
		
	}
	public static void play(){
		delay();
		System.out.println("新的一局开始了！请开始猜测。");
		checkAnswer();
	}
	
	public static void greeting(){
		System.out.println("你好！请输入你的姓名。");
		Scanner userInput = new Scanner(System.in);
		name = userInput.nextLine();
	    System.out.println(name +", 你好！这是一个猜数字游戏，系统会随机了一个从1~10的数字。你一共有3次机会，每次猜错系统会告诉你大了还是小了！");	
	    delay();
	    System.out.println("系统已经随机了一个数字，请开始猜测。");
	}
	
	public static void checkAnswer(){
		generateNumber();
		for(int i = 0; i < 3; i++){
			Scanner userInput = new Scanner(System.in);
			int answer = userInput.nextInt();
			if(i==2){
				//delay();
				System.out.println("机会用完了！你输啦。");
				keepGoing();
			}
			if(answer == key){
				System.out.println("耶！你猜对了，" + name + ".");
				keepGoing();
			} else if(answer > key){
				System.out.println("大了，往小了猜。");
			} else{
				System.out.println("小了，往大了猜。");
			}
		}	
		
		
	}
	
	public static void generateNumber(){
		key = (int)(Math.random()*10)+1;
	}
	
	public static void keepGoing(){
		delay();
		System.out.println("要再玩一局吗？是：Y 否：其他");
		Scanner userInput = new Scanner(System.in);
		
		if(userInput.nextLine().equalsIgnoreCase("Y")){
			play();
		} else {
			System.out.println("再见，欢迎下次再玩！");
			System.exit(0);
		}
	}
	
	public static void delay(){
		try{Thread.sleep(1500);}
		catch(InterruptedException e){e.printStackTrace();}
	}
	

}

package deco;
/**
 * 데코레이터 패턴은 기본 뼈대(클래스)를 그대로 유지하되, 이후 필요한 기능을 꾸민 때 사용한다.
 *  new Buffered ..new InputStreamReader(new inputStream());
 *   
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
		
		ICar audi = new Audi(1000);
		
		ICar a3 = new A3(audi, "A3");
		a3.showPrice();
		
	}

}

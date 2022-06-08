package adapter;

public class MyHouse {
	
	// 집의 전기 콘센트에 연결하는 동작 (메서드 아닌 함수로 만들어줌)
	public static void homeConnect(IElectronic220v electronic220v) {
		electronic220v.connect();
	}

	public static void main(String[] args) {
		// 1. 에어컨
		// 2. 헤어드라이기
		// 3. 청소기
		
		// 가전기기들의 추상화를 해보기. (인터페이스를 만들어주기, -> 공통적인 동작을 만들어낸다.)
		// connect(); : 사용하려면 전기가 필요해서 연결하는 동작을 구현해야 한다.
		
		// 문제 인식
		// 청소기와 헤어드라이기 -> 110v , 에어컨 -> 220v 인 경우,
		
		// 사용해보기
		AirConditional airConditional = new AirConditional();
		// 집의 전기 콘센트에 연결
		homeConnect(airConditional);
		
		HairDryer hairDryer = new HairDryer();
//		homeConnect(hairDryer); // 연결 안됨.
		Cleaner cleaner = new Cleaner();
//		homeConnect(cleaner); // 연결 안됨.
		
		// 어뎁터 구매하여 사용하기
		ElectronicAdapter adapter1 = new ElectronicAdapter(hairDryer);
		// 집에 있는 콘센트에 연결하기
		homeConnect(adapter1);
		
		ElectronicAdapter adapter2 = new ElectronicAdapter(cleaner);
		homeConnect(adapter2);
		
		

	}

}

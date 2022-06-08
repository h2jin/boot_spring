package adapter;

public class HairDryer implements IElectronic110v{

	@Override
	public void connect() {
		System.out.println("헤어드라이어 연결 110v ON");
		
	}

}

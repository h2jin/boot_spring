package deco;

public class AudiDecorator implements ICar{

	protected ICar audi;
	protected String modelName;
	protected int modelPrice;
	
	public AudiDecorator(ICar audi, String modelName, int modelPrice) {
		this.audi = audi;
		this.modelName = modelName;
		this.modelPrice = modelPrice;
	}
	
	// 가격 기본 2000 -> A3 = 2000 + 1000
	
	@Override
	public int getPrice() {
		return audi.getPrice() + modelPrice;
	}

	@Override
	public void showPrice() {
		System.out.println(modelName + "의 가격은 " + getPrice() + "만원 입니다.");
		
	}

}

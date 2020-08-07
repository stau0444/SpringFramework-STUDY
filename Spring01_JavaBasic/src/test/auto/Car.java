package test.auto;

public class Car  {
	//필드
	private Engine engine;
	//생성자
	public Car(Engine engine) {
		this.engine=engine;
	}
	
	public void drive() {
		if(engine==null) {
			System.out.println("Engine 객체 없음");
		}else {
			System.out.println("달림");
		}
		
	}
}

package test.mypac;

public class RemoconImpl2 implements Remocon {

	@Override
	public void up() {
		System.out.println("볼륨 최대올림");
	}

	@Override
	public void down() {
		System.out.println("볼륨 최대내림");
	}
}

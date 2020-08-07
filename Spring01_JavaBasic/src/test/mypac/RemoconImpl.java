package test.mypac;

public class RemoconImpl implements Remocon {

	@Override
	public void up() {
		System.out.println("볼륨 올림");
	}

	@Override
	public void down() {
		System.out.println("볼륨 내림");
	}
}

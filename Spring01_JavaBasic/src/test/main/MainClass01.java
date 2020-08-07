package test.main;

import test.mypac.Weapon;
import test.mypac.Weaponimpl;

//메인클레스 01은 Weaponimpl 객체에  의존한다.
public class MainClass01 {
	public static void main(String[] args) {
		//Application 목적이 뭔가를 공격하는 것이라면?
		
		//1. 목적을 달성하기 위해 필요한 핵심 의존 객체를 직접 생성해서 
		Weapon w=new Weaponimpl();
		//2.메소드를 호출해서 목적을 달성한다
		w.attack();
		
	}
}

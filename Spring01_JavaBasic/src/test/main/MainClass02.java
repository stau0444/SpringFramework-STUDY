package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

//스프링방식으로 만든예제
public class MainClass02 {
	public static void main(String[] args) {
		//weapon 클래스를 new 하지않고 init.xml에 명시해 놓은 경로를 통해 불러온다 
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		//관리 하고 있는 객체 중에서 id 가 myWeapon인 객체의 참조값을 얻어오서 
		//인터페이스 type 으로 casting 한다.
		Weapon w= (Weapon)context.getBean("myWeapon");
		//필요한 기능 사용한다
		w.attack();
	}	
}

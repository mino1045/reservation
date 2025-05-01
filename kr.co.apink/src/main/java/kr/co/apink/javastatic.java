package kr.co.apink;

public class javastatic {
	public static void maom(String[] args) {
		
		//javatest jt = new javatest();
		
		//만약 객체를 안 쓰고 ? 일반 메소드는 new를 해야하지만 static은 메모리에 등록되어있음
		System.out.println(javatest.test1(10));
		//System.out.println(javatest.test2(10));
		System.out.println(new javatest().test2(10)); //일반 메서드는 new를 해야 가져올 수 있음
		
		//똑같이 데이터 넣어보면?
		System.out.println(javatest.test1(10));;
		System.out.println(new javatest().test2(10)); //일반 메서드는 new를 해야 가져올 수 있음

	}

}



//둘 다 똑같은 코드인데 static인지아닌지만 다르다. static을 쓰면 초기화가 안 된다.
class javatest{
	public static int test1(int aa) { //static 메서드를 new로 쓰는 것은 권장되지 않는다.
		int sum = aa+ 10;
		return aa; //sum이 저장이 됨
	}
	
	public int test2(int aa) {
		int sum = aa+ 10;
	
		return sum;
	}
	
}
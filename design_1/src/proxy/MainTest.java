package proxy;

import java.util.concurrent.atomic.AtomicLong;

import aop.AopBrowser;

/**
 * 
 *  Proxy 는 대리인이라는 뜻으로, 무언가를 대신해서 처리하는 것이다.
 *  proxy class를 통해서 대신 무언가를 전달하는 형태로 설계되며, 
 *  실제 사용하는 클라이언트는 Proxy 클래스로부터 결과를 받는다.
 *  Cache의 기능으로도 활용이 가능하다.
 *  즉 한번 메모리에 로드된 것을 남겨뒀다가 다시 내려줄 수 있다.
 *  
 *  Spring 에서 많은 어노테이션을 활용하는데, 프록시 패턴을 활용해서 aop를 구현할 수 있다.
 * 	aop : 관점 지향형 프로그래밍. 
 *   
 *  Cache : 컴퓨터에서 하나의 데이터를 찾고자 할 때 메모리에 있는지 검색하고 없으면 
 *  c드라이버나 데이터베이스가 가서 풀스캔을 하게 된다. ++ 더 알아보기
 *  
 * 
 *
 */
public class MainTest {

	public static void main(String[] args) {
//		Browser browser = new Browser("www.naver.com");
//		browser.show();
//		browser.show();
//		browser.show();
//		browser.show();
		
//		BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
		
//		IBrowser browser = new AopBrowser("www.google.com", new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//		}, new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		// 동시성 문제 때문에 
		AtomicLong start = new AtomicLong();
		AtomicLong end = new AtomicLong();
		
		// 객체 생성 및 초기화
		IBrowser browser = new AopBrowser("www.naver.com",
				() -> {
					System.out.println("before");
					start.set(System.currentTimeMillis());
				}, 
				() -> {
					long now = System.currentTimeMillis();
					end.set(now - start.get()); // 총 소요 시간
				}
				
				);
		
		browser.show();
		System.out.println("loading time : " + end.get());
		// 첫번째 호출 소요시간 : 1507
		
		browser.show();
		System.out.println("loading time : " + end.get());
		// 2번째 호출 소요시간 : 0
		
		browser.show();
		System.out.println("loading time : " + end.get());
		// 3번째 호출 소요시간 : 0
		
		// 캐시기능을 사용하면 메모리상으로 굉장한 이득을 볼 수 있다.
		// 두번째부터는 chache 처리. 메모리에 올라와있기 때문에 불필요한 검색하지 않게 됨.
		
		// aop 란 관점 지향
		// 실제적으로 aop를 활용한 사례는 특정한 메서드가 있으면 그 메서드에 실행시간을 확인하거나
		// 또는 일괄적인 request 정보나 response 정보를 확인하여 남기고자 할 때 코드에 개별적으로 작성하지 않고
		// 일괄적으로 특정 클래스 또는 특정 패키지에 있는 모든 메서드에 전/후에 기능을 넣을 수 있는 방법을 제공한다.

	}

}

package proxy;

public class BrowserProxy implements IBrowser{

	private String url;
	private Html html; // 멤버변수로 가지고 있어야 함.
	
	public BrowserProxy(String url) {
		this.url = url;
	}
	
	@Override
	public Html show() {
		// 여기에 캐싱 기능을 만들어 보자.
		if(html == null) {
			System.out.println("BrowserProxy loading html from : " + url);
			html = new Html(url);
		}
		
		System.out.println("BrowserProxy use cache html : " + url);
		
		return html;
	}

}

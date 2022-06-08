package aop;

import proxy.Html;
import proxy.IBrowser;

public class AopBrowser implements IBrowser{
	
	// aop 특징 중 하나 전처리, 후처리를 사용해 보자.
	private String url;
	private Html html;
	private Runnable before;
	private Runnable after;
	
	public AopBrowser(String url, Runnable before, Runnable after) {
		this.url = url;
		this.before = before;
		this.after = after;
	}
	
	@Override
	public Html show() {
		before.run();
		
		if(html == null) {
			System.out.println("AopBrowser html loaging from : " + url);
			html = new Html(url);
			// 여기있는 코드 너무 빨리 처리됨. -> Thread Sleep
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		after.run();
		System.out.println("AopBrowser html chache from : " + url);
		return null;
	}
	
	

}

package com.example.home.chicgallers;




import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.home.myapplication.R;

public class MainActivity extends Activity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webView1);
        myWebView.getSettings().setJavaScriptEnabled(true); // 자바스크립트를 사용
        myWebView.loadUrl("http://lute.fantazm.net/");     // url
        // file:///abc/abc.html 처럼 사용할 수 있습니다.
        myWebView.setWebViewClient(new myWebViewClient());
        // 다운 로드 할 수 있도록 해주는 함수
        myWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                // 다운로드 파일 웹 브라우저 사용
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType(mimetype);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    // 디바이스 기기의 back 버튼 인식
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // 웹 뷰 내부의 URL 인식
    // 웹 뷰 내부의 URL 인식
    private class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // 전화걸기 (퍼미션설정) Intent.ACTION_CALL , Intent.ACTION_DIAL
            if (url.contains("tel:")) {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(url)));
                return true;
            }
            // 메일 보내기 Intent.ACTION_SENDTO
            else if (url.contains("mailto:")) {
                startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(url)));
                return true;
            }
            // 웹 화면 띄우기
            else {
                view.loadUrl(url);
                return true;
            }
        }
    }
}

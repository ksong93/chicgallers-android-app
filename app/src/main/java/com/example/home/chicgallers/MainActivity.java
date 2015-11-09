package com.example.home.chicgallers;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.home.chicgallers.R;
import android.widget.Toast;

public class MainActivity extends Activity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    myWebView = (WebView) findViewById(R.id.webView1);
     //   myWebView.getSettings().setJavaScriptEnabled(true); // 자바스크립트를 사용
   //     myWebView.loadUrl("http://fantazm.net/mabi/");     // url
        // file:///abc/abc.html 처럼 사용할 수 있습니다.
  //      myWebView.setWebViewClient(new myWebViewClient());

        //CookieSyncManager.createInstance(context);
      //  CookieSyncManager.getInstance().startSync();
    //    CookieSyncManager.getInstance().stopSync();
      //  CookieSyncManager.getInstance().sync();
        // 다운 로드 할 수 있도록 해주는 함수
//     myWebView.setDownloadListener(new DownloadListener() {
        //    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                // 다운로드 파일 웹 브라우저 사용
       //         Intent intent = new Intent(Intent.ACTION_VIEW);
   //             intent.setType(mimetype);
   //             intent.setData(Uri.parse(url));
   //             startActivity(intent);
  //          }
 //       });
    }
    //페이지이동 차후 웹뷰로 대체예정
    public void onButton1(View v){

        Intent i1;
        i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lute.fantazm.net"));
        startActivity(i1);
        Toast.makeText(MainActivity.this, "류트 서버로 이동 합니다.", Toast.LENGTH_SHORT).show();


    }
    public void onButton2(View v){

        Intent i1;
        i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://harp.fantazm.net"));
        startActivity(i1);
        Toast.makeText(MainActivity.this, "하프 서버로 이동 합니다.", Toast.LENGTH_SHORT).show();

    }
    public void onButton3(View v){

        Intent i1;
        i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mand.fantazm.net"));
        startActivity(i1);
        Toast.makeText(MainActivity.this, "만돌린 서버로 이동 합니다.", Toast.LENGTH_SHORT).show();

    }
    public void onButton4(View v){

        Intent i1;
        i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://wolf.fantazm.net"));
        startActivity(i1);
        Toast.makeText(MainActivity.this, "울프서버로 이동합니다.", Toast.LENGTH_SHORT).show();

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

    private class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (view==myWebView){
                    view.loadUrl(url);
                    return true;
                }
                return false;
            }
        }
    }


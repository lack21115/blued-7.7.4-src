package com.alipay.sdk.widget;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alipay.sdk.util.k;
import com.alipay.sdk.util.n;

public class p extends LinearLayout {
  private static Handler f = new Handler(Looper.getMainLooper());
  
  private ImageView a;
  
  private TextView b;
  
  private ImageView c;
  
  private ProgressBar d;
  
  private WebView e;
  
  private a g;
  
  private b h;
  
  private c i;
  
  private final com.alipay.sdk.sys.a j;
  
  private View.OnClickListener k = new q(this);
  
  private final float l;
  
  public p(Context paramContext, AttributeSet paramAttributeSet, com.alipay.sdk.sys.a parama) {
    super(paramContext, paramAttributeSet);
    this.j = parama;
    this.l = (paramContext.getResources().getDisplayMetrics()).density;
    setOrientation(1);
    a(paramContext);
    b(paramContext);
    c(paramContext);
  }
  
  public p(Context paramContext, com.alipay.sdk.sys.a parama) {
    this(paramContext, (AttributeSet)null, parama);
  }
  
  private int a(int paramInt) {
    return (int)(paramInt * this.l);
  }
  
  private void a(Context paramContext) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setBackgroundColor(-218103809);
    linearLayout.setOrientation(0);
    linearLayout.setGravity(16);
    this.a = new ImageView(paramContext);
    this.a.setOnClickListener(this.k);
    this.a.setScaleType(ImageView.ScaleType.CENTER);
    this.a.setImageDrawable(k.a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABIBAMAAACnw650AAAAFVBMVEUAAAARjusRkOkQjuoRkeoRj+oQjunya570AAAABnRSTlMAinWeSkk7CjRNAAAAZElEQVRIx+3MOw6AIBQF0YsrMDGx1obaLeGH/S9BQgkJ82rypp4ceTN1ilvyKizmZIAyU7FML0JVYig55BBAfQ2EU4V4CpZJ+2AiSj11C6rUoTannBpRn4W6xNQjLBSI2+TN0w/+3HT2wPClrQAAAABJRU5ErkJggg==", paramContext));
    this.a.setPadding(a(12), 0, a(12), 0);
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
    linearLayout.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams3);
    View view = new View(paramContext);
    view.setBackgroundColor(-2500135);
    linearLayout.addView(view, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(a(1), a(25)));
    this.b = new TextView(paramContext);
    this.b.setTextColor(-15658735);
    this.b.setTextSize(17.0F);
    this.b.setMaxLines(1);
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams2.setMargins(a(17), 0, 0, 0);
    layoutParams2.weight = 1.0F;
    linearLayout.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams2);
    this.c = new ImageView(paramContext);
    this.c.setOnClickListener(this.k);
    this.c.setScaleType(ImageView.ScaleType.CENTER);
    this.c.setImageDrawable(k.a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAAmVBMVEUAAAARj+oQjuoRkOsVk/AQj+oRjuoQj+oSkO3///8Rj+kRj+oQkOsTk+whm/8Qj+oRj+oQj+oSkus2p/8QjuoQj+oQj+oQj+oQj+oRj+oTkuwRj+oQj+oRj+oRj+oSkOsSkO0ZlfMbk+8XnPgQj+oRj+oQj+oQj+sSj+sRkOoSkescqv8Rj+oQj+oSj+sXku4Rj+kQjuoQjumXGBCVAAAAMnRSTlMAxPtPF8ry7CoB9npbGwe6lm0wBODazb1+aSejm5GEYjcTDwvls6uJc0g/CdWfRCF20AXrk5QAAAJqSURBVFjD7ZfXmpswEIUFphmDCxi3talurGvm/R8uYSDe5FNBwlzsxf6XmvFBmiaZ/PCdWDk9CWn61OhHCMAaXfoRAth7wx6EkMXnWyrho4yg4bDpquI8Jy78Q7eoj9cmUFijsaLM0JsD9CD0uQAa9aNdPuCFvbA7B9t/Becap8Pu6Q/2jcyH81VHc/WCHDQZXwbvtUhQ61iDlqadncU6Rp31yGkZIzOAu7AjtPpYGREzq/pY5DRFHS1siyO6HfkOKTrMjdb2qevV4zosK7MbkFY2LmYk55hL6juCIFWMOI2KGzblmho3b18EIbxL1hs6r5m2Q2WaEElwS3NW4xh6ZZJuzTtUsBKT4G0h35s4y1mNgkNoS6TZ8SKBXTZQGBNYdPTozXGYKoyLAmOasttjThT4xT6Ch+2qIjRhV9Ja3NC87Kyo5We1vCNEMW1T+j1VLZ9UhE54Q1DL52r5piJ0YxdegvWlHOwTu76uKkJX+MOTHno4YFSEbHYdhViojsLrCTg/MKnhKWaEYzvkZFM8aOkPH7iTSvoFZKD7jGEJbarkRaxQyOeWvGVIbsji152jK7TbDgRzcIuz7SGj89BFU8d30TqWeDtrILxyTkD1IXfvmHseuU3lVHDz607bw0f3xDqejm5ncd0j8VDwfoibRy8RcgTkWHBvocbDbMlJsQAkGnAOHwGy90kLmQY1Wkob07/GaCNRIzdoWK7/+6y/XkLDJCcynOGFuUrKIMuCMonNr9VpSOQoIxBgJ0SacGbzZNy4ICrkscvU2fpElYz+U3sd+aQThjfVmjNa5i15kLcojM3Gz8kP34jf4VaV3X55gNEAAAAASUVORK5CYII=", paramContext));
    this.c.setPadding(a(12), 0, a(12), 0);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    linearLayout.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams1);
    addView((View)linearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, a(48)));
  }
  
  private void b(Context paramContext) {
    this.d = new ProgressBar(paramContext, null, 16973855);
    this.d.setProgressDrawable(paramContext.getResources().getDrawable(17301612));
    this.d.setMax(100);
    this.d.setBackgroundColor(-218103809);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a(2));
    addView((View)this.d, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void c(Context paramContext) {
    this.e = new WebView(paramContext);
    this.e.setVerticalScrollbarOverlay(true);
    a(this.e, paramContext);
    WebSettings webSettings = this.e.getSettings();
    webSettings.setUseWideViewPort(true);
    webSettings.setAppCacheMaxSize(5242880L);
    webSettings.setAppCachePath(paramContext.getCacheDir().getAbsolutePath());
    webSettings.setAllowFileAccess(true);
    webSettings.setAppCacheEnabled(true);
    webSettings.setJavaScriptEnabled(true);
    webSettings.setCacheMode(-1);
    webSettings.setSupportMultipleWindows(true);
    webSettings.setJavaScriptEnabled(true);
    webSettings.setSavePassword(false);
    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    webSettings.setDomStorageEnabled(true);
    try {
      this.e.removeJavascriptInterface("searchBoxJavaBridge_");
      this.e.removeJavascriptInterface("accessibility");
      this.e.removeJavascriptInterface("accessibilityTraversal");
    } catch (Exception exception) {}
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView((View)this.e, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void a() {
    removeAllViews();
    this.e.removeAllViews();
    this.e.setWebViewClient(null);
    this.e.setWebChromeClient(null);
    this.e.destroy();
  }
  
  protected void a(WebView paramWebView, Context paramContext) {
    String str2 = paramWebView.getSettings().getUserAgentString();
    String str3 = paramContext.getPackageName();
    String str1 = n.a(this.j, paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append(" AlipaySDK(");
    stringBuilder.append(str3);
    stringBuilder.append("/");
    stringBuilder.append(str1);
    stringBuilder.append("/");
    stringBuilder.append("15.7.4");
    stringBuilder.append(")");
    str1 = stringBuilder.toString();
    paramWebView.getSettings().setUserAgentString(str1);
  }
  
  public void a(String paramString) {
    this.e.loadUrl(paramString);
  }
  
  public void a(String paramString, byte[] paramArrayOfbyte) {
    this.e.postUrl(paramString, paramArrayOfbyte);
  }
  
  public ImageView getBackButton() {
    return this.a;
  }
  
  public ProgressBar getProgressbar() {
    return this.d;
  }
  
  public ImageView getRefreshButton() {
    return this.c;
  }
  
  public TextView getTitle() {
    return this.b;
  }
  
  public String getUrl() {
    return this.e.getUrl();
  }
  
  public WebView getWebView() {
    return this.e;
  }
  
  public void setChromeProxy(a parama) {
    this.g = parama;
    if (parama == null) {
      this.e.setWebChromeClient(null);
      return;
    } 
    this.e.setWebChromeClient(new s(this));
  }
  
  public void setWebClientProxy(b paramb) {
    this.h = paramb;
    if (paramb == null) {
      this.e.setWebViewClient(null);
      return;
    } 
    this.e.setWebViewClient(new t(this));
  }
  
  public void setWebEventProxy(c paramc) {
    this.i = paramc;
  }
  
  public static interface a {
    void a(p param1p, String param1String);
    
    boolean a(p param1p, String param1String1, String param1String2, String param1String3, JsPromptResult param1JsPromptResult);
  }
  
  public static interface b {
    boolean a(p param1p, int param1Int, String param1String1, String param1String2);
    
    boolean a(p param1p, SslErrorHandler param1SslErrorHandler, SslError param1SslError);
    
    boolean b(p param1p, String param1String);
    
    boolean c(p param1p, String param1String);
  }
  
  public static interface c {
    void a(p param1p);
    
    void b(p param1p);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
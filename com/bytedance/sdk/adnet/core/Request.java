package com.bytedance.sdk.adnet.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Request<T> implements Comparable<Request<T>> {
  public static final int METHOD_DELETE = 3;
  
  public static final int METHOD_DEPRECATED_GET_OR_POST = -1;
  
  public static final int METHOD_GET = 0;
  
  public static final int METHOD_HEAD = 4;
  
  public static final int METHOD_OPTIONS = 5;
  
  public static final int METHOD_PATCH = 7;
  
  public static final int METHOD_POST = 1;
  
  public static final int METHOD_PUT = 2;
  
  public static final int METHOD_TRACE = 6;
  
  protected n.a<T> a;
  
  protected Handler b;
  
  private final p.a c;
  
  private final int d;
  
  private String e;
  
  private String f;
  
  private final int g;
  
  private final Object h;
  
  private Integer i;
  
  private m j;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  private boolean n;
  
  private d o;
  
  private com.bytedance.sdk.adnet.face.a.a p;
  
  private Object q;
  
  private long r;
  
  private long s;
  
  private boolean t;
  
  private String u;
  
  private Map<String, Object> v;
  
  private a w;
  
  public Request(int paramInt, String paramString, n.a<T> parama) {
    p.a a1;
    if (p.a.a) {
      a1 = new p.a();
    } else {
      a1 = null;
    } 
    this.c = a1;
    this.f = "VADNetAgent/0";
    this.h = new Object();
    this.k = true;
    this.l = false;
    this.m = false;
    this.n = false;
    this.p = null;
    this.r = 0L;
    this.s = 0L;
    this.t = true;
    this.b = new Handler(Looper.getMainLooper());
    this.d = paramInt;
    this.e = paramString;
    this.a = parama;
    setRetryPolicy(new e());
    this.g = b(paramString);
  }
  
  @Deprecated
  public Request(String paramString, n.a parama) {
    this(-1, paramString, parama);
  }
  
  private byte[] a(Map<String, String> paramMap, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      for (Map.Entry<String, String> entry : paramMap.entrySet()) {
        if (entry.getKey() != null && entry.getValue() != null) {
          stringBuilder.append(URLEncoder.encode((String)entry.getKey(), paramString));
          stringBuilder.append('=');
          stringBuilder.append(URLEncoder.encode((String)entry.getValue(), paramString));
          stringBuilder.append('&');
          continue;
        } 
        throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", new Object[] { entry.getKey(), entry.getValue() }));
      } 
      return stringBuilder.toString().getBytes(paramString);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Encoding not supported: ");
      stringBuilder.append(paramString);
      throw new RuntimeException(stringBuilder.toString(), unsupportedEncodingException);
    } 
  }
  
  private static int b(String paramString) {
    try {
      if (!TextUtils.isEmpty(paramString)) {
        Uri uri = Uri.parse(paramString);
        if (uri != null) {
          String str = uri.getHost();
          if (str != null)
            return str.hashCode(); 
        } 
      } 
    } finally {}
    return 0;
  }
  
  protected abstract n<T> a(j paramj);
  
  protected VAdError a(VAdError paramVAdError) {
    return paramVAdError;
  }
  
  @Deprecated
  protected Map<String, String> a() throws com.bytedance.sdk.adnet.err.a {
    return c();
  }
  
  void a(int paramInt) {
    m m1 = this.j;
    if (m1 != null)
      m1.a(this, paramInt); 
  }
  
  protected void a(long paramLong1, long paramLong2) {}
  
  void a(a parama) {
    synchronized (this.h) {
      this.w = parama;
      return;
    } 
  }
  
  protected abstract void a(n<T> paramn);
  
  void a(String paramString) {
    m m1 = this.j;
    if (m1 != null)
      m1.c(this); 
    if (p.a.a) {
      long l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.b.post(new Runnable(this, paramString, l) {
              public void run() {
                Request.a(this.c).a(this.a, this.b);
                Request.a(this.c).a(this.c.toString());
              }
            });
        return;
      } 
      this.c.a(paramString, l);
      this.c.a(toString());
    } 
  }
  
  public Request addExtra(String paramString, Object paramObject) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramObject == null)
        return this; 
      if (this.v == null)
        this.v = new HashMap<String, Object>(); 
      this.v.put(paramString, paramObject);
    } 
    return this;
  }
  
  public void addMarker(String paramString) {
    if (p.a.a)
      this.c.a(paramString, Thread.currentThread().getId()); 
  }
  
  @Deprecated
  protected String b() {
    return d();
  }
  
  void b(n<?> paramn) {
    synchronized (this.h) {
      a a1 = this.w;
      if (a1 != null)
        a1.a(this, paramn); 
      return;
    } 
  }
  
  public void build(m paramm) {
    if (paramm != null)
      paramm.a(this); 
  }
  
  protected Map<String, String> c() throws com.bytedance.sdk.adnet.err.a {
    return null;
  }
  
  public void cancel() {
    synchronized (this.h) {
      this.l = true;
      this.a = null;
      return;
    } 
  }
  
  public int compareTo(Request<T> paramRequest) {
    b b1 = getPriority();
    b b2 = paramRequest.getPriority();
    return (b1 == b2) ? (this.i.intValue() - paramRequest.i.intValue()) : (b2.ordinal() - b1.ordinal());
  }
  
  protected String d() {
    return "UTF-8";
  }
  
  public void deliverError(n<T> paramn) {
    synchronized (this.h) {
      n.a<T> a1 = this.a;
      if (a1 != null)
        a1.b(paramn); 
      return;
    } 
  }
  
  void e() {
    synchronized (this.h) {
      a a1 = this.w;
      if (a1 != null)
        a1.a(this); 
      return;
    } 
  }
  
  public n.a getBaseListener() {
    synchronized (this.h) {
      return this.a;
    } 
  }
  
  public byte[] getBody() throws com.bytedance.sdk.adnet.err.a {
    Map<String, String> map = c();
    return (map != null && map.size() > 0) ? a(map, d()) : null;
  }
  
  public String getBodyContentType() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("application/x-www-form-urlencoded; charset=");
    stringBuilder.append(d());
    return stringBuilder.toString();
  }
  
  public com.bytedance.sdk.adnet.face.a.a getCacheEntry() {
    return this.p;
  }
  
  public String getCacheKey() {
    String str2 = getUrl();
    int i = getMethod();
    String str1 = str2;
    if (i != 0) {
      if (i == -1)
        return str2; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Integer.toString(i));
      stringBuilder.append('-');
      stringBuilder.append(str2);
      str1 = stringBuilder.toString();
    } 
    return str1;
  }
  
  public Map<String, Object> getExtra() {
    return this.v;
  }
  
  public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
    return Collections.emptyMap();
  }
  
  public String getIpAddrStr() {
    return this.u;
  }
  
  public int getMethod() {
    return this.d;
  }
  
  public long getNetDuration() {
    return this.s;
  }
  
  @Deprecated
  public byte[] getPostBody() throws com.bytedance.sdk.adnet.err.a {
    Map<String, String> map = a();
    return (map != null && map.size() > 0) ? a(map, b()) : null;
  }
  
  public b getPriority() {
    return b.b;
  }
  
  public final m getRequestQueue() {
    return this.j;
  }
  
  public d getRetryPolicy() {
    return this.o;
  }
  
  public final int getSequence() {
    Integer integer = this.i;
    if (integer != null)
      return integer.intValue(); 
    throw new IllegalStateException("getSequence called before setSequence");
  }
  
  public long getStartTime() {
    return this.r;
  }
  
  public Object getTag() {
    return this.q;
  }
  
  public final int getTimeoutMs() {
    return getRetryPolicy().a();
  }
  
  public int getTrafficStatsTag() {
    return this.g;
  }
  
  public String getUrl() {
    return this.e;
  }
  
  public String getUserAgent() {
    return this.f;
  }
  
  public boolean hasHadResponseDelivered() {
    synchronized (this.h) {
      return this.m;
    } 
  }
  
  public boolean isCanceled() {
    synchronized (this.h) {
      return this.l;
    } 
  }
  
  public boolean isResponseOnMain() {
    return this.t;
  }
  
  public void markDelivered() {
    synchronized (this.h) {
      this.m = true;
      return;
    } 
  }
  
  public Request<?> setCacheEntry(com.bytedance.sdk.adnet.face.a.a parama) {
    this.p = parama;
    return this;
  }
  
  public void setIpAddrStr(String paramString) {
    this.u = paramString;
  }
  
  public void setNetDuration(long paramLong) {
    this.s = paramLong;
  }
  
  public Request<?> setRequestQueue(m paramm) {
    this.j = paramm;
    return this;
  }
  
  public Request<?> setResponseOnMain(boolean paramBoolean) {
    this.t = paramBoolean;
    return this;
  }
  
  public Request<?> setRetryPolicy(d paramd) {
    this.o = paramd;
    return this;
  }
  
  public final Request<?> setSequence(int paramInt) {
    this.i = Integer.valueOf(paramInt);
    return this;
  }
  
  public final Request<?> setShouldCache(boolean paramBoolean) {
    this.k = paramBoolean;
    return this;
  }
  
  public final Request<?> setShouldRetryServerErrors(boolean paramBoolean) {
    this.n = paramBoolean;
    return this;
  }
  
  public void setStartTime() {
    this.r = SystemClock.elapsedRealtime();
  }
  
  public Request<?> setTag(Object paramObject) {
    this.q = paramObject;
    return this;
  }
  
  public void setUrl(String paramString) {
    this.e = paramString;
  }
  
  public Request<?> setUserAgent(String paramString) {
    this.f = paramString;
    return this;
  }
  
  public final boolean shouldCache() {
    return this.k;
  }
  
  public final boolean shouldRetryServerErrors() {
    return this.n;
  }
  
  public String toString() {
    String str1;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("0x");
    stringBuilder1.append(Integer.toHexString(getTrafficStatsTag()));
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    if (isCanceled()) {
      str1 = "[X] ";
    } else {
      str1 = "[ ] ";
    } 
    stringBuilder2.append(str1);
    stringBuilder2.append(getUrl());
    stringBuilder2.append(" ");
    stringBuilder2.append(str2);
    stringBuilder2.append(" ");
    stringBuilder2.append(getPriority());
    stringBuilder2.append(" ");
    stringBuilder2.append(this.i);
    return stringBuilder2.toString();
  }
  
  static interface a {
    void a(Request<?> param1Request);
    
    void a(Request<?> param1Request, n<?> param1n);
  }
  
  public enum b {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
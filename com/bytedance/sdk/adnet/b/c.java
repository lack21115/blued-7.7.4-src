package com.bytedance.sdk.adnet.b;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.f;
import com.bytedance.sdk.adnet.face.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class c extends Request<File> {
  private File c;
  
  private File d;
  
  private final Object e = new Object();
  
  private n.a<File> f;
  
  public c(String paramString1, String paramString2, n.a<File> parama) {
    super(paramString2, parama);
    this.f = parama;
    this.c = new File(paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(".tmp");
    this.d = new File(stringBuilder.toString());
    try {
      if (this.c != null && this.c.getParentFile() != null && !this.c.getParentFile().exists())
        this.c.getParentFile().mkdirs(); 
    } finally {}
    setRetryPolicy((d)new e(25000, 1, 1.0F));
    setShouldCache(false);
  }
  
  private String a(HttpResponse paramHttpResponse, String paramString) {
    if (paramHttpResponse != null && paramHttpResponse.b() != null && !paramHttpResponse.b().isEmpty())
      for (Header header : paramHttpResponse.b()) {
        if (header != null && TextUtils.equals(header.a(), paramString))
          return header.b(); 
      }  
    return null;
  }
  
  private boolean b(HttpResponse paramHttpResponse) {
    return TextUtils.equals(a(paramHttpResponse, "Content-Encoding"), "gzip");
  }
  
  private boolean c(HttpResponse paramHttpResponse) {
    if (TextUtils.equals(a(paramHttpResponse, "Accept-Ranges"), "bytes"))
      return true; 
    String str = a(paramHttpResponse, "Content-Range");
    return (str != null && str.startsWith("bytes"));
  }
  
  private void h() {
    try {
      this.c.delete();
    } finally {
      Exception exception = null;
    } 
  }
  
  public n<File> a(j paramj) {
    if (!isCanceled()) {
      if (this.d.canRead() && this.d.length() > 0L) {
        if (this.d.renameTo(this.c))
          return n.a(null, com.bytedance.sdk.adnet.d.c.a(paramj)); 
        h();
        return n.a(new VAdError("Can't rename the download temporary file!"));
      } 
      h();
      return n.a(new VAdError("Download temporary file was invalid!"));
    } 
    h();
    return n.a(new VAdError("Request was Canceled!"));
  }
  
  public void a(long paramLong1, long paramLong2) {
    synchronized (this.e) {
      n.a<File> a1 = this.f;
      if (a1 instanceof a)
        ((a)a1).a(paramLong1, paramLong2); 
      return;
    } 
  }
  
  public void a(n<File> paramn) {
    synchronized (this.e) {
      n.a<File> a1 = this.f;
      if (a1 != null)
        a1.a(n.a(this.c, paramn.b)); 
      return;
    } 
  }
  
  public byte[] a(HttpResponse paramHttpResponse) throws IOException, f {
    InputStream inputStream;
    RandomAccessFile randomAccessFile;
    long l2 = paramHttpResponse.c();
    if (l2 <= 0L)
      p.b("Response doesn't present Content-Length!", new Object[0]); 
    long l1 = g().length();
    boolean bool = c(paramHttpResponse);
    if (bool) {
      long l = l2 + l1;
      inputStream = (InputStream)a(paramHttpResponse, "Content-Range");
      l2 = l;
      if (!TextUtils.isEmpty((CharSequence)inputStream)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bytes ");
        stringBuilder.append(l1);
        stringBuilder.append("-");
        stringBuilder.append(l - 1L);
        String str = stringBuilder.toString();
        if (TextUtils.indexOf((CharSequence)inputStream, str) != -1) {
          l2 = l;
        } else {
          null = new StringBuilder();
          null.append("The Content-Range Header is invalid Assume[");
          null.append(str);
          null.append("] vs Real[");
          null.append((String)inputStream);
          null.append("], please remove the temporary file [");
          null.append(g());
          null.append("].");
          throw new IllegalStateException(null.toString());
        } 
      } 
    } 
    if (l2 > 0L && f().length() == l2) {
      f().renameTo(g());
      a(l2, l2);
      return null;
    } 
    if (f() != null && f().exists())
      f().delete(); 
    try {
      randomAccessFile = new RandomAccessFile(g(), "rw");
    } finally {
      inputStream = null;
    } 
    try {
      InputStream inputStream2 = null.d();
      InputStream inputStream1 = inputStream2;
      inputStream = inputStream2;
    } finally {
      null = null;
    } 
    try {
      p.a("Error occured when FileRequest.parseHttpResponse", new Object[0]);
      if (inputStream != null)
        try {
          inputStream.close();
        } finally {
          null = null;
        }  
    } finally {
      if (inputStream != null)
        try {
          inputStream.close();
        } finally {
          Exception exception = null;
        }  
      if (inputStream != null);
    } 
  }
  
  public void cancel() {
    super.cancel();
    synchronized (this.e) {
      this.f = null;
      return;
    } 
  }
  
  public File f() {
    return this.c;
  }
  
  public File g() {
    return this.d;
  }
  
  public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bytes=");
    stringBuilder.append(this.d.length());
    stringBuilder.append("-");
    hashMap.put("Range", stringBuilder.toString());
    hashMap.put("Accept-Encoding", "identity");
    return (Map)hashMap;
  }
  
  public Request.b getPriority() {
    return Request.b.a;
  }
  
  public static interface a extends n.a<File> {
    void a(long param1Long1, long param1Long2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
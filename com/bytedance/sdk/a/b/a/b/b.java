package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.a.a;
import com.bytedance.sdk.a.b.k;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class b {
  private final List<k> a;
  
  private int b = 0;
  
  private boolean c;
  
  private boolean d;
  
  public b(List<k> paramList) {
    this.a = paramList;
  }
  
  private boolean b(SSLSocket paramSSLSocket) {
    for (int i = this.b; i < this.a.size(); i++) {
      if (((k)this.a.get(i)).a(paramSSLSocket))
        return true; 
    } 
    return false;
  }
  
  public k a(SSLSocket paramSSLSocket) throws IOException {
    k k;
    int i = this.b;
    int j = this.a.size();
    while (true) {
      if (i < j) {
        k k1 = this.a.get(i);
        if (k1.a(paramSSLSocket)) {
          this.b = i + 1;
          break;
        } 
        i++;
        continue;
      } 
      k = null;
      break;
    } 
    if (k != null) {
      this.c = b(paramSSLSocket);
      a.a.a(k, paramSSLSocket, this.d);
      return k;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unable to find acceptable protocols. isFallback=");
    stringBuilder.append(this.d);
    stringBuilder.append(", modes=");
    stringBuilder.append(this.a);
    stringBuilder.append(", supported protocols=");
    stringBuilder.append(Arrays.toString((Object[])paramSSLSocket.getEnabledProtocols()));
    throw new UnknownServiceException(stringBuilder.toString());
  }
  
  public boolean a(IOException paramIOException) {
    boolean bool = true;
    this.d = true;
    if (!this.c)
      return false; 
    if (paramIOException instanceof java.net.ProtocolException)
      return false; 
    if (paramIOException instanceof java.io.InterruptedIOException)
      return false; 
    boolean bool1 = paramIOException instanceof javax.net.ssl.SSLHandshakeException;
    if (bool1 && paramIOException.getCause() instanceof java.security.cert.CertificateException)
      return false; 
    if (paramIOException instanceof javax.net.ssl.SSLPeerUnverifiedException)
      return false; 
    if (!bool1) {
      if (paramIOException instanceof javax.net.ssl.SSLProtocolException)
        return true; 
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
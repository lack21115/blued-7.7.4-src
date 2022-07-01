package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f {
  private final com.bytedance.sdk.a.b.a a;
  
  private final d b;
  
  private final e c;
  
  private final p d;
  
  private List<Proxy> e = Collections.emptyList();
  
  private int f;
  
  private List<InetSocketAddress> g = Collections.emptyList();
  
  private final List<ac> h = new ArrayList<ac>();
  
  public f(com.bytedance.sdk.a.b.a parama, d paramd, e parame, p paramp) {
    this.a = parama;
    this.b = paramd;
    this.c = parame;
    this.d = paramp;
    a(parama.a(), parama.h());
  }
  
  static String a(InetSocketAddress paramInetSocketAddress) {
    InetAddress inetAddress = paramInetSocketAddress.getAddress();
    return (inetAddress == null) ? paramInetSocketAddress.getHostName() : inetAddress.getHostAddress();
  }
  
  private void a(s params, Proxy paramProxy) {
    if (paramProxy != null) {
      this.e = Collections.singletonList(paramProxy);
    } else {
      List<Proxy> list = this.a.g().select(params.a());
      if (list != null && !list.isEmpty()) {
        list = c.a(list);
      } else {
        list = c.a((Object[])new Proxy[] { Proxy.NO_PROXY });
      } 
      this.e = list;
    } 
    this.f = 0;
  }
  
  private void a(Proxy paramProxy) throws IOException {
    int i;
    String str;
    InetAddress inetAddress;
    this.g = new ArrayList<InetSocketAddress>();
    if (paramProxy.type() == Proxy.Type.DIRECT || paramProxy.type() == Proxy.Type.SOCKS) {
      str = this.a.a().f();
      i = this.a.a().g();
    } else {
      SocketAddress socketAddress = paramProxy.address();
      if (socketAddress instanceof InetSocketAddress) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
        str = a(inetSocketAddress);
        i = inetSocketAddress.getPort();
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Proxy.address() is not an InetSocketAddress: ");
        stringBuilder.append(str.getClass());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
    } 
    if (i >= 1 && i <= 65535) {
      if (stringBuilder.type() == Proxy.Type.SOCKS) {
        this.g.add(InetSocketAddress.createUnresolved(str, i));
        return;
      } 
      this.d.a(this.c, str);
      List<InetAddress> list = this.a.b().a(str);
      if (!list.isEmpty()) {
        this.d.a(this.c, str, list);
        int j = 0;
        int k = list.size();
        while (j < k) {
          inetAddress = list.get(j);
          this.g.add(new InetSocketAddress(inetAddress, i));
          j++;
        } 
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.a.b());
      stringBuilder1.append(" returned no addresses for ");
      stringBuilder1.append((String)inetAddress);
      throw new UnknownHostException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No route to ");
    stringBuilder.append((String)inetAddress);
    stringBuilder.append(":");
    stringBuilder.append(i);
    stringBuilder.append("; port is out of range");
    throw new SocketException(stringBuilder.toString());
  }
  
  private boolean c() {
    return (this.f < this.e.size());
  }
  
  private Proxy d() throws IOException {
    if (c()) {
      List<Proxy> list = this.e;
      int i = this.f;
      this.f = i + 1;
      Proxy proxy = list.get(i);
      a(proxy);
      return proxy;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No route to ");
    stringBuilder.append(this.a.a().f());
    stringBuilder.append("; exhausted proxy configurations: ");
    stringBuilder.append(this.e);
    throw new SocketException(stringBuilder.toString());
  }
  
  public void a(ac paramac, IOException paramIOException) {
    if (paramac.b().type() != Proxy.Type.DIRECT && this.a.g() != null)
      this.a.g().connectFailed(this.a.a().a(), paramac.b().address(), paramIOException); 
    this.b.a(paramac);
  }
  
  public boolean a() {
    return (c() || !this.h.isEmpty());
  }
  
  public a b() throws IOException {
    if (a()) {
      ArrayList<ac> arrayList = new ArrayList();
      while (c()) {
        Proxy proxy = d();
        int i = 0;
        int j = this.g.size();
        while (i < j) {
          ac ac = new ac(this.a, proxy, this.g.get(i));
          if (this.b.c(ac)) {
            this.h.add(ac);
          } else {
            arrayList.add(ac);
          } 
          i++;
        } 
        if (!arrayList.isEmpty())
          break; 
      } 
      if (arrayList.isEmpty()) {
        arrayList.addAll(this.h);
        this.h.clear();
      } 
      return new a(arrayList);
    } 
    throw new NoSuchElementException();
  }
  
  public static final class a {
    private final List<ac> a;
    
    private int b = 0;
    
    a(List<ac> param1List) {
      this.a = param1List;
    }
    
    public boolean a() {
      return (this.b < this.a.size());
    }
    
    public ac b() {
      if (a()) {
        List<ac> list = this.a;
        int i = this.b;
        this.b = i + 1;
        return list.get(i);
      } 
      throw new NoSuchElementException();
    }
    
    public List<ac> c() {
      return new ArrayList<ac>(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
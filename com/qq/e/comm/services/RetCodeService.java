package com.qq.e.comm.services;

import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Random;

public class RetCodeService {
  private final String a = "1000162";
  
  private final String b = "http://wspeed.qq.com/w.cgi";
  
  private final Random c = new Random(System.currentTimeMillis());
  
  private RetCodeService() {}
  
  private static String a(String paramString) {
    try {
      return InetAddress.getByName(paramString).getHostAddress();
    } catch (UnknownHostException unknownHostException) {
      return "0.0.0.0";
    } 
  }
  
  private boolean a(int paramInt) {
    return (this.c.nextDouble() < 1.0D / paramInt);
  }
  
  public static RetCodeService getInstance() {
    return Holder.a;
  }
  
  public void send(RetCodeInfo paramRetCodeInfo) {
    (new Thread(new SendTask(this, paramRetCodeInfo, 100))).start();
  }
  
  static class Holder {
    static final RetCodeService a = new RetCodeService((byte)0);
  }
  
  public static class RetCodeInfo {
    final String a;
    
    final String b;
    
    final String c;
    
    final int d;
    
    final int e;
    
    final int f;
    
    final int g;
    
    final int h;
    
    public RetCodeInfo(String param1String1, String param1String2, String param1String3, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1String3;
      this.d = param1Int1;
      this.e = param1Int2;
      this.f = param1Int3;
      this.g = param1Int4;
      this.h = param1Int5;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("RetCodeInfo [host=");
      stringBuilder.append(this.a);
      stringBuilder.append(", commandid=");
      stringBuilder.append(this.b);
      stringBuilder.append(", releaseversion=");
      stringBuilder.append(this.c);
      stringBuilder.append(", resultcode=");
      stringBuilder.append(this.d);
      stringBuilder.append(", tmcost=");
      stringBuilder.append(this.e);
      stringBuilder.append(", reqsize=");
      stringBuilder.append(this.f);
      stringBuilder.append(", rspsize=");
      stringBuilder.append(this.g);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  class SendTask implements Runnable {
    private RetCodeService.RetCodeInfo a;
    
    private int b;
    
    SendTask(RetCodeService this$0, RetCodeService.RetCodeInfo param1RetCodeInfo, int param1Int) {
      this.a = param1RetCodeInfo;
      this.b = 100;
    }
    
    public void run() {
      RetCodeService.a(this.c, this.a, this.b);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\services\RetCodeService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
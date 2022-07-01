package com.qq.e.comm.plugin.t;

public abstract class i implements b {
  public abstract void a(int paramInt, Exception paramException);
  
  public void a(Exception paramException) {
    char c;
    if (paramException instanceof java.net.SocketTimeoutException) {
      c = '஺';
    } else if (paramException instanceof java.net.UnknownHostException) {
      c = '஻';
    } else if (paramException instanceof java.net.ConnectException) {
      c = 'ஹ';
    } else if (paramException instanceof javax.net.ssl.SSLHandshakeException) {
      c = '஼';
    } else {
      c = 'ஸ';
    } 
    a(c, paramException);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
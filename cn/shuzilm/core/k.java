package cn.shuzilm.core;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class k implements HostnameVerifier {
  public boolean verify(String paramString, SSLSession paramSSLSession) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
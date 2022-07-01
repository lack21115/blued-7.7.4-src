package com.alipay.android.phone.mrpc.core.a;

import com.alipay.a.a.f;
import com.alipay.android.phone.mrpc.core.RpcException;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public final class e extends b {
  private int c;
  
  private Object d;
  
  public e(int paramInt, String paramString, Object paramObject) {
    super(paramString, paramObject);
    this.c = paramInt;
  }
  
  public final void a(Object paramObject) {
    this.d = paramObject;
  }
  
  public final byte[] a() {
    try {
      String str;
      ArrayList<BasicNameValuePair> arrayList = new ArrayList();
      if (this.d != null)
        arrayList.add(new BasicNameValuePair("extParam", f.a(this.d))); 
      arrayList.add(new BasicNameValuePair("operationType", this.a));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.c);
      arrayList.add(new BasicNameValuePair("id", stringBuilder.toString()));
      (new StringBuilder("mParams is:")).append(this.b);
      if (this.b == null) {
        str = "[]";
      } else {
        str = f.a(this.b);
      } 
      arrayList.add(new BasicNameValuePair("requestData", str));
      return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
    } catch (Exception exception) {
      String str;
      StringBuilder stringBuilder = new StringBuilder("request  =");
      stringBuilder.append(this.b);
      stringBuilder.append(":");
      stringBuilder.append(exception);
      if (stringBuilder.toString() == null) {
        str = "";
      } else {
        str = exception.getMessage();
      } 
      throw new RpcException(Integer.valueOf(9), str, exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
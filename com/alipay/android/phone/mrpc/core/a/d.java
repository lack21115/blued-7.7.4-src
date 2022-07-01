package com.alipay.android.phone.mrpc.core.a;

import com.alipay.a.a.e;
import com.alipay.android.phone.mrpc.core.RpcException;
import java.lang.reflect.Type;
import org.json.JSONObject;

public final class d extends a {
  public d(Type paramType, byte[] paramArrayOfbyte) {
    super(paramType, paramArrayOfbyte);
  }
  
  public final Object a() {
    try {
      String str = new String(this.b);
      StringBuilder stringBuilder = new StringBuilder("threadid = ");
      stringBuilder.append(Thread.currentThread().getId());
      stringBuilder.append("; rpc response:  ");
      stringBuilder.append(str);
      JSONObject jSONObject = new JSONObject(str);
      int i = jSONObject.getInt("resultStatus");
      if (i == 1000) {
        Type type = this.a;
        return (type == String.class) ? jSONObject.optString("result") : e.a(jSONObject.optString("result"), this.a);
      } 
      throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
    } catch (Exception exception) {
      String str;
      StringBuilder stringBuilder = new StringBuilder("response  =");
      stringBuilder.append(new String(this.b));
      stringBuilder.append(":");
      stringBuilder.append(exception);
      if (stringBuilder.toString() == null) {
        str = "";
      } else {
        str = str.getMessage();
      } 
      throw new RpcException(Integer.valueOf(10), str);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
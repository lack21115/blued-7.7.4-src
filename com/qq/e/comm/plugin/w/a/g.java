package com.qq.e.comm.plugin.w.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import com.qq.e.comm.plugin.s.c;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONObject;

public class g {
  private static void a(Context paramContext, c paramc) {
    String str = paramc.e();
    if (StringUtil.isEmpty(str)) {
      ak.a("[营销组件-电话组件] 获取display兜底号失败", new Object[0]);
      return;
    } 
    ak.a("[营销组件-电话组件] 获取display兜底号成功", new Object[0]);
    a(paramContext, str);
  }
  
  private static void a(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tel:");
    stringBuilder.append(paramString);
    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(stringBuilder.toString()));
    intent.setFlags(268435456);
    paramContext.startActivity(intent);
  }
  
  static <T> boolean a(T paramT, Context paramContext, d.a parama, d.b paramb, d.e parame) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramT != null) {
      bool1 = bool2;
      if (parama != null) {
        bool1 = bool2;
        if (paramb != null) {
          if (parame == null)
            return false; 
          c c = parama.c.l();
          if (c == null)
            return false; 
          String str = d.a((String)null, parama.a, paramb.b, paramb.d, paramb.i);
          if (StringUtil.isEmpty(str))
            return false; 
          Pair<Integer, JSONObject> pair = d.a(str, 4000L, parama, parame, paramb);
          if (pair != null && ((Integer)pair.first).intValue() == 200 && pair.second != null) {
            String str1 = ((JSONObject)pair.second).optString("fmcphone");
            if (StringUtil.isEmpty(str1)) {
              ak.a("[营销组件-电话组件] 点击CGI请求成功，获取中间号失败", new Object[0]);
            } else {
              ak.a("[营销组件-电话组件] 获取点击CGI中间号成功", new Object[0]);
              a(paramContext, str1);
              bool1 = true;
            } 
          } else {
            ak.a("[营销组件-电话组件] 点击CGI请求失败", new Object[0]);
          } 
          a(paramContext, c);
        } else {
          return bool1;
        } 
      } else {
        return bool1;
      } 
    } else {
      return bool1;
    } 
    bool1 = true;
  }
  
  public static <T> boolean a(T paramT, d.a parama, d.b paramb, d.e parame) {
    if (paramT != null && parama != null && paramb != null && parame != null) {
      c c = parama.c.l();
      if (c != null && !StringUtil.isEmpty(c.c())) {
        String str = d.a((String)null, parama.a, paramb.b, paramb.d, paramb.i);
        if (!StringUtil.isEmpty(str)) {
          d.a(str, 4000L, parama, parame, paramb);
          return true;
        } 
      } 
    } 
    return false;
  }
  
  public static <T> boolean b(T paramT, Context paramContext, d.a parama, d.b paramb, d.e parame) {
    if (paramT != null && parama != null && paramb != null && parame != null) {
      c c = parama.c.l();
      if (c != null) {
        String str = c.d();
        if (!StringUtil.isEmpty(str)) {
          String str1 = d.a((String)null, parama.a, paramb.b, paramb.d, paramb.i);
          if (!StringUtil.isEmpty(str1)) {
            a.a(paramContext, str, parama, parame);
            d.a(str1, 4000L, parama, parame, paramb);
            return true;
          } 
        } 
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.alibaba.mtl.appmonitor.f;

import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.appmonitor.a.d;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.a.h;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.c.d;
import com.alibaba.mtl.appmonitor.e.a;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class c {
  public static void a(h paramh) {
    if (paramh == null)
      return; 
    a.a(paramh.u, String.valueOf(paramh.e), paramh.v, paramh.w, paramh.x, paramh.k);
    a.a().a((b)paramh);
  }
  
  public static void a(UTDimensionValueSet paramUTDimensionValueSet, d paramd) {
    Integer integer = paramUTDimensionValueSet.getEventId();
    if (integer != null) {
      f f = f.a(integer.intValue());
      h h = (h)a.a().a(h.class, new Object[0]);
      h.e = 6699;
      if (paramUTDimensionValueSet.getMap() != null)
        h.k.putAll(paramUTDimensionValueSet.getMap()); 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("meta", SdkMeta.getSDKMetaData());
      hashMap.put("_event_id", integer);
      d d1 = (d)a.a().a(d.class, new Object[0]);
      d1.put(paramd.a());
      a.a().a((b)paramd);
      hashMap.put("data", d1);
      h.k.put(f.a(), (new JSONObject(hashMap)).toString());
      h.k.put(LogField.EVENTID.toString(), String.valueOf(6699));
      b(h);
      a.a().a((b)d1);
    } 
  }
  
  public static void b(h paramh) {
    i.a("UTUtil", new Object[] { "upload without flowback. args:", paramh.k });
    a.a().a(paramh.k);
    a.a().a((b)paramh);
  }
  
  public static void b(Map<UTDimensionValueSet, List<d>> paramMap) {
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    for (Map.Entry<UTDimensionValueSet, List<d>> entry : paramMap.entrySet()) {
      UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet)entry.getKey();
      List list = (List)entry.getValue();
      if (list.size() != 0) {
        Integer integer = uTDimensionValueSet.getEventId();
        if (integer != null) {
          f f = f.a(integer.intValue());
          a a = a.a();
          int i = 0;
          h h = (h)a.a(h.class, new Object[0]);
          h.e = integer.intValue();
          if (uTDimensionValueSet.getMap() != null)
            h.k.putAll(uTDimensionValueSet.getMap()); 
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("meta", SdkMeta.getSDKMetaData());
          d d = (d)a.a().a(d.class, new Object[0]);
          for (d d1 : list) {
            d.put(d1.a());
            if (!i) {
              stringBuilder1.append(d1.o);
              stringBuilder2.append(d1.p);
            } else {
              stringBuilder1.append(",");
              stringBuilder1.append(d1.o);
              stringBuilder2.append(",");
              stringBuilder2.append(d1.p);
            } 
            i++;
            a.a().a((b)d1);
          } 
          hashMap.put("data", d);
          h.k.put(f.a(), (new JSONObject(hashMap)).toString());
          String str1 = stringBuilder1.toString();
          String str2 = stringBuilder2.toString();
          h.k.put(LogField.ARG1.toString(), str1);
          h.k.put(LogField.ARG2.toString(), str2);
          h.v = str1;
          h.w = str2;
          b(h);
          a.a().a((b)d);
        } 
      } 
      a.a().a((b)uTDimensionValueSet);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
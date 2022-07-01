package com.datavisor.vangogh.d;

import android.content.Context;
import android.util.Base64;
import com.datavisor.vangogh.f.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class d {
  private static String a(List<a> paramList) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    } finally {
      paramList = null;
    } 
    if (paramList != null)
      try {
        return null;
      } finally {
        paramList = null;
      }  
    return null;
  }
  
  private static List<a> a(String paramString) {
    try {
      ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramString.getBytes(), 0)));
    } finally {
      paramString = null;
    } 
    if (paramString != null)
      try {
        return null;
      } finally {
        paramString = null;
      }  
    return null;
  }
  
  public static void a(Context paramContext) {
    if (paramContext == null)
      return; 
    try {
      String str = com.datavisor.vangogh.e.b.a.a(paramContext, "DVSPEVENTFAILS");
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void a(Context paramContext, Map<String, String> paramMap, byte[] paramArrayOfbyte) {
    if (paramContext != null) {
      if (paramArrayOfbyte == null)
        return; 
      try {
        a a;
        String str2 = com.datavisor.vangogh.e.b.a.a(paramContext, "DVSPEVENTFAILS");
        List<a> list = null;
        if (f.b(str2))
          list = a(str2); 
        if (list != null) {
          if (list.size() >= 5)
            list.remove(0); 
          a = new a(paramMap, paramArrayOfbyte);
        } else {
          list = new ArrayList<a>();
          a = new a((Map<String, String>)a, paramArrayOfbyte);
        } 
        list.add(a);
        String str1 = a(list);
        return;
      } finally {
        paramContext = null;
      } 
    } 
  }
  
  static class a implements Serializable {
    private Map<String, String> a;
    
    private byte[] b;
    
    public a(Map<String, String> param1Map, byte[] param1ArrayOfbyte) {
      this.a = param1Map;
      this.b = param1ArrayOfbyte;
    }
    
    public Map<String, String> a() {
      return this.a;
    }
    
    public byte[] b() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
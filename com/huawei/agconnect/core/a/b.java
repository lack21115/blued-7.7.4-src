package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b {
  private Context a;
  
  b(Context paramContext) {
    this.a = paramContext;
  }
  
  private <T extends ServiceRegistrar> T a(String paramString) {
    String str;
    try {
      StringBuilder stringBuilder;
      Class<?> clazz = Class.forName(paramString);
      if (!ServiceRegistrar.class.isAssignableFrom(clazz)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(clazz);
        stringBuilder.append(" must extends from ServiceRegistrar.");
        Log.e("ServiceRegistrarParser", stringBuilder.toString());
        return null;
      } 
      return (T)Class.forName((String)stringBuilder).newInstance();
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can not found service class, ");
      stringBuilder.append(classNotFoundException.getMessage());
      str = stringBuilder.toString();
    } catch (InstantiationException instantiationException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("instantiate service class exception ");
      String str1 = instantiationException.getLocalizedMessage();
      stringBuilder.append(str1);
      str = stringBuilder.toString();
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("instantiate service class exception ");
      String str1 = illegalAccessException.getLocalizedMessage();
      stringBuilder.append(str1);
      str = stringBuilder.toString();
    } 
    Log.e("ServiceRegistrarParser", str);
    return null;
  }
  
  private List<String> b() {
    ArrayList<String> arrayList1 = new ArrayList();
    Bundle bundle = c();
    if (bundle == null)
      return arrayList1; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(10);
    for (String str : bundle.keySet()) {
      if ("com.huawei.agconnect.core.ServiceRegistrar".equals(bundle.getString(str))) {
        String str1;
        StringBuilder stringBuilder;
        String[] arrayOfString = str.split(":");
        if (arrayOfString.length == 2) {
          try {
            hashMap.put(arrayOfString[0], Integer.valueOf(arrayOfString[1]));
            continue;
          } catch (NumberFormatException numberFormatException) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("registrar configuration format error:");
            str1 = numberFormatException.getMessage();
          } 
        } else {
          if (stringBuilder.length == 1) {
            hashMap.put(stringBuilder[0], Integer.valueOf(1000));
            continue;
          } 
          stringBuilder = new StringBuilder();
          stringBuilder.append("registrar configuration error, ");
        } 
        stringBuilder.append(str1);
        Log.e("ServiceRegistrarParser", stringBuilder.toString());
      } 
    } 
    ArrayList<?> arrayList = new ArrayList(hashMap.entrySet());
    Collections.sort(arrayList, new a());
    Iterator<?> iterator = arrayList.iterator();
    while (iterator.hasNext())
      arrayList1.add((String)((Map.Entry)iterator.next()).getKey()); 
    return arrayList1;
  }
  
  private Bundle c() {
    PackageManager packageManager = this.a.getPackageManager();
    if (packageManager == null)
      return null; 
    try {
      ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(this.a, ServiceDiscovery.class), 128);
      if (serviceInfo == null) {
        Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
        return null;
      } 
      return serviceInfo.metaData;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get ServiceDiscovery exception.");
      stringBuilder.append(nameNotFoundException.getLocalizedMessage());
      Log.e("ServiceRegistrarParser", stringBuilder.toString());
      return null;
    } 
  }
  
  public List<Service> a() {
    Log.i("ServiceRegistrarParser", "getServices");
    List<String> list = b();
    ArrayList<Service> arrayList = new ArrayList();
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      ServiceRegistrar serviceRegistrar = (ServiceRegistrar)a(iterator.next());
      if (serviceRegistrar != null) {
        serviceRegistrar.a(this.a);
        List list1 = serviceRegistrar.b(this.a);
        if (list1 != null)
          arrayList.addAll(list1); 
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("services:");
    stringBuilder.append(Integer.valueOf(arrayList.size()));
    Log.i("ServiceRegistrarParser", stringBuilder.toString());
    return arrayList;
  }
  
  static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
    private a() {}
    
    public int a(Map.Entry<String, Integer> param1Entry1, Map.Entry<String, Integer> param1Entry2) {
      return ((Integer)param1Entry1.getValue()).intValue() - ((Integer)param1Entry2.getValue()).intValue();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\core\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
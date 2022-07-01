package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.NetworkInfo;
import java.util.ArrayList;
import java.util.Hashtable;

public final class Hosts {
  private final Hashtable<String, ArrayList<Value>> hosts = new Hashtable<String, ArrayList<Value>>();
  
  private ArrayList<Value> filter(ArrayList<Value> paramArrayList, NetworkInfo paramNetworkInfo) {
    ArrayList<Value> arrayList1 = new ArrayList();
    ArrayList<Value> arrayList2 = new ArrayList();
    for (Value value : paramArrayList) {
      if (value.provider == 0)
        arrayList1.add(value); 
      if (paramNetworkInfo.provider != 0 && value.provider == paramNetworkInfo.provider)
        arrayList2.add(value); 
    } 
    return (arrayList2.size() != 0) ? arrayList2 : arrayList1;
  }
  
  public Hosts put(String paramString, Value paramValue) {
    ArrayList<Value> arrayList2 = this.hosts.get(paramString);
    ArrayList<Value> arrayList1 = arrayList2;
    if (arrayList2 == null)
      arrayList1 = new ArrayList(); 
    arrayList1.add(paramValue);
    this.hosts.put(paramString, arrayList1);
    return this;
  }
  
  public Hosts put(String paramString1, String paramString2) {
    put(paramString1, new Value(paramString2));
    return this;
  }
  
  public String[] query(Domain paramDomain, NetworkInfo paramNetworkInfo) {
    ArrayList<Value> arrayList = this.hosts.get(paramDomain.domain);
    if (arrayList == null || arrayList.isEmpty())
      return null; 
    if (arrayList.size() > 1) {
      Value value = arrayList.get(0);
      arrayList.remove(0);
      arrayList.add(value);
    } 
    return toIps(filter(arrayList, paramNetworkInfo));
  }
  
  public String[] toIps(ArrayList<Value> paramArrayList) {
    int j = paramArrayList.size();
    String[] arrayOfString = new String[j];
    for (int i = 0; i < j; i++)
      arrayOfString[i] = ((Value)paramArrayList.get(i)).ip; 
    return arrayOfString;
  }
  
  public static class Value {
    public final String ip;
    
    public final int provider;
    
    public Value(String param1String) {
      this(param1String, 0);
    }
    
    public Value(String param1String, int param1Int) {
      this.ip = param1String;
      this.provider = param1Int;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (!(param1Object instanceof Value))
          return false; 
        param1Object = param1Object;
        return (this.ip.equals(((Value)param1Object).ip) && this.provider == ((Value)param1Object).provider);
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\local\Hosts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
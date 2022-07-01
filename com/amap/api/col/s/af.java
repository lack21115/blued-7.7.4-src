package com.amap.api.col.s;

import com.amap.api.services.core.LatLonPoint;
import java.util.LinkedHashMap;

final class af extends ae {
  private double a = 0.0D;
  
  public af(String... paramVarArgs) {
    super(paramVarArgs);
    this.a = 0.0D;
  }
  
  public final double a() {
    return this.a;
  }
  
  public final void a(ad.a parama) {
    super.a(parama);
    if (parama != null)
      this.a = parama.d(); 
  }
  
  protected final boolean a(LinkedHashMap<ad.b, Object> paramLinkedHashMap, ad.b paramb) {
    if (paramLinkedHashMap != null) {
      if (paramb == null)
        return false; 
      if (paramb.b == null)
        return super.a(paramLinkedHashMap, paramb); 
      for (ad.b b1 : paramLinkedHashMap.keySet()) {
        if (b1 != null && b1.a != null && b1.a.equals(paramb.a) && b1.b instanceof a && ((a)b1.b).a(paramb.b))
          return true; 
      } 
    } 
    return false;
  }
  
  protected final Object b(LinkedHashMap<ad.b, Object> paramLinkedHashMap, ad.b paramb) {
    if (paramLinkedHashMap != null) {
      if (paramb == null)
        return null; 
      if (paramb.b == null)
        return super.b(paramLinkedHashMap, paramb); 
      for (ad.b b1 : paramLinkedHashMap.keySet()) {
        if (b1 != null && b1.a != null && b1.a.equals(paramb.a) && b1.b instanceof a && ((a)b1.b).a(paramb.b))
          return paramLinkedHashMap.get(b1); 
      } 
    } 
    return null;
  }
  
  protected final Object c(LinkedHashMap<ad.b, Object> paramLinkedHashMap, ad.b paramb) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 125
    //   4: aload_2
    //   5: ifnonnull -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_2
    //   11: getfield b : Ljava/lang/Object;
    //   14: ifnonnull -> 24
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: invokespecial c : (Ljava/util/LinkedHashMap;Lcom/amap/api/col/s/ad$b;)Ljava/lang/Object;
    //   23: areturn
    //   24: aload_1
    //   25: invokevirtual keySet : ()Ljava/util/Set;
    //   28: invokeinterface iterator : ()Ljava/util/Iterator;
    //   33: astore #4
    //   35: aload #4
    //   37: invokeinterface hasNext : ()Z
    //   42: ifeq -> 113
    //   45: aload #4
    //   47: invokeinterface next : ()Ljava/lang/Object;
    //   52: checkcast com/amap/api/col/s/ad$b
    //   55: astore_3
    //   56: aload_3
    //   57: ifnull -> 35
    //   60: aload_3
    //   61: getfield a : Ljava/lang/String;
    //   64: ifnull -> 35
    //   67: aload_3
    //   68: getfield a : Ljava/lang/String;
    //   71: aload_2
    //   72: getfield a : Ljava/lang/String;
    //   75: invokevirtual equals : (Ljava/lang/Object;)Z
    //   78: ifeq -> 35
    //   81: aload_3
    //   82: getfield b : Ljava/lang/Object;
    //   85: instanceof com/amap/api/col/s/af$a
    //   88: ifeq -> 35
    //   91: aload_3
    //   92: getfield b : Ljava/lang/Object;
    //   95: checkcast com/amap/api/col/s/af$a
    //   98: aload_2
    //   99: getfield b : Ljava/lang/Object;
    //   102: invokevirtual a : (Ljava/lang/Object;)Z
    //   105: ifeq -> 35
    //   108: aload_3
    //   109: astore_2
    //   110: goto -> 115
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull -> 125
    //   119: aload_1
    //   120: aload_2
    //   121: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   124: areturn
    //   125: aconst_null
    //   126: areturn
  }
  
  static final class a {
    LatLonPoint a = null;
    
    double b = 0.0D;
    
    public a(double param1Double1, double param1Double2, double param1Double3) {
      this.a = new LatLonPoint(param1Double1, param1Double2);
      this.b = param1Double3;
    }
    
    public final boolean a(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        LatLonPoint latLonPoint1 = this.a;
        param1Object = param1Object;
        LatLonPoint latLonPoint2 = ((a)param1Object).a;
        if (latLonPoint1 == latLonPoint2)
          return true; 
        if (latLonPoint1 != null && i.a(latLonPoint1, latLonPoint2) <= ((a)param1Object).b)
          return true; 
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
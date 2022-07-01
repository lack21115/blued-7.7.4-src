package com.ishumei.l111l11111Il;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l1111llIl.l111l1111l1Il;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public final class l11l1111I1ll {
  private Object l1111l111111Il = null;
  
  private Context l111l11111lIl = null;
  
  public l11l1111I1ll() {
    try {
      if (l111l1111llIl.l1111l111111Il.l111l11111Il != null) {
        this.l111l11111lIl = l111l1111llIl.l1111l111111Il.l111l11111Il;
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        String str1 = l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92ac9a8d89969c9a");
        String str2 = l111l1111lI1l.l111l11111Il("8f9790919a");
        this.l1111l111111Il = l111l1111l1Il.l1111l111111Il(context, str1, new Class[] { String.class }, new Object[] { str2 });
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static int l1111l111111Il(Object paramObject, String paramString, Object... paramVarArgs) {
    Method method = paramObject.getClass().getDeclaredMethod(paramString, new Class[0]);
    if (!method.isAccessible())
      method.setAccessible(true); 
    return ((Integer)method.invoke(paramObject, paramVarArgs)).intValue();
  }
  
  private CellLocation l1111l111111Il(List<?> paramList) {
    if (paramList != null) {
      if (paramList.isEmpty())
        return null; 
      ClassLoader classLoader = ClassLoader.getSystemClassLoader();
      Exception exception2 = null;
      Exception exception1 = exception2;
      int j = 0;
      int i = 0;
      while (true) {
        int k = i;
        object1 = exception2;
        Object object2 = exception1;
        if (j < paramList.size()) {
          Object object4 = paramList.get(j);
          k = i;
          object1 = exception2;
          object2 = exception1;
          if (object4 != null) {
            k = i;
            try {
              Class<?> clazz1 = classLoader.loadClass(l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990b88c92"));
              k = i;
              Class<?> clazz2 = classLoader.loadClass(l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990a89c9b929e"));
              k = i;
              Class<?> clazz3 = classLoader.loadClass(l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990b38b9a"));
              k = i;
              Class<?> clazz4 = classLoader.loadClass(l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990bc9b929e"));
              k = i;
              if (clazz1.isInstance(object4)) {
                i = 1;
              } else {
                k = i;
                if (clazz2.isInstance(object4)) {
                  i = 2;
                } else {
                  k = i;
                  if (clazz3.isInstance(object4)) {
                    i = 3;
                  } else {
                    k = i;
                    if (clazz4.isInstance(object4)) {
                      i = 4;
                    } else {
                      i = 0;
                    } 
                  } 
                } 
              } 
              k = i;
              object1 = exception2;
              object2 = exception1;
              if (i > 0) {
                if (i == 1) {
                  k = i;
                  object1 = clazz1.cast(object4);
                } else if (i == 2) {
                  k = i;
                  object1 = clazz2.cast(object4);
                } else if (i == 3) {
                  k = i;
                  object1 = clazz3.cast(object4);
                } else {
                  k = i;
                  object1 = clazz4.cast(object4);
                } 
                k = i;
                object2 = l111l11111lIl(object1, l111l1111lI1l.l111l11111Il("989a8bbc9a9393b69b9a918b968b86"), new Object[0]);
                if (object2 == null) {
                  k = i;
                  object1 = exception2;
                  object2 = exception1;
                } else if (i == 4) {
                  k = i;
                  object1 = new CdmaCellLocation();
                  try {
                    k = l1111l111111Il(object2, l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92b69b"), new Object[0]);
                    int m = l1111l111111Il(object2, l111l1111lI1l.l111l11111Il("989a8bb19a8b88908d94b69b"), new Object[0]);
                    int n = l1111l111111Il(object2, l111l1111lI1l.l111l11111Il("989a8bbd9e8c9a8c8b9e8b969091b69b"), new Object[0]);
                    int i1 = l1111l111111Il(object2, l111l1111lI1l.l111l11111Il("989a8bb3909198968b8a9b9a"), new Object[0]);
                    object1.setCellLocationData(n, l1111l111111Il(object2, l111l1111lI1l.l111l11111Il("989a8bb39e8b968b8a9b9a"), new Object[0]), i1, k, m);
                    object2 = object1;
                    k = i;
                    object1 = exception2;
                    return (CellLocation)((k == 4) ? object2 : object1);
                  } catch (Exception exception3) {
                    object2 = object1;
                    k = i;
                    object1 = exception2;
                  } 
                } else {
                  int m;
                  if (i == 3) {
                    k = i;
                    m = l1111l111111Il(object2, l111l1111lI1l.l111l11111Il("989a8bab9e9c"), new Object[0]);
                    k = i;
                    int n = l1111l111111Il(object2, l111l1111lI1l.l111l11111Il("989a8bbc96"), new Object[0]);
                    k = i;
                    object1 = new GsmCellLocation();
                    k = n;
                  } else {
                    k = i;
                    m = l1111l111111Il(object2, l111l1111lI1l.l111l11111Il("989a8bb39e9c"), new Object[0]);
                    k = i;
                    int n = l1111l111111Il(object2, l111l1111lI1l.l111l11111Il("989a8bbc969b"), new Object[0]);
                    k = i;
                    object1 = new GsmCellLocation();
                    k = n;
                  } 
                  try {
                    object1.setLacAndCid(m, k);
                    k = i;
                    object2 = exception3;
                    return (CellLocation)((k == 4) ? object2 : object1);
                  } catch (Exception exception4) {
                    object2 = exception3;
                    k = i;
                  } 
                } 
              } 
            } catch (Exception object1) {
              object1 = exception4;
              object2 = exception3;
            } 
          } 
          j++;
          i = k;
          exception2 = (Exception)object1;
          Object object3 = object2;
          continue;
        } 
        return (CellLocation)((k == 4) ? object2 : object1);
      } 
    } 
    return null;
  }
  
  private Object l1111l111111Il(String paramString) {
    Object object = null;
    try {
      if (this.l111l11111lIl != null)
        object = l111l1111l1Il.l1111l111111Il(this.l111l11111lIl.getApplicationContext(), l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92ac9a8d89969c9a"), new Class[] { String.class }, new Object[] { paramString }); 
      return object;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static Object l111l11111lIl(Object paramObject, String paramString, Object... paramVarArgs) {
    Class<?> clazz = paramObject.getClass();
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++) {
      arrayOfClass[i] = paramVarArgs[i].getClass();
      if (arrayOfClass[i] == Integer.class)
        arrayOfClass[i] = int.class; 
    } 
    Method method = clazz.getDeclaredMethod(paramString, arrayOfClass);
    if (!method.isAccessible())
      method.setAccessible(true); 
    return method.invoke(paramObject, paramVarArgs);
  }
  
  private static int l111l1111lI1l() {
    try {
      Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1b2ac9692ab9a939a8f97909186b29e919e989a8d"));
      return 1;
    } catch (Exception exception) {
      try {
        Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1ab9a939a8f97909186b29e919e989a8dcd"));
        return 2;
      } catch (SecurityException securityException) {
        return -1001;
      } catch (Exception exception1) {
        return 0;
      } 
    } 
  }
  
  private Object l111l1111lIl() {
    int i = l111l1111lI1l();
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return null; 
        String str2 = "8f9790919acd";
        return l1111l111111Il(l111l1111lI1l.l111l11111Il(str2));
      } 
      String str1 = "8f9790919aa0928c9692";
      return l1111l111111Il(l111l1111lI1l.l111l11111Il(str1));
    } 
    String str = "8f9790919a";
    return l1111l111111Il(l111l1111lI1l.l111l11111Il(str));
  }
  
  private int l111l1111llIl() {
    try {
      if (this.l1111l111111Il != null)
        return ((Integer)l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, l111l1111lI1l.l111l11111Il("989a8bac9692ac8b9e8b9a"))).intValue(); 
    } catch (SecurityException securityException) {
      return -1001;
    } catch (Exception exception) {}
    return 0;
  }
  
  private CellLocation l11l1111I11l() {
    Object object1;
    Class clazz1 = null;
    try {
      int i = l111l1111lI1l();
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            object = null;
          } else {
            String str = "8f9790919acd";
            object = (Object<?>)l1111l111111Il(l111l1111lI1l.l111l11111Il(str));
          } 
        } else {
          String str = "8f9790919aa0928c9692";
          object = (Object<?>)l1111l111111Il(l111l1111lI1l.l111l11111Il(str));
        } 
      } else {
        String str = "8f9790919a";
        object = (Object<?>)l1111l111111Il(l111l1111lI1l.l111l11111Il(str));
      } 
    } catch (Exception object) {
      return null;
    } 
    if (object == null)
      return null; 
    Class<?> clazz = l11l1111lIIl();
    if (clazz.isInstance(object)) {
      Object object2 = clazz.cast(object);
      String str = l111l1111lI1l.l111l11111Il("989a8bbc9a9393b3909c9e8b969091");
      try {
        object1 = l111l11111lIl(object2, str, new Object[0]);
      } catch (Exception exception) {
        clazz = null;
      } 
      object = (Object<?>)clazz;
      if (clazz == null) {
        object = (Object<?>)clazz;
        try {
          object1 = l111l11111lIl(object2, str, new Object[] { Integer.valueOf(0) });
          object = (Object<?>)object1;
          if (object1 == null) {
            object = (Object<?>)object1;
            object1 = l111l11111lIl(object2, str, new Object[] { Integer.valueOf(1) });
            object = (Object<?>)object1;
          } 
        } catch (Exception null) {}
      } 
      if (object == null) {
        object1 = l111l1111lI1l.l111l11111Il("989a8bbc9a9393b3909c9e8b969091b89a92969196");
        try {
          Object object3 = l111l11111lIl(object2, (String)object1, new Object[] { Integer.valueOf(1) });
          object = (Object<?>)object3;
        } catch (Exception exception) {}
      } 
      if (object == null) {
        object = (Object<?>)l111l1111lI1l.l111l11111Il("989a8bbe9393bc9a9393b6919990");
        try {
          object = (Object<?>)l111l11111lIl(object2, (String)object, new Object[0]);
        } catch (Exception exception) {
          exception = null;
        } 
        CellLocation cellLocation = l1111l111111Il((List<?>)exception);
      } 
    } else {
      object = null;
    } 
    clazz = clazz1;
    if (object != null)
      object1 = object; 
    return (CellLocation)object1;
  }
  
  private Class<?> l11l1111lIIl() {
    String str;
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    int i = l111l1111lI1l();
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          str = null;
        } else {
          str = "9e919b8d90969bd18b9a939a8f97909186d1ab9a939a8f97909186b29e919e989a8dcd";
          str = l111l1111lI1l.l111l11111Il(str);
        } 
      } else {
        str = "9e919b8d90969bd18b9a939a8f97909186d1b2ac9692ab9a939a8f97909186b29e919e989a8d";
        str = l111l1111lI1l.l111l11111Il(str);
      } 
    } else {
      str = "9e919b8d90969bd18b9a939a8f97909186d1ab9a939a8f97909186b29e919e989a8d";
      str = l111l1111lI1l.l111l11111Il(str);
    } 
    try {
      return classLoader.loadClass(str);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public final String l1111l111111Il() {
    String str = "";
    try {
      l111l1111lI1l.l111l11111Il("b1b0afbaadb2");
      if (this.l1111l111111Il != null) {
        str = (String)l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, l111l1111lI1l.l111l11111Il("989a8bbb9a89969c9ab69b"));
        if (str == null)
          return ""; 
      } 
      return str;
    } catch (SecurityException|Exception securityException) {
      return "";
    } 
  }
  
  public final String l1111l111111Il(int paramInt) {
    String str = "";
    try {
      l111l1111lI1l.l111l11111Il("b1b0afbaadb2");
      if (this.l1111l111111Il != null)
        str = (String)l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, l111l1111lI1l.l111l11111Il("989a8bbb9a89969c9ab69b"), new Class[] { int.class }, new Object[] { Integer.valueOf(paramInt) }); 
      return str;
    } catch (SecurityException|Exception securityException) {
      return "";
    } 
  }
  
  public final String l111l11111I1l() {
    String str = "";
    try {
      if (this.l1111l111111Il != null) {
        str = (String)l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, l111l1111lI1l.l111l11111Il("989a8bac8a9d8c9c8d969d9a8db69b"));
        if (str == null)
          return ""; 
      } 
      return str;
    } catch (SecurityException|Exception securityException) {
      return "";
    } 
  }
  
  public final String l111l11111Il() {
    String str = "";
    try {
      if (this.l1111l111111Il != null) {
        str = (String)l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, l111l1111lI1l.l111l11111Il("989a8bac9692ac9a8d969e93b18a929d9a8d"));
        if (str == null)
          return ""; 
      } 
      return str;
    } catch (SecurityException|Exception securityException) {
      return "";
    } 
  }
  
  public final String l111l11111lIl() {
    // Byte code:
    //   0: ldc ''
    //   2: astore_1
    //   3: aload_0
    //   4: getfield l1111l111111Il : Ljava/lang/Object;
    //   7: ifnull -> 63
    //   10: aload_0
    //   11: getfield l1111l111111Il : Ljava/lang/Object;
    //   14: ldc '989a8bac9692b08f9a8d9e8b908d'
    //   16: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic l1111l111111Il : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast java/lang/String
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull -> 40
    //   30: aload_2
    //   31: invokevirtual isEmpty : ()Z
    //   34: ifeq -> 70
    //   37: goto -> 40
    //   40: aload_0
    //   41: getfield l1111l111111Il : Ljava/lang/Object;
    //   44: ldc '989a8bb19a8b88908d94b08f9a8d9e8b908db19e929a'
    //   46: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   49: invokestatic l1111l111111Il : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   52: checkcast java/lang/String
    //   55: astore_1
    //   56: aload_1
    //   57: ifnonnull -> 63
    //   60: ldc ''
    //   62: areturn
    //   63: aload_1
    //   64: areturn
    //   65: astore_1
    //   66: ldc ''
    //   68: areturn
    //   69: astore_1
    //   70: aload_2
    //   71: areturn
    // Exception table:
    //   from	to	target	type
    //   3	26	65	java/lang/Exception
    //   30	37	69	java/lang/Exception
    //   40	56	69	java/lang/Exception
  }
  
  public final HashMap<String, String> l111l1111l1Il() {
    String str;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      PackageManager packageManager = this.l111l11111lIl.getPackageManager();
      int i = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", this.l111l11111lIl.getPackageName());
      int j = packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", this.l111l11111lIl.getPackageName());
      if (i != 0 && j != 0)
        return (HashMap)hashMap; 
      String str1 = l111l1111lI1l.l111l11111Il("b1b0afbaadb2");
      try {
        CellLocation cellLocation2 = l11l1111I11l();
        CellLocation cellLocation1 = cellLocation2;
        if (cellLocation2 == null) {
          cellLocation1 = cellLocation2;
          if (this.l1111l111111Il != null)
            cellLocation1 = (CellLocation)l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, l111l1111lI1l.l111l11111Il("989a8bbc9a9393b3909c9e8b969091")); 
        } 
        if (cellLocation1 != null) {
          if (cellLocation1 instanceof GsmCellLocation) {
            hashMap.put("type", l111l1111lI1l.l111l11111Il("988c92"));
            GsmCellLocation gsmCellLocation = (GsmCellLocation)cellLocation1;
            hashMap.put(l111l1111lI1l.l111l11111Il("9c969b"), String.valueOf(gsmCellLocation.getCid()));
            str = l111l1111lI1l.l111l11111Il("939e9c");
            i = gsmCellLocation.getLac();
            hashMap.put(str, String.valueOf(i));
            return (HashMap)hashMap;
          } 
          if (str instanceof CdmaCellLocation) {
            hashMap.put("type", l111l1111lI1l.l111l11111Il("9c9b929e"));
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation)str;
            hashMap.put(l111l1111lI1l.l111l11111Il("9d969b"), String.valueOf(cdmaCellLocation.getBaseStationId()));
            hashMap.put(l111l1111lI1l.l111l11111Il("91969b"), String.valueOf(cdmaCellLocation.getNetworkId()));
            hashMap.put(l111l1111lI1l.l111l11111Il("8c969b"), String.valueOf(cdmaCellLocation.getSystemId()));
            hashMap.put(l111l1111lI1l.l111l11111Il("939e8b"), String.valueOf(cdmaCellLocation.getBaseStationLatitude()));
            str = l111l1111lI1l.l111l11111Il("939198");
            i = cdmaCellLocation.getBaseStationLongitude();
            hashMap.put(str, String.valueOf(i));
            return (HashMap)hashMap;
          } 
        } 
        return (HashMap)hashMap;
      } catch (Exception exception) {
        str = str1;
      } 
    } catch (Exception exception) {
      str = "";
    } 
    hashMap.put("type", str);
    return (HashMap)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l11l1111I1ll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
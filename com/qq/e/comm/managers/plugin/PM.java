package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PM {
  private static final Map<Class<?>, String> h = new HashMap<Class<?>, String>() {
    
    };
  
  private ExecutorService a = Executors.newSingleThreadExecutor();
  
  private final Context b;
  
  private RandomAccessFile c;
  
  private FileLock d;
  
  private boolean e;
  
  private a$a f;
  
  private a$b g = new a$b(this) {
    
    };
  
  public PM(Context paramContext, a$a parama$a) {
    this.b = paramContext.getApplicationContext();
    this.f = parama$a;
    this.e = a();
  }
  
  private boolean a() {
    try {
      File file = b.a(this.b);
      if (!file.exists()) {
        file.createNewFile();
        StringUtil.writeTo("lock", file);
      } 
      if (file.exists()) {
        this.c = new RandomAccessFile(file, "rw");
        this.d = this.c.getChannel().tryLock();
        if (this.d != null) {
          this.c.writeByte(37);
          return true;
        } 
      } 
    } finally {
      Exception exception;
    } 
    return false;
  }
  
  public <T> T getFactory(Class<T> paramClass) throws a {
    boolean bool;
    StringBuilder stringBuilder2 = new StringBuilder("GetFactoryInstaceforInterface:");
    stringBuilder2.append(paramClass);
    GDTLogger.d(stringBuilder2.toString());
    ClassLoader classLoader = getClass().getClassLoader();
    StringBuilder stringBuilder3 = new StringBuilder("PluginClassLoader is parent");
    if (getClass().getClassLoader() == classLoader) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder3.append(bool);
    GDTLogger.d(stringBuilder3.toString());
    if (classLoader != null)
      try {
        String str = h.get(paramClass);
        if (!StringUtil.isEmpty(str)) {
          Class<?> clazz = classLoader.loadClass(str);
          clazz = (Class<?>)paramClass.cast(clazz.getDeclaredMethod("getInstance", new Class[0]).invoke(clazz, new Object[0]));
          return (T)clazz;
        } 
        StringBuilder stringBuilder = new StringBuilder("factory  implemention name is not specified for interface:");
        stringBuilder.append(paramClass.getName());
        throw new a(stringBuilder.toString());
      } finally {
        classLoader = null;
        stringBuilder3 = new StringBuilder("Fail to getfactory implement instance for interface:");
        stringBuilder3.append(paramClass.getName());
      }  
    StringBuilder stringBuilder1 = new StringBuilder("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:");
    stringBuilder1.append(paramClass);
    throw new a(stringBuilder1.toString());
  }
  
  public String getLocalSig() {
    return null;
  }
  
  public POFactory getPOFactory() throws a {
    return getFactory(POFactory.class);
  }
  
  public int getPluginVersion() {
    return 1164;
  }
  
  public void update(String paramString1, String paramString2) {}
  
  public static interface a {
    public static interface a$a {}
    
    public static interface a$b {}
  }
  
  public static interface a$a {}
  
  public static interface a$a {}
  
  public static interface a$b {}
  
  public static interface a$b {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\plugin\PM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
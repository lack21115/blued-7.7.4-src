package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.content.res.Resources;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OpenHelperManager {
  private static final String HELPER_CLASS_RESOURCE_NAME = "open_helper_classname";
  
  private static volatile OrmLiteSqliteOpenHelper helper;
  
  private static Class<? extends OrmLiteSqliteOpenHelper> helperClass;
  
  private static int instanceCount;
  
  private static Logger logger = LoggerFactory.getLogger(OpenHelperManager.class);
  
  private static boolean wasClosed;
  
  static {
    helperClass = null;
    helper = null;
    wasClosed = false;
    instanceCount = 0;
  }
  
  private static OrmLiteSqliteOpenHelper constructHelper(Context paramContext, Class<? extends OrmLiteSqliteOpenHelper> paramClass) {
    try {
      Constructor<? extends OrmLiteSqliteOpenHelper> constructor = paramClass.getConstructor(new Class[] { Context.class });
      try {
        return constructor.newInstance(new Object[] { paramContext });
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not construct instance of helper class ");
        stringBuilder.append(paramClass);
        throw new IllegalStateException(stringBuilder.toString(), exception);
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not find public constructor that has a single (Context) argument for helper class ");
      stringBuilder.append(paramClass);
      throw new IllegalStateException(stringBuilder.toString(), exception);
    } 
  }
  
  @Deprecated
  public static OrmLiteSqliteOpenHelper getHelper(Context paramContext) {
    // Byte code:
    //   0: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   2: monitorenter
    //   3: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.helperClass : Ljava/lang/Class;
    //   6: ifnonnull -> 40
    //   9: aload_0
    //   10: ifnull -> 30
    //   13: aload_0
    //   14: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   17: aload_0
    //   18: invokevirtual getClass : ()Ljava/lang/Class;
    //   21: invokestatic lookupHelperClass : (Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Class;
    //   24: invokestatic innerSetHelperClass : (Ljava/lang/Class;)V
    //   27: goto -> 40
    //   30: new java/lang/IllegalArgumentException
    //   33: dup
    //   34: ldc 'context argument is null'
    //   36: invokespecial <init> : (Ljava/lang/String;)V
    //   39: athrow
    //   40: aload_0
    //   41: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.helperClass : Ljava/lang/Class;
    //   44: invokestatic loadHelper : (Landroid/content/Context;Ljava/lang/Class;)Lcom/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper;
    //   47: astore_0
    //   48: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   50: monitorexit
    //   51: aload_0
    //   52: areturn
    //   53: astore_0
    //   54: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	53	finally
    //   13	27	53	finally
    //   30	40	53	finally
    //   40	48	53	finally
  }
  
  public static <T extends OrmLiteSqliteOpenHelper> T getHelper(Context paramContext, Class<T> paramClass) {
    // Byte code:
    //   0: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull -> 26
    //   7: aload_1
    //   8: invokestatic innerSetHelperClass : (Ljava/lang/Class;)V
    //   11: aload_0
    //   12: aload_1
    //   13: invokestatic loadHelper : (Landroid/content/Context;Ljava/lang/Class;)Lcom/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper;
    //   16: astore_0
    //   17: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: astore_0
    //   23: goto -> 36
    //   26: new java/lang/IllegalArgumentException
    //   29: dup
    //   30: ldc 'openHelperClass argument is null'
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: athrow
    //   36: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   7	17	22	finally
    //   26	36	22	finally
  }
  
  private static void innerSetHelperClass(Class<? extends OrmLiteSqliteOpenHelper> paramClass) {
    if (paramClass != null) {
      Class<? extends OrmLiteSqliteOpenHelper> clazz = helperClass;
      if (clazz == null) {
        helperClass = paramClass;
        return;
      } 
      if (clazz == paramClass)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Helper class was ");
      stringBuilder.append(helperClass);
      stringBuilder.append(" but is trying to be reset to ");
      stringBuilder.append(paramClass);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    throw new IllegalStateException("Helper class was trying to be reset to null");
  }
  
  private static <T extends OrmLiteSqliteOpenHelper> T loadHelper(Context paramContext, Class<T> paramClass) {
    if (helper == null) {
      if (wasClosed)
        logger.info("helper was already closed and is being re-opened"); 
      if (paramContext != null) {
        helper = constructHelper(paramContext.getApplicationContext(), paramClass);
        logger.trace("zero instances, created helper {}", helper);
        BaseDaoImpl.clearAllInternalObjectCaches();
        DaoManager.clearDaoCache();
        instanceCount = 0;
      } else {
        throw new IllegalArgumentException("context argument is null");
      } 
    } 
    instanceCount++;
    logger.trace("returning helper {}, instance count = {} ", helper, Integer.valueOf(instanceCount));
    return (T)helper;
  }
  
  private static Class<? extends OrmLiteSqliteOpenHelper> lookupHelperClass(Context paramContext, Class<?> paramClass) {
    Resources resources = paramContext.getResources();
    int i = resources.getIdentifier("open_helper_classname", "string", paramContext.getPackageName());
    if (i != 0) {
      String str = resources.getString(i);
      try {
        return (Class)Class.forName(str);
      } catch (Exception exception2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Could not create helper instance for class ");
        stringBuilder1.append(str);
        throw new IllegalStateException(stringBuilder1.toString(), exception2);
      } 
    } 
    Exception exception1 = exception2;
    while (exception1 != null) {
      Type type = exception1.getGenericSuperclass();
      if (type != null && type instanceof ParameterizedType) {
        Type[] arrayOfType = ((ParameterizedType)type).getActualTypeArguments();
        if (arrayOfType != null && arrayOfType.length != 0) {
          int j = arrayOfType.length;
          for (i = 0; i < j; i++) {
            Type type1 = arrayOfType[i];
            if (type1 instanceof Class) {
              type1 = type1;
              if (OrmLiteSqliteOpenHelper.class.isAssignableFrom((Class<?>)type1))
                return (Class<? extends OrmLiteSqliteOpenHelper>)type1; 
            } 
          } 
        } 
      } 
      Class clazz = exception1.getSuperclass();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not find OpenHelperClass because none of the generic parameters of class ");
    stringBuilder.append(exception2);
    stringBuilder.append(" extends OrmLiteSqliteOpenHelper.  You should use getHelper(Context, Class) instead.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  @Deprecated
  public static void release() {
    releaseHelper();
  }
  
  public static void releaseHelper() {
    // Byte code:
    //   0: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   2: monitorenter
    //   3: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.instanceCount : I
    //   6: iconst_1
    //   7: isub
    //   8: putstatic com/j256/ormlite/android/apptools/OpenHelperManager.instanceCount : I
    //   11: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   14: ldc 'releasing helper {}, instance count = {}'
    //   16: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.helper : Lcom/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper;
    //   19: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.instanceCount : I
    //   22: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   25: invokevirtual trace : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   28: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.instanceCount : I
    //   31: ifgt -> 85
    //   34: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.helper : Lcom/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper;
    //   37: ifnull -> 65
    //   40: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   43: ldc 'zero instances, closing helper {}'
    //   45: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.helper : Lcom/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper;
    //   48: invokevirtual trace : (Ljava/lang/String;Ljava/lang/Object;)V
    //   51: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.helper : Lcom/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper;
    //   54: invokevirtual close : ()V
    //   57: aconst_null
    //   58: putstatic com/j256/ormlite/android/apptools/OpenHelperManager.helper : Lcom/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper;
    //   61: iconst_1
    //   62: putstatic com/j256/ormlite/android/apptools/OpenHelperManager.wasClosed : Z
    //   65: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.instanceCount : I
    //   68: ifge -> 85
    //   71: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   74: ldc 'too many calls to release helper, instance count = {}'
    //   76: getstatic com/j256/ormlite/android/apptools/OpenHelperManager.instanceCount : I
    //   79: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   82: invokevirtual error : (Ljava/lang/String;Ljava/lang/Object;)V
    //   85: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   87: monitorexit
    //   88: return
    //   89: astore_0
    //   90: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   3	65	89	finally
    //   65	85	89	finally
  }
  
  public static void setHelper(OrmLiteSqliteOpenHelper paramOrmLiteSqliteOpenHelper) {
    // Byte code:
    //   0: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   2: monitorenter
    //   3: aload_0
    //   4: putstatic com/j256/ormlite/android/apptools/OpenHelperManager.helper : Lcom/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper;
    //   7: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static void setOpenHelperClass(Class<? extends OrmLiteSqliteOpenHelper> paramClass) {
    // Byte code:
    //   0: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull -> 14
    //   7: aconst_null
    //   8: putstatic com/j256/ormlite/android/apptools/OpenHelperManager.helperClass : Ljava/lang/Class;
    //   11: goto -> 18
    //   14: aload_0
    //   15: invokestatic innerSetHelperClass : (Ljava/lang/Class;)V
    //   18: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   20: monitorexit
    //   21: return
    //   22: astore_0
    //   23: ldc com/j256/ormlite/android/apptools/OpenHelperManager
    //   25: monitorexit
    //   26: aload_0
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   7	11	22	finally
    //   14	18	22	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\apptools\OpenHelperManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
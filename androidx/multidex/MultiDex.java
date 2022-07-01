package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.zip.ZipFile;

public final class MultiDex {
  private static final Set<File> a = new HashSet<File>();
  
  private static final boolean b = a(System.getProperty("java.vm.version"));
  
  private static File a(Context paramContext, File paramFile, String paramString) throws IOException {
    paramFile = new File(paramFile, "code_cache");
    try {
      a(paramFile);
      file = paramFile;
    } catch (IOException iOException) {
      file = new File(file.getFilesDir(), "code_cache");
      a(file);
    } 
    File file = new File(file, paramString);
    a(file);
    return file;
  }
  
  private static ClassLoader a(Context paramContext) {
    try {
      ClassLoader classLoader = paramContext.getClassLoader();
      if (Build.VERSION.SDK_INT >= 14) {
        if (classLoader instanceof dalvik.system.BaseDexClassLoader)
          return classLoader; 
      } else {
        if (!(classLoader instanceof dalvik.system.DexClassLoader)) {
          if (classLoader instanceof dalvik.system.PathClassLoader)
            return classLoader; 
          Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
          return null;
        } 
        return classLoader;
      } 
      Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
      return null;
    } catch (RuntimeException runtimeException) {
      Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", runtimeException);
      return null;
    } 
  }
  
  private static void a(Context paramContext, File paramFile1, File paramFile2, String paramString1, String paramString2, boolean paramBoolean) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
    synchronized (a) {
      if (a.contains(paramFile1))
        return; 
      a.add(paramFile1);
      if (Build.VERSION.SDK_INT > 20) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiDex is not guaranteed to work in SDK version ");
        stringBuilder.append(Build.VERSION.SDK_INT);
        stringBuilder.append(": SDK version higher than ");
        stringBuilder.append(20);
        stringBuilder.append(" should be backed by ");
        stringBuilder.append("runtime with built-in multidex capabilty but it's not the ");
        stringBuilder.append("case here: java.vm.version=\"");
        stringBuilder.append(System.getProperty("java.vm.version"));
        stringBuilder.append("\"");
        Log.w("MultiDex", stringBuilder.toString());
      } 
      ClassLoader classLoader = a(paramContext);
      if (classLoader == null)
        return; 
      try {
        c(paramContext);
      } finally {
        Exception exception = null;
      } 
      MultiDexExtractor multiDexExtractor = new MultiDexExtractor(paramFile1, paramFile2);
      paramFile1 = null;
      try {
        List<? extends File> list = multiDexExtractor.a(paramContext, paramString2, false);
        try {
          a(classLoader, paramFile2, list);
        } catch (IOException iOException1) {
          if (paramBoolean) {
            Log.w("MultiDex", "Failed to install extracted secondary dex files, retrying with forced extraction", iOException1);
            a(classLoader, paramFile2, multiDexExtractor.a(paramContext, paramString2, true));
          } else {
            throw iOException1;
          } 
        } 
        try {
          multiDexExtractor.close();
          File file = paramFile1;
        } catch (IOException iOException) {}
        if (iOException == null)
          return; 
        throw iOException;
      } finally {
        try {
          multiDexExtractor.close();
        } catch (IOException iOException) {}
      } 
    } 
  }
  
  private static void a(File paramFile) throws IOException {
    paramFile.mkdir();
    if (!paramFile.isDirectory()) {
      File file = paramFile.getParentFile();
      if (file == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to create dir ");
        stringBuilder.append(paramFile.getPath());
        stringBuilder.append(". Parent file is null.");
        Log.e("MultiDex", stringBuilder.toString());
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Failed to create dir ");
        stringBuilder1.append(paramFile.getPath());
        stringBuilder1.append(". parent file is a dir ");
        stringBuilder1.append(stringBuilder.isDirectory());
        stringBuilder1.append(", a file ");
        stringBuilder1.append(stringBuilder.isFile());
        stringBuilder1.append(", exists ");
        stringBuilder1.append(stringBuilder.exists());
        stringBuilder1.append(", readable ");
        stringBuilder1.append(stringBuilder.canRead());
        stringBuilder1.append(", writable ");
        stringBuilder1.append(stringBuilder.canWrite());
        Log.e("MultiDex", stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to create directory ");
      stringBuilder.append(paramFile.getPath());
      throw new IOException(stringBuilder.toString());
    } 
  }
  
  private static void a(ClassLoader paramClassLoader, File paramFile, List<? extends File> paramList) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
    if (!paramList.isEmpty()) {
      if (Build.VERSION.SDK_INT >= 19) {
        V19.a(paramClassLoader, paramList, paramFile);
        return;
      } 
      if (Build.VERSION.SDK_INT >= 14) {
        V14.a(paramClassLoader, paramList);
        return;
      } 
      V4.a(paramClassLoader, paramList);
    } 
  }
  
  static boolean a(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iload #4
    //   5: istore_3
    //   6: aload_0
    //   7: ifnull -> 118
    //   10: new java/util/StringTokenizer
    //   13: dup
    //   14: aload_0
    //   15: ldc_w '.'
    //   18: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore #7
    //   23: aload #7
    //   25: invokevirtual hasMoreTokens : ()Z
    //   28: istore_3
    //   29: aconst_null
    //   30: astore #6
    //   32: iload_3
    //   33: ifeq -> 46
    //   36: aload #7
    //   38: invokevirtual nextToken : ()Ljava/lang/String;
    //   41: astore #5
    //   43: goto -> 49
    //   46: aconst_null
    //   47: astore #5
    //   49: aload #7
    //   51: invokevirtual hasMoreTokens : ()Z
    //   54: ifeq -> 64
    //   57: aload #7
    //   59: invokevirtual nextToken : ()Ljava/lang/String;
    //   62: astore #6
    //   64: iload #4
    //   66: istore_3
    //   67: aload #5
    //   69: ifnull -> 118
    //   72: iload #4
    //   74: istore_3
    //   75: aload #6
    //   77: ifnull -> 118
    //   80: aload #5
    //   82: invokestatic parseInt : (Ljava/lang/String;)I
    //   85: istore_1
    //   86: aload #6
    //   88: invokestatic parseInt : (Ljava/lang/String;)I
    //   91: istore_2
    //   92: iload_1
    //   93: iconst_2
    //   94: if_icmpgt -> 113
    //   97: iload #4
    //   99: istore_3
    //   100: iload_1
    //   101: iconst_2
    //   102: if_icmpne -> 118
    //   105: iload #4
    //   107: istore_3
    //   108: iload_2
    //   109: iconst_1
    //   110: if_icmplt -> 118
    //   113: iconst_1
    //   114: istore_3
    //   115: goto -> 118
    //   118: new java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore #5
    //   127: aload #5
    //   129: ldc_w 'VM with version '
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload #5
    //   138: aload_0
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: iload_3
    //   144: ifeq -> 154
    //   147: ldc_w ' has multidex support'
    //   150: astore_0
    //   151: goto -> 158
    //   154: ldc_w ' does not have multidex support'
    //   157: astore_0
    //   158: aload #5
    //   160: aload_0
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: ldc 'MultiDex'
    //   167: aload #5
    //   169: invokevirtual toString : ()Ljava/lang/String;
    //   172: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   175: pop
    //   176: iload_3
    //   177: ireturn
    //   178: astore #5
    //   180: iload #4
    //   182: istore_3
    //   183: goto -> 118
    // Exception table:
    //   from	to	target	type
    //   80	92	178	java/lang/NumberFormatException
  }
  
  private static ApplicationInfo b(Context paramContext) {
    try {
      return paramContext.getApplicationInfo();
    } catch (RuntimeException runtimeException) {
      Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", runtimeException);
      return null;
    } 
  }
  
  private static Field b(Object paramObject, String paramString) throws NoSuchFieldException {
    Class<?> clazz = paramObject.getClass();
    while (true) {
      if (clazz != null)
        try {
          Field field = clazz.getDeclaredField(paramString);
          if (!field.isAccessible())
            field.setAccessible(true); 
          return field;
        } catch (NoSuchFieldException noSuchFieldException) {
          clazz = clazz.getSuperclass();
          continue;
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Field ");
      stringBuilder.append(paramString);
      stringBuilder.append(" not found in ");
      stringBuilder.append(paramObject.getClass());
      throw new NoSuchFieldException(stringBuilder.toString());
    } 
  }
  
  private static Method b(Object paramObject, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
    Class<?> clazz = paramObject.getClass();
    while (true) {
      if (clazz != null)
        try {
          Method method = clazz.getDeclaredMethod(paramString, paramVarArgs);
          if (!method.isAccessible())
            method.setAccessible(true); 
          return method;
        } catch (NoSuchMethodException noSuchMethodException) {
          clazz = clazz.getSuperclass();
          continue;
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Method ");
      stringBuilder.append(paramString);
      stringBuilder.append(" with parameters ");
      stringBuilder.append(Arrays.asList(paramVarArgs));
      stringBuilder.append(" not found in ");
      stringBuilder.append(paramObject.getClass());
      throw new NoSuchMethodException(stringBuilder.toString());
    } 
  }
  
  private static void b(Object paramObject, String paramString, Object[] paramArrayOfObject) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    Field field = b(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])field.get(paramObject);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), arrayOfObject1.length + paramArrayOfObject.length);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, arrayOfObject1.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, arrayOfObject1.length, paramArrayOfObject.length);
    field.set(paramObject, arrayOfObject2);
  }
  
  private static void c(Context paramContext) throws Exception {
    File file = new File(paramContext.getFilesDir(), "secondary-dexes");
    if (file.isDirectory()) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Clearing old secondary dex dir (");
      stringBuilder2.append(file.getPath());
      stringBuilder2.append(").");
      Log.i("MultiDex", stringBuilder2.toString());
      File[] arrayOfFile = file.listFiles();
      if (arrayOfFile == null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Failed to list secondary dex dir content (");
        stringBuilder1.append(file.getPath());
        stringBuilder1.append(").");
        Log.w("MultiDex", stringBuilder1.toString());
        return;
      } 
      int j = stringBuilder1.length;
      for (int i = 0; i < j; i++) {
        StringBuilder stringBuilder3 = stringBuilder1[i];
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("Trying to delete old file ");
        stringBuilder4.append(stringBuilder3.getPath());
        stringBuilder4.append(" of size ");
        stringBuilder4.append(stringBuilder3.length());
        Log.i("MultiDex", stringBuilder4.toString());
        if (!stringBuilder3.delete()) {
          stringBuilder4 = new StringBuilder();
          stringBuilder4.append("Failed to delete old file ");
          stringBuilder4.append(stringBuilder3.getPath());
          Log.w("MultiDex", stringBuilder4.toString());
        } else {
          stringBuilder4 = new StringBuilder();
          stringBuilder4.append("Deleted old file ");
          stringBuilder4.append(stringBuilder3.getPath());
          Log.i("MultiDex", stringBuilder4.toString());
        } 
      } 
      if (!file.delete()) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Failed to delete secondary dex dir ");
        stringBuilder1.append(file.getPath());
        Log.w("MultiDex", stringBuilder1.toString());
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Deleted old secondary dex dir ");
      stringBuilder1.append(file.getPath());
      Log.i("MultiDex", stringBuilder1.toString());
    } 
  }
  
  public static void install(Context paramContext) {
    Log.i("MultiDex", "Installing application");
    if (b) {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    } 
    if (Build.VERSION.SDK_INT >= 4)
      try {
        ApplicationInfo applicationInfo = b(paramContext);
        if (applicationInfo == null) {
          Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
          return;
        } 
        a(paramContext, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
        Log.i("MultiDex", "install done");
        return;
      } catch (Exception exception) {
        Log.e("MultiDex", "MultiDex installation failure", exception);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("MultiDex installation failed (");
        stringBuilder1.append(exception.getMessage());
        stringBuilder1.append(").");
        throw new RuntimeException(stringBuilder1.toString());
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MultiDex installation failed. SDK ");
    stringBuilder.append(Build.VERSION.SDK_INT);
    stringBuilder.append(" is unsupported. Min SDK version is ");
    stringBuilder.append(4);
    stringBuilder.append(".");
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public static void installInstrumentation(Context paramContext1, Context paramContext2) {
    Log.i("MultiDex", "Installing instrumentation");
    if (b) {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    } 
    if (Build.VERSION.SDK_INT >= 4)
      try {
        ApplicationInfo applicationInfo2 = b(paramContext1);
        if (applicationInfo2 == null) {
          Log.i("MultiDex", "No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
          return;
        } 
        ApplicationInfo applicationInfo1 = b(paramContext2);
        if (applicationInfo1 == null) {
          Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
          return;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramContext1.getPackageName());
        stringBuilder1.append(".");
        String str = stringBuilder1.toString();
        File file2 = new File(applicationInfo1.dataDir);
        File file1 = new File(applicationInfo2.sourceDir);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("secondary-dexes");
        a(paramContext2, file1, file2, stringBuilder2.toString(), str, false);
        a(paramContext2, new File(applicationInfo1.sourceDir), file2, "secondary-dexes", "", false);
        Log.i("MultiDex", "Installation done");
        return;
      } catch (Exception exception) {
        Log.e("MultiDex", "MultiDex installation failure", exception);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("MultiDex installation failed (");
        stringBuilder1.append(exception.getMessage());
        stringBuilder1.append(").");
        throw new RuntimeException(stringBuilder1.toString());
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MultiDex installation failed. SDK ");
    stringBuilder.append(Build.VERSION.SDK_INT);
    stringBuilder.append(" is unsupported. Min SDK version is ");
    stringBuilder.append(4);
    stringBuilder.append(".");
    throw new RuntimeException(stringBuilder.toString());
  }
  
  static final class V14 {
    private static final int a = 4;
    
    private final ElementConstructor b;
    
    private V14() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
      JBMR2ElementConstructor jBMR2ElementConstructor;
      Class<?> clazz = Class.forName("dalvik.system.DexPathList$Element");
      try {
        ICSElementConstructor iCSElementConstructor = new ICSElementConstructor(clazz);
      } catch (NoSuchMethodException noSuchMethodException) {
        try {
          JBMR11ElementConstructor jBMR11ElementConstructor = new JBMR11ElementConstructor(clazz);
        } catch (NoSuchMethodException noSuchMethodException1) {
          jBMR2ElementConstructor = new JBMR2ElementConstructor(clazz);
        } 
      } 
      this.b = jBMR2ElementConstructor;
    }
    
    private static String a(File param1File) {
      File file = param1File.getParentFile();
      String str = param1File.getName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str.substring(0, str.length() - a));
      stringBuilder.append(".dex");
      return (new File(file, stringBuilder.toString())).getPath();
    }
    
    static void a(ClassLoader param1ClassLoader, List<? extends File> param1List) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
      Object object = MultiDex.a(param1ClassLoader, "pathList").get(param1ClassLoader);
      Object[] arrayOfObject = (new V14()).a(param1List);
      try {
        MultiDex.a(object, "dexElements", arrayOfObject);
        return;
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", noSuchFieldException);
        MultiDex.a(object, "pathElements", arrayOfObject);
        return;
      } 
    }
    
    private Object[] a(List<? extends File> param1List) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
      Object[] arrayOfObject = new Object[param1List.size()];
      for (int i = 0; i < arrayOfObject.length; i++) {
        File file = param1List.get(i);
        arrayOfObject[i] = this.b.newInstance(file, DexFile.loadDex(file.getPath(), a(file), 0));
      } 
      return arrayOfObject;
    }
    
    static interface ElementConstructor {
      Object newInstance(File param2File, DexFile param2DexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
    }
    
    static class ICSElementConstructor implements ElementConstructor {
      private final Constructor<?> a;
      
      ICSElementConstructor(Class<?> param2Class) throws SecurityException, NoSuchMethodException {
        this.a = param2Class.getConstructor(new Class[] { File.class, ZipFile.class, DexFile.class });
        this.a.setAccessible(true);
      }
      
      public Object newInstance(File param2File, DexFile param2DexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
        return this.a.newInstance(new Object[] { param2File, new ZipFile(param2File), param2DexFile });
      }
    }
    
    static class JBMR11ElementConstructor implements ElementConstructor {
      private final Constructor<?> a;
      
      JBMR11ElementConstructor(Class<?> param2Class) throws SecurityException, NoSuchMethodException {
        this.a = param2Class.getConstructor(new Class[] { File.class, File.class, DexFile.class });
        this.a.setAccessible(true);
      }
      
      public Object newInstance(File param2File, DexFile param2DexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return this.a.newInstance(new Object[] { param2File, param2File, param2DexFile });
      }
    }
    
    static class JBMR2ElementConstructor implements ElementConstructor {
      private final Constructor<?> a;
      
      JBMR2ElementConstructor(Class<?> param2Class) throws SecurityException, NoSuchMethodException {
        this.a = param2Class.getConstructor(new Class[] { File.class, boolean.class, File.class, DexFile.class });
        this.a.setAccessible(true);
      }
      
      public Object newInstance(File param2File, DexFile param2DexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return this.a.newInstance(new Object[] { param2File, Boolean.FALSE, param2File, param2DexFile });
      }
    }
  }
  
  static interface ElementConstructor {
    Object newInstance(File param1File, DexFile param1DexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
  }
  
  static class ICSElementConstructor implements V14.ElementConstructor {
    private final Constructor<?> a;
    
    ICSElementConstructor(Class<?> param1Class) throws SecurityException, NoSuchMethodException {
      this.a = param1Class.getConstructor(new Class[] { File.class, ZipFile.class, DexFile.class });
      this.a.setAccessible(true);
    }
    
    public Object newInstance(File param1File, DexFile param1DexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
      return this.a.newInstance(new Object[] { param1File, new ZipFile(param1File), param1DexFile });
    }
  }
  
  static class JBMR11ElementConstructor implements V14.ElementConstructor {
    private final Constructor<?> a;
    
    JBMR11ElementConstructor(Class<?> param1Class) throws SecurityException, NoSuchMethodException {
      this.a = param1Class.getConstructor(new Class[] { File.class, File.class, DexFile.class });
      this.a.setAccessible(true);
    }
    
    public Object newInstance(File param1File, DexFile param1DexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
      return this.a.newInstance(new Object[] { param1File, param1File, param1DexFile });
    }
  }
  
  static class JBMR2ElementConstructor implements V14.ElementConstructor {
    private final Constructor<?> a;
    
    JBMR2ElementConstructor(Class<?> param1Class) throws SecurityException, NoSuchMethodException {
      this.a = param1Class.getConstructor(new Class[] { File.class, boolean.class, File.class, DexFile.class });
      this.a.setAccessible(true);
    }
    
    public Object newInstance(File param1File, DexFile param1DexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
      return this.a.newInstance(new Object[] { param1File, Boolean.FALSE, param1File, param1DexFile });
    }
  }
  
  static final class V19 {
    static void a(ClassLoader param1ClassLoader, List<? extends File> param1List, File param1File) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
      Object object = MultiDex.a(param1ClassLoader, "pathList").get(param1ClassLoader);
      ArrayList<IOException> arrayList = new ArrayList();
      MultiDex.a(object, "dexElements", a(object, new ArrayList<File>(param1List), param1File, arrayList));
      if (arrayList.size() > 0) {
        IOException[] arrayOfIOException1;
        Iterator<IOException> iterator = arrayList.iterator();
        while (iterator.hasNext())
          Log.w("MultiDex", "Exception in makeDexElement", iterator.next()); 
        Field field = MultiDex.a(object, "dexElementsSuppressedExceptions");
        IOException[] arrayOfIOException2 = (IOException[])field.get(object);
        if (arrayOfIOException2 == null) {
          arrayOfIOException1 = arrayList.<IOException>toArray(new IOException[arrayList.size()]);
        } else {
          arrayOfIOException1 = new IOException[arrayList.size() + arrayOfIOException2.length];
          arrayList.toArray(arrayOfIOException1);
          System.arraycopy(arrayOfIOException2, 0, arrayOfIOException1, arrayList.size(), arrayOfIOException2.length);
        } 
        field.set(object, arrayOfIOException1);
        IOException iOException = new IOException("I/O exception during makeDexElement");
        iOException.initCause(arrayList.get(0));
        throw iOException;
      } 
    }
    
    private static Object[] a(Object param1Object, ArrayList<File> param1ArrayList, File param1File, ArrayList<IOException> param1ArrayList1) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
      return (Object[])MultiDex.a(param1Object, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(param1Object, new Object[] { param1ArrayList, param1File, param1ArrayList1 });
    }
  }
  
  static final class V4 {
    static void a(ClassLoader param1ClassLoader, List<? extends File> param1List) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
      int i = param1List.size();
      Field field = MultiDex.a(param1ClassLoader, "path");
      StringBuilder stringBuilder = new StringBuilder((String)field.get(param1ClassLoader));
      String[] arrayOfString = new String[i];
      File[] arrayOfFile = new File[i];
      ZipFile[] arrayOfZipFile = new ZipFile[i];
      DexFile[] arrayOfDexFile = new DexFile[i];
      ListIterator<? extends File> listIterator = param1List.listIterator();
      while (listIterator.hasNext()) {
        File file = listIterator.next();
        String str = file.getAbsolutePath();
        stringBuilder.append(':');
        stringBuilder.append(str);
        i = listIterator.previousIndex();
        arrayOfString[i] = str;
        arrayOfFile[i] = file;
        arrayOfZipFile[i] = new ZipFile(file);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append(".dex");
        arrayOfDexFile[i] = DexFile.loadDex(str, stringBuilder1.toString(), 0);
      } 
      field.set(param1ClassLoader, stringBuilder.toString());
      MultiDex.a(param1ClassLoader, "mPaths", (Object[])arrayOfString);
      MultiDex.a(param1ClassLoader, "mFiles", (Object[])arrayOfFile);
      MultiDex.a(param1ClassLoader, "mZips", (Object[])arrayOfZipFile);
      MultiDex.a(param1ClassLoader, "mDexs", (Object[])arrayOfDexFile);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\multidex\MultiDex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
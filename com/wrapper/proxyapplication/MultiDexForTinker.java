package com.wrapper.proxyapplication;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MultiDexForTinker {
  static final String TAG = "MultiDexForTinker";
  
  static IOException[] dexElementsSuppressedExceptions;
  
  static int hasInjected;
  
  static int injectDexBeginIndex;
  
  static Object[] injectDexsObj;
  
  static Object[] injectFilesObj;
  
  static Object[] injectPathListObj;
  
  static Object[] injectPathsObj;
  
  static Object[] injectZipsObj;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MultiDexForTinker() {
    throw new VerifyError("bad dex opcode");
  }
  
  private static void expandFieldArray(Object paramObject, String paramString, Object[] paramArrayOfObject) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    findField(paramObject, paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  private static void expandFieldArray(Object paramObject, String paramString, Object[] paramArrayOfObject, int paramInt) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    findField(paramObject, paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  private static Field findField(Object paramObject, String paramString) throws NoSuchFieldException {
    throw new VerifyError("bad dex opcode");
  }
  
  private static Method findMethod(Object paramObject, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
    throw new VerifyError("bad dex opcode");
  }
  
  private static Method findMethodinClazz(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
    if (paramClass != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new VerifyError("bad dex opcode");
      }  
    new StringBuilder();
    throw new VerifyError("bad dex opcode");
  }
  
  private static void finishinstallDexes(ClassLoader paramClassLoader) {
    try {
      findField(paramClassLoader, "pathList");
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalAccessException illegalAccessException) {
        throw new VerifyError("bad dex opcode");
      } 
    } catch (NoSuchFieldException noSuchFieldException) {
      try {
        findField(paramClassLoader, "path");
        try {
          throw new VerifyError("bad dex opcode");
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new VerifyError("bad dex opcode");
        } catch (IllegalAccessException illegalAccessException) {
          throw new VerifyError("bad dex opcode");
        } 
      } catch (NoSuchFieldException noSuchFieldException1) {
        throw new VerifyError("bad dex opcode");
      } 
    } 
  }
  
  private static String getprefixname(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  private static ArrayList<Object> installDexes(ClassLoader paramClassLoader, String paramString1, String paramString2) throws IOException {
    ArrayList<File> arrayList = splitPaths(paramString1);
    File file = new File(paramString2);
    try {
      Field field = findField(paramClassLoader, "pathList");
      try {
        return V19.install(paramClassLoader, field, arrayList, file);
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalAccessException illegalAccessException) {
        throw new VerifyError("bad dex opcode");
      } catch (InvocationTargetException invocationTargetException) {
        throw new VerifyError("bad dex opcode");
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new VerifyError("bad dex opcode");
      } catch (IOException iOException) {}
      throw new IOException("v19,load dex fail");
    } catch (NoSuchFieldException noSuchFieldException) {
      try {
        Field field = findField(paramClassLoader, "path");
        try {
          return V4.install(paramClassLoader, field, arrayList, file);
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new VerifyError("bad dex opcode");
        } catch (IllegalAccessException illegalAccessException) {
          throw new VerifyError("bad dex opcode");
        } catch (IOException iOException) {}
        throw new IOException("v4, load dex fail");
      } catch (NoSuchFieldException noSuchFieldException1) {
        Log.w("MultiDexForTinker", "Strange!no pathlist&path,a new or modified android version ");
        return null;
      } 
    } 
  }
  
  private static ArrayList<Object> installDexes(ClassLoader paramClassLoader, String paramString1, String paramString2, int paramInt) throws IOException {
    ArrayList<File> arrayList = splitPaths(paramString1);
    File file = new File(paramString2);
    try {
      Field field = findField(paramClassLoader, "pathList");
      try {
        return V19.install(paramClassLoader, field, arrayList, file, paramInt);
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalAccessException illegalAccessException) {
        throw new VerifyError("bad dex opcode");
      } catch (InvocationTargetException invocationTargetException) {
        throw new VerifyError("bad dex opcode");
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new VerifyError("bad dex opcode");
      } catch (IOException iOException) {}
      throw new IOException("v19,load dex fail");
    } catch (NoSuchFieldException noSuchFieldException) {
      try {
        Field field = findField(paramClassLoader, "path");
        try {
          return V4.install(paramClassLoader, field, arrayList, file, paramInt);
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new VerifyError("bad dex opcode");
        } catch (IllegalAccessException illegalAccessException) {
          throw new VerifyError("bad dex opcode");
        } catch (IOException iOException) {}
        throw new IOException("v4, load dex fail");
      } catch (NoSuchFieldException noSuchFieldException1) {
        Log.w("MultiDexForTinker", "Strange!no pathlist&path,a new or modified android version ");
        return null;
      } 
    } 
  }
  
  private static ArrayList<Object> openallDexes(ClassLoader paramClassLoader, String paramString1, String paramString2) {
    splitPaths(paramString1);
    new File(paramString2);
    try {
      findField(paramClassLoader, "pathList");
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalAccessException illegalAccessException) {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalArgumentException illegalArgumentException) {}
      throw new VerifyError("bad dex opcode");
    } catch (NoSuchFieldException noSuchFieldException) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private static void prepareexpandFieldArray(Object paramObject, String paramString, int paramInt) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    findField(paramObject, paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  private static void preparetoinstallDexes(ClassLoader paramClassLoader, int paramInt) throws IOException {
    try {
      findField(paramClassLoader, "pathList");
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalAccessException illegalAccessException) {
        throw new VerifyError("bad dex opcode");
      } 
    } catch (NoSuchFieldException noSuchFieldException) {
      try {
        findField(paramClassLoader, "path");
        try {
          prepareexpandFieldArray(paramClassLoader, "mPaths", paramInt);
          prepareexpandFieldArray(paramClassLoader, "mFiles", paramInt);
          prepareexpandFieldArray(paramClassLoader, "mZips", paramInt);
          prepareexpandFieldArray(paramClassLoader, "mDexs", paramInt);
          throw new VerifyError("bad dex opcode");
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new VerifyError("bad dex opcode");
        } catch (IllegalAccessException illegalAccessException) {
          throw new VerifyError("bad dex opcode");
        } 
      } catch (NoSuchFieldException noSuchFieldException1) {
        Log.w("MultiDexForTinker", "Strange!no pathlist&path,a new or modified android version ");
        throw new VerifyError("bad dex opcode");
      } 
    } 
  }
  
  private static ArrayList<File> splitPaths(String paramString) {
    ArrayList<File> arrayList = new ArrayList();
    if (paramString != null) {
      paramString = File.pathSeparator;
      throw new VerifyError("bad dex opcode");
    } 
    return arrayList;
  }
  
  private static final class V19 {
    private V19() {
      throw new VerifyError("bad dex opcode");
    }
    
    private static ArrayList<Object> install(ClassLoader param1ClassLoader, Field param1Field, List<File> param1List, File param1File) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
      throw new VerifyError("bad dex opcode");
    }
    
    private static ArrayList<Object> install(ClassLoader param1ClassLoader, Field param1Field, List<File> param1List, File param1File, int param1Int) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
      throw new VerifyError("bad dex opcode");
    }
    
    private static Object[] makeDexElements(Object param1Object, ArrayList<File> param1ArrayList, File param1File, ArrayList<IOException> param1ArrayList1) {
      try {
        MultiDexForTinker.findMethod(param1Object, "makeDexElements", new Class[] { ArrayList.class, File.class });
        try {
          throw new VerifyError("bad dex opcode");
        } catch (IllegalAccessException illegalAccessException) {
          throw new VerifyError("bad dex opcode");
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new VerifyError("bad dex opcode");
        } catch (InvocationTargetException invocationTargetException) {
          throw new VerifyError("bad dex opcode");
        } catch (RuntimeException runtimeException) {
          throw new VerifyError("bad dex opcode");
        } 
      } catch (NoSuchMethodException noSuchMethodException) {
        try {
          MultiDexForTinker.findMethod(param1Object, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class });
          try {
            throw new VerifyError("bad dex opcode");
          } catch (IllegalAccessException illegalAccessException) {
            throw new VerifyError("bad dex opcode");
          } catch (IllegalArgumentException illegalArgumentException) {
            throw new VerifyError("bad dex opcode");
          } catch (InvocationTargetException invocationTargetException) {
            throw new VerifyError("bad dex opcode");
          } catch (RuntimeException runtimeException) {
            throw new VerifyError("bad dex opcode");
          } 
        } catch (NoSuchMethodException noSuchMethodException1) {
          try {
            MultiDexForTinker.findMethod(param1Object, "makePathElements", new Class[] { List.class, File.class, List.class });
            try {
              throw new VerifyError("bad dex opcode");
            } catch (IllegalAccessException illegalAccessException) {
              throw new VerifyError("bad dex opcode");
            } catch (IllegalArgumentException illegalArgumentException) {
              throw new VerifyError("bad dex opcode");
            } catch (InvocationTargetException invocationTargetException) {
              throw new VerifyError("bad dex opcode");
            } 
          } catch (NoSuchMethodException noSuchMethodException2) {
            throw new VerifyError("bad dex opcode");
          } 
        } 
      } 
    }
  }
  
  private static final class V4 {
    private V4() {
      throw new VerifyError("bad dex opcode");
    }
    
    private static ArrayList<Object> install(ClassLoader param1ClassLoader, Field param1Field, List<File> param1List, File param1File) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
      param1List.size();
      throw new VerifyError("bad dex opcode");
    }
    
    private static ArrayList<Object> install(ClassLoader param1ClassLoader, Field param1Field, List<File> param1List, File param1File, int param1Int) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
      param1List.size();
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\wrapper\proxyapplication\MultiDexForTinker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
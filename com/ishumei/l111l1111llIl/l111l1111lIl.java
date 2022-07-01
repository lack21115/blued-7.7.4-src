package com.ishumei.l111l1111llIl;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import com.ishumei.l1111l111111Il.l111l11111Il;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l111l1111lIl {
  private static Object l1111l111111Il(Field paramField, Object paramObject) {
    try {
      Class<?> clazz = paramField.getType();
      if (clazz == Integer.class || clazz == Double.class || clazz == Float.class || clazz == Long.class)
        return (paramObject == null) ? Integer.valueOf(-1) : paramObject; 
      if (clazz == String.class)
        return (paramObject == null) ? "" : paramObject; 
      if (clazz == Map.class)
        return (paramObject == null) ? new JSONObject() : new JSONObject((Map)paramObject); 
    } catch (Exception exception) {
      return new Object();
    } 
    return (exception == List.class || exception == Set.class) ? ((paramObject == null) ? new JSONArray() : new JSONArray((Collection)paramObject)) : ((paramObject == null) ? exception.newInstance() : paramObject);
  }
  
  public static String l1111l111111Il(File paramFile) {
    if (paramFile.exists()) {
      Exception exception;
      File file = null;
      try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(paramFile));
      } finally {
        exception = null;
      } 
      if (paramFile != null)
        paramFile.close(); 
      throw exception;
    } 
    throw new IOException("not exist");
  }
  
  public static String l1111l111111Il(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      byte b = paramArrayOfbyte[i];
      if (stringBuffer.length() > 0)
        stringBuffer.append(":"); 
      String str2 = Integer.toHexString(b & 0xFF);
      String str1 = str2;
      if (str2.length() == 1) {
        StringBuilder stringBuilder = new StringBuilder("0");
        stringBuilder.append(str2);
        str1 = stringBuilder.toString();
      } 
      stringBuffer.append(str1);
    } 
    return stringBuffer.toString();
  }
  
  private static List<String> l1111l111111Il(File paramFile, Set<String> paramSet, int paramInt) {
    ArrayList<String> arrayList = new ArrayList();
    if (paramFile.exists() && paramFile.canRead() && paramFile.isFile() && paramSet != null) {
      Exception exception1;
      Exception exception2;
      if (paramSet.size() == 0)
        return arrayList; 
      HashSet<String> hashSet = new HashSet<String>(paramSet);
      String str = null;
      paramSet = null;
      try {
      
      } catch (Exception null) {
      
      } finally {
        exception3 = null;
        exception1 = exception2;
      } 
      throw new IOException(exception1);
    } 
    return arrayList;
  }
  
  private static List<String> l1111l111111Il(String paramString, Set<String> paramSet, int paramInt) {
    return l1111l111111Il(new File(paramString), paramSet, paramInt);
  }
  
  private static List<Object> l1111l111111Il(JSONArray paramJSONArray) {
    ArrayList<Object> arrayList = new ArrayList();
    if (paramJSONArray == null)
      return arrayList; 
    int j = paramJSONArray.length();
    for (int i = 0; i < j; i++) {
      Object object = paramJSONArray.opt(i);
      if (object != null)
        arrayList.add(l111l11111Il(object)); 
    } 
    return arrayList;
  }
  
  private static Map<String, Object> l1111l111111Il(JSONObject paramJSONObject) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramJSONObject == null)
      return (Map)hashMap; 
    Iterator<String> iterator = paramJSONObject.keys();
    while (iterator.hasNext()) {
      String str = iterator.next();
      Object object = paramJSONObject.opt(str);
      if (object != null)
        hashMap.put(str, l111l11111Il(object)); 
    } 
    return (Map)hashMap;
  }
  
  private static JSONArray l1111l111111Il(Collection paramCollection) {
    JSONArray jSONArray = new JSONArray();
    if (paramCollection != null) {
      Iterator iterator = paramCollection.iterator();
      while (iterator.hasNext())
        jSONArray.put(l111l11111I1l(iterator.next())); 
    } 
    return jSONArray;
  }
  
  public static JSONObject l1111l111111Il(Object paramObject) {
    JSONObject jSONObject = new JSONObject();
    if (paramObject == null)
      return jSONObject; 
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (true) {
      if (i < j) {
        Field field = arrayOfField[i];
        try {
          if (!field.getName().equals("serialVersionUID")) {
            field.setAccessible(true);
            Object object = field.get(paramObject);
            l111l11111Il l111l11111Il = field.<l111l11111Il>getAnnotation(l111l11111Il.class);
            if (l111l11111Il == null) {
              jSONObject.put(field.getName(), object);
            } else {
              boolean bool = l111l11111Il.l111l11111I1l();
              if (object != null || bool) {
                Object object1;
                bool = l111l11111Il.l111l11111lIl();
                String str = l111l11111Il.l1111l111111Il();
                if (bool) {
                  object1 = l1111l111111Il(object);
                } else {
                  object1 = l1111l111111Il((Field)object1, object);
                } 
                jSONObject.put(str, object1);
              } 
            } 
          } 
        } catch (Exception exception) {}
        i++;
        continue;
      } 
      return jSONObject;
    } 
  }
  
  public static JSONObject l1111l111111Il(Map<?, ?> paramMap) {
    JSONObject jSONObject = new JSONObject();
    try {
      Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          String str = (String)entry.getKey();
          if (str != null) {
            try {
              jSONObject.put(str, l111l11111I1l(entry.getValue()));
            } catch (JSONException jSONException) {}
            continue;
          } 
          throw new NullPointerException("key == null");
        } 
        return jSONObject;
      } 
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public static void l1111l111111Il(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void l1111l111111Il(File paramFile, String paramString) {
    if (!l111l1111lI1l.l1111l111111Il(paramString)) {
      File file = null;
      try {
        FileWriter fileWriter = new FileWriter(paramFile);
      } finally {
        paramString = null;
      } 
      if (paramFile != null)
        paramFile.close(); 
      throw paramString;
    } 
    throw new IOException("file or bytes empty");
  }
  
  private static void l1111l111111Il(File paramFile, byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      FileLock fileLock2 = null;
      FileChannel fileChannel = null;
      FileLock fileLock1 = null;
      FileLock fileLock3 = null;
      try {
        FileChannel fileChannel1;
      } catch (Exception exception) {
      
      } finally {
        File file;
        paramArrayOfbyte = null;
        paramFile = null;
      } 
    } else {
      throw new IOException("file or bytes empty");
    } 
    File file2 = null;
    paramArrayOfbyte = null;
    File file1 = paramFile;
    paramFile = file2;
  }
  
  private static void l1111l111111Il(String paramString1, String paramString2) {
    if (!l111l1111lI1l.l1111l111111Il(paramString1) && !l111l1111lI1l.l1111l111111Il(paramString2)) {
      byte[] arrayOfByte = paramString2.getBytes("utf-8");
      if (!l111l1111lI1l.l1111l111111Il(paramString1) && arrayOfByte != null)
        try {
          l1111l111111Il(new File(paramString1), arrayOfByte);
          return;
        } catch (Exception exception) {
          throw new IOException(exception);
        }  
      throw new IOException("filename or byes empty");
    } 
    throw new IOException("file or bytes empty");
  }
  
  private static void l1111l111111Il(String paramString, byte[] paramArrayOfbyte) {
    if (!l111l1111lI1l.l1111l111111Il(paramString) && paramArrayOfbyte != null)
      try {
        l1111l111111Il(new File(paramString), paramArrayOfbyte);
        return;
      } catch (Exception exception) {
        throw new IOException(exception);
      }  
    throw new IOException("filename or byes empty");
  }
  
  public static void l1111l111111Il(HttpURLConnection paramHttpURLConnection) {
    if (paramHttpURLConnection != null)
      try {
        paramHttpURLConnection.disconnect();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static boolean l1111l111111Il(String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Environment.getExternalStorageDirectory());
      stringBuilder.append("/");
      stringBuilder.append(paramString);
      return (new File(stringBuilder.toString())).exists();
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static byte[] l1111l111111Il(FileChannel paramFileChannel) {
    ByteBuffer byteBuffer2 = null;
    ByteBuffer byteBuffer1 = null;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    } catch (Exception exception) {
    
    } finally {
      ByteBuffer byteBuffer;
      paramFileChannel = null;
    } 
    throw new IOException(paramFileChannel);
  }
  
  private static Object l111l11111I1l(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (!(paramObject instanceof JSONArray)) {
      if (paramObject instanceof JSONObject)
        return paramObject; 
      try {
        if (paramObject instanceof Collection) {
          Collection collection = (Collection)paramObject;
          paramObject = new JSONArray();
          if (collection != null) {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext())
              paramObject.put(l111l11111I1l(iterator.next())); 
          } 
        } else {
          if (paramObject.getClass().isArray())
            return l111l11111lIl(paramObject); 
          if (paramObject instanceof Map)
            return l1111l111111Il((Map<?, ?>)paramObject); 
          Object object = paramObject;
          if (!(paramObject instanceof Boolean)) {
            object = paramObject;
            if (!(paramObject instanceof Byte)) {
              object = paramObject;
              if (!(paramObject instanceof Character)) {
                object = paramObject;
                if (!(paramObject instanceof Double)) {
                  object = paramObject;
                  if (!(paramObject instanceof Float)) {
                    object = paramObject;
                    if (!(paramObject instanceof Integer)) {
                      object = paramObject;
                      if (!(paramObject instanceof Long)) {
                        object = paramObject;
                        if (!(paramObject instanceof Short)) {
                          if (paramObject instanceof String)
                            return paramObject; 
                          if (paramObject.getClass().getPackage().getName().startsWith("java."))
                            return paramObject.toString(); 
                        } else {
                          return object;
                        } 
                      } else {
                        return object;
                      } 
                    } else {
                      return object;
                    } 
                  } else {
                    return object;
                  } 
                } else {
                  return object;
                } 
              } else {
                return object;
              } 
            } else {
              return object;
            } 
          } else {
            return object;
          } 
          return null;
        } 
      } catch (Exception exception) {
        return null;
      } 
    } else {
      return exception;
    } 
    return exception;
  }
  
  private static String l111l11111I1l(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return ""; 
    try {
      paramArrayOfbyte = MessageDigest.getInstance("MD5").digest(paramArrayOfbyte);
      StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length << 1);
      int j = paramArrayOfbyte.length;
      for (int i = 0; i < j; i++) {
        int k = paramArrayOfbyte[i] & 0xFF;
        if (k < 16)
          stringBuilder.append("0"); 
        stringBuilder.append(Integer.toHexString(k));
      } 
      return stringBuilder.toString();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new IOException("fail to md5 data");
    } 
  }
  
  public static List<String> l111l11111I1l(String paramString) {
    Exception exception;
    ArrayList<String> arrayList = new ArrayList();
    File file = new File(paramString);
    BufferedReader bufferedReader = null;
    paramString = null;
    try {
      Exception exception1;
      BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
      try {
        while (true)
          return arrayList; 
      } catch (Exception exception2) {
      
      } finally {
        Exception exception2;
        paramString = null;
        exception = exception1;
        String str = paramString;
      } 
    } catch (Exception exception2) {
      Exception exception1 = exception;
    } finally {}
    throw new IOException(file);
  }
  
  private static Object l111l11111Il(Object<Object> paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof JSONObject)
      return l1111l111111Il((JSONObject)paramObject); 
    Object<Object> object = paramObject;
    if (paramObject instanceof JSONArray)
      object = (Object<Object>)l1111l111111Il((JSONArray)paramObject); 
    return object;
  }
  
  public static String l111l11111Il(String paramString) {
    return (paramString != null) ? (paramString.isEmpty() ? "" : paramString.replaceAll(":", "").toLowerCase()) : "";
  }
  
  public static String l111l11111lIl(byte[] paramArrayOfbyte) {
    try {
      return Base64.encodeToString(paramArrayOfbyte, 2);
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
  
  private static List<String> l111l11111lIl(File paramFile, Set<String> paramSet, int paramInt) {
    ArrayList<String> arrayList = new ArrayList();
    if (paramFile.isDirectory() && paramSet != null) {
      if (paramSet.size() == 0)
        return arrayList; 
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null) {
        if (arrayOfString.length == 0)
          return arrayList; 
        paramSet = new HashSet<String>(paramSet);
        int j = arrayOfString.length;
        for (int i = 0; i < j; i++) {
          String str = arrayOfString[i];
          Iterator<String> iterator = paramSet.iterator();
          if (paramInt != 0) {
            if (paramInt != 1) {
              if (paramInt == 2)
                while (iterator.hasNext()) {
                  if (Pattern.compile(iterator.next()).matcher(str).find())
                    arrayList.add(str); 
                }  
            } else {
              str = str.toLowerCase();
              while (iterator.hasNext()) {
                String str1 = iterator.next();
                if (str.contains(str1.toLowerCase()))
                  arrayList.add(str1); 
              } 
            } 
          } else {
            while (iterator.hasNext()) {
              String str1 = iterator.next();
              if (str.contains(str1))
                arrayList.add(str1); 
            } 
          } 
        } 
      } 
    } 
    return arrayList;
  }
  
  private static List<String> l111l11111lIl(String paramString, Set<String> paramSet, int paramInt) {
    return TextUtils.isEmpty(paramString) ? Collections.emptyList() : l111l11111lIl(new File(paramString), paramSet, paramInt);
  }
  
  private static JSONArray l111l11111lIl(Object paramObject) {
    if (paramObject.getClass().isArray()) {
      int j = Array.getLength(paramObject);
      JSONArray jSONArray = new JSONArray();
      for (int i = 0; i < j; i++)
        jSONArray.put(l111l11111I1l(Array.get(paramObject, i))); 
      return jSONArray;
    } 
    StringBuilder stringBuilder = new StringBuilder("Not a primitive data: ");
    stringBuilder.append(paramObject.getClass());
    throw new JSONException(stringBuilder.toString());
  }
  
  public static boolean l111l11111lIl(String paramString) {
    try {
      return (new File(paramString)).exists();
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static String l111l1111l1Il(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    try {
      return l111l11111I1l(paramString.getBytes("utf-8"));
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static String l111l1111lI1l(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    Matcher matcher = Patterns.DOMAIN_NAME.matcher(paramString);
    return matcher.find() ? matcher.group(0) : null;
  }
  
  public static boolean l111l1111lIl(String paramString) {
    return (paramString == null) ? false : Patterns.IP_ADDRESS.matcher(paramString).matches();
  }
  
  public static byte[] l111l1111llIl(String paramString) {
    try {
      return Base64.decode(paramString.getBytes("utf-8"), 0);
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
  
  private static String l11l1111I11l(String paramString) {
    if (paramString != null) {
      if (paramString.length() == 0)
        return ""; 
      try {
        return URLEncoder.encode(paramString, "UTF-8");
      } catch (Exception exception) {
        return "";
      } 
    } 
    return "";
  }
  
  private static String l11l1111lIIl(String paramString) {
    try {
      return l1111l111111Il(new File(paramString));
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l1111llIl\l111l1111lIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
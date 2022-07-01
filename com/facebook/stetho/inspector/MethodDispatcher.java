package com.facebook.stetho.inspector;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class MethodDispatcher {
  private final Iterable<ChromeDevtoolsDomain> mDomainHandlers;
  
  private Map<String, MethodDispatchHelper> mMethods;
  
  private final ObjectMapper mObjectMapper;
  
  public MethodDispatcher(ObjectMapper paramObjectMapper, Iterable<ChromeDevtoolsDomain> paramIterable) {
    this.mObjectMapper = paramObjectMapper;
    this.mDomainHandlers = paramIterable;
  }
  
  private static Map<String, MethodDispatchHelper> buildDispatchTable(ObjectMapper paramObjectMapper, Iterable<ChromeDevtoolsDomain> paramIterable) {
    Util.throwIfNull(paramObjectMapper);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (ChromeDevtoolsDomain chromeDevtoolsDomain : Util.throwIfNull(paramIterable)) {
      Class<?> clazz = chromeDevtoolsDomain.getClass();
      String str = clazz.getSimpleName();
      for (Method method : clazz.getDeclaredMethods()) {
        if (isDevtoolsMethod(method)) {
          MethodDispatchHelper methodDispatchHelper = new MethodDispatchHelper(paramObjectMapper, chromeDevtoolsDomain, method);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append(".");
          stringBuilder.append(method.getName());
          hashMap.put(stringBuilder.toString(), methodDispatchHelper);
        } 
      } 
    } 
    return (Map)Collections.unmodifiableMap(hashMap);
  }
  
  private MethodDispatchHelper findMethodDispatcher(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mMethods : Ljava/util/Map;
    //   6: ifnonnull -> 24
    //   9: aload_0
    //   10: aload_0
    //   11: getfield mObjectMapper : Lcom/facebook/stetho/json/ObjectMapper;
    //   14: aload_0
    //   15: getfield mDomainHandlers : Ljava/lang/Iterable;
    //   18: invokestatic buildDispatchTable : (Lcom/facebook/stetho/json/ObjectMapper;Ljava/lang/Iterable;)Ljava/util/Map;
    //   21: putfield mMethods : Ljava/util/Map;
    //   24: aload_0
    //   25: getfield mMethods : Ljava/util/Map;
    //   28: aload_1
    //   29: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast com/facebook/stetho/inspector/MethodDispatcher$MethodDispatchHelper
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	42	finally
    //   24	38	42	finally
  }
  
  private static boolean isDevtoolsMethod(Method paramMethod) throws IllegalArgumentException {
    boolean bool;
    if (!paramMethod.isAnnotationPresent((Class)ChromeDevtoolsMethod.class))
      return false; 
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramMethod.getDeclaringClass().getSimpleName());
    stringBuilder.append(".");
    stringBuilder.append(paramMethod.getName());
    String str = stringBuilder.toString();
    if (arrayOfClass.length == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    Util.throwIfNot(bool, "%s: expected 2 args, got %s", new Object[] { str, Integer.valueOf(arrayOfClass.length) });
    Util.throwIfNot(arrayOfClass[0].equals(JsonRpcPeer.class), "%s: expected 1st arg of JsonRpcPeer, got %s", new Object[] { str, arrayOfClass[0].getName() });
    Util.throwIfNot(arrayOfClass[1].equals(JSONObject.class), "%s: expected 2nd arg of JSONObject, got %s", new Object[] { str, arrayOfClass[1].getName() });
    Class<?> clazz = paramMethod.getReturnType();
    if (!clazz.equals(void.class))
      Util.throwIfNot(JsonRpcResult.class.isAssignableFrom(clazz), "%s: expected JsonRpcResult return type, got %s", new Object[] { str, clazz.getName() }); 
    return true;
  }
  
  public JSONObject dispatch(JsonRpcPeer paramJsonRpcPeer, String paramString, @Nullable JSONObject paramJSONObject) throws JsonRpcException {
    MethodDispatchHelper methodDispatchHelper = findMethodDispatcher(paramString);
    if (methodDispatchHelper != null)
      try {
        return methodDispatchHelper.invoke(paramJsonRpcPeer, paramJSONObject);
      } catch (InvocationTargetException invocationTargetException) {
        Throwable throwable = invocationTargetException.getCause();
        ExceptionUtil.propagateIfInstanceOf(throwable, JsonRpcException.class);
        throw ExceptionUtil.propagate(throwable);
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (JSONException jSONException) {
        throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, jSONException.toString(), null));
      }  
    JsonRpcError.ErrorCode errorCode = JsonRpcError.ErrorCode.METHOD_NOT_FOUND;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Not implemented: ");
    stringBuilder.append(paramString);
    throw new JsonRpcException(new JsonRpcError(errorCode, stringBuilder.toString(), null));
  }
  
  static class MethodDispatchHelper {
    private final ChromeDevtoolsDomain mInstance;
    
    private final Method mMethod;
    
    private final ObjectMapper mObjectMapper;
    
    public MethodDispatchHelper(ObjectMapper param1ObjectMapper, ChromeDevtoolsDomain param1ChromeDevtoolsDomain, Method param1Method) {
      this.mObjectMapper = param1ObjectMapper;
      this.mInstance = param1ChromeDevtoolsDomain;
      this.mMethod = param1Method;
    }
    
    public JSONObject invoke(JsonRpcPeer param1JsonRpcPeer, @Nullable JSONObject param1JSONObject) throws InvocationTargetException, IllegalAccessException, JSONException, JsonRpcException {
      Object object = this.mMethod.invoke(this.mInstance, new Object[] { param1JsonRpcPeer, param1JSONObject });
      if (object == null || object instanceof com.facebook.stetho.inspector.jsonrpc.protocol.EmptyResult)
        return new JSONObject(); 
      object = object;
      return (JSONObject)this.mObjectMapper.convertValue(object, JSONObject.class);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\MethodDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
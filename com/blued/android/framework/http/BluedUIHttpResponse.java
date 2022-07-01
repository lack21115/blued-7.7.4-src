package com.blued.android.framework.http;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.FileCache;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BluedUIHttpResponse<T extends BluedEntity> extends StringHttpResponseHandler implements IRequestHost {
  private static final String TAG = BluedUIHttpResponse.class.getSimpleName();
  
  private String cacheKey;
  
  private Type dataType;
  
  private boolean httpResult;
  
  private boolean readCache = false;
  
  private IRequestHost requestActive;
  
  private boolean writeCache = false;
  
  public BluedUIHttpResponse() {
    Type type = getClass().getGenericSuperclass();
    if (type instanceof ParameterizedType) {
      Type[] arrayOfType = ((ParameterizedType)type).getActualTypeArguments();
      if (arrayOfType != null && arrayOfType.length > 0)
        this.dataType = arrayOfType[0]; 
    } 
  }
  
  public BluedUIHttpResponse(IRequestHost paramIRequestHost) {
    this();
    this.requestActive = paramIRequestHost;
  }
  
  public BluedUIHttpResponse(String paramString, IRequestHost paramIRequestHost) {
    this(paramIRequestHost);
    this.cacheKey = paramString;
  }
  
  private void onReadCache() {
    if (!this.readCache && !TextUtils.isEmpty(this.cacheKey)) {
      this.readCache = true;
      try {
        T t = parseData(FileCache.a(this.cacheKey));
        AppInfo.n().post(new Runnable(this, (BluedEntity)t) {
              public void run() {
                if (this.b.isActive())
                  this.b.onUICache(this.a); 
              }
            });
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  private void onSaveCache(String paramString) {
    if (!TextUtils.isEmpty(paramString) && !this.writeCache && !TextUtils.isEmpty(this.cacheKey)) {
      FileCache.a(this.cacheKey, paramString);
      this.writeCache = true;
    } 
  }
  
  public boolean isActive() {
    IRequestHost iRequestHost = this.requestActive;
    return (iRequestHost != null) ? iRequestHost.isActive() : true;
  }
  
  @Deprecated
  public void onFailure(Throwable paramThrowable, int paramInt, String paramString) {
    super.onFailure(paramThrowable, paramInt, paramString);
    this.httpResult = false;
    Pair<Integer, String> pair = BluedHttpUtils.a(paramThrowable, paramInt, paramString);
    AppInfo.n().post(new Runnable(this, pair, paramString) {
          public void run() {
            if (this.c.isActive() && !this.c.onUIFailure(((Integer)this.a.first).intValue(), (String)this.a.second, this.b))
              BluedHttpUtils.b.a(((Integer)this.a.first).intValue(), (String)this.a.second); 
          }
        });
  }
  
  @Deprecated
  public final void onFinish() {
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            if (this.a.isActive()) {
              BluedUIHttpResponse bluedUIHttpResponse = this.a;
              bluedUIHttpResponse.onUIFinish(bluedUIHttpResponse.httpResult);
            } 
          }
        });
  }
  
  @Deprecated
  public final void onStart() {
    super.onStart();
    this.httpResult = false;
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            if (this.a.isActive())
              this.a.onUIStart(); 
          }
        });
  }
  
  @Deprecated
  public void onSuccess(int paramInt, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: aload_2
    //   3: invokespecial onSuccess : (ILjava/lang/Object;)V
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_0
    //   9: aload_2
    //   10: invokevirtual parseData : (Ljava/lang/String;)Lcom/blued/android/framework/http/parser/BluedEntity;
    //   13: astore #4
    //   15: aload_3
    //   16: astore #5
    //   18: aload #4
    //   20: astore #6
    //   22: aload #4
    //   24: ifnonnull -> 86
    //   27: aload_0
    //   28: getfield dataType : Ljava/lang/reflect/Type;
    //   31: ifnonnull -> 44
    //   34: aload_3
    //   35: astore #5
    //   37: aload #4
    //   39: astore #6
    //   41: goto -> 86
    //   44: new java/lang/RuntimeException
    //   47: dup
    //   48: ldc 'response is null or parse data failed'
    //   50: invokespecial <init> : (Ljava/lang/String;)V
    //   53: athrow
    //   54: astore_3
    //   55: goto -> 62
    //   58: astore_3
    //   59: aconst_null
    //   60: astore #4
    //   62: aload_3
    //   63: astore #5
    //   65: aload #4
    //   67: astore #6
    //   69: invokestatic m : ()Z
    //   72: ifeq -> 86
    //   75: aload_3
    //   76: invokevirtual printStackTrace : ()V
    //   79: aload #4
    //   81: astore #6
    //   83: aload_3
    //   84: astore #5
    //   86: aload #5
    //   88: iload_1
    //   89: aload_2
    //   90: invokestatic b : (Ljava/lang/Throwable;ILjava/lang/String;)Z
    //   93: ifeq -> 123
    //   96: aload_0
    //   97: iconst_1
    //   98: putfield httpResult : Z
    //   101: aload_0
    //   102: aload_2
    //   103: invokespecial onSaveCache : (Ljava/lang/String;)V
    //   106: invokestatic n : ()Landroid/os/Handler;
    //   109: new com/blued/android/framework/http/BluedUIHttpResponse$4
    //   112: dup
    //   113: aload_0
    //   114: aload #6
    //   116: invokespecial <init> : (Lcom/blued/android/framework/http/BluedUIHttpResponse;Lcom/blued/android/framework/http/parser/BluedEntity;)V
    //   119: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   122: pop
    //   123: return
    // Exception table:
    //   from	to	target	type
    //   8	15	58	java/lang/Exception
    //   27	34	54	java/lang/Exception
    //   44	54	54	java/lang/Exception
  }
  
  @Deprecated
  public void onSuccess(String paramString) {}
  
  public void onUICache(T paramT) {}
  
  public boolean onUIFailure(int paramInt, String paramString) {
    return false;
  }
  
  public boolean onUIFailure(int paramInt, String paramString1, String paramString2) {
    return onUIFailure(paramInt, paramString1);
  }
  
  public void onUIFinish() {}
  
  public void onUIFinish(boolean paramBoolean) {
    onUIFinish();
  }
  
  public void onUIStart() {}
  
  protected abstract void onUIUpdate(T paramT);
  
  public T parseData(String paramString) {
    return (T)((this.dataType == null) ? null : (TextUtils.isEmpty(paramString) ? null : (BluedEntity)AppInfo.f().fromJson(paramString, this.dataType)));
  }
  
  public void refresh() {
    this.writeCache = false;
    onReadCache();
  }
  
  public void setDataType(Type paramType) {
    this.dataType = paramType;
  }
  
  public void setRequestHost(IRequestHost paramIRequestHost) {
    this.requestActive = paramIRequestHost;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\http\BluedUIHttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
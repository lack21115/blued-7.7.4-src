package com.jeremyliao.liveeventbus.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ExternalLiveData;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jeremyliao.liveeventbus.ipc.encode.IEncoder;
import com.jeremyliao.liveeventbus.ipc.encode.ValueEncoder;
import com.jeremyliao.liveeventbus.ipc.json.GsonConverter;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;
import com.jeremyliao.liveeventbus.ipc.receiver.LebIpcReceiver;
import com.jeremyliao.liveeventbus.logger.DefaultLogger;
import com.jeremyliao.liveeventbus.logger.Logger;
import com.jeremyliao.liveeventbus.logger.LoggerManager;
import com.jeremyliao.liveeventbus.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public final class LiveEventBusCore {
  private Context appContext;
  
  private boolean autoClear = false;
  
  private final Map<String, LiveEvent<Object>> bus = new HashMap<String, LiveEvent<Object>>();
  
  private final Config config = new Config();
  
  private IEncoder encoder;
  
  private boolean lifecycleObserverAlwaysActive = true;
  
  private LoggerManager logger = new LoggerManager((Logger)new DefaultLogger());
  
  private LebIpcReceiver receiver;
  
  private LiveEventBusCore() {
    GsonConverter gsonConverter = new GsonConverter();
    this.encoder = (IEncoder)new ValueEncoder((JsonConverter)gsonConverter);
    this.receiver = new LebIpcReceiver((JsonConverter)gsonConverter);
  }
  
  public static LiveEventBusCore get() {
    return SingletonHolder.DEFAULT_BUS;
  }
  
  public Config config() {
    return this.config;
  }
  
  void enableLogger(boolean paramBoolean) {
    this.logger.setEnable(paramBoolean);
  }
  
  void registerReceiver(Context paramContext) {
    if (paramContext != null)
      this.appContext = paramContext.getApplicationContext(); 
    if (this.appContext != null) {
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("intent.action.ACTION_LEB_IPC");
      this.appContext.registerReceiver((BroadcastReceiver)this.receiver, intentFilter);
    } 
  }
  
  void setAutoClear(boolean paramBoolean) {
    this.autoClear = paramBoolean;
  }
  
  void setJsonConverter(JsonConverter paramJsonConverter) {
    if (paramJsonConverter == null)
      return; 
    this.encoder = (IEncoder)new ValueEncoder(paramJsonConverter);
    this.receiver.setJsonConverter(paramJsonConverter);
  }
  
  void setLifecycleObserverAlwaysActive(boolean paramBoolean) {
    this.lifecycleObserverAlwaysActive = paramBoolean;
  }
  
  void setLogger(Logger paramLogger) {
    this.logger.setLogger(paramLogger);
  }
  
  public <T> Observable<T> with(String paramString, Class<T> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield bus : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   12: ifne -> 35
    //   15: aload_0
    //   16: getfield bus : Ljava/util/Map;
    //   19: aload_1
    //   20: new com/jeremyliao/liveeventbus/core/LiveEventBusCore$LiveEvent
    //   23: dup
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial <init> : (Lcom/jeremyliao/liveeventbus/core/LiveEventBusCore;Ljava/lang/String;)V
    //   29: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: pop
    //   35: aload_0
    //   36: getfield bus : Ljava/util/Map;
    //   39: aload_1
    //   40: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast com/jeremyliao/liveeventbus/core/Observable
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	53	finally
    //   35	49	53	finally
  }
  
  class LiveEvent<T> implements Observable<T> {
    private final String key;
    
    private final LifecycleLiveData<T> liveData;
    
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    
    private final Map<Observer, LiveEventBusCore.ObserverWrapper<T>> observerMap = new HashMap<Observer, LiveEventBusCore.ObserverWrapper<T>>();
    
    LiveEvent(String param1String) {
      this.key = param1String;
      this.liveData = new LifecycleLiveData<T>();
    }
    
    private void broadcastInternal(T param1T, boolean param1Boolean) {
      LoggerManager loggerManager = LiveEventBusCore.this.logger;
      Level level = Level.INFO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("broadcast: ");
      stringBuilder.append(param1T);
      stringBuilder.append(" foreground: ");
      stringBuilder.append(param1Boolean);
      stringBuilder.append(" with key: ");
      stringBuilder.append(this.key);
      loggerManager.log(level, stringBuilder.toString());
      Intent intent = new Intent("intent.action.ACTION_LEB_IPC");
      if (param1Boolean && Build.VERSION.SDK_INT >= 16)
        intent.addFlags(268435456); 
      intent.putExtra("leb_ipc_key", this.key);
      try {
        LiveEventBusCore.this.encoder.encode(intent, param1T);
        LiveEventBusCore.this.appContext.sendBroadcast(intent);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      } 
    }
    
    private void observeForeverInternal(Observer<T> param1Observer) {
      boolean bool;
      LiveEventBusCore.ObserverWrapper<T> observerWrapper = new LiveEventBusCore.ObserverWrapper<T>(param1Observer);
      if (this.liveData.getVersion() > -1) {
        bool = true;
      } else {
        bool = false;
      } 
      LiveEventBusCore.ObserverWrapper.access$1202(observerWrapper, bool);
      this.observerMap.put(param1Observer, observerWrapper);
      this.liveData.observeForever(observerWrapper);
      LoggerManager loggerManager = LiveEventBusCore.this.logger;
      Level level = Level.INFO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("observe forever observer: ");
      stringBuilder.append(observerWrapper);
      stringBuilder.append("(");
      stringBuilder.append(param1Observer);
      stringBuilder.append(") with key: ");
      stringBuilder.append(this.key);
      loggerManager.log(level, stringBuilder.toString());
    }
    
    private void observeInternal(LifecycleOwner param1LifecycleOwner, Observer<T> param1Observer) {
      boolean bool;
      LiveEventBusCore.ObserverWrapper<T> observerWrapper = new LiveEventBusCore.ObserverWrapper<T>(param1Observer);
      if (this.liveData.getVersion() > -1) {
        bool = true;
      } else {
        bool = false;
      } 
      LiveEventBusCore.ObserverWrapper.access$1202(observerWrapper, bool);
      this.liveData.observe(param1LifecycleOwner, observerWrapper);
      LoggerManager loggerManager = LiveEventBusCore.this.logger;
      Level level = Level.INFO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("observe observer: ");
      stringBuilder.append(observerWrapper);
      stringBuilder.append("(");
      stringBuilder.append(param1Observer);
      stringBuilder.append(") on owner: ");
      stringBuilder.append(param1LifecycleOwner);
      stringBuilder.append(" with key: ");
      stringBuilder.append(this.key);
      loggerManager.log(level, stringBuilder.toString());
    }
    
    private void observeStickyForeverInternal(Observer<T> param1Observer) {
      LiveEventBusCore.ObserverWrapper<T> observerWrapper = new LiveEventBusCore.ObserverWrapper<T>(param1Observer);
      this.observerMap.put(param1Observer, observerWrapper);
      this.liveData.observeForever(observerWrapper);
      LoggerManager loggerManager = LiveEventBusCore.this.logger;
      Level level = Level.INFO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("observe sticky forever observer: ");
      stringBuilder.append(observerWrapper);
      stringBuilder.append("(");
      stringBuilder.append(param1Observer);
      stringBuilder.append(") with key: ");
      stringBuilder.append(this.key);
      loggerManager.log(level, stringBuilder.toString());
    }
    
    private void observeStickyInternal(LifecycleOwner param1LifecycleOwner, Observer<T> param1Observer) {
      LiveEventBusCore.ObserverWrapper<T> observerWrapper = new LiveEventBusCore.ObserverWrapper<T>(param1Observer);
      this.liveData.observe(param1LifecycleOwner, observerWrapper);
      LoggerManager loggerManager = LiveEventBusCore.this.logger;
      Level level = Level.INFO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("observe sticky observer: ");
      stringBuilder.append(observerWrapper);
      stringBuilder.append("(");
      stringBuilder.append(param1Observer);
      stringBuilder.append(") on owner: ");
      stringBuilder.append(param1LifecycleOwner);
      stringBuilder.append(" with key: ");
      stringBuilder.append(this.key);
      loggerManager.log(level, stringBuilder.toString());
    }
    
    private void postInternal(T param1T) {
      LoggerManager loggerManager = LiveEventBusCore.this.logger;
      Level level = Level.INFO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("post: ");
      stringBuilder.append(param1T);
      stringBuilder.append(" with key: ");
      stringBuilder.append(this.key);
      loggerManager.log(level, stringBuilder.toString());
      this.liveData.setValue(param1T);
    }
    
    private void removeObserverInternal(Observer<T> param1Observer) {
      Observer<T> observer = param1Observer;
      if (this.observerMap.containsKey(param1Observer))
        observer = this.observerMap.remove(param1Observer); 
      this.liveData.removeObserver(observer);
    }
    
    public void broadcast(T param1T) {
      broadcast(param1T, false);
    }
    
    public void broadcast(final T value, final boolean foreground) {
      if (LiveEventBusCore.this.appContext != null) {
        if (ThreadUtils.isMainThread()) {
          broadcastInternal(value, foreground);
          return;
        } 
        this.mainHandler.post(new Runnable() {
              public void run() {
                LiveEventBusCore.LiveEvent.this.broadcastInternal((T)value, foreground);
              }
            });
        return;
      } 
      post(value);
    }
    
    public void observe(final LifecycleOwner owner, final Observer<T> observer) {
      if (ThreadUtils.isMainThread()) {
        observeInternal(owner, observer);
        return;
      } 
      this.mainHandler.post(new Runnable() {
            public void run() {
              LiveEventBusCore.LiveEvent.this.observeInternal(owner, observer);
            }
          });
    }
    
    public void observeForever(final Observer<T> observer) {
      if (ThreadUtils.isMainThread()) {
        observeForeverInternal(observer);
        return;
      } 
      this.mainHandler.post(new Runnable() {
            public void run() {
              LiveEventBusCore.LiveEvent.this.observeForeverInternal(observer);
            }
          });
    }
    
    public void observeSticky(final LifecycleOwner owner, final Observer<T> observer) {
      if (ThreadUtils.isMainThread()) {
        observeStickyInternal(owner, observer);
        return;
      } 
      this.mainHandler.post(new Runnable() {
            public void run() {
              LiveEventBusCore.LiveEvent.this.observeStickyInternal(owner, observer);
            }
          });
    }
    
    public void observeStickyForever(final Observer<T> observer) {
      if (ThreadUtils.isMainThread()) {
        observeStickyForeverInternal(observer);
        return;
      } 
      this.mainHandler.post(new Runnable() {
            public void run() {
              LiveEventBusCore.LiveEvent.this.observeStickyForeverInternal(observer);
            }
          });
    }
    
    public void post(T param1T) {
      if (ThreadUtils.isMainThread()) {
        postInternal(param1T);
        return;
      } 
      this.mainHandler.post(new PostValueTask(param1T));
    }
    
    public void postDelay(LifecycleOwner param1LifecycleOwner, T param1T, long param1Long) {
      this.mainHandler.postDelayed(new PostLifeValueTask(param1T, param1LifecycleOwner), param1Long);
    }
    
    public void postDelay(T param1T, long param1Long) {
      this.mainHandler.postDelayed(new PostValueTask(param1T), param1Long);
    }
    
    public void postOrderly(T param1T) {
      this.mainHandler.post(new PostValueTask(param1T));
    }
    
    public void removeObserver(final Observer<T> observer) {
      if (ThreadUtils.isMainThread()) {
        removeObserverInternal(observer);
        return;
      } 
      this.mainHandler.post(new Runnable() {
            public void run() {
              LiveEventBusCore.LiveEvent.this.removeObserverInternal(observer);
            }
          });
    }
    
    class LifecycleLiveData<T> extends ExternalLiveData<T> {
      private LifecycleLiveData() {}
      
      public Lifecycle.State observerActiveLevel() {
        return LiveEventBusCore.this.lifecycleObserverAlwaysActive ? Lifecycle.State.CREATED : Lifecycle.State.STARTED;
      }
      
      public void removeObserver(Observer<? super T> param2Observer) {
        super.removeObserver(param2Observer);
        if (LiveEventBusCore.this.autoClear && !LiveEventBusCore.LiveEvent.this.liveData.hasObservers())
          (LiveEventBusCore.get()).bus.remove(LiveEventBusCore.LiveEvent.this.key); 
        LoggerManager loggerManager = LiveEventBusCore.this.logger;
        Level level = Level.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("observer removed: ");
        stringBuilder.append(param2Observer);
        loggerManager.log(level, stringBuilder.toString());
      }
    }
    
    class PostLifeValueTask implements Runnable {
      private Object newValue;
      
      private LifecycleOwner owner;
      
      public PostLifeValueTask(Object param2Object, LifecycleOwner param2LifecycleOwner) {
        this.newValue = param2Object;
        this.owner = param2LifecycleOwner;
      }
      
      public void run() {
        LifecycleOwner lifecycleOwner = this.owner;
        if (lifecycleOwner != null && lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED))
          LiveEventBusCore.LiveEvent.this.postInternal((T)this.newValue); 
      }
    }
    
    class PostValueTask implements Runnable {
      private Object newValue;
      
      public PostValueTask(Object param2Object) {
        this.newValue = param2Object;
      }
      
      public void run() {
        LiveEventBusCore.LiveEvent.this.postInternal((T)this.newValue);
      }
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.broadcastInternal((T)value, foreground);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.observeInternal(owner, observer);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.observeStickyInternal(owner, observer);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.observeForeverInternal(observer);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.observeStickyForeverInternal(observer);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.removeObserverInternal(observer);
    }
  }
  
  class LifecycleLiveData<T> extends ExternalLiveData<T> {
    private LifecycleLiveData() {}
    
    public Lifecycle.State observerActiveLevel() {
      return LiveEventBusCore.this.lifecycleObserverAlwaysActive ? Lifecycle.State.CREATED : Lifecycle.State.STARTED;
    }
    
    public void removeObserver(Observer<? super T> param1Observer) {
      super.removeObserver(param1Observer);
      if (LiveEventBusCore.this.autoClear && !LiveEventBusCore.LiveEvent.this.liveData.hasObservers())
        (LiveEventBusCore.get()).bus.remove(LiveEventBusCore.LiveEvent.this.key); 
      LoggerManager loggerManager = LiveEventBusCore.this.logger;
      Level level = Level.INFO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("observer removed: ");
      stringBuilder.append(param1Observer);
      loggerManager.log(level, stringBuilder.toString());
    }
  }
  
  class PostLifeValueTask implements Runnable {
    private Object newValue;
    
    private LifecycleOwner owner;
    
    public PostLifeValueTask(Object param1Object, LifecycleOwner param1LifecycleOwner) {
      this.newValue = param1Object;
      this.owner = param1LifecycleOwner;
    }
    
    public void run() {
      LifecycleOwner lifecycleOwner = this.owner;
      if (lifecycleOwner != null && lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED))
        this.this$1.postInternal((T)this.newValue); 
    }
  }
  
  class PostValueTask implements Runnable {
    private Object newValue;
    
    public PostValueTask(Object param1Object) {
      this.newValue = param1Object;
    }
    
    public void run() {
      this.this$1.postInternal((T)this.newValue);
    }
  }
  
  class ObserverWrapper<T> implements Observer<T> {
    private final Observer<T> observer;
    
    private boolean preventNextEvent = false;
    
    ObserverWrapper(Observer<T> param1Observer) {
      this.observer = param1Observer;
    }
    
    public void onChanged(T param1T) {
      if (this.preventNextEvent) {
        this.preventNextEvent = false;
        return;
      } 
      LoggerManager loggerManager = LiveEventBusCore.this.logger;
      Level level = Level.INFO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("message received: ");
      stringBuilder.append(param1T);
      loggerManager.log(level, stringBuilder.toString());
      try {
        this.observer.onChanged(param1T);
        return;
      } catch (ClassCastException classCastException) {
        LoggerManager loggerManager1 = LiveEventBusCore.this.logger;
        Level level1 = Level.WARNING;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("class cast error on message received: ");
        stringBuilder1.append(param1T);
        loggerManager1.log(level1, stringBuilder1.toString(), classCastException);
        return;
      } catch (Exception exception) {
        LoggerManager loggerManager1 = LiveEventBusCore.this.logger;
        Level level1 = Level.WARNING;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("error on message received: ");
        stringBuilder1.append(param1T);
        loggerManager1.log(level1, stringBuilder1.toString(), exception);
        return;
      } 
    }
  }
  
  static class SingletonHolder {
    private static final LiveEventBusCore DEFAULT_BUS = new LiveEventBusCore();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\core\LiveEventBusCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
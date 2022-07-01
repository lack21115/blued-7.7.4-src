package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
  public static final String KEY_MEDIA_ITEM = "media_item";
  
  public static final String KEY_SEARCH_RESULTS = "search_results";
  
  public static final int RESULT_ERROR = -1;
  
  public static final int RESULT_OK = 0;
  
  public static final int RESULT_PROGRESS_UPDATE = 1;
  
  public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
  
  static final boolean a = Log.isLoggable("MBServiceCompat", 3);
  
  final ArrayMap<IBinder, ConnectionRecord> b = new ArrayMap();
  
  ConnectionRecord c;
  
  final ServiceHandler d = new ServiceHandler(this);
  
  MediaSessionCompat.Token e;
  
  private MediaBrowserServiceImpl f;
  
  List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle) {
    if (paramList == null)
      return null; 
    int i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
    int m = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    if (i == -1 && m == -1)
      return paramList; 
    int k = m * i;
    int j = k + m;
    if (i < 0 || m < 1 || k >= paramList.size())
      return Collections.emptyList(); 
    i = j;
    if (j > paramList.size())
      i = paramList.size(); 
    return paramList.subList(k, i);
  }
  
  void a(String paramString, Bundle paramBundle, ConnectionRecord paramConnectionRecord, ResultReceiver paramResultReceiver) {
    Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(this, paramString, paramResultReceiver) {
        void a(List<MediaBrowserCompat.MediaItem> param1List) {
          if ((b() & 0x4) != 0 || param1List == null) {
            this.a.send(-1, null);
            return;
          } 
          Bundle bundle = new Bundle();
          bundle.putParcelableArray("search_results", (Parcelable[])param1List.toArray((Object[])new MediaBrowserCompat.MediaItem[0]));
          this.a.send(0, bundle);
        }
      };
    this.c = paramConnectionRecord;
    onSearch(paramString, paramBundle, result);
    this.c = null;
    if (result.a())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSearch must call detach() or sendResult() before returning for query=");
    stringBuilder.append(paramString);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  void a(String paramString, ConnectionRecord paramConnectionRecord, Bundle paramBundle1, Bundle paramBundle2) {
    Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(this, paramString, paramConnectionRecord, paramString, paramBundle1, paramBundle2) {
        void a(List<MediaBrowserCompat.MediaItem> param1List) {
          StringBuilder stringBuilder1;
          List<MediaBrowserCompat.MediaItem> list;
          if (this.e.b.get(this.a.callbacks.asBinder()) != this.a) {
            if (MediaBrowserServiceCompat.a) {
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
              stringBuilder1.append(this.a.pkg);
              stringBuilder1.append(" id=");
              stringBuilder1.append(this.b);
              Log.d("MBServiceCompat", stringBuilder1.toString());
            } 
            return;
          } 
          StringBuilder stringBuilder2 = stringBuilder1;
          if ((b() & 0x1) != 0)
            list = this.e.a((List<MediaBrowserCompat.MediaItem>)stringBuilder1, this.c); 
          try {
            this.a.callbacks.onLoadChildren(this.b, list, this.c, this.d);
            return;
          } catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Calling onLoadChildren() failed for id=");
            stringBuilder.append(this.b);
            stringBuilder.append(" package=");
            stringBuilder.append(this.a.pkg);
            Log.w("MBServiceCompat", stringBuilder.toString());
            return;
          } 
        }
      };
    this.c = paramConnectionRecord;
    if (paramBundle1 == null) {
      onLoadChildren(paramString, result);
    } else {
      onLoadChildren(paramString, result, paramBundle1);
    } 
    this.c = null;
    if (result.a())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onLoadChildren must call detach() or sendResult() before returning for package=");
    stringBuilder.append(paramConnectionRecord.pkg);
    stringBuilder.append(" id=");
    stringBuilder.append(paramString);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  void a(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder, Bundle paramBundle) {
    List<Pair> list2 = (List)paramConnectionRecord.subscriptions.get(paramString);
    List<Pair> list1 = list2;
    if (list2 == null)
      list1 = new ArrayList(); 
    for (Pair pair : list1) {
      if (paramIBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(paramBundle, (Bundle)pair.second))
        return; 
    } 
    list1.add(new Pair(paramIBinder, paramBundle));
    paramConnectionRecord.subscriptions.put(paramString, list1);
    a(paramString, paramConnectionRecord, paramBundle, (Bundle)null);
    this.c = paramConnectionRecord;
    onSubscribe(paramString, paramBundle);
    this.c = null;
  }
  
  void a(String paramString, ConnectionRecord paramConnectionRecord, ResultReceiver paramResultReceiver) {
    Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(this, paramString, paramResultReceiver) {
        void a(MediaBrowserCompat.MediaItem param1MediaItem) {
          if ((b() & 0x2) != 0) {
            this.a.send(-1, null);
            return;
          } 
          Bundle bundle = new Bundle();
          bundle.putParcelable("media_item", (Parcelable)param1MediaItem);
          this.a.send(0, bundle);
        }
      };
    this.c = paramConnectionRecord;
    onLoadItem(paramString, result);
    this.c = null;
    if (result.a())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onLoadItem must call detach() or sendResult() before returning for id=");
    stringBuilder.append(paramString);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  boolean a(String paramString, int paramInt) {
    if (paramString == null)
      return false; 
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    int i = arrayOfString.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      if (arrayOfString[paramInt].equals(paramString))
        return true; 
    } 
    return false;
  }
  
  boolean a(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder) {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramIBinder == null)
      try {
        paramIBinder = (IBinder)paramConnectionRecord.subscriptions.remove(paramString);
        if (paramIBinder != null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        } 
        return bool1;
      } finally {
        this.c = paramConnectionRecord;
        onUnsubscribe(paramString);
        this.c = null;
      }  
    List list = paramConnectionRecord.subscriptions.get(paramString);
    bool2 = bool3;
    if (list != null) {
      Iterator iterator = list.iterator();
      while (iterator.hasNext()) {
        if (paramIBinder == ((Pair)iterator.next()).first) {
          iterator.remove();
          bool1 = true;
        } 
      } 
      bool2 = bool1;
      if (list.size() == 0) {
        paramConnectionRecord.subscriptions.remove(paramString);
        bool2 = bool1;
      } 
    } 
    this.c = paramConnectionRecord;
    onUnsubscribe(paramString);
    this.c = null;
    return bool2;
  }
  
  public void attachToBaseContext(Context paramContext) {
    attachBaseContext(paramContext);
  }
  
  void b(String paramString, Bundle paramBundle, ConnectionRecord paramConnectionRecord, ResultReceiver paramResultReceiver) {
    Result<Bundle> result = new Result<Bundle>(this, paramString, paramResultReceiver) {
        void a(Bundle param1Bundle) {
          this.a.send(0, param1Bundle);
        }
        
        void b(Bundle param1Bundle) {
          this.a.send(1, param1Bundle);
        }
        
        void c(Bundle param1Bundle) {
          this.a.send(-1, param1Bundle);
        }
      };
    this.c = paramConnectionRecord;
    onCustomAction(paramString, paramBundle, result);
    this.c = null;
    if (result.a())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
    stringBuilder.append(paramString);
    stringBuilder.append(" extras=");
    stringBuilder.append(paramBundle);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final Bundle getBrowserRootHints() {
    return this.f.getBrowserRootHints();
  }
  
  public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
    return this.f.getCurrentBrowserInfo();
  }
  
  public MediaSessionCompat.Token getSessionToken() {
    return this.e;
  }
  
  public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, String paramString, Bundle paramBundle) {
    if (paramRemoteUserInfo != null) {
      if (paramString != null) {
        if (paramBundle != null) {
          this.f.notifyChildrenChanged(paramRemoteUserInfo, paramString, paramBundle);
          return;
        } 
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
      } 
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    } 
    throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
  }
  
  public void notifyChildrenChanged(String paramString) {
    if (paramString != null) {
      this.f.notifyChildrenChanged(paramString, null);
      return;
    } 
    throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
  }
  
  public void notifyChildrenChanged(String paramString, Bundle paramBundle) {
    if (paramString != null) {
      if (paramBundle != null) {
        this.f.notifyChildrenChanged(paramString, paramBundle);
        return;
      } 
      throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    } 
    throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
  }
  
  public IBinder onBind(Intent paramIntent) {
    return this.f.onBind(paramIntent);
  }
  
  public void onCreate() {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 28) {
      this.f = new MediaBrowserServiceImplApi28(this);
    } else if (Build.VERSION.SDK_INT >= 26) {
      this.f = new MediaBrowserServiceImplApi26(this);
    } else if (Build.VERSION.SDK_INT >= 23) {
      this.f = new MediaBrowserServiceImplApi23(this);
    } else if (Build.VERSION.SDK_INT >= 21) {
      this.f = new MediaBrowserServiceImplApi21(this);
    } else {
      this.f = new MediaBrowserServiceImplBase(this);
    } 
    this.f.onCreate();
  }
  
  public void onCustomAction(String paramString, Bundle paramBundle, Result<Bundle> paramResult) {
    paramResult.sendError(null);
  }
  
  public abstract BrowserRoot onGetRoot(String paramString, int paramInt, Bundle paramBundle);
  
  public abstract void onLoadChildren(String paramString, Result<List<MediaBrowserCompat.MediaItem>> paramResult);
  
  public void onLoadChildren(String paramString, Result<List<MediaBrowserCompat.MediaItem>> paramResult, Bundle paramBundle) {
    paramResult.a(1);
    onLoadChildren(paramString, paramResult);
  }
  
  public void onLoadItem(String paramString, Result<MediaBrowserCompat.MediaItem> paramResult) {
    paramResult.a(2);
    paramResult.sendResult(null);
  }
  
  public void onSearch(String paramString, Bundle paramBundle, Result<List<MediaBrowserCompat.MediaItem>> paramResult) {
    paramResult.a(4);
    paramResult.sendResult(null);
  }
  
  public void onSubscribe(String paramString, Bundle paramBundle) {}
  
  public void onUnsubscribe(String paramString) {}
  
  public void setSessionToken(MediaSessionCompat.Token paramToken) {
    if (paramToken != null) {
      if (this.e == null) {
        this.e = paramToken;
        this.f.setSessionToken(paramToken);
        return;
      } 
      throw new IllegalStateException("The session token has already been set.");
    } 
    throw new IllegalArgumentException("Session token may not be null.");
  }
  
  public static final class BrowserRoot {
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
    
    @Deprecated
    public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
    
    private final String a;
    
    private final Bundle b;
    
    public BrowserRoot(String param1String, Bundle param1Bundle) {
      if (param1String != null) {
        this.a = param1String;
        this.b = param1Bundle;
        return;
      } 
      throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
    }
    
    public Bundle getExtras() {
      return this.b;
    }
    
    public String getRootId() {
      return this.a;
    }
  }
  
  class ConnectionRecord implements IBinder.DeathRecipient {
    public final MediaSessionManager.RemoteUserInfo browserInfo;
    
    public final MediaBrowserServiceCompat.ServiceCallbacks callbacks;
    
    public final int pid;
    
    public final String pkg;
    
    public MediaBrowserServiceCompat.BrowserRoot root;
    
    public final Bundle rootHints;
    
    public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap<String, List<Pair<IBinder, Bundle>>>();
    
    public final int uid;
    
    ConnectionRecord(MediaBrowserServiceCompat this$0, String param1String, int param1Int1, int param1Int2, Bundle param1Bundle, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {
      this.pkg = param1String;
      this.pid = param1Int1;
      this.uid = param1Int2;
      this.browserInfo = new MediaSessionManager.RemoteUserInfo(param1String, param1Int1, param1Int2);
      this.rootHints = param1Bundle;
      this.callbacks = param1ServiceCallbacks;
    }
    
    public void binderDied() {
      this.a.d.post(new Runnable(this) {
            public void run() {
              this.a.a.b.remove(this.a.callbacks.asBinder());
            }
          });
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0) {}
    
    public void run() {
      this.a.a.b.remove(this.a.callbacks.asBinder());
    }
  }
  
  static interface MediaBrowserServiceImpl {
    Bundle getBrowserRootHints();
    
    MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();
    
    void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo param1RemoteUserInfo, String param1String, Bundle param1Bundle);
    
    void notifyChildrenChanged(String param1String, Bundle param1Bundle);
    
    IBinder onBind(Intent param1Intent);
    
    void onCreate();
    
    void setSessionToken(MediaSessionCompat.Token param1Token);
  }
  
  class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
    final List<Bundle> a = new ArrayList<Bundle>();
    
    Object b;
    
    Messenger c;
    
    MediaBrowserServiceImplApi21(MediaBrowserServiceCompat this$0) {}
    
    void a(MediaBrowserServiceCompat.ConnectionRecord param1ConnectionRecord, String param1String, Bundle param1Bundle) {
      List list = param1ConnectionRecord.subscriptions.get(param1String);
      if (list != null)
        for (Pair pair : list) {
          if (MediaBrowserCompatUtils.hasDuplicatedItems(param1Bundle, (Bundle)pair.second))
            this.d.a(param1String, param1ConnectionRecord, (Bundle)pair.second, param1Bundle); 
        }  
    }
    
    void a(MediaSessionManager.RemoteUserInfo param1RemoteUserInfo, String param1String, Bundle param1Bundle) {
      this.d.d.post(new Runnable(this, param1RemoteUserInfo, param1String, param1Bundle) {
            public void run() {
              for (int i = 0; i < this.d.d.b.size(); i++) {
                MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.d.d.b.valueAt(i);
                if (connectionRecord.browserInfo.equals(this.a))
                  this.d.a(connectionRecord, this.b, this.c); 
              } 
            }
          });
    }
    
    void a(String param1String, Bundle param1Bundle) {
      MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.b, param1String);
    }
    
    void b(String param1String, Bundle param1Bundle) {
      this.d.d.post(new Runnable(this, param1String, param1Bundle) {
            public void run() {
              for (IBinder iBinder : this.c.d.b.keySet()) {
                MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.c.d.b.get(iBinder);
                this.c.a(connectionRecord, this.a, this.b);
              } 
            }
          });
    }
    
    public Bundle getBrowserRootHints() {
      if (this.c == null)
        return null; 
      if (this.d.c != null)
        return (this.d.c.rootHints == null) ? null : new Bundle(this.d.c.rootHints); 
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
      if (this.d.c != null)
        return this.d.c.browserInfo; 
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo param1RemoteUserInfo, String param1String, Bundle param1Bundle) {
      a(param1RemoteUserInfo, param1String, param1Bundle);
    }
    
    public void notifyChildrenChanged(String param1String, Bundle param1Bundle) {
      a(param1String, param1Bundle);
      b(param1String, param1Bundle);
    }
    
    public IBinder onBind(Intent param1Intent) {
      return MediaBrowserServiceCompatApi21.onBind(this.b, param1Intent);
    }
    
    public void onCreate() {
      this.b = MediaBrowserServiceCompatApi21.createService((Context)this.d, this);
      MediaBrowserServiceCompatApi21.onCreate(this.b);
    }
    
    public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String param1String, int param1Int, Bundle param1Bundle) {
      String str;
      if (param1Bundle != null && param1Bundle.getInt("extra_client_version", 0) != 0) {
        param1Bundle.remove("extra_client_version");
        this.c = new Messenger(this.d.d);
        Bundle bundle = new Bundle();
        bundle.putInt("extra_service_version", 2);
        BundleCompat.putBinder(bundle, "extra_messenger", this.c.getBinder());
        if (this.d.e != null) {
          IBinder iBinder;
          IMediaSession iMediaSession = this.d.e.getExtraBinder();
          if (iMediaSession == null) {
            iMediaSession = null;
          } else {
            iBinder = iMediaSession.asBinder();
          } 
          BundleCompat.putBinder(bundle, "extra_session_binder", iBinder);
          str = (String)bundle;
        } else {
          this.a.add(bundle);
          str = (String)bundle;
        } 
      } else {
        str = null;
      } 
      MediaBrowserServiceCompat mediaBrowserServiceCompat = this.d;
      mediaBrowserServiceCompat.c = new MediaBrowserServiceCompat.ConnectionRecord(mediaBrowserServiceCompat, param1String, -1, param1Int, param1Bundle, null);
      MediaBrowserServiceCompat.BrowserRoot browserRoot = this.d.onGetRoot(param1String, param1Int, param1Bundle);
      this.d.c = null;
      if (browserRoot == null)
        return null; 
      if (str == null) {
        Bundle bundle = browserRoot.getExtras();
      } else {
        param1String = str;
        if (browserRoot.getExtras() != null) {
          str.putAll(browserRoot.getExtras());
          param1String = str;
        } 
      } 
      return new MediaBrowserServiceCompatApi21.BrowserRoot(browserRoot.getRootId(), (Bundle)param1String);
    }
    
    public void onLoadChildren(String param1String, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> param1ResultWrapper) {
      MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result = new MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>>(this, param1String, param1ResultWrapper) {
          void a(List<MediaBrowserCompat.MediaItem> param2List) {
            if (param2List != null) {
              ArrayList<MediaBrowserCompat.MediaItem> arrayList = new ArrayList();
              Iterator<MediaBrowserCompat.MediaItem> iterator = param2List.iterator();
              while (true) {
                param2List = arrayList;
                if (iterator.hasNext()) {
                  MediaBrowserCompat.MediaItem mediaItem = iterator.next();
                  Parcel parcel = Parcel.obtain();
                  mediaItem.writeToParcel(parcel, 0);
                  arrayList.add(parcel);
                  continue;
                } 
                break;
              } 
            } else {
              param2List = null;
            } 
            this.a.sendResult(param2List);
          }
          
          public void detach() {
            this.a.detach();
          }
        };
      this.d.onLoadChildren(param1String, result);
    }
    
    public void setSessionToken(MediaSessionCompat.Token param1Token) {
      this.d.d.postOrRun(new Runnable(this, param1Token) {
            public void run() {
              if (!this.b.a.isEmpty()) {
                IMediaSession iMediaSession = this.a.getExtraBinder();
                if (iMediaSession != null) {
                  Iterator<Bundle> iterator = this.b.a.iterator();
                  while (iterator.hasNext())
                    BundleCompat.putBinder(iterator.next(), "extra_session_binder", iMediaSession.asBinder()); 
                } 
                this.b.a.clear();
              } 
              MediaBrowserServiceCompatApi21.setSessionToken(this.b.b, this.a.getToken());
            }
          });
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaSessionCompat.Token param1Token) {}
    
    public void run() {
      if (!this.b.a.isEmpty()) {
        IMediaSession iMediaSession = this.a.getExtraBinder();
        if (iMediaSession != null) {
          Iterator<Bundle> iterator = this.b.a.iterator();
          while (iterator.hasNext())
            BundleCompat.putBinder(iterator.next(), "extra_session_binder", iMediaSession.asBinder()); 
        } 
        this.b.a.clear();
      } 
      MediaBrowserServiceCompatApi21.setSessionToken(this.b.b, this.a.getToken());
    }
  }
  
  class null extends Result<List<MediaBrowserCompat.MediaItem>> {
    null(MediaBrowserServiceCompat this$0, Object param1Object, MediaBrowserServiceCompatApi21.ResultWrapper param1ResultWrapper) {
      super(param1Object);
    }
    
    void a(List<MediaBrowserCompat.MediaItem> param1List) {
      if (param1List != null) {
        ArrayList<MediaBrowserCompat.MediaItem> arrayList = new ArrayList();
        Iterator<MediaBrowserCompat.MediaItem> iterator = param1List.iterator();
        while (true) {
          param1List = arrayList;
          if (iterator.hasNext()) {
            MediaBrowserCompat.MediaItem mediaItem = iterator.next();
            Parcel parcel = Parcel.obtain();
            mediaItem.writeToParcel(parcel, 0);
            arrayList.add(parcel);
            continue;
          } 
          break;
        } 
      } else {
        param1List = null;
      } 
      this.a.sendResult(param1List);
    }
    
    public void detach() {
      this.a.detach();
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, String param1String, Bundle param1Bundle) {}
    
    public void run() {
      for (IBinder iBinder : this.c.d.b.keySet()) {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.c.d.b.get(iBinder);
        this.c.a(connectionRecord, this.a, this.b);
      } 
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaSessionManager.RemoteUserInfo param1RemoteUserInfo, String param1String, Bundle param1Bundle) {}
    
    public void run() {
      for (int i = 0; i < this.d.d.b.size(); i++) {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.d.d.b.valueAt(i);
        if (connectionRecord.browserInfo.equals(this.a))
          this.d.a(connectionRecord, this.b, this.c); 
      } 
    }
  }
  
  class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
    MediaBrowserServiceImplApi23(MediaBrowserServiceCompat this$0) {
      super(this$0);
    }
    
    public void onCreate() {
      this.b = MediaBrowserServiceCompatApi23.createService((Context)this.e, this);
      MediaBrowserServiceCompatApi21.onCreate(this.b);
    }
    
    public void onLoadItem(String param1String, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> param1ResultWrapper) {
      MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> result = new MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem>(this, param1String, param1ResultWrapper) {
          void a(MediaBrowserCompat.MediaItem param2MediaItem) {
            if (param2MediaItem == null) {
              this.a.sendResult(null);
              return;
            } 
            Parcel parcel = Parcel.obtain();
            param2MediaItem.writeToParcel(parcel, 0);
            this.a.sendResult(parcel);
          }
          
          public void detach() {
            this.a.detach();
          }
        };
      this.e.onLoadItem(param1String, result);
    }
  }
  
  class null extends Result<MediaBrowserCompat.MediaItem> {
    null(MediaBrowserServiceCompat this$0, Object param1Object, MediaBrowserServiceCompatApi21.ResultWrapper param1ResultWrapper) {
      super(param1Object);
    }
    
    void a(MediaBrowserCompat.MediaItem param1MediaItem) {
      if (param1MediaItem == null) {
        this.a.sendResult(null);
        return;
      } 
      Parcel parcel = Parcel.obtain();
      param1MediaItem.writeToParcel(parcel, 0);
      this.a.sendResult(parcel);
    }
    
    public void detach() {
      this.a.detach();
    }
  }
  
  class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
    MediaBrowserServiceImplApi26(MediaBrowserServiceCompat this$0) {
      super(this$0);
    }
    
    void a(String param1String, Bundle param1Bundle) {
      if (param1Bundle != null) {
        MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.b, param1String, param1Bundle);
        return;
      } 
      super.a(param1String, param1Bundle);
    }
    
    public Bundle getBrowserRootHints() {
      return (this.f.c != null) ? ((this.f.c.rootHints == null) ? null : new Bundle(this.f.c.rootHints)) : MediaBrowserServiceCompatApi26.getBrowserRootHints(this.b);
    }
    
    public void onCreate() {
      this.b = MediaBrowserServiceCompatApi26.createService((Context)this.f, this);
      MediaBrowserServiceCompatApi21.onCreate(this.b);
    }
    
    public void onLoadChildren(String param1String, MediaBrowserServiceCompatApi26.ResultWrapper param1ResultWrapper, Bundle param1Bundle) {
      MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result = new MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>>(this, param1String, param1ResultWrapper) {
          void a(List<MediaBrowserCompat.MediaItem> param2List) {
            if (param2List != null) {
              ArrayList<MediaBrowserCompat.MediaItem> arrayList = new ArrayList();
              Iterator<MediaBrowserCompat.MediaItem> iterator = param2List.iterator();
              while (true) {
                param2List = arrayList;
                if (iterator.hasNext()) {
                  MediaBrowserCompat.MediaItem mediaItem = iterator.next();
                  Parcel parcel = Parcel.obtain();
                  mediaItem.writeToParcel(parcel, 0);
                  arrayList.add(parcel);
                  continue;
                } 
                break;
              } 
            } else {
              param2List = null;
            } 
            this.a.sendResult((List)param2List, b());
          }
          
          public void detach() {
            this.a.detach();
          }
        };
      this.f.onLoadChildren(param1String, result, param1Bundle);
    }
  }
  
  class null extends Result<List<MediaBrowserCompat.MediaItem>> {
    null(MediaBrowserServiceCompat this$0, Object param1Object, MediaBrowserServiceCompatApi26.ResultWrapper param1ResultWrapper) {
      super(param1Object);
    }
    
    void a(List<MediaBrowserCompat.MediaItem> param1List) {
      if (param1List != null) {
        ArrayList<MediaBrowserCompat.MediaItem> arrayList = new ArrayList();
        Iterator<MediaBrowserCompat.MediaItem> iterator = param1List.iterator();
        while (true) {
          param1List = arrayList;
          if (iterator.hasNext()) {
            MediaBrowserCompat.MediaItem mediaItem = iterator.next();
            Parcel parcel = Parcel.obtain();
            mediaItem.writeToParcel(parcel, 0);
            arrayList.add(parcel);
            continue;
          } 
          break;
        } 
      } else {
        param1List = null;
      } 
      this.a.sendResult((List)param1List, b());
    }
    
    public void detach() {
      this.a.detach();
    }
  }
  
  class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
    MediaBrowserServiceImplApi28(MediaBrowserServiceCompat this$0) {
      super(this$0);
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
      return (this.g.c != null) ? this.g.c.browserInfo : new MediaSessionManager.RemoteUserInfo(((MediaBrowserService)this.b).getCurrentBrowserInfo());
    }
  }
  
  class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
    private Messenger b;
    
    MediaBrowserServiceImplBase(MediaBrowserServiceCompat this$0) {}
    
    void a(MediaBrowserServiceCompat.ConnectionRecord param1ConnectionRecord, String param1String, Bundle param1Bundle) {
      List list = param1ConnectionRecord.subscriptions.get(param1String);
      if (list != null)
        for (Pair pair : list) {
          if (MediaBrowserCompatUtils.hasDuplicatedItems(param1Bundle, (Bundle)pair.second))
            this.a.a(param1String, param1ConnectionRecord, (Bundle)pair.second, param1Bundle); 
        }  
    }
    
    public Bundle getBrowserRootHints() {
      if (this.a.c != null)
        return (this.a.c.rootHints == null) ? null : new Bundle(this.a.c.rootHints); 
      throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
      if (this.a.c != null)
        return this.a.c.browserInfo; 
      throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo param1RemoteUserInfo, String param1String, Bundle param1Bundle) {
      this.a.d.post(new Runnable(this, param1RemoteUserInfo, param1String, param1Bundle) {
            public void run() {
              for (int i = 0; i < this.d.a.b.size(); i++) {
                MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.d.a.b.valueAt(i);
                if (connectionRecord.browserInfo.equals(this.a)) {
                  this.d.a(connectionRecord, this.b, this.c);
                  return;
                } 
              } 
            }
          });
    }
    
    public void notifyChildrenChanged(String param1String, Bundle param1Bundle) {
      this.a.d.post(new Runnable(this, param1String, param1Bundle) {
            public void run() {
              for (IBinder iBinder : this.c.a.b.keySet()) {
                MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.c.a.b.get(iBinder);
                this.c.a(connectionRecord, this.a, this.b);
              } 
            }
          });
    }
    
    public IBinder onBind(Intent param1Intent) {
      return "android.media.browse.MediaBrowserService".equals(param1Intent.getAction()) ? this.b.getBinder() : null;
    }
    
    public void onCreate() {
      this.b = new Messenger(this.a.d);
    }
    
    public void setSessionToken(MediaSessionCompat.Token param1Token) {
      this.a.d.post(new Runnable(this, param1Token) {
            public void run() {
              Iterator<MediaBrowserServiceCompat.ConnectionRecord> iterator = this.b.a.b.values().iterator();
              while (true) {
                if (iterator.hasNext()) {
                  MediaBrowserServiceCompat.ConnectionRecord connectionRecord = iterator.next();
                  try {
                    connectionRecord.callbacks.onConnect(connectionRecord.root.getRootId(), this.a, connectionRecord.root.getExtras());
                  } catch (RemoteException remoteException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Connection for ");
                    stringBuilder.append(connectionRecord.pkg);
                    stringBuilder.append(" is no longer valid.");
                    Log.w("MBServiceCompat", stringBuilder.toString());
                    iterator.remove();
                  } 
                  continue;
                } 
                return;
              } 
            }
          });
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaSessionCompat.Token param1Token) {}
    
    public void run() {
      Iterator<MediaBrowserServiceCompat.ConnectionRecord> iterator = this.b.a.b.values().iterator();
      while (true) {
        if (iterator.hasNext()) {
          MediaBrowserServiceCompat.ConnectionRecord connectionRecord = iterator.next();
          try {
            connectionRecord.callbacks.onConnect(connectionRecord.root.getRootId(), this.a, connectionRecord.root.getExtras());
          } catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Connection for ");
            stringBuilder.append(connectionRecord.pkg);
            stringBuilder.append(" is no longer valid.");
            Log.w("MBServiceCompat", stringBuilder.toString());
            iterator.remove();
          } 
          continue;
        } 
        return;
      } 
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, String param1String, Bundle param1Bundle) {}
    
    public void run() {
      for (IBinder iBinder : this.c.a.b.keySet()) {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.c.a.b.get(iBinder);
        this.c.a(connectionRecord, this.a, this.b);
      } 
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaSessionManager.RemoteUserInfo param1RemoteUserInfo, String param1String, Bundle param1Bundle) {}
    
    public void run() {
      for (int i = 0; i < this.d.a.b.size(); i++) {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.d.a.b.valueAt(i);
        if (connectionRecord.browserInfo.equals(this.a)) {
          this.d.a(connectionRecord, this.b, this.c);
          return;
        } 
      } 
    }
  }
  
  public static class Result<T> {
    private final Object a;
    
    private boolean b;
    
    private boolean c;
    
    private boolean d;
    
    private boolean e;
    
    private int f;
    
    Result(Object param1Object) {
      this.a = param1Object;
    }
    
    private void a(Bundle param1Bundle) {
      if (param1Bundle == null)
        return; 
      if (param1Bundle.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS")) {
        float f = param1Bundle.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
        if (f >= -1.0E-5F && f <= 1.00001F)
          return; 
        throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
      } 
    }
    
    void a(int param1Int) {
      this.f = param1Int;
    }
    
    void a(T param1T) {}
    
    boolean a() {
      return (this.b || this.c || this.e);
    }
    
    int b() {
      return this.f;
    }
    
    void b(Bundle param1Bundle) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("It is not supported to send an interim update for ");
      stringBuilder.append(this.a);
      throw new UnsupportedOperationException(stringBuilder.toString());
    }
    
    void c(Bundle param1Bundle) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("It is not supported to send an error for ");
      stringBuilder.append(this.a);
      throw new UnsupportedOperationException(stringBuilder.toString());
    }
    
    public void detach() {
      if (!this.b) {
        if (!this.c) {
          if (!this.e) {
            this.b = true;
            return;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("detach() called when sendError() had already been called for: ");
          stringBuilder2.append(this.a);
          throw new IllegalStateException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("detach() called when sendResult() had already been called for: ");
        stringBuilder1.append(this.a);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("detach() called when detach() had already been called for: ");
      stringBuilder.append(this.a);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public void sendError(Bundle param1Bundle) {
      if (!this.c && !this.e) {
        this.e = true;
        c(param1Bundle);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendError() called when either sendResult() or sendError() had already been called for: ");
      stringBuilder.append(this.a);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public void sendProgressUpdate(Bundle param1Bundle) {
      if (!this.c && !this.e) {
        a(param1Bundle);
        this.d = true;
        b(param1Bundle);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
      stringBuilder.append(this.a);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public void sendResult(T param1T) {
      if (!this.c && !this.e) {
        this.c = true;
        a(param1T);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendResult() called when either sendResult() or sendError() had already been called for: ");
      stringBuilder.append(this.a);
      throw new IllegalStateException(stringBuilder.toString());
    }
  }
  
  class ServiceBinderImpl {
    ServiceBinderImpl(MediaBrowserServiceCompat this$0) {}
    
    public void addSubscription(String param1String, IBinder param1IBinder, Bundle param1Bundle, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {
      this.a.d.postOrRun(new Runnable(this, param1ServiceCallbacks, param1String, param1IBinder, param1Bundle) {
            public void run() {
              StringBuilder stringBuilder;
              IBinder iBinder = this.a.asBinder();
              MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.e.a.b.get(iBinder);
              if (connectionRecord == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("addSubscription for callback that isn't registered id=");
                stringBuilder.append(this.b);
                Log.w("MBServiceCompat", stringBuilder.toString());
                return;
              } 
              this.e.a.a(this.b, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.c, this.d);
            }
          });
    }
    
    public void connect(String param1String, int param1Int1, int param1Int2, Bundle param1Bundle, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {
      if (this.a.a(param1String, param1Int2)) {
        this.a.d.postOrRun(new Runnable(this, param1ServiceCallbacks, param1String, param1Int1, param1Int2, param1Bundle) {
              public void run() {
                StringBuilder stringBuilder;
                IBinder iBinder = this.a.asBinder();
                this.f.a.b.remove(iBinder);
                MediaBrowserServiceCompat.ConnectionRecord connectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(this.f.a, this.b, this.c, this.d, this.e, this.a);
                this.f.a.c = connectionRecord;
                connectionRecord.root = this.f.a.onGetRoot(this.b, this.d, this.e);
                this.f.a.c = null;
                if (connectionRecord.root == null) {
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("No root for client ");
                  stringBuilder.append(this.b);
                  stringBuilder.append(" from service ");
                  stringBuilder.append(getClass().getName());
                  Log.i("MBServiceCompat", stringBuilder.toString());
                  try {
                    this.a.onConnectFailed();
                    return;
                  } catch (RemoteException remoteException) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Calling onConnectFailed() failed. Ignoring. pkg=");
                    stringBuilder.append(this.b);
                    Log.w("MBServiceCompat", stringBuilder.toString());
                    return;
                  } 
                } 
                try {
                  this.f.a.b.put(stringBuilder, connectionRecord);
                  stringBuilder.linkToDeath(connectionRecord, 0);
                  if (this.f.a.e != null) {
                    this.a.onConnect(connectionRecord.root.getRootId(), this.f.a.e, connectionRecord.root.getExtras());
                    return;
                  } 
                } catch (RemoteException remoteException) {
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("Calling onConnect() failed. Dropping client. pkg=");
                  stringBuilder1.append(this.b);
                  Log.w("MBServiceCompat", stringBuilder1.toString());
                  this.f.a.b.remove(stringBuilder);
                } 
              }
            });
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Package/uid mismatch: uid=");
      stringBuilder.append(param1Int2);
      stringBuilder.append(" package=");
      stringBuilder.append(param1String);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public void disconnect(MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {
      this.a.d.postOrRun(new Runnable(this, param1ServiceCallbacks) {
            public void run() {
              IBinder iBinder = this.a.asBinder();
              MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.b.a.b.remove(iBinder);
              if (connectionRecord != null)
                connectionRecord.callbacks.asBinder().unlinkToDeath(connectionRecord, 0); 
            }
          });
    }
    
    public void getMediaItem(String param1String, ResultReceiver param1ResultReceiver, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {
      if (!TextUtils.isEmpty(param1String)) {
        if (param1ResultReceiver == null)
          return; 
        this.a.d.postOrRun(new Runnable(this, param1ServiceCallbacks, param1String, param1ResultReceiver) {
              public void run() {
                StringBuilder stringBuilder;
                IBinder iBinder = this.a.asBinder();
                MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.d.a.b.get(iBinder);
                if (connectionRecord == null) {
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("getMediaItem for callback that isn't registered id=");
                  stringBuilder.append(this.b);
                  Log.w("MBServiceCompat", stringBuilder.toString());
                  return;
                } 
                this.d.a.a(this.b, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.c);
              }
            });
      } 
    }
    
    public void registerCallbacks(MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks, String param1String, int param1Int1, int param1Int2, Bundle param1Bundle) {
      this.a.d.postOrRun(new Runnable(this, param1ServiceCallbacks, param1String, param1Int1, param1Int2, param1Bundle) {
            public void run() {
              IBinder iBinder = this.a.asBinder();
              this.f.a.b.remove(iBinder);
              MediaBrowserServiceCompat.ConnectionRecord connectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(this.f.a, this.b, this.c, this.d, this.e, this.a);
              this.f.a.b.put(iBinder, connectionRecord);
              try {
                iBinder.linkToDeath(connectionRecord, 0);
                return;
              } catch (RemoteException remoteException) {
                Log.w("MBServiceCompat", "IBinder is already dead.");
                return;
              } 
            }
          });
    }
    
    public void removeSubscription(String param1String, IBinder param1IBinder, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {
      this.a.d.postOrRun(new Runnable(this, param1ServiceCallbacks, param1String, param1IBinder) {
            public void run() {
              StringBuilder stringBuilder;
              IBinder iBinder = this.a.asBinder();
              MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.d.a.b.get(iBinder);
              if (connectionRecord == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("removeSubscription for callback that isn't registered id=");
                stringBuilder.append(this.b);
                Log.w("MBServiceCompat", stringBuilder.toString());
                return;
              } 
              if (!this.d.a.a(this.b, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.c)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("removeSubscription called for ");
                stringBuilder.append(this.b);
                stringBuilder.append(" which is not subscribed");
                Log.w("MBServiceCompat", stringBuilder.toString());
              } 
            }
          });
    }
    
    public void search(String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {
      if (!TextUtils.isEmpty(param1String)) {
        if (param1ResultReceiver == null)
          return; 
        this.a.d.postOrRun(new Runnable(this, param1ServiceCallbacks, param1String, param1Bundle, param1ResultReceiver) {
              public void run() {
                StringBuilder stringBuilder;
                IBinder iBinder = this.a.asBinder();
                MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.e.a.b.get(iBinder);
                if (connectionRecord == null) {
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("search for callback that isn't registered query=");
                  stringBuilder.append(this.b);
                  Log.w("MBServiceCompat", stringBuilder.toString());
                  return;
                } 
                this.e.a.a(this.b, this.c, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.d);
              }
            });
      } 
    }
    
    public void sendCustomAction(String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {
      if (!TextUtils.isEmpty(param1String)) {
        if (param1ResultReceiver == null)
          return; 
        this.a.d.postOrRun(new Runnable(this, param1ServiceCallbacks, param1String, param1Bundle, param1ResultReceiver) {
              public void run() {
                StringBuilder stringBuilder;
                IBinder iBinder = this.a.asBinder();
                MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.e.a.b.get(iBinder);
                if (connectionRecord == null) {
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("sendCustomAction for callback that isn't registered action=");
                  stringBuilder.append(this.b);
                  stringBuilder.append(", extras=");
                  stringBuilder.append(this.c);
                  Log.w("MBServiceCompat", stringBuilder.toString());
                  return;
                } 
                this.e.a.b(this.b, this.c, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.d);
              }
            });
      } 
    }
    
    public void unregisterCallbacks(MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {
      this.a.d.postOrRun(new Runnable(this, param1ServiceCallbacks) {
            public void run() {
              IBinder iBinder = this.a.asBinder();
              MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.b.a.b.remove(iBinder);
              if (connectionRecord != null)
                iBinder.unlinkToDeath(connectionRecord, 0); 
            }
          });
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks, String param1String, int param1Int1, int param1Int2, Bundle param1Bundle) {}
    
    public void run() {
      StringBuilder stringBuilder;
      IBinder iBinder = this.a.asBinder();
      this.f.a.b.remove(iBinder);
      MediaBrowserServiceCompat.ConnectionRecord connectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(this.f.a, this.b, this.c, this.d, this.e, this.a);
      this.f.a.c = connectionRecord;
      connectionRecord.root = this.f.a.onGetRoot(this.b, this.d, this.e);
      this.f.a.c = null;
      if (connectionRecord.root == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("No root for client ");
        stringBuilder.append(this.b);
        stringBuilder.append(" from service ");
        stringBuilder.append(getClass().getName());
        Log.i("MBServiceCompat", stringBuilder.toString());
        try {
          this.a.onConnectFailed();
          return;
        } catch (RemoteException remoteException) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Calling onConnectFailed() failed. Ignoring. pkg=");
          stringBuilder.append(this.b);
          Log.w("MBServiceCompat", stringBuilder.toString());
          return;
        } 
      } 
      try {
        this.f.a.b.put(stringBuilder, connectionRecord);
        stringBuilder.linkToDeath(connectionRecord, 0);
        if (this.f.a.e != null) {
          this.a.onConnect(connectionRecord.root.getRootId(), this.f.a.e, connectionRecord.root.getExtras());
          return;
        } 
      } catch (RemoteException remoteException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Calling onConnect() failed. Dropping client. pkg=");
        stringBuilder1.append(this.b);
        Log.w("MBServiceCompat", stringBuilder1.toString());
        this.f.a.b.remove(stringBuilder);
      } 
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {}
    
    public void run() {
      IBinder iBinder = this.a.asBinder();
      MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.b.a.b.remove(iBinder);
      if (connectionRecord != null)
        connectionRecord.callbacks.asBinder().unlinkToDeath(connectionRecord, 0); 
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks, String param1String, IBinder param1IBinder, Bundle param1Bundle) {}
    
    public void run() {
      StringBuilder stringBuilder;
      IBinder iBinder = this.a.asBinder();
      MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.e.a.b.get(iBinder);
      if (connectionRecord == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("addSubscription for callback that isn't registered id=");
        stringBuilder.append(this.b);
        Log.w("MBServiceCompat", stringBuilder.toString());
        return;
      } 
      this.e.a.a(this.b, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.c, this.d);
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks, String param1String, IBinder param1IBinder) {}
    
    public void run() {
      StringBuilder stringBuilder;
      IBinder iBinder = this.a.asBinder();
      MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.d.a.b.get(iBinder);
      if (connectionRecord == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("removeSubscription for callback that isn't registered id=");
        stringBuilder.append(this.b);
        Log.w("MBServiceCompat", stringBuilder.toString());
        return;
      } 
      if (!this.d.a.a(this.b, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.c)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("removeSubscription called for ");
        stringBuilder.append(this.b);
        stringBuilder.append(" which is not subscribed");
        Log.w("MBServiceCompat", stringBuilder.toString());
      } 
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks, String param1String, ResultReceiver param1ResultReceiver) {}
    
    public void run() {
      StringBuilder stringBuilder;
      IBinder iBinder = this.a.asBinder();
      MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.d.a.b.get(iBinder);
      if (connectionRecord == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("getMediaItem for callback that isn't registered id=");
        stringBuilder.append(this.b);
        Log.w("MBServiceCompat", stringBuilder.toString());
        return;
      } 
      this.d.a.a(this.b, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.c);
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks, String param1String, int param1Int1, int param1Int2, Bundle param1Bundle) {}
    
    public void run() {
      IBinder iBinder = this.a.asBinder();
      this.f.a.b.remove(iBinder);
      MediaBrowserServiceCompat.ConnectionRecord connectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(this.f.a, this.b, this.c, this.d, this.e, this.a);
      this.f.a.b.put(iBinder, connectionRecord);
      try {
        iBinder.linkToDeath(connectionRecord, 0);
        return;
      } catch (RemoteException remoteException) {
        Log.w("MBServiceCompat", "IBinder is already dead.");
        return;
      } 
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks) {}
    
    public void run() {
      IBinder iBinder = this.a.asBinder();
      MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.b.a.b.remove(iBinder);
      if (connectionRecord != null)
        iBinder.unlinkToDeath(connectionRecord, 0); 
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks, String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver) {}
    
    public void run() {
      StringBuilder stringBuilder;
      IBinder iBinder = this.a.asBinder();
      MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.e.a.b.get(iBinder);
      if (connectionRecord == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("search for callback that isn't registered query=");
        stringBuilder.append(this.b);
        Log.w("MBServiceCompat", stringBuilder.toString());
        return;
      } 
      this.e.a.a(this.b, this.c, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.d);
    }
  }
  
  class null implements Runnable {
    null(MediaBrowserServiceCompat this$0, MediaBrowserServiceCompat.ServiceCallbacks param1ServiceCallbacks, String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver) {}
    
    public void run() {
      StringBuilder stringBuilder;
      IBinder iBinder = this.a.asBinder();
      MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.e.a.b.get(iBinder);
      if (connectionRecord == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("sendCustomAction for callback that isn't registered action=");
        stringBuilder.append(this.b);
        stringBuilder.append(", extras=");
        stringBuilder.append(this.c);
        Log.w("MBServiceCompat", stringBuilder.toString());
        return;
      } 
      this.e.a.b(this.b, this.c, (MediaBrowserServiceCompat.ConnectionRecord)stringBuilder, this.d);
    }
  }
  
  static interface ServiceCallbacks {
    IBinder asBinder();
    
    void onConnect(String param1String, MediaSessionCompat.Token param1Token, Bundle param1Bundle) throws RemoteException;
    
    void onConnectFailed() throws RemoteException;
    
    void onLoadChildren(String param1String, List<MediaBrowserCompat.MediaItem> param1List, Bundle param1Bundle1, Bundle param1Bundle2) throws RemoteException;
  }
  
  static class ServiceCallbacksCompat implements ServiceCallbacks {
    final Messenger a;
    
    ServiceCallbacksCompat(Messenger param1Messenger) {
      this.a = param1Messenger;
    }
    
    private void a(int param1Int, Bundle param1Bundle) throws RemoteException {
      Message message = Message.obtain();
      message.what = param1Int;
      message.arg1 = 2;
      message.setData(param1Bundle);
      this.a.send(message);
    }
    
    public IBinder asBinder() {
      return this.a.getBinder();
    }
    
    public void onConnect(String param1String, MediaSessionCompat.Token param1Token, Bundle param1Bundle) throws RemoteException {
      Bundle bundle = param1Bundle;
      if (param1Bundle == null)
        bundle = new Bundle(); 
      bundle.putInt("extra_service_version", 2);
      param1Bundle = new Bundle();
      param1Bundle.putString("data_media_item_id", param1String);
      param1Bundle.putParcelable("data_media_session_token", (Parcelable)param1Token);
      param1Bundle.putBundle("data_root_hints", bundle);
      a(1, param1Bundle);
    }
    
    public void onConnectFailed() throws RemoteException {
      a(2, null);
    }
    
    public void onLoadChildren(String param1String, List<MediaBrowserCompat.MediaItem> param1List, Bundle param1Bundle1, Bundle param1Bundle2) throws RemoteException {
      Bundle bundle = new Bundle();
      bundle.putString("data_media_item_id", param1String);
      bundle.putBundle("data_options", param1Bundle1);
      bundle.putBundle("data_notify_children_changed_options", param1Bundle2);
      if (param1List != null) {
        ArrayList<MediaBrowserCompat.MediaItem> arrayList;
        if (param1List instanceof ArrayList) {
          arrayList = (ArrayList)param1List;
        } else {
          arrayList = new ArrayList<MediaBrowserCompat.MediaItem>(param1List);
        } 
        bundle.putParcelableArrayList("data_media_item_list", arrayList);
      } 
      a(3, bundle);
    }
  }
  
  final class ServiceHandler extends Handler {
    private final MediaBrowserServiceCompat.ServiceBinderImpl b = new MediaBrowserServiceCompat.ServiceBinderImpl(this.a);
    
    ServiceHandler(MediaBrowserServiceCompat this$0) {}
    
    public void handleMessage(Message param1Message) {
      StringBuilder stringBuilder;
      Bundle bundle1 = param1Message.getData();
      switch (param1Message.what) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unhandled message: ");
          stringBuilder.append(param1Message);
          stringBuilder.append("\n  Service version: ");
          stringBuilder.append(2);
          stringBuilder.append("\n  Client version: ");
          stringBuilder.append(param1Message.arg1);
          Log.w("MBServiceCompat", stringBuilder.toString());
          return;
        case 9:
          bundle2 = stringBuilder.getBundle("data_custom_action_extras");
          MediaSessionCompat.ensureClassLoader(bundle2);
          this.b.sendCustomAction(stringBuilder.getString("data_custom_action"), bundle2, (ResultReceiver)stringBuilder.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(param1Message.replyTo));
          return;
        case 8:
          bundle2 = stringBuilder.getBundle("data_search_extras");
          MediaSessionCompat.ensureClassLoader(bundle2);
          this.b.search(stringBuilder.getString("data_search_query"), bundle2, (ResultReceiver)stringBuilder.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(param1Message.replyTo));
          return;
        case 7:
          this.b.unregisterCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(param1Message.replyTo));
          return;
        case 6:
          bundle2 = stringBuilder.getBundle("data_root_hints");
          MediaSessionCompat.ensureClassLoader(bundle2);
          this.b.registerCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(param1Message.replyTo), stringBuilder.getString("data_package_name"), stringBuilder.getInt("data_calling_pid"), stringBuilder.getInt("data_calling_uid"), bundle2);
          return;
        case 5:
          this.b.getMediaItem(stringBuilder.getString("data_media_item_id"), (ResultReceiver)stringBuilder.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(param1Message.replyTo));
          return;
        case 4:
          this.b.removeSubscription(stringBuilder.getString("data_media_item_id"), BundleCompat.getBinder((Bundle)stringBuilder, "data_callback_token"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(param1Message.replyTo));
          return;
        case 3:
          bundle2 = stringBuilder.getBundle("data_options");
          MediaSessionCompat.ensureClassLoader(bundle2);
          this.b.addSubscription(stringBuilder.getString("data_media_item_id"), BundleCompat.getBinder((Bundle)stringBuilder, "data_callback_token"), bundle2, new MediaBrowserServiceCompat.ServiceCallbacksCompat(param1Message.replyTo));
          return;
        case 2:
          this.b.disconnect(new MediaBrowserServiceCompat.ServiceCallbacksCompat(param1Message.replyTo));
          return;
        case 1:
          break;
      } 
      Bundle bundle2 = stringBuilder.getBundle("data_root_hints");
      MediaSessionCompat.ensureClassLoader(bundle2);
      this.b.connect(stringBuilder.getString("data_package_name"), stringBuilder.getInt("data_calling_pid"), stringBuilder.getInt("data_calling_uid"), bundle2, new MediaBrowserServiceCompat.ServiceCallbacksCompat(param1Message.replyTo));
    }
    
    public void postOrRun(Runnable param1Runnable) {
      if (Thread.currentThread() == getLooper().getThread()) {
        param1Runnable.run();
        return;
      } 
      post(param1Runnable);
    }
    
    public boolean sendMessageAtTime(Message param1Message, long param1Long) {
      Bundle bundle = param1Message.getData();
      bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      bundle.putInt("data_calling_uid", Binder.getCallingUid());
      bundle.putInt("data_calling_pid", Binder.getCallingPid());
      return super.sendMessageAtTime(param1Message, param1Long);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\MediaBrowserServiceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
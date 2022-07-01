package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service {
  static final Object h = new Object();
  
  static final HashMap<ComponentName, WorkEnqueuer> i = new HashMap<ComponentName, WorkEnqueuer>();
  
  CompatJobEngine a;
  
  WorkEnqueuer b;
  
  CommandProcessor c;
  
  boolean d = false;
  
  boolean e = false;
  
  boolean f = false;
  
  final ArrayList<CompatWorkItem> g;
  
  public JobIntentService() {
    if (Build.VERSION.SDK_INT >= 26) {
      this.g = null;
      return;
    } 
    this.g = new ArrayList<CompatWorkItem>();
  }
  
  static WorkEnqueuer a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt) {
    WorkEnqueuer workEnqueuer2 = i.get(paramComponentName);
    WorkEnqueuer workEnqueuer1 = workEnqueuer2;
    if (workEnqueuer2 == null) {
      JobWorkEnqueuer jobWorkEnqueuer;
      CompatWorkEnqueuer compatWorkEnqueuer;
      if (Build.VERSION.SDK_INT >= 26) {
        if (paramBoolean) {
          jobWorkEnqueuer = new JobWorkEnqueuer(paramContext, paramComponentName, paramInt);
        } else {
          throw new IllegalArgumentException("Can't be here without a job id");
        } 
      } else {
        compatWorkEnqueuer = new CompatWorkEnqueuer((Context)jobWorkEnqueuer, paramComponentName);
      } 
      i.put(paramComponentName, compatWorkEnqueuer);
      workEnqueuer1 = compatWorkEnqueuer;
    } 
    return workEnqueuer1;
  }
  
  public static void enqueueWork(Context paramContext, ComponentName paramComponentName, int paramInt, Intent paramIntent) {
    if (paramIntent != null)
      synchronized (h) {
        WorkEnqueuer workEnqueuer = a(paramContext, paramComponentName, true, paramInt);
        workEnqueuer.a(paramInt);
        workEnqueuer.a(paramIntent);
        return;
      }  
    throw new IllegalArgumentException("work must not be null");
  }
  
  public static void enqueueWork(Context paramContext, Class<?> paramClass, int paramInt, Intent paramIntent) {
    enqueueWork(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }
  
  protected abstract void a(Intent paramIntent);
  
  void a(boolean paramBoolean) {
    if (this.c == null) {
      this.c = new CommandProcessor(this);
      WorkEnqueuer workEnqueuer = this.b;
      if (workEnqueuer != null && paramBoolean)
        workEnqueuer.serviceProcessingStarted(); 
      this.c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    } 
  }
  
  boolean a() {
    CommandProcessor commandProcessor = this.c;
    if (commandProcessor != null)
      commandProcessor.cancel(this.d); 
    this.e = true;
    return onStopCurrentWork();
  }
  
  void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Ljava/util/ArrayList;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull -> 63
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_0
    //   12: aconst_null
    //   13: putfield c : Landroidx/core/app/JobIntentService$CommandProcessor;
    //   16: aload_0
    //   17: getfield g : Ljava/util/ArrayList;
    //   20: ifnull -> 41
    //   23: aload_0
    //   24: getfield g : Ljava/util/ArrayList;
    //   27: invokevirtual size : ()I
    //   30: ifle -> 41
    //   33: aload_0
    //   34: iconst_0
    //   35: invokevirtual a : (Z)V
    //   38: goto -> 55
    //   41: aload_0
    //   42: getfield f : Z
    //   45: ifne -> 55
    //   48: aload_0
    //   49: getfield b : Landroidx/core/app/JobIntentService$WorkEnqueuer;
    //   52: invokevirtual serviceProcessingFinished : ()V
    //   55: aload_1
    //   56: monitorexit
    //   57: return
    //   58: astore_2
    //   59: aload_1
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    //   63: return
    // Exception table:
    //   from	to	target	type
    //   11	38	58	finally
    //   41	55	58	finally
    //   55	57	58	finally
    //   59	61	58	finally
  }
  
  GenericWorkItem c() {
    CompatJobEngine compatJobEngine = this.a;
    if (compatJobEngine != null)
      return compatJobEngine.dequeueWork(); 
    synchronized (this.g) {
      if (this.g.size() > 0)
        return this.g.remove(0); 
      return null;
    } 
  }
  
  public boolean isStopped() {
    return this.e;
  }
  
  public IBinder onBind(Intent paramIntent) {
    CompatJobEngine compatJobEngine = this.a;
    return (compatJobEngine != null) ? compatJobEngine.compatGetBinder() : null;
  }
  
  public void onCreate() {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26) {
      this.a = new JobServiceEngineImpl(this);
      this.b = null;
      return;
    } 
    this.a = null;
    this.b = a((Context)this, new ComponentName((Context)this, getClass()), false, 0);
  }
  
  public void onDestroy() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial onDestroy : ()V
    //   4: aload_0
    //   5: getfield g : Ljava/util/ArrayList;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull -> 35
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield f : Z
    //   20: aload_0
    //   21: getfield b : Landroidx/core/app/JobIntentService$WorkEnqueuer;
    //   24: invokevirtual serviceProcessingFinished : ()V
    //   27: aload_1
    //   28: monitorexit
    //   29: return
    //   30: astore_2
    //   31: aload_1
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    //   35: return
    // Exception table:
    //   from	to	target	type
    //   15	29	30	finally
    //   31	33	30	finally
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    if (this.g != null) {
      this.b.serviceStartReceived();
      synchronized (this.g) {
        ArrayList<CompatWorkItem> arrayList = this.g;
        if (paramIntent == null)
          paramIntent = new Intent(); 
        arrayList.add(new CompatWorkItem(this, paramIntent, paramInt2));
        a(true);
        return 3;
      } 
    } 
    return 2;
  }
  
  public boolean onStopCurrentWork() {
    return true;
  }
  
  public void setInterruptIfStopped(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  final class CommandProcessor extends AsyncTask<Void, Void, Void> {
    CommandProcessor(JobIntentService this$0) {}
    
    protected Void a(Void... param1VarArgs) {
      while (true) {
        JobIntentService.GenericWorkItem genericWorkItem = this.a.c();
        if (genericWorkItem != null) {
          this.a.a(genericWorkItem.getIntent());
          genericWorkItem.complete();
          continue;
        } 
        return null;
      } 
    }
    
    protected void a(Void param1Void) {
      this.a.b();
    }
    
    protected void b(Void param1Void) {
      this.a.b();
    }
  }
  
  static interface CompatJobEngine {
    IBinder compatGetBinder();
    
    JobIntentService.GenericWorkItem dequeueWork();
  }
  
  static final class CompatWorkEnqueuer extends WorkEnqueuer {
    boolean a;
    
    boolean b;
    
    private final Context f;
    
    private final PowerManager.WakeLock g;
    
    private final PowerManager.WakeLock h;
    
    CompatWorkEnqueuer(Context param1Context, ComponentName param1ComponentName) {
      super(param1ComponentName);
      this.f = param1Context.getApplicationContext();
      PowerManager powerManager = (PowerManager)param1Context.getSystemService("power");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1ComponentName.getClassName());
      stringBuilder.append(":launch");
      this.g = powerManager.newWakeLock(1, stringBuilder.toString());
      this.g.setReferenceCounted(false);
      stringBuilder = new StringBuilder();
      stringBuilder.append(param1ComponentName.getClassName());
      stringBuilder.append(":run");
      this.h = powerManager.newWakeLock(1, stringBuilder.toString());
      this.h.setReferenceCounted(false);
    }
    
    void a(Intent param1Intent) {
      // Byte code:
      //   0: new android/content/Intent
      //   3: dup
      //   4: aload_1
      //   5: invokespecial <init> : (Landroid/content/Intent;)V
      //   8: astore_1
      //   9: aload_1
      //   10: aload_0
      //   11: getfield c : Landroid/content/ComponentName;
      //   14: invokevirtual setComponent : (Landroid/content/ComponentName;)Landroid/content/Intent;
      //   17: pop
      //   18: aload_0
      //   19: getfield f : Landroid/content/Context;
      //   22: aload_1
      //   23: invokevirtual startService : (Landroid/content/Intent;)Landroid/content/ComponentName;
      //   26: ifnull -> 68
      //   29: aload_0
      //   30: monitorenter
      //   31: aload_0
      //   32: getfield a : Z
      //   35: ifne -> 60
      //   38: aload_0
      //   39: iconst_1
      //   40: putfield a : Z
      //   43: aload_0
      //   44: getfield b : Z
      //   47: ifne -> 60
      //   50: aload_0
      //   51: getfield g : Landroid/os/PowerManager$WakeLock;
      //   54: ldc2_w 60000
      //   57: invokevirtual acquire : (J)V
      //   60: aload_0
      //   61: monitorexit
      //   62: return
      //   63: astore_1
      //   64: aload_0
      //   65: monitorexit
      //   66: aload_1
      //   67: athrow
      //   68: return
      // Exception table:
      //   from	to	target	type
      //   31	60	63	finally
      //   60	62	63	finally
      //   64	66	63	finally
    }
    
    public void serviceProcessingFinished() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Z
      //   6: ifeq -> 38
      //   9: aload_0
      //   10: getfield a : Z
      //   13: ifeq -> 26
      //   16: aload_0
      //   17: getfield g : Landroid/os/PowerManager$WakeLock;
      //   20: ldc2_w 60000
      //   23: invokevirtual acquire : (J)V
      //   26: aload_0
      //   27: iconst_0
      //   28: putfield b : Z
      //   31: aload_0
      //   32: getfield h : Landroid/os/PowerManager$WakeLock;
      //   35: invokevirtual release : ()V
      //   38: aload_0
      //   39: monitorexit
      //   40: return
      //   41: astore_1
      //   42: aload_0
      //   43: monitorexit
      //   44: aload_1
      //   45: athrow
      // Exception table:
      //   from	to	target	type
      //   2	26	41	finally
      //   26	38	41	finally
      //   38	40	41	finally
      //   42	44	41	finally
    }
    
    public void serviceProcessingStarted() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Z
      //   6: ifne -> 31
      //   9: aload_0
      //   10: iconst_1
      //   11: putfield b : Z
      //   14: aload_0
      //   15: getfield h : Landroid/os/PowerManager$WakeLock;
      //   18: ldc2_w 600000
      //   21: invokevirtual acquire : (J)V
      //   24: aload_0
      //   25: getfield g : Landroid/os/PowerManager$WakeLock;
      //   28: invokevirtual release : ()V
      //   31: aload_0
      //   32: monitorexit
      //   33: return
      //   34: astore_1
      //   35: aload_0
      //   36: monitorexit
      //   37: aload_1
      //   38: athrow
      // Exception table:
      //   from	to	target	type
      //   2	31	34	finally
      //   31	33	34	finally
      //   35	37	34	finally
    }
    
    public void serviceStartReceived() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_0
      //   4: putfield a : Z
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_1
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_1
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	10	finally
      //   11	13	10	finally
    }
  }
  
  final class CompatWorkItem implements GenericWorkItem {
    final Intent a;
    
    final int b;
    
    CompatWorkItem(JobIntentService this$0, Intent param1Intent, int param1Int) {
      this.a = param1Intent;
      this.b = param1Int;
    }
    
    public void complete() {
      this.c.stopSelf(this.b);
    }
    
    public Intent getIntent() {
      return this.a;
    }
  }
  
  static interface GenericWorkItem {
    void complete();
    
    Intent getIntent();
  }
  
  static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
    final JobIntentService a;
    
    final Object b = new Object();
    
    JobParameters c;
    
    JobServiceEngineImpl(JobIntentService param1JobIntentService) {
      super(param1JobIntentService);
      this.a = param1JobIntentService;
    }
    
    public IBinder compatGetBinder() {
      return getBinder();
    }
    
    public JobIntentService.GenericWorkItem dequeueWork() {
      synchronized (this.b) {
        if (this.c == null)
          return null; 
        JobWorkItem jobWorkItem = this.c.dequeueWork();
        if (jobWorkItem != null) {
          jobWorkItem.getIntent().setExtrasClassLoader(this.a.getClassLoader());
          return new WrapperWorkItem(this, jobWorkItem);
        } 
        return null;
      } 
    }
    
    public boolean onStartJob(JobParameters param1JobParameters) {
      this.c = param1JobParameters;
      this.a.a(false);
      return true;
    }
    
    public boolean onStopJob(JobParameters param1JobParameters) {
      boolean bool = this.a.a();
      synchronized (this.b) {
        this.c = null;
        return bool;
      } 
    }
    
    final class WrapperWorkItem implements JobIntentService.GenericWorkItem {
      final JobWorkItem a;
      
      WrapperWorkItem(JobIntentService.JobServiceEngineImpl this$0, JobWorkItem param2JobWorkItem) {
        this.a = param2JobWorkItem;
      }
      
      public void complete() {
        synchronized (this.b.b) {
          if (this.b.c != null)
            this.b.c.completeWork(this.a); 
          return;
        } 
      }
      
      public Intent getIntent() {
        return this.a.getIntent();
      }
    }
  }
  
  final class WrapperWorkItem implements GenericWorkItem {
    final JobWorkItem a;
    
    WrapperWorkItem(JobIntentService this$0, JobWorkItem param1JobWorkItem) {
      this.a = param1JobWorkItem;
    }
    
    public void complete() {
      synchronized (this.b.b) {
        if (this.b.c != null)
          this.b.c.completeWork(this.a); 
        return;
      } 
    }
    
    public Intent getIntent() {
      return this.a.getIntent();
    }
  }
  
  static final class JobWorkEnqueuer extends WorkEnqueuer {
    private final JobInfo a;
    
    private final JobScheduler b;
    
    JobWorkEnqueuer(Context param1Context, ComponentName param1ComponentName, int param1Int) {
      super(param1ComponentName);
      a(param1Int);
      this.a = (new JobInfo.Builder(param1Int, this.c)).setOverrideDeadline(0L).build();
      this.b = (JobScheduler)param1Context.getApplicationContext().getSystemService("jobscheduler");
    }
    
    void a(Intent param1Intent) {
      this.b.enqueue(this.a, new JobWorkItem(param1Intent));
    }
  }
  
  static abstract class WorkEnqueuer {
    final ComponentName c;
    
    boolean d;
    
    int e;
    
    WorkEnqueuer(ComponentName param1ComponentName) {
      this.c = param1ComponentName;
    }
    
    void a(int param1Int) {
      if (!this.d) {
        this.d = true;
        this.e = param1Int;
        return;
      } 
      if (this.e == param1Int)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Given job ID ");
      stringBuilder.append(param1Int);
      stringBuilder.append(" is different than previous ");
      stringBuilder.append(this.e);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    abstract void a(Intent param1Intent);
    
    public void serviceProcessingFinished() {}
    
    public void serviceProcessingStarted() {}
    
    public void serviceStartReceived() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\JobIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.find.manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.guy.GuyProtos;
import com.huawei.android.hms.agent.common.ActivityMgr;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.HelloHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.find.fragment.HelloOpenDialogFragment;
import com.soft.blued.ui.find.fragment.HelloStateDialogFragment;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.HelloOpenState;
import com.soft.blued.ui.find.observer.CallHelloObserver;
import com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.PermissionUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.dialog.BluedAlertDialog;
import java.util.Timer;
import java.util.TimerTask;

public class CallHelloManager {
  private static volatile CallHelloManager a;
  
  private volatile CallMeStatusData b;
  
  private int c;
  
  private Timer d;
  
  private int e;
  
  private Timer f;
  
  private boolean g = true;
  
  public static CallHelloManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/find/manager/CallHelloManager.a : Lcom/soft/blued/ui/find/manager/CallHelloManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/find/manager/CallHelloManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/find/manager/CallHelloManager.a : Lcom/soft/blued/ui/find/manager/CallHelloManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/find/manager/CallHelloManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/find/manager/CallHelloManager.a : Lcom/soft/blued/ui/find/manager/CallHelloManager;
    //   25: ldc com/soft/blued/ui/find/manager/CallHelloManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/find/manager/CallHelloManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/find/manager/CallHelloManager.a : Lcom/soft/blued/ui/find/manager/CallHelloManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private static void b(int paramInt) {
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            if (paramInt != 11)
              return; 
            EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.CALL_POP);
            return;
          } 
          EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.HOME_KEEP_ON);
          return;
        } 
        EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.HOME_VOCATIVE_BTN);
        return;
      } 
      EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.VOCATIVE_MESSAGE);
      return;
    } 
    EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.VOCATIVE_HOMEPAGE);
  }
  
  private void b(Context paramContext, ToOpenListener paramToOpenListener, boolean paramBoolean) {
    if (!BluedPreferences.ed() && paramBoolean) {
      EventTrackGuy.b(GuyProtos.Event.VOCATIVE_OPEN_POP_SHOW);
      BluedAlertDialog bluedAlertDialog = CommonAlertDialog.a(paramContext, paramContext.getString(2131755706), paramContext.getString(2131755707), paramContext.getString(2131756100), new DialogInterface.OnClickListener(this, paramToOpenListener) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              BluedPreferences.ee();
              EventTrackGuy.b(GuyProtos.Event.VOCATIVE_PROMPT_TRUE_BTN_CLICK);
              this.a.a(true);
            }
          }null, new DialogInterface.OnClickListener(this, paramToOpenListener) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              this.a.a(false);
            }
          }null);
      bluedAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener(this, paramToOpenListener) {
            public void onCancel(DialogInterface param1DialogInterface) {
              this.a.a(false);
            }
          });
      bluedAlertDialog.c().setGravity(1);
      return;
    } 
    paramToOpenListener.a(true);
  }
  
  private void c(Context paramContext, ToOpenListener paramToOpenListener, boolean paramBoolean) {
    PermissionHelper.c(new PermissionCallbacks(this, paramContext, paramToOpenListener, paramBoolean) {
          public void a(String[] param1ArrayOfString) {
            this.b.a(false);
          }
          
          public void aa_() {
            CallHelloManager.b(this.d, this.a, this.b, this.c);
          }
        });
  }
  
  public void a(Context paramContext, IRequestHost paramIRequestHost, int paramInt) {
    if (this.b == null)
      return; 
    c();
    this.e = this.b.countdown;
    this.d = new Timer();
    this.d.schedule(new TimerTask(this, paramContext, paramIRequestHost, paramInt) {
          public void run() {
            CallHelloManager.c(this.d);
            if (CallHelloManager.d(this.d) <= 0) {
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      (CallHelloManager.b(this.a.d)).call_status = 5;
                      CallHelloObserver.a().a(CallHelloManager.b(this.a.d));
                    }
                  });
              this.d.c();
              AppInfo.n().postDelayed(new Runnable(this) {
                    public void run() {
                      this.a.d.a(this.a.a, this.a.b, this.a.c, (CallHelloManager.ToOpenListener)null);
                    }
                  }1000L);
              return;
            } 
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    CallHelloObserver.a().a(CallHelloManager.d(this.a.d));
                  }
                });
          }
        }0L, 1000L);
  }
  
  public void a(Context paramContext, IRequestHost paramIRequestHost, int paramInt, ToOpenListener paramToOpenListener) {
    a(paramContext, paramIRequestHost, paramInt, false, paramToOpenListener);
  }
  
  public void a(Context paramContext, IRequestHost paramIRequestHost, int paramInt, boolean paramBoolean, ToOpenListener paramToOpenListener) {
    FindHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<CallMeStatusData>>(this, paramIRequestHost, paramToOpenListener, paramContext, paramBoolean, paramInt) {
          protected void a(BluedEntityA<CallMeStatusData> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.hasData()) {
              CallHelloManager.a(this.e, (CallMeStatusData)param1BluedEntityA.getSingleData());
              CallHelloManager.a(this.e, BluedPreferences.cd());
              if (CallHelloManager.a(this.e) == 1 && (CallHelloManager.b(this.e)).call_status == 0) {
                BluedPreferences.t(5);
                (CallHelloManager.b(this.e)).call_status = 5;
              } else {
                BluedPreferences.t((CallHelloManager.b(this.e)).call_status);
              } 
              if (this.a != null)
                if ((CallHelloManager.b(this.e)).call_status == 0) {
                  if (CallHelloManager.b(this.e) != null && ((CallHelloManager.b(this.e)).free_count != 0 || (CallHelloManager.b(this.e)).pay_count != 0)) {
                    if (BluedConfig.b().I()) {
                      this.e.a(this.b, this.c, this.d);
                      this.a.a(false);
                    } else if (!this.c) {
                      this.e.a(this.b, this.a);
                    } else {
                      this.e.b(this.b, this.a);
                    } 
                  } else {
                    CallHelloManager.a(this.d);
                    PrivilegeBuyDialogFragment.a(this.b, this.d);
                    this.a.a(false);
                  } 
                } else {
                  if (!this.c)
                    HelloStateDialogFragment.a(this.b, CallHelloManager.a().b()); 
                  this.a.a(false);
                }  
              CallHelloObserver.a().a(CallHelloManager.b(this.e));
            } 
          }
        }paramIRequestHost);
  }
  
  public void a(Context paramContext, IRequestHost paramIRequestHost, boolean paramBoolean, int paramInt) {
    HelloHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<HelloOpenState>>(this, paramIRequestHost, paramContext, paramInt) {
          protected void a(BluedEntityA<HelloOpenState> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.hasData()) {
              HelloOpenState helloOpenState = (HelloOpenState)param1BluedEntityA.getSingleData();
              (CallHelloManager.b(this.c)).is_quietly = helloOpenState.is_quietly;
              if (helloOpenState.open_status == 0) {
                ToastUtils.a(this.a.getResources().getString(2131758320));
                return;
              } 
              if (helloOpenState.open_status == 2) {
                CallHelloManager.a(this.b);
                PrivilegeBuyDialogFragment.a(this.a, this.b);
                return;
              } 
              if (helloOpenState.open_status == 3) {
                (CallHelloManager.b(this.c)).call_status = 2;
                HelloStateDialogFragment.a(this.a, CallHelloManager.b(this.c));
                CallHelloObserver.a().a(CallHelloManager.b(this.c));
                return;
              } 
              if (helloOpenState.open_status == 1) {
                (CallHelloManager.b(this.c)).call_status = 4;
                (CallHelloManager.b(this.c)).countdown = (int)helloOpenState.countdown;
                (CallHelloManager.b(this.c)).multiples = helloOpenState.multiples;
                HelloStateDialogFragment.a(this.a, CallHelloManager.b(this.c));
                CallHelloObserver.a().a(CallHelloManager.b(this.c));
                return;
              } 
              if (helloOpenState.open_status == 4)
                AppInfo.n().post(new Runnable(this, helloOpenState) {
                      public void run() {
                        Context context;
                        String str = String.format(AppUtils.a(2131756902), new Object[] { TimeAndDateUtils.c(this.a.expire_time * 1000L) });
                        if (ActivityMgr.INST.getLastActivity() != null) {
                          Activity activity = ActivityMgr.INST.getLastActivity();
                        } else {
                          context = this.b.a;
                        } 
                        CommonAlertDialog.a(context, 0, AppUtils.a(2131755498), str, null, AppUtils.a(2131756901), null, null, null, null, false, 0, 0, false, false);
                        EventTrackGuy.b(GuyProtos.Event.VOCATIVE_MB_POP_SHOW);
                        BluedPreferences.dz();
                      }
                    }); 
            } 
          }
        }paramIRequestHost, paramBoolean);
  }
  
  public void a(Context paramContext, ToOpenListener paramToOpenListener) {
    a(paramContext, paramToOpenListener, true);
  }
  
  public void a(Context paramContext, ToOpenListener paramToOpenListener, boolean paramBoolean) {
    if (PermissionUtils.a()) {
      b(paramContext, paramToOpenListener, paramBoolean);
      return;
    } 
    CommonAlertDialog.a(paramContext, null, paramContext.getString(2131756895), paramContext.getString(2131756896), new DialogInterface.OnClickListener(this, paramContext, paramToOpenListener, paramBoolean) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            CallHelloManager.a(this.d, this.a, this.b, this.c);
          }
        }null, new DialogInterface.OnClickListener(this, paramToOpenListener) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.a(false);
          }
        }null);
  }
  
  public void a(Context paramContext, boolean paramBoolean, int paramInt) {
    HelloOpenDialogFragment.a(paramContext, paramBoolean, paramInt);
  }
  
  public void a(CallMeStatusData paramCallMeStatusData) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield b : Lcom/soft/blued/ui/find/model/CallMeStatusData;
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
    //   2	7	10	finally
  }
  
  public CallMeStatusData b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/soft/blued/ui/find/model/CallMeStatusData;
    //   6: ifnonnull -> 20
    //   9: aload_0
    //   10: new com/soft/blued/ui/find/model/CallMeStatusData
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: putfield b : Lcom/soft/blued/ui/find/model/CallMeStatusData;
    //   20: aload_0
    //   21: getfield b : Lcom/soft/blued/ui/find/model/CallMeStatusData;
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	29	finally
    //   20	25	29	finally
  }
  
  public void b(Context paramContext, ToOpenListener paramToOpenListener) {
    if (paramContext == null)
      return; 
    EventTrackGuy.b(GuyProtos.Event.VOCATIVE_BUY_SUCCESS_POP_SHOW);
    BluedAlertDialog bluedAlertDialog = CommonAlertDialog.a(paramContext, paramContext.getString(2131756888), paramContext.getString(2131756889), paramContext.getString(2131756899), new DialogInterface.OnClickListener(this, paramContext, paramToOpenListener) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            EventTrackGuy.b(GuyProtos.Event.VOCATIVE_BUY_SUCCESS_POP_OPEN_BTN_CLICK);
            this.c.a(this.a, this.b, false);
          }
        }null, 1);
    bluedAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener(this, paramToOpenListener) {
          public void onCancel(DialogInterface param1DialogInterface) {
            this.a.a(false);
          }
        });
    bluedAlertDialog.c().setGravity(1);
  }
  
  public void c() {
    Timer timer = this.d;
    if (timer != null) {
      timer.cancel();
      this.d = null;
    } 
  }
  
  public void d() {
    int i;
    if (this.b == null)
      return; 
    e();
    if (this.b.free_count == 0) {
      i = this.b.pay_count;
    } else {
      i = this.b.free_count;
    } 
    if (i == 0)
      return; 
    this.f = new Timer();
    this.f.schedule(new TimerTask(this, i) {
          public void run() {
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    CallHelloObserver.a().a(CallHelloManager.e(this.a.b), String.valueOf(this.a.a));
                    CallHelloManager.a(this.a.b, CallHelloManager.e(this.a.b) ^ true);
                  }
                });
          }
        }5000L, 5000L);
  }
  
  public void e() {
    Timer timer = this.f;
    if (timer != null) {
      timer.cancel();
      this.f = null;
    } 
  }
  
  public static interface ToOpenListener {
    void a(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\manager\CallHelloManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.blued.android.module.live_china.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.model.DialogWith6PW;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class LiveGiftPayTools {
  public static boolean a;
  
  public static DialogWith6PW b;
  
  private static final String c = LiveGiftPayTools.class.getSimpleName();
  
  static {
    a = false;
  }
  
  public static LiveGiftPayTools a() {
    return SingletonCreator.a();
  }
  
  private void a(Context paramContext, long paramLong1, String paramString, int paramInt, BackGiftStatusListener paramBackGiftStatusListener, LiveGiftModel paramLiveGiftModel, LiveZanExtraModel paramLiveZanExtraModel, PayRemaining paramPayRemaining, short paramShort, long paramLong2) {
    b();
    if (paramBackGiftStatusListener != null && paramLiveGiftModel != null) {
      if (paramLiveZanExtraModel == null)
        return; 
      LiveGiftModel liveGiftModel = new LiveGiftModel();
      try {
        liveGiftModel.sendGiftStatus = 3;
        liveGiftModel.beans = paramPayRemaining.beans;
        liveGiftModel.hit_id = paramPayRemaining.hit_id;
        liveGiftModel.hit_count = paramPayRemaining.hit_count;
        liveGiftModel.beans_count = paramPayRemaining.beans_count;
        liveGiftModel.beans_current_count = paramPayRemaining.beans_current;
        liveGiftModel.free_number = paramPayRemaining.free_number;
        liveGiftModel.bonus = paramPayRemaining.bonus;
        liveGiftModel.user_store_count = paramLiveZanExtraModel.user_store_count;
        liveGiftModel.danmu_count = paramLiveZanExtraModel.danmu_count;
        if (paramLiveZanExtraModel.join_club == 1) {
          AppMethods.d(R.string.live_fans_add_success);
          if (LiveRoomManager.a().i() != null)
            (LiveRoomManager.a().i()).fans_status = 1; 
          if (paramInt == 2)
            LiveEventBus.get("live_fans_guide_pop").post(Boolean.valueOf(true)); 
          LiveEventBus.get("live_refresh_gift_list").post(Boolean.valueOf(true));
        } 
        if (LiveRoomManager.a().i() != null && (LiveRoomManager.a().i()).fans_status == 2 && liveGiftModel.beans_count >= 6.0D) {
          Log.i("xpp", "zhi hui dian liang");
          LiveFansObserver.a().d();
        } 
        if (paramLiveGiftModel.is_join_ticket == 1)
          if (paramInt == 1) {
            EventTrackLive.a(LiveProtos.Event.LIVE_SEND_FANS_CLUB_TICKET, LiveProtos.Source.FANS_CLUB_PAGE, String.valueOf(paramLong1), paramString);
          } else if (paramInt == 2) {
            EventTrackLive.a(LiveProtos.Event.LIVE_SEND_FANS_CLUB_TICKET, LiveProtos.Source.GIFT_PAGE, String.valueOf(paramLong1), paramString);
          }  
        paramBackGiftStatusListener.a(paramLiveGiftModel, liveGiftModel, paramLiveZanExtraModel.box);
        Logger.b(c, new Object[] { "可以发礼物===", Integer.valueOf(3) });
        boolean bool = TextUtils.isEmpty(paramLiveGiftModel.contents);
        if (!bool || paramLiveGiftModel.effect != null) {
          Logger.a("ddrb", new Object[] { "弹幕消息，不模拟发消息" });
          return;
        } 
        if (paramLiveGiftModel.selectNumModel != null && paramLiveGiftModel.selectNumModel.count > 1) {
          paramLiveGiftModel.hit_batch = 1;
          paramLiveGiftModel.hit_count = paramLiveGiftModel.selectNumModel.count;
        } else {
          paramLiveGiftModel.hit_batch = 0;
          if (paramLiveGiftModel.double_hit == 1)
            paramLiveGiftModel.hit_count++; 
        } 
        Logger.a("ddrb", new Object[] { "liveGiftModel.hit_batch = ", Integer.valueOf(paramLiveGiftModel.hit_batch) });
        Logger.a("ddrb", new Object[] { "liveGiftModel.hit_count = ", Integer.valueOf(paramLiveGiftModel.hit_count) });
        Logger.a("ddrb", new Object[] { "liveGiftModel.hit_id = ", Long.valueOf(paramLiveGiftModel.hit_id) });
        paramLiveGiftModel.beans_count = paramPayRemaining.beans_count;
        paramLiveGiftModel.beans_current_count = paramPayRemaining.beans_current;
        if (paramLiveZanExtraModel.box != null && paramLiveZanExtraModel.box.size() > 0) {
          liveGiftModel = paramLiveZanExtraModel.box.get(0);
          if (liveGiftModel.ops == 4) {
            paramLiveGiftModel.ops = liveGiftModel.ops;
            paramLiveGiftModel.box_image = liveGiftModel.images_static;
          } 
        } 
        paramLiveGiftModel.animation = paramPayRemaining.animation;
        Logger.a("drb", new Object[] { "gift success type_name  = ", paramLiveGiftModel.type_name });
        LiveMsgSendManager.a().a(paramLiveGiftModel);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  public static void a(Context paramContext, IRequestHost paramIRequestHost) {
    DialogWith6PW dialogWith6PW = b;
    if (dialogWith6PW != null && dialogWith6PW.a != null && b.a.isShowing())
      return; 
    b = CommonAlertDialog.a(paramContext, paramContext.getResources().getString(R.string.Live_SendPresent_resetPayPassword), paramContext.getResources().getString(R.string.live_set_6_num), true, new CommonAlertDialog.PWDListener(paramIRequestHost) {
          public void a(String param1String, boolean param1Boolean, DialogWith6PW param1DialogWith6PW) {
            LiveRoomInfo.a().a(param1String, param1Boolean, this.a);
          }
        }null);
  }
  
  private void a(Context paramContext, BackGiftStatusListener paramBackGiftStatusListener, IRequestHost paramIRequestHost, LiveGiftModel paramLiveGiftModel) {
    b();
    AppInfo.n().post(new Runnable(this, paramIRequestHost, paramContext, paramLiveGiftModel, paramBackGiftStatusListener) {
          public void run() {
            if (LiveGiftPayTools.a)
              return; 
            IRequestHost iRequestHost = this.a;
            if (iRequestHost != null) {
              if (!iRequestHost.isActive())
                return; 
              String str2 = this.b.getResources().getString(R.string.Live_SendPresent_notEnoughWandou);
              String str1 = str2;
              if (this.c.effect != null) {
                str1 = str2;
                if (this.c.effect.size() > 0)
                  str1 = this.b.getResources().getString(R.string.Live_effect_not_enough); 
              } 
              LiveGiftPayTools.a = true;
              Context context = this.b;
              CommonAlertDialog.a(context, null, "", str1, context.getResources().getString(R.string.cancel), this.b.getResources().getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      if (this.a.d != null)
                        this.a.d.a(); 
                      LiveRoomInfo.a().a(this.a.b, 2);
                      LiveGiftPayTools.a = false;
                    }
                  }new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      LiveGiftPayTools.a = false;
                    }
                  },  new DialogInterface.OnCancelListener(this) {
                    public void onCancel(DialogInterface param2DialogInterface) {
                      LiveGiftPayTools.a = false;
                    }
                  },  true);
            } 
          }
        });
  }
  
  private void a(BackGiftStatusListener paramBackGiftStatusListener, LiveGiftModel paramLiveGiftModel) {
    b();
    if (paramBackGiftStatusListener != null) {
      if (paramLiveGiftModel == null)
        return; 
      LiveGiftModel liveGiftModel = new LiveGiftModel();
      liveGiftModel.sendGiftStatus = 2;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("liveGiftModel = ");
      stringBuilder.append(paramLiveGiftModel.errorMessage);
      Log.v("pk", stringBuilder.toString());
      paramBackGiftStatusListener.a(paramLiveGiftModel, liveGiftModel, null);
      Logger.b(c, new Object[] { "取消发礼物===", Integer.valueOf(2) });
    } 
  }
  
  public static void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      BluedEntityA bluedEntityA = (BluedEntityA)AppInfo.f().fromJson(paramString, (new TypeToken<BluedEntityA<PayRemaining>>() {
          
          }).getType());
      if (bluedEntityA.hasData()) {
        String str = ((PayRemaining)bluedEntityA.data.get(0)).token;
        if (!TextUtils.isEmpty(str)) {
          LiveRoomPreferences.c(str);
          return;
        } 
      } 
    } catch (JsonSyntaxException jsonSyntaxException) {
      jsonSyntaxException.printStackTrace();
    } 
  }
  
  public static void b() {
    DialogWith6PW dialogWith6PW = b;
    if (dialogWith6PW != null && dialogWith6PW.a != null)
      b.a.dismiss(); 
  }
  
  public void a(Context paramContext, short paramShort, long paramLong, int paramInt1, IRequestHost paramIRequestHost, LiveGiftModel paramLiveGiftModel, String paramString1, String paramString2, int paramInt2, BackGiftStatusListener paramBackGiftStatusListener) {
    if (paramLiveGiftModel == null || paramBackGiftStatusListener == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkGiftPayStatus:  mSessionId:");
    stringBuilder.append(paramLong);
    stringBuilder.append(", ticketSource: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", liveGiftModel:");
    stringBuilder.append(paramLiveGiftModel.toString());
    stringBuilder.append(", target_uid:");
    stringBuilder.append(paramString1);
    stringBuilder.append(", discount_id:");
    stringBuilder.append(paramString2);
    stringBuilder.append(", giftCount:");
    stringBuilder.append(paramInt2);
    LogUtils.c(stringBuilder.toString());
    try {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
      LiveRoomHttpUtils.a(paramString1, stringBuilder.toString(), paramLiveGiftModel, paramString2, "", LiveRoomPreferences.b(""), false, paramInt2, new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(this, paramContext, paramLong, paramString1, paramInt1, paramBackGiftStatusListener, paramLiveGiftModel, paramShort, paramIRequestHost, paramString2, paramInt2) {
            public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
              LiveGiftPayTools.a(param1String);
              Pair pair = BluedHttpUtils.a(param1Throwable, param1Int, param1String);
              if (((Integer)pair.first).intValue() == 0)
                return; 
              param1Int = ((Integer)pair.first).intValue();
              if (param1Int != 4221002) {
                if (param1Int != 4221005) {
                  if (param1Int != 4221008) {
                    if (!TextUtils.isEmpty((CharSequence)pair.second))
                      AppMethods.a((CharSequence)pair.second); 
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("liveGiftModel default = ");
                    stringBuilder.append((String)pair.second);
                    Log.v("pk", stringBuilder.toString());
                    this.f.errorMessage = (String)pair.second;
                    LiveGiftPayTools.a(this.k, this.e, this.f);
                    return;
                  } 
                  LiveGiftPayTools.a(this.k, this.e, this.f);
                  LiveGiftPayTools.a(this.k, this.a, this.e, this.h, this.f);
                  return;
                } 
                AppInfo.n().post(new Runnable(this) {
                      public void run() {
                        if (LiveGiftPayTools.b != null && LiveGiftPayTools.b.a != null && LiveGiftPayTools.b.a.isShowing())
                          return; 
                        String str1 = this.a.a.getResources().getString(R.string.Live_SendPresent_verifyPassword);
                        String str2 = this.a.a.getResources().getString(R.string.Live_SendPresent_verifyPasswordText);
                        LiveGiftPayTools.b = CommonAlertDialog.a(this.a.a, str1, str2, true, false, true, LiveFloatManager.a().B() ^ true, new CommonAlertDialog.PWDListener(this) {
                              public void a(String param3String, boolean param3Boolean, DialogWith6PW param3DialogWith6PW) {
                                if (!TextUtils.isEmpty(param3String)) {
                                  String str1;
                                  try {
                                    param3String = BluedHttpTools.b(param3String);
                                  } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                                    noSuchAlgorithmException.printStackTrace();
                                    str1 = "";
                                  } 
                                  String str2 = this.a.a.c;
                                  StringBuilder stringBuilder = new StringBuilder();
                                  stringBuilder.append(this.a.a.b);
                                  stringBuilder.append("");
                                  LiveRoomHttpUtils.a(str2, stringBuilder.toString(), this.a.a.f, this.a.a.i, str1, "", param3Boolean, this.a.a.j, new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(this) {
                                        public void onFailure(Throwable param4Throwable, int param4Int, String param4String) {
                                          super.onFailure(param4Throwable, param4Int, param4String);
                                          LiveGiftPayTools.a(param4String);
                                          Pair pair = BluedHttpUtils.a(param4Throwable, param4Int, param4String);
                                          int i = ((Integer)pair.first).intValue();
                                          if (i != 4221004) {
                                            if (i != 4221008) {
                                              if (!TextUtils.isEmpty((CharSequence)pair.second))
                                                AppMethods.a((CharSequence)pair.second); 
                                              this.a.a.a.f.errorMessage = (String)pair.second;
                                              LiveGiftPayTools.a(this.a.a.a.k, this.a.a.a.e, this.a.a.a.f);
                                              BluedHttpUtils.b(param4Throwable, param4Int, param4String);
                                              return;
                                            } 
                                            LiveGiftPayTools.a(this.a.a.a.k, this.a.a.a.e, this.a.a.a.f);
                                            LiveGiftPayTools.a(this.a.a.a.k, this.a.a.a.a, this.a.a.a.e, this.a.a.a.h, this.a.a.a.f);
                                            return;
                                          } 
                                          if (!TextUtils.isEmpty((CharSequence)pair.second))
                                            AppInfo.n().post(new Runnable(this, pair) {
                                                  public void run() {
                                                    if (LiveGiftPayTools.b != null && LiveGiftPayTools.b.c != null && LiveGiftPayTools.b.b != null) {
                                                      LiveGiftPayTools.b.c.setTextColor(this.b.a.a.a.a.getResources().getColor(R.color.biao_live_bug_gift_paycode_error));
                                                      LiveGiftPayTools.b.c.setText((CharSequence)this.a.second);
                                                      LiveGiftPayTools.b.b.a();
                                                    } 
                                                  }
                                                }); 
                                        }
                                        
                                        public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> param4BluedEntity) {
                                          if (param4BluedEntity != null && param4BluedEntity.hasData()) {
                                            PayRemaining payRemaining = param4BluedEntity.data.get(0);
                                            String str = payRemaining.token;
                                            if (!TextUtils.isEmpty(str))
                                              LiveRoomPreferences.c(str); 
                                            LiveZanExtraModel liveZanExtraModel = (LiveZanExtraModel)param4BluedEntity.extra;
                                            Logger.a("ddrb", new Object[] { "弹出输入密码框：giftSuccess" });
                                            AppInfo.n().post(new Runnable(this) {
                                                  public void run() {
                                                    LiveSetDataObserver.a().d(0);
                                                  }
                                                });
                                            LiveGiftPayTools.a(this.a.a.a.k, this.a.a.a.a, this.a.a.a.b, this.a.a.a.c, this.a.a.a.d, this.a.a.a.e, this.a.a.a.f, liveZanExtraModel, payRemaining, this.a.a.a.g, this.a.a.a.b);
                                            return;
                                          } 
                                          LiveGiftPayTools.a(this.a.a.a.k, this.a.a.a.e, this.a.a.a.f);
                                        }
                                      }this.a.a.h);
                                } 
                              }
                            }new DialogInterface.OnCancelListener(this) {
                              public void onCancel(DialogInterface param3DialogInterface) {
                                LiveGiftPayTools.a(this.a.a.k, this.a.a.e, this.a.a.f);
                              }
                            });
                      }
                    });
                return;
              } 
              LiveGiftPayTools.a(this.k, this.e, this.f);
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      LiveGiftPayTools.a(this.a.a, this.a.h);
                    }
                  });
            }
            
            public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> param1BluedEntity) {
              if (param1BluedEntity.hasData()) {
                PayRemaining payRemaining = param1BluedEntity.data.get(0);
                LiveZanExtraModel liveZanExtraModel = (LiveZanExtraModel)param1BluedEntity.extra;
                Logger.a("ddrb", new Object[] { "giftSuccess" });
                LiveGiftPayTools liveGiftPayTools = this.k;
                Context context = this.a;
                long l = this.b;
                LiveGiftPayTools.a(liveGiftPayTools, context, l, this.c, this.d, this.e, this.f, liveZanExtraModel, payRemaining, this.g, l);
                return;
              } 
              LiveGiftPayTools.a(this.k, this.e, this.f);
            }
          }paramIRequestHost);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramBackGiftStatusListener, paramLiveGiftModel);
      return;
    } 
  }
  
  public void a(Context paramContext, short paramShort, long paramLong, IRequestHost paramIRequestHost, LiveGiftModel paramLiveGiftModel, String paramString1, String paramString2, int paramInt, BackGiftStatusListener paramBackGiftStatusListener) {
    a(paramContext, paramShort, paramLong, 0, paramIRequestHost, paramLiveGiftModel, paramString1, paramString2, paramInt, paramBackGiftStatusListener);
  }
  
  public static interface BackGiftStatusListener {
    void a();
    
    void a(LiveGiftModel param1LiveGiftModel1, LiveGiftModel param1LiveGiftModel2, List<LiveGiftModel> param1List);
  }
  
  static class SingletonCreator {
    private static final LiveGiftPayTools a = new LiveGiftPayTools();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_chin\\utils\LiveGiftPayTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
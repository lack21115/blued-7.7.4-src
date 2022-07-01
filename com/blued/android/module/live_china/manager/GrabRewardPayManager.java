package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.model.DecryptJson;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.model.LiveRewardDescribe;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.model.DialogWith6PW;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class GrabRewardPayManager {
  public DialogWith6PW a;
  
  private boolean b = false;
  
  private BackGiftStatusListener c;
  
  public static GrabRewardPayManager a() {
    return SingletonCreator.a();
  }
  
  private void a(Context paramContext, IRequestHost paramIRequestHost, boolean paramBoolean1, LiveRewardConfigModel paramLiveRewardConfigModel, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, BackGiftStatusListener paramBackGiftStatusListener) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/paymentcode/");
    stringBuilder.append(1);
    String str2 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (paramBoolean1) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    map.put("verify", str1);
    map.put("type", "set");
    try {
      map.put("code", BluedHttpTools.b(paramString3));
      str1 = AesCrypto.b(AppInfo.f().toJson(map));
      map = BluedHttpTools.a();
      map.put("_", str1);
      HttpManager.b(str2, (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<BasePayRemaining>>(this, paramIRequestHost, paramContext, paramIRequestHost, paramLiveRewardConfigModel, paramString1, paramString2, paramBoolean2, paramString3, paramBackGiftStatusListener) {
            protected void a(BluedEntityA<BasePayRemaining> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
                if (BluedHttpUtils.a(param1BluedEntityA.code, param1BluedEntityA.message)) {
                  BasePayRemaining basePayRemaining = (BasePayRemaining)param1BluedEntityA.getSingleData();
                  try {
                    String str = AesCrypto.c(basePayRemaining._);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("dataStr = ");
                    stringBuilder.append(str);
                    Logger.c("pwd", new Object[] { stringBuilder.toString() });
                    LiveBasePreferences.b(((DecryptJson)AppInfo.f().fromJson(str, DecryptJson.class)).token);
                    this.i.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
                    return;
                  } catch (Exception exception) {
                    return;
                  } 
                } 
                AppMethods.d(R.string.get_user_info_fail);
                return;
              } 
              AppMethods.d(R.string.get_user_info_fail);
            }
          }paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void a(Context paramContext, BackGiftStatusListener paramBackGiftStatusListener, IRequestHost paramIRequestHost) {
    b();
    AppInfo.n().post(new Runnable(this, paramIRequestHost, paramContext, paramBackGiftStatusListener) {
          public void run() {
            if (GrabRewardPayManager.a(this.d))
              return; 
            IRequestHost iRequestHost = this.a;
            if (iRequestHost != null) {
              if (!iRequestHost.isActive())
                return; 
              GrabRewardPayManager.a(this.d, true);
              Context context = this.b;
              CommonAlertDialog.a(context, null, "", context.getResources().getString(R.string.Live_SendPresent_notEnoughWandou), this.b.getResources().getString(R.string.cancel), this.b.getResources().getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      if (this.a.c != null)
                        this.a.c.a(); 
                      LiveRoomInfo.a().a(this.a.b, 2);
                      GrabRewardPayManager.a(this.a.d, false);
                    }
                  }new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      GrabRewardPayManager.a(this.a.d, this.a.c, "");
                      GrabRewardPayManager.a(this.a.d, false);
                    }
                  }new DialogInterface.OnCancelListener(this) {
                    public void onCancel(DialogInterface param2DialogInterface) {
                      GrabRewardPayManager.a(this.a.d, false);
                    }
                  }true);
            } 
          }
        });
  }
  
  private void a(Context paramContext, BackGiftStatusListener paramBackGiftStatusListener, PayRemaining paramPayRemaining, LiveRewardConfigModel paramLiveRewardConfigModel, LiveRewardDescribe paramLiveRewardDescribe) {
    b();
    if (paramBackGiftStatusListener == null)
      return; 
    paramPayRemaining.sendGiftStatus = 3;
    paramBackGiftStatusListener.a(paramPayRemaining, paramLiveRewardDescribe, paramLiveRewardConfigModel);
  }
  
  private void a(BackGiftStatusListener paramBackGiftStatusListener, String paramString) {
    b();
    if (paramBackGiftStatusListener == null)
      return; 
    PayRemaining payRemaining = new PayRemaining();
    payRemaining.sendGiftStatus = 2;
    payRemaining.errorMessage = paramString;
    paramBackGiftStatusListener.a(payRemaining, null, null);
  }
  
  private void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      BluedEntityA bluedEntityA = (BluedEntityA)AppInfo.f().fromJson(paramString, (new TypeToken<BluedEntityA<PayRemaining>>(this) {
          
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
  
  private void b() {
    DialogWith6PW dialogWith6PW = this.a;
    if (dialogWith6PW != null && dialogWith6PW.a != null)
      this.a.a.dismiss(); 
  }
  
  public void a(Context paramContext, IRequestHost paramIRequestHost, LiveRewardConfigModel paramLiveRewardConfigModel, String paramString1, String paramString2, boolean paramBoolean, BackGiftStatusListener paramBackGiftStatusListener) {
    DialogWith6PW dialogWith6PW = this.a;
    if (dialogWith6PW != null && dialogWith6PW.a != null && this.a.a.isShowing())
      return; 
    this.a = CommonAlertDialog.a(paramContext, paramContext.getResources().getString(R.string.Live_SendPresent_resetPayPassword), paramContext.getResources().getString(R.string.live_set_6_num), true, new CommonAlertDialog.PWDListener(this, paramContext, paramIRequestHost, paramLiveRewardConfigModel, paramString1, paramString2, paramBoolean, paramBackGiftStatusListener) {
          public void a(String param1String, boolean param1Boolean, DialogWith6PW param1DialogWith6PW) {
            GrabRewardPayManager.a(this.h, this.a, this.b, param1Boolean, this.c, this.d, this.e, this.f, param1String, this.g);
          }
        }new DialogInterface.OnCancelListener(this, paramBackGiftStatusListener) {
          public void onCancel(DialogInterface param1DialogInterface) {
            GrabRewardPayManager.a(this.b, this.a, "");
          }
        });
  }
  
  public void a(Context paramContext, IRequestHost paramIRequestHost, LiveRewardConfigModel paramLiveRewardConfigModel, String paramString1, String paramString2, boolean paramBoolean, String paramString3, BackGiftStatusListener paramBackGiftStatusListener) {
    this.c = paramBackGiftStatusListener;
    try {
      LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveRewardDescribe>>(this, paramContext, paramBackGiftStatusListener, paramLiveRewardConfigModel, paramIRequestHost, paramString1, paramString2, paramBoolean, paramString3) {
            public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
              GrabRewardPayManager.a(this.i, param1String);
              Pair pair = BluedHttpUtils.a(param1Throwable, param1Int, param1String);
              if (((Integer)pair.first).intValue() == 0)
                return; 
              int i = ((Integer)pair.first).intValue();
              if (i != 4221002) {
                if (i != 4221005) {
                  if (i != 4221008) {
                    BluedHttpUtils.b(param1Throwable, param1Int, param1String);
                    GrabRewardPayManager.a(this.i, this.b, (String)pair.second);
                    return;
                  } 
                  GrabRewardPayManager.a(this.i, this.a, this.b, this.d);
                  return;
                } 
                AppInfo.n().post(new Runnable(this) {
                      public void run() {
                        if (this.a.i.a != null && this.a.i.a.a != null && this.a.i.a.a.isShowing())
                          return; 
                        String str1 = this.a.a.getResources().getString(R.string.Live_SendPresent_verifyPassword);
                        String str2 = this.a.a.getResources().getString(R.string.Live_SendPresent_verifyPasswordText);
                        this.a.i.a = CommonAlertDialog.a(this.a.a, str1, str2, true, false, true, LiveFloatManager.a().B() ^ true, false, new CommonAlertDialog.PWDListener(this) {
                              public void a(String param3String, boolean param3Boolean, DialogWith6PW param3DialogWith6PW) {
                                if (!TextUtils.isEmpty(param3String)) {
                                  String str;
                                  try {
                                    param3String = BluedHttpTools.b(param3String);
                                  } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                                    noSuchAlgorithmException.printStackTrace();
                                    str = "";
                                  } 
                                  LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveRewardDescribe>>(this) {
                                        public void onFailure(Throwable param4Throwable, int param4Int, String param4String) {
                                          GrabRewardPayManager.a(this.a.a.a.i, param4String);
                                          Pair pair = BluedHttpUtils.a(param4Throwable, param4Int, param4String);
                                          int i = ((Integer)pair.first).intValue();
                                          if (i != 4221004) {
                                            if (i != 4221008) {
                                              GrabRewardPayManager.a(this.a.a.a.i, this.a.a.a.b, (String)pair.second);
                                              BluedHttpUtils.b(param4Throwable, param4Int, param4String);
                                              return;
                                            } 
                                            GrabRewardPayManager.a(this.a.a.a.i, this.a.a.a.a, this.a.a.a.b, this.a.a.a.d);
                                            return;
                                          } 
                                          if (!TextUtils.isEmpty((CharSequence)pair.second))
                                            AppInfo.n().post(new Runnable(this, pair) {
                                                  public void run() {
                                                    if (this.b.a.a.a.i.a != null && this.b.a.a.a.i.a.c != null && this.b.a.a.a.i.a.b != null) {
                                                      this.b.a.a.a.i.a.c.setTextColor(this.b.a.a.a.a.getResources().getColor(R.color.biao_live_bug_gift_paycode_error));
                                                      this.b.a.a.a.i.a.c.setText((CharSequence)this.a.second);
                                                      this.b.a.a.a.i.a.b.a();
                                                    } 
                                                  }
                                                }); 
                                        }
                                        
                                        public void onUIUpdate(BluedEntity<PayRemaining, LiveRewardDescribe> param4BluedEntity) {
                                          if (param4BluedEntity.hasData()) {
                                            PayRemaining payRemaining = param4BluedEntity.data.get(0);
                                            String str = payRemaining.token;
                                            if (!TextUtils.isEmpty(str))
                                              LiveRoomPreferences.c(str); 
                                            LiveRewardDescribe liveRewardDescribe = (LiveRewardDescribe)param4BluedEntity.extra;
                                            GrabRewardPayManager.a(this.a.a.a.i, this.a.a.a.a, this.a.a.a.b, payRemaining, this.a.a.a.c, liveRewardDescribe);
                                            return;
                                          } 
                                          GrabRewardPayManager.a(this.a.a.a.i, this.a.a.a.b, "");
                                        }
                                      }this.a.a.c, this.a.a.e, this.a.a.f, str, "", param3Boolean, this.a.a.g, this.a.a.h, this.a.a.d);
                                } 
                              }
                            }new DialogInterface.OnCancelListener(this) {
                              public void onCancel(DialogInterface param3DialogInterface) {
                                GrabRewardPayManager.a(this.a.a.i, this.a.a.b, "");
                              }
                            });
                      }
                    });
                return;
              } 
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      this.a.i.a(this.a.a, this.a.d, this.a.c, this.a.e, this.a.f, this.a.g, this.a.b);
                    }
                  });
            }
            
            public void onUIUpdate(BluedEntity<PayRemaining, LiveRewardDescribe> param1BluedEntity) {
              if (param1BluedEntity.hasData()) {
                PayRemaining payRemaining = param1BluedEntity.data.get(0);
                LiveRewardDescribe liveRewardDescribe = (LiveRewardDescribe)param1BluedEntity.extra;
                GrabRewardPayManager.a(this.i, this.a, this.b, payRemaining, this.c, liveRewardDescribe);
                return;
              } 
              GrabRewardPayManager.a(this.i, this.b, "");
            }
          }paramLiveRewardConfigModel, paramString1, paramString2, "", LiveRoomPreferences.b(""), false, paramBoolean, paramString3, paramIRequestHost);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramBackGiftStatusListener, "");
      return;
    } 
  }
  
  public static interface BackGiftStatusListener {
    void a();
    
    void a(PayRemaining param1PayRemaining, LiveRewardDescribe param1LiveRewardDescribe, LiveRewardConfigModel param1LiveRewardConfigModel);
  }
  
  static class SingletonCreator {
    private static final GrabRewardPayManager a = new GrabRewardPayManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\GrabRewardPayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
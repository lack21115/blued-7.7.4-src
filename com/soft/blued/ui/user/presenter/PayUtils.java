package com.soft.blued.ui.user.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.das.vip.VipProtos;
import com.huawei.android.hms.agent.common.ActivityMgr;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.ShareCoreConstants;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.pay.alipay.AlipayUtils;
import com.soft.blued.ui.pay.alipay.Result;
import com.soft.blued.ui.pay.model.PayOrderInfo;
import com.soft.blued.ui.user.model.GiftPayRemaining;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.dialog.BluedAlertDialog;
import com.soft.blued.view.tip.model.DialogWith6PW;
import com.soft.blued.wxapi.WXPayEntryActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.security.NoSuchAlgorithmException;
import java.util.Timer;
import java.util.TimerTask;

public class PayUtils {
  public Context a;
  
  public String b;
  
  public IRequestHost c;
  
  public String d;
  
  public String e;
  
  public String f;
  
  public String g;
  
  public int h;
  
  public DialogWith6PW i;
  
  GiftPayRemaining j;
  
  private IWXAPI k;
  
  public PayUtils(Context paramContext, String paramString, IRequestHost paramIRequestHost) {
    this.a = paramContext;
    this.b = paramString;
    this.c = paramIRequestHost;
    this.k = WXAPIFactory.createWXAPI(this.a, ShareCoreConstants.a(), false);
    this.k.registerApp(ShareCoreConstants.a());
  }
  
  public static void a(Context paramContext, int paramInt, String paramString) {
    a(paramContext, paramInt, paramString, VipProtos.FromType.UNKNOWN_FROM);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, VipProtos.FromType paramFromType) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #5
    //   3: iload_1
    //   4: ifle -> 10
    //   7: goto -> 179
    //   10: iload #5
    //   12: istore_1
    //   13: iload_3
    //   14: iflt -> 179
    //   17: invokestatic a : ()Lcom/soft/blued/user/ExperimentConfig;
    //   20: invokevirtual b : ()Lcom/soft/blued/ui/login_register/model/PayExperimentConfigModel;
    //   23: getfield switch_buy_vip_path : I
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq -> 106
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq -> 101
    //   37: iload_1
    //   38: iconst_4
    //   39: if_icmpeq -> 89
    //   42: iload_3
    //   43: iconst_4
    //   44: if_icmpeq -> 101
    //   47: iload_3
    //   48: bipush #6
    //   50: if_icmpeq -> 101
    //   53: iload_3
    //   54: bipush #11
    //   56: if_icmpeq -> 101
    //   59: iload_3
    //   60: bipush #13
    //   62: if_icmpeq -> 101
    //   65: iload_3
    //   66: bipush #22
    //   68: if_icmpeq -> 101
    //   71: iload_3
    //   72: bipush #26
    //   74: if_icmpeq -> 101
    //   77: iload_3
    //   78: bipush #27
    //   80: if_icmpeq -> 101
    //   83: iload #5
    //   85: istore_1
    //   86: goto -> 179
    //   89: iload_3
    //   90: bipush #21
    //   92: if_icmpne -> 101
    //   95: iload #5
    //   97: istore_1
    //   98: goto -> 179
    //   101: iconst_2
    //   102: istore_1
    //   103: goto -> 179
    //   106: iload_3
    //   107: iconst_4
    //   108: if_icmpeq -> 101
    //   111: iload_3
    //   112: bipush #6
    //   114: if_icmpeq -> 101
    //   117: iload_3
    //   118: bipush #24
    //   120: if_icmpeq -> 101
    //   123: iload_3
    //   124: bipush #21
    //   126: if_icmpeq -> 101
    //   129: iload_3
    //   130: bipush #22
    //   132: if_icmpeq -> 101
    //   135: iload_3
    //   136: bipush #26
    //   138: if_icmpeq -> 101
    //   141: iload_3
    //   142: bipush #27
    //   144: if_icmpeq -> 101
    //   147: iload_3
    //   148: tableswitch default -> 176, 11 -> 101, 12 -> 101, 13 -> 101
    //   176: iload #5
    //   178: istore_1
    //   179: aload_0
    //   180: iload_1
    //   181: aload_2
    //   182: iload_3
    //   183: aload #4
    //   185: iconst_0
    //   186: invokestatic a : (Landroid/content/Context;ILjava/lang/String;ILcom/blued/das/vip/VipProtos$FromType;Z)V
    //   189: return
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, VipProtos.FromType paramFromType) {
    a(paramContext, 0, paramString, paramInt, paramFromType);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, VipProtos.FromType paramFromType) {
    a(paramContext, 0, paramString, paramInt, paramFromType);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    if (paramContext instanceof FragmentActivity) {
      Lifecycle lifecycle = ((FragmentActivity)paramContext).getLifecycle();
      lifecycle.addObserver(new LifecycleObserver(paramContext, paramString1, paramString2, lifecycle) {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
              this.d.removeObserver(this);
            }
            
            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public void onStop() {
              Activity activity;
              Log.v("drb", "onStop");
              Context context = this.a;
              if (ActivityMgr.INST.getLastActivity() != null)
                activity = ActivityMgr.INST.getLastActivity(); 
              BluedAlertDialog bluedAlertDialog = CommonAlertDialog.a((Context)activity, activity.getString(2131756451), activity.getString(2131756449), activity.getString(2131756450), new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      WebViewShowInfoFragment.show((Context)ActivityMgr.INST.getLastActivity(), H5Url.a(52, new Object[] { this.a.b, this.a.c }), 0);
                    }
                  }null, 1);
              bluedAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener(this) {
                    public void onCancel(DialogInterface param2DialogInterface) {}
                  });
              bluedAlertDialog.c().setGravity(1);
            }
          });
    } 
  }
  
  public BluedUIHttpResponse a() {
    return new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(this, this.c) {
        protected void a(BluedEntityA<PayRemaining> param1BluedEntityA) {
          try {
            String str = AesCrypto.c(((PayRemaining)param1BluedEntityA.data.get(0))._);
            PayOrderInfo.AlipayOrder alipayOrder = (PayOrderInfo.AlipayOrder)AppInfo.f().fromJson(str, PayOrderInfo.AlipayOrder.class);
            AlipayUtils.a(this.a.a, new Handler(this) {
                  public void handleMessage(Message param2Message) {
                    try {
                      Result result = new Result((String)param2Message.obj);
                      if (param2Message.what != 1)
                        return; 
                      String str = result.a();
                      if (str.equals("9000")) {
                        (new Timer()).schedule(new TimerTask(this, result) {
                              public void run() {
                                WXPayEntryActivity.a(this.b.a.a.a, this.a.toString());
                              }
                            }200L);
                        return;
                      } 
                      if (str.equals("6001")) {
                        VIPBuyResultObserver.a().a(0, false);
                        AppMethods.a("支付取消");
                        return;
                      } 
                      VIPBuyResultObserver.a().a(0, false);
                      AppMethods.a(this.a.a.a.getResources().getString(2131755151));
                      return;
                    } catch (Exception exception) {
                      VIPBuyResultObserver.a().a(0, false);
                      AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                      return;
                    } 
                  }
                }alipayOrder.sign_type, alipayOrder.info, alipayOrder.sign);
            return;
          } catch (Exception exception) {
            VIPBuyResultObserver.a().a(0, false);
            AppMethods.a(AppInfo.d().getResources().getString(2131756082));
            return;
          } 
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          VIPBuyResultObserver.a().a(0, false);
          switch (param1Int) {
            default:
              return super.onUIFailure(param1Int, param1String);
            case 4433005:
              ToastUtils.a(AppInfo.d().getString(2131758075));
              return true;
            case 4433004:
              ToastUtils.a(AppInfo.d().getString(2131757985));
              return true;
            case 4433003:
              break;
          } 
          ToastUtils.a(AppInfo.d().getString(2131757995));
          return true;
        }
        
        public void onUIFinish() {
          super.onUIFinish();
        }
        
        public void onUIStart() {
          super.onUIStart();
        }
      };
  }
  
  public void a(int paramInt1, GoodsOptionBasic paramGoodsOptionBasic, int paramInt2) {
    if (paramGoodsOptionBasic != null) {
      if (paramInt1 != 1)
        if (paramInt1 != 2) {
          if (paramInt1 != 4)
            return; 
        } else {
          if (c()) {
            PayHttpUtils.a(b(), this.c, 2, paramGoodsOptionBasic.id, this.b, this.e, this.d, this.f, this.g, this.h);
            return;
          } 
          return;
        }  
      PayHttpUtils.a(a(), this.c, paramInt1, paramGoodsOptionBasic.id, this.b, this.e, this.d, this.f, this.g, this.h);
    } 
  }
  
  public void a(Context paramContext, GoodsOptionBasic paramGoodsOptionBasic, String paramString1, boolean paramBoolean, String paramString2, String paramString3) {
    BluedUIHttpResponse<BluedEntityA<GiftPayRemaining>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<GiftPayRemaining>>(this, this.c, paramGoodsOptionBasic, paramString3, paramContext) {
        protected void a(BluedEntityA<GiftPayRemaining> param1BluedEntityA) {
          if (this.d.i != null)
            this.d.i.a.dismiss(); 
          if (param1BluedEntityA.hasData()) {
            this.d.j = param1BluedEntityA.data.get(0);
            if (!TextUtils.isEmpty(this.d.j.token))
              BluedPreferences.V(this.d.j.token); 
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    if (this.a.d.j.lucky_list != null && this.a.d.j.lucky_list.size() > 0) {
                      FuGiftListEvent fuGiftListEvent = new FuGiftListEvent();
                      fuGiftListEvent.a = this.a.d.j.lucky_list;
                      LiveEventBus.get("buy_fu", FuGiftListEvent.class).post(fuGiftListEvent);
                    } 
                  }
                }500L);
          } 
        }
        
        public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
          LiveGiftPayTools.a(param1String2);
          Pair pair = BluedHttpUtils.a(null, param1Int, param1String2);
          if (((Integer)pair.first).intValue() == 0)
            return super.onUIFailure(param1Int, param1String1, param1String2); 
          if (param1Int != 4221002) {
            if (param1Int != 4221008) {
              switch (param1Int) {
                default:
                  switch (param1Int) {
                    default:
                      return true;
                    case 4433007:
                      ToastUtils.a(AppInfo.d().getString(2131757993));
                    case 4433006:
                      ToastUtils.a(AppInfo.d().getString(2131757994));
                    case 4433005:
                      ToastUtils.a(AppInfo.d().getString(2131758075));
                    case 4433004:
                      ToastUtils.a(AppInfo.d().getString(2131757985));
                    case 4433003:
                      break;
                  } 
                  ToastUtils.a(AppInfo.d().getString(2131757995));
                case 4221005:
                  AppInfo.n().post(new Runnable(this) {
                        public void run() {
                          if (this.a.d.i != null && this.a.d.i.a != null && this.a.d.i.a.isShowing())
                            return; 
                          String str1 = this.a.d.a.getResources().getString(2131755031);
                          String str2 = this.a.d.a.getResources().getString(2131755032);
                          this.a.d.i = CommonAlertDialog.a(this.a.d.a, str1, str2, true, false, true, true, new CommonAlertDialog.PWDListener(this) {
                                public void a(String param3String, boolean param3Boolean, DialogWith6PW param3DialogWith6PW) {
                                  if (!TextUtils.isEmpty(param3String)) {
                                    String str;
                                    try {
                                      param3String = BluedHttpTools.b(param3String);
                                    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                                      noSuchAlgorithmException.printStackTrace();
                                      str = "";
                                    } 
                                    this.a.a.d.a(this.a.a.d.a, this.a.a.a, str, param3Boolean, "", this.a.a.b);
                                  } 
                                }
                              }null);
                        }
                      });
                case 4221004:
                  break;
              } 
              if (!TextUtils.isEmpty((CharSequence)pair.second))
                AppInfo.n().post(new Runnable(this, pair) {
                      public void run() {
                        if (this.b.d.i != null && this.b.d.i.c != null && this.b.d.i.b != null) {
                          this.b.d.i.c.setTextColor(this.b.d.a.getResources().getColor(2131099723));
                          this.b.d.i.c.setText((CharSequence)this.a.second);
                          this.b.d.i.b.a();
                        } 
                      }
                    }); 
            } 
            if (this.d.i != null && this.d.i.a != null && this.d.i.a.isShowing())
              this.d.i.a.dismiss(); 
            CommonAlertDialog.a(this.d.a, "", this.d.a.getResources().getString(2131755019), this.d.a.getString(2131755024), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    param2DialogInterface.dismiss();
                    BeansPrePayFragment.a(this.a.d.a, 6);
                  }
                }this.d.a.getString(2131756057), null, null);
          } 
          AppInfo.n().post(new Runnable(this) {
                public void run() {
                  LiveGiftPayTools.a(this.a.d.a, this.a.d.c);
                }
              });
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          VIPBuyResultObserver.a().a(3, param1Boolean);
          if (param1Boolean && TextUtils.equals(this.a.trade_type, "beans")) {
            Context context = this.c;
            if (context instanceof Activity) {
              String str1;
              ((Activity)context).finish();
              LiveEventBus.get("close_flutter").post(Boolean.valueOf(true));
              Context context1 = this.c;
              String str2 = this.b;
              if (this.d.j == null) {
                str1 = "";
              } else {
                str1 = this.d.j.order_id;
              } 
              PayUtils.a(context1, str2, str1);
            } 
          } 
        }
      };
    paramString3 = this.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramGoodsOptionBasic.id);
    stringBuilder.append("");
    UserHttpUtils.a(bluedUIHttpResponse, paramString3, stringBuilder.toString(), paramGoodsOptionBasic.feed_id, this.g, null, this.c, paramString1, paramString2, paramBoolean, paramGoodsOptionBasic.trade_type, paramGoodsOptionBasic.beans, paramGoodsOptionBasic.aim, paramGoodsOptionBasic.promotion_type, paramGoodsOptionBasic.role, paramGoodsOptionBasic.age, paramGoodsOptionBasic.area);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramInt;
  }
  
  public BluedUIHttpResponse b() {
    return new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(this, this.c) {
        protected void a(BluedEntityA<PayRemaining> param1BluedEntityA) {
          try {
            String str = AesCrypto.c(((PayRemaining)param1BluedEntityA.data.get(0))._);
            Logger.a("wx", str);
            PayOrderInfo.WXpayOrder wXpayOrder = (PayOrderInfo.WXpayOrder)AppInfo.f().fromJson(str, PayOrderInfo.WXpayOrder.class);
            PayReq payReq = new PayReq();
            payReq.appId = wXpayOrder.appid;
            payReq.partnerId = wXpayOrder.partnerid;
            payReq.prepayId = wXpayOrder.prepayid;
            payReq.nonceStr = wXpayOrder.noncestr;
            payReq.timeStamp = wXpayOrder.timestamp;
            payReq.packageValue = wXpayOrder.packageValue;
            payReq.sign = wXpayOrder.sign;
            PayUtils.a(this.a).sendReq((BaseReq)payReq);
            return;
          } catch (Exception exception) {
            VIPBuyResultObserver.a().a(0, false);
            AppMethods.a(AppInfo.d().getResources().getString(2131756082));
            return;
          } 
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          VIPBuyResultObserver.a().a(0, false);
          switch (param1Int) {
            default:
              return super.onUIFailure(param1Int, param1String);
            case 4433005:
              ToastUtils.a(AppInfo.d().getString(2131758075));
              return true;
            case 4433004:
              ToastUtils.a(AppInfo.d().getString(2131757985));
              return true;
            case 4433003:
              break;
          } 
          ToastUtils.a(AppInfo.d().getString(2131757995));
          return true;
        }
      };
  }
  
  public boolean c() {
    boolean bool;
    if (this.k.getWXAppSupportAPI() >= 570425345) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool)
      AppMethods.a(this.a.getResources().getString(2131755146)); 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\presenter\PayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
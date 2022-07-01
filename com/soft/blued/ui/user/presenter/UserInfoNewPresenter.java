package com.soft.blued.ui.user.presenter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.FileCache;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.das.profile.PersonalProfileProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.contract.IUserInfoNewContract;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.MultiHeadMigration;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.File;

public class UserInfoNewPresenter implements IUserInfoNewContract.IPresenter, UserRelationshipUtils.IAddOrRemoveAttentionDone {
  public Context a;
  
  public IUserInfoNewContract.IView b;
  
  public IRequestHost c;
  
  public Dialog d;
  
  public boolean e;
  
  public String f;
  
  public boolean g;
  
  public boolean h;
  
  public boolean i;
  
  public MsgSourceEntity j;
  
  private UserInfoEntity k;
  
  private SessionSettingModel l;
  
  public UserInfoNewPresenter(Context paramContext, IUserInfoNewContract.IView paramIView, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, IRequestHost paramIRequestHost, MsgSourceEntity paramMsgSourceEntity) {
    this.a = paramContext;
    this.b = paramIView;
    this.c = paramIRequestHost;
    this.f = paramString;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.i = paramBoolean3;
    this.d = DialogUtils.a(this.a);
    this.j = paramMsgSourceEntity;
  }
  
  private void a(String paramString, BluedAlbum paramBluedAlbum) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {
            if (this.a.c.isActive())
              DialogUtils.b(this.a.d); 
          }
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            UserInfoNewPresenter.b(this.a, param1String1);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void e(String paramString) {
    MineHttpUtils.d(this.a, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, this.c, paramString) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            (UserInfoNewPresenter.a(this.b)).background_photo = this.a;
            (UserInfoNewPresenter.a(this.b)).background_photo_auditing = 1;
            this.b.b.a(UserInfoNewPresenter.a(this.b));
            AppMethods.d(2131758470);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(this.b.d);
          }
        }paramString, this.c);
  }
  
  private void f(String paramString) {
    UserInfoEntity userInfoEntity = this.k;
    if (userInfoEntity != null && userInfoEntity.uid != null) {
      SessionModel sessionModel = ChatManager.getInstance().getSnapSessionModel((short)2, Long.valueOf(this.k.uid).longValue());
      if (sessionModel != null) {
        this.l = (SessionSettingModel)sessionModel.sessionSettingModel;
      } else {
        ChatManager.getInstance().getSessionSettingModel((short)2, Long.valueOf(this.k.uid).longValue(), new FetchDataListener<SessionSettingBaseModel>(this) {
              public void a(SessionSettingBaseModel param1SessionSettingBaseModel) {
                UserInfoNewPresenter.a(this.a, (SessionSettingModel)param1SessionSettingBaseModel);
              }
            });
      } 
      SessionSettingModel sessionSettingModel = this.l;
      if (sessionSettingModel != null) {
        sessionSettingModel.setSessinoNote(paramString);
        ChatManager.getInstance().setSessionSetting(this.l.getSessionType(), this.l.getSessionId(), (SessionSettingBaseModel)this.l);
        return;
      } 
      sessionSettingModel = new SessionSettingModel();
      sessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
      sessionSettingModel.setSessionId(Long.valueOf(this.k.uid).longValue());
      sessionSettingModel.setSessionType((short)2);
      sessionSettingModel.setSessinoNote(paramString);
      ChatManager.getInstance().setSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), (SessionSettingBaseModel)sessionSettingModel);
    } 
  }
  
  public void a() {}
  
  public void a(UserBasicModel paramUserBasicModel) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse) {
    ChatHelperV4.a().a(this.k.uid, this.k.name, this.k.avatar, this.k.vbadge, this.k.vip_grade, this.k.is_vip_annual, this.k.vip_exp_lvl, this.k.is_hide_vip_look, paramGiftGivingOptionForJsonParse, this.j);
  }
  
  public void a(String paramString) {
    UserInfoEntity userInfoEntity = this.k;
    userInfoEntity.relationship = paramString;
    this.b.a(userInfoEntity);
  }
  
  public void b() {}
  
  public void b(String paramString) {
    UserInfoEntity userInfoEntity = this.k;
    userInfoEntity.relationship = paramString;
    this.b.a(userInfoEntity);
  }
  
  public void bb_() {}
  
  public void c() {}
  
  public void c(String paramString) {
    LoginRegisterHttpUtils.a(this.a, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, this.c, paramString) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
              UserInfoNewPresenter.a(this.b, this.a, bluedAlbum);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(this.b.d);
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(this.b.d);
          }
        }this.c);
  }
  
  public UserInfoEntity d() {
    if (this.k == null)
      this.k = new UserInfoEntity(); 
    return this.k;
  }
  
  public void d(String paramString) {
    if (LiveFloatManager.a().x())
      return; 
    YYRoomInfoManager.d().a((BaseFragmentActivity)this.a, paramString, "mine_chat_room");
  }
  
  public void e() {
    Context context = this.a;
    CommonAlertDialog.a(context, context.getResources().getString(2131756094), 20, null, null, null, this.k.note, this.a.getString(2131758397), new CommonAlertDialog.TextOnClickListener(this) {
          public void a(String param1String) {
            if (!param1String.equals((UserInfoNewPresenter.a(this.a)).note)) {
              MineHttpUtils.h(this.a.a, new BluedUIHttpResponse<BluedEntityA<Object>>(this, this.a.c, param1String) {
                    protected void a(BluedEntityA<Object> param2BluedEntityA) {
                      AppMethods.d(2131757917);
                      (UserInfoNewPresenter.a(this.b.a)).note = this.a;
                      this.b.a.b.b(UserInfoNewPresenter.a(this.b.a));
                      UserInfoNewPresenter.a(this.b.a, this.a);
                    }
                    
                    public void onUIFinish() {
                      DialogUtils.b(this.b.a.d);
                      super.onUIFinish();
                    }
                    
                    public void onUIStart() {
                      DialogUtils.a(this.b.a.d);
                      super.onUIStart();
                    }
                  }UserInfo.a().i().getUid(), param1String, (UserInfoNewPresenter.a(this.a)).uid, this.a.c);
              return;
            } 
            AppMethods.d(2131758397);
          }
        }null);
  }
  
  public boolean f() {
    return (this.k != null) ? ((UserInfo.a().i()).uid.equalsIgnoreCase(this.k.uid) ? false : UserRelationshipUtils.a(this.k.relationship)) : false;
  }
  
  public boolean g() {
    UserInfoEntity userInfoEntity = this.k;
    boolean bool = false;
    if (userInfoEntity == null)
      return false; 
    if ("8".equalsIgnoreCase(userInfoEntity.relationship) || "12".equalsIgnoreCase(this.k.relationship))
      bool = true; 
    return bool;
  }
  
  public void h() {
    UserHttpUtils.c(new BluedUIHttpResponse<BluedEntityA>(this, this.c) {
          protected void a(BluedEntityA param1BluedEntityA) {
            AppMethods.d(2131756175);
            (UserInfoNewPresenter.a(this.a)).background_photo = "";
            (UserInfoNewPresenter.a(this.a)).background_photo_auditing = 0;
            this.a.b.a(UserInfoNewPresenter.a(this.a));
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(this.a.d);
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(this.a.d);
          }
        }this.c);
  }
  
  public void i() {
    String str = AvatarUtils.a(3, this.k.background_photo);
    ImageFileLoader.a(null).b(str).a(new -$$Lambda$UserInfoNewPresenter$Aij8wt4Bso5z1BQI7f0wX7qWlWE(this)).a();
  }
  
  public void j() {
    if (this.k != null && !f())
      UserRelationshipUtils.a(this.a, this, this.k.uid, this.k.relationship, this.f, this.c, false); 
  }
  
  public void k() {
    UserInfoEntity userInfoEntity = this.k;
    if (userInfoEntity != null) {
      if ("0".equals(userInfoEntity.in_blacklist)) {
        UserHttpUtils.b(this.a, new BluedUIHttpResponse<BluedEntityA<Object>>(this, this.c) {
              boolean a;
              
              protected void a(BluedEntityA<Object> param1BluedEntityA) {
                AppMethods.d(2131755238);
                (UserInfoNewPresenter.a(this.b)).in_blacklist = "1";
                if ("8".equals((UserInfoNewPresenter.a(this.b)).relationship)) {
                  (UserInfoNewPresenter.a(this.b)).relationship = "12";
                } else {
                  (UserInfoNewPresenter.a(this.b)).relationship = "4";
                } 
                this.b.b.a(UserInfoNewPresenter.a(this.b));
                UserInfo.a().i().addBlackCount();
                if ((UserInfoNewPresenter.a(this.b)).uid != null) {
                  ChatHelperV4.a().b(Long.parseLong((UserInfoNewPresenter.a(this.b)).uid));
                  LiveEventBus.get("feed_relation_ship").post(UserInfoNewPresenter.a(this.b));
                } 
                this.b.b.d();
              }
              
              public boolean onUIFailure(int param1Int, String param1String) {
                if (param1Int == 403902)
                  this.a = true; 
                return super.onUIFailure(param1Int, param1String);
              }
              
              public void onUIFinish() {
                DialogUtils.b(this.b.d);
                if (this.a) {
                  PayUtils.a(this.b.a, 7, "blacklist_expand");
                  this.a = false;
                  if ((UserInfo.a().i()).vip_grade == 2) {
                    InstantLog.a("profile_max_blacklist", 1);
                    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PROFILE_MAX_BLACKLIST, 1);
                  } else {
                    InstantLog.a("profile_max_blacklist", 0);
                    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PROFILE_MAX_BLACKLIST, 0);
                  } 
                } 
                super.onUIFinish();
              }
              
              public void onUIStart() {
                DialogUtils.a(this.b.d);
                super.onUIStart();
              }
            }UserInfo.a().i().getUid(), this.k.uid, this.c);
        return;
      } 
      DialogUtils.a(this.d);
      UserHttpUtils.c(this.a, new BluedUIHttpResponse<BluedEntityA<Object>>(this, this.c) {
            protected void a(BluedEntityA<Object> param1BluedEntityA) {
              AppMethods.d(2131758572);
              (UserInfoNewPresenter.a(this.a)).in_blacklist = "0";
              if ("12".equals((UserInfoNewPresenter.a(this.a)).relationship)) {
                (UserInfoNewPresenter.a(this.a)).relationship = "8";
              } else {
                (UserInfoNewPresenter.a(this.a)).relationship = "0";
              } 
              this.a.b.a(UserInfoNewPresenter.a(this.a));
              UserInfo.a().i().removeBlackCount();
              if ((UserInfoNewPresenter.a(this.a)).uid != null)
                LiveEventBus.get("feed_relation_ship").post(UserInfoNewPresenter.a(this.a)); 
            }
            
            public void onUIFinish() {
              DialogUtils.b(this.a.d);
              super.onUIFinish();
            }
            
            public void onUIStart() {
              super.onUIStart();
            }
          }UserInfo.a().i().getUid(), this.k.uid, this.c);
    } 
  }
  
  public void l() {
    ProfileHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          protected BluedEntityA<Object> a(String param1String) {
            return (BluedEntityA<Object>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            if (param1BluedEntityA == null)
              try {
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            this.a.a((UserBasicModel)UserInfoNewPresenter.a(this.a));
            AppMethods.d(2131758331);
          }
          
          public void onUIFinish() {
            DialogUtils.b(this.a.d);
          }
          
          public void onUIStart() {
            DialogUtils.a(this.a.d);
          }
        },  UserInfo.a().i().getUid(), this.k.uid, null);
  }
  
  public void m() {
    MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          protected BluedEntityA<Object> a(String param1String) {
            return (BluedEntityA<Object>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            if (param1BluedEntityA == null)
              try {
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            this.a.a((UserBasicModel)UserInfoNewPresenter.a(this.a));
            AppMethods.d(2131758331);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            DialogUtils.b(this.a.d);
          }
          
          public void onUIStart() {
            DialogUtils.a(this.a.d);
          }
        }UserInfo.a().i().getUid(), this.k.uid, null);
  }
  
  public void n() {
    UserHttpUtils.a(this.a, new UserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
          public void a() {}
          
          public void a(String param1String) {}
          
          public void b() {}
          
          public void b(String param1String) {
            (UserInfoNewPresenter.a(this.a)).relationship = param1String;
            (UserInfoNewPresenter.a(this.a)).secretly_followed_status = 0;
            AppMethods.d(2131756206);
          }
          
          public void c() {}
        },  this.k.uid, this.f, this.c);
  }
  
  public void o() {
    UserHttpUtils.a(this.k.uid, this.c, new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(this) {
          protected void a(BluedEntityA<UserInfoEntity> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              (UserInfoNewPresenter.a(this.a)).secretly_followed_status = 1;
              this.a.b.a(UserInfoNewPresenter.a(this.a));
              AppMethods.d(2131758672);
            } 
          }
        });
  }
  
  public void p() {
    ProfileHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<MultiHeadMigration.DataBean>>(this, this.c) {
          protected void a(BluedEntityA<MultiHeadMigration.DataBean> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              MultiHeadMigration.DataBean dataBean = (MultiHeadMigration.DataBean)param1BluedEntityA.getSingleData();
              if (this.a.e && dataBean != null) {
                if (dataBean.vip_grade != 0 && dataBean.vip_avatar_num > 0) {
                  AppMethods.a(this.a.a.getResources().getString(2131758438));
                  return;
                } 
                if (dataBean.vip_grade == 0 && dataBean.vip_avatar_num > 0)
                  AppMethods.a(this.a.a.getResources().getString(2131758439)); 
              } 
            } 
          }
        }(UserInfo.a().i()).uid, this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\presenter\UserInfoNewPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
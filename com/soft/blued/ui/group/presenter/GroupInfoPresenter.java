package com.soft.blued.ui.group.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageFileWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.group.contract.IGroupInfoContract;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.msg.ChatBgSettingFragment;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.File;

public class GroupInfoPresenter implements IGroupInfoContract.IPresenter {
  public BluedUIHttpResponse a = new BluedUIHttpResponse<BluedEntity>(this) {
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(GroupInfoPresenter.a(this.a));
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(GroupInfoPresenter.a(this.a));
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        try {
          GroupInfoPresenter.i(this.a);
          AppMethods.d(2131756717);
          this.a.a(false);
          return;
        } catch (Exception exception) {
          AppMethods.a(GroupInfoPresenter.e(this.a).getResources().getString(2131756082));
          exception.printStackTrace();
          return;
        } 
      }
    };
  
  private String b = GroupInfoPresenter.class.getSimpleName();
  
  private int c = 0;
  
  private final int d = 403009030;
  
  private final int e = 403009029;
  
  private Context f;
  
  private IGroupInfoContract.IView g;
  
  private LoadOptions h;
  
  private IRequestHost i;
  
  private Dialog j;
  
  private BluedCreatedGroupInfo k;
  
  private String l;
  
  private String m;
  
  private String n;
  
  private String o;
  
  private String p;
  
  private String q;
  
  private boolean r;
  
  private String s;
  
  private SessionSettingModel t;
  
  public GroupInfoPresenter(Context paramContext, IGroupInfoContract.IView paramIView, LoadOptions paramLoadOptions, IRequestHost paramIRequestHost) {
    this.f = paramContext;
    this.g = paramIView;
    this.h = paramLoadOptions;
    this.i = paramIRequestHost;
    i();
    j();
  }
  
  private void a(String paramString, BluedAlbum paramBluedAlbum) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {}
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            GroupInfoPresenter.a(this.a, param1String1);
            GroupInfoPresenter.i(this.a);
            GroupInfoPresenter.f(this.a, param1String1);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void c(boolean paramBoolean) {
    GroupHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedCreatedGroupInfo>>(this, paramBoolean) {
          boolean a;
          
          int b;
          
          protected void a(BluedEntityA<BluedCreatedGroupInfo> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              GroupInfoPresenter.a(this.d, (BluedCreatedGroupInfo)param1BluedEntityA.getSingleData());
              GroupInfoPresenter groupInfoPresenter = this.d;
              GroupInfoPresenter.a(groupInfoPresenter, (GroupInfoPresenter.b(groupInfoPresenter)).groups_avatar);
              groupInfoPresenter = this.d;
              GroupInfoPresenter.b(groupInfoPresenter, (GroupInfoPresenter.b(groupInfoPresenter)).groups_name);
              groupInfoPresenter = this.d;
              GroupInfoPresenter.c(groupInfoPresenter, (GroupInfoPresenter.b(groupInfoPresenter)).groups_is_created);
              groupInfoPresenter = this.d;
              GroupInfoPresenter.d(groupInfoPresenter, (GroupInfoPresenter.b(groupInfoPresenter)).groups_in_members);
              groupInfoPresenter = this.d;
              GroupInfoPresenter.e(groupInfoPresenter, (GroupInfoPresenter.b(groupInfoPresenter)).groups_is_admins);
              GroupInfoPresenter.c(this.d).a((BluedCreatedGroupInfo)param1BluedEntityA.getSingleData());
            } 
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            Logger.a(GroupInfoPresenter.d(this.d), new Object[] { "onFailure, error:", param1Throwable });
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            this.b = param1Int;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            if (this.c)
              DialogUtils.b(GroupInfoPresenter.a(this.d)); 
            if (this.a) {
              this.a = false;
              if (this.b == 403009030)
                GroupInfoPresenter.c(this.d).aK_(); 
            } 
          }
          
          public void onUIStart() {
            if (this.c)
              DialogUtils.a(GroupInfoPresenter.a(this.d)); 
          }
        }this.l, "detail", this.i);
  }
  
  private void i() {
    this.j = DialogUtils.a(this.f);
  }
  
  private void i(String paramString) {
    if (this.k != null)
      GroupHttpUtils.j(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this) {
            protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
                GroupInfoPresenter.c(this.a).a(GroupInfoPresenter.g(this.a));
                (GroupInfoPresenter.b(this.a)).groups_avatar = GroupInfoPresenter.g(this.a);
              } 
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              DialogUtils.b(GroupInfoPresenter.a(this.a));
            }
            
            public void onUIStart() {
              super.onUIStart();
              DialogUtils.a(GroupInfoPresenter.a(this.a));
            }
          },  paramString, this.l, this.i); 
  }
  
  private void j() {
    Bundle bundle = this.g.a();
    if (bundle == null)
      return; 
    this.l = bundle.getString("gid");
  }
  
  private void k() {
    SessionProfileModel sessionProfileModel = new SessionProfileModel();
    sessionProfileModel.avatar = this.m;
    sessionProfileModel.nickname = this.n;
    ChatManager.getInstance().updateSessionInfoData((short)3, Long.parseLong(this.l), sessionProfileModel);
  }
  
  public void a(int paramInt) {
    SessionSettingModel sessionSettingModel = this.t;
    if (sessionSettingModel != null) {
      sessionSettingModel.setRemindAudio(paramInt);
      ChatManager.getInstance().setSessionSetting(this.t.getSessionType(), this.t.getSessionId(), (SessionSettingBaseModel)this.t);
    } 
  }
  
  public void a(BaseFragment paramBaseFragment, int paramInt) {
    BluedPreferences.f(1);
    if ((UserInfo.a().i()).vip_grade != 0 || (BluedConfig.b().j()).is_chat_backgrounds == 1) {
      ChatBgSettingFragment.a(paramBaseFragment, 1, this.t.getSessionId(), this.t.getSessionType(), paramInt);
      return;
    } 
    PayUtils.a(this.f, 23, "chat_customize_bg");
  }
  
  public void a(String paramString) {
    this.s = paramString;
    GroupHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, paramString) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              BluedAlbum bluedAlbum = (BluedAlbum)param1BluedEntityA.getSingleData();
              GroupInfoPresenter.a(this.b, this.a, bluedAlbum);
            } 
          }
        }this.l, this.i);
  }
  
  public void a(String paramString, ImageView paramImageView) {
    String str1 = BluedHttpUrl.b(this.l);
    String str2 = this.f.getString(2131756788);
    String str3 = String.format(this.f.getString(2131756787), new Object[] { paramString, this.l });
    if (this.k != null) {
      BluedGroupLists bluedGroupLists = new BluedGroupLists();
      bluedGroupLists.groups_gid = this.k.groups_gid;
      bluedGroupLists.groups_is_admins = this.k.groups_is_admins;
      bluedGroupLists.groups_is_created = this.k.groups_is_created;
      bluedGroupLists.groups_name = this.k.groups_name;
      bluedGroupLists.groups_description = this.k.groups_description;
      if (StringUtils.e(this.k.groups_avatar)) {
        ShareUtils.a().a((Activity)this.f, 0, "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500", null, null, str1, str2, str3, str3, 0, bluedGroupLists);
        return;
      } 
      ImageFileWrapper imageFileWrapper = ImageFileLoader.a(this.i);
      if (this.r) {
        paramString = this.s;
      } else {
        paramString = this.k.groups_avatar;
      } 
      imageFileWrapper.a(paramString).a(new ImageFileLoader.OnLoadFileListener(this, paramImageView, str1, str2, str3, bluedGroupLists) {
            public void onUIFinish(File param1File, Exception param1Exception) {
              String str1;
              if (param1File != null && param1File.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
              } else {
                param1File = null;
              } 
              ShareUtils shareUtils = ShareUtils.a();
              Activity activity = (Activity)GroupInfoPresenter.e(this.f);
              if (GroupInfoPresenter.f(this.f)) {
                str1 = GroupInfoPresenter.g(this.f);
              } else {
                str1 = (GroupInfoPresenter.b(this.f)).groups_avatar;
              } 
              ImageView imageView = this.a;
              String str2 = this.b;
              String str3 = this.c;
              String str4 = this.d;
              shareUtils.a(activity, 0, str1, (View)imageView, (Bitmap)param1File, str2, str3, str4, str4, 0, this.e);
            }
          }).a();
    } 
  }
  
  public void a(boolean paramBoolean) {
    c(paramBoolean);
  }
  
  public void b() {
    if ("1".equals(this.o) || "1".equals(this.q)) {
      String[] arrayOfString;
      if (TextUtils.isEmpty(this.k.groups_avatar)) {
        arrayOfString = new String[1];
        arrayOfString[0] = this.f.getResources().getString(2131756853);
      } else {
        arrayOfString = new String[2];
        arrayOfString[0] = this.f.getResources().getString(2131756853);
        arrayOfString[1] = this.f.getResources().getString(2131756854);
      } 
      CommonShowBottomWindow.a((FragmentActivity)this.f, arrayOfString, new ActionSheet.ActionSheetListener(this) {
            public void a(ActionSheet param1ActionSheet, int param1Int) {
              if (param1Int == 0) {
                if (!PopMenuUtils.a(GroupInfoPresenter.e(this.a))) {
                  GroupInfoPresenter.c(this.a).b();
                  return;
                } 
              } else {
                if (!StringUtils.e((GroupInfoPresenter.b(this.a)).groups_avatar)) {
                  String str = (GroupInfoPresenter.b(this.a)).groups_avatar;
                  GroupInfoPresenter.c(this.a).a(new String[] { str });
                  return;
                } 
                GroupInfoPresenter.c(this.a).a(new String[] { null });
              } 
            }
            
            public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
          });
      return;
    } 
    if (!StringUtils.e(this.k.groups_avatar)) {
      String str = this.k.groups_avatar;
      this.g.a(new String[] { str });
      return;
    } 
    this.g.a(new String[] { null });
  }
  
  public void b(String paramString) {
    SessionModel sessionModel = ChatManager.getInstance().getSnapSessionModel((short)3, Long.parseLong(paramString));
    if (sessionModel != null) {
      this.t = (SessionSettingModel)sessionModel.sessionSettingModel;
      SessionSettingModel sessionSettingModel = this.t;
      if (sessionSettingModel != null)
        if (sessionSettingModel.getRemindAudio() == 0) {
          this.g.a(false);
        } else if (this.t.getRemindAudio() == 1) {
          this.g.a(true);
        }  
    } 
    ChatManager.getInstance().getSessionSettingModel((short)3, Long.parseLong(paramString), new FetchDataListener<SessionSettingBaseModel>(this, paramString) {
          public void a(SessionSettingBaseModel param1SessionSettingBaseModel) {
            GroupInfoPresenter.a(this.b, (SessionSettingModel)param1SessionSettingBaseModel);
            if (GroupInfoPresenter.h(this.b) != null)
              if (GroupInfoPresenter.h(this.b).getRemindAudio() == 0) {
                GroupInfoPresenter.c(this.b).a(false);
              } else if (GroupInfoPresenter.h(this.b).getRemindAudio() == 1) {
                GroupInfoPresenter.c(this.b).a(true);
              }  
            if (GroupInfoPresenter.h(this.b) == null) {
              SessionSettingModel sessionSettingModel = new SessionSettingModel();
              sessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
              sessionSettingModel.setSessionId(Long.valueOf(this.a).longValue());
              sessionSettingModel.setSessionType((short)3);
              GroupInfoPresenter.a(this.b, sessionSettingModel);
            } 
          }
        });
  }
  
  public void b(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void bb_() {}
  
  public void c(String paramString) {
    GroupHttpUtils.d(this.f, new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          protected BluedEntityA<Object> a(String param1String) {
            Logger.a(GroupInfoPresenter.d(this.a), new Object[] { "onSuccess, content:", param1String });
            return (BluedEntityA<Object>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            try {
              AppMethods.d(2131756686);
              UserInfo.a().i().setGroupsCount(1);
              GroupInfoPresenter.c(this.a).aJ_();
            } catch (Exception exception) {
              AppMethods.a(GroupInfoPresenter.e(this.a).getResources().getString(2131756082));
              exception.printStackTrace();
            } 
            GroupInfoPresenter.a(this.a, 0);
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            GroupInfoPresenter.a(this.a, 0);
            if (((Integer)(BluedHttpUtils.a(param1Throwable, param1Int, param1String)).first).intValue() == 403009029) {
              GroupInfoPresenter.a(this.a, 403009029);
              GroupInfoPresenter.c(this.a).h();
            } 
          }
          
          public void onUIFinish() {
            Logger.a(GroupInfoPresenter.d(this.a), new Object[] { "onFinish" });
            DialogUtils.b(GroupInfoPresenter.a(this.a));
          }
          
          public void onUIStart() {
            DialogUtils.a(GroupInfoPresenter.a(this.a));
          }
        }UserInfo.a().i().getUid(), paramString, this.i);
  }
  
  public boolean c() {
    return ("1".equals(this.p) || "1".equals(this.q) || "1".equals(this.o));
  }
  
  public void d() {
    ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)3), Long.parseLong(this.l));
  }
  
  public void d(String paramString) {
    GroupHttpUtils.f(this.f, new BluedUIHttpResponse<BluedEntity>(this) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.d(2131755679);
          }
        },  this.l, paramString, this.i);
  }
  
  public void e() {
    GroupHttpUtils.f(this.f, new BluedUIHttpResponse<BluedEntity>(this) {
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupInfoPresenter.a(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupInfoPresenter.a(this.a));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            GroupInfoPresenter.c(this.a).d();
          }
        },  this.k.groups_gid, this.i);
  }
  
  public void e(String paramString) {
    GroupHttpUtils.b(this.f, this.a, this.l, "", "", paramString, "", this.i);
  }
  
  public void f() {
    GroupHttpUtils.e(this.f, new BluedUIHttpResponse<BluedEntity>(this) {
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupInfoPresenter.a(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupInfoPresenter.a(this.a));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            GroupInfoPresenter.c(this.a).e();
          }
        },  this.k.groups_gid, this.i);
  }
  
  public void f(String paramString) {
    GroupHttpUtils.b(this.f, this.a, this.l, "", paramString, "", "", this.i);
  }
  
  public void g() {
    ChatManager.getInstance().deleteSessionAndChattingWithSetting(Short.valueOf((short)3), Long.parseLong(this.k.groups_gid));
  }
  
  public void g(String paramString) {
    GroupHttpUtils.b(this.f, this.a, this.l, paramString, "", "", "", this.i);
  }
  
  public void h(String paramString) {
    this.r = true;
    this.k.groups_avatar = RecyclingUtils.Scheme.c.b(paramString);
  }
  
  public boolean h() {
    return (this.c == 403009029);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\presenter\GroupInfoPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
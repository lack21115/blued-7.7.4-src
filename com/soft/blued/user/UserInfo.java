package com.soft.blued.user;

import android.text.TextUtils;
import android.view.View;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.db.model.UserAccountsModel;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.mine.model.UserUnreadMsgModel;
import com.soft.blued.ui.mine.pop.UnreadMsgPop;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserInfo {
  private static final String a = UserInfo.class.getSimpleName();
  
  private static volatile UserInfo b;
  
  private BluedLoginResult c;
  
  private BluedLoginResult d = new BluedLoginResult();
  
  private String e;
  
  private double f;
  
  private String g;
  
  private int h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private UserInfo() {
    i();
  }
  
  public static UserInfo a() {
    // Byte code:
    //   0: getstatic com/soft/blued/user/UserInfo.b : Lcom/soft/blued/user/UserInfo;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/user/UserInfo
    //   8: monitorenter
    //   9: getstatic com/soft/blued/user/UserInfo.b : Lcom/soft/blued/user/UserInfo;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/user/UserInfo
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/user/UserInfo.b : Lcom/soft/blued/user/UserInfo;
    //   25: ldc com/soft/blued/user/UserInfo
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/user/UserInfo
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/user/UserInfo.b : Lcom/soft/blued/user/UserInfo;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public BluedLoginResult a(UserAccountsModel paramUserAccountsModel) {
    // Byte code:
    //   0: ldc ''
    //   2: astore_2
    //   3: aload_1
    //   4: ifnull -> 12
    //   7: aload_1
    //   8: invokevirtual getLoginresult : ()Ljava/lang/String;
    //   11: astore_2
    //   12: aload_2
    //   13: invokestatic e : (Ljava/lang/String;)Z
    //   16: ifeq -> 27
    //   19: new com/soft/blued/ui/login_register/model/BluedLoginResult
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: areturn
    //   27: invokestatic f : ()Lcom/google/gson/Gson;
    //   30: astore_1
    //   31: aload_1
    //   32: aload_2
    //   33: new com/soft/blued/user/UserInfo$1
    //   36: dup
    //   37: aload_0
    //   38: invokespecial <init> : (Lcom/soft/blued/user/UserInfo;)V
    //   41: invokevirtual getType : ()Ljava/lang/reflect/Type;
    //   44: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   47: checkcast com/blued/android/framework/http/parser/BluedEntityA
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull -> 174
    //   55: aload_3
    //   56: getfield data : Ljava/util/List;
    //   59: ifnull -> 174
    //   62: aload_3
    //   63: getfield data : Ljava/util/List;
    //   66: invokeinterface size : ()I
    //   71: ifle -> 174
    //   74: aload_3
    //   75: getfield data : Ljava/util/List;
    //   78: iconst_0
    //   79: invokeinterface get : (I)Ljava/lang/Object;
    //   84: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
    //   87: invokevirtual get_ : ()Ljava/lang/String;
    //   90: astore #4
    //   92: aload #4
    //   94: invokestatic e : (Ljava/lang/String;)Z
    //   97: ifne -> 160
    //   100: getstatic com/soft/blued/user/UserInfo.a : Ljava/lang/String;
    //   103: iconst_3
    //   104: anewarray java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: ldc '===success'
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: ldc '加密：responseJson:'
    //   116: aastore
    //   117: dup
    //   118: iconst_2
    //   119: aload_2
    //   120: aastore
    //   121: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload #4
    //   126: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_2
    //   130: getstatic com/soft/blued/user/UserInfo.a : Ljava/lang/String;
    //   133: iconst_2
    //   134: anewarray java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: ldc '解密：deData==='
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: aload_2
    //   145: aastore
    //   146: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_1
    //   150: aload_2
    //   151: ldc com/soft/blued/ui/login_register/model/BluedLoginResult
    //   153: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   156: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
    //   159: areturn
    //   160: aload_3
    //   161: getfield data : Ljava/util/List;
    //   164: iconst_0
    //   165: invokeinterface get : (I)Ljava/lang/Object;
    //   170: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
    //   173: areturn
    //   174: new com/soft/blued/ui/login_register/model/BluedLoginResult
    //   177: dup
    //   178: invokespecial <init> : ()V
    //   181: astore_1
    //   182: aload_1
    //   183: areturn
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual printStackTrace : ()V
    //   189: aconst_null
    //   190: areturn
    // Exception table:
    //   from	to	target	type
    //   7	12	184	java/lang/Exception
    //   12	27	184	java/lang/Exception
    //   27	51	184	java/lang/Exception
    //   55	160	184	java/lang/Exception
    //   160	174	184	java/lang/Exception
    //   174	182	184	java/lang/Exception
  }
  
  public void a(double paramDouble) {
    this.f = paramDouble;
  }
  
  public void a(int paramInt) {
    this.h = paramInt;
  }
  
  public void a(HomeActivity.TabItem paramTabItem) {
    if (paramTabItem == null)
      return; 
    ThreadManager.a().a(new ThreadExecutor(this, "getUnreadMsgCnt", paramTabItem) {
          public void execute() {
            CopyOnWriteArrayList<UserAccountsModel> copyOnWriteArrayList = UserAccountsVDao.a().g();
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 1) {
              UserAccountsModel userAccountsModel = copyOnWriteArrayList.get(1);
              if (!userAccountsModel.getUid().equals((this.b.i()).uid))
                UserHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<UserUnreadMsgModel>>(this, null) {
                      protected void a(BluedEntityA<UserUnreadMsgModel> param2BluedEntityA) {
                        if (param2BluedEntityA.hasData() && ((UserUnreadMsgModel)param2BluedEntityA.data.get(0)).has_unread != 0) {
                          String str = UserInfo.l();
                          StringBuilder stringBuilder = new StringBuilder();
                          stringBuilder.append("hasUnread===");
                          stringBuilder.append(((UserUnreadMsgModel)param2BluedEntityA.data.get(0)).has_unread);
                          Logger.e(str, new Object[] { stringBuilder.toString() });
                          BluedPreferences.A(((UserUnreadMsgModel)param2BluedEntityA.data.get(0)).has_unread);
                          BluedPreferences.T(true);
                          BluedPreferences.U(true);
                          this.a.a.h.setVisibility(0);
                          if (!BluedPreferences.em()) {
                            (new XPopup.Builder(this.a.a.a.getContext())).a((XPopupCallback)new SimpleCallback(this) {
                                  public void c(BasePopupView param3BasePopupView) {
                                    BluedPreferences.en();
                                  }
                                }).a(PopupAnimation.a).a(PopupPosition.c).c(Boolean.valueOf(false)).a(false).a((View)this.a.a.a).a((BasePopupView)new UnreadMsgPop(this.a.a.a.getContext())).h();
                            return;
                          } 
                        } else {
                          this.a.a.h.setVisibility(4);
                          BluedPreferences.T(false);
                        } 
                      }
                    }userAccountsModel.getUid(), null); 
            } 
          }
        });
  }
  
  public void a(BluedLoginResult paramBluedLoginResult) {
    // Byte code:
    //   0: ldc com/soft/blued/user/UserInfo
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: putfield c : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   8: aload_0
    //   9: getfield c : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   12: ifnonnull -> 23
    //   15: aload_0
    //   16: aload_0
    //   17: getfield d : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   20: putfield c : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   23: ldc com/soft/blued/user/UserInfo
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: ldc com/soft/blued/user/UserInfo
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	27	finally
    //   23	26	27	finally
    //   28	31	27	finally
  }
  
  public void a(String paramString) {
    this.e = paramString;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, BluedLoginResult paramBluedLoginResult, String... paramVarArgs) {
    // Byte code:
    //   0: aload #4
    //   2: ifnonnull -> 6
    //   5: return
    //   6: ldc com/soft/blued/user/UserInfo
    //   8: monitorenter
    //   9: aload #5
    //   11: ifnull -> 65
    //   14: aload #5
    //   16: arraylength
    //   17: ifle -> 65
    //   20: aload #5
    //   22: iconst_0
    //   23: aaload
    //   24: invokestatic e : (Ljava/lang/String;)Z
    //   27: ifne -> 65
    //   30: invokestatic a : ()Lcom/soft/blued/db/UserAccountsVDao;
    //   33: invokevirtual c : ()Lcom/soft/blued/db/model/UserAccountsModel;
    //   36: astore #6
    //   38: aload #6
    //   40: aload #4
    //   42: getfield uid : Ljava/lang/String;
    //   45: invokevirtual setAliasUserId : (Ljava/lang/String;)V
    //   48: invokestatic a : ()Lcom/soft/blued/db/UserAccountsVDao;
    //   51: invokevirtual b : ()Lcom/j256/ormlite/dao/Dao;
    //   54: aload #6
    //   56: invokeinterface update : (Ljava/lang/Object;)I
    //   61: pop
    //   62: invokestatic a : ()V
    //   65: aload_0
    //   66: aload #4
    //   68: invokevirtual a : (Lcom/soft/blued/ui/login_register/model/BluedLoginResult;)V
    //   71: aload_0
    //   72: aload_1
    //   73: putfield e : Ljava/lang/String;
    //   76: getstatic com/soft/blued/user/UserInfo.a : Ljava/lang/String;
    //   79: astore #6
    //   81: new java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore #7
    //   90: aload #7
    //   92: ldc 'IM=token==raw='
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload #7
    //   100: aload #4
    //   102: invokevirtual getAccess_token : ()Ljava/lang/String;
    //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload #6
    //   111: iconst_1
    //   112: anewarray java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload #7
    //   119: invokevirtual toString : ()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_0
    //   127: aload #4
    //   129: invokevirtual getAccess_token : ()Ljava/lang/String;
    //   132: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   135: putfield g : Ljava/lang/String;
    //   138: aload_0
    //   139: iload_2
    //   140: putfield h : I
    //   143: new com/soft/blued/db/model/UserAccountsModel
    //   146: dup
    //   147: invokespecial <init> : ()V
    //   150: astore #6
    //   152: aload #6
    //   154: ldc ''
    //   156: invokevirtual setExtra : (Ljava/lang/String;)V
    //   159: aload #6
    //   161: aload_3
    //   162: invokevirtual setLoginresult : (Ljava/lang/String;)V
    //   165: aload #6
    //   167: aload #4
    //   169: invokevirtual getUid : ()Ljava/lang/String;
    //   172: invokevirtual setUid : (Ljava/lang/String;)V
    //   175: aload #6
    //   177: invokestatic currentTimeMillis : ()J
    //   180: invokevirtual setLastHandleTime : (J)V
    //   183: aload #6
    //   185: aload_1
    //   186: invokevirtual setUsername : (Ljava/lang/String;)V
    //   189: aload #6
    //   191: iload_2
    //   192: invokevirtual setLoginType : (I)V
    //   195: aload #6
    //   197: aload #4
    //   199: invokevirtual getAccess_token : ()Ljava/lang/String;
    //   202: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   205: invokevirtual setAccessToken : (Ljava/lang/String;)V
    //   208: aload #5
    //   210: ifnull -> 228
    //   213: aload #5
    //   215: arraylength
    //   216: ifle -> 228
    //   219: aload #6
    //   221: aload #5
    //   223: iconst_0
    //   224: aaload
    //   225: invokevirtual setAliasUserId : (Ljava/lang/String;)V
    //   228: invokestatic a : ()Lcom/soft/blued/db/UserAccountsVDao;
    //   231: aload #6
    //   233: invokevirtual a : (Lcom/soft/blued/db/model/UserAccountsModel;)V
    //   236: invokestatic a : ()Lcom/blued/android/statistics/biz/Common;
    //   239: aload #4
    //   241: invokevirtual getUid : ()Ljava/lang/String;
    //   244: invokevirtual f : (Ljava/lang/String;)Lcom/blued/android/statistics/biz/Common;
    //   247: pop
    //   248: invokestatic d : ()Ljava/lang/String;
    //   251: invokestatic a : (Ljava/lang/String;)V
    //   254: invokestatic e : ()Lcom/blued/android/statistics/biz/Dau;
    //   257: invokevirtual b : ()V
    //   260: invokestatic a : ()Lcom/blued/android/module/device_identity/library/BluedDeviceIdentity;
    //   263: invokevirtual b : ()V
    //   266: goto -> 284
    //   269: astore_1
    //   270: goto -> 288
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual printStackTrace : ()V
    //   278: ldc_w 2131756082
    //   281: invokestatic d : (I)V
    //   284: ldc com/soft/blued/user/UserInfo
    //   286: monitorexit
    //   287: return
    //   288: ldc com/soft/blued/user/UserInfo
    //   290: monitorexit
    //   291: aload_1
    //   292: athrow
    // Exception table:
    //   from	to	target	type
    //   14	65	273	java/lang/Exception
    //   14	65	269	finally
    //   65	208	273	java/lang/Exception
    //   65	208	269	finally
    //   213	228	273	java/lang/Exception
    //   213	228	269	finally
    //   228	266	273	java/lang/Exception
    //   228	266	269	finally
    //   274	284	269	finally
    //   284	287	269	finally
    //   288	291	269	finally
  }
  
  public void a(boolean paramBoolean) {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic U : (Z)V
    //   4: ldc com/soft/blued/user/UserInfo
    //   6: monitorenter
    //   7: iload_1
    //   8: ifne -> 32
    //   11: aload_0
    //   12: ldc ''
    //   14: invokevirtual b : (Ljava/lang/String;)V
    //   17: invokestatic a : ()Lcom/soft/blued/db/UserAccountsVDao;
    //   20: invokevirtual e : ()V
    //   23: invokestatic a : ()Lcom/soft/blued/db/UserAccountsVDao;
    //   26: invokevirtual f : ()V
    //   29: goto -> 85
    //   32: getstatic com/soft/blued/user/UserInfo.a : Ljava/lang/String;
    //   35: astore_2
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore_3
    //   44: aload_3
    //   45: aload_0
    //   46: getfield e : Ljava/lang/String;
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: ldc_w '=切换不清除token='
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: aload_0
    //   63: getfield g : Ljava/lang/String;
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: iconst_1
    //   72: anewarray java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_3
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: aastore
    //   82: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: invokestatic b : ()Ljava/lang/String;
    //   88: pop
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield c : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   94: aload_0
    //   95: ldc ''
    //   97: invokevirtual c : (Ljava/lang/String;)V
    //   100: aload_0
    //   101: ldc ''
    //   103: invokevirtual d : (Ljava/lang/String;)V
    //   106: aload_0
    //   107: ldc ''
    //   109: invokevirtual e : (Ljava/lang/String;)V
    //   112: invokestatic e : ()Lcom/blued/android/statistics/biz/Dau;
    //   115: invokevirtual e : ()V
    //   118: invokestatic a : ()Lcom/blued/android/statistics/biz/Common;
    //   121: ldc ''
    //   123: invokevirtual f : (Ljava/lang/String;)Lcom/blued/android/statistics/biz/Common;
    //   126: pop
    //   127: aconst_null
    //   128: invokestatic a : (Ljava/lang/String;)V
    //   131: invokestatic a : ()Lcom/blued/android/module/device_identity/library/BluedDeviceIdentity;
    //   134: invokevirtual c : ()V
    //   137: aconst_null
    //   138: putstatic com/soft/blued/user/UserInfo.b : Lcom/soft/blued/user/UserInfo;
    //   141: ldc com/soft/blued/user/UserInfo
    //   143: monitorexit
    //   144: return
    //   145: astore_2
    //   146: ldc com/soft/blued/user/UserInfo
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    // Exception table:
    //   from	to	target	type
    //   11	29	145	finally
    //   32	85	145	finally
    //   85	144	145	finally
    //   146	149	145	finally
  }
  
  public String b() {
    return this.e;
  }
  
  public void b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield g : Ljava/lang/String;
    //   7: getstatic com/soft/blued/user/UserInfo.a : Ljava/lang/String;
    //   10: astore_2
    //   11: new java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc_w 'setAccessToken==='
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: iconst_1
    //   35: anewarray java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_3
    //   41: invokevirtual toString : ()Ljava/lang/String;
    //   44: aastore
    //   45: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   51: aload_1
    //   52: invokevirtual updateUserToken : (Ljava/lang/String;)V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   2	55	58	finally
  }
  
  public double c() {
    return this.f;
  }
  
  public void c(String paramString) {
    this.i = paramString;
  }
  
  public String d() {
    return this.g;
  }
  
  public void d(String paramString) {
    this.j = paramString;
  }
  
  public int e() {
    return this.h;
  }
  
  public void e(String paramString) {
    this.k = paramString;
  }
  
  public String f() {
    return this.i;
  }
  
  public String g() {
    return this.j;
  }
  
  public String h() {
    return this.k;
  }
  
  public BluedLoginResult i() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   4: ifnonnull -> 45
    //   7: ldc com/soft/blued/user/UserInfo
    //   9: monitorenter
    //   10: aload_0
    //   11: aload_0
    //   12: invokevirtual k : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   15: putfield c : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   18: aload_0
    //   19: getfield c : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   22: ifnonnull -> 33
    //   25: aload_0
    //   26: aload_0
    //   27: getfield d : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   30: putfield c : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   33: ldc com/soft/blued/user/UserInfo
    //   35: monitorexit
    //   36: goto -> 45
    //   39: astore_1
    //   40: ldc com/soft/blued/user/UserInfo
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: aload_0
    //   46: getfield c : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   49: areturn
    // Exception table:
    //   from	to	target	type
    //   10	33	39	finally
    //   33	36	39	finally
    //   40	43	39	finally
  }
  
  public boolean j() {
    // Byte code:
    //   0: ldc com/soft/blued/user/UserInfo
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual b : ()Ljava/lang/String;
    //   7: astore #5
    //   9: aload_0
    //   10: invokevirtual d : ()Ljava/lang/String;
    //   13: astore #6
    //   15: iconst_0
    //   16: istore_3
    //   17: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   20: invokevirtual e : ()I
    //   23: istore_1
    //   24: iload_1
    //   25: ifeq -> 66
    //   28: iload_1
    //   29: iconst_1
    //   30: if_icmpeq -> 66
    //   33: iload_1
    //   34: iconst_2
    //   35: if_icmpeq -> 43
    //   38: iload_3
    //   39: istore_2
    //   40: goto -> 102
    //   43: iload_3
    //   44: istore_2
    //   45: aload #5
    //   47: invokestatic e : (Ljava/lang/String;)Z
    //   50: ifne -> 102
    //   53: iload_3
    //   54: istore_2
    //   55: aload #6
    //   57: invokestatic e : (Ljava/lang/String;)Z
    //   60: ifne -> 102
    //   63: goto -> 115
    //   66: iload_3
    //   67: istore_2
    //   68: aload #5
    //   70: invokestatic e : (Ljava/lang/String;)Z
    //   73: ifne -> 102
    //   76: aload #6
    //   78: invokestatic e : (Ljava/lang/String;)Z
    //   81: istore #4
    //   83: iload_3
    //   84: istore_2
    //   85: iload #4
    //   87: ifne -> 102
    //   90: goto -> 115
    //   93: astore #5
    //   95: aload #5
    //   97: invokevirtual printStackTrace : ()V
    //   100: iload_3
    //   101: istore_2
    //   102: ldc com/soft/blued/user/UserInfo
    //   104: monitorexit
    //   105: iload_2
    //   106: ireturn
    //   107: astore #5
    //   109: ldc com/soft/blued/user/UserInfo
    //   111: monitorexit
    //   112: aload #5
    //   114: athrow
    //   115: iconst_1
    //   116: istore_2
    //   117: goto -> 102
    // Exception table:
    //   from	to	target	type
    //   3	15	107	finally
    //   17	24	93	java/lang/Exception
    //   17	24	107	finally
    //   45	53	93	java/lang/Exception
    //   45	53	107	finally
    //   55	63	93	java/lang/Exception
    //   55	63	107	finally
    //   68	83	93	java/lang/Exception
    //   68	83	107	finally
    //   95	100	107	finally
    //   102	105	107	finally
    //   109	112	107	finally
  }
  
  public BluedLoginResult k() {
    UserAccountsModel userAccountsModel = UserAccountsVDao.a().c();
    if (userAccountsModel != null)
      a(userAccountsModel.getUsername()); 
    if (userAccountsModel != null)
      b(userAccountsModel.getAccessToken()); 
    if (userAccountsModel != null)
      a(userAccountsModel.getLoginType()); 
    try {
      int i = this.h;
      if (i != 0 && i != 1) {
        if (i != 2)
          return null; 
        if (!TextUtils.isEmpty(this.e))
          return TextUtils.isEmpty(this.g) ? null : a(userAccountsModel); 
      } else {
        return TextUtils.isEmpty(this.e) ? null : a(userAccountsModel);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\user\UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
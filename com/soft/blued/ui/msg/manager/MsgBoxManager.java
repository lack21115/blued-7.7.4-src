package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MsgBoxManager {
  public static final String a = MsgBoxManager.class.getSimpleName();
  
  private static volatile MsgBoxManager b;
  
  private Set<Long> c = new HashSet<Long>();
  
  private Set<Long> d = new HashSet<Long>();
  
  private int e;
  
  private MsgBoxManager() {
    if (c()) {
      String str = BluedPreferences.ay(UserInfo.a().i().getUid());
      if (!TextUtils.isEmpty(str))
        for (String str1 : str.split(","))
          this.c.add(Long.valueOf(str1));  
    } 
  }
  
  private int a(long paramLong, List<SessionModel> paramList) {
    int j = paramList.size();
    int i;
    for (i = 0; i < paramList.size(); i++) {
      if (paramLong > ((SessionModel)paramList.get(i)).lastMsgTime)
        return i; 
    } 
    return j;
  }
  
  public static MsgBoxManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/msg/manager/MsgBoxManager.b : Lcom/soft/blued/ui/msg/manager/MsgBoxManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/msg/manager/MsgBoxManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/msg/manager/MsgBoxManager.b : Lcom/soft/blued/ui/msg/manager/MsgBoxManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/msg/manager/MsgBoxManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/msg/manager/MsgBoxManager.b : Lcom/soft/blued/ui/msg/manager/MsgBoxManager;
    //   25: ldc com/soft/blued/ui/msg/manager/MsgBoxManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/msg/manager/MsgBoxManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/msg/manager/MsgBoxManager.b : Lcom/soft/blued/ui/msg/manager/MsgBoxManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private boolean b(SessionModel paramSessionModel) {
    return (paramSessionModel.sessionType == 3 || d(paramSessionModel) || e(paramSessionModel) || g(paramSessionModel) || c(paramSessionModel) || !h(paramSessionModel));
  }
  
  private boolean c(SessionModel paramSessionModel) {
    return (paramSessionModel.sessionType == 1);
  }
  
  private void d() {
    if (this.c.isEmpty()) {
      BluedPreferences.b(UserInfo.a().i().getUid(), "");
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    Iterator<Long> iterator = this.c.iterator();
    while (iterator.hasNext()) {
      stringBuilder1.append(iterator.next());
      stringBuilder1.append(",");
    } 
    String str1 = stringBuilder1.toString();
    str1 = str1.substring(0, str1.length() - 1);
    String str2 = a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("saveBoxSessionId : ");
    stringBuilder2.append(str1);
    Logger.c(str2, new Object[] { stringBuilder2.toString() });
    BluedPreferences.b(UserInfo.a().i().getUid(), str1);
  }
  
  private boolean d(SessionModel paramSessionModel) {
    return (paramSessionModel.friend == 1);
  }
  
  private boolean e() {
    return (!StringUtils.e(BluedPreferences.cW()) && !BluedPreferences.cW().equals("0-0"));
  }
  
  private boolean e(SessionModel paramSessionModel) {
    return (paramSessionModel.sessionSettingModel != null) ? ((((SessionSettingModel)paramSessionModel.sessionSettingModel).getFollower() == 1)) : false;
  }
  
  private boolean f(SessionModel paramSessionModel) {
    return (paramSessionModel.vBadge == 3);
  }
  
  private boolean g(SessionModel paramSessionModel) {
    return (paramSessionModel.sourceFrom == 13 || paramSessionModel.sourceFrom == 14 || paramSessionModel.sourceFrom == 15 || paramSessionModel.sourceFrom == 16 || paramSessionModel.sourceFrom == 17 || paramSessionModel.sourceFrom == 22 || paramSessionModel.sourceFrom == 23 || paramSessionModel.sourceFrom == 24);
  }
  
  private boolean h(SessionModel paramSessionModel) {
    // Byte code:
    //   0: invokestatic cV : ()Ljava/lang/String;
    //   3: astore #7
    //   5: aload #7
    //   7: invokestatic e : (Ljava/lang/String;)Z
    //   10: istore #6
    //   12: iconst_1
    //   13: istore #5
    //   15: iload #6
    //   17: ifne -> 425
    //   20: invokestatic f : ()Lcom/google/gson/Gson;
    //   23: aload #7
    //   25: ldc java/util/Set
    //   27: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   30: checkcast java/util/Set
    //   33: astore #7
    //   35: aload #7
    //   37: ldc '1'
    //   39: invokeinterface contains : (Ljava/lang/Object;)Z
    //   44: ifeq -> 173
    //   47: aload_1
    //   48: getfield sourceFrom : I
    //   51: iconst_1
    //   52: if_icmpeq -> 168
    //   55: aload_1
    //   56: getfield sourceFrom : I
    //   59: iconst_2
    //   60: if_icmpeq -> 168
    //   63: aload_1
    //   64: getfield sourceFrom : I
    //   67: iconst_3
    //   68: if_icmpeq -> 168
    //   71: aload_1
    //   72: getfield sourceFrom : I
    //   75: iconst_4
    //   76: if_icmpeq -> 168
    //   79: aload_1
    //   80: getfield sourceFrom : I
    //   83: iconst_5
    //   84: if_icmpeq -> 168
    //   87: aload_1
    //   88: getfield sourceFrom : I
    //   91: bipush #6
    //   93: if_icmpeq -> 168
    //   96: aload_1
    //   97: getfield sourceFrom : I
    //   100: bipush #7
    //   102: if_icmpeq -> 168
    //   105: aload_1
    //   106: getfield sourceFrom : I
    //   109: bipush #19
    //   111: if_icmpeq -> 168
    //   114: aload_1
    //   115: getfield sourceFrom : I
    //   118: bipush #20
    //   120: if_icmpeq -> 168
    //   123: aload_1
    //   124: getfield sourceFrom : I
    //   127: bipush #25
    //   129: if_icmpeq -> 168
    //   132: aload_1
    //   133: getfield sourceFrom : I
    //   136: bipush #26
    //   138: if_icmpeq -> 168
    //   141: aload_1
    //   142: getfield sourceFrom : I
    //   145: bipush #27
    //   147: if_icmpeq -> 168
    //   150: aload_1
    //   151: getfield sourceFrom : I
    //   154: bipush #28
    //   156: if_icmpeq -> 168
    //   159: aload_1
    //   160: getfield sourceFrom : I
    //   163: bipush #31
    //   165: if_icmpne -> 173
    //   168: iconst_1
    //   169: istore_2
    //   170: goto -> 175
    //   173: iconst_0
    //   174: istore_2
    //   175: aload #7
    //   177: ldc '2'
    //   179: invokeinterface contains : (Ljava/lang/Object;)Z
    //   184: ifeq -> 390
    //   187: aload_1
    //   188: getfield sourceFrom : I
    //   191: bipush #8
    //   193: if_icmpeq -> 385
    //   196: aload_1
    //   197: getfield sourceFrom : I
    //   200: bipush #9
    //   202: if_icmpeq -> 385
    //   205: aload_1
    //   206: getfield sourceFrom : I
    //   209: bipush #10
    //   211: if_icmpeq -> 385
    //   214: aload_1
    //   215: getfield sourceFrom : I
    //   218: bipush #11
    //   220: if_icmpeq -> 385
    //   223: aload_1
    //   224: getfield sourceFrom : I
    //   227: bipush #12
    //   229: if_icmpeq -> 385
    //   232: aload_1
    //   233: getfield sourceFrom : I
    //   236: bipush #32
    //   238: if_icmpeq -> 385
    //   241: aload_1
    //   242: getfield sourceFrom : I
    //   245: bipush #33
    //   247: if_icmpeq -> 385
    //   250: aload_1
    //   251: getfield sourceFrom : I
    //   254: bipush #34
    //   256: if_icmpeq -> 385
    //   259: aload_1
    //   260: getfield sourceFrom : I
    //   263: bipush #35
    //   265: if_icmpeq -> 385
    //   268: aload_1
    //   269: getfield sourceFrom : I
    //   272: bipush #36
    //   274: if_icmpeq -> 385
    //   277: aload_1
    //   278: getfield sourceFrom : I
    //   281: bipush #37
    //   283: if_icmpeq -> 385
    //   286: aload_1
    //   287: getfield sourceFrom : I
    //   290: bipush #38
    //   292: if_icmpeq -> 385
    //   295: aload_1
    //   296: getfield sourceFrom : I
    //   299: bipush #39
    //   301: if_icmpeq -> 385
    //   304: aload_1
    //   305: getfield sourceFrom : I
    //   308: bipush #40
    //   310: if_icmpeq -> 385
    //   313: aload_1
    //   314: getfield sourceFrom : I
    //   317: bipush #41
    //   319: if_icmpeq -> 385
    //   322: aload_1
    //   323: getfield sourceFrom : I
    //   326: bipush #42
    //   328: if_icmpeq -> 385
    //   331: aload_1
    //   332: getfield sourceFrom : I
    //   335: bipush #43
    //   337: if_icmpeq -> 385
    //   340: aload_1
    //   341: getfield sourceFrom : I
    //   344: bipush #44
    //   346: if_icmpeq -> 385
    //   349: aload_1
    //   350: getfield sourceFrom : I
    //   353: bipush #45
    //   355: if_icmpeq -> 385
    //   358: aload_1
    //   359: getfield sourceFrom : I
    //   362: bipush #46
    //   364: if_icmpeq -> 385
    //   367: aload_1
    //   368: getfield sourceFrom : I
    //   371: bipush #47
    //   373: if_icmpeq -> 385
    //   376: aload_1
    //   377: getfield sourceFrom : I
    //   380: bipush #48
    //   382: if_icmpne -> 390
    //   385: iconst_1
    //   386: istore_3
    //   387: goto -> 392
    //   390: iconst_0
    //   391: istore_3
    //   392: aload #7
    //   394: ldc '3'
    //   396: invokeinterface contains : (Ljava/lang/Object;)Z
    //   401: ifeq -> 419
    //   404: aload_1
    //   405: getfield sourceFrom : I
    //   408: bipush #18
    //   410: if_icmpne -> 419
    //   413: iconst_1
    //   414: istore #4
    //   416: goto -> 432
    //   419: iconst_0
    //   420: istore #4
    //   422: goto -> 432
    //   425: iconst_0
    //   426: istore #4
    //   428: iconst_0
    //   429: istore_2
    //   430: iconst_0
    //   431: istore_3
    //   432: iload_2
    //   433: ifne -> 453
    //   436: iload_3
    //   437: ifne -> 453
    //   440: iload #4
    //   442: ifeq -> 448
    //   445: goto -> 453
    //   448: iconst_0
    //   449: istore_2
    //   450: goto -> 455
    //   453: iconst_1
    //   454: istore_2
    //   455: aload_0
    //   456: invokespecial e : ()Z
    //   459: ifeq -> 613
    //   462: aload_1
    //   463: getfield lastMsgFromDistance : Ljava/lang/String;
    //   466: invokestatic e : (Ljava/lang/String;)Z
    //   469: ifne -> 613
    //   472: ldc '0-100'
    //   474: invokestatic cW : ()Ljava/lang/String;
    //   477: invokevirtual equals : (Ljava/lang/Object;)Z
    //   480: ifeq -> 488
    //   483: iconst_1
    //   484: istore_3
    //   485: goto -> 615
    //   488: aload_1
    //   489: getfield lastMsgFromDistance : Ljava/lang/String;
    //   492: invokestatic c : (Ljava/lang/String;)Z
    //   495: ifeq -> 501
    //   498: goto -> 613
    //   501: invokestatic cW : ()Ljava/lang/String;
    //   504: ldc '-'
    //   506: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   509: astore #7
    //   511: aload #7
    //   513: ifnull -> 613
    //   516: aload #7
    //   518: arraylength
    //   519: iconst_2
    //   520: if_icmpne -> 613
    //   523: aload #7
    //   525: iconst_1
    //   526: aaload
    //   527: ldc '100'
    //   529: invokevirtual equals : (Ljava/lang/Object;)Z
    //   532: ifeq -> 562
    //   535: aload_1
    //   536: getfield lastMsgFromDistance : Ljava/lang/String;
    //   539: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
    //   542: invokevirtual floatValue : ()F
    //   545: aload #7
    //   547: iconst_0
    //   548: aaload
    //   549: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
    //   552: invokevirtual floatValue : ()F
    //   555: fcmpl
    //   556: iflt -> 613
    //   559: goto -> 483
    //   562: aload_1
    //   563: getfield lastMsgFromDistance : Ljava/lang/String;
    //   566: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
    //   569: invokevirtual floatValue : ()F
    //   572: aload #7
    //   574: iconst_0
    //   575: aaload
    //   576: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
    //   579: invokevirtual floatValue : ()F
    //   582: fcmpl
    //   583: iflt -> 613
    //   586: aload_1
    //   587: getfield lastMsgFromDistance : Ljava/lang/String;
    //   590: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
    //   593: invokevirtual floatValue : ()F
    //   596: aload #7
    //   598: iconst_1
    //   599: aaload
    //   600: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
    //   603: invokevirtual floatValue : ()F
    //   606: fcmpg
    //   607: ifgt -> 613
    //   610: goto -> 483
    //   613: iconst_0
    //   614: istore_3
    //   615: iload_2
    //   616: ifne -> 628
    //   619: iload_3
    //   620: ifeq -> 625
    //   623: iconst_1
    //   624: ireturn
    //   625: iconst_0
    //   626: istore #5
    //   628: iload #5
    //   630: ireturn
  }
  
  public List<SessionModel> a(List<SessionModel> paramList, boolean paramBoolean) {
    if (!c())
      return paramList; 
    this.c.clear();
    this.d.clear();
    this.e = 0;
    ArrayList<SessionModel> arrayList1 = new ArrayList();
    ArrayList<SessionModel> arrayList2 = new ArrayList();
    for (int i = 0; i < paramList.size(); i++) {
      SessionModel sessionModel = paramList.get(i);
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(sessionModel.lastMsgContent);
      stringBuilder.append("====source==");
      stringBuilder.append(sessionModel.sourceFrom);
      Logger.c(str, new Object[] { stringBuilder.toString() });
      str = a;
      stringBuilder = new StringBuilder();
      stringBuilder.append(sessionModel.lastMsgContent);
      stringBuilder.append("====isFriend==");
      stringBuilder.append(d(sessionModel));
      Logger.c(str, new Object[] { stringBuilder.toString() });
      str = a;
      stringBuilder = new StringBuilder();
      stringBuilder.append(sessionModel.lastMsgContent);
      stringBuilder.append("====isAttention==");
      stringBuilder.append(e(sessionModel));
      Logger.c(str, new Object[] { stringBuilder.toString() });
      str = a;
      stringBuilder = new StringBuilder();
      stringBuilder.append(sessionModel.lastMsgContent);
      stringBuilder.append("====isPurpleV==");
      stringBuilder.append(f(sessionModel));
      Logger.c(str, new Object[] { stringBuilder.toString() });
      str = a;
      stringBuilder = new StringBuilder();
      stringBuilder.append(sessionModel.lastMsgContent);
      stringBuilder.append("====isFromExposureOrHellCall==");
      stringBuilder.append(g(sessionModel));
      Logger.c(str, new Object[] { stringBuilder.toString() });
      str = a;
      stringBuilder = new StringBuilder();
      stringBuilder.append(sessionModel.lastMsgContent);
      stringBuilder.append("====isBoxMsg==");
      stringBuilder.append(h(sessionModel));
      Logger.c(str, new Object[] { stringBuilder.toString() });
      if (b(sessionModel)) {
        arrayList2.add(sessionModel);
      } else {
        this.c.add(Long.valueOf(sessionModel.sessionId));
        this.e += sessionModel.noReadMsgCount;
        if (sessionModel.noReadMsgCount > 0)
          this.d.add(Long.valueOf(sessionModel.sessionId)); 
        arrayList1.add(sessionModel);
      } 
    } 
    if (!paramBoolean) {
      SessionModel sessionModel = new SessionModel();
      sessionModel.sessionType = 6668;
      sessionModel.sessionId = 1L;
      if (arrayList1.size() > 0) {
        sessionModel.noReadMsgCount = this.e;
        SessionModel sessionModel1 = arrayList1.get(0);
        sessionModel.lastMsgType = sessionModel1.lastMsgType;
        sessionModel.lastMsgTime = sessionModel1.lastMsgTime;
        sessionModel.lastMsgContent = sessionModel1.lastMsgContent;
        sessionModel.lastMsgFromNickname = sessionModel1.lastMsgFromNickname;
        sessionModel.lastMsgFromId = sessionModel1.lastMsgFromId;
        sessionModel.lastMsgStateCode = sessionModel1.lastMsgStateCode;
        sessionModel.lastMsgExtra = sessionModel1.lastMsgExtra;
        SessionSettingModel sessionSettingModel = new SessionSettingModel();
        sessionSettingModel.setRemindAudio(0);
        sessionModel.sessionSettingModel = (SessionSettingBaseModel)sessionSettingModel;
      } else {
        sessionModel.lastMsgContent = AppInfo.d().getString(2131757943);
        sessionModel.lastMsgTime = BluedPreferences.dM();
      } 
      arrayList2.add(a(sessionModel.lastMsgTime, arrayList2), sessionModel);
    } 
    d();
    return paramBoolean ? arrayList1 : arrayList2;
  }
  
  public boolean a(long paramLong) {
    return this.c.contains(Long.valueOf(paramLong));
  }
  
  public boolean a(SessionModel paramSessionModel) {
    return (paramSessionModel == null) ? false : (b(paramSessionModel) ^ true);
  }
  
  public void b() {
    this.c.clear();
    this.d.clear();
  }
  
  public boolean c() {
    return ((UserInfo.a().i()).vip_grade != 0 && BluedPreferences.dL());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\manager\MsgBoxManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
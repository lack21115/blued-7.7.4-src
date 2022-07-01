package com.soft.blued.ui.search.presenter;

import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.ui.search.model.SearchSessionModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchLikeChatPresenter extends MvpPresenter {
  private long h;
  
  private short i;
  
  private String j;
  
  private String k;
  
  private Cursor l;
  
  private int m = 0;
  
  private int n = 20;
  
  private void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Landroid/database/Cursor;
    //   6: ifnonnull -> 31
    //   9: aload_0
    //   10: invokestatic a : ()Lcom/soft/blued/db/ChattingDao;
    //   13: aload_0
    //   14: getfield j : Ljava/lang/String;
    //   17: aload_0
    //   18: getfield h : J
    //   21: aload_0
    //   22: getfield i : S
    //   25: invokevirtual a : (Ljava/lang/String;JS)Landroid/database/Cursor;
    //   28: putfield l : Landroid/database/Cursor;
    //   31: aload_0
    //   32: getfield l : Landroid/database/Cursor;
    //   35: ifnull -> 581
    //   38: iload_1
    //   39: ifge -> 45
    //   42: goto -> 581
    //   45: new java/util/ArrayList
    //   48: dup
    //   49: invokespecial <init> : ()V
    //   52: astore_3
    //   53: aload_0
    //   54: getfield l : Landroid/database/Cursor;
    //   57: iload_1
    //   58: invokeinterface moveToPosition : (I)Z
    //   63: pop
    //   64: iload_2
    //   65: istore_1
    //   66: iload_2
    //   67: ifge -> 80
    //   70: aload_0
    //   71: getfield l : Landroid/database/Cursor;
    //   74: invokeinterface getCount : ()I
    //   79: istore_1
    //   80: aload_0
    //   81: getfield l : Landroid/database/Cursor;
    //   84: invokeinterface getPosition : ()I
    //   89: iload_1
    //   90: if_icmpge -> 524
    //   93: aload_0
    //   94: getfield l : Landroid/database/Cursor;
    //   97: invokeinterface isAfterLast : ()Z
    //   102: ifne -> 524
    //   105: new com/soft/blued/ui/search/model/SearchSessionModel
    //   108: dup
    //   109: invokespecial <init> : ()V
    //   112: astore #4
    //   114: aload #4
    //   116: aload_0
    //   117: getfield l : Landroid/database/Cursor;
    //   120: aload_0
    //   121: getfield l : Landroid/database/Cursor;
    //   124: ldc 'id'
    //   126: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   131: invokeinterface getInt : (I)I
    //   136: putfield dbId : I
    //   139: aload #4
    //   141: aload_0
    //   142: getfield l : Landroid/database/Cursor;
    //   145: aload_0
    //   146: getfield l : Landroid/database/Cursor;
    //   149: ldc 'msgTimestamp'
    //   151: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   156: invokeinterface getLong : (I)J
    //   161: putfield lastMsgTime : J
    //   164: aload #4
    //   166: aload_0
    //   167: getfield l : Landroid/database/Cursor;
    //   170: aload_0
    //   171: getfield l : Landroid/database/Cursor;
    //   174: ldc 'msgContent'
    //   176: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   181: invokeinterface getString : (I)Ljava/lang/String;
    //   186: putfield lastMsgContent : Ljava/lang/String;
    //   189: aload #4
    //   191: aload_0
    //   192: getfield l : Landroid/database/Cursor;
    //   195: aload_0
    //   196: getfield l : Landroid/database/Cursor;
    //   199: ldc 'msgStateCode'
    //   201: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   206: invokeinterface getShort : (I)S
    //   211: putfield lastMsgStateCode : S
    //   214: aload #4
    //   216: aload_0
    //   217: getfield l : Landroid/database/Cursor;
    //   220: aload_0
    //   221: getfield l : Landroid/database/Cursor;
    //   224: ldc 'msgId'
    //   226: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   231: invokeinterface getLong : (I)J
    //   236: putfield lastMsgId : J
    //   239: aload #4
    //   241: aload_0
    //   242: getfield l : Landroid/database/Cursor;
    //   245: aload_0
    //   246: getfield l : Landroid/database/Cursor;
    //   249: ldc 'msgLocalId'
    //   251: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   256: invokeinterface getLong : (I)J
    //   261: putfield lastMsgLocalId : J
    //   264: aload #4
    //   266: aload_0
    //   267: getfield l : Landroid/database/Cursor;
    //   270: aload_0
    //   271: getfield l : Landroid/database/Cursor;
    //   274: ldc 'avatar'
    //   276: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   281: invokeinterface getString : (I)Ljava/lang/String;
    //   286: putfield avatar : Ljava/lang/String;
    //   289: aload #4
    //   291: aload_0
    //   292: getfield l : Landroid/database/Cursor;
    //   295: aload_0
    //   296: getfield l : Landroid/database/Cursor;
    //   299: ldc 'vBadge'
    //   301: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   306: invokeinterface getInt : (I)I
    //   311: putfield vBadge : I
    //   314: aload #4
    //   316: aload_0
    //   317: getfield l : Landroid/database/Cursor;
    //   320: aload_0
    //   321: getfield l : Landroid/database/Cursor;
    //   324: ldc 'fromVipAnnual'
    //   326: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   331: invokeinterface getInt : (I)I
    //   336: putfield vipAnnual : I
    //   339: aload #4
    //   341: aload_0
    //   342: getfield l : Landroid/database/Cursor;
    //   345: aload_0
    //   346: getfield l : Landroid/database/Cursor;
    //   349: ldc 'fromVipExpLvl'
    //   351: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   356: invokeinterface getInt : (I)I
    //   361: putfield vipExpLvl : I
    //   364: aload #4
    //   366: aload_0
    //   367: getfield l : Landroid/database/Cursor;
    //   370: aload_0
    //   371: getfield l : Landroid/database/Cursor;
    //   374: ldc 'fromVipGrade'
    //   376: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   381: invokeinterface getInt : (I)I
    //   386: putfield vipGrade : I
    //   389: aload #4
    //   391: aload_0
    //   392: getfield l : Landroid/database/Cursor;
    //   395: aload_0
    //   396: getfield l : Landroid/database/Cursor;
    //   399: ldc 'fromHideVipLook'
    //   401: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   406: invokeinterface getInt : (I)I
    //   411: putfield hideVipLook : I
    //   414: aload #4
    //   416: iconst_1
    //   417: putfield a : I
    //   420: aload_0
    //   421: getfield l : Landroid/database/Cursor;
    //   424: aload_0
    //   425: getfield l : Landroid/database/Cursor;
    //   428: ldc 'fromId'
    //   430: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   435: invokeinterface getLong : (I)J
    //   440: invokestatic valueOf : (J)Ljava/lang/String;
    //   443: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   446: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   449: getfield uid : Ljava/lang/String;
    //   452: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   455: ifeq -> 475
    //   458: aload #4
    //   460: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   463: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   466: invokevirtual getName : ()Ljava/lang/String;
    //   469: putfield nickName : Ljava/lang/String;
    //   472: goto -> 484
    //   475: aload #4
    //   477: aload_0
    //   478: getfield k : Ljava/lang/String;
    //   481: putfield nickName : Ljava/lang/String;
    //   484: aload #4
    //   486: aload_0
    //   487: getfield h : J
    //   490: putfield sessionId : J
    //   493: aload #4
    //   495: aload_0
    //   496: getfield i : S
    //   499: putfield sessionType : S
    //   502: aload_3
    //   503: aload #4
    //   505: invokeinterface add : (Ljava/lang/Object;)Z
    //   510: pop
    //   511: aload_0
    //   512: getfield l : Landroid/database/Cursor;
    //   515: invokeinterface moveToNext : ()Z
    //   520: pop
    //   521: goto -> 80
    //   524: aload_0
    //   525: aload_3
    //   526: invokespecial a : (Ljava/util/List;)V
    //   529: aload_0
    //   530: ldc 'notify_list'
    //   532: aload_3
    //   533: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   536: iload_1
    //   537: aload_0
    //   538: getfield l : Landroid/database/Cursor;
    //   541: invokeinterface getCount : ()I
    //   546: if_icmplt -> 562
    //   549: aload_0
    //   550: ldc 'no_more_list'
    //   552: invokevirtual b : (Ljava/lang/String;)V
    //   555: aload_0
    //   556: invokevirtual o : ()V
    //   559: goto -> 578
    //   562: aload_0
    //   563: ldc 'has_more_list'
    //   565: invokevirtual b : (Ljava/lang/String;)V
    //   568: aload_0
    //   569: aload_0
    //   570: getfield m : I
    //   573: iconst_1
    //   574: iadd
    //   575: putfield m : I
    //   578: aload_0
    //   579: monitorexit
    //   580: return
    //   581: aload_0
    //   582: ldc 'empty_list'
    //   584: invokevirtual b : (Ljava/lang/String;)V
    //   587: aload_0
    //   588: invokevirtual o : ()V
    //   591: aload_0
    //   592: monitorexit
    //   593: return
    //   594: astore_3
    //   595: aload_0
    //   596: monitorexit
    //   597: aload_3
    //   598: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	594	finally
    //   31	38	594	finally
    //   45	64	594	finally
    //   70	80	594	finally
    //   80	472	594	finally
    //   475	484	594	finally
    //   484	521	594	finally
    //   524	559	594	finally
    //   562	578	594	finally
    //   581	591	594	finally
  }
  
  private void a(List<SearchSessionModel> paramList) {
    ArrayList<SearchSessionModel> arrayList = new ArrayList();
    Iterator<SearchSessionModel> iterator = paramList.iterator();
    for (SearchSessionModel searchSessionModel = null; iterator.hasNext(); searchSessionModel = searchSessionModel1) {
      SearchSessionModel searchSessionModel1 = iterator.next();
      if (a(searchSessionModel, searchSessionModel1) != 0) {
        arrayList.add(searchSessionModel1);
      } else if (searchSessionModel1.dbId > searchSessionModel.dbId) {
        arrayList.remove(searchSessionModel);
        arrayList.add(searchSessionModel1);
      } else {
        continue;
      } 
    } 
    paramList.clear();
    paramList.addAll(arrayList);
  }
  
  public int a(SearchSessionModel paramSearchSessionModel1, SearchSessionModel paramSearchSessionModel2) {
    if (paramSearchSessionModel1 == null && paramSearchSessionModel2 == null)
      return 0; 
    byte b = -1;
    if (paramSearchSessionModel1 == null)
      return -1; 
    if (paramSearchSessionModel2 == null)
      return 1; 
    int i = paramSearchSessionModel1.lastMsgId - paramSearchSessionModel2.lastMsgId cmp 0L;
    if (i != 0) {
      if (i > 0)
        b = 1; 
      return b;
    } 
    i = paramSearchSessionModel1.lastMsgLocalId - paramSearchSessionModel2.lastMsgLocalId cmp 0L;
    if (i != 0) {
      if (i > 0)
        b = 1; 
      return b;
    } 
    if (paramSearchSessionModel1.lastMsgId == 0L && paramSearchSessionModel1.lastMsgLocalId == 0L) {
      i = paramSearchSessionModel1.lastMsgTime - paramSearchSessionModel2.lastMsgTime cmp 0L;
      if (i == 0)
        return 0; 
      if (i > 0)
        b = 1; 
      return b;
    } 
    return 0;
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.j = paramBundle1.getString("word");
    this.h = paramBundle1.getLong("passby_session_id");
    this.i = paramBundle1.getShort("passby_session_type");
    this.k = paramBundle1.getString("passby_nick_name");
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void m() {
    ThreadManager.a().a(new Runnable(this) {
          public void run() {
            SearchLikeChatPresenter searchLikeChatPresenter = this.a;
            SearchLikeChatPresenter.a(searchLikeChatPresenter, 0, SearchLikeChatPresenter.a(searchLikeChatPresenter));
          }
        });
  }
  
  public void n() {
    ThreadManager.a().a(new Runnable(this) {
          public void run() {
            int i = SearchLikeChatPresenter.b(this.a) * SearchLikeChatPresenter.a(this.a);
            int j = SearchLikeChatPresenter.a(this.a);
            SearchLikeChatPresenter.a(this.a, i, j + i);
          }
        });
  }
  
  public void o() {
    Cursor cursor = this.l;
    if (cursor != null && !cursor.isClosed()) {
      this.l.close();
      this.l = null;
    } 
  }
  
  public String p() {
    return this.k;
  }
  
  public String q() {
    return this.j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\presenter\SearchLikeChatPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.search.presenter;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.db.BluedBaseDataHelper;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.search.model.SearchSessionModel;
import java.util.ArrayList;

public class SearchAllPresenter extends MvpPresenter {
  public boolean h = false;
  
  BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntityA<UserFindResult>>(this, g()) {
      protected BluedEntityA<UserFindResult> a(String param1String) {
        return (BluedEntityA<UserFindResult>)super.parseData(param1String);
      }
      
      public void a(BluedEntityA<UserFindResult> param1BluedEntityA) {
        if (param1BluedEntityA != null) {
          this.a.a("PERSON_LIST", param1BluedEntityA.data);
          SearchAllPresenter.a(this.a, param1BluedEntityA.hasMore());
          return;
        } 
        SearchAllPresenter.a(this.a, false);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        SearchAllPresenter.a(this.a, false);
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish(boolean param1Boolean) {
        super.onUIFinish(param1Boolean);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onUIFinish hasMore:");
        stringBuilder.append(SearchAllPresenter.a(this.a));
        Log.v("drb", stringBuilder.toString());
        SearchAllPresenter searchAllPresenter = this.a;
        searchAllPresenter.b("PERSON_LOADING", SearchAllPresenter.a(searchAllPresenter));
      }
      
      public void onUIStart() {
        super.onUIStart();
        this.a.e_("PERSON_LOADING");
      }
    };
  
  private boolean j = false;
  
  private Cursor k;
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (this.k == null || paramInt1 < 0) {
      b("MESSAGE_LIST");
      return;
    } 
    ArrayList<SearchSessionModel> arrayList = new ArrayList();
    while (this.k.moveToNext()) {
      SearchSessionModel searchSessionModel = new SearchSessionModel();
      Cursor cursor = this.k;
      searchSessionModel.lastMsgTime = cursor.getLong(cursor.getColumnIndexOrThrow("msgTimestamp"));
      cursor = this.k;
      searchSessionModel.dbId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
      cursor = this.k;
      searchSessionModel.lastMsgContent = cursor.getString(cursor.getColumnIndexOrThrow("msgContent"));
      cursor = this.k;
      searchSessionModel.avatar = cursor.getString(cursor.getColumnIndexOrThrow("sessionAvatar"));
      cursor = this.k;
      searchSessionModel.nickName = cursor.getString(cursor.getColumnIndexOrThrow("sessionNickName"));
      cursor = this.k;
      searchSessionModel.vBadge = cursor.getInt(cursor.getColumnIndexOrThrow("vBadge"));
      cursor = this.k;
      searchSessionModel.vipAnnual = cursor.getInt(cursor.getColumnIndexOrThrow("vipAnnual"));
      cursor = this.k;
      searchSessionModel.vipExpLvl = cursor.getInt(cursor.getColumnIndexOrThrow("vipExpLvl"));
      cursor = this.k;
      searchSessionModel.vipGrade = cursor.getInt(cursor.getColumnIndexOrThrow("vipGrade"));
      cursor = this.k;
      searchSessionModel.hideVipLook = cursor.getInt(cursor.getColumnIndexOrThrow("hideVipLook"));
      cursor = this.k;
      searchSessionModel.lastMsgStateCode = cursor.getShort(cursor.getColumnIndexOrThrow("lastMsgStateCode"));
      cursor = this.k;
      searchSessionModel.sessionType = cursor.getShort(cursor.getColumnIndexOrThrow("sessionType"));
      cursor = this.k;
      searchSessionModel.a = cursor.getInt(cursor.getColumnIndexOrThrow("msgCount"));
      cursor = this.k;
      searchSessionModel.lastMsgId = cursor.getLong(cursor.getColumnIndexOrThrow("msgId"));
      cursor = this.k;
      searchSessionModel.lastMsgLocalId = cursor.getLong(cursor.getColumnIndexOrThrow("msgLocalId"));
      cursor = this.k;
      searchSessionModel.c = cursor.getLong(cursor.getColumnIndexOrThrow("chatDbId"));
      cursor = this.k;
      searchSessionModel.b = cursor.getString(cursor.getColumnIndexOrThrow("sessinoNote"));
      cursor = this.k;
      long l = cursor.getLong(cursor.getColumnIndexOrThrow("sessionId"));
      searchSessionModel.sessionId = l;
      searchSessionModel.sessionSettingModel = ChatManager.dbOperImpl.getSessionSetting(searchSessionModel.sessionType, l);
      arrayList.add(searchSessionModel);
    } 
    a("MESSAGE_LIST", arrayList);
    if (paramInt2 >= this.k.getCount()) {
      b("MESSAGE_No_MORE");
    } else {
      b("MESSAGE_Has_MORE");
    } 
    m();
    b("MESSAGE_LIST", true);
  }
  
  private String e(String paramString) {
    return paramString.replace("/", "//").replace("'", "''").replace("[", "/[").replace("]", "/]").replace("%", "/%").replace("&", "/&").replace("_", "/_").replace("(", "/(").replace(")", "/)");
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.h = paramBundle1.getBoolean("from");
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/blued/android/framework/pool/ThreadManager;
    //   5: new com/soft/blued/ui/search/presenter/SearchAllPresenter$2
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: iload_2
    //   12: iload_3
    //   13: iload #4
    //   15: invokespecial <init> : (Lcom/soft/blued/ui/search/presenter/SearchAllPresenter;Ljava/lang/String;IIZ)V
    //   18: invokevirtual a : (Ljava/lang/Runnable;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	24	finally
  }
  
  public void a(String paramString1, String paramString2) {
    UserHttpUtils.a((Context)h(), this.i, paramString1, paramString2, g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void d(String paramString) {
    a(paramString, "1");
    a(paramString, 0, 4, true);
  }
  
  public void m() {
    Cursor cursor = this.k;
    if (cursor != null && !cursor.isClosed()) {
      this.k.close();
      this.k = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\presenter\SearchAllPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.live.presenter;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.observer.LiveListRefreshObserver;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveHotListDiversion;
import com.soft.blued.ui.live.model.LiveListCommonModel;
import com.soft.blued.ui.live.model.LiveListRankFlagExtra;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiveListHotPresenter extends MvpPresenter {
  private LiveListCommonModel h;
  
  private List<BluedLiveListData> i;
  
  private List<BluedLiveListData> j;
  
  private List<LiveHotListDiversion> k;
  
  private List<BluedLiveListData> l;
  
  private List<BluedLiveListData> m;
  
  private List<BluedLiveListData> n;
  
  private int o;
  
  private int p;
  
  private boolean q = false;
  
  private void a(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> paramBluedEntity, IFetchDataListener paramIFetchDataListener) {
    LiveListCommonModel liveListCommonModel;
    ArrayList arrayList = new ArrayList();
    if (paramBluedEntity == null) {
      try {
        if (this.h.getPage() == 1) {
          if (paramIFetchDataListener != null) {
            paramIFetchDataListener.a("HOT_LIST", null);
            return;
          } 
        } else {
          this.h.setPage(this.h.getPage() - 1);
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        if (this.h.getPage() != 1) {
          liveListCommonModel = this.h;
          liveListCommonModel.setPage(liveListCommonModel.getPage() - 1);
        } 
        AppMethods.a(h().getString(2131756082));
        return;
      } 
    } else {
      List list = ((BluedEntity)liveListCommonModel).data;
      if (list != null && ((BluedEntity)liveListCommonModel).data.size() > 0) {
        boolean bool = liveListCommonModel.hasMore();
        this.h.setHasData(bool);
        if (!bool && paramIFetchDataListener != null)
          paramIFetchDataListener.b(); 
        if (this.h.getPage() == 1) {
          this.o = ((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).rankflag;
          LiveListRefreshObserver.a(this.o);
          this.l.clear();
          if (((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).fresh_beans_list != null)
            this.l.addAll(((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).fresh_beans_list); 
          this.m.clear();
          if (((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).official_list != null)
            this.m.addAll(((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).official_list); 
          this.n.clear();
          if (((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).hotpk_list != null)
            this.n.addAll(((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).hotpk_list); 
          this.k.clear();
          if (((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).hot_list_diversion != null)
            this.k.addAll(((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).hot_list_diversion); 
          this.p = ((LiveListRankFlagExtra)((BluedEntity)liveListCommonModel).extra).pkhasmore;
          if (this.k.size() > 0)
            for (int i = 0;; i++) {
              if (i < this.k.size()) {
                LiveHotListDiversion liveHotListDiversion = this.k.get(i);
                BluedLiveListData bluedLiveListData = new BluedLiveListData();
                bluedLiveListData.hot_diversion = liveHotListDiversion;
                bluedLiveListData.lid = String.valueOf(liveHotListDiversion.id);
                if (((BluedEntity)liveListCommonModel).data.size() > liveHotListDiversion.index)
                  ((BluedEntity)liveListCommonModel).data.add(liveHotListDiversion.index, bluedLiveListData); 
                continue;
              } 
              if (this.n.size() > 0) {
                BluedLiveListData bluedLiveListData = new BluedLiveListData();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bluedLiveListData.hashCode());
                stringBuilder.append("");
                bluedLiveListData.lid = stringBuilder.toString();
                bluedLiveListData.liveType = 7;
                bluedLiveListData.hotpk_list = this.n;
                ((BluedEntity)liveListCommonModel).data.add(0, bluedLiveListData);
                LogData logData = new LogData();
                logData.J = "live_list_pk_show";
                logData.a = String.valueOf(this.n.size());
                InstantLog.a(logData);
              } 
            }  
        } else {
          a(((BluedEntity)liveListCommonModel).data);
          arrayList.addAll(((BluedEntity)liveListCommonModel).data);
          Log.i("xpm", "b====");
          if (paramIFetchDataListener != null)
            paramIFetchDataListener.a("HOT_LIST", arrayList); 
          if (o() == 1)
            this.i.clear(); 
          this.i.addAll(((BluedEntity)liveListCommonModel).data);
          if (this.o != BluedPreferences.br()) {
            LiveListRefreshObserver.a().a(true);
            return;
          } 
        } 
      } else {
        if (this.h.getPage() == 1) {
          Log.i("xpm", "c====");
          if (paramIFetchDataListener != null)
            paramIFetchDataListener.a("HOT_LIST", arrayList); 
        } else {
          this.h.setPage(this.h.getPage() - 1);
        } 
        if (paramIFetchDataListener != null) {
          paramIFetchDataListener.b();
          return;
        } 
        return;
      } 
      if (this.n.size() > 0) {
        BluedLiveListData bluedLiveListData = new BluedLiveListData();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bluedLiveListData.hashCode());
        stringBuilder.append("");
        bluedLiveListData.lid = stringBuilder.toString();
        bluedLiveListData.liveType = 7;
        bluedLiveListData.hotpk_list = this.n;
        ((BluedEntity)liveListCommonModel).data.add(0, bluedLiveListData);
        LogData logData = new LogData();
        logData.J = "live_list_pk_show";
        logData.a = String.valueOf(this.n.size());
        InstantLog.a(logData);
      } 
    } 
  }
  
  private void a(List<BluedLiveListData> paramList) {
    if (this.l.size() != 0 && paramList != null) {
      if (paramList.size() == 0)
        return; 
      for (BluedLiveListData bluedLiveListData : this.l) {
        if (paramList.size() > 0) {
          Iterator<BluedLiveListData> iterator = paramList.iterator();
          while (iterator.hasNext()) {
            BluedLiveListData bluedLiveListData1 = iterator.next();
            if (bluedLiveListData.lid.equals(bluedLiveListData1.lid))
              iterator.remove(); 
          } 
        } 
      } 
    } 
  }
  
  private void a(boolean paramBoolean, IFetchDataListener paramIFetchDataListener) {
    LiveListCommonModel liveListCommonModel;
    if (paramBoolean) {
      m();
      this.h.setPage(1);
      this.h.setHasData(true);
    } else {
      LiveListCommonModel liveListCommonModel1 = this.h;
      liveListCommonModel1.setPage(liveListCommonModel1.getPage() + 1);
      if (!this.h.getHasData() && this.h.getPage() != 1) {
        liveListCommonModel = this.h;
        liveListCommonModel.setPage(liveListCommonModel.getPage() - 1);
        AppMethods.a(h().getResources().getString(2131756083));
        b("", false);
        return;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("requestLiveListData page:");
    stringBuilder.append(o());
    Log.i("xpm", stringBuilder.toString());
    c((IFetchDataListener)liveListCommonModel);
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.h = new LiveListCommonModel();
    this.i = new ArrayList<BluedLiveListData>();
    this.j = new ArrayList<BluedLiveListData>();
    this.k = new ArrayList<LiveHotListDiversion>();
    this.m = new ArrayList<BluedLiveListData>();
    this.l = new ArrayList<BluedLiveListData>();
    this.n = new ArrayList<BluedLiveListData>();
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    a(true, paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    a(false, paramIFetchDataListener);
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    BluedUIHttpResponse<BluedEntity<BluedLiveListData, LiveListRankFlagExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<BluedLiveListData, LiveListRankFlagExtra>>(this, "hot_live_list", null, paramIFetchDataListener) {
        public void onUICache(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> param1BluedEntity) {
          super.onUICache(param1BluedEntity);
          LiveListHotPresenter.a(this.b, param1BluedEntity, this.a);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          LiveListHotPresenter.a(this.b, (BluedEntity)null, this.a);
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish() {
          IFetchDataListener iFetchDataListener = this.a;
          if (iFetchDataListener != null)
            iFetchDataListener.a(true); 
        }
        
        public void onUIUpdate(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> param1BluedEntity) {
          LiveListHotPresenter.a(this.b, param1BluedEntity, this.a);
        }
      };
    if (!this.q && this.h.getPage() == 1) {
      Log.i("xpm", "refresh cache");
      this.q = true;
      bluedUIHttpResponse.refresh();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.h.getPage());
    stringBuilder.append("");
    LiveHttpUtils.b(bluedUIHttpResponse, stringBuilder.toString(), null);
  }
  
  public boolean c() {
    return false;
  }
  
  public void m() {
    List<BluedLiveListData> list = this.l;
    if (list != null)
      list.clear(); 
    list = this.m;
    if (list != null)
      list.clear(); 
    list = this.i;
    if (list != null)
      list.clear(); 
    list = this.j;
    if (list != null)
      list.clear(); 
  }
  
  public int n() {
    List<BluedLiveListData> list = this.l;
    int j = 0;
    if (list != null)
      j = 0 + list.size(); 
    list = this.m;
    int i = j;
    if (list != null)
      i = j + list.size(); 
    list = this.i;
    j = i;
    if (list != null)
      j = i + list.size(); 
    list = this.j;
    i = j;
    if (list != null)
      i = j + list.size(); 
    return i;
  }
  
  public int o() {
    return this.h.getPage();
  }
  
  public boolean p() {
    return (this.p == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveListHotPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
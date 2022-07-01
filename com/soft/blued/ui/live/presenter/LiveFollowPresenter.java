package com.soft.blued.ui.live.presenter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveRecommendExtra;
import com.soft.blued.ui.live.model.LiveRecommendModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.Iterator;
import java.util.List;

public class LiveFollowPresenter extends MvpPresenter {
  public int h = 1;
  
  private final String i = "LiveFollowPresenter";
  
  private String j;
  
  private List<LiveRecommendModel> k;
  
  private int l = 1;
  
  private boolean m;
  
  private boolean n;
  
  private boolean o = false;
  
  private String a(int paramInt) {
    return h().getResources().getString(paramInt);
  }
  
  private void a(BluedUIHttpResponse<BluedEntity<LiveRecommendModel, LiveRecommendExtra>> paramBluedUIHttpResponse) {
    LiveHttpUtils.a(paramBluedUIHttpResponse, g(), this.h, this.j);
  }
  
  private void a(List<BluedLiveListData> paramList) {
    if (paramList == null)
      return; 
    List<LiveRecommendModel> list = this.k;
    if (list != null) {
      BluedLiveListData bluedLiveListData1;
      if (list.isEmpty())
        return; 
      List list1 = null;
      Iterator<BluedLiveListData> iterator = paramList.iterator();
      int i = 0;
      while (true) {
        list = list1;
        if (iterator.hasNext()) {
          if (((BluedLiveListData)iterator.next()).livetype == 0) {
            Logger.e("LiveFollowPresenter", new Object[] { "推荐数为：", Integer.valueOf(this.k.size()) });
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("position = ");
            stringBuilder.append(i);
            Logger.e("LiveFollowPresenter", new Object[] { stringBuilder.toString() });
            this.o = true;
            bluedLiveListData1 = n();
            break;
          } 
          i++;
          continue;
        } 
        break;
      } 
      BluedLiveListData bluedLiveListData2 = bluedLiveListData1;
      if (bluedLiveListData1 == null) {
        Logger.e("LiveFollowPresenter", new Object[] { "listData == null 推荐数为：", Integer.valueOf(this.k.size()) });
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("listData == null position = ");
        stringBuilder.append(i);
        Logger.e("LiveFollowPresenter", new Object[] { stringBuilder.toString() });
        bluedLiveListData2 = n();
      } 
      if (this.o)
        paramList.add(i, bluedLiveListData2); 
    } 
  }
  
  private void b(BluedLiveListData paramBluedLiveListData) {
    UserHttpUtils.a((Context)h(), new UserRelationshipUtils.IAddOrRemoveAttentionDone(this, paramBluedLiveListData) {
          public void a() {}
          
          public void a(String param1String) {}
          
          public void b() {}
          
          public void b(String param1String) {
            this.b.a("recommend_list_user_no_more", this.a, false);
          }
          
          public void c() {}
        }paramBluedLiveListData.uid, "", null);
  }
  
  private void d(IFetchDataListener paramIFetchDataListener) {
    a(new BluedUIHttpResponse<BluedEntity<LiveRecommendModel, LiveRecommendExtra>>(this, g(), paramIFetchDataListener) {
          public void onUIUpdate(BluedEntity<LiveRecommendModel, LiveRecommendExtra> param1BluedEntity) {
            LiveRecommendExtra liveRecommendExtra = (LiveRecommendExtra)param1BluedEntity.extra;
            if (liveRecommendExtra == null) {
              this.b.c(this.a);
              return;
            } 
            if (liveRecommendExtra.is_new == 1) {
              this.b.a("recommend_list_user", param1BluedEntity.data);
            } else {
              LiveFollowPresenter.b(this.b, param1BluedEntity.data);
              this.b.c(this.a);
            } 
            LiveFollowPresenter.a(this.b, liveRecommendExtra.last_id);
            if (param1BluedEntity.hasMore()) {
              LiveFollowPresenter liveFollowPresenter = this.b;
              liveFollowPresenter.h++;
            } 
          }
        });
  }
  
  private BluedLiveListData n() {
    BluedLiveListData bluedLiveListData = new BluedLiveListData();
    bluedLiveListData.liveType = 1;
    bluedLiveListData.livetype = 0;
    bluedLiveListData.liveRecommendModelList = this.k;
    bluedLiveListData.recommendType = 1;
    bluedLiveListData.lid = "0";
    bluedLiveListData.anchor = new UserBasicModel();
    return bluedLiveListData;
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    LiveEventBus.get("delete_all_recommend_user", String.class).observe(paramLifecycleOwner, new Observer<String>(this) {
          public void a(String param1String) {
            this.a.m();
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.h = 1;
    this.l = 1;
    this.o = false;
    List<LiveRecommendModel> list = this.k;
    if (list != null) {
      list.clear();
      this.k = null;
    } 
    d(paramIFetchDataListener);
  }
  
  public void a(BluedLiveListData paramBluedLiveListData) {
    if (paramBluedLiveListData == null)
      return; 
    CommonAlertDialog.a((Context)h(), "", a(2131757136), a(2131756086), new DialogInterface.OnClickListener(this, paramBluedLiveListData) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (BluedPreferences.aL()) {
              AlertDialog alertDialog = (new AlertDialog.Builder((Context)this.b.h())).create();
              Window window = alertDialog.getWindow();
              alertDialog.show();
              window.setContentView(LayoutInflater.from((Context)this.b.h()).inflate(2131492980, null));
              window.clearFlags(131072);
              alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
                    public boolean onKey(DialogInterface param2DialogInterface, int param2Int, KeyEvent param2KeyEvent) {
                      return (param2Int == 4);
                    }
                  });
              ((TextView)window.findViewById(2131296926)).setOnClickListener(new View.OnClickListener(this, (Dialog)alertDialog) {
                    public void onClick(View param2View) {
                      Dialog dialog = this.a;
                      if (dialog != null)
                        dialog.cancel(); 
                      BluedPreferences.aM();
                      LiveFollowPresenter.a(this.b.b, this.b.a);
                    }
                  });
              return;
            } 
            LiveFollowPresenter.a(this.b, this.a);
          }
        }a(2131756057), null, null);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    c(paramIFetchDataListener);
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    LiveHttpUtils.a((Context)h(), new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(this, g(), paramIFetchDataListener) {
          protected BluedEntityA<BluedLiveListData> a(String param1String) {
            Logger.a("LiveFollowPresenter", new Object[] { "getLiveListFollow, content:", param1String });
            return (BluedEntityA<BluedLiveListData>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<BluedLiveListData> param1BluedEntityA) {
            if (param1BluedEntityA == null || !param1BluedEntityA.hasData()) {
              LiveFollowPresenter.a(this.b, false);
              return;
            } 
            LiveFollowPresenter.a(this.b, param1BluedEntityA.hasMore());
            if (!LiveFollowPresenter.a(this.b))
              LiveFollowPresenter.a(this.b, param1BluedEntityA.data); 
            this.a.a("follow_list_user", param1BluedEntityA.data);
            if (LiveFollowPresenter.b(this.b))
              LiveFollowPresenter.c(this.b); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            LiveFollowPresenter.a(this.b, false);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            Logger.e("LiveFollowPresenter", new Object[] { "onFinish" });
            if (!LiveFollowPresenter.b(this.b))
              this.a.b(); 
            this.a.a(param1Boolean);
          }
        }UserInfo.a().i().getUid(), String.valueOf(this.l), g());
  }
  
  public void m() {
    a(new BluedUIHttpResponse<BluedEntity<LiveRecommendModel, LiveRecommendExtra>>(this, g()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            LiveFollowPresenter.b(this.a, false);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (LiveFollowPresenter.d(this.a)) {
              this.a.b("recommend_list_user_has_more");
              return;
            } 
            this.a.b("recommend_list_user_no_more");
          }
          
          public void onUIUpdate(BluedEntity<LiveRecommendModel, LiveRecommendExtra> param1BluedEntity) {
            if (param1BluedEntity == null || param1BluedEntity.data == null || param1BluedEntity.extra == null) {
              LiveFollowPresenter.b(this.a, false);
              return;
            } 
            LiveFollowPresenter.a(this.a, ((LiveRecommendExtra)param1BluedEntity.extra).last_id);
            this.a.a("more_recommend_list_new_user", param1BluedEntity.data, false);
            if (param1BluedEntity.hasMore()) {
              LiveFollowPresenter liveFollowPresenter = this.a;
              liveFollowPresenter.h++;
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveFollowPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
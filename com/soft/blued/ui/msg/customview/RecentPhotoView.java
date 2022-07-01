package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.SelectPhotoBarView;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.common_contract.ISelectPhotoBarCallback;
import com.soft.blued.ui.msg.adapter.RecentPhotoAdapter;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import com.soft.blued.ui.msg.pop.GuideCenterBluedPop;
import com.soft.blued.ui.msg.pop.PicPinPop;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class RecentPhotoView extends RelativeLayout {
  public static final String a = RecentPhotoView.class.getSimpleName();
  
  private View b;
  
  private RecyclerView c;
  
  private SelectPhotoBarView d;
  
  private RecentPhotoAdapter e;
  
  private IRecentPhotoOperationCallback f;
  
  private View g;
  
  private GuideCenterBluedPop h;
  
  public RecentPhotoView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public RecentPhotoView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecentPhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    a(paramContext);
    this.c = (RecyclerView)findViewById(2131299291);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(paramContext);
    linearLayoutManager.setOrientation(0);
    this.c.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), 2.0F));
    spacesItemDecoration.a(0);
    spacesItemDecoration.a(DensityUtils.a(getContext(), 3.0F), 0, DensityUtils.a(getContext(), 3.0F), 0);
    spacesItemDecoration.a(true, true);
    this.c.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
    this.b = findViewById(2131299288);
    this.d = (SelectPhotoBarView)findViewById(2131299285);
  }
  
  private void a(View paramView) {
    if (this.h == null)
      this.h = new GuideCenterBluedPop(getContext()); 
    if (this.h.r())
      return; 
    BluedPreferences.eL();
    (new XPopup.Builder(getContext())).a(paramView).a(false).a(PopupAnimation.a).a(PopupPosition.c).b(Boolean.valueOf(true)).c(Boolean.valueOf(false)).a((BasePopupView)this.h).h();
  }
  
  private void a(MsgRecentPhotoInfo paramMsgRecentPhotoInfo, View paramView) {
    PicPinPop picPinPop = new PicPinPop(getContext(), paramMsgRecentPhotoInfo.isPin, new PicPinPop.OperateListener(this, paramMsgRecentPhotoInfo) {
          public void a() {
            CommonAlertDialog.a(this.b.getContext(), this.b.getContext().getResources().getString(2131758059), this.b.getContext().getResources().getString(2131758058), this.b.getContext().getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    RecentPhotoView.a(this.a.b).n().remove(this.a.a);
                    if (RecentPhotoView.a(this.a.b).n().size() == 0) {
                      RecentPhotoView.b(this.a.b);
                    } else {
                      RecentPhotoView.c(this.a.b).a(this.a.a);
                    } 
                    this.a.b.a(false);
                  }
                },  this.b.getContext().getResources().getString(2131756057), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {}
                },  null);
          }
          
          public void b() {
            RecentPhotoView.c(this.b).b(this.a);
            RecentPhotoView.c(this.b).a(new IRecentPhotoAdapterCallback.IGetPhotoListCallback(this) {
                  public void a(List<MsgRecentPhotoInfo> param2List) {
                    RecentPhotoView.a(this.a.b).c(param2List);
                  }
                });
          }
        });
    (new XPopup.Builder(getContext())).a(paramView).a(PopupAnimation.a).a(PopupPosition.c).b(Boolean.valueOf(true)).c(Boolean.valueOf(false)).a(true).a((BasePopupView)picPinPop).h();
  }
  
  private void d() {
    this.g = View.inflate(getContext(), 2131493754, null);
    this.e.b(this.g, -1, 0);
    this.g.setVisibility(8);
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            RecentPhotoView.d(this.a);
          }
        });
  }
  
  private void e() {
    this.f.S();
    this.e.n().clear();
    this.e.notifyDataSetChanged();
    a(false);
    View view = this.b;
    if (view != null)
      view.setVisibility(0); 
    RecyclerView recyclerView = this.c;
    if (recyclerView != null)
      recyclerView.setVisibility(8); 
  }
  
  private void f() {
    CommonAlertDialog.a(getContext(), getContext().getString(2131757962), getResources().getString(2131757961), getContext().getString(2131757960), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            RecentPhotoView.b(this.a);
            EventTrackMessage.a(MessageProtos.Event.MSG_PHOTO_CLEAR_BTN_CLICK);
          }
        },  getContext().getString(2131756057), null, null);
  }
  
  private void g() {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            if (this.a.getVisibility() == 0 && RecentPhotoView.a(this.a) != null && RecentPhotoView.a(this.a).n().size() > 0 && RecentPhotoView.f(this.a) != null && RecentPhotoView.f(this.a).getChildCount() > 0) {
              RecentPhotoView recentPhotoView = this.a;
              RecentPhotoView.b(recentPhotoView, (View)recentPhotoView);
            } 
          }
        }200L);
  }
  
  private void setFixForRecycleView(View paramView) {
    if (this.c != null && paramView != null) {
      int i = paramView.getWidth();
      Rect rect = new Rect();
      paramView.getLocalVisibleRect(rect);
      if (rect.left > 0 && rect.right == i) {
        this.c.scrollBy(-rect.left, 0);
        return;
      } 
      if (rect.left == 0 && rect.right < i)
        this.c.scrollBy(i - rect.right, 0); 
    } 
  }
  
  protected View a(Context paramContext) {
    return View.inflate(paramContext, 2131494249, (ViewGroup)this);
  }
  
  public void a() {
    SelectPhotoBarView selectPhotoBarView = this.d;
    if (selectPhotoBarView != null)
      selectPhotoBarView.b(); 
  }
  
  public void a(IRequestHost paramIRequestHost, IRecentPhotoOperationCallback paramIRecentPhotoOperationCallback) {
    this.f = paramIRecentPhotoOperationCallback;
    this.e = new RecentPhotoAdapter(paramIRequestHost, paramIRecentPhotoOperationCallback);
    this.e.a(this.c);
    this.c.setAdapter((RecyclerView.Adapter)this.e);
    this.d.setOperationCallback(paramIRecentPhotoOperationCallback);
    this.e.a(new BaseQuickAdapter.OnItemLongClickListener(this) {
          public boolean a(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            MsgRecentPhotoInfo msgRecentPhotoInfo = param1BaseQuickAdapter.n().get(param1Int);
            RecentPhotoView.a(this.a, param1View);
            RecentPhotoView.a(this.a, msgRecentPhotoInfo, param1View);
            return true;
          }
        });
    d();
  }
  
  public void a(boolean paramBoolean) {
    IRecentPhotoOperationCallback iRecentPhotoOperationCallback = this.f;
    if (iRecentPhotoOperationCallback != null && iRecentPhotoOperationCallback.Q() != null)
      if (this.f.Q().size() > 0) {
        this.f.b(new IRecentPhotoAdapterCallback.IGetPhotoListCallback(this) {
              public void a(List<MsgRecentPhotoInfo> param1List) {
                AppInfo.n().post(new Runnable(this, param1List) {
                      public void run() {
                        if (RecentPhotoView.g(this.b.a) != null)
                          RecentPhotoView.g(this.b.a).a(this.a.size()); 
                      }
                    });
              }
            });
        View view = this.b;
        if (view != null)
          view.setVisibility(8); 
        RecyclerView recyclerView = this.c;
        if (recyclerView != null)
          recyclerView.setVisibility(0); 
        if (this.e != null) {
          this.g.setVisibility(0);
          this.e.notifyDataSetChanged();
        } 
        if (paramBoolean) {
          this.c.scrollToPosition(0);
          return;
        } 
      } else {
        View view = this.b;
        if (view != null)
          view.setVisibility(0); 
        RecyclerView recyclerView = this.c;
        if (recyclerView != null)
          recyclerView.setVisibility(4); 
        SelectPhotoBarView selectPhotoBarView = this.d;
        if (selectPhotoBarView != null)
          selectPhotoBarView.a(0); 
      }  
  }
  
  public void b() {
    setVisibility(0);
    if (!BluedPreferences.eM()) {
      g();
      this.e.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) {
            public void onChanged() {
              if (!BluedPreferences.eM())
                RecentPhotoView.e(this.a); 
            }
          });
    } 
    a(false);
  }
  
  public void c() {
    setVisibility(8);
  }
  
  public static interface IRecentPhotoOperationCallback extends ISelectPhotoBarCallback, IRecentPhotoAdapterCallback {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\RecentPhotoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
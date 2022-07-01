package com.blued.android.module.media.selector.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.contract.IAlbumBaseView;
import com.blued.android.module.media.selector.model.GroupImageInfo;
import com.blued.android.module.media.selector.present.AlbumBasePresenter;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.media.selector.utils.ThumbLoader;
import com.blued.android.module.media.selector.utils.Tools;
import com.blued.android.module.media.selector.view.AlbumRecyclerView;
import com.blued.android.module.media.selector.view.NoDataAndLoadFailView;
import com.blued.android.module.media.selector.widget.PopMenu;

public abstract class AlbumBaseFragment extends MediaBaseFragment<IAlbumBaseView, AlbumBasePresenter> implements MemoryRequest.MemoryListener, IAlbumBaseView {
  private Context d;
  
  private View g;
  
  private View h;
  
  private View i;
  
  private TextView j;
  
  private TextView k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private ImageView o;
  
  private FrameLayout p;
  
  private FrameLayout q;
  
  private FrameLayout r;
  
  private AlbumRecyclerView s;
  
  private RecyclerView.Adapter t;
  
  private NoDataAndLoadFailView u;
  
  private PopMenu v;
  
  private PopAdapter w;
  
  private Dialog x;
  
  private int y = 6;
  
  private boolean z = true;
  
  private void D() {
    ListView listView = new ListView(this.d);
    listView.setDivider(null);
    this.w = new PopAdapter(this);
    listView.setAdapter((ListAdapter)this.w);
    this.v = new PopMenu(this.d, (View)listView);
    this.v.a(new PopupWindow.OnDismissListener(this) {
          public void onDismiss() {
            if (this.a.t() != null) {
              AlbumBaseFragment.c(this.a).setImageDrawable(this.a.t());
              return;
            } 
            AlbumBaseFragment.c(this.a).setImageDrawable(AlbumBaseFragment.d(this.a).getResources().getDrawable(R.drawable.media_arrow_down_icon));
          }
        });
  }
  
  private void E() {
    if (!TextUtils.isEmpty(o())) {
      if (this.z) {
        this.j.setVisibility(0);
        Animation animation = AnimationUtils.loadAnimation(this.d, R.anim.photo_select_tips_in);
        this.j.startAnimation(animation);
        AppInfo.n().post(new Runnable(this) {
              public void run() {
                if (AlbumBaseFragment.f(this.a) == 0) {
                  Animation animation = AnimationUtils.loadAnimation(AlbumBaseFragment.d(this.a), R.anim.photo_select_tips_out);
                  AlbumBaseFragment.g(this.a).startAnimation(animation);
                  AlbumBaseFragment.g(this.a).setVisibility(8);
                  return;
                } 
                AlbumBaseFragment.h(this.a);
                if (AlbumBaseFragment.f(this.a) == 0) {
                  AppInfo.n().post(this);
                  return;
                } 
                AppInfo.n().postDelayed(this, 1000L);
              }
            });
        this.z = false;
        return;
      } 
      this.j.setVisibility(8);
    } 
  }
  
  private void F() {
    this.r.setVisibility(0);
    TextView textView = this.m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e.c());
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    this.n.setAlpha(1.0F);
    this.n.setEnabled(true);
  }
  
  private void G() {
    this.r.setVisibility(8);
    this.n.setAlpha(0.3F);
    this.n.setEnabled(false);
  }
  
  protected AlbumBasePresenter A() {
    return new AlbumBasePresenter();
  }
  
  protected void B() {
    if (r() == null)
      if (!x()) {
        this.i.setVisibility(0);
        this.i.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                if (AlbumBaseFragment.a(this.a) != null) {
                  AlbumBaseFragment.a(this.a).a(AlbumBaseFragment.e(this.a));
                  if (this.a.u() != null) {
                    AlbumBaseFragment.c(this.a).setImageDrawable(this.a.u());
                    return;
                  } 
                  AlbumBaseFragment.c(this.a).setImageDrawable(AlbumBaseFragment.d(this.a).getResources().getDrawable(R.drawable.media_arrow_up_icon));
                } 
              }
            });
      } else {
        this.i.setVisibility(8);
      }  
    if (q() != null) {
      if (this.q.getChildCount() > 0)
        this.q.removeAllViews(); 
      this.q.setVisibility(0);
      this.q.addView(q());
      this.q.setBackgroundColor(w());
    } else {
      this.q.setVisibility(8);
    } 
    this.t = n();
    this.s.setAdapter(this.t);
  }
  
  public int S_() {
    return 9;
  }
  
  public long T_() {
    return 2950L;
  }
  
  public long U_() {
    return 60000L;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean) {
    Dialog dialog = this.x;
    if (dialog != null)
      if (paramBoolean) {
        if (!dialog.isShowing()) {
          this.x.show();
          return;
        } 
      } else if (dialog.isShowing()) {
        this.x.dismiss();
      }  
  }
  
  public void a(boolean paramBoolean, String paramString) {
    if (w_() != null) {
      if (!w_().isActive())
        return; 
      z();
      if (paramBoolean) {
        this.u.a();
        this.s.setVisibility(8);
        if (r() == null) {
          this.i.setEnabled(false);
          return;
        } 
      } else {
        E();
        this.u.b();
        this.s.setVisibility(0);
        this.t.notifyDataSetChanged();
        if (r() == null) {
          this.i.setEnabled(true);
          this.k.setText(paramString);
        } 
      } 
    } 
  }
  
  public boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    return false;
  }
  
  public boolean a(Bundle paramBundle) {
    return false;
  }
  
  public BaseFragment b() {
    return this;
  }
  
  protected void b(Bundle paramBundle) {
    this.p = (FrameLayout)this.g.findViewById(R.id.vr_short_video_title_v);
    this.h = this.g.findViewById(R.id.vr_short_video_title);
    if (r() == null) {
      this.h.setVisibility(0);
      this.l = (TextView)this.h.findViewById(R.id.ctt_left_tv);
      this.l.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              this.a.e.l();
              this.a.c();
            }
          });
      this.i = this.h.findViewById(R.id.ctt_center_ll);
      this.k = (TextView)this.h.findViewById(R.id.ctt_center);
      this.k.setText(R.string.foudation_media_all_photos);
      this.o = (ImageView)this.h.findViewById(R.id.ctt_center_right);
      if (t() != null)
        this.o.setImageDrawable(t()); 
      this.r = (FrameLayout)this.h.findViewById(R.id.fl_num_view);
      this.m = (TextView)this.h.findViewById(R.id.num_view);
      this.n = (TextView)this.h.findViewById(R.id.ctt_right_tv);
      this.n.setEnabled(false);
      this.o.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (AlbumBaseFragment.a(this.a) != null) {
                AlbumBaseFragment.a(this.a).a((View)AlbumBaseFragment.b(this.a));
                if (this.a.u() != null) {
                  AlbumBaseFragment.c(this.a).setImageDrawable(this.a.u());
                  return;
                } 
                AlbumBaseFragment.c(this.a).setImageDrawable(AlbumBaseFragment.d(this.a).getResources().getDrawable(R.drawable.media_arrow_up_icon));
              } 
            }
          });
    } else {
      this.h.setVisibility(8);
      this.p.addView(r());
    } 
    this.j = (TextView)this.g.findViewById(R.id.vr_tips_tv);
    this.s = (AlbumRecyclerView)this.g.findViewById(R.id.vr_gird_view);
    this.s.setLayoutManager(m());
    this.q = (FrameLayout)this.g.findViewById(R.id.tabs);
    this.x = Tools.a(this.d);
    this.u = (NoDataAndLoadFailView)this.g.findViewById(R.id.vr_error_v);
  }
  
  public void c() {
    getActivity().finish();
  }
  
  public void d() {
    RecyclerView.Adapter adapter = this.t;
    if (adapter != null)
      adapter.notifyDataSetChanged(); 
    e();
  }
  
  public void e() {
    if (r() == null && this.e != null) {
      if (this.e.c() > 0) {
        F();
        return;
      } 
      G();
    } 
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
  }
  
  public int i() {
    return 3;
  }
  
  public abstract void k();
  
  public int l() {
    return 4;
  }
  
  public RecyclerView.LayoutManager m() {
    return (RecyclerView.LayoutManager)new GridLayoutManager(getContext(), l());
  }
  
  public RecyclerView.Adapter n() {
    return this.e.k();
  }
  
  public CharSequence o() {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(R.layout.album_v, paramViewGroup, false);
      k();
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
  
  public void onDestroyView() {
    MemoryRequest.a().b(this);
    super.onDestroyView();
  }
  
  public void onStart() {
    super.onStart();
    MemoryRequest.a().b(this);
  }
  
  public void onStop() {
    super.onStop();
    MemoryRequest.a().a(this);
  }
  
  public int p() {
    return 6;
  }
  
  public View q() {
    return null;
  }
  
  public View r() {
    return null;
  }
  
  public View s() {
    return (View)this.p;
  }
  
  public Drawable t() {
    return null;
  }
  
  public Drawable u() {
    return null;
  }
  
  public TextView v() {
    return this.k;
  }
  
  public int w() {
    return getContext().getResources().getColor(R.color.black);
  }
  
  public boolean x() {
    return false;
  }
  
  public void y() {
    a(true);
  }
  
  protected void z() {
    this.y = p();
    D();
    e();
    if (r() == null)
      this.n.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (this.a.e != null)
                this.a.e.a(null); 
            }
          }); 
    if (!TextUtils.isEmpty(o()))
      this.j.setText(o()); 
  }
  
  public class PopAdapter extends BaseAdapter {
    public PopAdapter(AlbumBaseFragment this$0) {}
    
    public int getCount() {
      return AlbumBasePresenter.n();
    }
    
    public Object getItem(int param1Int) {
      return AlbumBasePresenter.b(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      ViewHolder viewHolder;
      if (param1View == null) {
        param1View = LayoutInflater.from(AlbumBaseFragment.d(this.a)).inflate(R.layout.select_catalog_item, null);
        viewHolder = new ViewHolder();
        param1View.setTag(viewHolder);
        viewHolder.a = (ImageView)param1View.findViewById(R.id.header_view);
        viewHolder.b = (TextView)param1View.findViewById(R.id.name_view);
      } else {
        viewHolder = (ViewHolder)param1View.getTag();
        viewHolder.a.setImageResource(R.drawable.defaultpicture);
      } 
      GroupImageInfo groupImageInfo = AlbumBasePresenter.b(param1Int);
      LoadOptions loadOptions = new LoadOptions();
      loadOptions.d = R.drawable.defaultpicture;
      loadOptions.b = R.drawable.defaultpicture;
      if (groupImageInfo.isVideoMediaType()) {
        ThumbLoader.a().a(groupImageInfo.getChildImageInfo(), viewHolder.a, loadOptions);
      } else if (!TextUtils.isEmpty(groupImageInfo.topImageUri)) {
        ImageLoader.b((IRequestHost)this.a.w_(), groupImageInfo.topImageUri).a(R.drawable.defaultpicture).a(viewHolder.a);
      } else {
        ImageLoader.d((IRequestHost)this.a.w_(), groupImageInfo.getTopImagePath()).a(R.drawable.defaultpicture).a(viewHolder.a);
      } 
      if (!TextUtils.isEmpty(groupImageInfo.getFolderName())) {
        viewHolder.b.setText(groupImageInfo.getFolderName());
      } else {
        viewHolder.b.setText("");
      } 
      param1View.setOnClickListener(new View.OnClickListener(this, groupImageInfo) {
            public void onClick(View param2View) {
              AlbumBasePresenter.a(this.a.getFolderName(), AlbumBasePresenter.a(this.a.getFolderName()));
              AlbumBaseFragment.i(this.b.a).setText(this.a.getFolderName());
              AlbumBaseFragment.a(this.b.a).a();
              AlbumBaseFragment.j(this.b.a).notifyDataSetChanged();
            }
          });
      return param1View;
    }
    
    class ViewHolder {
      ImageView a;
      
      TextView b;
      
      private ViewHolder(AlbumBaseFragment.PopAdapter this$0) {}
    }
  }
  
  class null implements View.OnClickListener {
    null(AlbumBaseFragment this$0, GroupImageInfo param1GroupImageInfo) {}
    
    public void onClick(View param1View) {
      AlbumBasePresenter.a(this.a.getFolderName(), AlbumBasePresenter.a(this.a.getFolderName()));
      AlbumBaseFragment.i(this.b.a).setText(this.a.getFolderName());
      AlbumBaseFragment.a(this.b.a).a();
      AlbumBaseFragment.j(this.b.a).notifyDataSetChanged();
    }
  }
  
  class ViewHolder {
    ImageView a;
    
    TextView b;
    
    private ViewHolder(AlbumBaseFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\fragment\AlbumBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.feed.fragment;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.player.audio.IAudioPlayer;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.TabTitleTrackIndicatorWithDot;
import com.soft.blued.http.FlashVideoHttpUtils;
import com.soft.blued.ui.feed.adapter.MusicListAdapter;
import com.soft.blued.ui.feed.model.MusicCategory;
import com.soft.blued.ui.feed.observer.MusicChoosedObserver;
import com.soft.blued.ui.video.view.CustomProgressDialog;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MusicChooseFragment extends BaseFragment implements View.OnClickListener, MusicChoosedObserver.IMusicDownloadObserver {
  private static boolean t = false;
  
  private static String u = "";
  
  public Dialog d;
  
  public ProgressDialog e;
  
  public IAudioPlayer f;
  
  public String g = "";
  
  private Context h;
  
  private View i;
  
  private ImageView j;
  
  private EditText k;
  
  private TextView l;
  
  private TabTitleTrackIndicatorWithDot m;
  
  private ViewPager n;
  
  private ViewPager o;
  
  private MyAdapter p;
  
  private MyAdapter q;
  
  private NoDataAndLoadFailView r;
  
  private boolean s = false;
  
  private TextWatcher v = new TextWatcher(this) {
      String a;
      
      public void afterTextChanged(Editable param1Editable) {
        String str = param1Editable.toString();
        if (!this.a.equals(str) && MusicChooseFragment.a(this.b) != null && MusicChooseFragment.a(this.b).a(0) != null) {
          MusicChooseFragment.a(this.b).a(0).b(str);
          if (StringUtils.e(str))
            MusicChooseFragment.a(this.b).a(0).a(); 
        } 
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        this.a = param1CharSequence.toString();
      }
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private void a(View paramView) {
    BluedConfig.b().x();
    VideoPlayConfig.c(1);
    this.j = (ImageView)paramView.findViewById(2131297436);
    this.k = (EditText)paramView.findViewById(2131297014);
    this.k.addTextChangedListener(this.v);
    this.l = (TextView)paramView.findViewById(2131301302);
    this.m = (TabTitleTrackIndicatorWithDot)paramView.findViewById(2131297592);
    this.m.setBackgroundColor(BluedSkinUtils.a(this.h, 2131100728));
    this.m.setTextOriginColor(BluedSkinUtils.a(this.h, 2131100838));
    this.m.setTextChangeColor(BluedSkinUtils.a(this.h, 2131100838));
    this.m.setTabLayoutGravity(3);
    this.n = (ViewPager)paramView.findViewById(2131301728);
    this.o = (ViewPager)paramView.findViewById(2131301727);
    this.r = (NoDataAndLoadFailView)paramView.findViewById(2131301664);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.k.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            this.a.l();
            return false;
          }
        });
    this.p = new MyAdapter(this, getChildFragmentManager());
    this.q = new MyAdapter(this, getChildFragmentManager());
    ArrayList<MusicCategory> arrayList = new ArrayList();
    arrayList.add(new MusicCategory(""));
    this.q.a(arrayList);
    this.q.notifyDataSetChanged();
    this.o.setAdapter((PagerAdapter)this.q);
    this.n.setAdapter((PagerAdapter)this.p);
    this.m.setViewPager(this.n);
    this.m.setIsShowWithUnderline(true);
    this.m.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            MusicChooseFragment.b(this.a).a(param1Int);
          }
        });
  }
  
  public static void n() {
    if (u.equals("music_from_local_upload") || u.equals("music_from_shoot"))
      t = true; 
  }
  
  public boolean V_() {
    if (u.equals("music_from_local_upload") || u.equals("music_from_shoot"))
      t = true; 
    k();
    return true;
  }
  
  public void a() {
    Bundle bundle = getArguments();
    if (bundle != null)
      u = bundle.getString("fromsource_key"); 
    if (u.equals("music_from_local_upload") || u.equals("music_from_shoot"))
      ShortVideoProxy.e().a(getClass().getSimpleName()); 
    this.k.setText("");
    FlashVideoHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MusicCategory>>(this) {
          boolean a = false;
          
          protected void a(BluedEntityA<MusicCategory> param1BluedEntityA) {
            MusicChooseFragment.c(this.b).a(param1BluedEntityA.data);
            MusicChooseFragment.b(this.b).a();
            if (MusicChooseFragment.c(this.b).getCount() > 0)
              MusicChooseFragment.b(this.b).a(0); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            DialogUtils.b(this.b.d);
            if (this.a) {
              MusicChooseFragment.d(this.b).b();
            } else if (MusicChooseFragment.c(this.b).getCount() == 0) {
              MusicChooseFragment.d(this.b).a();
            } else {
              MusicChooseFragment.d(this.b).c();
            } 
            super.onUIFinish();
          }
          
          public void onUIStart() {
            DialogUtils.a(this.b.d);
            super.onUIStart();
          }
        }(IRequestHost)w_());
  }
  
  public void a(int paramInt1, int paramInt2) {
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)MusicChooseFragment.g(this.a).getLayoutParams();
            layoutParams.rightMargin = i;
            MusicChooseFragment.g(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator.setDuration(150L);
    valueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    valueAnimator.start();
  }
  
  public void a(String paramString) {
    Intent intent = new Intent();
    intent.putExtra("music_file_path", paramString);
    getActivity().setResult(-1, intent);
    k();
  }
  
  public boolean a(String paramString1, String paramString2) {
    String str = o();
    paramString2 = b(paramString2);
    if ((new File(str, paramString2)).exists())
      return false; 
    this.e.setOnDismissListener(new DialogInterface.OnDismissListener(this, str, paramString2) {
          public void onDismiss(DialogInterface param1DialogInterface) {
            MusicChooseFragment musicChooseFragment = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("/");
            stringBuilder.append(this.b);
            musicChooseFragment.g = stringBuilder.toString();
          }
        });
    a(new Runnable(this) {
          public void run() {
            DialogUtils.a((Dialog)this.a.e);
          }
        });
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("/");
    stringBuilder.append(paramString2);
    FileDownloader.a(paramString1, stringBuilder.toString(), new FileHttpResponseHandler(this, str, paramString2) {
          boolean a = false;
          
          boolean b = false;
          
          public void a(File param1File) {}
          
          public void a(Throwable param1Throwable, int param1Int, File param1File) {
            this.a = true;
            super.onFailure(param1Throwable, param1Int, param1File);
          }
          
          public void onFinish() {
            super.onFinish();
            this.b = true;
            this.e.a(new Runnable(this) {
                  public void run() {
                    if (!this.a.a) {
                      String str = this.a.e.g;
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append(this.a.c);
                      stringBuilder.append("/");
                      stringBuilder.append(this.a.d);
                      if (!str.equalsIgnoreCase(stringBuilder.toString())) {
                        this.a.e.g = "";
                        DialogUtils.b((Dialog)this.a.e.e);
                        MusicChooseFragment musicChooseFragment = this.a.e;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(this.a.c);
                        stringBuilder.append("/");
                        stringBuilder.append(this.a.d);
                        musicChooseFragment.a(stringBuilder.toString());
                      } 
                    } 
                  }
                });
          }
          
          public void onProgress(int param1Int1, int param1Int2) {
            this.e.a(new Runnable(this, param1Int1) {
                  public void run() {
                    this.b.e.e.setProgress(this.a);
                    if (this.a == 100)
                      this.b.e.a(new Runnable(this) {
                            public void run() {
                              if (!this.a.b.b && !this.a.b.a) {
                                String str = this.a.b.e.g;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(this.a.b.c);
                                stringBuilder.append("/");
                                stringBuilder.append(this.a.b.d);
                                if (!str.equalsIgnoreCase(stringBuilder.toString())) {
                                  this.a.b.e.g = "";
                                  DialogUtils.b((Dialog)this.a.b.e.e);
                                  MusicChooseFragment musicChooseFragment = this.a.b.e;
                                  stringBuilder = new StringBuilder();
                                  stringBuilder.append(this.a.b.c);
                                  stringBuilder.append("/");
                                  stringBuilder.append(this.a.b.d);
                                  musicChooseFragment.a(stringBuilder.toString());
                                } 
                              } 
                            }
                          },  3000L); 
                  }
                });
            super.onProgress(param1Int1, param1Int2);
          }
          
          public void onStart() {
            this.a = false;
            this.b = false;
            this.e.a(new Runnable(this) {
                  public void run() {
                    DialogUtils.a((Dialog)this.a.e.e);
                  }
                });
            super.onStart();
          }
        }null);
    return true;
  }
  
  public String b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(URLEncoder.encode(paramString.toLowerCase().trim()));
    stringBuilder.append(".mp3");
    return stringBuilder.toString();
  }
  
  public void b(String paramString1, String paramString2) {
    if (!a(paramString1, paramString2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(o());
      stringBuilder.append("/");
      stringBuilder.append(b(paramString2));
      a(stringBuilder.toString());
    } 
  }
  
  public void c(String paramString1, String paramString2) {
    String str;
    File file = new File(o(), b(paramString2));
    if (file.exists()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("file:/");
      stringBuilder.append(file.getAbsolutePath());
      str = stringBuilder.toString();
    } 
    this.f.a(str).a(true).a();
    int j = this.o.getVisibility();
    int i = 0;
    if (j == 0) {
      while (i < this.p.getCount()) {
        if (this.p.a(i) != null && this.p.a(i).k() != null) {
          MusicListAdapter musicListAdapter = this.p.a(i).k();
          musicListAdapter.c();
          musicListAdapter.b();
          musicListAdapter.notifyDataSetChanged();
        } 
        i++;
      } 
    } else {
      for (i = 0; i < this.p.getCount(); i++) {
        if (i != this.n.getCurrentItem() && this.p.a(i) != null && this.p.a(i).k() != null) {
          MusicListAdapter musicListAdapter = this.p.a(i).k();
          musicListAdapter.c();
          musicListAdapter.b();
          musicListAdapter.notifyDataSetChanged();
        } 
      } 
      MyAdapter myAdapter = this.q;
      if (myAdapter != null && myAdapter.a(0) != null && this.q.a(0).k() != null) {
        this.q.a(0).k().b();
        this.q.a(0).k().c();
        this.q.a(0).k().notifyDataSetChanged();
      } 
    } 
  }
  
  public void k() {
    MusicChoosedObserver.a().b();
    getActivity().finish();
  }
  
  public void l() {
    if (!this.s) {
      MyAdapter myAdapter = this.q;
      if (myAdapter != null && myAdapter.getCount() > 0 && this.q.a(0) != null)
        this.q.a(0).a(); 
      this.s = true;
      a(new Runnable(this) {
            public void run() {
              MusicChooseFragment.e(this.a).setVisibility(0);
            }
          },  150L);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.l.getLayoutParams();
      a(-this.l.getWidth() - layoutParams.leftMargin, 0);
    } 
  }
  
  public void m() {
    if (this.s) {
      this.s = false;
      KeyboardUtils.a((Activity)getActivity());
      a(new Runnable(this) {
            public void run() {
              MusicChooseFragment.e(this.a).setVisibility(8);
              MusicChooseFragment.f(this.a).setText("");
            }
          },  150L);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.l.getLayoutParams();
      a(0, -this.l.getWidth() - layoutParams.leftMargin);
    } 
  }
  
  public String o() {
    return AppMethods.b("ShortVideoMusic");
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131297436) {
      if (i != 2131301302)
        return; 
      m();
      return;
    } 
    V_();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.h = (Context)getActivity();
    this.d = DialogUtils.a(this.h);
    getActivity().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(this.h.getResources().getColor(2131100528)));
    getActivity().getWindow().setSoftInputMode(18);
    this.e = (ProgressDialog)new CustomProgressDialog(this.h);
    this.e.setCanceledOnTouchOutside(true);
    View view = this.i;
    if (view == null) {
      this.i = paramLayoutInflater.inflate(2131493238, paramViewGroup, false);
      a(this.i);
      a();
      MusicChoosedObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.i.getParent()).removeView(this.i);
    } 
    return this.i;
  }
  
  public void onDestroy() {
    MusicChoosedObserver.a().b(this);
    if (u.equals("music_from_local_upload") || u.equals("music_from_shoot"))
      ShortVideoProxy.e().b(getClass().getSimpleName()); 
    this.f.b();
    u = "";
    k();
    super.onDestroy();
  }
  
  public void onPause() {
    IAudioPlayer iAudioPlayer = this.f;
    if (iAudioPlayer != null)
      iAudioPlayer.c(); 
    MusicChoosedObserver.a().b();
    super.onPause();
    if (u.equals("music_from_local_upload") || u.equals("music_from_shoot"))
      AudioManagerUtils.a().a(t); 
  }
  
  public void onResume() {
    super.onResume();
    if (u.equals("music_from_local_upload") || u.equals("music_from_shoot")) {
      t = false;
      AudioManagerUtils.a().b();
    } 
  }
  
  public void p() {
    this.f.b();
    for (int i = 0; i < this.p.getCount(); i++) {
      if (this.p.a(i) != null && this.p.a(i).k() != null) {
        MusicListAdapter musicListAdapter = this.p.a(i).k();
        musicListAdapter.c();
        musicListAdapter.notifyDataSetChanged();
      } 
    } 
    MyAdapter myAdapter = this.q;
    if (myAdapter != null && myAdapter.a(0) != null && this.q.a(0).k() != null) {
      this.q.a(0).k().c();
      this.q.a(0).k().notifyDataSetChanged();
    } 
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    private List<MusicCategory> b;
    
    private List<MusicListFragment> c;
    
    public MyAdapter(MusicChooseFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public MusicListFragment a(int param1Int) {
      List<MusicListFragment> list = this.c;
      return (list != null) ? list.get(param1Int) : null;
    }
    
    public void a(List<MusicCategory> param1List) {
      List<MusicCategory> list = this.b;
      if (list == null) {
        this.b = new ArrayList<MusicCategory>();
      } else {
        list.clear();
      } 
      if (param1List != null && param1List.size() > 0) {
        List<MusicListFragment> list1 = this.c;
        if (list1 == null) {
          this.c = new ArrayList<MusicListFragment>();
        } else {
          list1.clear();
        } 
        for (int i = 0; i < param1List.size(); i++) {
          if (((MusicCategory)param1List.get(i)).classify_id == -1) {
            this.c.add(MusicListFragment.a(((MusicCategory)param1List.get(i)).keyword));
          } else {
            this.c.add(MusicListFragment.a(((MusicCategory)param1List.get(i)).classify_id));
          } 
        } 
      } 
      this.b.addAll(param1List);
      notifyDataSetChanged();
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      if (this.b == null)
        this.b = new ArrayList<MusicCategory>(); 
      return this.b.size();
    }
    
    public Fragment getItem(int param1Int) {
      if (this.c == null)
        this.c = new ArrayList<MusicListFragment>(); 
      return (Fragment)this.c.get(param1Int);
    }
    
    public CharSequence getPageTitle(int param1Int) {
      if (this.b == null)
        this.b = new ArrayList<MusicCategory>(); 
      return ((MusicCategory)this.b.get(param1Int)).name;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\MusicChooseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.customview.emoji.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.soft.blued.customview.emoji.manager.Emoji;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import java.util.ArrayList;
import java.util.List;

public class EmojiMainFragment extends Fragment implements EmojiFragment.OnEmojiClickedListener {
  private View a;
  
  private ViewPager b;
  
  private EmoticonsIndicatorView c;
  
  private List<Emoji> d = new ArrayList<Emoji>();
  
  private List<Fragment> e;
  
  private OnMainEmojiClickedListener f;
  
  private EmojiPagerAdapter g;
  
  private boolean h = false;
  
  private boolean i = false;
  
  private boolean j = false;
  
  private void a() {
    if (this.i)
      return; 
    if (!this.j)
      return; 
    if (!this.h)
      return; 
    this.i = true;
    c();
  }
  
  private void b() {
    this.b = (ViewPager)this.a.findViewById(2131297218);
    this.c = (EmoticonsIndicatorView)this.a.findViewById(2131297217);
  }
  
  private void c() {
    this.e = new ArrayList<Fragment>();
    if (this.d.size() <= 35) {
      EmojiFragment emojiFragment = new EmojiFragment();
      emojiFragment.a(this.d);
      emojiFragment.a(this);
      this.e.add(emojiFragment);
    } else {
      int j = this.d.size() / 35;
      int i;
      for (i = 0; i < j; i++) {
        ArrayList<Emoji> arrayList = new ArrayList();
        EmojiFragment emojiFragment = new EmojiFragment();
        for (int k = 0; k < 35; k++)
          arrayList.add(this.d.get(i * 35 + k)); 
        emojiFragment.a(arrayList);
        emojiFragment.a(this);
        this.e.add(emojiFragment);
      } 
      if (this.d.size() % 35 != 0) {
        ArrayList<Emoji> arrayList = new ArrayList();
        EmojiFragment emojiFragment = new EmojiFragment();
        for (i = j * 35; i < this.d.size(); i++)
          arrayList.add(this.d.get(i)); 
        emojiFragment.a(arrayList);
        emojiFragment.a(this);
        this.e.add(emojiFragment);
      } 
    } 
    this.c.a(this.e.size());
    EmojiPagerAdapter emojiPagerAdapter = this.g;
    if (emojiPagerAdapter == null) {
      this.g = new EmojiPagerAdapter(this, getChildFragmentManager());
      this.b.setAdapter((PagerAdapter)this.g);
      this.b.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
            public void onPageScrollStateChanged(int param1Int) {}
            
            public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
            
            public void onPageSelected(int param1Int) {
              EmojiMainFragment.a(this.a).b(param1Int);
            }
          });
      return;
    } 
    emojiPagerAdapter.notifyDataSetChanged();
  }
  
  public void a(OnMainEmojiClickedListener paramOnMainEmojiClickedListener) {
    this.f = paramOnMainEmojiClickedListener;
  }
  
  public void a(Emoji paramEmoji) {
    this.f.a(paramEmoji);
  }
  
  public void a(List<Emoji> paramList) {
    this.d = paramList;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    if (this.a == null) {
      this.j = true;
      this.a = paramLayoutInflater.inflate(2131493120, paramViewGroup, false);
      b();
      a();
    } 
    ViewGroup viewGroup = (ViewGroup)this.a.getParent();
    if (viewGroup != null)
      viewGroup.removeView(this.a); 
    return this.a;
  }
  
  public void onDetach() {
    super.onDetach();
    List<Fragment> list = this.e;
    if (list == null)
      return; 
    list.clear();
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.h = paramBoolean;
    a();
  }
  
  class EmojiPagerAdapter extends FragmentPagerAdapter {
    public EmojiPagerAdapter(EmojiMainFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return EmojiMainFragment.b(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      return EmojiMainFragment.b(this.a).get(param1Int);
    }
  }
  
  public static interface OnMainEmojiClickedListener {
    void a(Emoji param1Emoji);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\fragment\EmojiMainFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
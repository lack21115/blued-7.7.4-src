package com.soft.blued.customview.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.soft.blued.customview.emoji.category.ActivityCategory;
import com.soft.blued.customview.emoji.category.FlagsCategory;
import com.soft.blued.customview.emoji.category.FoodsCategory;
import com.soft.blued.customview.emoji.category.NatureCategory;
import com.soft.blued.customview.emoji.category.ObjectsCategory;
import com.soft.blued.customview.emoji.category.PeopleCategory;
import com.soft.blued.customview.emoji.category.PlacesCategory;
import com.soft.blued.customview.emoji.category.SymbolsCategory;
import com.soft.blued.customview.emoji.fragment.EmojiMainFragment;
import com.soft.blued.customview.emoji.fragment.RecentEmojiFragment;
import com.soft.blued.customview.emoji.manager.Emoji;
import com.soft.blued.customview.emoji.manager.RecentEmojiManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class EmojiKeyboardLayout extends LinearLayout implements EmojiMainFragment.OnMainEmojiClickedListener, RecentEmojiFragment.OnRecentEmojiClickedListener {
  private ViewPager a;
  
  private LinearLayout b;
  
  private View c;
  
  private List<FragmentEntity> d;
  
  private RecentEmojiFragment e;
  
  private EmojiCallback f;
  
  private RecentEmojiManager g;
  
  private FragmentManager h;
  
  private EmojiPagerAdapter i;
  
  private int j = 0;
  
  public EmojiKeyboardLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public EmojiKeyboardLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.g = new RecentEmojiManager(paramContext);
  }
  
  private void a() {
    LinearLayout linearLayout;
    if (isInEditMode())
      return; 
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    if (this.c == null) {
      this.c = View.inflate(getContext(), 2131493745, null);
      addView(this.c, (ViewGroup.LayoutParams)layoutParams);
      this.a = (ViewPager)findViewById(2131297215);
      this.b = (LinearLayout)findViewById(2131297216);
      this.b.getChildAt(0).setSelected(true);
      this.d = new ArrayList<FragmentEntity>();
      this.d.add(new FragmentEntity(RecentEmojiFragment.class, null, this.g.a()));
      this.d.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(PeopleCategory.a), null));
      this.d.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(NatureCategory.a), null));
      this.d.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(FoodsCategory.a), null));
      this.d.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(ActivityCategory.a), null));
      this.d.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(PlacesCategory.a), null));
      this.d.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(ObjectsCategory.a), null));
      this.d.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(SymbolsCategory.a), null));
      this.d.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(FlagsCategory.a), null));
      FragmentManager fragmentManager = this.h;
      if (fragmentManager != null)
        this.i = new EmojiPagerAdapter(this, fragmentManager); 
      ViewPager viewPager = this.a;
      if (viewPager != null) {
        EmojiPagerAdapter emojiPagerAdapter = this.i;
        if (emojiPagerAdapter != null)
          viewPager.setAdapter((PagerAdapter)emojiPagerAdapter); 
      } 
      this.a.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
            public void onPageScrollStateChanged(int param1Int) {}
            
            public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
            
            public void onPageSelected(int param1Int) {
              ((ViewGroup)EmojiKeyboardLayout.b(this.a).getChildAt(param1Int)).getChildAt(0).setSelected(true);
              ((ViewGroup)EmojiKeyboardLayout.b(this.a).getChildAt(param1Int)).getChildAt(0).setBackgroundResource(2131231392);
              ((ViewGroup)EmojiKeyboardLayout.b(this.a).getChildAt(EmojiKeyboardLayout.c(this.a))).getChildAt(0).setSelected(false);
              ((ViewGroup)EmojiKeyboardLayout.b(this.a).getChildAt(EmojiKeyboardLayout.c(this.a))).getChildAt(0).setBackgroundResource(0);
              EmojiKeyboardLayout.a(this.a, param1Int);
            }
          });
      for (int i = 0; i < this.b.getChildCount() - 1; i++)
        ((ViewGroup)this.b.getChildAt(i)).getChildAt(0).setOnClickListener(new OnTabClickedListener(this, i)); 
      linearLayout = this.b;
      linearLayout.getChildAt(linearLayout.getChildCount() - 1).setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (EmojiKeyboardLayout.d(this.a) == null)
                return; 
              EmojiKeyboardLayout.d(this.a).a();
            }
          });
      return;
    } 
    RecentEmojiFragment recentEmojiFragment = this.e;
    if (recentEmojiFragment != null)
      recentEmojiFragment.a(this.g.a()); 
    addView(this.c, (ViewGroup.LayoutParams)linearLayout);
  }
  
  public void a(Emoji paramEmoji) {
    this.g.a(paramEmoji);
    EmojiCallback emojiCallback = this.f;
    if (emojiCallback == null)
      return; 
    emojiCallback.a(paramEmoji);
  }
  
  public void b(Emoji paramEmoji) {
    this.g.a(paramEmoji);
    EmojiCallback emojiCallback = this.f;
    if (emojiCallback == null)
      return; 
    emojiCallback.a(paramEmoji);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    a();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.g.b();
    removeView(this.c);
  }
  
  public void setEmojiCallback(EmojiCallback paramEmojiCallback) {
    this.f = paramEmojiCallback;
  }
  
  public void setFragmentManager(FragmentManager paramFragmentManager) {
    this.h = paramFragmentManager;
    paramFragmentManager = this.h;
    if (paramFragmentManager != null) {
      this.i = new EmojiPagerAdapter(this, paramFragmentManager);
      ViewPager viewPager = this.a;
      if (viewPager != null)
        viewPager.setAdapter((PagerAdapter)this.i); 
    } 
  }
  
  public void setKeyboardColor(int paramInt) {
    post(new Runnable(this, paramInt) {
          public void run() {
            int k = this.a;
            int i = 2131100980;
            int j = 2131099781;
            if (k != 2) {
              i = 2131099781;
            } else {
              j = 2131100980;
            } 
            if (EmojiKeyboardLayout.a(this.b) != null)
              EmojiKeyboardLayout.a(this.b).setBackgroundColor(this.b.getResources().getColor(i)); 
            if (EmojiKeyboardLayout.b(this.b) != null)
              EmojiKeyboardLayout.b(this.b).setBackgroundColor(this.b.getResources().getColor(j)); 
          }
        });
  }
  
  public void setVisibility(int paramInt) {
    super.setVisibility(paramInt);
    RecentEmojiFragment recentEmojiFragment = this.e;
    if (recentEmojiFragment == null)
      return; 
    if (paramInt == 0)
      recentEmojiFragment.a(this.g.a()); 
  }
  
  public static interface EmojiCallback {
    void a();
    
    void a(Emoji param1Emoji);
  }
  
  class EmojiPagerAdapter extends FragmentPagerAdapter {
    public EmojiPagerAdapter(EmojiKeyboardLayout this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return EmojiKeyboardLayout.e(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      EmojiKeyboardLayout.FragmentEntity fragmentEntity = EmojiKeyboardLayout.e(this.a).get(param1Int);
      Fragment fragment = Fragment.instantiate(this.a.getContext(), fragmentEntity.a.getName(), null);
      if (fragment instanceof EmojiMainFragment) {
        EmojiMainFragment emojiMainFragment = (EmojiMainFragment)fragment;
        emojiMainFragment.a(fragmentEntity.c);
        emojiMainFragment.a(this.a);
        return fragment;
      } 
      if (fragment instanceof RecentEmojiFragment) {
        RecentEmojiFragment recentEmojiFragment = (RecentEmojiFragment)fragment;
        recentEmojiFragment.a(fragmentEntity.b);
        recentEmojiFragment.a(this.a);
        EmojiKeyboardLayout.a(this.a, recentEmojiFragment);
      } 
      return fragment;
    }
  }
  
  static class FragmentEntity {
    public Class<?> a;
    
    public Collection<Emoji> b;
    
    public List<Emoji> c;
    
    public FragmentEntity(Class<?> param1Class, List<Emoji> param1List, Collection<Emoji> param1Collection) {
      this.a = param1Class;
      this.c = param1List;
      this.b = param1Collection;
    }
  }
  
  class OnTabClickedListener implements View.OnClickListener {
    private int b;
    
    public OnTabClickedListener(EmojiKeyboardLayout this$0, int param1Int) {
      this.b = param1Int;
    }
    
    public void onClick(View param1View) {
      EmojiKeyboardLayout.a(this.a).setCurrentItem(this.b, true);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\view\EmojiKeyboardLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
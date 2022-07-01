package com.soft.blued.customview.selectabletextview;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;

public class SelectFrameLayout extends FrameLayout {
  private Context a;
  
  private int b;
  
  private int c;
  
  private View d;
  
  private TextView e;
  
  private Spannable f;
  
  private SelectionInfo g = new SelectionInfo();
  
  private BackgroundColorSpan h;
  
  private int i = 2131100759;
  
  private int j = 2131100739;
  
  private CursorHandle k;
  
  private CursorHandle l;
  
  private boolean m = true;
  
  private OperateWindow n;
  
  private FullScreenWindow o;
  
  private SelectableOnShowListener p;
  
  private SelectableOnChangeListener q;
  
  private SelectableItemOnClickListener r;
  
  public SelectFrameLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SelectFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SelectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  private CursorHandle a(boolean paramBoolean) {
    return (CursorHandle.a(this.k) == paramBoolean) ? this.k : this.l;
  }
  
  private void a() {
    this.d.setOnLongClickListener(new View.OnLongClickListener(this) {
          public boolean onLongClick(View param1View) {
            if (SelectFrameLayout.a(this.a) != null)
              SelectFrameLayout.a(this.a).a(); 
            SelectFrameLayout.b(this.a).a();
            SelectFrameLayout.c(this.a).b();
            return true;
          }
        });
    setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            SelectFrameLayout.d(this.a);
          }
        });
    this.n = new OperateWindow(this, this.a);
    this.o = new FullScreenWindow(this, this.a);
  }
  
  private void a(int paramInt1, int paramInt2) {
    c();
    d();
    this.m = false;
    if (this.k == null)
      this.k = new CursorHandle(this, true); 
    if (this.l == null)
      this.l = new CursorHandle(this, false); 
    paramInt1 = this.e.length();
    if (this.e.getText() instanceof Spannable)
      this.f = (Spannable)this.e.getText(); 
    if (this.f != null) {
      if (this.e.getText().length() <= 0)
        return; 
      b(0, paramInt1);
      this.o.a();
      a(this.k);
      a(this.l);
      this.n.a();
    } 
  }
  
  private void a(CursorHandle paramCursorHandle) {
    int i;
    Layout layout = this.e.getLayout();
    if (CursorHandle.a(paramCursorHandle)) {
      i = this.g.a(this.e);
    } else {
      i = this.g.b(this.e);
    } 
    paramCursorHandle.b((int)layout.getPrimaryHorizontal(i), layout.getLineBottom(layout.getLineForOffset(i)));
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent) {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    paramView.getLocationInWindow(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getHeight();
    int m = paramView.getWidth();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    return (new Rect(i, j, m + i, k + j)).contains((int)f1, (int)f2);
  }
  
  private void b() {
    TextView textView = this.e;
    textView.setText(textView.getText(), TextView.BufferType.SPANNABLE);
    this.e.setOnLongClickListener(new View.OnLongClickListener(this) {
          public boolean onLongClick(View param1View) {
            if (SelectFrameLayout.a(this.a) != null)
              SelectFrameLayout.a(this.a).a(); 
            SelectFrameLayout selectFrameLayout = this.a;
            SelectFrameLayout.a(selectFrameLayout, SelectFrameLayout.e(selectFrameLayout), SelectFrameLayout.f(this.a));
            return true;
          }
        });
    this.e.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            SelectFrameLayout.a(this.a, (int)param1MotionEvent.getX());
            SelectFrameLayout.b(this.a, (int)param1MotionEvent.getY());
            return false;
          }
        });
    this.e.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            SelectFrameLayout.g(this.a);
            SelectFrameLayout.d(this.a);
          }
        });
    this.n = new OperateWindow(this, this.a);
    this.o = new FullScreenWindow(this, this.a);
    setCopyVisibility(true);
    setSelectAllVisibility(true);
  }
  
  private void b(int paramInt1, int paramInt2) {
    if (paramInt1 != -1)
      this.g.a(paramInt1); 
    if (paramInt2 != -1)
      this.g.b(paramInt2); 
    if (this.g.a(this.e) > this.g.b(this.e)) {
      int i = this.g.a(this.e);
      SelectionInfo selectionInfo = this.g;
      selectionInfo.a(selectionInfo.b(this.e));
      this.g.b(i);
    } 
    if (this.f != null) {
      if (this.h == null)
        this.h = new BackgroundColorSpan(this.a.getResources().getColor(this.i)); 
      Spannable spannable2 = this.f;
      int i = spannable2.length();
      boolean bool = false;
      SelectedImageSpan[] arrayOfSelectedImageSpan = (SelectedImageSpan[])spannable2.getSpans(0, i, SelectedImageSpan.class);
      for (i = 0; i < arrayOfSelectedImageSpan.length; i++) {
        int j = this.f.getSpanStart(arrayOfSelectedImageSpan[i]);
        int k = this.f.getSpanEnd(arrayOfSelectedImageSpan[i]);
        if (j >= this.g.a(this.e) && k <= this.g.b(this.e)) {
          (arrayOfSelectedImageSpan[i]).a = ContextCompat.getColor(AppInfo.d(), 2131100759);
        } else {
          (arrayOfSelectedImageSpan[i]).a = 0;
        } 
      } 
      SelectionInfo selectionInfo = this.g;
      Spannable spannable3 = this.f;
      selectionInfo.a = spannable3.subSequence(selectionInfo.a(spannable3), this.g.b(this.f)).toString();
      Spannable spannable1 = this.f;
      spannable1.setSpan(this.h, this.g.a(spannable1), this.g.b(this.f), 17);
      SelectableOnChangeListener selectableOnChangeListener = this.q;
      if (selectableOnChangeListener != null) {
        String str = this.g.a;
        boolean bool1 = bool;
        if (paramInt1 == 0) {
          bool1 = bool;
          if (paramInt2 == this.e.getText().length())
            bool1 = true; 
        } 
        selectableOnChangeListener.a(str, bool1);
      } 
    } 
  }
  
  private void c() {
    this.m = true;
    Spannable spannable = this.f;
    if (spannable != null && this.e != null) {
      SelectedImageSpan[] arrayOfSelectedImageSpan = (SelectedImageSpan[])spannable.getSpans(0, spannable.length(), SelectedImageSpan.class);
      for (int i = 0; i < arrayOfSelectedImageSpan.length; i++)
        (arrayOfSelectedImageSpan[i]).a = 0; 
      this.e.invalidate();
    } 
    CursorHandle cursorHandle = this.k;
    if (cursorHandle != null)
      cursorHandle.a(); 
    cursorHandle = this.l;
    if (cursorHandle != null)
      cursorHandle.a(); 
    OperateWindow operateWindow = this.n;
    if (operateWindow != null)
      operateWindow.c(); 
    FullScreenWindow fullScreenWindow = this.o;
    if (fullScreenWindow != null)
      fullScreenWindow.b(); 
  }
  
  private void d() {
    this.g.a = null;
    Spannable spannable = this.f;
    if (spannable != null) {
      BackgroundColorSpan backgroundColorSpan = this.h;
      if (backgroundColorSpan != null) {
        spannable.removeSpan(backgroundColorSpan);
        this.h = null;
      } 
    } 
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (getChildCount() == 1) {
      this.d = getChildAt(0);
      if (getChildAt(0) instanceof TextView) {
        this.e = (TextView)getChildAt(0);
        b();
        return;
      } 
      a();
      return;
    } 
    throw new SelectFrameLayoutException("你必须使SelectFrameLayout有且只有一个子View");
  }
  
  public int getSubViewX() {
    int[] arrayOfInt = new int[2];
    this.d.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[0];
  }
  
  public int getSubViewY() {
    int[] arrayOfInt = new int[2];
    this.d.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
  }
  
  public void setBubbleVisibility(boolean paramBoolean) {
    OperateWindow operateWindow = this.n;
    if (operateWindow != null) {
      byte b;
      if (OperateWindow.g(operateWindow) == null)
        return; 
      View view = OperateWindow.g(this.n);
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
  }
  
  public void setCancelVisibility(boolean paramBoolean) {
    OperateWindow operateWindow = this.n;
    if (operateWindow != null) {
      byte b;
      if (OperateWindow.h(operateWindow) == null)
        return; 
      View view = OperateWindow.h(this.n);
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
  }
  
  public void setCopyVisibility(boolean paramBoolean) {
    OperateWindow operateWindow = this.n;
    if (operateWindow != null) {
      byte b;
      if (OperateWindow.a(operateWindow) == null)
        return; 
      View view = OperateWindow.a(this.n);
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
  }
  
  public void setRecallVisibility(boolean paramBoolean) {
    OperateWindow operateWindow = this.n;
    if (operateWindow != null) {
      byte b;
      if (OperateWindow.c(operateWindow) == null)
        return; 
      View view = OperateWindow.c(this.n);
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
  }
  
  public void setRepostVisibility(boolean paramBoolean) {
    OperateWindow operateWindow = this.n;
    if (operateWindow != null) {
      byte b;
      if (OperateWindow.f(operateWindow) == null)
        return; 
      View view = OperateWindow.f(this.n);
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
  }
  
  public void setSelectAllVisibility(boolean paramBoolean) {
    OperateWindow operateWindow = this.n;
    if (operateWindow != null) {
      byte b;
      if (OperateWindow.b(operateWindow) == null)
        return; 
      View view = OperateWindow.b(this.n);
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
  }
  
  public void setSelectableItemOnClickListener(SelectableItemOnClickListener paramSelectableItemOnClickListener) {
    this.r = paramSelectableItemOnClickListener;
  }
  
  public void setSelectableOnChangeListener(SelectableOnChangeListener paramSelectableOnChangeListener) {
    this.q = paramSelectableOnChangeListener;
  }
  
  public void setSelectableOnShowListener(SelectableOnShowListener paramSelectableOnShowListener) {
    this.p = paramSelectableOnShowListener;
  }
  
  public void setTranslateVisibility(boolean paramBoolean) {
    OperateWindow operateWindow = this.n;
    if (operateWindow != null) {
      byte b;
      if (OperateWindow.d(operateWindow) == null)
        return; 
      View view = OperateWindow.d(this.n);
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
  }
  
  public void setTurnTextVisibility(boolean paramBoolean) {
    OperateWindow operateWindow = this.n;
    if (operateWindow != null) {
      byte b;
      if (OperateWindow.e(operateWindow) == null)
        return; 
      View view = OperateWindow.e(this.n);
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
  }
  
  class CursorHandle extends View {
    private final int b = 48;
    
    private PopupWindow c;
    
    private Paint d;
    
    private int e = 24;
    
    private int f;
    
    private int g;
    
    private int h;
    
    private boolean i;
    
    private int j;
    
    private int k;
    
    private int l;
    
    private int m;
    
    private int[] n;
    
    public CursorHandle(SelectFrameLayout this$0, boolean param1Boolean) {
      super(SelectFrameLayout.h(this$0));
      int i = this.e;
      this.f = i * 2;
      this.g = i * 2;
      this.h = 25;
      this.n = new int[2];
      this.i = param1Boolean;
      this.d = new Paint(1);
      this.d.setColor(SelectFrameLayout.h(this$0).getResources().getColor(SelectFrameLayout.i(this$0)));
      this.c = new PopupWindow(this);
      this.c.setClippingEnabled(false);
      this.c.setWidth(this.f + this.h * 2);
      this.c.setHeight(this.g + this.h / 2);
      invalidate();
    }
    
    private void d() {
      this.i ^= 0x1;
      invalidate();
    }
    
    private void e() {
      this.a.getLocationInWindow(this.n);
      Layout layout = SelectFrameLayout.j(this.a).getLayout();
      if (this.i) {
        this.c.update((int)layout.getPrimaryHorizontal(SelectFrameLayout.k(this.a).a(SelectFrameLayout.j(this.a))) - this.f + b(), layout.getLineBottom(layout.getLineForOffset(SelectFrameLayout.k(this.a).a(SelectFrameLayout.j(this.a)))) + c(), -1, -1);
        return;
      } 
      this.c.update((int)layout.getPrimaryHorizontal(SelectFrameLayout.k(this.a).b(SelectFrameLayout.j(this.a))) + b(), layout.getLineBottom(layout.getLineForOffset(SelectFrameLayout.k(this.a).b(SelectFrameLayout.j(this.a)))) + c(), -1, -1);
    }
    
    public void a() {
      this.c.dismiss();
    }
    
    public void a(int param1Int1, int param1Int2) {
      int i;
      this.a.getLocationInWindow(this.n);
      if (this.i) {
        i = SelectFrameLayout.k(this.a).a(SelectFrameLayout.j(this.a));
      } else {
        i = SelectFrameLayout.k(this.a).b(SelectFrameLayout.j(this.a));
      } 
      int j = this.n[1];
      param1Int1 = TextLayoutUtil.a(SelectFrameLayout.j(this.a), param1Int1, param1Int2 - j, i);
      if (param1Int1 != i) {
        SelectFrameLayout.g(this.a);
        if (this.i) {
          if (param1Int1 > this.m) {
            CursorHandle cursorHandle = SelectFrameLayout.a(this.a, false);
            d();
            cursorHandle.d();
            param1Int2 = this.m;
            this.l = param1Int2;
            SelectFrameLayout.b(this.a, param1Int2, param1Int1);
            cursorHandle.e();
          } else {
            SelectFrameLayout.b(this.a, param1Int1, -1);
          } 
          e();
          return;
        } 
        param1Int2 = this.l;
        if (param1Int1 < param1Int2) {
          CursorHandle cursorHandle = SelectFrameLayout.a(this.a, true);
          cursorHandle.d();
          d();
          param1Int2 = this.l;
          this.m = param1Int2;
          SelectFrameLayout.b(this.a, param1Int1, param1Int2);
          cursorHandle.e();
        } else {
          SelectFrameLayout.b(this.a, param1Int2, param1Int1);
        } 
        e();
      } 
    }
    
    public int b() {
      return this.n[0] - this.h + this.a.getPaddingLeft();
    }
    
    public void b(int param1Int1, int param1Int2) {
      byte b;
      this.a.getLocationInWindow(this.n);
      if (this.i) {
        b = this.f;
      } else {
        b = 0;
      } 
      this.c.showAtLocation((View)this.a, 0, param1Int1 - b + b(), param1Int2 + c());
    }
    
    public int c() {
      return this.n[1] + this.a.getPaddingTop();
    }
    
    protected void onDraw(Canvas param1Canvas) {
      int i = this.e;
      param1Canvas.drawCircle((this.h + i), i, i, this.d);
      if (this.i) {
        i = this.e;
        int k = this.h;
        param1Canvas.drawRect((i + k), 0.0F, (i * 2 + k), i, this.d);
        return;
      } 
      i = this.h;
      float f = i;
      int j = this.e;
      param1Canvas.drawRect(f, 0.0F, (i + j), j, this.d);
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      int i = param1MotionEvent.getAction();
      if (i != 0) {
        if (i != 1)
          if (i != 2) {
            if (i != 3)
              return true; 
          } else {
            SelectFrameLayout.c(this.a).c();
            i = (int)param1MotionEvent.getRawX();
            int j = (int)param1MotionEvent.getRawY();
            a(i + this.j - this.f - this.a.getSubViewX(), j + this.k - this.g);
            return true;
          }  
        SelectFrameLayout.c(this.a).a();
        return true;
      } 
      this.l = SelectFrameLayout.k(this.a).a(SelectFrameLayout.j(this.a));
      this.m = SelectFrameLayout.k(this.a).b(SelectFrameLayout.j(this.a));
      this.j = (int)param1MotionEvent.getX();
      this.k = (int)param1MotionEvent.getY();
      return true;
    }
  }
  
  class FullScreenWindow {
    private PopupWindow b;
    
    public FullScreenWindow(SelectFrameLayout this$0, Context param1Context) {
      this.b = new PopupWindow(LayoutInflater.from(param1Context).inflate(2131494110, null), -1, -1, false);
      this.b.setClippingEnabled(false);
      this.b.setTouchInterceptor(new View.OnTouchListener(this, this$0) {
            public boolean onTouch(View param2View, MotionEvent param2MotionEvent) {
              if (SelectFrameLayout.c(this.b.a) == null || SelectFrameLayout.OperateWindow.i(SelectFrameLayout.c(this.b.a)) == null)
                this.b.b(); 
              if (!SelectFrameLayout.a(this.b.a, SelectFrameLayout.OperateWindow.i(SelectFrameLayout.c(this.b.a)), param2MotionEvent))
                if (SelectFrameLayout.l(this.b.a) != null && SelectFrameLayout.m(this.b.a) != null) {
                  if (!SelectFrameLayout.a(this.b.a, SelectFrameLayout.l(this.b.a), param2MotionEvent) && !SelectFrameLayout.a(this.b.a, SelectFrameLayout.m(this.b.a), param2MotionEvent)) {
                    SelectFrameLayout.g(this.b.a);
                    SelectFrameLayout.d(this.b.a);
                  } 
                } else {
                  SelectFrameLayout.d(this.b.a);
                }  
              return true;
            }
          });
    }
    
    public void a() {
      this.b.showAtLocation((View)this.a, 0, 0, 0);
    }
    
    public void b() {
      this.b.dismiss();
    }
  }
  
  class null implements View.OnTouchListener {
    null(SelectFrameLayout this$0, SelectFrameLayout param1SelectFrameLayout) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      if (SelectFrameLayout.c(this.b.a) == null || SelectFrameLayout.OperateWindow.i(SelectFrameLayout.c(this.b.a)) == null)
        this.b.b(); 
      if (!SelectFrameLayout.a(this.b.a, SelectFrameLayout.OperateWindow.i(SelectFrameLayout.c(this.b.a)), param1MotionEvent))
        if (SelectFrameLayout.l(this.b.a) != null && SelectFrameLayout.m(this.b.a) != null) {
          if (!SelectFrameLayout.a(this.b.a, SelectFrameLayout.l(this.b.a), param1MotionEvent) && !SelectFrameLayout.a(this.b.a, SelectFrameLayout.m(this.b.a), param1MotionEvent)) {
            SelectFrameLayout.g(this.b.a);
            SelectFrameLayout.d(this.b.a);
          } 
        } else {
          SelectFrameLayout.d(this.b.a);
        }  
      return true;
    }
  }
  
  class OperateWindow {
    private int b;
    
    private int c;
    
    private PopupWindow d;
    
    private View e;
    
    private LinearLayout f;
    
    private View g;
    
    private View h;
    
    private View i;
    
    private View j;
    
    private View k;
    
    private View l;
    
    private View m;
    
    private View n;
    
    private View o;
    
    public OperateWindow(SelectFrameLayout this$0, Context param1Context) {
      this.b = TextLayoutUtil.a(SelectFrameLayout.h(this$0));
      this.c = DensityUtils.a(SelectFrameLayout.h(this$0), 13.0F);
      this.e = LayoutInflater.from(param1Context).inflate(2131494111, null);
      this.e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.d = new PopupWindow(this.e, -2, -2, false);
      this.d.setClippingEnabled(false);
      this.f = (LinearLayout)this.e.findViewById(2131298899);
      this.g = this.e.findViewById(2131297610);
      this.g.setVisibility(8);
      this.g.setOnClickListener(new View.OnClickListener(this, this$0) {
            public void onClick(View param2View) {
              ((ClipboardManager)SelectFrameLayout.h(this.b.a).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((SelectFrameLayout.k(this.b.a)).a, (SelectFrameLayout.k(this.b.a)).a));
              SelectFrameLayout.g(this.b.a);
              SelectFrameLayout.d(this.b.a);
            }
          });
      this.h = this.e.findViewById(2131297613);
      this.h.setVisibility(8);
      this.h.setOnClickListener(new View.OnClickListener(this, this$0) {
            public void onClick(View param2View) {
              SelectFrameLayout.d(this.b.a);
              SelectFrameLayout.b(this.b.a, 0, SelectFrameLayout.j(this.b.a).getText().length());
              SelectFrameLayout.b(this.b.a, false);
              SelectFrameLayout.b(this.b.a).a();
              SelectFrameLayout.a(this.b.a, SelectFrameLayout.l(this.b.a));
              SelectFrameLayout.a(this.b.a, SelectFrameLayout.m(this.b.a));
              SelectFrameLayout.c(this.b.a).a();
            }
          });
      this.i = this.e.findViewById(2131297611);
      this.i.setVisibility(8);
      this.i.setOnClickListener(new View.OnClickListener(this, this$0) {
            public void onClick(View param2View) {
              if (SelectFrameLayout.n(this.b.a) != null)
                SelectFrameLayout.n(this.b.a).a(); 
              SelectFrameLayout.g(this.b.a);
              SelectFrameLayout.d(this.b.a);
            }
          });
      this.j = this.e.findViewById(2131297614);
      this.j.setVisibility(8);
      this.j.setOnClickListener(new View.OnClickListener(this, this$0) {
            public void onClick(View param2View) {
              if (SelectFrameLayout.n(this.b.a) != null)
                SelectFrameLayout.n(this.b.a).b(); 
              SelectFrameLayout.g(this.b.a);
              SelectFrameLayout.d(this.b.a);
            }
          });
      this.k = this.e.findViewById(2131297615);
      this.k.setVisibility(8);
      this.k.setOnClickListener(new View.OnClickListener(this, this$0) {
            public void onClick(View param2View) {
              if (SelectFrameLayout.n(this.b.a) != null)
                SelectFrameLayout.n(this.b.a).c(); 
              SelectFrameLayout.g(this.b.a);
              SelectFrameLayout.d(this.b.a);
            }
          });
      this.l = this.e.findViewById(2131297612);
      this.l.setVisibility(8);
      this.l.setOnClickListener(new View.OnClickListener(this, this$0) {
            public void onClick(View param2View) {
              if (SelectFrameLayout.n(this.b.a) != null)
                SelectFrameLayout.n(this.b.a).d(); 
              SelectFrameLayout.g(this.b.a);
              SelectFrameLayout.d(this.b.a);
            }
          });
      this.m = this.e.findViewById(2131297608);
      this.m.setVisibility(8);
      this.m.setOnClickListener(new View.OnClickListener(this, this$0) {
            public void onClick(View param2View) {
              if (SelectFrameLayout.n(this.b.a) != null)
                SelectFrameLayout.n(this.b.a).e(); 
              SelectFrameLayout.g(this.b.a);
              SelectFrameLayout.d(this.b.a);
            }
          });
      this.n = this.e.findViewById(2131297609);
      this.n.setVisibility(8);
      this.n.setOnClickListener(new View.OnClickListener(this, this$0) {
            public void onClick(View param2View) {
              if (SelectFrameLayout.n(this.b.a) != null)
                SelectFrameLayout.n(this.b.a).f(); 
              SelectFrameLayout.g(this.b.a);
              SelectFrameLayout.d(this.b.a);
            }
          });
      if (SelectFrameLayout.j(this$0) == null) {
        this.g.setVisibility(8);
        this.h.setVisibility(8);
      } 
      this.o = this.e.findViewById(2131297688);
    }
    
    private int d() {
      int i = 0;
      int j = 0;
      while (i < this.f.getChildCount()) {
        byte b;
        if (this.f.getChildAt(i).getVisibility() == 0) {
          b = this.f.getChildAt(i).getMeasuredWidth();
        } else {
          b = 0;
        } 
        j += b;
        i++;
      } 
      return j;
    }
    
    private int e() {
      return this.e.getMeasuredHeight();
    }
    
    private int f() {
      int i;
      Layout layout = SelectFrameLayout.j(this.a).getLayout();
      int j = (int)layout.getPrimaryHorizontal(SelectFrameLayout.k(this.a).a(SelectFrameLayout.j(this.a)));
      int k = (int)layout.getPrimaryHorizontal(SelectFrameLayout.k(this.a).b(SelectFrameLayout.j(this.a)));
      if (layout.getLineTop(layout.getLineForOffset(SelectFrameLayout.k(this.a).a(SelectFrameLayout.j(this.a)))) == layout.getLineTop(layout.getLineForOffset(SelectFrameLayout.k(this.a).b(SelectFrameLayout.j(this.a))))) {
        i = 1;
      } else {
        i = 0;
      } 
      if (k > j && i) {
        i = k - j;
      } else {
        i = this.a.getWidth() - j - this.a.getPaddingLeft() - this.a.getPaddingRight();
      } 
      return i / 2;
    }
    
    public void a() {
      Layout layout = SelectFrameLayout.j(this.a).getLayout();
      int i = (int)layout.getPrimaryHorizontal(SelectFrameLayout.k(this.a).a(SelectFrameLayout.j(this.a))) + this.a.getSubViewX() - d() / 2 + f();
      int k = layout.getLineTop(layout.getLineForOffset(SelectFrameLayout.k(this.a).a(SelectFrameLayout.j(this.a))));
      int m = this.a.getSubViewY();
      int n = e();
      int j = this.c;
      m = k + m - n - j;
      if (i < j) {
        k = i - j;
        i = j;
        j = k;
      } else {
        j = 0;
      } 
      k = m;
      if (m < 0)
        k = this.c; 
      n = d();
      int i1 = this.b;
      m = i;
      if (n + i > i1 - this.c) {
        j = i - i1 - d() - this.c;
        m = this.b - d() - this.c;
      } 
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.o.getLayoutParams();
      marginLayoutParams.leftMargin = j;
      this.o.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
      this.d.showAtLocation((View)SelectFrameLayout.j(this.a), 0, m, k);
    }
    
    public void b() {
      int i = this.a.getSubViewX() - d() / 2 + SelectFrameLayout.o(this.a).getMeasuredWidth() / 2;
      int k = this.a.getSubViewY();
      int m = e();
      int n = SelectFrameLayout.o(this.a).getPaddingTop();
      int j = this.c;
      m = k - m + n - j;
      if (i < j) {
        k = i - j;
        i = j;
        j = k;
      } else {
        j = 0;
      } 
      n = this.c;
      k = m;
      if (m < n)
        k = n; 
      n = d();
      int i1 = this.b;
      m = i;
      if (n + i > i1 - this.c) {
        j = i - i1 - d() - this.c;
        m = this.b - d() - this.c;
      } 
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.o.getLayoutParams();
      marginLayoutParams.leftMargin = j;
      this.o.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
      this.d.showAtLocation(SelectFrameLayout.o(this.a), 0, m, k);
    }
    
    public void c() {
      this.d.dismiss();
    }
  }
  
  class null implements View.OnClickListener {
    null(SelectFrameLayout this$0, SelectFrameLayout param1SelectFrameLayout) {}
    
    public void onClick(View param1View) {
      ((ClipboardManager)SelectFrameLayout.h(this.b.a).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((SelectFrameLayout.k(this.b.a)).a, (SelectFrameLayout.k(this.b.a)).a));
      SelectFrameLayout.g(this.b.a);
      SelectFrameLayout.d(this.b.a);
    }
  }
  
  class null implements View.OnClickListener {
    null(SelectFrameLayout this$0, SelectFrameLayout param1SelectFrameLayout) {}
    
    public void onClick(View param1View) {
      SelectFrameLayout.d(this.b.a);
      SelectFrameLayout.b(this.b.a, 0, SelectFrameLayout.j(this.b.a).getText().length());
      SelectFrameLayout.b(this.b.a, false);
      SelectFrameLayout.b(this.b.a).a();
      SelectFrameLayout.a(this.b.a, SelectFrameLayout.l(this.b.a));
      SelectFrameLayout.a(this.b.a, SelectFrameLayout.m(this.b.a));
      SelectFrameLayout.c(this.b.a).a();
    }
  }
  
  class null implements View.OnClickListener {
    null(SelectFrameLayout this$0, SelectFrameLayout param1SelectFrameLayout) {}
    
    public void onClick(View param1View) {
      if (SelectFrameLayout.n(this.b.a) != null)
        SelectFrameLayout.n(this.b.a).a(); 
      SelectFrameLayout.g(this.b.a);
      SelectFrameLayout.d(this.b.a);
    }
  }
  
  class null implements View.OnClickListener {
    null(SelectFrameLayout this$0, SelectFrameLayout param1SelectFrameLayout) {}
    
    public void onClick(View param1View) {
      if (SelectFrameLayout.n(this.b.a) != null)
        SelectFrameLayout.n(this.b.a).b(); 
      SelectFrameLayout.g(this.b.a);
      SelectFrameLayout.d(this.b.a);
    }
  }
  
  class null implements View.OnClickListener {
    null(SelectFrameLayout this$0, SelectFrameLayout param1SelectFrameLayout) {}
    
    public void onClick(View param1View) {
      if (SelectFrameLayout.n(this.b.a) != null)
        SelectFrameLayout.n(this.b.a).c(); 
      SelectFrameLayout.g(this.b.a);
      SelectFrameLayout.d(this.b.a);
    }
  }
  
  class null implements View.OnClickListener {
    null(SelectFrameLayout this$0, SelectFrameLayout param1SelectFrameLayout) {}
    
    public void onClick(View param1View) {
      if (SelectFrameLayout.n(this.b.a) != null)
        SelectFrameLayout.n(this.b.a).d(); 
      SelectFrameLayout.g(this.b.a);
      SelectFrameLayout.d(this.b.a);
    }
  }
  
  class null implements View.OnClickListener {
    null(SelectFrameLayout this$0, SelectFrameLayout param1SelectFrameLayout) {}
    
    public void onClick(View param1View) {
      if (SelectFrameLayout.n(this.b.a) != null)
        SelectFrameLayout.n(this.b.a).e(); 
      SelectFrameLayout.g(this.b.a);
      SelectFrameLayout.d(this.b.a);
    }
  }
  
  class null implements View.OnClickListener {
    null(SelectFrameLayout this$0, SelectFrameLayout param1SelectFrameLayout) {}
    
    public void onClick(View param1View) {
      if (SelectFrameLayout.n(this.b.a) != null)
        SelectFrameLayout.n(this.b.a).f(); 
      SelectFrameLayout.g(this.b.a);
      SelectFrameLayout.d(this.b.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\selectabletextview\SelectFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
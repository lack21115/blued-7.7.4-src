package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Predicate;
import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.DescriptorMap;
import com.facebook.stetho.inspector.elements.DescriptorProvider;
import com.facebook.stetho.inspector.elements.DescriptorRegistrar;
import com.facebook.stetho.inspector.elements.DocumentProvider;
import com.facebook.stetho.inspector.elements.DocumentProviderListener;
import com.facebook.stetho.inspector.elements.NodeDescriptor;
import com.facebook.stetho.inspector.elements.ObjectDescriptor;
import com.facebook.stetho.inspector.helper.ThreadBoundProxy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

final class AndroidDocumentProvider extends ThreadBoundProxy implements DocumentProvider, AndroidDescriptorHost {
  private static final int INSPECT_HOVER_COLOR = 1077952767;
  
  private static final int INSPECT_OVERLAY_COLOR = 1090519039;
  
  private static final long REPORT_CHANGED_INTERVAL_MS = 1000L;
  
  private final Application mApplication;
  
  private final DescriptorMap mDescriptorMap;
  
  private final AndroidDocumentRoot mDocumentRoot;
  
  private final ViewHighlighter mHighlighter;
  
  private final Rect mHighlightingBoundsRect = new Rect();
  
  private final Rect mHitRect = new Rect();
  
  private final InspectModeHandler mInspectModeHandler;
  
  private boolean mIsReportChangesTimerPosted;
  
  @Nullable
  private DocumentProviderListener mListener;
  
  private final Runnable mReportChangesTimer;
  
  public AndroidDocumentProvider(Application paramApplication, List<DescriptorProvider> paramList, ThreadBound paramThreadBound) {
    super(paramThreadBound);
    int i = 0;
    this.mIsReportChangesTimerPosted = false;
    this.mReportChangesTimer = new Runnable() {
        public void run() {
          AndroidDocumentProvider.access$002(AndroidDocumentProvider.this, false);
          if (AndroidDocumentProvider.this.mListener != null) {
            AndroidDocumentProvider.this.mListener.onPossiblyChanged();
            AndroidDocumentProvider.access$002(AndroidDocumentProvider.this, true);
            AndroidDocumentProvider.this.postDelayed(this, 1000L);
          } 
        }
      };
    this.mApplication = (Application)Util.throwIfNull(paramApplication);
    this.mDocumentRoot = new AndroidDocumentRoot(paramApplication);
    this.mDescriptorMap = (new DescriptorMap()).beginInit().registerDescriptor(Activity.class, (Descriptor)new ActivityDescriptor()).registerDescriptor(AndroidDocumentRoot.class, (Descriptor)this.mDocumentRoot).registerDescriptor(Application.class, (Descriptor)new ApplicationDescriptor()).registerDescriptor(Dialog.class, (Descriptor)new DialogDescriptor()).registerDescriptor(Object.class, (Descriptor)new ObjectDescriptor()).registerDescriptor(TextView.class, (Descriptor)new TextViewDescriptor()).registerDescriptor(View.class, (Descriptor)new ViewDescriptor()).registerDescriptor(ViewGroup.class, (Descriptor)new ViewGroupDescriptor()).registerDescriptor(Window.class, (Descriptor)new WindowDescriptor());
    DialogFragmentDescriptor.register(this.mDescriptorMap);
    FragmentDescriptor.register(this.mDescriptorMap);
    int j = paramList.size();
    while (i < j) {
      ((DescriptorProvider)paramList.get(i)).registerDescriptor((DescriptorRegistrar)this.mDescriptorMap);
      i++;
    } 
    this.mDescriptorMap.setHost(this).endInit();
    this.mHighlighter = ViewHighlighter.newInstance();
    this.mInspectModeHandler = new InspectModeHandler();
  }
  
  private void getWindows(final Accumulator<Window> accumulator) {
    Descriptor descriptor = getDescriptor(this.mApplication);
    if (descriptor != null) {
      Accumulator<Object> accumulator = new Accumulator<Object>() {
          public void store(Object param1Object) {
            if (param1Object instanceof Window) {
              accumulator.store(param1Object);
              return;
            } 
            Descriptor descriptor = AndroidDocumentProvider.this.getDescriptor(param1Object);
            if (descriptor != null)
              descriptor.getChildren(param1Object, this); 
          }
        };
      descriptor.getChildren(this.mApplication, accumulator);
    } 
  }
  
  public void dispose() {
    verifyThreadAccess();
    this.mHighlighter.clearHighlight();
    this.mInspectModeHandler.disable();
    removeCallbacks(this.mReportChangesTimer);
    this.mIsReportChangesTimerPosted = false;
    this.mListener = null;
  }
  
  public Descriptor getDescriptor(Object paramObject) {
    return (paramObject == null) ? null : this.mDescriptorMap.get(paramObject.getClass());
  }
  
  @Nullable
  public HighlightableDescriptor getHighlightableDescriptor(@Nullable Object<?> paramObject) {
    HighlightableDescriptor highlightableDescriptor;
    if (paramObject == null)
      return null; 
    paramObject = (Object<?>)paramObject.getClass();
    Descriptor descriptor1 = null;
    Descriptor descriptor2 = descriptor1;
    while (descriptor1 == null && paramObject != null) {
      HighlightableDescriptor highlightableDescriptor1;
      Descriptor descriptor4 = this.mDescriptorMap.get((Class)paramObject);
      if (descriptor4 == null)
        return null; 
      Descriptor descriptor3 = descriptor1;
      if (descriptor4 != descriptor2) {
        descriptor3 = descriptor1;
        if (descriptor4 instanceof HighlightableDescriptor)
          highlightableDescriptor1 = (HighlightableDescriptor)descriptor4; 
      } 
      paramObject = (Object<?>)paramObject.getSuperclass();
      descriptor2 = descriptor4;
      highlightableDescriptor = highlightableDescriptor1;
    } 
    return highlightableDescriptor;
  }
  
  public NodeDescriptor getNodeDescriptor(Object paramObject) {
    verifyThreadAccess();
    return (NodeDescriptor)getDescriptor(paramObject);
  }
  
  public Object getRootElement() {
    verifyThreadAccess();
    return this.mDocumentRoot;
  }
  
  public void hideHighlight() {
    verifyThreadAccess();
    this.mHighlighter.clearHighlight();
  }
  
  public void highlightElement(Object paramObject, int paramInt) {
    verifyThreadAccess();
    HighlightableDescriptor<Object> highlightableDescriptor = getHighlightableDescriptor(paramObject);
    if (highlightableDescriptor == null) {
      this.mHighlighter.clearHighlight();
      return;
    } 
    this.mHighlightingBoundsRect.setEmpty();
    paramObject = highlightableDescriptor.getViewAndBoundsForHighlighting(paramObject, this.mHighlightingBoundsRect);
    if (paramObject == null) {
      this.mHighlighter.clearHighlight();
      return;
    } 
    this.mHighlighter.setHighlightedView((View)paramObject, this.mHighlightingBoundsRect, paramInt);
  }
  
  public void onAttributeModified(Object paramObject, String paramString1, String paramString2) {
    DocumentProviderListener documentProviderListener = this.mListener;
    if (documentProviderListener != null)
      documentProviderListener.onAttributeModified(paramObject, paramString1, paramString2); 
  }
  
  public void onAttributeRemoved(Object paramObject, String paramString) {
    DocumentProviderListener documentProviderListener = this.mListener;
    if (documentProviderListener != null)
      documentProviderListener.onAttributeRemoved(paramObject, paramString); 
  }
  
  public void setAttributesAsText(Object paramObject, String paramString) {
    verifyThreadAccess();
    Descriptor descriptor = this.mDescriptorMap.get(paramObject.getClass());
    if (descriptor != null)
      descriptor.setAttributesAsText(paramObject, paramString); 
  }
  
  public void setInspectModeEnabled(boolean paramBoolean) {
    verifyThreadAccess();
    if (paramBoolean) {
      this.mInspectModeHandler.enable();
      return;
    } 
    this.mInspectModeHandler.disable();
  }
  
  public void setListener(DocumentProviderListener paramDocumentProviderListener) {
    verifyThreadAccess();
    this.mListener = paramDocumentProviderListener;
    if (this.mListener == null && this.mIsReportChangesTimerPosted) {
      this.mIsReportChangesTimerPosted = false;
      removeCallbacks(this.mReportChangesTimer);
      return;
    } 
    if (this.mListener != null && !this.mIsReportChangesTimerPosted) {
      this.mIsReportChangesTimerPosted = true;
      postDelayed(this.mReportChangesTimer, 1000L);
    } 
  }
  
  final class InspectModeHandler {
    private List<View> mOverlays;
    
    private final Predicate<View> mViewSelector = new Predicate<View>() {
        public boolean apply(View param2View) {
          return param2View instanceof DocumentHiddenView ^ true;
        }
      };
    
    private InspectModeHandler() {}
    
    public void disable() {
      AndroidDocumentProvider.this.verifyThreadAccess();
      if (this.mOverlays == null)
        return; 
      for (int i = 0; i < this.mOverlays.size(); i++) {
        View view = this.mOverlays.get(i);
        ((ViewGroup)view.getParent()).removeView(view);
      } 
      this.mOverlays = null;
    }
    
    public void enable() {
      AndroidDocumentProvider.this.verifyThreadAccess();
      if (this.mOverlays != null)
        disable(); 
      this.mOverlays = new ArrayList<View>();
      AndroidDocumentProvider.this.getWindows(new Accumulator<Window>() {
            public void store(Window param2Window) {
              if (param2Window.peekDecorView() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup)param2Window.peekDecorView();
                AndroidDocumentProvider.InspectModeHandler inspectModeHandler = AndroidDocumentProvider.InspectModeHandler.this;
                AndroidDocumentProvider.InspectModeHandler.OverlayView overlayView = new AndroidDocumentProvider.InspectModeHandler.OverlayView((Context)AndroidDocumentProvider.this.mApplication);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                viewGroup.addView(overlayView, (ViewGroup.LayoutParams)layoutParams);
                viewGroup.bringChildToFront(overlayView);
                AndroidDocumentProvider.InspectModeHandler.this.mOverlays.add(overlayView);
              } 
            }
          });
    }
    
    final class OverlayView extends DocumentHiddenView {
      public OverlayView(Context param2Context) {
        super(param2Context);
      }
      
      protected void onDraw(Canvas param2Canvas) {
        param2Canvas.drawColor(1090519039);
        super.onDraw(param2Canvas);
      }
      
      public boolean onTouchEvent(MotionEvent param2MotionEvent) {
        int j = (int)param2MotionEvent.getX();
        int i = (int)param2MotionEvent.getY();
        ViewParent viewParent = getParent();
        while (true) {
          Object object;
          HighlightableDescriptor<ViewParent> highlightableDescriptor = AndroidDocumentProvider.this.getHighlightableDescriptor(viewParent);
          if (highlightableDescriptor != null) {
            AndroidDocumentProvider.this.mHitRect.setEmpty();
            Object object1 = highlightableDescriptor.getElementToHighlightAtPosition(viewParent, j, i, AndroidDocumentProvider.this.mHitRect);
            j -= AndroidDocumentProvider.this.mHitRect.left;
            i -= AndroidDocumentProvider.this.mHitRect.top;
            if (object1 != viewParent) {
              object = object1;
              continue;
            } 
          } 
          if (object != null) {
            highlightableDescriptor = AndroidDocumentProvider.this.getHighlightableDescriptor(object);
            if (highlightableDescriptor != null) {
              View view = highlightableDescriptor.getViewAndBoundsForHighlighting(object, AndroidDocumentProvider.this.mHighlightingBoundsRect);
              if (param2MotionEvent.getAction() != 3 && view != null) {
                AndroidDocumentProvider.this.mHighlighter.setHighlightedView(view, AndroidDocumentProvider.this.mHighlightingBoundsRect, 1077952767);
                if (param2MotionEvent.getAction() == 1 && AndroidDocumentProvider.this.mListener != null)
                  AndroidDocumentProvider.this.mListener.onInspectRequested(object); 
              } 
            } 
          } 
          return true;
        } 
      }
    }
  }
  
  class null implements Predicate<View> {
    public boolean apply(View param1View) {
      return param1View instanceof DocumentHiddenView ^ true;
    }
  }
  
  class null implements Accumulator<Window> {
    public void store(Window param1Window) {
      if (param1Window.peekDecorView() instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)param1Window.peekDecorView();
        AndroidDocumentProvider.InspectModeHandler inspectModeHandler = this.this$1;
        AndroidDocumentProvider.InspectModeHandler.OverlayView overlayView = new AndroidDocumentProvider.InspectModeHandler.OverlayView((Context)AndroidDocumentProvider.this.mApplication);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        viewGroup.addView(overlayView, (ViewGroup.LayoutParams)layoutParams);
        viewGroup.bringChildToFront(overlayView);
        this.this$1.mOverlays.add(overlayView);
      } 
    }
  }
  
  final class OverlayView extends DocumentHiddenView {
    public OverlayView(Context param1Context) {
      super(param1Context);
    }
    
    protected void onDraw(Canvas param1Canvas) {
      param1Canvas.drawColor(1090519039);
      super.onDraw(param1Canvas);
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      int j = (int)param1MotionEvent.getX();
      int i = (int)param1MotionEvent.getY();
      ViewParent viewParent = getParent();
      while (true) {
        Object object;
        HighlightableDescriptor<ViewParent> highlightableDescriptor = AndroidDocumentProvider.this.getHighlightableDescriptor(viewParent);
        if (highlightableDescriptor != null) {
          AndroidDocumentProvider.this.mHitRect.setEmpty();
          Object object1 = highlightableDescriptor.getElementToHighlightAtPosition(viewParent, j, i, AndroidDocumentProvider.this.mHitRect);
          j -= AndroidDocumentProvider.this.mHitRect.left;
          i -= AndroidDocumentProvider.this.mHitRect.top;
          if (object1 != viewParent) {
            object = object1;
            continue;
          } 
        } 
        if (object != null) {
          highlightableDescriptor = AndroidDocumentProvider.this.getHighlightableDescriptor(object);
          if (highlightableDescriptor != null) {
            View view = highlightableDescriptor.getViewAndBoundsForHighlighting(object, AndroidDocumentProvider.this.mHighlightingBoundsRect);
            if (param1MotionEvent.getAction() != 3 && view != null) {
              AndroidDocumentProvider.this.mHighlighter.setHighlightedView(view, AndroidDocumentProvider.this.mHighlightingBoundsRect, 1077952767);
              if (param1MotionEvent.getAction() == 1 && AndroidDocumentProvider.this.mListener != null)
                AndroidDocumentProvider.this.mListener.onInspectRequested(object); 
            } 
          } 
        } 
        return true;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\AndroidDocumentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
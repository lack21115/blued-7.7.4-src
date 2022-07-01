package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;

public class Easing {
  public static final EasingFunction A;
  
  public static final EasingFunction B;
  
  public static final EasingFunction a = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return param1Float;
      }
    };
  
  public static final EasingFunction b = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return param1Float * param1Float;
      }
    };
  
  public static final EasingFunction c = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return -param1Float * (param1Float - 2.0F);
      }
    };
  
  public static final EasingFunction d = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        param1Float *= 2.0F;
        if (param1Float < 1.0F)
          return 0.5F * param1Float * param1Float; 
        param1Float--;
        return (param1Float * (param1Float - 2.0F) - 1.0F) * -0.5F;
      }
    };
  
  public static final EasingFunction e = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return (float)Math.pow(param1Float, 3.0D);
      }
    };
  
  public static final EasingFunction f = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return (float)Math.pow((param1Float - 1.0F), 3.0D) + 1.0F;
      }
    };
  
  public static final EasingFunction g = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        param1Float *= 2.0F;
        if (param1Float < 1.0F) {
          param1Float = (float)Math.pow(param1Float, 3.0D);
          return param1Float * 0.5F;
        } 
        param1Float = (float)Math.pow((param1Float - 2.0F), 3.0D) + 2.0F;
        return param1Float * 0.5F;
      }
    };
  
  public static final EasingFunction h = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return (float)Math.pow(param1Float, 4.0D);
      }
    };
  
  public static final EasingFunction i = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return -((float)Math.pow((param1Float - 1.0F), 4.0D) - 1.0F);
      }
    };
  
  public static final EasingFunction j = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        param1Float *= 2.0F;
        return (param1Float < 1.0F) ? ((float)Math.pow(param1Float, 4.0D) * 0.5F) : (((float)Math.pow((param1Float - 2.0F), 4.0D) - 2.0F) * -0.5F);
      }
    };
  
  public static final EasingFunction k = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return -((float)Math.cos(param1Float * 1.5707963267948966D)) + 1.0F;
      }
    };
  
  public static final EasingFunction l = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return (float)Math.sin(param1Float * 1.5707963267948966D);
      }
    };
  
  public static final EasingFunction m = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return ((float)Math.cos(param1Float * Math.PI) - 1.0F) * -0.5F;
      }
    };
  
  public static final EasingFunction n = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return (param1Float == 0.0F) ? 0.0F : (float)Math.pow(2.0D, ((param1Float - 1.0F) * 10.0F));
      }
    };
  
  public static final EasingFunction o = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return (param1Float == 1.0F) ? 1.0F : -((float)Math.pow(2.0D, ((param1Float + 1.0F) * -10.0F)));
      }
    };
  
  public static final EasingFunction p = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        if (param1Float == 0.0F)
          return 0.0F; 
        if (param1Float == 1.0F)
          return 1.0F; 
        param1Float *= 2.0F;
        if (param1Float < 1.0F) {
          param1Float = (float)Math.pow(2.0D, ((param1Float - 1.0F) * 10.0F));
          return param1Float * 0.5F;
        } 
        param1Float = -((float)Math.pow(2.0D, ((param1Float - 1.0F) * -10.0F))) + 2.0F;
        return param1Float * 0.5F;
      }
    };
  
  public static final EasingFunction q = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return -((float)Math.sqrt((1.0F - param1Float * param1Float)) - 1.0F);
      }
    };
  
  public static final EasingFunction r = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        param1Float--;
        return (float)Math.sqrt((1.0F - param1Float * param1Float));
      }
    };
  
  public static final EasingFunction s = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        param1Float *= 2.0F;
        if (param1Float < 1.0F)
          return ((float)Math.sqrt((1.0F - param1Float * param1Float)) - 1.0F) * -0.5F; 
        param1Float -= 2.0F;
        return ((float)Math.sqrt((1.0F - param1Float * param1Float)) + 1.0F) * 0.5F;
      }
    };
  
  public static final EasingFunction t = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        if (param1Float == 0.0F)
          return 0.0F; 
        if (param1Float == 1.0F)
          return 1.0F; 
        float f = (float)Math.asin(1.0D);
        param1Float--;
        return -((float)Math.pow(2.0D, (10.0F * param1Float)) * (float)Math.sin(((param1Float - 0.047746483F * f) * 6.2831855F / 0.3F)));
      }
    };
  
  public static final EasingFunction u = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        if (param1Float == 0.0F)
          return 0.0F; 
        if (param1Float == 1.0F)
          return 1.0F; 
        float f = (float)Math.asin(1.0D);
        return (float)Math.pow(2.0D, (-10.0F * param1Float)) * (float)Math.sin(((param1Float - 0.047746483F * f) * 6.2831855F / 0.3F)) + 1.0F;
      }
    };
  
  public static final EasingFunction v = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        if (param1Float == 0.0F)
          return 0.0F; 
        float f = param1Float * 2.0F;
        if (f == 2.0F)
          return 1.0F; 
        param1Float = (float)Math.asin(1.0D) * 0.07161972F;
        if (f < 1.0F) {
          f--;
          return (float)Math.pow(2.0D, (10.0F * f)) * (float)Math.sin(((f * 1.0F - param1Float) * 6.2831855F * 2.2222223F)) * -0.5F;
        } 
        f--;
        return (float)Math.pow(2.0D, (-10.0F * f)) * 0.5F * (float)Math.sin(((f * 1.0F - param1Float) * 6.2831855F * 2.2222223F)) + 1.0F;
      }
    };
  
  public static final EasingFunction w = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return param1Float * param1Float * (param1Float * 2.70158F - 1.70158F);
      }
    };
  
  public static final EasingFunction x = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        param1Float--;
        return param1Float * param1Float * (param1Float * 2.70158F + 1.70158F) + 1.0F;
      }
    };
  
  public static final EasingFunction y = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        param1Float *= 2.0F;
        if (param1Float < 1.0F)
          return param1Float * param1Float * (3.5949094F * param1Float - 2.5949094F) * 0.5F; 
        param1Float -= 2.0F;
        return (param1Float * param1Float * (3.5949094F * param1Float + 2.5949094F) + 2.0F) * 0.5F;
      }
    };
  
  public static final EasingFunction z = new EasingFunction() {
      public float getInterpolation(float param1Float) {
        return 1.0F - Easing.A.getInterpolation(1.0F - param1Float);
      }
    };
  
  static {
    A = new EasingFunction() {
        public float getInterpolation(float param1Float) {
          if (param1Float < 0.36363637F)
            return 7.5625F * param1Float * param1Float; 
          if (param1Float < 0.72727275F) {
            param1Float -= 0.54545456F;
            return 7.5625F * param1Float * param1Float + 0.75F;
          } 
          if (param1Float < 0.90909094F) {
            param1Float -= 0.8181818F;
            return 7.5625F * param1Float * param1Float + 0.9375F;
          } 
          param1Float -= 0.95454544F;
          return 7.5625F * param1Float * param1Float + 0.984375F;
        }
      };
    B = new EasingFunction() {
        public float getInterpolation(float param1Float) {
          return (param1Float < 0.5F) ? (Easing.z.getInterpolation(param1Float * 2.0F) * 0.5F) : (Easing.A.getInterpolation(param1Float * 2.0F - 1.0F) * 0.5F + 0.5F);
        }
      };
  }
  
  public static interface EasingFunction extends TimeInterpolator {
    float getInterpolation(float param1Float);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\animation\Easing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
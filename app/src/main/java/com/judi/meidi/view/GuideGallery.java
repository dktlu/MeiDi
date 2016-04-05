package com.judi.meidi.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.judi.meidi.R;
import com.judi.meidi.utils.Util;

public class GuideGallery extends ViewPager {
	private boolean left = false;
    private boolean right = false;  
    private boolean isScrolling = false;  
    private int lastValue = -1;  
    private int curPosition;
    private int prePosition;
	private boolean isAutoPlay = false;
	private long timeInterval = 5000;
    
	private int imageSize;
	public LinearLayout bottomFrame;
	public GuideGallery(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public void initPoints(){
		Context context = getContext();
		if(bottomFrame != null){
            bottomFrame.removeAllViews();
			bottomFrame.setOrientation(LinearLayout.HORIZONTAL);
			ImageView image = new ImageView(context);
			LinearLayout.LayoutParams lyParams = new LinearLayout.LayoutParams(Util.dip2px(context,5), Util.dip2px(context, 5));
			int margin = Util.dip2px(context, 5);
			lyParams.setMargins(0, 0, margin, 0);
			image.setLayoutParams(lyParams);
			image.setImageDrawable(getResources().getDrawable(R.drawable.icon_orange_point));
			bottomFrame.addView(image);
			for(int i=1;i<getImageSize();i++){
				image = new ImageView(context);
				image.setLayoutParams(lyParams);
				image.setImageDrawable(getResources().getDrawable(R.drawable.icon_grey_point));
				bottomFrame.addView(image);
			}
			prePosition = 0;
		}
		this.setOnPageChangeListener(listener);
	}


	public int getImageSize() {
		return imageSize;
	}

	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}
	
	/** 
     * listener ,to get move direction . 
*/  
    public OnPageChangeListener listener = new OnPageChangeListener() {
        @Override  
        public void onPageScrollStateChanged(int arg0) {  
            if (arg0 == 1) {  
                isScrolling = true;  
            } else {  
                isScrolling = false;  
            }  
  
            if (arg0 == 2) {  
                right = left = false;  
            }  
  
        }  
  
        @Override  
        public void onPageScrolled(int arg0, float arg1, int arg2) {  
            if (isScrolling) {  
                if (lastValue > arg2) {  
                    right = true;
                    left = false;
                    
                } else if (lastValue < arg2) {
                    right = false;
                    left = true;  
                } else if (lastValue == arg2) {
                    right = left = false;  
                }
            }  
            lastValue = arg2;  
        }  
  
        @Override  
        public void onPageSelected(int arg0) {
        	arg0=arg0%imageSize;
        	if(bottomFrame != null){
        		ImageView preView = (ImageView) bottomFrame.getChildAt(prePosition);
        		curPosition = arg0;
        		ImageView curView = (ImageView) bottomFrame.getChildAt(curPosition);
        		preView.setImageResource(R.drawable.icon_grey_point);
        		curView.setImageResource(R.drawable.icon_orange_point);
        		prePosition = curPosition;
        	}
        	//Toast.makeText(getContext(), ""+arg0, Toast.LENGTH_SHORT).show();
        }  
    };  
      
    public boolean getMoveRight(){
        return right;  
    }  
      
    public boolean getMoveLeft(){
        return left;  
    }  
      
	public boolean isAutoPlay() {
		return isAutoPlay;
	}
	public void setAutoPlay(boolean isAutoPlay) {
		this.isAutoPlay = isAutoPlay;
	}
	public long getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(long timeInterval) {
		this.timeInterval = timeInterval;
	}  
    
}

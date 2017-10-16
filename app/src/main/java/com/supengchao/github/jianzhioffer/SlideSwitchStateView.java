package com.supengchao.github.jianzhioffer;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 三种状态滑块开关
 *
 * @author wangyupeng
 * @since 2014-6-28
 */
public class SlideSwitchStateView extends LinearLayout {
    /**
     *  从左边开始数，第1个开关被选中
     */
    public static final int SELECTED_0 = 0;
    /**
     *  从左边开始数，第2个开关被选中
     */
    public static final int SELECTED_1 = 1;
    /**
     *  从左边开始数，第3个开关被选中
     */
    public static final int SELECTED_2 = 2;

    /**
     * SwitchView的外层Layout
     */
    private RelativeLayout mSvContainer;
    /**
     * 开关按键的ImageView
     */
    private ImageButton mIvSwitchCursor;
    /**
     * 文字信息控件
     */
    private List<TextView> mTextViewList = new ArrayList<>();
    /**
     * 游标离边缘位置
     */
    private int mMargin = 0;
    /**
     * 背景左
     */
    private int mBgLeft;
    /**
     * 背景中
     */
    private int mBgMiddle;
    /**
     * 背景右
     */
    private int mBgRight;
    /**
     * 游标左部
     */
    private int mCursorLeft;
    /**
     * 游标顶部
     */
    private int mCursorTop;
    /**
     * 游标右部
     */
    private int mCursorRight;
    /**
     * 游标中心X坐标
     */
    private int mCursorCenterX;
    /**
     * 游标宽
     */
    private int mCursorWidth;
    /**
     * 游标底部
     */
    private int mCursorBottom;
    /**
     * 移动动画
     */
    private Animation mAnimation;
    /**
     * 当前选中项
     */
    private int mSelected = 0;
    /**
     * 上一次传给用户的选中项目
     */
    private int mSelectedListenerLast = -1;

    /** 用户的注册的开关变化事件监听函数 */
//    private IOnSlideSelectedChangedListener mSwitchListener;
    /**
     * 滑动模块容器
     */
    private LinearLayout mSlideChildViewContainer;

    public SlideSwitchStateView(Context context) {
        super(context);
        initView();
    }

    public SlideSwitchStateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        // 获取所需要的值
        mBgLeft = mSvContainer.getLeft();
        mBgRight = mSvContainer.getRight();
        mBgMiddle = (mBgLeft + mBgRight) / 2;
        mCursorLeft = mIvSwitchCursor.getLeft();
        mCursorTop = mIvSwitchCursor.getTop();
        mCursorRight = mIvSwitchCursor.getRight();
        mCursorBottom = mIvSwitchCursor.getBottom();
        mCursorCenterX = (mCursorLeft + mCursorRight) / 2;
        onSwitchCursorAnimationEnd(false);


    }

    /**
     * 初始化控件
     */
    private void initView() {
        inflate(getContext(), R.layout.slide_switch_state_view, this);

        mSlideChildViewContainer = (LinearLayout) findViewById(R.id.ll_slide_switch_child_container);
        mSvContainer = (RelativeLayout) findViewById(R.id.sv_container);
        mSvContainer.setOnTouchListener(mSvContainerOnTouchListener);

        setTextViewList();
        changeTextColor(mSelected);
        mIvSwitchCursor = (ImageButton) findViewById(R.id.iv_switch_cursor);
        mIvSwitchCursor.setClickable(true);
        mIvSwitchCursor.setOnTouchListener(mIvSwitchCursorOnTouchListener);
    }

    public void setTextViewList() {
        mTextViewList.clear();
        mSlideChildViewContainer.removeAllViews();
        for (int i = 0; i < 4; i++) {
            addChildView("name" + i);
        }
    }

    private void addChildView(String name) {
        final TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        params.gravity = Gravity.CENTER;
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(params);
        textView.setText(name);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 28);
        mTextViewList.add(textView);
        mSlideChildViewContainer.addView(textView);
    }

    /**
     * 滑动槽OnTouchListener
     */
    private OnTouchListener mSvContainerOnTouchListener = new OnTouchListener() {
        int relLastX; // 最后的X坐标

        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mSvContainer.getParent().requestDisallowInterceptTouchEvent(true);
                    relLastX = (int) event.getX();
                    if (relLastX <= mBgLeft + mMargin) {
                        relLastX = mBgLeft + mMargin;
                    }
                    if (relLastX >= mBgRight - mMargin) {
                        mCursorRight = mBgRight - mMargin;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    mSvContainer.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case MotionEvent.ACTION_UP:
                    mSvContainer.getParent().requestDisallowInterceptTouchEvent(false);
                    calculateIscheck(relLastX);
                    break;
            }
            return true;
        }
    };

    /**
     * 滑动游标OnTouchListener
     */
    private OnTouchListener mIvSwitchCursorOnTouchListener = new OnTouchListener() {
        int lastX; // 最后的X坐标

        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    mSvContainer.getParent().requestDisallowInterceptTouchEvent(true);

                    mIvSwitchCursor.setBackgroundResource(R.drawable.slide_bar_press);
                    lastX = (int) event.getRawX();

                    mCursorLeft = v.getLeft();
                    mCursorTop = v.getTop();
                    mCursorRight = v.getRight();
                    mCursorBottom = v.getBottom();
                    mCursorCenterX = (mCursorLeft + mCursorRight) / 2;

                    break;
                case MotionEvent.ACTION_MOVE:
                    mSvContainer.getParent().requestDisallowInterceptTouchEvent(true);

                    int dx = (int) event.getRawX() - lastX;

                    mCursorLeft = v.getLeft() + dx;
                    mCursorRight = v.getRight() + dx;

                    // 超出边界处理
                    if (mCursorLeft <= mBgLeft + mMargin) {
                        mCursorLeft = mBgLeft + mMargin;
                        mCursorRight = mCursorLeft + v.getWidth();
                    }
                    if (mCursorRight >= mBgRight - mMargin) {
                        mCursorRight = mBgRight - mMargin;
                        mCursorLeft = mCursorRight - v.getWidth();
                    }
                    mCursorCenterX = (mCursorLeft + mCursorRight) / 2;
                    v.layout(mCursorLeft, mCursorTop, mCursorRight, mCursorBottom);

                    lastX = (int) event.getRawX();
                    break;

                case MotionEvent.ACTION_UP:
                    mSvContainer.getParent().requestDisallowInterceptTouchEvent(false);
                    mIvSwitchCursor.setBackgroundResource(R.drawable.slide_bar_normal);
                    calculateIscheck();
                    break;
            }
            return true;
        }
    };

    /**
     * 根据mCursorLeft在屏幕绝对坐标计算
     */
    private void calculateIscheck() {
        int centerLeft = mCursorWidth;

        int cursor_center = ((mCursorRight - mCursorLeft) / 2);

        int position = (mCursorLeft + cursor_center) / centerLeft;
        changeSelected(position);
    }

    /**
     * 根据手点击在控件x相对坐标计算
     *
     * @param x  相对坐标
     */
    private void calculateIscheck(int x) {
        int centerLeft =mCursorWidth;
        int position = (x / centerLeft);
        changeSelected(position);
    }

    /**
     * 改变selected, 根据selected移动游标
     *
     * @param selected
     */
    private void changeSelected(int selected) {
        mSelected = selected;
        cursorMove();
    }

    /**
     * 游标移动
     */
    private void cursorMove() {

        mAnimation = null;
        final int toX;
        int targetPosi = mSelected * mCursorWidth;
        toX = targetPosi - mCursorLeft;

        mAnimation = new TranslateAnimation(0, toX, 0, 0);
        mAnimation.setDuration(150);
        mAnimation.setFillEnabled(true);

        mAnimation.setInterpolator(new LinearInterpolator());
        mAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {

            }

            public void onAnimationRepeat(Animation animation) {

            }

            public void onAnimationEnd(Animation animation) {
                // 游标按钮动画结束回调
                onSwitchCursorAnimationEnd(true);
            }
        });

        mIvSwitchCursor.startAnimation(mAnimation);
    }

    /**
     * 游标按钮动画结束回调
     *
     * @param isSayUser 相对滑动的坐标偏移量
     */
    private void onSwitchCursorAnimationEnd(boolean isSayUser) {

        mCursorLeft = mSelected * mCursorWidth;
        mCursorRight = mCursorLeft + mCursorWidth;

        mCursorCenterX = mCursorLeft + mCursorWidth / 2;

        mIvSwitchCursor.layout(mCursorLeft, mCursorTop, mCursorRight, mCursorBottom);
        changeTextColor(mSelected);

        /* 回调用户注册的监听函数 */
//        if ((mSwitchListener != null) && (isSayUser)) {
//            mSwitchListener.onSelectedChanged(mSelected);
//            /* 上一次选中状态更新 */
//            mSelectedListenerLast = mSelected;
//        }
    }

    /**
     * 改变字体显示颜色
     */
    private void changeTextColor(int isChecked) {

        for (int i = 0; i < mTextViewList.size(); i++) {
            TextView textView = mTextViewList.get(i);
            if (isChecked == i) {
                selectedTextView(textView);
            } else {
                normaiTextView(textView);
            }
        }

    }

    private void selectedTextView(TextView textView) {
        textView.setTextColor(getResources().getColor(R.color.white));
    }

    private void normaiTextView(TextView textView) {
        textView.setTextColor(getResources().getColor(R.color.color_main_control_more_trans_white));
    }

    /** 设置用户注册的开关变化事件监听函数 */
//    public boolean setOnSlideSelectedChangedListener(IOnSlideSelectedChangedListener iSwitchListener) {
//        if (iSwitchListener == null) {
//            return false;
//        }
//        mSwitchListener = iSwitchListener;
//        return true;
//    }

    /**
     * 返回现在滑动开关的选中状态
     *
     * @return
     */
    public int getSelected() {
        return mSelected;
    }

    /**
     * 设置现在滑动开关的选中状态
     *
     * @param selected 索引值
     * @return 是否成功设置
     */
    public boolean setSelected(int selected, boolean isAnimation) {
        if (selected > 2) {
            return false;
        }
        mSelected = selected;
        if (isAnimation) {
            changeSelected(selected);
        } else {
            onSwitchCursorAnimationEnd(false);
        }

        return true;
    }

    /**
     * 得到当前游标中心在屏幕中的坐标位置X
     *
     * @return 游标中心位置X(单位像素)
     */
    public int getCursorCenterLocationOnScreen() {
        int[] location = new int[2];
        mIvSwitchCursor.getLocationOnScreen(location);
        return (int) (location[0] + mIvSwitchCursor.getWidth() / 2);
    }

    /**
     * 得到当前游标中心在父控件容器中的坐标位置X
     *
     * @return 游标中心位置X(单位像素)
     */
    public int getCursorCenterLocationInParent() {
        return (int) (mIvSwitchCursor.getLeft() + mIvSwitchCursor.getWidth() / 2);
    }

}

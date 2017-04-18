package com.example.scott.concessionstand;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Scott on 2/19/2017.
 */

public class UpDownBox extends LinearLayout implements View.OnClickListener, View.OnTouchListener {

    private Button mDownButton;
    private TextView mItem;
    private TextView mPrice;
    private Button mUpButton;
    private TextView mQuantity;
    private int startVal;
    private String itemName;
    private float itemPrice;
    private int state;
    private Paint paint;
    private int color;
    private onValueChangedListener aListen;

    public UpDownBox(Context context) {
        super(context);
        initializeViews(context);
    }

    public UpDownBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);

        //TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.updownbox);   //get attributes from xml
        //startVal = ta.getInt(R.styleable.updownbox_startValue, 0);
        //itemName = ta.getString(R.styleable.updownbox_itemName);
        //itemPrice =  R.styleable.updownbox_itemPrice;
        //ta.recycle();   //clear the memory from this, don't need anymore
    }

    public UpDownBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);

        //TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.updownbox);   //get attributes from xml
        //startVal = ta.getInt(R.styleable.updownbox_startValue, 0);
        //itemName = ta.getString(R.styleable.updownbox_itemName);
        //itemPrice =  R.styleable.updownbox_itemPrice;
        //ta.recycle();   //clear the memory from this, don't need anymore
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.updownbox, this);
        setState(0);
        setOnTouchListener(this);
        paint = new Paint();
        mItem = (TextView)findViewById(R.id.txtItem);
        mPrice = (TextView) findViewById(R.id.txtPrice);
        mQuantity = (TextView) findViewById(R.id.txtQuantity);

        mDownButton = (Button) findViewById(R.id.btnDown);
        mUpButton = (Button) findViewById(R.id.btnUp);

        mDownButton.setOnClickListener(this);
        mUpButton.setOnClickListener(this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();

        setVal(Integer.parseInt(mQuantity.getText().toString()));   //using private modifiers
        setItem(mItem.getText().toString());
        setPrice(Float.parseFloat(mPrice.getText().toString()));
    };

    //setters and getters for class objects
    public void setVal(int v) { mQuantity.setText(((Integer)v).toString()); }
    public int returnVal() { return Integer.parseInt(mQuantity.getText().toString()); }
    public void setItem(String s) { mItem.setText(s); }
    public String returnItem() { return mItem.getText().toString(); }
    public void setPrice(float p) { mPrice.setText(String.format("$" + "%.2f", p)); }
    public float returnPrice() { return Float.parseFloat(mPrice.getText().toString()); }

    @Override
    public void onClick(View v) {
        int val = returnVal();

        switch(v.getId()) {
            case R.id.btnDown:
                if (val > 0) {
                    val--;
                    setVal(val);   //using private modifier
                    aListen.onValueChanged(this);
                }
                break;
            case  R.id.btnUp:
                val++;
                setVal(val);   //using private modifier
                aListen.onValueChanged(this);
                break;
        }

        //mTextValue.setText(String.valueOf(val));
    }

    public void setOnValueChangedListener(onValueChangedListener o) {
        aListen = o;
    }

    private void setState(int s) {
        state = s%2;
        setColor(state);
    }

    private void setColor(int s) {
        switch(state) {
            case 0:
                color = Color.LTGRAY;
                break;
            case 1:
                color = Color.DKGRAY;
                break;
        }
        setBackgroundColor(color);
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {               //only changes when you take finger off the toggle
            setState(state+1);
        }
        return false;
    }
}

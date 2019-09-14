package com.example.mynamecard

import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*
import android.graphics.Shader
import android.R.attr.bitmap
import android.graphics.BitmapShader
import android.graphics.RectF
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        hi.setOnClickListener{
            hi.setText("SLEEEEEEEEEEP")
        }

    }
}
public class RoundImage() : Drawable(), Parcelable {

    private var mBitmap: Bitmap? = null
    private var mPaint: Paint? = null
    private var mRectF: RectF? = null
    private var mBitmapWidth: Int = 0
    private var mBitmapHeight: Int = 0

    constructor(parcel: Parcel) : this() {
        mBitmap = parcel.readParcelable(Bitmap::class.java.classLoader)
        mRectF = parcel.readParcelable(RectF::class.java.classLoader)
        mBitmapWidth = parcel.readInt()
        mBitmapHeight = parcel.readInt()
    }

    constructor(bitmap: Bitmap) : this() {
        mBitmap = bitmap
        mRectF = RectF()
        mPaint = Paint()
        mPaint!!.setAntiAlias(true)
        mPaint!!.setDither(true)
        val shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mPaint!!.shader = shader

        mBitmapWidth = mBitmap!!.width
        mBitmapHeight = mBitmap!!.height
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOpacity(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAlpha(alpha: Int) {
        TODO(reason = "not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun draw(canvas: Canvas) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(mBitmap, flags)
        parcel.writeParcelable(mRectF, flags)
        parcel.writeInt(mBitmapWidth)
        parcel.writeInt(mBitmapHeight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RoundImage> {
        override fun createFromParcel(parcel: Parcel): RoundImage {
            return RoundImage(parcel)
        }

        override fun newArray(size: Int): Array<RoundImage?> {
            return arrayOfNulls(size)
        }
    }

}
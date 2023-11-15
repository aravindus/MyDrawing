package com.androidaravind.mydrawing

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var drawingView: DrawingView? = null
    private var ivBrushSizeSelector: ImageButton? = null
    private var ivBrushColorSelector: ImageButton? = null
    private var brushDialog: Dialog? = null
    private var mLinearLayoutColorPicker: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawingView = findViewById(R.id.dvMainLayout)
        ivBrushSizeSelector = findViewById(R.id.ivBrushSizeSelector)
        mLinearLayoutColorPicker = findViewById(R.id.ll_color_picker)
        ivBrushColorSelector = mLinearLayoutColorPicker!![0] as ImageButton
        ivBrushColorSelector!!.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.pallet_pressed
            )
        )

        ivBrushSizeSelector?.setOnClickListener(this)
        brushDialog = Dialog(this)

    }

    private fun showBrushSizeChooserDialog() {
        brushDialog!!.setContentView(R.layout.dialog_brush_size)
        brushDialog!!.setTitle("Please select the brush size")
        val ivSmallBtn = brushDialog!!.findViewById<ImageView>(R.id.ivSmallBtn)
        val ivMediumBtn = brushDialog!!.findViewById<ImageView>(R.id.ivMediumBtn)
        val ivLargeBtn = brushDialog!!.findViewById<ImageView>(R.id.ivLargeBtn)
        ivSmallBtn.setOnClickListener(this)
        ivMediumBtn.setOnClickListener(this)
        ivLargeBtn.setOnClickListener(this)
        brushDialog?.show()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ivBrushSizeSelector -> {
                showBrushSizeChooserDialog()
            }

            R.id.ivSmallBtn -> {
                drawingView?.setSizeForBrush(10.toFloat())
                brushDialog!!.dismiss()

            }

            R.id.ivMediumBtn -> {
                drawingView?.setSizeForBrush(20.toFloat())
                brushDialog!!.dismiss()
            }

            R.id.ivLargeBtn -> {
                drawingView?.setSizeForBrush(30.toFloat())
                brushDialog!!.dismiss()
            }
        }
    }
}
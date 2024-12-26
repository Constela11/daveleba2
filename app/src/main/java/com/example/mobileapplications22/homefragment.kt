package com.example.mobileapplications22

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.core.view.GestureDetectorCompat

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var gestureDetector: GestureDetectorCompat

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gestureDetector = context?.let { GestureDetectorCompat(it, SwipeGestureListener()) }!!

        val frameLayout: FrameLayout = view.findViewById(R.id.caughtUpText)
        frameLayout.setOnTouchListener { v, event -> gestureDetector.onTouchEvent(event) }
    }

    private inner class SwipeGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (e1?.x ?: 0f < e2?.x ?: 0f) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentMessages())
                    .addToBackStack(null)
                    .commit()
            }
            return true
        }
    }
}

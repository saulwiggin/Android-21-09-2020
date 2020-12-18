package com.example.paywithbitcoin.ui.camera

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.CameraX
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.example.paywithbitcoin.MainActivity
import com.example.paywithbitcoin.R


class BarcodeFragment : Fragment() {

//
//    private fun startCamera() {
//        val previewConfig = PreviewConfig.Builder()
//            // We want to show input from back camera of the device
//            .setLensFacing(CameraX.LensFacing.BACK)
//            .build()
//
//        val preview = Preview(previewConfig)
//
//        preview.setOnPreviewOutputUpdateListener { previewOutput ->
//            // textureView.surfaceTexture = previewOutput.surfaceTexture
//        }
//
//        CameraX.bindToLifecycle(this as LifecycleOwner, preview)
//
//        val imageAnalysisConfig = ImageAnalysisConfig.Builder()
//            .build()
//        val imageAnalysis = ImageAnalysis(imageAnalysisConfig)
//
//        val qrCodeAnalyzer = QrCodeAnalyzer { qrCodes ->
//            qrCodes.forEach {
//                Log.d("MainActivity", "QR Code detected: ${it.rawValue}.")
//            }
//        }
//
//        imageAnalysis.analyzer = qrCodeAnalyzer
//
//        // We need to bind preview and imageAnalysis use cases
//        CameraX.bindToLifecycle(this as LifecycleOwner, preview, imageAnalysis)
//    }
//
//    private fun isCameraPermissionGranted(): Boolean {
//        val selfPermission = ContextCompat.checkSelfPermission(baseContext, Manifest.permission.CAMERA)
//        return selfPermission == PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == MainActivity.REQUEST_CAMERA_PERMISSION) {
//            if (isCameraPermissionGranted()) {
//                textureView.post { startCamera() }
//            } else {
//                Toast.makeText(this, "Camera permission is required.", Toast.LENGTH_SHORT).show()
//                finish()
//            }
//        }
//    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_barcode, container, false)
    }

}
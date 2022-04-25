package com.hyunjine.personallotto

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import com.hyunjine.personallotto.util.TAG


class MainActivity : AppCompatActivity() {
    private lateinit var getResult: ActivityResultLauncher<Intent>
    private lateinit var manager: BiometricManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                Log.d(TAG, "onCreate: ${it.data}")
            }
        }
        manager = BiometricManager.from(this)

        when (manager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK)) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                //  생체 인증 가능
                Log.d(TAG, "Application can authenticate with biometrics.")
            }
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                //  기기에서 생체 인증을 지원하지 않는 경우
                Log.d(TAG, "Biometric facility is not available in this device.")
            }
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                Log.d(TAG, "Biometric facility is currently not available")
            }
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                //  생체 인식 정보가 등록되지 않은 경우
                Log.d(TAG, "Any biometric credential is not added in this device.")
            }
            else -> {
                //   기타 실패
                Log.d(TAG, "Fail Biometric facility")
            }
        }

        val prompt = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric login for my app")
            .setSubtitle("Log in using your biometric credential")
            // Can't call setNegativeButtonText() and
            // setAllowedAuthenticators(... or DEVICE_CREDENTIAL) at the same time.
            // .setNegativeButtonText("Use account password")
            .setAllowedAuthenticators(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
            .build()

        biometricPrompt.authenticate(prompt)

    }

    private val biometricPrompt: BiometricPrompt by lazy {

        BiometricPrompt(this@MainActivity, object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Log.d(TAG, "onAuthenticationSucceeded: ${result.toString().split("@")[1]}")
                Toast.makeText(applicationContext, "result : Authentication succeeded", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(applicationContext, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
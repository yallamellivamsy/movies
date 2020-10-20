package application.android.com.movies

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    var handler: Handler
    var runnable: Runnable

    init {
        handler = Handler()
        runnable = Runnable {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startMainActivityUsingHandler()
    }

    private fun startMainActivityUsingHandler() {
        handler.postDelayed(runnable, 2500)
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
        handler.removeMessages(0)
    }


}

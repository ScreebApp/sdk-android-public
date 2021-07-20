package app.screeb.androiddemoapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import app.screeb.androiddemoapp.application.DemoApplication.Companion.screeb
import app.screeb.sdk.init.model.VisitorProperties
import app.screeb.sdk.tracking.model.TrackingEventProperties
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureSetIdentityButton()
        configureSetVisitorPropertiesButton()
        configureTrackEventButton()
        configureTrackScreenButton()
    }

    private fun configureSetIdentityButton() {
        findViewById<Button>(R.id.setIdentityButton).setOnClickListener {
            screeb.setIdentity("<new-user-id>")
        }
    }

    private fun configureSetVisitorPropertiesButton() {
        findViewById<Button>(R.id.setVisitorPropertiesButton).setOnClickListener {
            screeb.setVisitorProperties(
                VisitorProperties().apply {
                    this["email"] = "<user-email>"
                    this["age"] = 32
                    this["company"] = "<My company>"
                    this["logged_at"] = Date()
                    // Add you own properties
                })
        }
    }

    private fun configureTrackEventButton() {
        findViewById<Button>(R.id.trackEventButton).setOnClickListener {
            // Simple event tracking
            screeb.trackEvent("Product removed from cart")

            // Event with properties
            screeb.trackEvent("Product added to cart", TrackingEventProperties().apply {
                this["product_name"] = "Red bike 2021"
                this["category"] = "sport"
                this["price"] = 457.30
                this["count"] = 1
                this["user_logged"] = false
                this["added_at"] = Date()
                // Add you own properties
            })
        }
    }

    private fun configureTrackScreenButton() {
        findViewById<Button>(R.id.trackScreenButton).setOnClickListener {
            // Simple screen tracking
            screeb.trackScreen("ProductCartFragment")

            // Screen with properties
            screeb.trackScreen("FaqFragment", TrackingEventProperties().apply {
                this["product_name"] = "Red bike 2021"
                this["category"] = "sport"
                this["price"] = 457.30
                this["count"] = 1
                this["user_logged"] = false
                this["added_at"] = Date()
                // Add you own properties
            })
        }
    }
}

package app.screeb.androiddemoapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import app.screeb.sdk.Screeb
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
            Screeb.setIdentity(
                "123456789",
                VisitorProperties().apply {
                    this["email"] = "samuel@screeb.app"
                    this["age"] = 42
                    this["company"] = "Screeb"
                    this["logged_at"] = Date()
                    this["technology"] = "kotlin"
                    // Add you own properties
                }
            )
        }
    }

    private fun configureSetVisitorPropertiesButton() {
        findViewById<Button>(R.id.setVisitorPropertiesButton).setOnClickListener {
            Screeb.setVisitorProperties(
                VisitorProperties().apply {
                    this["email"] = "samuel@screeb.app"
                    this["age"] = 42
                    this["company"] = "Screeb"
                    this["logged_at"] = Date()
                    this["technology"] = "kotlin"
                    // Add you own properties
                })
        }
    }

    private fun configureTrackEventButton() {
        findViewById<Button>(R.id.trackEventButton).setOnClickListener {
            // Simple event tracking
            Screeb.trackEvent("Product removed from cart")

            // Event with properties
            Screeb.trackEvent("Product added to cart", TrackingEventProperties().apply {
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
            Screeb.trackScreen("ProductCartFragment")

            // Screen with properties
            Screeb.trackScreen("FaqFragment", TrackingEventProperties().apply {
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

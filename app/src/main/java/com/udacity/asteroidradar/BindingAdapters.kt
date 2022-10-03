package com.udacity.asteroidradar

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.udacity.asteroidradar.main.DailyImage

@BindingAdapter("statusIcon")
fun bindImageViewAsteroiStatus(imageView: ImageView, isHazardous: Boolean){
    val context = imageView.context
    if(isHazardous){
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
        imageView.contentDescription = context.getString(R.string.potentially_hazardous_asteroid_image)
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
        imageView.contentDescription = context.getString(R.string.not_hazardous_asteroid_image)
    }
}


@BindingAdapter("imageOfDay")
fun bindImageOfDay(imageView: ImageView, dailyImage: DailyImage?){
    dailyImage?.let {
        if(dailyImage.media_type == "image"){
            Picasso.get().load(dailyImage.url).into(imageView);
            imageView.contentDescription = dailyImage.title
        } else {
            val context = imageView.context
            imageView.setImageResource(R.drawable.sample_daily_image)
            imageView.contentDescription = context.getString(R.string.sample_daily_image)
        }
    }
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
    }
}

@BindingAdapter("astronomicalUnitText")
fun bindTextViewToAstronomicalUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("kmUnitText")
fun bindTextViewToKmUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("velocityText")
fun bindTextViewToDisplayVelocity(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_s_unit_format), number)
}
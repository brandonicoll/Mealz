package ca.ispy.model.api

import ca.ispy.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

class MealsWebService {

    private lateinit var api: MealsApi //lateinit var of the interface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    fun getMeals() : Call<MealsCategoriesResponse> {
        return api.getMeals()
    }

    interface MealsApi {
        @GET("categories.php")
        fun getMeals() : Call<MealsCategoriesResponse>
    }
}
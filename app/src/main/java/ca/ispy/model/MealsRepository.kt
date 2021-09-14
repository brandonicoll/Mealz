package ca.ispy.model

import ca.ispy.model.api.MealsWebService
import ca.ispy.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val websService : MealsWebService = MealsWebService()) {

    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        return websService.getMeals().enqueue(object : Callback<MealsCategoriesResponse>{
            override fun onResponse(
                call: Call<MealsCategoriesResponse>,
                response: Response<MealsCategoriesResponse>
            ) {
                if (response.isSuccessful )
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
                TODO("treat failure")
            }

        }) //end of enqueue
    }

}
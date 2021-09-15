package ca.ispy.model

import ca.ispy.model.api.MealsWebService
import ca.ispy.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val websService : MealsWebService = MealsWebService()) {

    suspend fun getMeals() : MealsCategoriesResponse {
        return websService.getMeals()
    }

}
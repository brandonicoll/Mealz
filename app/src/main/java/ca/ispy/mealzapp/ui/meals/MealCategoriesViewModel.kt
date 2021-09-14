package ca.ispy.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import ca.ispy.model.MealsRepository
import ca.ispy.model.response.MealResponse
import ca.ispy.model.response.MealsCategoriesResponse

class MealCategoriesViewModel (private val repository : MealsRepository = MealsRepository()) : ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) { //callbacks come in the future
        repository.getMeals() { response ->
            successCallback(response)
        }
    }
}
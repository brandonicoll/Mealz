package ca.ispy.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import ca.ispy.model.MealsRepository
import ca.ispy.model.response.MealResponse

class MealCategoriesViewModel (private val repository : MealsRepository = MealsRepository()) : ViewModel() {
    fun getMeals() : List<MealResponse> {
        return repository.getMeals().categories
    }
}
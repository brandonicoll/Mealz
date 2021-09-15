package ca.ispy.mealzapp.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.ispy.model.MealsRepository
import ca.ispy.model.response.MealResponse
import ca.ispy.model.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealCategoriesViewModel (private val repository : MealsRepository = MealsRepository()) : ViewModel() {

    init { //run coroutine when viewmodel is initialed becuase its only called in the composable (when composable is gone this is too)
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState = mutableStateOf(emptyList<MealResponse>())

    private suspend fun getMeals() : List<MealResponse> {
        return repository.getMeals().categories
    }
}
package ca.ispy.model

import ca.ispy.model.response.MealsCategoriesResponse

class MealsRepository {
    fun getMeals(): MealsCategoriesResponse = MealsCategoriesResponse(arrayListOf())
}
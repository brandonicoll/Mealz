package ca.ispy.mealzapp.ui.meals

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.ispy.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealCategoriesViewModel = viewModel()
    val meals = viewModel.mealsState.value

    LazyColumn{
        items(meals) { meal ->
            Text(text = meal.name)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}
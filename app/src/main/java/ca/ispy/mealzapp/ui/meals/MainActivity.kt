package ca.ispy.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.ispy.mealzapp.ui.theme.MealzAppTheme
import ca.ispy.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {

                    MealsCategoriesScreen()

            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealCategoriesViewModel = viewModel()
    val rememberedMeals = remember { mutableStateOf(emptyList<MealResponse>()) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = "GET_MEALS") { //coroutine function that lets us call something only once
        coroutineScope.launch(Dispatchers.IO) {
            val meals = viewModel.getMeals()
            rememberedMeals.value = meals
        }
    }

    LazyColumn{
        items(rememberedMeals.value) { meal ->
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
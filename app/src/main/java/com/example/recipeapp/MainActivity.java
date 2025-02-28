package com.example.recipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.OnRecipeClickListener {
    private RecyclerView recipeRecyclerView;
    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipeList;
    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        recipeRecyclerView = findViewById(R.id.recipeRecyclerView);
        recipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        String category = getIntent().getStringExtra("CATEGORY");
        recipeList = new ArrayList<>();

        if (category.equals("vegan")) {
            recipeList.add(new Recipe("Vegan Salad",
                    Arrays.asList("Lettuce", "Tomato", "Cucumber", "Olive Oil"),
                    "1. Wash and chop all vegetables.\n" +
                            "2. Mix them in a bowl.\n" +
                            "3. Drizzle with olive oil and toss.\n" +
                            "4. Serve fresh."));

            recipeList.add(new Recipe("Vegan Stir Fry",
                    Arrays.asList("Broccoli", "Tofu", "Soy Sauce", "Garlic"),
                    "1. Cut tofu into cubes.\n" +
                            "2. Heat a pan, sauté garlic, and add tofu.\n" +
                            "3. Stir-fry until golden, add broccoli, cook 3 mins.\n" +
                            "4. Add soy sauce, mix well, serve hot."));

            recipeList.add(new Recipe("Avocado Toast",
                    Arrays.asList("Bread", "Avocado", "Lemon", "Salt", "Pepper"),
                    "1. Toast the bread slices.\n" +
                            "2. Mash the avocado with lemon juice, salt, and pepper.\n" +
                            "3. Spread the mixture on toast and serve."));

            recipeList.add(new Recipe("Vegan Pancakes",
                    Arrays.asList("Flour", "Almond Milk", "Maple Syrup", "Baking Powder"),
                    "1. Mix flour, baking powder, and almond milk.\n" +
                            "2. Stir into smooth batter, pour into a heated pan.\n" +
                            "3. Cook both sides until golden brown, serve with maple syrup."));

            recipeList.add(new Recipe("Vegan Tofu Scramble",
                    Arrays.asList("Tofu", "Turmeric", "Nutritional Yeast", "Spinach"),
                    "1. Crumble tofu in a bowl.\n" +
                            "2. Heat pan, sauté onions, bell peppers.\n" +
                            "3. Add tofu, season with turmeric and salt.\n" +
                            "4. Stir in nutritional yeast, add spinach, cook 2 mins, serve."));

            recipeList.add(new Recipe("Vegan Chickpea Salad",
                    Arrays.asList("Chickpeas", "Cucumber", "Tomatoes", "Lemon Juice"),
                    "1. Rinse chickpeas, chop cucumber, tomatoes.\n" +
                            "2. Mix all ingredients, drizzle with lemon juice.\n" +
                            "3. Toss and serve chilled."));

            recipeList.add(new Recipe("Vegan Lentil Soup",
                    Arrays.asList("Lentils", "Carrots", "Garlic", "Cumin"),
                    "1. Sauté garlic, carrots in a pot.\n" +
                            "2. Add lentils, pour in broth.\n" +
                            "3. Simmer 20 mins, season with cumin, blend if desired, serve."));

            recipeList.add(new Recipe("Vegan Stuffed Peppers",
                    Arrays.asList("Bell Peppers", "Quinoa", "Black Beans", "Tomatoes"),
                    "1. Cook quinoa, sauté onions, black beans, and tomatoes.\n" +
                            "2. Stuff mixture into bell peppers, bake 25 mins at 375°F.\n" +
                            "3. Serve warm."));

            recipeList.add(new Recipe("Vegan Sweet Potato Curry",
                    Arrays.asList("Sweet Potatoes", "Coconut Milk", "Chickpeas", "Curry Powder"),
                    "1. Sauté onions, garlic, add sweet potatoes and curry powder.\n" +
                            "2. Pour in coconut milk, simmer 15 mins.\n" +
                            "3. Add chickpeas, cook 5 mins, serve with rice."));

            recipeList.add(new Recipe("Vegan Zucchini Noodles",
                    Arrays.asList("Zucchini", "Tomatoes", "Garlic", "Basil"),
                    "1. Spiralize zucchini, sauté garlic, add cherry tomatoes.\n" +
                            "2. Toss in zucchini noodles, cook 1 min.\n" +
                            "3. Garnish with basil, serve."));

        } else if (category.equals("vegetarian")) {
            recipeList.add(new Recipe("Paneer Butter Masala",
                    Arrays.asList("200g paneer (cubed)", "2 medium tomatoes (pureed)", "1 onion (finely chopped)",
                            "1 tbsp ginger-garlic paste", "2 tbsp butter", "1/2 cup cream", "1 tsp garam masala",
                            "1 tsp turmeric", "1 tsp red chili powder", "1 tsp cumin seeds",
                            "Salt to taste", "1 tbsp kasuri methi (dried fenugreek leaves)"),
                    "1. Heat butter in a pan, add cumin seeds, and let them crackle.\n" +
                            "2. Add chopped onions and sauté until golden brown.\n" +
                            "3. Stir in ginger-garlic paste and cook for a minute.\n" +
                            "4. Add tomato puree, turmeric, chili powder, and salt. Cook until oil separates.\n" +
                            "5. (Optional) Blend and strain the masala for a smoother texture.\n" +
                            "6. Add cubed paneer and mix well.\n" +
                            "7. Pour in cream, garam masala, and kasuri methi. Simmer for 5 minutes.\n" +
                            "8. Serve hot with naan or rice."
            ));

            recipeList.add(new Recipe("Veg Pulao",
                    Arrays.asList("1 cup basmati rice", "1/2 cup mixed vegetables (carrot, beans, peas)",
                            "1 onion (sliced)", "1 bay leaf", "1 tsp cumin seeds", "1 tsp garam masala",
                            "2 cups water", "Salt to taste", "1 tbsp oil or ghee"),
                    "1. Rinse rice thoroughly and soak it in water for 20 minutes.\n" +
                            "2. Heat oil or ghee in a pan, add bay leaf and cumin seeds, and let them crackle.\n" +
                            "3. Add sliced onions and sauté until golden brown.\n" +
                            "4. Add mixed vegetables, salt, and garam masala. Stir well and cook for a minute.\n" +
                            "5. Drain the soaked rice and add it to the pan along with 2 cups of water.\n" +
                            "6. Cover and cook on low heat until the rice is fully cooked and water is absorbed.\n" +
                            "7. Gently fluff the rice with a fork and serve hot."
            ));



            recipeList.add(new Recipe("Chana Masala",
                    Arrays.asList("1 cup chickpeas (soaked overnight)", "1 onion (chopped)", "2 tomatoes (pureed)",
                            "1 tsp cumin seeds", "1 tbsp chana masala", "1 tsp turmeric", "1 tsp red chili powder",
                            "Salt to taste", "1 tbsp oil"),
                    "1. Pressure cook chickpeas with water and salt until soft.\n" +
                            "2. Heat oil in a pan, add cumin seeds, and let them crackle.\n" +
                            "3. Add chopped onions and sauté until golden brown.\n" +
                            "4. Stir in tomato puree, turmeric, chili powder, and cook until oil separates.\n" +
                            "5. Add boiled chickpeas and mix well. Cook for 10 minutes.\n" +
                            "6. Add water as needed and simmer to enhance flavors.\n" +
                            "7. Garnish with fresh coriander and serve hot with rice or roti."
            ));


            recipeList.add(new Recipe("Aloo Paratha",
                    Arrays.asList("2 cups wheat flour", "2 boiled potatoes (mashed)", "1 tsp cumin powder",
                            "1 tsp garam masala", "Salt to taste", "Ghee for cooking"),
                    "1. Knead wheat flour with water into a soft, pliable dough.\n" +
                            "2. In a bowl, mix mashed potatoes with cumin powder, garam masala, and salt.\n" +
                            "3. Roll dough into a small circle, place potato filling, and seal edges.\n" +
                            "4. Roll again gently into a paratha shape.\n" +
                            "5. Cook on a hot tawa, adding ghee, until golden brown on both sides.\n" +
                            "6. Serve hot with curd or pickle."
            ));


            recipeList.add(new Recipe("Palak Paneer",
                    Arrays.asList("2 cups spinach (blanched and pureed)", "200g paneer (cubed)", "1 onion (chopped)",
                            "2 tomatoes (pureed)", "1 tsp cumin", "1 tsp garam masala", "1/2 cup cream"),
                    "1. Blanch spinach in hot water, then blend into a smooth paste.\n" +
                            "2. Heat oil in a pan, add cumin seeds, and sauté chopped onions.\n" +
                            "3. Add tomato puree and cook until oil separates.\n" +
                            "4. Stir in spinach puree and cook for a few minutes.\n" +
                            "5. Add paneer cubes and simmer for 5 minutes.\n" +
                            "6. Pour in cream, mix well, and serve hot with rice or roti."
            ));


            recipeList.add(new Recipe("Vegetable Soup",
                    Arrays.asList("1 cup mixed vegetables (carrot, beans, cabbage)", "4 cups water", "1 tsp black pepper",
                            "Salt to taste", "1 tbsp cornflour (mixed with water)"),
                    "1. Bring water to a boil in a pot, then add chopped vegetables.\n" +
                            "2. Add salt and black pepper, stirring well.\n" +
                            "3. Mix cornflour with water and add to the soup.\n" +
                            "4. Cook until the soup thickens slightly.\n" +
                            "5. Serve warm with bread or as an appetizer."
            ));


            recipeList.add(new Recipe("Gobi Manchurian",
                    Arrays.asList("1 cup cauliflower florets", "1/2 cup cornflour", "1 tbsp soy sauce", "1 tbsp tomato ketchup",
                            "1 tbsp garlic (chopped)", "Salt to taste", "Oil for frying"),
                    "1. Mix cornflour, salt, and water into a thick batter.\n" +
                            "2. Dip cauliflower florets into the batter and coat well.\n" +
                            "3. Deep fry the florets until crispy and golden brown.\n" +
                            "4. Heat oil in a pan, sauté garlic, then add soy sauce and ketchup.\n" +
                            "5. Toss the fried cauliflower into the sauce and mix well.\n" +
                            "6. Serve hot as a snack or side dish."
            ));


            recipeList.add(new Recipe("Dal Tadka",
                    Arrays.asList("1 cup toor dal", "1 onion (chopped)", "1 tomato (chopped)", "1 tsp cumin",
                            "2 cloves garlic (chopped)", "1 tsp turmeric", "Salt to taste"),
                    "1. Boil toor dal with turmeric and water until soft.\n" +
                            "2. Heat oil in a pan, add cumin seeds, and sauté onions and garlic.\n" +
                            "3. Add chopped tomatoes and cook until soft.\n" +
                            "4. Pour this tadka (tempering) over the cooked dal and mix well.\n" +
                            "5. Simmer for 5 minutes and serve hot with rice or roti."
            ));


            recipeList.add(new Recipe("Veg Biryani",
                    Arrays.asList("1 cup basmati rice", "1/2 cup mixed vegetables", "1 onion (sliced)",
                            "1 bay leaf", "1 tsp garam masala", "Salt to taste", "2 cups water"),
                    "1. Cook basmati rice until 70% done, then drain excess water.\n" +
                            "2. Heat oil in a pan, add bay leaf, and sauté onions until golden.\n" +
                            "3. Add mixed vegetables and cook for a few minutes.\n" +
                            "4. Layer the rice over the cooked vegetables and sprinkle garam masala.\n" +
                            "5. Cover and cook on low heat for 10 minutes until flavors blend.\n" +
                            "6. Serve hot with raita or yogurt."
            ));


            recipeList.add(new Recipe("Masala Dosa",
                    Arrays.asList("2 cups dosa batter", "2 boiled potatoes (mashed)", "1 onion (chopped)",
                            "1 tsp mustard seeds", "1 tsp turmeric", "Salt to taste"),
                    "1. Heat oil in a pan, add mustard seeds, and let them crackle.\n" +
                            "2. Add chopped onions, mashed potatoes, turmeric, and salt. Mix well.\n" +
                            "3. Heat a dosa tawa, pour batter, and spread it thinly.\n" +
                            "4. Place the potato masala in the center of the dosa.\n" +
                            "5. Fold the dosa and serve hot with coconut chutney and sambar."
            ));


            recipeList.add(new Recipe("Aloo Gobi (Potato & Cauliflower Curry)",
                    Arrays.asList("2 potatoes (cubed)", "1 small cauliflower (cut into florets)", "1 onion (chopped)",
                            "2 tomatoes (chopped)", "2 cloves garlic (minced)", "1-inch ginger (grated)",
                            "1 tsp cumin seeds", "1 tsp turmeric powder", "1 tsp garam masala",
                            "1 tsp red chili powder", "Salt to taste", "2 tbsp oil", "Fresh coriander for garnish"),
                    "1. Heat oil in a pan and add cumin seeds. Let them crackle.\n" +
                            "2. Add chopped onions and sauté until golden brown.\n" +
                            "3. Add garlic and ginger, cook for a minute until fragrant.\n" +
                            "4. Add chopped tomatoes and cook until soft.\n" +
                            "5. Add turmeric, chili powder, and garam masala. Mix well.\n" +
                            "6. Add potatoes and cook for 5 minutes, stirring occasionally.\n" +
                            "7. Add cauliflower and mix everything well.\n" +
                            "8. Cover and cook for 15 minutes on low heat until vegetables are soft.\n" +
                            "9. Garnish with fresh coriander and serve with roti or rice."
            ));


        } else if (category.equals("nonveg")) {
            recipeList.add(new Recipe("Chicken Curry",
                    Arrays.asList("Chicken", "Onions", "Tomatoes", "Spices"),
                    "1. Sauté onions, add tomatoes, spices.\n" +
                            "2. Add chicken, cook 20 mins.\n" +
                            "3. Serve hot with rice or bread."));

            recipeList.add(new Recipe("Grilled Salmon",
                    Arrays.asList("Salmon", "Lemon", "Garlic", "Herbs"),
                    "1. Marinate salmon, grill 5-7 mins per side.\n" +
                            "2. Serve with vegetables or salad."));

            recipeList.add(new Recipe("Beef Stroganoff",
                    Arrays.asList("Beef", "Mushrooms", "Onion", "Sour Cream"),
                    "1. Sauté onions, mushrooms, add beef, brown.\n" +
                            "2. Simmer with beef broth, stir in sour cream, serve."));


            recipeList.add(new Recipe("Chicken Biryani",
                    Arrays.asList("1 cup basmati rice", "250g chicken (cut into pieces)", "1 onion (sliced)",
                            "1 tomato (chopped)", "1/2 cup yogurt", "1 tsp garam masala", "1 tsp turmeric",
                            "1 tsp red chili powder", "1 tsp cumin seeds", "1 bay leaf", "2 cups water",
                            "Salt to taste", "2 tbsp ghee"),
                    "1. Rinse basmati rice and soak for 30 minutes.\n" +
                            "2. Mix chicken with yogurt, turmeric, chili powder, and salt. Marinate for 1 hour.\n" +
                            "3. Heat ghee in a pot, add cumin seeds, bay leaf, and sliced onions. Sauté until golden brown.\n" +
                            "4. Add marinated chicken and cook until it turns white.\n" +
                            "5. Stir in chopped tomatoes and garam masala. Cook until oil separates.\n" +
                            "6. Drain and add soaked rice over the chicken.\n" +
                            "7. Pour 2 cups of water, cover, and cook on low heat for 20 minutes.\n" +
                            "8. Let it rest for 10 minutes, fluff gently, and serve hot."
            ));


            recipeList.add(new Recipe("Butter Chicken",
                    Arrays.asList("250g chicken (boneless, cubed)", "2 tomatoes (pureed)", "1 onion (chopped)",
                            "1 tbsp ginger-garlic paste", "2 tbsp butter", "1/2 cup cream", "1 tsp garam masala",
                            "1 tsp turmeric", "1 tsp red chili powder", "1 tbsp kasuri methi", "Salt to taste"),
                    "1. Mix chicken with turmeric, chili powder, and salt. Let it rest for 30 minutes.\n" +
                            "2. Heat butter in a pan and cook the chicken until golden brown. Remove and set aside.\n" +
                            "3. In the same pan, sauté onions, ginger-garlic paste, and tomato puree until oil separates.\n" +
                            "4. (Optional) Blend the masala for a smoother sauce and strain back into the pan.\n" +
                            "5. Return chicken to the pan, mix well, and let it simmer.\n" +
                            "6. Stir in cream, garam masala, and kasuri methi. Cook for 5 more minutes.\n" +
                            "7. Garnish with butter and serve with naan or rice."
            ));


            recipeList.add(new Recipe("Mutton Curry",
                    Arrays.asList("250g mutton (bone-in)", "1 onion (chopped)", "2 tomatoes (chopped)",
                            "1 tbsp ginger-garlic paste", "1 tsp turmeric", "1 tsp red chili powder",
                            "1 tsp garam masala", "2 tbsp oil", "Salt to taste", "2 cups water"),
                    "1. Mix mutton with turmeric, chili powder, and salt. Let it rest for 1 hour.\n" +
                            "2. Heat oil in a pressure cooker, add onions, and sauté until golden.\n" +
                            "3. Add ginger-garlic paste and tomatoes. Cook until oil separates.\n" +
                            "4. Stir in mutton and mix well.\n" +
                            "5. Add water, close the lid, and cook for 4-5 whistles.\n" +
                            "6. Let it simmer for 10 minutes before serving."
            ));


            recipeList.add(new Recipe("Fish Fry",
                    Arrays.asList("2 fish fillets", "1 tsp turmeric", "1 tsp red chili powder", "1 tsp salt",
                            "1 tbsp lemon juice", "2 tbsp oil"),
                    "1. Coat fish with turmeric, chili powder, salt, and lemon juice. Let it rest for 30 minutes.\n" +
                            "2. Heat oil in a pan on medium flame.\n" +
                            "3. Place fish in the pan and fry for 3-4 minutes per side until crispy.\n" +
                            "4. Garnish with lemon wedges and serve hot."
            ));


            recipeList.add(new Recipe("Chicken Tikka",
                    Arrays.asList("250g boneless chicken (cubed)", "1/2 cup yogurt", "1 tbsp ginger-garlic paste",
                            "1 tsp red chili powder", "1 tsp garam masala", "Salt to taste", "1 tbsp oil"),
                    "1. Mix chicken with yogurt, spices, and oil. Let it rest for 1 hour.\n" +
                            "2. Preheat oven to 200°C.\n" +
                            "3. Place chicken on a baking tray and bake for 20 minutes, turning halfway.\n" +
                            "4. Garnish with lemon slices and onion rings, then serve hot."
            ));


            recipeList.add(new Recipe("Egg Curry",
                    Arrays.asList("4 boiled eggs", "1 onion (chopped)", "2 tomatoes (chopped)",
                            "1 tbsp ginger-garlic paste", "1 tsp turmeric", "1 tsp red chili powder",
                            "1 tsp garam masala", "Salt to taste", "2 tbsp oil"),
                    "1. Heat oil in a pan, add onions, and sauté until golden.\n" +
                            "2. Add ginger-garlic paste, tomatoes, and spices. Cook until oil separates.\n" +
                            "3. Slice boiled eggs in half and gently place them in the curry.\n" +
                            "4. Simmer for 5 minutes, then serve with rice or roti."
            ));


            recipeList.add(new Recipe("Prawn Masala",
                    Arrays.asList("250g prawns (cleaned)", "1 onion (chopped)", "2 tomatoes (chopped)",
                            "1 tbsp ginger-garlic paste", "1 tsp turmeric", "1 tsp red chili powder",
                            "Salt to taste", "2 tbsp oil"),
                    "1. Coat prawns with turmeric, chili powder, and salt. Let it rest for 30 minutes.\n" +
                            "2. Heat oil in a pan, add onions, and sauté until golden.\n" +
                            "3. Add tomatoes, ginger-garlic paste, and cook until oil separates.\n" +
                            "4. Stir in prawns and cook for 5 minutes.\n" +
                            "5. Serve hot with steamed rice."
            ));


            recipeList.add(new Recipe("Chicken Soup",
                    Arrays.asList("250g chicken (bone-in)", "4 cups water", "1 onion (chopped)",
                            "1 carrot (chopped)", "1 tsp black pepper", "Salt to taste"),
                    "1. In a pot, bring water to a boil and add chicken.\n" +
                            "2. Stir in onions, carrots, salt, and pepper.\n" +
                            "3. Cook for 20 minutes until chicken is tender.\n" +
                            "4. Strain and serve warm."
            ));


            recipeList.add(new Recipe("Keema Paratha",
                    Arrays.asList("1 cup minced meat (keema)", "2 cups wheat flour", "1 onion (chopped)",
                            "1 tsp cumin powder", "Salt to taste", "Ghee for cooking"),
                    "1. Heat oil in a pan, sauté onions, and cook minced meat with spices.\n" +
                            "2. Knead wheat flour into a soft dough.\n" +
                            "3. Roll dough, add keema filling, and seal.\n" +
                            "4. Roast on a hot tawa with ghee until golden.\n" +
                            "5. Serve hot with yogurt or chutney."
            ));


            recipeList.add(new Recipe("Chicken Lollipop",
                    Arrays.asList("6 chicken drumsticks", "1 tbsp soy sauce", "1 tbsp red chili paste",
                            "1 tbsp ginger-garlic paste", "Salt to taste", "Oil for frying"),
                    "1. Coat chicken with soy sauce, chili paste, and spices. Let it rest for 1 hour.\n" +
                            "2. Heat oil in a deep pan.\n" +
                            "3. Deep-fry drumsticks until crispy.\n" +
                            "4. Serve hot with chili sauce."
            ));


            recipeList.add(new Recipe("Shrimp Tacos",
                    Arrays.asList("Shrimp", "Tortilla", "Cabbage", "Sour Cream"),
                    "1. Cook shrimp, warm tortillas.\n" +
                            "2. Fill tortillas with cabbage, shrimp, sour cream, serve."));

        }

        recipeAdapter = new RecipeAdapter(recipeList, this);
        recipeRecyclerView.setAdapter(recipeAdapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        List<Recipe> filteredList = new ArrayList<>();
        for (Recipe recipe : recipeList) {
            if (recipe.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(recipe);
            }
        }
        recipeAdapter = new RecipeAdapter(filteredList, this);
        recipeRecyclerView.setAdapter(recipeAdapter);
    }

    @Override
    public void onRecipeClick(Recipe recipe) {
        Intent intent = new Intent(MainActivity.this, RecipeDetailActivity.class);
        intent.putExtra("RECIPE_TITLE", recipe.getTitle());
        intent.putStringArrayListExtra("RECIPE_INGREDIENTS", new ArrayList<>(recipe.getIngredients()));
        intent.putExtra("RECIPE_INSTRUCTIONS", recipe.getInstructions());
        startActivity(intent);
    }
}
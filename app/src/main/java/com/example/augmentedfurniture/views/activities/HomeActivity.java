package com.example.augmentedfurniture.views.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import com.example.augmentedfurniture.R;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    Button btnAdd;
    HorizontalScrollView svFoodH;
    ArFragment arFragment;
    ModelRenderable donutRenderable, frenchFriesRenderable, hamburgerRenderable, hotDogRenderable,
            pizzaRenderable, sushiRenderable;
    ImageView donut, frenchFries, hamburger, hotDog, pizza, sushi;
    View[] arrayView;
    int selected = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        supportActionBar();
    }

    private void supportActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Augmented Food");

        initials();
    }

    private void initials() {
        btnAdd = findViewById(R.id.buttonAdd);
        svFoodH = findViewById(R.id.scrollViewFoodH);
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragmentH);

        donut = findViewById(R.id.imageViewDonutH);
        frenchFries = findViewById(R.id.imageViewFrenchFriesH);
        hamburger = findViewById(R.id.imageViewHamburgerH);
        hotDog = findViewById(R.id.imageViewHotDogH);
        pizza = findViewById(R.id.imageViewPizzaH);
        sushi = findViewById(R.id.imageViewSushiH);

        btnAdd.setOnClickListener(view -> {
            btnAdd.setVisibility(View.GONE);
            svFoodH.setVisibility(View.VISIBLE);
        });

        setUpModel();
        setArrayView();
        setOnClickListener();

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            Anchor anchor = hitResult.createAnchor();
            AnchorNode anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());

            createModel(anchorNode, selected);
        });
    }

    private void setUpModel() {

        ModelRenderable.builder()
                .setSource(HomeActivity.this, R.raw.donut_01)
                .build().thenAccept(renderable -> donutRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(HomeActivity.this, "Unable to load donut", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(HomeActivity.this, R.raw.frernchfries_01)
                .build().thenAccept(renderable -> frenchFriesRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(HomeActivity.this, "Unable to load french fries", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(HomeActivity.this, R.raw.hamburger)
                .build().thenAccept(renderable -> hamburgerRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(HomeActivity.this, "Unable to load hamburger", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(HomeActivity.this, R.raw.hotdog)
                .build().thenAccept(renderable -> hotDogRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(HomeActivity.this, "Unable to load hot hotDog", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(HomeActivity.this, R.raw.pizza)
                .build().thenAccept(renderable -> pizzaRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(HomeActivity.this, "Unable to load pizza", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(HomeActivity.this, R.raw.model)
                .build().thenAccept(renderable -> sushiRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(HomeActivity.this, "Unable to load sushi", Toast.LENGTH_LONG).show();
                    return null;
                });
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1) {
            TransformableNode donut = new TransformableNode(arFragment.getTransformationSystem());
            donut.setParent(anchorNode);
            donut.setRenderable(donutRenderable);
            donut.select();

            addName(anchorNode, donut, "Donut");
            donut.setOnTapListener((hitTestResult, motionEvent) -> addDetails(anchorNode, donut,
                    "1 tablespoon plus 1 teaspoon active dry yeast\n" +
                            "1 cup whole milk, heated to 110°F\n" +
                            "2 to 2 1/2 cups (320 to 400 grams) bread flour\n" +
                            "1 teaspoon pure vanilla extract\n" +
                            "3 large egg yolks\n" +
                            "2 tablespoons (30 grams) superfine sugar\n" +
                            "1/2 teaspoon table salt\n" +
                            "4 tablespoons (1/2 stick or 2 ounces) unsalted butter, softened at room temperature and cut into cubes\n" +
                            "Vegetable oil for frying\n" +
                            "Basic Sugar Glaze\n" +
                            "Chocolate Glaze"));

//            donut.setOnTouchListener((hitTestResult, motionEvent) -> false);
        }
        if (selected == 2) {
            TransformableNode frenchFries = new TransformableNode(arFragment.getTransformationSystem());
            frenchFries.setParent(anchorNode);
            frenchFries.setRenderable(frenchFriesRenderable);
            frenchFries.select();

            addName(anchorNode, frenchFries, "French Fries");
            frenchFries.setOnTapListener((hitTestResult, motionEvent) -> addDetails(anchorNode, frenchFries,
                    " Potatoes, \n" +
                            " Vegetable Oil (Canola Oil, Soybean Oil, Hydrogenated Soybean Oil, \n" +
                            " Natural Beef Flavor [Wheat and Milk Derivatives]*, Citric Acid [Preservative]), \n" +
                            " Dextrose, Sodium Acid Pyrophosphate (Maintain Color), Salt.\n" +
                            "Prepared in Vegetable Oil (Canola Oil, Corn Oil, Soybean Oil, Hydrogenated Soybean Oil) with \n" +
                            " TBHQ and Citric Acid to preserve freshness of the oil and \n" +
                            " Dimethylpolysiloxane to reduce oil splatter when cooking"));
        }
        if (selected == 3) {
            TransformableNode hamburger = new TransformableNode(arFragment.getTransformationSystem());
            hamburger.setParent(anchorNode);
            hamburger.setRenderable(hamburgerRenderable);
            hamburger.select();

            addName(anchorNode, hamburger, "Hamburger");
            hamburger.setOnTapListener((hitTestResult, motionEvent) -> addDetails(anchorNode, hamburger,
                    "1 1/2 pounds lean ground beef.\n" +
                            "1/2 onion, finely chopped.\n" +
                            "1/2 cup shredded Colby Jack or Cheddar cheese.\n" +
                            "1 teaspoon soy sauce.\n" +
                            "1 teaspoon Worcestershire sauce.\n" +
                            "1 egg.\n" +
                            "1 (1 ounce) envelope dry onion soup mix. \n" +
                            "1 clove garlic, minced1 tablespoon garlic powder. \n" +
                            "1 teaspoon dried parsley. \n" +
                            "1 teaspoon dried basil1 teaspoon dried oregano. \n" +
                            "1/2 teaspoon crushed dried rosemary. \n" +
                            "salt and pepper to taste."));
        }
        if (selected == 4) {
            TransformableNode hotDog = new TransformableNode(arFragment.getTransformationSystem());
            hotDog.setParent(anchorNode);
            hotDog.setRenderable(hotDogRenderable);
            hotDog.select();

            addName(anchorNode, hotDog, "Hot Dog");
            hotDog.setOnTapListener((hitTestResult, motionEvent) -> addDetails(anchorNode, hotDog,
                    "5 pounds fully pastured/grass-fed beef (either ground by your butcher or in cubes for you to grind at home)\n" +
                            "1 tablespoon paprika\n" +
                            "2 tablespoons mustard powder\n" +
                            "1 teaspoon black pepper\n" +
                            "1 teaspoon garlic powder\n" +
                            "Pinch of celery seed\n" +
                            "½ teaspoon coriander\n" +
                            "2 tablespoons salt\n" +
                            "Just over 1 cup ice-cold water\n" +
                            "Sheep casings (24-26 mm)"));
        }
        if (selected == 5) {
            TransformableNode pizza = new TransformableNode(arFragment.getTransformationSystem());
            pizza.setParent(anchorNode);
            pizza.setRenderable(pizzaRenderable);
            pizza.select();

            addName(anchorNode, pizza, "Pizza");
            pizza.setOnTapListener((hitTestResult, motionEvent) -> addDetails(anchorNode, pizza,
                    "Extra virgin olive oil\n" +
                            "Cornmeal (to help slide the pizza onto the pizza stone)\n" +
                            "Tomato sauce (smooth, or pured)\n" +
                            "Firm mozzarella cheese, grated\n" +
                            "Fresh soft mozzarella cheese, separated into small clumps\n" +
                            "Fontina cheese, grated\n" +
                            "Parmesan cheese, grated\n" +
                            "Feta cheese, crumbled\n" +
                            "Mushrooms, very thinly sliced if raw, otherwise first salted\n" +
                            "Bell peppers, stems and seeds removed, very thinly sliced\n" +
                            "Italian pepperoncini, thinly sliced\n" +
                            "Italian sausage, cooked ahead and crumbled\n" +
                            "Chopped fresh basil\n" +
                            "Baby arugula, tossed in a little olive oil, added as pizza comes out of the oven\n" +
                            "Pesto\n" +
                            "Pepperoni, thinly sliced\n" +
                            "Onions, thinly sliced raw or caramelized\n" +
                            "Ham, thinly sliced"));
        }
        if (selected == 6) {
            TransformableNode sushi = new TransformableNode(arFragment.getTransformationSystem());
            sushi.setParent(anchorNode);
            sushi.setRenderable(sushiRenderable);
            sushi.select();

            addName(anchorNode, sushi, "Sushi");
            sushi.setOnTapListener((hitTestResult, motionEvent) -> addDetails(anchorNode, sushi,
                    "6 sheets sushi seaweed aka nori\n" +
                            "1 batch prepared sushi rice\n" +
                            "1/2 lb sushi-grade raw salmon or desired raw fish of choice\n" +
                            "4 oz cream cheese sliced into strips\n" +
                            "1 avocado sliced\n" +
                            "soy sauce for serving\n"));
        }
    }

    private void addDetails(AnchorNode anchorNode, TransformableNode model, String details) {
        ViewRenderable.builder()
                .setView(HomeActivity.this, R.layout.food_details).build()
                .thenAccept(viewRenderable -> {
                    TransformableNode ingredientView = new TransformableNode(arFragment.getTransformationSystem());
                    ingredientView.setLocalPosition(new Vector3(model.getLocalPosition().x + 1.5f,
                            model.getLocalPosition().y, 0));
                    ingredientView.setParent(anchorNode);
                    ingredientView.setRenderable(viewRenderable);
                    ingredientView.select();

                    TextView textIngredient = viewRenderable.getView().findViewById(R.id.textViewIngredientsFD);
                    textIngredient.setText(R.string.food_ingredients);
                    TextView textIngredientName = viewRenderable.getView().findViewById(R.id.textViewIngredientNameFD);
                    textIngredientName.setText(details);
                    textIngredientName.setOnClickListener(view -> ingredientView.setParent(null));
                });
    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {
        ViewRenderable.builder()
                .setView(HomeActivity.this, R.layout.food_name).build()
                .thenAccept(viewRenderable -> {
                    TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y + 1.5f, 0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();

                    TextView textName = viewRenderable.getView().findViewById(R.id.textViewFoodNameNF);
                    textName.setText(name);
                    textName.setOnClickListener(view -> anchorNode.setParent(null));
                });
    }

    private void setOnClickListener() {
        for (View view : arrayView) {
            view.setOnClickListener(view1 -> {
                if (view1.getId() == R.id.imageViewDonutH) {
                    selected = 1;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.imageViewFrenchFriesH) {
                    selected = 2;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.imageViewHamburgerH) {
                    selected = 3;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.imageViewHotDogH) {
                    selected = 4;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.imageViewPizzaH) {
                    selected = 5;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.imageViewSushiH) {
                    selected = 6;
                    setBackground(view1.getId());
                }
            });
        }
    }

    private void setBackground(int id) {
        for (View view : arrayView) {
            if (view.getId() == id)
                view.setBackgroundColor(Color.parseColor("#80333639"));
            else
                view.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void setArrayView() {
        arrayView = new View[]{donut, frenchFries, hamburger, hotDog, pizza, sushi};
    }
}
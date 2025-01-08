package chapter_2_create_destroy_objects.use_builder;

import chapter_2_create_destroy_objects.use_builder.NutritionFacts;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NutritionFactsTest {
    @Test
    void testNutritionFactsWithMandatoryFields() {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(250, 2).build();

        assertThat(nutritionFacts).isNotNull();
        assertThat(nutritionFacts.toString()).isEqualTo(
                "NutritionFacts{servingSize=250, servings=2, calories=0, fat=0, sodium=0, carbohydrate=0}"
        );
    }

    @Test
    void testNutritionFactsWithAllFields() {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(250, 2)
                .calories(300)
                .fat(10)
                .sodium(150)
                .carbohydrate(50)
                .build();

        assertThat(nutritionFacts).isNotNull();
        assertThat(nutritionFacts.toString()).isEqualTo(
                "NutritionFacts{servingSize=250, servings=2, calories=300, fat=10, sodium=150, carbohydrate=50}"
        );
    }

    @Test
    void testNutritionFactsWithPartialOptionalFields() {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(100, 1)
                .calories(100)
                .fat(5)
                .build();

        assertThat(nutritionFacts).isNotNull();
        assertThat(nutritionFacts.toString()).isEqualTo(
                "NutritionFacts{servingSize=100, servings=1, calories=100, fat=5, sodium=0, carbohydrate=0}"
        );
    }

}
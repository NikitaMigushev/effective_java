package chapter_2_create_destroy_objects.use_builder;

import chapter_2_create_destroy_objects.use_builder.MargheritaPizza;
import chapter_2_create_destroy_objects.use_builder.Pizza;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MargheritaPizzaTest {
    @Test
    void testBuildWithMandatoryFields() {
        // Create a MargheritaPizza with no extra cheese and no toppings
        MargheritaPizza pizza = new MargheritaPizza.Builder().build();

        // Assertions
        assertThat(pizza).isNotNull();
        assertThat(pizza.toString()).isEqualTo("MargheritaPizza{toppings=[], extraCheese=false}");
    }

    @Test
    void testBuildWithExtraCheese() {
        // Create a MargheritaPizza with extra cheese
        MargheritaPizza pizza = new MargheritaPizza.Builder()
                .extraCheese(true)
                .build();

        // Assertions
        assertThat(pizza).isNotNull();
        assertThat(pizza.toString()).isEqualTo("MargheritaPizza{toppings=[], extraCheese=true}");
    }

    @Test
    void testBuildWithToppingsAndExtraCheese() {
        // Create a MargheritaPizza with toppings and extra cheese
        MargheritaPizza pizza = new MargheritaPizza.Builder()
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .extraCheese(true)
                .build();

        // Assertions
        assertThat(pizza).isNotNull();
        assertThat(pizza.toString()).isEqualTo("MargheritaPizza{toppings=[HAM, MUSHROOM], extraCheese=true}");
    }

    @Test
    void testBuildWithToppingsOnly() {
        // Create a MargheritaPizza with toppings but no extra cheese
        MargheritaPizza pizza = new MargheritaPizza.Builder()
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.PEPPER)
                .build();

        // Assertions
        assertThat(pizza).isNotNull();
        assertThat(pizza.toString()).isEqualTo("MargheritaPizza{toppings=[ONION, PEPPER], extraCheese=false}");
    }

}
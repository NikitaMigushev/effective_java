package chapter_2_create_destroy_objects.use_builder;

public class MargheritaPizza extends Pizza {
    private final boolean extraCheese;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean extraCheese = false;

        public Builder extraCheese(boolean value) {
            extraCheese = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public MargheritaPizza build() {
            return new MargheritaPizza(this);
        }
    }

    private MargheritaPizza(Builder builder) {
        super(builder);
        extraCheese = builder.extraCheese;
    }

    @Override
    public String toString() {
        return "MargheritaPizza{" +
                "toppings=" + toppings +
                ", extraCheese=" + extraCheese +
                '}';
    }
}

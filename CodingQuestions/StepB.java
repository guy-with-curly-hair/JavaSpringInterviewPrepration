package CodingQuestions;

interface StepB {
    StepBuilder b(String b);
}

interface StepA {
    StepB a(String a);
}

final class StepBuilder implements StepA, StepB {
    private String a;
    private String b;
    private String c = "";

    private StepBuilder() {
    }

    static StepA with() {
      return new StepBuilder();
    }

    // mandatory, from StepA
    @Override
    public StepB a(String a) {
        this.a = a;
        return this;
    }

    // mandatory, from StepB
    @Override
    public StepBuilder b(String b) {
        this.b = b;
        return this;
    }

    // optional
    StepBuilder c(String c) {
        this.c = c;
        return this;
    }
    Product build() {
        return new Product(a, b, c);
    }

    class Product {
        String a1;
        String b1;
        String c1;

        Product(String a, String b, String c) {
            this.a1 = a;
            this.b1 = b;
            this.c1 = c;
        }
    }
}

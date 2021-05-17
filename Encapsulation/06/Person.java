import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getBagOfProducts() {
        return bagOfProducts;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Name cannot be empty%n");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalStateException("Money cannot be negative%n");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.getMoney() >= product.getCost()) {
            this.setMoney(this.getMoney() - product.getCost());
            this.bagOfProducts.add(product);
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        } else {
            System.out.printf("%s can`t afford %s%n", this.getName(), product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - ", this.getName()));
        if (this.getBagOfProducts().size() == 0) {
            sb.append("Nothing bought");
        } else {
            sb.append(this.getBagOfProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
        return sb.toString();

    }
}


public class Cart {
    private final int[] prices;
    private final String cartId;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(
                "Capacity cannot be negative."
            );
        }

        this.cartId = cartId;
        this.prices = new int[capacity];
        this.itemCount = 0;
    }

    public void addItem(int price) {
        if (price < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        if (itemCount >= prices.length) {
            System.out.println("Cart is full.");
            return;
        }

        prices[itemCount] = price;
        itemCount++;
    }

    public long getTotal() {
        long total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}

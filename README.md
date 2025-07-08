# Challenge 1: E-commerce System


## 🏗️ System Architecture

1. **Product Hierarchy**
   - Base `Product` class with common properties
   - `ExpirableProduct` for items with expiration dates
   - `ShippableProduct` for items requiring shipping
   - `ExpirableShippableProduct` for items with expiration dates and can be shipped

2. **Shopping Cart System**
   - Add products with quantity validation
   - Stock availability checking
   - Expiration date validation

3. **Checkout Process**
   - Order subtotal calculation
   - Shipping fee computation
   - Balance validation
   - Payment processing

4. **Shipping Service**
   - Interface-based shipping integration
   - Weight calculation for shippable items


## 💻 Usage Examples

### Basic Usage

![image](https://github.com/user-attachments/assets/0224e822-be92-4471-8a3e-54f345fad2d5)


### Console Output

![image](https://github.com/user-attachments/assets/8e1810f8-d481-49a4-9377-270853034fb4)


## 🔧 Error Handling

The system handles various error scenarios:

### Cart Validation
- **Empty Cart**: Prevents checkout with no items
- **Insufficient Stock**: Validates product availability
- **Expired Products**: Checks expiration dates for perishable items

### Payment Validation
- **Insufficient Balance**: Ensures customer has enough funds
- **Invalid Quantities**: Prevents adding more items than available


---

# Challenge Quantum Bookstore 📚


## 🏗️ System Architecture


1. **Book Hierarchy**
   ```
   Book (Abstract Base Class)
   ├── PaperBook (Physical inventory + shipping)
   ├── EBook (Digital format + email delivery)
   └── DemoBook (Demo purposes only)
   ```

2. **Inventory Management**
   - Add books with ISBN, title, author, year, price
   - Remove outdated books based on age criteria
   - Stock quantity tracking for physical books

3. **Purchase System**
   - ISBN-based book lookup
   - Quantity validation and stock reduction
   - Automated fulfillment routing
   - Payment amount calculation

4. **Service Integration**
   - **ShippingService**: Handles physical book delivery
   - **MailService**: Manages digital book distribution



## 💻 Usage Examples

![image](https://github.com/user-attachments/assets/1458be27-419b-4ca7-a6a7-a9a31e44c8b0)

### Console Output

![image](https://github.com/user-attachments/assets/6f65c0f3-0220-4d88-b751-9e04607e0293)




### Design Decisions
1. **Extensibility**: New book types can be added without modifying existing code
2. **Error Handling**: Comprehensive validation and user-friendly error messages



---

This project is developed for educational purposes as part of the Fawry internship challenge.

---



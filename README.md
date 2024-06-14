# Shipping Company - Backend Programming Homework

## Project Description

This project is designed to calculate the shipping cost of products from China to Germany on a regular basis. The application is implemented in Java and includes several products to be shipped:

1. **Laptop**:
    - Box size: 60x50x50 cm
    - Weight: 6.5 kg
2. **Mouse**:
    - Box size: 30x30x20 cm
    - Weight: 200 g
3. **Desktop**:
    - Box size: 100x150x50 cm
    - Weight: 20 kg
4. **LCD Screens**:
    - Box size: 120x140x80 cm
    - Weight: 2.6 kg

There are two different shipping options available:

1. **Small Container**:
    - Height: 2.59m
    - Width: 2.43m
    - Length: 6.06m

2. **Big Container**:
    - Height: 2.59m
    - Width: 2.43m
    - Length: 12.01m

Shipping Costs:
- **Big Container**: 1800 Euro regardless of the shipment weight.
- **Small Container**: 1000 Euro for 500 kg or less, and 1200 Euro for weight more than 500 kg.

The program reads the order information from the user and calculates the best shipping methods according to the least price.

## Solution Steps

### Package: `items`
**Class: `Item`**
- Constructors
- Getters and Setters
- Calculate Volume Method
- Print item info

### Package: `containers`
**Class: `Container`**
- Constructors
- Getters and Setters
- Calculate Volume
- Print container info

### Package: `methods`
**Class: `Calculation`**
- `totalVolume` method
- `totalWeight` method
- `bestShipping` method
- `shippingPrice` method
- `addItems` method
- `addOrder` method
- `printItem` method to print items information
- `printOrder` method to show order information and price

### Test Main Method
- Add products details
- Read the order
- Print the results

## Solution Conditions

1. Based on OOP principles, no static methods are allowed (except for Lambda Functions if needed). **(10 points penalty)**
2. All variables must be private. **(4 point penalty)**
3. Use inheritance and abstract classes in the solution. **(4 points penalty)**
4. Use Array or List to save the shape of the items (item objects). **(2 points penalty)**
5. Use Array or List to save the order information (numbers of items). **(2 points penalty)**
6. Follow the package structures and use the correct package and class names as shown above. **(2 Points penalty)**
7. Use UTF-8 character encoding. **(1 point penalty)**

### Project Structure

- Create a project called `YourNameHW`, using your first name and last name.
- Write your name in the code as a comment.

## Report the Solution

- Include comments to explain your program correctly.
- Use Lists or ArrayLists as needed.

## Notes

1. This homework is individual; each student must submit their solution within the timeframe. Late submissions will receive a zero.
2. Save your homework in a compressed file named `YourNameHW.zip` and submit it before the deadline.
3. Nonworking programs or failure to submit on time will receive a zero.
4. Any copied homework will result in failing the course.
5. Upload your report or file under your name in MsTeam.
6. No questions will be answered after 17:00, on holidays, or on days off.

**Good Luck!**

Prof. Dr. Rand Kouatly  
EU University Europe, Summer 2024

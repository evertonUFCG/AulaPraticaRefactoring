# Aula Prática sobre Refactoring

Temos duas versão de código do sistema VideoStore (original e refatorada). Os códigos e refatoramentos aplicados são baseados em exemplos do livro de Martin Fowler sobre refatoramentos.

Lista de refatoramentos aplicados, em ordem, durante a aula:
1) Extract Method: método amountFor(Rental each) extraído de Customer.statement()
2) Rename Variable: variável each de Customer.amountFor foi renomeada para aRental
3) Move Method: método Customer.amountFor(each) foi movido para a classe Rental
4) Rename Method: método Rental.amountFor foi renomeado para getCharge
5) Replace Temp with Query: variável thisAmount em Customer.statement() foi substitída por uma chamada de método
6) Extract Method: método getFrenquentPoints(Rental each) foi extraído de Customer.statement()
7) Move Method: método Customer.getFrenquentPoints(each)) foi movido para a classe Rental
8) Replace Temp with Query: variável totalAmount em Customer.statement() foi substitída por uma chamada de método
9) Replace Temp with Query: variável frequentRenterPoints em Customer.statement() foi substitída por uma chamada de método
10) Move Method: método Rental.getCharge foi movido para Movie
11) Replace Conditional with Polymorphism

11.1) Introduzir relacionamento de herança: classes Price (superclasse abstrata), ChildrensPrice, NewReleasePrice e RegularPrice 
```
   class Movie...

   private Price price;

   public Movie(String name, int priceCode) {
      title = name;
      setPriceCode(priceCode);
   }
    
   public int getPriceCode() {
      return price.getPriceCode();
   }
   
   public void setPriceCode(int arg) {
      switch (arg) {
         case REGULAR:
            price = new RegularPrice();
            break;
         case CHILDRENS:
            price = new ChildrensPrice();
            break;
         case NEW_RELEASE:
            price = new NewReleasePrice();
            break;
         default:
            throw new IllegalArgumentException("Incorrect Price Code");
      }
   }
   ...
```
11.2) Extrair e mover getCharge(int) da classe Movie para getCharge(int) na classe Price:
```
   class Movie...

   private Price _price;

   public Movie(String name, int priceCode) {
      _title = name;
      setPriceCode(priceCode);
   }
    
   public int getPriceCode() {
      return _price.getPriceCode();
   }
   
   public void setPriceCode(int arg) {
      switch (arg) {
         case REGULAR:
            _price = new RegularPrice();
            break;
         case CHILDRENS:
            _price = new ChildrensPrice();
            break;
         case NEW_RELEASE:
            _price = new NewReleasePrice();
            break;
         default:
            throw new IllegalArgumentException("Incorrect Price Code");
      }
   }
   ...
```
11.3) Decompor getCharge criando métodos específicos nas subclasses de Price:
```
    class Price...
   public abstract double getCharge(int daysRented);
```
```
    class ChildrensPrice ...
   public double getCharge(int daysRented) {
      double result = 1.5;
      if (daysRented > 3)
         result += (daysRented - 3) * 1.5;
      return result;
   }
```

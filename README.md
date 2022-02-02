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

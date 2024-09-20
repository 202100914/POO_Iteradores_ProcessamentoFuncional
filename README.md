# POO_Iteradores_ProcessamentoFuncional



### Objetivo

> - Iteradores e processamento funcional.

## Programa

Protótipo de uma aplicação para facilitar a gestão de contas de um serviço streaming e os respetivos pagamentos.


## Implementação

### Nível 1:

1. Inclua as classes `Account` e `StreamingService` fornecidas com este enunciado num projeto BlueJ, que deve criar no repositório local (clonado com o GitHub Desktop).

2. Altere os métodos da classe `StreamingService` de forma a retornar valores fixos de modo a possibilitar a compilação da classe. Por exemplo, os métodos que retornam referências de objetos retornam o valor `null`, os métodos que retornam inteiros retornam o valor -1, etc.

3. Crie a classe de teste `StreamingServiceTest`, para a classe `StreamingService`.

4. Crie o método de teste `testConstructor` que testa o construtor. Este método de teste deve criar o objeto StreamingService como uma Fixture e verificar que o objeto é inicializado corretamente, ou seja, que após a criação o atributo não é null.

5. Implemente o código interno do construtor e também do seletor da classe (necessário para verificar que o construtor inicializou corretamente o objeto).

6. Execute o teste criado (quando completar a implementação do código interno dos métodos utilizados no teste, a execução do teste deve ter sucesso).

### Nível 2:

1. Crie o método de teste `testAddAccount`.

2. Implemente o código interno do método `addAccount`.

3. Execute todos os testes criados.

4. Crie o método de teste `testRemoveAccount`.

5. Implemente o código interno do método `removeAccount`.

6. Execute todos os testes criados.

### Nível 3:

1. Crie o método de teste `testRemoveUnpaidAccounts` (utilize os objetos da Tabela 1).

2. Implemente o código interno do método `removeUnpaidAccounts` de modo a utilizar um iterador.

3. Execute todos os testes criados.

4. Crie o método de teste `testSetAllAccountsAsUnpaid`.

5. Implemente o código interno do método `setAllAccountsAsUnpaid` que deve utilizar o processamento funcional.

6. Execute todos os testes criados.

| Identificador | Nome           | Pago  |
|:-------------:|:--------------:|:-----:|
| **Account1**   | José Manuel     | true  |
| **Account2**   | Francisco Silva   | false |
| **Account3**   | Maria Clara    | false |
| **Account4**   | Clotilde Matias | true  |
| **Account5**   | Fernanda Costa    | false |

<center><strong>Tabela 1</strong> - Objetos para testar a classe StreamingServiceTest</center><br/>

### Nível 4:

1. Crie o método de teste `testRemoveUnpaidAccountsRemoveIf`.

2. Implemente o código interno do método `removeUnpaidAccountsRemoveIf` de modo a utilizar o método `removeIf` da coleção.

3. Execute todos os testes criados.

4. Crie o método de teste `testGetListOfUnpaidAccounts`.

5. Em seguida, implemente o código interno do método `getListOfUnpaidAccounts` que deve utilizar o processamento funcional.

6. Execute todos os testes criados.

### Nível 5:

1. Crie o método de teste `testCountUnpaidAccounts`.

2. Implemente o código interno do método `countUnpaidAccounts` que deve utilizar o processamento funcional.

3. Execute todos os testes criados.

O método `toString` da classe `StreamingService` deve retornar uma string no formato apresentado na listagem 1. 

4. Crie o método de teste `testToString`.

5. Implemente o código interno do método `toString` que deve utilizar o processamento funcional.

6. Execute todos os testes criados.

```shell
Contas do serviço de streaming:

Nome                Pago
José Manuel         true
Francisco Silva     false
Maria Clara         false
Clotilde Matias     true
Fernanda Costa      false
```

<center><strong>Listagem 1</strong> - Exemplo de String a devolver pelo método toString para o ginásio com os membros da tabela 1</center>



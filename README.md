# Cliente de cotação de Bitcoin

Um software simples que através do processamento de dados coletados pela API do <a href="https://www.mercadobitcoin.com.br">Mercado Bitcoin</a> gera informações que são utilizadas por uma página de dashboard.

## Como funciona

Esse sistema busca dados do histórico de negociações da API do Mercado Bitcoin, através do endereço `https://www.mercadobitcoin.net/api/BTC/trades/1501871369/1501891200/` e transforma os mesmos em informações resumidas, disponibilizadas em uma nova API contento as seguintes informações:

`/trades/higher_sales` - As cinco maiores vendas

`/trades/higher_purchases` -  As cinco maiores compras

`/trades/average_sale` - Valor médio de venda

`/trades/average_purchase` - Valor médio de compra

`/trades/median_sale` - Valor mediano de venda

`/trades/median_purchase` - Valor mediano de compra

`/trades/standard_deviation_sale` - Desvio padrão de venda

`/trades/standard_deviation_purchase` - Desvio padrão de compra


Um cliente desenvolvido com AngularJS consome estas informações e as exibe em forma de dashboard.

1. Rode o sistema
``` 
mvn spring-boot:run
```
2. Abra o navegador em `http://localhost:8080/`. 

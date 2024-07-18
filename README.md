# stock-scraper
API that serves scraped stock data in JSON format


# set up:

## This service requires the folowing environment variables to be set:
|name|value|example|
|----|----|----|
|STOCK_SCRAPER_DB_URL|url to the mysql database|jdbc:mysql://localhost:3306/stock_scraper|
|STOCK_SCRAPER_DB_USER|username|stock_scraper|
|STOCK_SCRAPER_DB_PASS|password|test|

### to start in dev: mvn spring-boot:run -Dspring-boot.run.profiles=dev
### to start in prod: mvn spring-boot:run -Dspring-boot.run.profiles=prod

# endpoints: 

## GET: /stock/exchange/ticker
Returns information for a stock 
#### URL Parameters:
|name|type|description|
|----|----|-----------|
|ticker|String|The stock ticker|
|exchange|String|Acronym for the exchange. Currently supported: ASX|
## GET: /price/exchange/ticker
Returns a list of prices between the given dates for a stock, with dates inclusive on both ends
#### URL Parameters
|name|type|description|
|----|----|-----------|
|ticker|String|The stock ticker|
|exchange|String|Acronym for the exchange. Currently supported: ASX|
#### Query Parameters
|name|type|description|required|
|---|---|---|---|
|startDate|iso formatted date string eg. 2024-07-11|start date of search|yes|
|endDate|iso formatted date string eg. 2024-07-11|end date of search|yes|
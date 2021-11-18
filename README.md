## End points:

### Country/Países

GET https://gabrieljuliao-cities-api.herokuapp.com/country <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

GET https://gabrieljuliao-cities-api.herokuapp.com/country/{id} <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

GET https://gabrieljuliao-cities-api.herokuapp.com/country?page={number}&size={number}&sort={attribute} <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

### States/Estados

GET https://gabrieljuliao-cities-api.herokuapp.com/state <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

GET https://gabrieljuliao-cities-api.herokuapp.com/state/{id} <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

GET https://gabrieljuliao-cities-api.herokuapp.com/state?page={number}&size={number}&sort={attribute} <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

### Cities/Cidades

GET https://gabrieljuliao-cities-api.herokuapp.com/city <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

GET https://gabrieljuliao-cities-api.herokuapp.com/city/{id} <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

GET https://gabrieljuliao-cities-api.herokuapp.com/city?page={number}&size={number}&sort={attribute} <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

GET https://gabrieljuliao-cities-api.herokuapp.com/city/distance-in-between/{cityId1}/{cityId2} <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

GET https://gabrieljuliao-cities-api.herokuapp.com/city/distance-in-between/{cityId1}/{cityId2}/?unit={MI} <br>
Accept: application/json;charset=utf8;application/hal+json;charset=utf8;

A aplicação é HATEOAS enabled, basta dar um GET no "/".


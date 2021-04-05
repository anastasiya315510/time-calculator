# time-calculator
This service convinient hepls to convert:
  - address to coordinate
  - calculate time in trip
  
To use this service you should install this service to your intelijj. To make a request with postman for calculating time:
1).Put in address: "http://localhost:8080/crd/time"
2).In the field body you should choose JSON
3). Mark raw
4). Enter in body you json for example:
{
"countryFrom":"Israel",
"cityFrom":"Lod",
"streetFrom":"HaEla",
"buildingFrom": 3,
"countryTo":"Israel",
"cityTo":"Holon",
"streetTo":"Bialik",
"buildingTo": 5
}

you will get aswer. This is result of calculated time in seconds(value), or in text 28 min:
{
    "text": "28 mins",
    "value": 1665
}


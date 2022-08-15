# weather-app

Weather App created during TTS bootcamp using the Open Weather API and SpringBoot.

- For graders: completed steps of the assignment:

1. Add the necessary database settings to application.properties.
2. Create a model/entity to store zip codes in the database.
3. Create a zip code repository.
4. Inject the zip code repository into the weather service.
5. Any time the getForecast method is called in the weather service, add the zip code to the database.
6. Create a weather service method to get the (up to 10) most recent searches.

Next Steps: 
 7. In both of the weather controller methods, call the new service method and add the the list of zip codes to the model.
 8. In the html page, add code to display the recent searches in a table.


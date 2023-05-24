# chicago.dtc-pokemon
Prueba técnica
Crear una aplicación Java, la cual:
-	Debe tener una arquitectura de tres niveles
-	Debe consumir el API RESTful https://pokeapi.co/api/v2/pokemon 
-	Debe traer los resultados paginados
-	Debe exponer los resultados en un servicio SOAP y poderse consumir por SOAP UI
-	Debe aplicar dos patrones de diseño y sustentar su uso

thw web service has security with this credencials and type passowrd digest 
username: admin
password : pwd123

there's a soap ui project in the folder /pokemonWs/pokemonService-wsdl-soapui-project.xml

thw two desing patter i decided to use are : 
singleton :The Singleton pattern ensures that there is only one instance of the class in the entire system. This is useful when you need to have a single object
that is shared by different components of your application. For example, if you have a class that handles api connection management, you would only
need a single instance of that class to avoid concurrency issues and maintain data consistency.
Global Access: By using Singleton, you have global access to the single instance of the class from anywhere in your code.
This makes it easy to use and manage that object in different components and modules of your application.
Avoid unnecessary instantiation: By having a single instance, you avoid creating additional instances of the class each time 
it needs to be accessed. This is beneficial in terms of performance and resource consumption, especially when the instance creation 
is expensive in terms of time or memory.
The singleton pattern can be easily handled in spring boot using the autowired annotation and also by creating the bean in a configuration file.

proxy: The PokemonAPIProxy class acts as an intermediary between the client and the RESTful API.
This class implements the PokemonAPI interface and contains an instance of the concrete PokemonAPIImpl implementation.
In the getPokemons method, the proxy checks if the requested data is already cached. If so, they retrieve them from the cache and return them.
If the data is not cached, the proxy calls the concrete implementation to get the data from the RESTful API, caches it, and then returns it.
With this implementation, you can use the PokemonAPIProxy proxy to interact with the RESTful API, you will need a simpler interface and you will manage the output cache.
This pattern helps us make queries faster and add additional functionality such as validation of the offset and limit parameters.



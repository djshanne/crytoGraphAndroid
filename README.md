## This is a simple app in kotlin that covers all this points named below:

 1. Android Module usage (views, repository, domain, app, playground)
 2. Separate Responsibilities by using modules
 3. Dependency Injection
 4. Simple Unit Tests on every module
 5. Patters: Repository, MPV
 6. Architecture according to the requirements
 7. Every component intents to be suitable for Unit tests
 8. Usage of RXJava 2
 9. Error Handling
 10. Feedback Status
 11. Android Material Components 
 12. Uses this API and Shows it's results "https://api.blockchain.info"/charts/market-price?timespan=3days&format=json"
 13. To Compare https://www.blockchain.com/charts/market-price?timespan=3days



 ## Responsibilities and dependencies

 1. Views : it's job is to hold all our widgets, this way we can reuse the
    module as a library (aar) in other project.
    (No dependencies between modules, depends on the chart library implemented)

 2. Domain : it's job is to hold all the business logic, as this project doesn't has that much logic
    its just depending on the repository, but it could depend on other modules to complete it's job,
    now this module uses the repository to get the data from remote/local(not implemented) sources
    (Dependencies -Repository-)

 3. Repository : it's job is to request data on every sources we could have on this project like
    RemoteAPI, DB, SharedPreferences, files etc.
    (No dependencies between modules)

 4. App : This is the main module, it's job is to orchestrate the android app and it's modules,
    using a presentation layer that has all the Activities / Fragments implementing MPV making the
    presenter and the view suitable to test. It uses the domain module to execute / parse business logic and
    the View module to paint the data on the correct widget
    (Dependencies -Domain-Views-)
    
 5. Playgound : in this app-module we could have a catalog, it helps to build fast views using the views module,
    this way we can have a list of widgets with it's name and mocked data, but also we could have basic implementations of every module,
    and this way we could build some tests in this module.
    (Depedencies -Views-)


  Using modules makes easy to separate responsibilities and keep it that way during the development
  and also gives you the option to export them as an aar wish is very convenient if you are orient
  all your development as a library-component.









## Github Repository Fetcher

I have tried to showcase the use of various libaries and architecture in this test app. Even though this test app is too small to need all those libraries, I have used them. 
 
 The app follows MVP architecture with each view is an instance of `Scene` and each presenter is instance of `Presenter`. Each `Activtity` acts as the view in _MVP_.  All Presenters are injected in the activity via Dagger.
 
 The app is basically divided into three layer via package
- **app**: This is the view layer, where all the android components reside and there is no business logic
- **logic**: This is the business logic, no direct view interaction is done here.
- **core** : This layer sets the contract between *app* and *logic* layer.

#### NOTE :
I wasn't able to find public API for trending repositories for a topic. So, I have used the search API for topic and am showing the most starred repositories in descending order. Also I am using the APIs without authentication so it has lower rate limit, kindly keep that in mind while testing.

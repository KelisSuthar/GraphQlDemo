# Welcome To Graphql Demo #

**Steps To implement The GraphQL in Your Projects(In Kotlin)**

(https://www.apollographql.com/docs/kotlin)

[**Note - I have refer this site to do this project gives you best Exaple as well**] 

=>However Graphql server is not free one need to buy to make things work but some provide graphql Comtebility i personally like this one
(https://hasura.io/)
This will give you options to make graphQL Databse (To Some extent after it will charge you)

=>I use this site as a consol too which is free you need to add your base url in this and one can practice query on this platform
**Example - https://rickandmortyapi.com/graphql/** 




=> Create New android project name GraphQL Demo

=> Implment below dependancy into your poject in build.gradle file

    plugins {
        id("com.android.application")
        // ...
        id("com.apollographql.apollo3").version("3.2.1")
    }
    
    
    dependencies {
    // ...
    implementation("com.apollographql.apollo3:apollo-runtime:3.2.1")
    }
    
    apollo {
    packageName.set("com.example.rocketreserver")
    }


Let the project sync

=> Add Require Files in to your project 
  There are main two files a developer needs to add   
  
      1).graphqls /.json File for schema
      2).graphql file for graphql Queries

  **[Note-please Make sore that you have to make a directory for graphql in adnroid studio]**

  **-Open your Andoid stdio project in Project mode insted of Android Mode**

  **-Add A Directory Graphql at app->src->main->Graphql**

  **-Add All Files into this**
      
  You will require schema file which you will get from backedn developer or you can get from your GraphQL Consol 
  However ther is another way thorugh you can directly get file.
  For that you need to add this code to android studio terminal
  
    ./gradlew :app:downloadApolloSchema --endpoint='https://apollo-fullstack-tutorial.herokuapp.com/graphql(Your Base Url For)' --schema=app/src/main/graphql/com/example/rocketreserver/schema.graphqls(Your Path)

  At The same Path create A file Query.graphQL

   **[Note-You Can make one file for all query but i would recomend to make seperate file for each query for simple code utilization]**
   
   Rebuild your project 
   
   **[Note-I recommend to rebuild every time when you add any new query or update any existing query to your project]**
   
=>Initialize Apollo 
  Make a new file in your project name Apollo.kt (Name what ever you like)
  
  Initialize Apollo in that
  
    val apolloClient = ApolloClient.Builder()
        .serverUrl("https://rickandmortyapi.com/graphql")//Your Base url
        .build()
        
=>Api Calling in main Activity
    
    lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(LaunchListQuery()).execute()

            Log.d("LaunchList", "Success ${response.data}")
        }

**==============TroubleShoots I have faced during amaking this project=============**

=>For isue regarding lifecycle 
  If you afce any issue during API calling regarding lifecycleScope or lifecycle make sure you have lifecycle dependancy in your project 
  
      implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1").//update letest version accoding time
      
=>Api Run time Error
    If there is any run time error occure please check have you give **Internet** Permission to manifest file 
    
      <uses-permission android:name="android.permission.INTERNET"/>      


**Thankyou**

# Elastic-Search-Simple-spring-Boot-Application
Technologies Used:   Java, ElasticSearch
Framework :          Spring Boot with ElasticsearchRepository

Its a simple elastic search Spring Boot Application.
This application does not have authentication configuration of elastic search.
This will create the index named product in elastic search db.

______________________________________________________________________________________________________________

1. #Configuration# go to Elastic Search -> Config -> elasticsearch.yml and update below lines true to false:
      xpack.security.enabled: false

      xpack.security.enrollment.enabled: false

      xpack.security.http.ssl:
                enabled: false
  
      xpack.security.transport.ssl:
                enabled: false

  2. Start elastic search server.
  3. Go to application.properties file and modify below:
           spring.data.elasticsearch.cluster-name=naveen-test-cluster(replace this with your cluster)
           spring.data.elasticsearch.cluster-nodes=http://localhost:9200/
     
  5. Run spring boot application.

______________________________________________________________________________________________________________


Saving a Document:
     Method: Post 
     http://localhost:8080/product/save
      {
        "name": "ABC",
        "price": 100000.0,
        "description": "MacBook Pro",
        "manufacturer": "ABCDE"
    }


fetch all documents:
    Method:get
    http://localhost:8080/product/


delete document:
    Method: Delete
    http://localhost:8080/product/delete/{name}

Update:
    Method: Patch
    http://localhost:8080/product/1
    {
        "name": "ABCD",
        "price": 100000.0,
        "description": "MacBook Pro",
        "manufacturer": "ABC"
    }

 ______________________________________________________________________________________________________________

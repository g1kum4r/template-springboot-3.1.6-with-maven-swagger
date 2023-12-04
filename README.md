# Sringboot 3.* Maven Project With OpenAPI & Swagger UI


## OpenAPI
reference: [baeldung](https://www.baeldung.com/spring-rest-openapi-documentation)

find the OpenAPI descriptions at /v3/api-docs, which is the default path: http://localhost:8080/v3/api-docs

to change the path add/change the following property in properties file

`springdoc.api-docs.path=/api-docs`

The OpenAPI definitions are in JSON format by default. For yaml format, we can obtain the definitions at:
http://localhost:8080/api-docs.yaml

### Swagger UI
go to http://localhost:8080/swagger-ui/index.html for swagger ui documentation
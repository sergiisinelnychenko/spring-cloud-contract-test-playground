# Spring cloud contract playground

The simple demo project illustrating base approach for Contract Testing using *Spring Cloud Contract*
There are two services in the playground project - a producer of an API (Book Service) and a consumer of the API (Store Service).

Just perform project build and make sure tests pass

```
mvn clean install
```

Contract tests on the producer side are automatically generated out of the API contracts (written as groovy scripts).
REST endpoints studs are build by the Producer, and at a later time, used by the Consumer for its own tests

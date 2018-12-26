# Tecent Cloud SCF Java Events

### Event Models Supported
* APIGatewayProxyRequestEvent
* APIGatewayProxyResponseEvent
* CosEvent
* CMQEvent
* CKafkaEvent

### Package inclusion model
The dependencies section in the pom.xml file would like this

```xml
<dependencies>
    ...
    <dependency>
        <groupId>com.tencent.cloud</groupId>
        <artifactId>scf-java-events</artifactId>
        <version>0.0.1</version>
    </dependency>
    ...
</dependencies>
```
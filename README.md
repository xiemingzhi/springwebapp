# Spring JMS Example

Access on welcome controller [http://localhost:8000/springwebapp/welcome.htm](http://localhost:8000/springwebapp/welcome.htm) will send a JMS message to a queue.

# Setup ActiveMQ

* Download [activemq](http://activemq.apache.org/download.html)  
* Unzip  
* bin\activemq start  
* [admin console](http://localhost:8161/admin/) create queue `messageQueue1`

# Configure JMSTemplate

Edit springwebapp-servlet.xml

```xml
	<bean id="connectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
		<property name="brokerURL" value="tcp://localhost:61616" />
	</bean>
	<bean id="messageDestination" class="org.apache.activemq.command.ActiveMQQueue">
		<constructor-arg value="messageQueue1" />
	</bean>
```

# Run JavaProgram spring2jms-consumer

Run the App.java inside JavaProgram [spring2jms-consumer](https://github.com/xiemingzhi/javaprogram/tree/spring2jms-consumer) branch to consume the message.

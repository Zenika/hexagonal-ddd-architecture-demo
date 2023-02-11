<h1 align="center">Welcome to hexagonal-ddd-architecture-demo 👋</h1>
<p>
  <a href="./LICENSE" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
</p>

> A demo of a hexagonal architecture used with DDD

## Exercises

### 1. Domain service and aggregate

* Complete the `PlanningService`'s domain service `reserveQuay` method.
* Check your implementation running the `PlanningServiceTest`'s unit tests.
* Use the `OffloadingDurationCalculator` to calculate the offloading time.
* Use the `PlanningRepository` to get and persist the planning.
* Use the static method `PortInfrastructure.getQuaysId()` to get a list of the quays.
* Consider using the `DateRange` `intersects` method.

### 2. Application layer

* Complete the method `reserveQuay` of the application service `PlanningApplication`. This method takes a `ReserveQuay` command. Create the `ReserveQuay` command in the `com.shipco.planning.application` package.
* The method should call the planning service.
* Consider where to put the `Transactional` annotation either in the application service or in the domain service.
* Consider where to put the `Authorized` annotation either in the application service or in the domain service.
* Run the application service unit tests.

### 3. Repository

* Complete the `InMemoryPlanningRepository`.
* Run the repository unit tests.

### 4. External rest client

* Complete the `OffloadingEstimationDurationCalculatorRestClient`.
* Call the `estimate` GET endpoint. See the `OffloadingEstimationDurationController` class.

### 5. Domain event

* Use the `Event` interface to create a new event, `QuayReservedForVessel`.
* Add the `vesselId`, `quay`, and `timeSlot` to the event attributes.
* Change the `PlanningService` by publishing the event you created using the `EventPublisher`.

## Author

👤 **Zenika**

* Website: https://zenika.com/
* Github: [@Zenika](https://github.com/zenika)

## Show your support

Give a ⭐️ if this project helped you!

## 📝 License

Copyright © 2023 [Zenika](https://github.com/zenika).<br />
This project is [MIT](LICENSE) licensed.

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
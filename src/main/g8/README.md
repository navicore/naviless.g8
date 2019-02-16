$name$
-----

$description$

Build and run via:
```console
sbt assembly
java -jar target/scala-2.12/$name;format="Camel"$.jar
```

### Test and Code Coverage

```
sbt clean coverage test
sbt coverageReport
open target/scala-2.12/scoverage-report/index.html

### Code Stats

```console
sbt stats
```
### Check dependencies

```console
sbt dependencyUpdates
```

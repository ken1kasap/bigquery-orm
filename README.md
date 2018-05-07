## Requirements

* Java 8+
* Scala 2.12.5 (@see build.sbt)
* sbt 1.1.2 (@see project/build.properties)

## Set up to use this library.

* Set BigQuery Credentials.

```
$ export GOOGLE_APPLICATION_CREDENTIALS=/path/to/your_gcp_credential.json
```

* Set BigQuery Project ID to run test.

```
$ export BQ_PROJECT_ID=your_gcp_project_id
```

**CAUTION**

This is my experimental project to map SQL result into Scala case class.
Currently support only flat result, does not support nested structure.
